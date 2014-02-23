package org.collatztrees.sat;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

public class BuildConditions {
    private static final String not = "not ";
    private static final String and = " and ";
    private static final String or = " or ";

    public static void main(String[] args){
        int numberOfBits = 3;
        int numberOfLegs = 3;

        List<String> x = buildVariable("x", numberOfBits);
        List<String> y = buildVariable("y", numberOfBits);
        List<String> yc = buildVariable("yc", numberOfBits);
        List<String> z = buildVariable("z", numberOfBits);

        System.out.println(not(get(x, 1)));
        System.out.println(and(not(get(x, 1)), equivalent(get(y, 1), get(x, 2))));
        System.out.println(and(not(get(x, 1)), divBy2(x, y, numberOfBits)));

        System.out.println(get(x, 1));
        System.out.println(and(get(x, 1), not(get(yc, 1)), get(yc, 2), times3Plus1(x, yc, y)));
    }

    private static String times3Plus1(List<String> x, List<String> yc, List<String> y) {
        int n = 3;
        String ycEquation = brackets(or(
                brackets(and(get(x, n - 1), get(x, n - 2))),
                brackets(and(get(x, n - 1), get(yc, n - 1))),
                brackets(and(get(x, n - 2), get(yc, n - 1)))
        ));
        String yEquation = brackets(or(
                brackets(and(get(x, n), get(x, n - 1), get(yc, n))),
                brackets(and(get(x, n), not(get(x, n - 1)), not(get(yc, n)))),
                brackets(and(not(get(x, n)), get(x, n - 1), not(get(yc, n)))),
                brackets(and(not(get(x, n)), not(get(x, n - 1)), get(yc, n)))
        ));
        return and(brackets(equivalent(get(yc, n), ycEquation)), brackets(equivalent(get(y, n), yEquation)));
    }

    private static String divBy2(List<String> x, List<String> y, int numberOfBits) {
        List<String> equivalentConditions = new ArrayList<String>();
        for (int i = 1; i < numberOfBits; i++){
            equivalentConditions.add(equivalent(get(y, i), get(x, i+1)));
        }
        equivalentConditions.add(not(get(y, numberOfBits)));

        return and(equivalentConditions);
    }

    private static String and(List<String> equivalentConditions) {
        return and(equivalentConditions.toArray(new String[0]));
    }

    private static String equivalent(String p, String q) {
        return brackets(and(brackets(or(p, not(q))), brackets(or(not(p), q))));
    }

    private static String brackets(String p) {
        return "(" + p + ")";
    }

    private static String or(String... values) {
        return Joiner.on(or).join(values);
    }

    private static String get(List<String> x, int i) {
        return x.get(i-1);
    }

    private static String and(String... values) {
        return Joiner.on(and).join(values);
    }

    private static String not(String x) {
        return not + x;
    }

    private static List<String> buildVariable(String prefix, int numberOfBits) {
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < numberOfBits; i++) {
            strings.add(prefix + (i + 1));
        }
        return strings;
    }
}
