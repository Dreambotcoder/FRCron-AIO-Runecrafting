package org.frcron.util;

import org.dreambot.api.methods.MethodContext;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public class APIContext {

    private MethodContext context;

    private FrcUtil frcUtil;

    public APIContext(MethodContext context) {
        this.context = context;
        frcUtil = new FrcUtil(context);
    }

    public FrcUtil getFRC() {
        return frcUtil;
    }

    public MethodContext getDreambot() {
        return context;
    }

    /**
     * We can write our own stuff here
     */
}
