package com.ryz.sh.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServer {
    @Async
    public void doAsync(String name){
        System.out.println("异步方法中的线程名称"+Thread.currentThread().getName());
        System.out.println("开始执行异步方法"+name);
        try{
            Thread.sleep(5*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("异步方法执行完成");
    }
}
