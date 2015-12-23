package com.frc.frc_api.node_framework.tags.optional;

/**
 * Created by zherridg on 8/11/2015.
 */
public interface SelfRemoving {
    //Tags the node as removeable, if the return is true the parent node will remove the node from the tree after execution.
    boolean shouldRemove();
}
