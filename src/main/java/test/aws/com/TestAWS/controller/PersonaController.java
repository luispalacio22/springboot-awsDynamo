package test.aws.com.TestAWS.controller;

import org.springframework.web.bind.annotation.*;
import test.aws.com.TestAWS.model.Persona;
import test.aws.com.TestAWS.service.PersonaService;

@RestController
public class PersonaController {
    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping(value="/dynamodb/save",produces={"application/json"})
    public String savePerson(@RequestBody Persona persona){
        return personaService.save(persona);
    }

    @GetMapping(value = "/dynamodb/getPerson",produces = {"application/json"})
    public String getPerson(@RequestBody Persona persona){
        return personaService.getPerson(persona);

    }

    @DeleteMapping(value = "/dynamodb/delete",produces = {"application/json"})
    public String delete(@RequestBody Persona persona){
        return personaService.delete(persona);
    }
}
