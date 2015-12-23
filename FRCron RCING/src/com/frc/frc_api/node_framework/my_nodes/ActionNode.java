package com.frc.frc_api.node_framework.my_nodes;


import com.frc.frc_api.node_framework.tags.optional.Executeable;
import com.frc.frc_api.node_framework.tags.optional.PrePost;
import com.frc.frc_api.node_framework.tags.required.Node;

/**
 * Created by zherridg on 7/21/2015.
 */
public abstract class ActionNode implements Node, Executeable, PrePost {
    //Executes every loop, dose not validate, dose not block execution.
    
    @Override
    public void onFinish() {

    }
    @Override
    public void onStart() {

    }
}
