package org.frcron.fw;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public abstract class NodeTree extends Node implements Comparator<Node> {

    private List<Node> nodeList;
    private int sleepTime;

    public NodeTree(int sleepTime) {
        nodeList = new ArrayList<>();
        this.sleepTime = sleepTime;
        isTree = true;
    }

    public NodeTree addLeaves(Node... leaves) {
        nodeList.addAll(Arrays.stream(leaves)
                .filter(Objects::nonNull)
                .filter(node -> !nodeList.contains(node))
                .collect(Collectors.toList()));
        nodeList.sort(this);
        return this;
    }

    public NodeTree removeLeaves(Node... leaves) {
        nodeList.removeAll(Arrays.stream(leaves)
                .filter(Objects::nonNull)
                .filter(node -> nodeList.contains(node))
                .collect(Collectors.toList()));
        nodeList.sort(this);
        return this;
    }

    public Node[] getLeaves() {
        return nodeList.toArray(new Node[nodeList.size()]);
    }

    private Stream<Node> getValidLeaveStream() {
        return nodeList.stream().filter(Objects::nonNull).filter(Node::onValid);
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public Node[] getValidLeaves() {
        List<Node> stream = getValidLeaveStream().collect(Collectors.toList());
        return stream.toArray(new Node[stream.size()]);
    }

    public Optional<Node> getCandidateLeaf() {
        return getValidLeaveStream().findFirst();
    }

    @Override
    public int compare(Node node1, Node node2) {
        return node1.priority() - node2.priority();
    }

    @Override
    public int onLoop() {
        Optional<Node> candidate = getCandidateLeaf();
        return candidate.isPresent() ? candidate.get().onLoop() : sleepTime;
    }

}