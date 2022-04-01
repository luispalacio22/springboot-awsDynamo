package test.aws.com.TestAWS.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigConnectionAwsServices {
    @Bean
    public AmazonDynamoDB setUpDynamoDB(){
        AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAQHAG2DAG7EDSGVPV","jmMpyXZPJS+eIFkEUyugmt2KUFk7zHkIP51/4adM");
        return AmazonDynamoDBClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(Regions.US_EAST_1).build();
    }
}
