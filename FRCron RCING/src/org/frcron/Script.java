package org.frcron;

import com.frc.frc_api.node_framework.my_nodes.BaseNode;
import org.dreambot.api.script.AbstractScript;
import org.frcron.abyss.Abyss;
import org.frcron.fw.TreeController;
import org.frcron.fw.impl.trees.RootTree;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */

public class Script extends AbstractScript{

    private BaseNode baseNode = new BaseNode(this);

    public void onStart() {
        baseNode.add(new Abyss(this));
    }

    @Override
    public int onLoop() {
        return 0;
    }
}
