package org.collatztrees.functions;

public class LessThan implements BinaryOp {
    @Override
    public boolean apply(long[] a, long[] b) {
        return a[0]<b[0]||(a[0]==b[0] && a[1]<b[1]);
    }
}
