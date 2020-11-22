package hu.webvalto.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClientFactory;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

@Configuration
public class MongoConfiguration {

//    @Bean
//    public MongoClient mongoClient() {
//        return MongoClients.create("mongodb://localhost:27018");
//    }

    @Bean
    public MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongoClientFactory = new MongoClientFactoryBean();
        mongoClientFactory.setHost("localhost");
        mongoClientFactory.setPort(27019);
        return mongoClientFactory;
    }
}
