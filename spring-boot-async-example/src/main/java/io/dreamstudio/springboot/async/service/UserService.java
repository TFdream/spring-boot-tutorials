package io.dreamstudio.springboot.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author Ricky Fung
 */
@Service
public class UserService {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Async
    public Future<String> getUserById(Long userId) {
        LOG.info("查询用户信息开始, userId:{}", userId);
        sleep(2000);
        return new AsyncResult<String>(String.format("userId:%s", userId));
    }

    @Async
    public void doNoReturn() {
        LOG.info("提交任务开始");
        sleep(3000);
        LOG.info("提交任务结束");
    }

    private void sleep(long millis) {
        try {
            // 这个方法执行需要三秒
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            LOG.error("", e);
        }
    }
}
