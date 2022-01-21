package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Care extends BaseEntity {
    
    @NotNull
    @Column(name = "name", unique = true)
    @Size(min =5, max=30)
    private String name;

    @NotEmpty
    private String description;
    
    
    @ManyToMany(cascade = CascadeType.ALL)
    @NotEmpty
    @JoinColumn(name = "pet_type_id")
    Set<PetType> compatiblePetTypes;
}
