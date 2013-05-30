package org.collatztrees;

import java.util.concurrent.Callable;

import static org.collatztrees.Numbers.*;

public class TreeChecker implements Callable<Node> {
    private final long first;
    private final long to;

    public TreeChecker(long from, long to) {
        while ((from % eighteen)!=eight){
            from += 1L;
        }
        this.first = from;
        this.to = to;
    }

    public Node call(){
        for (long i = first; i < to; i += eighteen){
            Node node = new Node(i);
            if (node.containsKOver2()) {
                return node;
            }
            if ((i%logLimit)<eighteen){System.out.println(i);}
        }
        return null;
    }
}