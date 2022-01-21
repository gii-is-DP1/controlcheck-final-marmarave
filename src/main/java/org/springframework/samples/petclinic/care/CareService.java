package org.springframework.samples.petclinic.care;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CareService {    

    @Autowired
    CareProvisionRepository careProvisionRepository;

    public List<Care> getAllCares(){
        return careProvisionRepository.findAllCares();
    }

    public List<Care> getAllCompatibleCares(String petTypeName){
        return careProvisionRepository.findCompatibleCares(petTypeName);
    }

    public Care getCare(String careName) {
        return careProvisionRepository.findCareByName(careName);
    }

    
    public CareProvision save(CareProvision p) throws NonCompatibleCaresException, UnfeasibleCareException {
        return careProvisionRepository.save(p);   
    }

    public List<CareProvision> getAllCaresProvided(){
        return null;
    }

    public List<CareProvision> getCaresProvided(Integer visitId){
        return null;

    }
    
}
