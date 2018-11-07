package io.dreamstudio.springboot.rest.service;

import io.dreamstudio.springboot.rest.BaseSpringBootJUnitTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author Ricky Fung
 */
public class HttpRequestServiceTest extends BaseSpringBootJUnitTest {

    @Resource(name = "httpRequestService")
    private HttpRequestService httpRequestService;

    @Test
    @Ignore
    public void testGet() {
        httpRequestService.doGet();
    }
}
