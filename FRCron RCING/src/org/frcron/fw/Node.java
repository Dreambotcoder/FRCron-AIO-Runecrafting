package org.frcron.fw;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        9/12/2015
 */
public abstract class Node {

    public boolean isTree = false;

    public abstract String getStatus();

    public abstract int priority();

    public abstract boolean onValid();

    public abstract int onLoop();

}
