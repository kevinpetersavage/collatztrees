package org.collatztrees;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import static org.collatztrees.Numbers.*;

public class Node {
    private final BigInteger a;
    private final BigInteger kOver2;

    public Node(BigInteger k) {
        this.a = two.multiply(k).subtract(BigInteger.ONE).divide(three);
        this.kOver2 = k.divide(two);
    }

    public Node(BigInteger a, BigInteger kOver2) {
        this.a = a;
        this.kOver2 = kOver2;
    }

    public Set<Node> calculateImmediateChildren() {
        int comparison = a.compareTo(kOver2);

        Set<Node> children = new HashSet<Node>();
        if (comparison < 0){
            children.add(new Node(a.multiply(two), kOver2));
        }
        if (a.mod(three).equals(two) && comparison != 0){
            children.add(new Node(a.multiply(two).subtract(BigInteger.ONE).divide(three), kOver2));
        }
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        Node node = (Node) o;

        if (!a.equals(node.a)) return false;
        if (!kOver2.equals(node.kOver2)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + kOver2.hashCode();
        return result;
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
        if (a.equals(kOver2)){
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
    public String toString() {
        return "Node{" +
                "a=" + a +
                ", kOver2=" + kOver2 +
                '}';
    }
}
