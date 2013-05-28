package org.collatztrees;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CheckLoadsOfTrees {
    private static final int numberOfThreads = 4;

    public static final void main(String[] args) throws ExecutionException, InterruptedException {
        BigInteger from = new BigInteger("10").pow(8);
        BigInteger to = new BigInteger("10").pow(9);
        BigInteger steps = to.subtract(from).divide(new BigInteger(String.valueOf(numberOfThreads)));

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        List<Future<Node>> futures = new ArrayList<Future<Node>>();
        for (int i = 0; i < numberOfThreads; i++){
            BigInteger stepFrom = steps.multiply(new BigInteger(String.valueOf(i))).add(from);
            BigInteger stepTo = steps.multiply(new BigInteger(String.valueOf(i+1))).add(from);

            futures.add(executor.submit(new TreeChecker(stepFrom, stepTo)));
        }

        for (Future<Node> future : futures) {
            System.out.println(future.get());
        }
    }
}
