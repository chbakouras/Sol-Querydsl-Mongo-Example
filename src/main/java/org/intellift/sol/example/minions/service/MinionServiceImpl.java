package org.intellift.sol.example.minions.service;

import org.intellift.sol.example.minions.domain.entity.system.Minion;
import org.intellift.sol.example.minions.domain.repository.MinionRepository;
import org.intellift.sol.domain.querydsl.repository.QueryDslRepository;
import org.intellift.sol.service.querydsl.QueryDslCrudService;
import org.springframework.stereotype.Service;

/**
 * @author Chrisostomos Bakouras.
 */
@Service
public class MinionServiceImpl implements QueryDslCrudService<Minion, String> {

    private final MinionRepository minionRepository;

    public MinionServiceImpl(MinionRepository minionRepository) {
        this.minionRepository = minionRepository;
    }

    @Override
    public Class<Minion> getEntityClass() {
        return Minion.class;
    }

    @Override
    public QueryDslRepository<Minion, String> getEntityRepository() {
        return minionRepository;
    }
}
