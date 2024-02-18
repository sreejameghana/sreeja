package com.codewithmosh.executors;

public class LongTask {
// overriding simulate method to create a delay speerately for seperate website queries
    public static void simulate(){

        //put cuurrent thread to sleep
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void simulate(int delay){

        //put cuurrent thread to sleep
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
