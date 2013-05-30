package org.collatztrees;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import static org.collatztrees.Numbers.*;

public class Node {
    private final long a;
    private final long kOver2;

    public Node(long k) {
        this.a = ((2L * k)-1L)/3L;
        this.kOver2 = k/2L;
    }

    public Node(long a, long kOver2) {
        this.a = a;
        this.kOver2 = kOver2;
    }

    public Set<Node> calculateImmediateChildren() {
        Set<Node> children = new HashSet<Node>();
        if (a < kOver2){
            children.add(new Node(a*2L, kOver2));
        }
        if ((a % 3L) == 2 && a != kOver2){
            children.add(new Node(((a*2l)-1L)/3L, kOver2));
        }
        return children;
    }

    public int size() {
        Set<Node> children = calculateImmediateChildren();
        int count = 1;
        for (Node child : children) {
            count += (child.size());
        }
        return count;
    }

    public boolean containsKOver2(){
        if (a==kOver2){
            return true;
        }
        Set<Node> children = calculateImmediateChildren();
        for (Node child : children) {
            if (child.containsKOver2()){
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (a != node.a) return false;
        if (kOver2 != node.kOver2) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (a ^ (a >>> 32));
        result = 31 * result + (int) (kOver2 ^ (kOver2 >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Node{" +
                "a=" + a +
                ", kOver2=" + kOver2 +
                '}';
    }
}
