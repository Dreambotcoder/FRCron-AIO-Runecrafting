package com.frc.frc_api.node_framework.my_nodes;


import com.frc.frc_api.node_framework.tags.optional.Executeable;
import com.frc.frc_api.node_framework.tags.optional.PrePost;
import com.frc.frc_api.node_framework.tags.optional.SelfRemoving;
import com.frc.frc_api.node_framework.tags.optional.Validateable;
import com.frc.frc_api.node_framework.tags.required.Node;
import org.dreambot.api.methods.MethodContext;
import org.frcron.util.APIContext;

/**
 * Created by zherridg on 7/22/2015.
 */
public abstract class OneTimeActionNode extends ActionNode implements SelfRemoving {

    public OneTimeActionNode(APIContext context) {
        super(context);
    }

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
