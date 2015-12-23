package org.frcron.abyss;

import com.frc.frc_api.node_framework.my_nodes.ParentNode;
import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.map.Tile;
import org.frcron.abyss.bank.AbyssBank;
import org.frcron.abyss.movement.HandleAbyssInner;
import org.frcron.util.APIContext;

/**
 * Created by zach on 12/23/2015.
 */
public class Abyss extends ParentNode {

    public Abyss(APIContext context) {
        super(context);
        initChildren();
    }

    @Override
    public void initChildren() {
        add(new HandleAbyssInner(context));
        add(new AbyssBank(context));
    }
}
