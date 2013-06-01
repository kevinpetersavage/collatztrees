package org.collatztrees;

import org.collatztrees.functions.*;

import java.util.concurrent.Callable;

import static org.collatztrees.Numbers.*;

public class TreeChecker implements Callable<Node> {
    private final long first;
    private final long to;

    private final Function u;
    private final Function d;
    private final Function div2;

    private final BinaryOp lessThan;
    private final BinaryOp equalTo;
    private final UnaryOp mod3Equals2;

    public TreeChecker(long from, long to) {
        while ((from % eighteen)!=eight){
            from += 1L;
        }
        this.first = from;
        this.to = to;

        this.u = new U();
        this.d = new D();
        this.div2 = new Div2();

        this.lessThan = new LessThan();
        this.equalTo = new LessThan();
        this.mod3Equals2 = new Mod3Equals2();
    }

    public Node call(){
        for (long i = first; i < to; i += eighteen){
            Node node = new Node(new long[]{0l, i}, u, d, lessThan, equalTo, mod3Equals2, div2);
            if (node.containsKOver2()) {
                return node;
            }
            if ((i%logLimit)<eighteen){System.out.println(i);}
        }
        return null;
    }
}