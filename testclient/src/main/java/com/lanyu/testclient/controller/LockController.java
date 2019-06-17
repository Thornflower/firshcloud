package com.lanyu.testclient.controller;

import com.lanyu.testclient.service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 锁
 *
 * @Author: 朱佳明
 * Date: 2019-03-01
 * Time: 4:09 PM
 */

@RestController
public class LockController {

    @Autowired
    private LockService lockService;

    @GetMapping("/orderLock/{productId}")
    public String lock(@PathVariable String productId){
        lockService.addLock(productId);
        return lockService.query(productId);
    }

}
