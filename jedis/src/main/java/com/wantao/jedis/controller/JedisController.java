package com.wantao.jedis.controller;

import com.wantao.jedis.redis.RedisService;
import com.wantao.jedis.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JedisController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/set")
    @ResponseBody
    public Result set(){
        redisService.set("girlfriend","sakura");
       return Result.success();
    }

    @GetMapping("/get")
    @ResponseBody
    public Result get(){
        String str=redisService.get("girlfriend",String.class);
        return Result.success().add("girlfriend",str);
    }
}
