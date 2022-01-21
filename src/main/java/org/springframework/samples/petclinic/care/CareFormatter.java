package org.springframework.samples.petclinic.care;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class CareFormatter implements Formatter<Care>{

    @Autowired
    CareService careService;

    @Override
    public String print(Care object, Locale locale) {
        String nombre = object.getName();
        return nombre;
    }

    @Override
    public Care parse(String text, Locale locale) throws ParseException {
        Care result = careService.getCare(text);
        if(result == null){
            throw new ParseException(text, 0);
        }else{
            return result;
        }
    }
}
    

