package com.frc.frc_api.node_framework.my_nodes;

import org.tbot.bot.TBot;
import org.tbot.methods.Time;

/**
 * Created by zach on 8/29/2015.
 */
public abstract class LoopingNode extends ChildNode {

    private boolean looping = true;

    @Override
    public void execute() {
        looping = true;
        while (TBot.getBot().getScriptHandler().getScript().isRunning() && looping){
            int result = loop();
            if (result == -1){
                break;
            }
            Time.sleep(result);
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
