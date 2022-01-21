package org.springframework.samples.petclinic.care;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/care")
public class CareController {
    @Autowired
    private CareService careService;
    private static final String VIWE_CARE_CREAT_OR_UPDATE_FORM = "care/createOrUpdateProvidedCareForm.jsp";

 @GetMapping(path="/create")
    public String initCreationForm(ModelMap modelMap){
        String view = VIWE_CARE_CREAT_OR_UPDATE_FORM;
        modelMap.addAttribute("care", new Care());
        modelMap.addAttribute("careProvision", careService.getAllCaresProvided());
        return view;

    }

 @PostMapping(path="/create")
    public String processCreationForm(@Valid CareProvision care,BindingResult result, ModelMap modelMap) throws NonCompatibleCaresException, UnfeasibleCareException{
        String view = VIWE_CARE_CREAT_OR_UPDATE_FORM;
        if(result.hasErrors()){
        modelMap.addAttribute("careProvision", care);
        modelMap.addAttribute("careType", careService.getAllCaresProvided());
        return view;
    }else{
        careService.save(care);
        modelMap.addAttribute("message", "Care sucesfully save");
       
    }
    return "/";

    }
    
}

