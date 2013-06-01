package org.collatztrees.functions;

import static org.collatztrees.Numbers.largeNumberOverlap;

public class AddEighteen implements Function {
    @Override
    public long[] apply(long[] input) {
        long smallPart = input[1]+18;
        boolean needsToOverlap = smallPart>=largeNumberOverlap;
        long extraLargePart = needsToOverlap? 1 : 0;
        long extraSmallPart = needsToOverlap? -largeNumberOverlap : 0;

        return new long[]{input[0] + extraLargePart, smallPart + extraSmallPart};
    }
}
