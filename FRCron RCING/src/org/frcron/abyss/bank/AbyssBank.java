package org.frcron.abyss.bank;

import com.frc.frc_api.node_framework.my_nodes.ParentNode;
import org.frcron.abyss.movement.EnterAbyss;
import org.frcron.abyss.movement.EnterWildy;
import org.frcron.util.APIContext;

/**
 * Created by zach on 12/23/2015.
 */
public class AbyssBank extends ParentNode {

    public AbyssBank(APIContext context) {
        super(context);
        initChildren();
    }

    @Override
    public void initChildren() {
        add(new EnterAbyss(context));
        add(new EnterWildy(context));
    }
}
