package com.onlyone.es.config;


import lombok.Getter;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearchConfig {

    private final RestHighLevelClient client;

    @Autowired
    public ElasticSearchConfig(RestHighLevelClient client) {
        this.client = client;
    }

    @Bean
    ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client);
    }

}
