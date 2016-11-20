package org.intellift.sol.example.minions.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.AsyncClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.web.client.AsyncRestOperations;
import org.springframework.web.client.AsyncRestTemplate;

/**
 * @author Chrisostomos Bakouras
 */
@Configuration
public class AsyncRestOperationConfiguration {

    @Bean
    @ConditionalOnMissingBean(AsyncRestOperations.class)
    public AsyncRestOperations asyncRestOperations() {
        final RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(60000)
                .setConnectTimeout(60000)
                .setSocketTimeout(60000)
                .build();

        final CloseableHttpAsyncClient asyncClient = HttpAsyncClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setMaxConnTotal(300)
                .build();

        final AsyncClientHttpRequestFactory requestFactory = new HttpComponentsAsyncClientHttpRequestFactory(asyncClient);

        return new AsyncRestTemplate(requestFactory);
    }
}
