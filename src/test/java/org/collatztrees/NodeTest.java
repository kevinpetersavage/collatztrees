package org.collatztrees;

import org.junit.Test;

import java.util.Set;

import static org.fest.assertions.Assertions.assertThat;

public class NodeTest {
    @Test public void aLessThanKOver2(){
        long kOver2 = 11L;
        long a = 10L;
        Node start = new Node(a, kOver2);

        Set<Node> children = start.calculateImmediateChildren();

        assertThat(children).contains(new Node(a*2L, kOver2));
    }

    @Test public void aEquals2Mod3AndLessThanKOver2(){
        long kOver2 = 12L;
        long a = 11L;
        Node start = new Node(a, kOver2);

        Set<Node> children = start.calculateImmediateChildren();

        long expected = ((a*2L)-1L)/3L;
        assertThat(children).contains(new Node(expected, kOver2));
    }

    @Test public void aEquals2Mod3AndGreaterThanKOver2(){
        long kOver2 = 5L;
        long a = 11L;
        Node start = new Node(a, kOver2);

        Set<Node> children = start.calculateImmediateChildren();

        long expected = ((a*2L)-1L)/3L;
        assertThat(children).contains(new Node(expected, kOver2));
    }

    @Test public void forKEquals8mod54TheTreeShouldHave3Nodes(){
        long k = 62L;
        Node start = new Node(k);

        int count = start.size();
        assertThat(count).isEqualTo(3);
    }

    @Test public void forKEquals8mod54TheTreeShouldNotContainKOver2(){
        long k = 62L;
        Node start = new Node(k);
        assertThat(start.containsKOver2()).isFalse();
    }
}
