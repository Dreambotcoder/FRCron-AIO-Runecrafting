package org.frcron.util;

import org.dreambot.api.methods.MethodContext;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public class APIContext {

    private MethodContext context;

    public APIContext(MethodContext context) {
        this.context = context;
    }

    public MethodContext getDreambot() {
        return context;
    }

    /**
     * We can write our own stuff here
     */
}
