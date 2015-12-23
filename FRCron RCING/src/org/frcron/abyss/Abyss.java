package org.frcron.abyss;

import com.frc.frc_api.node_framework.my_nodes.ParentNode;
import org.dreambot.api.methods.MethodContext;

/**
 * Created by zach on 12/23/2015.
 */
public class Abyss extends ParentNode {

    public Abyss(MethodContext context) {
        super(context);
    }

    @Override
    public void initChildren() {
        addAll(new AbyssTest(context));
    }
}
