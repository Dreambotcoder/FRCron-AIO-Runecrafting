package org.frcron.fw;

import java.util.ArrayList;
import java.util.List;
/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        9/12/2015
 */
public class TreeController  {

    private NodeTree root;

    public TreeController(NodeTree root) {
        this.root = root;
    }

    public void invokeTree(NodeTree... tree) {
        root.addLeaves(tree);
    }

    public void revokeTree(NodeTree... tree) {
        root.removeLeaves(tree);
    }

    public int onLoop() {
        return root.onLoop();
    }

    public NodeTree[] getTrees() {
        List<NodeTree> treeList = new ArrayList<>();
        for (Node tree : root.getLeaves()) {
            if (tree.isTree) {
                treeList.add((NodeTree)tree);
            }
        }
        return treeList.toArray(new NodeTree[treeList.size()]);
    }

    public NodeTree getRootTree() {
        return root;
    }
}
