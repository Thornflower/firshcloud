package com.lanyu.testclient.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @Author: 朱佳明
 * Date: 2019-03-01
 * Time: 3:31 PM
 */
public interface LockService {




        void addLock(String productId);

        String query(String productId);

}
