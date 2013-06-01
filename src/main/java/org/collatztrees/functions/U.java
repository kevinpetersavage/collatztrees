package org.collatztrees.functions;

import static org.collatztrees.Numbers.largeNumberOverlap;

/**
 * u(x) = (2x-1)/3
 */
public class U implements Function{
    public long[] apply(long[] a) {
        long[] reconfigured = reconfigure(a);

        long smallPart = ((reconfigured[1]*2L) - 1L)/3L;
        long largePart = (reconfigured[0]*2L)/3L;
        boolean needsToOverlap = smallPart>=largeNumberOverlap;
        long extraLargePart = needsToOverlap? 1 : 0;
        long extraSmallPart = needsToOverlap? -largeNumberOverlap : 0;

        return new long[]{largePart + extraLargePart, smallPart + extraSmallPart};
    }

    private long[] reconfigure(long[] a) {
        long numberToPropegateDown = ((a[0]*2) %3)/2;
        return new long[]{
                a[0] - numberToPropegateDown,
                a[1] + (numberToPropegateDown * largeNumberOverlap)
        };
    }
}
