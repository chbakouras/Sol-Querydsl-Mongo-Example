package org.intellift.sol.example.minions.service;

import org.intellift.sol.example.minions.domain.entity.system.Banana;
import org.intellift.sol.example.minions.domain.repository.BananaRepository;
import org.intellift.sol.domain.querydsl.repository.QueryDslRepository;
import org.intellift.sol.service.querydsl.QueryDslCrudService;
import org.springframework.stereotype.Service;

/**
 * @author Chrisostomos Bakouras.
 */
@Service
public class BananaServiceImpl implements QueryDslCrudService<Banana, String> {

    private final BananaRepository bananaRepository;

    public BananaServiceImpl(BananaRepository bananaRepository) {
        this.bananaRepository = bananaRepository;
    }

    @Override
    public Class<Banana> getEntityClass() {
        return Banana.class;
    }

    @Override
    public QueryDslRepository<Banana, String> getEntityRepository() {
        return bananaRepository;
    }
}
