package com.kncm.accommodationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityRepository<T> extends MongoRepository<T, Long> {
    default T findOne(Long id) {
        return findById(id).orElse(null);
    }
}
