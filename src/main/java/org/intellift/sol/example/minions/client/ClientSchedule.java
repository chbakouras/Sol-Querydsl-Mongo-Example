package org.intellift.sol.example.minions.client;

import org.apache.log4j.Logger;
import org.intellift.sol.example.minions.MinionsApplication;
import org.intellift.sol.example.minions.domain.repository.BananaRepository;
import org.intellift.sol.example.minions.dto.system.BananaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author Chrisostomos Bakouras
 */

@Component
public class ClientSchedule {

    private static final Logger logger = Logger.getLogger(ClientSchedule.class);

    private final BananaRepository bananaRepository;

    private final BananaClient bananaClient;

    private BananaDto firstBanana;

    @Autowired
    public ClientSchedule(BananaRepository bananaRepository, BananaClient bananaClient) {
        this.bananaRepository = bananaRepository;
        this.bananaClient = bananaClient;
    }

    public static void main(String... args) {
        SpringApplication.run(MinionsApplication.class, args);
    }

    @Scheduled(fixedRate = 10000)
    @Transactional
    public void consumeNotBeenSent() {
        bananaClient.getAll()
                .onSuccess(getAllResponse -> {
                    logger.info("GetAll Response status: " + getAllResponse.getStatusCodeValue());
                    final BananaDto bananaDto = getAllResponse.getBody().getContent().stream().findFirst().get();

                    bananaClient.getOne(bananaDto.getId())
                            .onSuccess(getOneResponse -> {
                                logger.info("GetOne Response status: " + getOneResponse.getStatusCodeValue());

                                BananaDto newBananaDto = new BananaDto();
                                newBananaDto.setJuicy(10D);

                                bananaClient.create(newBananaDto)
                                        .onSuccess(postResponse -> {
                                            final BananaDto createdBanana = postResponse.getBody();
                                            logger.info("Post Response status: " + postResponse.getStatusCodeValue());
                                            logger.info("Juicy: " + createdBanana.getJuicy());

                                            bananaClient.update(createdBanana)
                                                    .onSuccess(putResponse -> {
                                                        final BananaDto updatedBanana = putResponse.getBody();
                                                        logger.info("Put Response status: " + putResponse.getStatusCodeValue());
                                                        logger.info("Juicy: " + updatedBanana.getJuicy());

                                                        bananaClient.delete(updatedBanana.getId())
                                                                .onSuccess(deleteResponse -> {
                                                                    logger.info("Delete Response status: " + deleteResponse.getStatusCodeValue());
                                                                })
                                                                .onFailure(e -> {
                                                                    logger.error("Delete FAILED: " + e.getMessage());
                                                                    throw new RuntimeException(e);
                                                                });
                                                    })
                                                    .onFailure(e -> {
                                                        logger.error("Put FAILED: " + e.getMessage());
                                                        throw new RuntimeException(e);
                                                    });
                                        })
                                        .onFailure(e -> {
                                            logger.error("Post FAILED: " + e.getMessage());
                                            throw new RuntimeException(e);
                                        });
                            })
                            .onFailure(e -> {
                                logger.error("GetOne FAILED: " + e.getMessage());
                                throw new RuntimeException(e);
                            });
                })
                .onFailure(e -> {
                    logger.error("GetAll FAILED: " + e.getMessage());
                    throw new RuntimeException(e);
                });
    }
}
