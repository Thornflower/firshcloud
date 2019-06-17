package com.lanyu.faceclient.controller;

import com.lanyu.faceclient.entity.ClassList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @Author: 朱佳明
 * Date: 2019-01-16
 * Time: 2:33 PM
 */

@RestController
public class OrderController {


    @RequestMapping("/msg")
    public String msg(){
        return "卧槽，你妈妈炸了";
    }


    @GetMapping("/getList")
    public List<ClassList> getList(String msg){
        if(!"123456".equals(msg)){
            return null;
        }
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        List<ClassList> list = new ArrayList<>();
        ClassList classList = new ClassList();
        classList.setAge("23");
        classList.setName("朱佳明");
        list.add(classList);
        return list;
    }

}
