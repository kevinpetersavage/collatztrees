package org.collatztrees.functions;

public class Mod3Equals2 implements UnaryOp {
    @Override
    public boolean apply(long[] a) {
        return (a[0]%3 + a[1]%3)%3 == 2;
    }
}
