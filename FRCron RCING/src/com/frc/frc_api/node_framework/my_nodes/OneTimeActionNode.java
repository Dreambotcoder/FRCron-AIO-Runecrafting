package com.frc.frc_api.node_framework.my_nodes;


import com.frc.frc_api.node_framework.tags.optional.Executeable;
import com.frc.frc_api.node_framework.tags.optional.PrePost;
import com.frc.frc_api.node_framework.tags.optional.SelfRemoving;
import com.frc.frc_api.node_framework.tags.optional.Validateable;
import com.frc.frc_api.node_framework.tags.required.Node;

/**
 * Created by zherridg on 7/22/2015.
 */
public abstract class OneTimeActionNode implements Node, Validateable, Executeable, PrePost, SelfRemoving {

    //Node that will only be execute one time then it will remove itself from the node tree. Good for initing stuff only when logged in.
    @Override
    public void onStart() {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public boolean shouldRemove() {
        return true;
    }
}
