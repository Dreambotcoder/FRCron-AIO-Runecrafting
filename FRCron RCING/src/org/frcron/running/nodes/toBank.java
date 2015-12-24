package org.frcron.running.nodes;

import com.frc.frc_api.node_framework.my_nodes.ChildNode;
import org.frcron.running.data.AltarType;
import org.frcron.util.APIContext;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public class ToBank extends ChildNode {

    private AltarType type;

    public ToBank(APIContext context,AltarType type) {
        super(context);
        this.type = type;
    }

    @Override
    public void execute() {
        context.getCron().recursiveForceWalk((type.getBankArea().getRandomTile()));
    }

    @Override
    public boolean validate() {
        if (context.getDreambot().getInventory().contains("Pure essence")) {
            return false;
        }
        if (type.getBankArea().contains(context.getDreambot().getLocalPlayer())) {
            return false;
        }
        return context.getDreambot().getGameObjects()
                .all(gameObject -> gameObject.hasAction("Craft-rune") && gameObject.getName().equals("Altar")).isEmpty();
    }
}
