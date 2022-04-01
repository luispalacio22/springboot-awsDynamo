package test.aws.com.TestAWS.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import test.aws.com.TestAWS.model.Persona;
import test.aws.com.TestAWS.model.Response;

@Service
public class PersonaServiceImpl implements PersonaService{
    private AmazonDynamoDB setUpDynamoDB;

    public PersonaServiceImpl(AmazonDynamoDB setUpDynamoDB) {
        this.setUpDynamoDB = setUpDynamoDB;
    }

    @Override
    public String save(Persona persona) {
        DynamoDBMapper dbMapper = new DynamoDBMapper(setUpDynamoDB);
        dbMapper.save(persona);
        Gson response = new Gson();
        return response.toJson(new Response("ok"));
    }

    @Override
    public String getPerson(Persona persona) {
        DynamoDBMapper dbMapper = new DynamoDBMapper(setUpDynamoDB);
        Gson response = new Gson();
        return response.toJson(dbMapper.load(Persona.class,persona.getId()));
    }

    @Override
    public String delete(Persona persona) {
        DynamoDBMapper dbMapper = new DynamoDBMapper(setUpDynamoDB);
        Persona persona1 = dbMapper.load(Persona.class,persona.getId());
        dbMapper.delete(persona1);
        Gson response = new Gson();
        return response.toJson(new Response("ok"));
    }
}
