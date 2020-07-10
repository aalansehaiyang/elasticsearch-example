package com.onlyone.es.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "ecommerce", type = "product", shards = 2)
public class ProductModel {

    @Id
    private Long id;
    private Long productId;
    private String name;
    private String desc;
    private Long price;
    private String producer;
    private List<String> tags;
    private List<Long> shopId;
    private String city;
}
