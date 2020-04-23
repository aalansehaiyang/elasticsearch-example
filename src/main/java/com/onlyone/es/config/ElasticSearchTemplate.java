//package com.onlyone.es.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpHost;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import java.io.IOException;
//
//@Slf4j
//@Component
//public class ElasticSearchTemplate {
//    @Value("${elasticsearch.ip}")
//    private String ip;
//    @Value("${elasticsearch.port}")
//    private int port;
//    @Value("${elasticsearch.user}")
//    private String user;
//    @Value("${elasticsearch.password}")
//    private String password;
//    private RestHighLevelClient client;
//    @Value("${elasticsearch.connectTimeout}")
//    private int connectTimeout;
//    @Value("${elasticsearch.socketTimeout}")
//    private int socketTimeout;
//    @Value("${elasticsearch.connectionRequestTimeout}")
//    private int connectionRequestTimeout;
//    @Value("${elasticsearch.maxConnTotal}")
//    private int maxConnTotal;
//    @Value("${elasticsearch.maxConnPerRoute}")
//    private int maxConnPerRoute;
//    @Value("${elasticsearch.maxRetryTimeoutMillis}")
//    private int maxRetryTimeoutMillis;
//
//
//    /**
//     * 初始化RestHighLevelClient
//     */
//    @PostConstruct
//    public void init() {
//        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(user, password));
//        //配置化
//        RestClientBuilder builder =
//                RestClient.builder(new HttpHost(ip, port, "http")).setRequestConfigCallback(requestConfigBuilder -> {
//                    requestConfigBuilder.setConnectTimeout(connectTimeout);
//                    requestConfigBuilder.setSocketTimeout(socketTimeout);
//                    requestConfigBuilder.setConnectionRequestTimeout(connectionRequestTimeout);
//                    return requestConfigBuilder;
//                }).setHttpClientConfigCallback(httpClientBuilder -> {
//                    httpClientBuilder.setMaxConnTotal(maxConnTotal);
//                    httpClientBuilder.setMaxConnPerRoute(maxConnPerRoute);
//                    httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
//                    return httpClientBuilder;
//                }).setMaxRetryTimeoutMillis(maxRetryTimeoutMillis);
//
//        client = new RestHighLevelClient(builder);
//    }
//
//    public RestHighLevelClient getClient() {
//        return client;
//    }
//
//
//    @PreDestroy
//    public void destroy() throws IOException {
//        if (null != client) {
//            client.close();
//        }
//    }
//
//}
