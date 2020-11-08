package hu.webvalto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {
    private static Logger LOG = LoggerFactory
            .getLogger(SpringBootConsoleApplication.class);

    public static void main(String[] args) {
        LOG.info("Demo app elinditva");
        SpringApplication.run(SpringBootConsoleApplication.class, args);
        LOG.info("Demo app befejezodott");
    }

    @Override
    public void run(String... args) {
        LOG.info("VEGREHAJTAS : lefuttatom amit kapok...");

        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
    }
}
