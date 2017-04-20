package com.company;

import java.util.concurrent.*;

/**
 * Created by Gnadlinger on 06-Apr-17.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ExecutorService threadpool = Executors.newFixedThreadPool(3);
        Calculator calc = new Calculator();
        FutureTask<Double> futuretask = new FutureTask<Double>(calc);
        System.out.println("Start....");
        threadpool.submit(futuretask)

        System.out.println("submitted...");
        while (!futuretask.isDone()){
            System.out.println("sorry need more time");
            Thread.sleep(1);
        }
        if(futuretask.isDone()){
            System.out.println("finally finished");
            System.out.println("Pi is "+futuretask.get());
        }

    }
}
class Calculator implements Callable<Double> {
    @Override
    public Double call() throws Exception {
        double x = Math.atan(0.25);
        double y = Math.atan(0.00418410042);
        Thread.sleep(10);
        return 16*x-y;
    }
}


