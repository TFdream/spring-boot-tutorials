package io.dreamstudio.springboot.cache.service;

import io.dreamstudio.springboot.cache.BaseSpringBootJUnitTest;
import io.dreamstudio.springboot.cache.model.Product;
import io.dreamstudio.springboot.cache.util.JsonUtils;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Ricky Fung
 */
public class ProductServiceTest extends BaseSpringBootJUnitTest {

    @Resource(name = "productService")
    private ProductService productService;

    @Test
    @Ignore
    public void testSaveOrUpdate() {
        Product product = new Product();
        product.setName("iPhone X");
        product.setPrice(Double.valueOf(0.1d));
        product.setTags(Arrays.asList("Apple"));
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        productService.saveOrUpdate(product);

        System.out.println(JsonUtils.toJson(product));
    }

    @Test
    @Ignore
    public void testGet() {
        Long id = 1L;
        Product product = productService.get(id);
        System.out.println(JsonUtils.toJson(product));
    }

    @Test
    @Ignore
    public void testDelete() {
        boolean success = productService.delete(1L);
        System.out.println(success);
    }

}
