package com.onlyone.es.repository;

import com.onlyone.es.model.ProductModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<ProductModel, Long> {

}
