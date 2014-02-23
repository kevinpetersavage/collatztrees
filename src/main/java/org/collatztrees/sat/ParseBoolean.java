package org.collatztrees.sat;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import static java.nio.charset.Charset.defaultCharset;

public class ParseBoolean {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readLines(new File("C:\\Users\\Jo\\IdeaProjects\\collatzTrees\\src\\main\\java\\org\\collatztrees\\sat\\solution.txt"), defaultCharset());

        BigInteger total = BigInteger.ZERO;
        BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
        for (int i = 0; i < strings.size(); i++) {
            total = total.add(Boolean.parseBoolean(strings.get(i)) ? two.pow(i) : BigInteger.ZERO);
        }
        System.out.println(total);
    }
}
