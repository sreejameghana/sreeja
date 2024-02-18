package com.codewithmosh.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static java.lang.Integer.parseInt;

public class CompletableFuturesDemo {



public static void show() {
// when calling a remote service we want to have the time limits of how long we want to wait to get a response

// create a completable future

//   var first =  CompletableFuture.supplyAsync(()->{
//        LongTask.simulate();
//        return 1;
//    });
//
//
//    try {
//        var result = first.orTimeout(1, TimeUnit.SECONDS)
//        .get();
//        System.out.println(result);
//    } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//    } catch (ExecutionException e) {
//        throw new RuntimeException(e);
//    }



    // better approach to recover with the default value instead calling ortimeout

// oncomplete will return a completable future that will complete after one sec
    var first =  CompletableFuture.supplyAsync(()->{
        LongTask.simulate();
        return 1;
    });


    try {
        var result = first
                .completeOnTimeout(1, 1,TimeUnit.SECONDS)
                .get();
        System.out.println(result);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    } catch (ExecutionException e) {
        throw new RuntimeException(e);
    }

}



}
