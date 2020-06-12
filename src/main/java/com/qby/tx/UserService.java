package com.qby.tx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qby
 * @date 2020/6/12 19:58
 */

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserDao userDao;

    @Transactional()
    public void insertUser() {
        userDao.insert();
        logger.info("插入成功。。。");

        int i = 10 / 0;
    }
}
