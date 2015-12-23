package org.frcron.fw.impl.trees;

import org.dreambot.api.methods.MethodContext;
import org.frcron.fw.NodeTree;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public class RootTree extends NodeTree {

    public RootTree(MethodContext context, int sleepTime) {
        super(context,sleepTime);
    }

    @Override
    public String getStatus() {
        return (getCandidateLeaf().isPresent()) ? getCandidateLeaf().get().getStatus() : "Scanning...";
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public boolean onValid() {
        return getContext().getClient().isLoggedIn();
    }
}
