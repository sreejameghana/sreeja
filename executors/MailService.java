package com.codewithmosh.executors;

import java.util.concurrent.CompletableFuture;

public class MailService {
    public void send(){
        LongTask.simulate();// simulate the delay
        System.out.println("mail was sent.");

    }
 public CompletableFuture<Void> sendAsync(){

        return CompletableFuture.runAsync(()->send());
 }

   // reimplement this method in the asyn fashion
}
