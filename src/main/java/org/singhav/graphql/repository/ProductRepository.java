package org.singhav.graphql.repository;

import org.singhav.graphql.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryIgnoreCase(String category);
}
