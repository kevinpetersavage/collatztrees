package org.collatztrees;

public class Numbers {
    public static final long three = 3L;
    public static final long two = 2L;

    public static final long eighteen = 18L;
    public static final long eight = 8L;

    public static final long largeNumberOverlap = pow(10, 18);

    public static final long logLimit = pow(10L, 8);

    public static long pow(long first, int second){
        long result = 1;
        for(int i = 0; i < second; i++){
            result *= first;
        }
        return result;
    }
}
