package org.intellift.sol.example.minions.domain.repository;

import org.intellift.sol.domain.querydsl.mongodb.repository.QueryDslMongoRepository;
import org.intellift.sol.example.minions.domain.entity.system.Minion;
import org.springframework.stereotype.Repository;

/**
 * @author Chrisostomos Bakouras.
 */
@Repository
public interface MinionRepository extends QueryDslMongoRepository<Minion, String> {
}
