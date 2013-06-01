package org.collatztrees.functions;

import org.collatztrees.Numbers;

public class Div2 implements Function{
    @Override
    public long[] apply(long[] input) {
        long remainder = (input[0] * 10L / 2L) % 10L;
        long smallExtra = remainder * Numbers.largeNumberOverlap / 10L;

        return new long[]{input[0]/2L, smallExtra + (input[1]/2L)};
    }
}
