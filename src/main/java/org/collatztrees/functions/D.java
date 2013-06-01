package org.collatztrees.functions;

import static org.collatztrees.Numbers.*;

/**
 * D(x) = 2x
 */
public class D implements Function {
    @Override
    public long[] apply(long[] input) {
        long smallPart = input[1]*2;
        boolean needsToOverlap = smallPart>=largeNumberOverlap;
        long extraLargePart = needsToOverlap? 1 : 0;
        long extraSmallPart = needsToOverlap? -largeNumberOverlap : 0;

        return new long[]{(input[0]*2) + extraLargePart, smallPart + extraSmallPart};
    }
}
