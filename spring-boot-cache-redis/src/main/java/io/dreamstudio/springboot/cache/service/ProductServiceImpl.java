package io.dreamstudio.springboot.cache.service;

import io.dreamstudio.springboot.cache.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Ricky Fung
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ConcurrentHashMap<Long, Product> database = new ConcurrentHashMap<>(32);
    private AtomicLong counter = new AtomicLong(1);

    @CachePut(value = "product", key = "#product.id")
    @Override
    public Product saveOrUpdate(Product product) {
        logger.info("进入 saveOrUpdate 方法");
        if (product.getId()==null) {
            product.setId(counter.getAndIncrement());
        }
        database.put(product.getId(), product);
        return product;
    }

    @Cacheable(value = "product", key = "#id")
    @Override
    public Product get(Long id) {
        logger.info("从DB中查询产品信息id:{}", id);
        return simulateSlowService(id);
    }

    @CacheEvict(value = "product", key = "#id")
    @Override
    public boolean delete(Long id) {
        logger.info("进入 saveOrUpdate 方法");
        return database.remove(id)!=null;
    }

    // Don't do this at home
    private Product simulateSlowService(Long id) {
        try {
            long time = 3000L;
            Thread.sleep(time);
            return database.get(id);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
