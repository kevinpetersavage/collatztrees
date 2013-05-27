package org.collatztrees;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Set;

import static org.fest.assertions.Assertions.assertThat;

public class NodeTest {
    @Test public void aLessThanKOver2(){
        BigInteger kOver2 = new BigInteger("11");
        BigInteger a = new BigInteger("10");
        Node start = new Node(a, kOver2);

        Set<Node> children = start.calculateImmediateChildren();

        assertThat(children).contains(new Node(a.multiply(new BigInteger("2")), kOver2));
    }

    @Test public void aEquals2Mod3AndLessThanKOver2(){
        BigInteger kOver2 = new BigInteger("12");
        BigInteger a = new BigInteger("11");
        Node start = new Node(a, kOver2);

        Set<Node> children = start.calculateImmediateChildren();

        BigInteger expected = a.multiply(new BigInteger("2")).subtract(BigInteger.ONE).divide(new BigInteger("3"));
        assertThat(children).contains(new Node(expected, kOver2));
    }

    @Test public void aEquals2Mod3AndGreaterThanKOver2(){
        BigInteger kOver2 = new BigInteger("5");
        BigInteger a = new BigInteger("11");
        Node start = new Node(a, kOver2);

        Set<Node> children = start.calculateImmediateChildren();

        BigInteger expected = a.multiply(new BigInteger("2")).subtract(BigInteger.ONE).divide(new BigInteger("3"));
        assertThat(children).contains(new Node(expected, kOver2));
    }

    @Test public void forKEquals8mod54TheTreeShouldHave3Nodes(){
        BigInteger k = new BigInteger("62");
        Node start = new Node(k);

        int count = start.size();
        assertThat(count).isEqualTo(3);
    }

    @Test public void forKEquals8mod54TheTreeShouldNotContainKOver2(){
        BigInteger k = new BigInteger("62");
        Node start = new Node(k);
        assertThat(start.containsKOver2()).isFalse();
    }
}
