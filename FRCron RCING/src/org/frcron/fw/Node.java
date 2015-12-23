package org.frcron.fw;

import org.dreambot.api.methods.MethodContext;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        9/12/2015
 */
public abstract class Node {

    private MethodContext context;
    private int sleepTime;

    public Node(MethodContext context, int sleepTime) {
        this.context = context;
        this.sleepTime = sleepTime;
    }
    public boolean isTree = false;

    public abstract String getStatus();

    public abstract int priority();

    public abstract boolean onValid();

    public abstract int onLoop();

    public MethodContext getContext() {
        return context;
    }

    public int getSleepTime() {
        return sleepTime;
    }

}
