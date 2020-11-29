package hu.webvalto.nyilatkozatok;

import hu.webvalto.config.LogConfiguration;
import hu.webvalto.config.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
@Import({WebConfiguration.class, LogConfiguration.class})
public class NyilatkozatokApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(NyilatkozatokApplication.class, args);

//        NyilatkozatRepository nyilatkozatRepository = context.getBean(NyilatkozatRepository.class);
//                MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);
//
//        // nyilatkozatRepository.deleteAll();
//        NyilatkozatV2 nyilatkozat = new NyilatkozatV2();
//        nyilatkozat.setId("3");
//        nyilatkozat.setAdozoEmber(1L);
//        nyilatkozat.setBevetel(1500L);
//        nyilatkozat.setKiadas(500L);
//        nyilatkozat.setLeiras("Adobevallas");
//        nyilatkozat.setTartalom("Adobevallas 2020");
//        nyilatkozat.setTemp("temp");
//
//        nyilatkozat = mongoTemplate.save(nyilatkozat);
//
//        System.out.println(""+mongoTemplate.findAll(NyilatkozatV2.class).toString());

    }

}
