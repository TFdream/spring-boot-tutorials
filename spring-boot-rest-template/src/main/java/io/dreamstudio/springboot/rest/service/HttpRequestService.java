package io.dreamstudio.springboot.rest.service;

import io.dreamstudio.springboot.rest.model.User;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ricky Fung
 */
@Service
public class HttpRequestService {

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    //----------设置HTTP Header
    public void doRequestWithHeader(String uri) throws URISyntaxException {
        //请求参数对象
        User user = new User();

        // 1-Content-Type
        RequestEntity<User> requestEntity1 = RequestEntity
                .post(new URI(uri))
                .contentType(MediaType.APPLICATION_JSON)
                .body(user);

        // 2-Accept
        RequestEntity<User> requestEntity2 = RequestEntity
                .post(new URI(uri))
                .accept(MediaType.APPLICATION_JSON)
                .body(user);

        // 3-Other
        String base64Credentials = "";
        RequestEntity<User> requestEntity3 = RequestEntity
                .post(new URI(uri))
                .header("Authorization", "Basic " + base64Credentials)
                .body(user);

        //
        ResponseEntity<User> responseEntity = this.restTemplate.exchange(requestEntity3, User.class);
    }

    //----------发送POST请求
    public void postBody(String url) {
        Map<String, Object> param = new HashMap<>(4);
        param.put("userId", "15");
        param.put("memo", "test");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity requestParam = new HttpEntity(param, headers);
        String json = restTemplate.postForObject(url, requestParam, String.class);
        System.out.println(json);
    }

    public void doPost(String uri) throws URISyntaxException {
        //请求参数对象
        User user = new User();

        // 1-postForObject()
        User user1 = this.restTemplate.postForObject(uri, user, User.class);

        // 2-postForEntity()
        ResponseEntity<User> responseEntity1 = this.restTemplate.postForEntity(uri, user, User.class);

        // 3-exchange()
        RequestEntity<User> requestEntity = RequestEntity.post(new URI(uri)).body(user);
        ResponseEntity<User> responseEntity2 = this.restTemplate.exchange(requestEntity, User.class);

    }

    //----------发送GET请求
    public void doGet() {
        //通过Jackson JSON processing library直接将返回值绑定到对象
        String url = "http://localhost:8080/api/users/15";
        User user = restTemplate.getForObject(url, User.class);
        System.out.println(user);

        //直接返回json字符串
        String json = restTemplate.getForObject(url, String.class);
        System.out.println(json);
    }

    public void doGet(String uri) {
        // 1-getForObject()
        User user1 = this.restTemplate.getForObject(uri, User.class);

        // 2-getForEntity()
        ResponseEntity<User> responseEntity1 = this.restTemplate.getForEntity(uri, User.class);
        HttpStatus statusCode = responseEntity1.getStatusCode();
        HttpHeaders header = responseEntity1.getHeaders();
        User user2 = responseEntity1.getBody();

    }
}
