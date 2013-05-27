package org.collatztrees;

import java.math.BigInteger;
import static org.collatztrees.Numbers.*;

public class TreeChecker {
    private final BigInteger first;
    private final BigInteger to;

    public TreeChecker(BigInteger from, BigInteger to) {
        while (!from.mod(eighteen).equals(eight)){
            from = from.add(BigInteger.ONE);
        }
        this.first = from;
        this.to = to;
    }

    public Node check(){
        for (BigInteger i = first; i.compareTo(to) < 0; i = i.add(eighteen)){
            Node node = new Node(i);
            if (node.containsKOver2()) {
                return node;
            }
             System.out.println(i);
        }
        return null;
    }
}