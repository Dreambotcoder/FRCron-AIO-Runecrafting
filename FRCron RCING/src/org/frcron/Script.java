package org.frcron;

import org.dreambot.api.script.AbstractScript;
import org.frcron.fw.TreeController;
import org.frcron.fw.impl.RootTree;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */

public class Script extends AbstractScript{

    public void onStart() {
        TreeController controller = new TreeController(new RootTree(this,0));
        /**
         * Add sets here
         */
    }

    @Override
    public int onLoop() {
        return 0;
    }
}
