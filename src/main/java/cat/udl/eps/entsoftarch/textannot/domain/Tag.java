package cat.udl.eps.entsoftarch.textannot.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Tag extends UriEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)

    private TagHierarchy definedIn;

    public Tag(String name) {
        this.setName(name);
    }

    public Tag(String name, TagHierarchy definedIn){
        this.setDefinedIn(definedIn);
        this.setName(name);
    }
}
