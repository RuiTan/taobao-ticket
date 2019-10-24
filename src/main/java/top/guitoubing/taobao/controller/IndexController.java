package top.guitoubing.taobao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @ResponseBody
    @GetMapping(value = {"index",""})
    public String index(){
        return "HelloWorld!";
    }

}
