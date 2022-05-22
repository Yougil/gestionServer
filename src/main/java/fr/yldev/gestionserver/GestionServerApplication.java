package fr.yldev.gestionserver;

import fr.yldev.gestionserver.model.Server;
import fr.yldev.gestionserver.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static fr.yldev.gestionserver.enumeration.Status.SERVER_DOWN;
import static fr.yldev.gestionserver.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class GestionServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionServerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServerRepo serverRepo) {
        return args -> {
            serverRepo.save(new Server(null, "192.168.1.160", "Ubuntu", "1 To", "PC",
                        "http://localhost:8080/server/image/server1.png", SERVER_UP));
            serverRepo.save(new Server(null, "192.165.1.160", "Kali", "500 Go", "Tower",
                    "http://localhost:8080/server/image/server2.png", SERVER_UP));
            serverRepo.save(new Server(null, "126.138.1.160", "Windows", "5 To", "PC",
                    "http://localhost:8080/server/image/server3.png", SERVER_UP));
            serverRepo.save(new Server(null, "32.168.1.160", "Debian", "100 Go", "Web server",
                    "http://localhost:8080/server/image/server4.png", SERVER_DOWN));
        };
    }

}
