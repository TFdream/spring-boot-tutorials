package io.dreamstudio.springboot.rest.configuration;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.net.URI;

/**
 * 自定义异常处理器
 * @author Ricky Fung
 */
public class CustomErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) {

    }
}
