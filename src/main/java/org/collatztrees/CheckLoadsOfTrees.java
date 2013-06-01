package org.collatztrees;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.collatztrees.Numbers.pow;

public class CheckLoadsOfTrees {
    private static final long numberOfThreads = 4L;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long from = pow(10L, 1);
        long to = pow(10L, 8);
        long steps = (to-from)/numberOfThreads;

        ExecutorService executor = Executors.newFixedThreadPool((int)numberOfThreads);

        List<Future<Node>> futures = new ArrayList<Future<Node>>();
        for (int i = 0; i < numberOfThreads; i++){
            long stepFrom = (steps*i)+from;
            long stepTo = (steps*(i+1))+from;

            futures.add(executor.submit(new TreeChecker(stepFrom, stepTo)));
        }

        for (Future<Node> future : futures) {
            System.out.println(future.get());
        }
        System.exit(1);
    }
}
