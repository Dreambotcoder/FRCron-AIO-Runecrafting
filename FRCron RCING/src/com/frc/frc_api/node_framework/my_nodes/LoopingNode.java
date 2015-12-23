package com.frc.frc_api.node_framework.my_nodes;

import org.dreambot.api.Client;
import org.dreambot.api.methods.MethodContext;

/**
 * Created by zach on 8/29/2015.
 */
public abstract class LoopingNode extends ChildNode {

    private boolean looping = true;

    public LoopingNode(MethodContext context) {
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
            context.sleep(result);
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
