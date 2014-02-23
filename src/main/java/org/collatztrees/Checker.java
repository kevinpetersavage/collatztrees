package org.collatztrees;

import java.math.BigInteger;

public class Checker {
    public static void main(String[] args){
        BigInteger value = new BigInteger("3689348814741910321");
        BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
        BigInteger three = two.add(BigInteger.ONE);

        while (!value.equals(BigInteger.ONE)){
            System.out.println(value);
            if (value.mod(two).equals(BigInteger.ZERO)){
                value = value.divide(two);
            } else {
                value = value.multiply(three).add(BigInteger.ONE);
            }
        }
    }
}
