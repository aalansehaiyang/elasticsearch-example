//package com.boot;
//
//import com.alibaba.fastjson.JSON;
//import com.onlyone.es.Application;
//import com.onlyone.es.config.ElasticSearchTemplate;
//import org.elasticsearch.action.search.SearchRequest;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.common.unit.TimeValue;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author onlyone
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class Ch1ApplicationTest {
//
//
//    @Autowired
//    private ElasticSearchTemplate elasticSearchTemplate;
//
//    @Test
//    public void testQuery() {
//        SearchRequest searchRequest = new SearchRequest("ecommerce");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
//        // name
//        queryBuilder.must().add(QueryBuilders.matchQuery("name", "苹果"));
//
//        //shopId
//        List<Long> shopIds = new ArrayList<>();
//        shopIds.add(10L);
//        shopIds.add(11L);
//        shopIds.add(13L);
////        queryBuilder.must().add(QueryBuilders.termsQuery("shopId", shopIds));
//
//        searchSourceBuilder.from(0);
//        searchSourceBuilder.size(10);
//        searchSourceBuilder.query(queryBuilder);
//
//        //缓存时间，1分钟
//        searchRequest.scroll(TimeValue.timeValueMinutes(1));
//        searchRequest.source(searchSourceBuilder);
//        SearchResponse searchResponse = null;
//        try {
//            searchResponse = elasticSearchTemplate.getClient().search(searchRequest, RequestOptions.DEFAULT);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        List<String> result = new ArrayList<>();
//        for (SearchHit hit : searchResponse.getHits()) {
//            String s = hit.getSourceAsString();
//            result.add(s);
//        }
////        System.out.println(JSON.toJSON(searchResponse));
//        System.out.println(result);
//
//
//    }
//
//}
