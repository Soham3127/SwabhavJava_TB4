package com.aurionpro.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException  {

        ExecutorService service = Executors.newSingleThreadExecutor(); 

        for (int i = 0; i <= 5; i++) {
            Callable<String> task = () -> {
                Thread.sleep(1000); 
                return "Result from thread: " + Thread.currentThread().getName();
            };

            Future<String> result = service.submit(task); // submit() returns a Future

            System.out.println(result.get()); 
        }

        service.shutdown(); 
    }
}
