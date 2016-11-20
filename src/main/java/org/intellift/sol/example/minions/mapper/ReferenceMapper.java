package org.intellift.sol.example.minions.mapper;

import org.intellift.sol.domain.Identifiable;
import org.intellift.sol.example.minions.domain.entity.AbstractEntity;
import org.intellift.sol.example.minions.dto.Reference;
import org.mapstruct.TargetType;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.QueryDslMongoRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Chrisostomos Bakouras.
 */
@Component
public class ReferenceMapper {

    private final MongoOperations mongoOperations;

    public ReferenceMapper(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public <T extends Identifiable<ID>, ID extends Serializable> T resolve(final Reference reference, @TargetType final Class<T> entityClass) {
        if (Objects.nonNull(reference)) {
//            final QueryDslMongoRepository repository = mongoRepositories.getRepository(entityClass);

            final MongoRepositoryFactory mongoRepositoryFactory = new MongoRepositoryFactory(mongoOperations);
            final QueryDslMongoRepository repository = mongoRepositoryFactory.getRepository(QueryDslMongoRepository.class);

            final T entity = (T) repository.findOne(reference.getId());

            final Optional<T> entityOptional = Optional.ofNullable(entity);

            return entityOptional.orElseThrow(() -> new RuntimeException(entityClass.getSimpleName() + " with id " + reference.getId() + " not found."));
        }

        return null;
    }

    public Reference toReference(final AbstractEntity entity) {
        if (Objects.nonNull(entity)) {
            final Reference reference = new Reference();

            reference.setId(entity.getId());

            return reference;
        }

        return null;
    }
}
