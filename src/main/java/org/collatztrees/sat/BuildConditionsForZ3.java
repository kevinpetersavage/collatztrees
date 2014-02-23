package org.collatztrees.sat;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/** http://rise4fun.com/z3py/tutorial */
public class BuildConditionsForZ3 {
    private static final String not = "Not";
    private static final String and = "And";
    private static final String or = "Or";

    public static void main(String[] args){
        int numberOfBits = 64;
        int numberOfLegs = 3;

        System.out.println("s = Solver()");
        List<String> x = defineAndSetupVariable(numberOfBits, "x");
        List<String> xc = defineAndSetupVariable(numberOfBits, "xc");
        List<String> y = defineAndSetupVariable(numberOfBits, "y");
        List<String> yc = defineAndSetupVariable(numberOfBits, "yc");
        List<String> z = defineAndSetupVariable(numberOfBits, "z");
        List<String> zc = defineAndSetupVariable(numberOfBits, "zc");

        chain(numberOfBits, x, y, yc, "xToY");
        chain(numberOfBits, y, z, zc, "xToY");
        chain(numberOfBits, z, x, xc, "xToY");

        System.out.println("print s.check()");
        System.out.println("print s.model()");
    }

    private static void chain(int numberOfBits, List<String> x, List<String> y, List<String> yc, String name) {
        System.out.println(name + "DivBy2 = " + and(not(get(x, 1)), divBy2(x, y, numberOfBits)));
        System.out.println(name + "Times3Plus1 = " + and(get(x, 1), not(get(yc, 1)), get(yc, 2), times3Plus1(x, yc, y, numberOfBits)));
        System.out.println(name + "Chain = Or(" + name + "DivBy2, " + name + "Times3Plus1)");
        System.out.println("s.add(" + name + "Chain)");
    }

    private static List<String> defineAndSetupVariable(int numberOfBits, String name) {
        List<String> x = buildVariable(name, numberOfBits);
        System.out.println(define(x));
        System.out.println(name + "NotZero = " + notZero(x));
        System.out.println("s.add(" + name + "NotZero)");
        return x;
    }

    private static String notZero(List<String> x) {
        return or(x.toArray(new String[0]));
    }

    private static String define(List<String> x) {
        return Joiner.on(",").join(x) + " = Bools('" + Joiner.on(" ").join(x) + "')";
    }

    private static String times3Plus1(List<String> x, List<String> yc, List<String> y, int numberOfBits) {
        List<String> equations = Lists.newArrayList();
        for (int i = numberOfBits; i > 2; i--){
            String ycEquation = equivalent(get(yc, i), or(
                    and(get(x, i - 1), get(x, i - 2)),
                    and(get(x, i - 1), get(yc, i - 1)),
                    and(get(x, i - 2), get(yc, i - 1))
            ));
            String yEquation = equivalent(get(y, i), or(
                    and(get(x, i), get(x, i - 1), get(yc, i)),
                    and(get(x, i), not(get(x, i - 1)), not(get(yc, i))),
                    and(not(get(x, i)), get(x, i - 1), not(get(yc, i))),
                    and(not(get(x, i)), not(get(x, i - 1)), get(yc, i))
            ));
            equations.add(ycEquation);
            equations.add(yEquation);
        }
        return and(equations);
    }

    private static String divBy2(List<String> x, List<String> y, int numberOfBits) {
        List<String> equivalentConditions = new ArrayList<String>();
        for (int i = 1; i < numberOfBits; i++){
            equivalentConditions.add(equivalent(get(y, i), get(x, i+1)));
        }
        equivalentConditions.add(not(get(y, numberOfBits)));

        return and(equivalentConditions);
    }

    private static String and(List<String> values) {
        return and(values.toArray(new String[0]));
    }

    private static String equivalent(String p, String q) {
        return p + " == " + q;
    }

    private static String brackets(String p) {
        return "(" + p + ")";
    }

    private static String or(String... values) {
        return or + brackets(Joiner.on(",").join(values));
    }

    private static String get(List<String> x, int i) {
        return x.get(i-1);
    }

    private static String and(String... values) {
        return and + brackets(Joiner.on(",").join(values));
    }

    private static String not(String x) {
        return not + brackets(x);
    }

    private static List<String> buildVariable(String prefix, int numberOfBits) {
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < numberOfBits; i++) {
            strings.add(prefix + (i + 1));
        }
        return strings;
    }
}
