package com.frc.frc_api.node_framework.my_nodes;

import org.dreambot.api.methods.MethodContext;
import org.frcron.util.APIContext;

/**
 * Created by zherridg on 7/10/2015.
 */
public class BaseNode extends ParentNode {

    //Node to add all other nodes to, removes it's status.

    public BaseNode(APIContext context) {
        super(context);
    }

    @Override
    public String getStatus() {
        return getChildStatus();
    }

    @Override
    public void initChildren() {

    }

    @Override
    public boolean validate() {
        return true;
    }
}
