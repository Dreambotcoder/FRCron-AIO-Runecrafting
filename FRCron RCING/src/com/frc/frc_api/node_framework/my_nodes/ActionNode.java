package com.frc.frc_api.node_framework.my_nodes;


import com.frc.frc_api.node_framework.tags.optional.Executeable;
import com.frc.frc_api.node_framework.tags.optional.PrePost;
import com.frc.frc_api.node_framework.tags.required.Node;
import org.dreambot.api.methods.MethodContext;
import org.frcron.util.APIContext;

/**
 * Created by zherridg on 7/21/2015.
 */
public abstract class ActionNode implements Node, Executeable, PrePost {
    //Executes every loop, dose not validate, dose not block execution.

    protected APIContext context;

    public ActionNode(APIContext context) {
        this.context = context;
    }

    @Override
    public void onFinish() {

    }
    @Override
    public void onStart() {

    }
}
