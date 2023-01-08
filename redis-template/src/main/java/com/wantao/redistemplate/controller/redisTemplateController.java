package com.wantao.redistemplate.controller;


import com.wantao.redistemplate.redis.RedisService;
import com.wantao.redistemplate.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class redisTemplateController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/set")
    @ResponseBody
    public Result set(){
        redisService.set("boyfriend","selenium");
       return Result.success();
    }

    @GetMapping("/get")
    @ResponseBody
    public Result get(){
        String str=redisService.get("boyfriend");
        return Result.success().add("boyfriend",str);
    }
}
