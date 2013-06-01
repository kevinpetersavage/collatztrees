package org.collatztrees;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.collatztrees.Numbers.pow;

public class CheckLoadsOfTrees {
    private static final BigInteger numberOfThreads = new BigInteger("4");

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BigInteger from = new BigInteger("10").pow(21);
        BigInteger to = new BigInteger("10").pow(22);
        BigInteger steps = (to.subtract(from)).divide(numberOfThreads);

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads.intValue());

        List<Future<Node>> futures = new ArrayList<Future<Node>>();
        for (BigInteger i = BigInteger.ZERO; i.compareTo(numberOfThreads)<0; i = i.add(BigInteger.ONE)){
            BigInteger stepFrom = (steps.multiply(i)).add(from);
            BigInteger stepTo = (steps.multiply(i.add(BigInteger.ONE))).add(from);

            futures.add(executor.submit(new TreeChecker(stepFrom, stepTo)));
        }

        for (Future<Node> future : futures) {
            System.out.println(future.get());
        }
        System.exit(1);
    }
}
