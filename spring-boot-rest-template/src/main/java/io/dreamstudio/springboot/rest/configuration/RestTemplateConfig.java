package io.dreamstudio.springboot.rest.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * RestTemplate配置
 * @author Ricky Fung
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .connectTimeout(3, TimeUnit.SECONDS)
                .build();
        return client;
    }

    @Bean
    public OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory(OkHttpClient okHttpClient) {
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory(okHttpClient);
        return factory;
    }

    @Bean
    public RestTemplate restTemplate(OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory) {
        RestTemplate restTemplate = new RestTemplate(okHttp3ClientHttpRequestFactory);
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        //1.解决中文乱码
        messageConverters.set(1, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        //2.设置下异常处理器
        restTemplate.setErrorHandler(new CustomErrorHandler());
        return restTemplate;
    }
}
