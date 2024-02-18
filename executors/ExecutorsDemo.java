package com.codewithmosh.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
// have 1000 tasks create too many threads run out of memory not needed with this approach
//we submit tasks to the ecexutor through this thread pool and this pool will assign tasks to worker threads
public class ExecutorsDemo {
    public static void show(){

      var executor =  Executors.newFixedThreadPool(2);
try {// put the task here
   var future =  executor.submit(() -> {//submit takes callable object that is represented by the lambda
      //  System.out.println(Thread.currentThread().getName());
       LongTask.simulate();// simulating an operation that is going to take three seconds; like call twitter api to get latest tweetsfor user
       //eventually task will return value which is one
       // so when we call the submit method it will immediately get the future object will not wait // three secondsbecause os sleep//
       //with the future object we can get the result of the task operation

       //submit method is going to return immediately so we can do some more work
       return 1; // automatically jvm matches this for the call () that returns value
    });
    System.out.println("do more work ");
    try {
        var result = future.get();
        System.out.println(result);//get method will block the current thread and make it wait untill the result of thus operation is ready eventually it is going to return some value eventually it is going to return some value// at some point we really need the result of this operation that is when we are presenting it here
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
//    } catch (ExecutionException e) {
//        e.printStackTrace();
    }

}
    finally

{// with no interrruptions we shut down the executor and release it from the memory
    executor.shutdown();
        }

    }

}
