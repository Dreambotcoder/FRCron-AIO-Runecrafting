package com.frc.frc_api.node_framework.my_nodes;

import org.dreambot.api.Client;
import org.dreambot.api.methods.MethodContext;
import org.frcron.util.APIContext;

/**
 * Created by zach on 8/29/2015.
 */
public abstract class LoopingNode extends ChildNode {

    private boolean looping = true;

    public LoopingNode(APIContext context) {
        super(context);
    }

    @Override
    public void execute() {
        looping = true;

        while (looping){
            int result = loop();
            if (result == -1){
                break;
            }
            context.getDreambot().sleep(result);
        }
    }

    public void stopLoop(){
        looping = false;
    }

    @Override
    public boolean validate() {
        return false;
    }

    public abstract int loop();
}
