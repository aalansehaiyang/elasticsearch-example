package com.boot;


import com.alibaba.fastjson.JSON;
import com.onlyone.es.Application;
import com.onlyone.es.model.ProductModel;
import com.onlyone.es.repository.ProductRepository;
import org.assertj.core.util.Lists;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Ch2ApplicationTest {


    @Resource
    private ProductRepository productRepository;


    @Test
    public void testAdd() {
        ProductModel product1 = ProductModel.builder()
                .id(1L)
                .name("苹果手机")
                .desc("可以打电话、发短信、玩游戏")
                .price(6000L)
                .producer("美国")
                .tags(Lists.list("手机", "apple"))
                .shopId(Lists.list(10L, 11L, 12L))
                .build();
        product1 = productRepository.save(product1);

        ProductModel product2 = ProductModel.builder()
                .id(2L)
                .name("苹果")
                .desc("产地烟台，有红又大的红富士苹果")
                .price(10L)
                .producer("烟台")
                .tags(Lists.list("苹果", "水果"))
                .shopId(Lists.list(10L))
                .build();
        product2 = productRepository.save(product2);

        ProductModel product3 = ProductModel.builder()
                .id(3L)
                .name("小米手机")
                .desc("小米10系列，新一代LPDDR5内存，突破5G性能极限；90Hz流速屏，对称式立体声，突破5G影音极限")
                .price(3000L)
                .producer("中国")
                .tags(Lists.list("手机"))
                .shopId(Lists.list(10L, 11L, 12L, 13L))
                .build();
        product3 = productRepository.save(product3);
    }


    @Test
    public void testQueryByName() {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.matchQuery("name", "苹果"));
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder);
        List<ProductModel> activityDocumentList = productRepository.search(searchQueryBuilder.build()).getContent();
        System.out.println(JSON.toJSONString(activityDocumentList));
    }

    @Test
    public void testQueryByShopIds() {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        List<Long> shopIds = Lists.list(11L, 13L);
        boolQueryBuilder.must(QueryBuilders.termsQuery("shopId", shopIds));
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder);
        List<ProductModel> activityDocumentList = productRepository.search(searchQueryBuilder.build()).getContent();
        System.out.println(JSON.toJSONString(activityDocumentList));
    }


}