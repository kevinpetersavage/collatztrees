package org.collatztrees;

import org.collatztrees.functions.*;

import java.math.BigInteger;
import java.util.concurrent.Callable;

import static org.collatztrees.Numbers.*;

public class TreeChecker implements Callable<Node> {
    private final long[] first;
    private final long[] to;

    private final Function u;
    private final Function d;
    private final Function div2;
    private final Function addEighteen;

    private final BinaryOp lessThan;
    private final BinaryOp equalTo;
    private final UnaryOp mod3Equals2;


    public TreeChecker(BigInteger stepFrom, BigInteger stepTo) {
        while(!stepFrom.mod(new BigInteger("18")).equals(new BigInteger("8"))){
            stepFrom = stepFrom.add(BigInteger.ONE);
        }

        BigIntegerParser parser = new BigIntegerParser();

        this.first = parser.parse(stepFrom);
        this.to = parser.parse(stepTo);

        this.u = new U();
        this.d = new D();
        this.div2 = new Div2();

        this.lessThan = new LessThan();
        this.equalTo = new LessThan();
        this.mod3Equals2 = new Mod3Equals2();
        this.addEighteen = new AddEighteen();
    }

    public Node call(){
        for (long[] i = first; lessThan.apply(i, to); i = addEighteen.apply(i)){
            Node node = new Node(i, u, d, lessThan, equalTo, mod3Equals2, div2);
            if (node.containsKOver2()) {
                return node;
            }
            if ((i[1]%logLimit)<eighteen){System.out.println(String.format("%s,%s", i[0], i[1]));}
        }
        return null;
    }
}