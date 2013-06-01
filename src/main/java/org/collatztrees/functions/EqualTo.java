package org.collatztrees.functions;

public class EqualTo implements BinaryOp {
    @Override
    public boolean apply(long[] a, long[] b) {
        return a[1]==b[1] && a[0]==b[0];
    }
}
