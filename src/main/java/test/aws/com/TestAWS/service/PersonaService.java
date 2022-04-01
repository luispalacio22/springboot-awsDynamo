package test.aws.com.TestAWS.service;

import test.aws.com.TestAWS.model.Persona;

public interface PersonaService {
    String save(Persona persona);

    String getPerson(Persona persona);

    String delete(Persona persona);
}
