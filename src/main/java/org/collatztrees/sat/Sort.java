package org.collatztrees.sat;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import static java.nio.charset.Charset.defaultCharset;

public class Sort {
    public static void main(String[] args) throws IOException {
        TreeSet<String> strings = new TreeSet<String>(Files.readLines(new File("C:\\Users\\Jo\\IdeaProjects\\collatzTrees\\src\\main\\java\\org\\collatztrees\\sat\\output.txt"), defaultCharset()));
        for (String string : strings) {
            System.out.println(string);
        }


    }
}
