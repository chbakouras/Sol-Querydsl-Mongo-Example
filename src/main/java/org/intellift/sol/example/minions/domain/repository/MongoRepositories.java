//package org.intellift.sol.example.minions.domain.repository;
//
//import org.intellift.sol.domain.Identifiable;
//import org.intellift.sol.domain.querydsl.mongodb.repository.QueryDslMongoRepository;
//import org.springframework.data.repository.support.Repositories;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.io.Serializable;
//
///**
// * @author Chrisostomos Bakouras
// */
//@Component
//public class MongoRepositories {
//
//    private final WebApplicationContext appContext;
//
//    private final Repositories repositories;
//
//    public MongoRepositories(WebApplicationContext appContext, Repositories repositories) {
//        this.appContext = appContext;
//        this.repositories = new Repositories(appContext);
//    }
//
//    public <T extends Identifiable<ID>, ID extends Serializable> QueryDslMongoRepository getRepository(Class<T> entityClass) {
//        return (QueryDslMongoRepository) repositories.getRepositoryFor(entityClass);
//    }
//}
