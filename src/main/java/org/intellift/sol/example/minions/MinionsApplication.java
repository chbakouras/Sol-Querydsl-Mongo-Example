package org.intellift.sol.example.minions;

import org.intellift.sol.example.minions.domain.entity.system.Banana;
import org.intellift.sol.example.minions.domain.entity.system.Minion;
import org.intellift.sol.example.minions.domain.repository.BananaRepository;
import org.intellift.sol.example.minions.domain.repository.MinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableMongoRepositories
public class MinionsApplication implements CommandLineRunner {

    private final MinionRepository minionRepository;

    private final BananaRepository bananaRepository;

    @Autowired
    public MinionsApplication(MinionRepository minionRepository, BananaRepository bananaRepository) {
        this.minionRepository = minionRepository;
        this.bananaRepository = bananaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MinionsApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Minion dave = new Minion();
        dave.setName("Dave");
        dave.setDespicability(25);

        final Minion savedMinion = minionRepository.save(dave);

        for (Integer i = 0; i < 100; i++) {
            Banana banana = new Banana();
            banana.setJuicy(200D);

            bananaRepository.save(banana);
        }
    }
}
