package org.collatztrees;

import org.junit.Test;

import java.math.BigInteger;

import static org.fest.assertions.Assertions.assertThat;


public class TreeCheckerTest {
    @Test public void shouldCheckTrees(){
        assertThat(new TreeChecker(BigInteger.ONE,new BigInteger("100")).call()).isNull();
    }
}
