package org.collatztrees;

import java.math.BigInteger;

public class CheckLoadsOfTrees {
    public static final void main(String[] args){
        BigInteger from = new BigInteger("10").pow(18);
        BigInteger to = new BigInteger("10").pow(19);
        TreeChecker checker = new TreeChecker(from, to);
        Node failure = checker.check();
        System.out.println(failure);
    }
}
