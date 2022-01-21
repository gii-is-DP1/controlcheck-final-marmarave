package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CareProvisionRepository extends CrudRepository<CareProvision, Integer>{
    List<CareProvision> findAll();        
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);
	
    @Query("SELECT c From Care c" )
    List<Care> findAllCares();
    
    @Query("SELECT c From Care c WHERE c.name=?1" )
    List<Care> findCompatibleCares(String petTypeName);
    
    @Query("SELECT c From Care c WHERE c.name=?1" )
    Care findCareByName(String name);
    
    // @Query("SELECT c From CareProvision c WHERE c.visit_id=?1" )
    // List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
}
