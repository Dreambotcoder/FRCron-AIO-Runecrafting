package org.frcron.running.nodes;

import com.frc.frc_api.node_framework.my_nodes.ChildNode;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.frcron.running.data.AltarType;
import org.frcron.util.APIContext;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public class EnterAltar extends ChildNode {

    private AltarType type;

    public EnterAltar(APIContext context, AltarType type) {
        super(context);
        this.type = type;
    }

    @Override
    public void execute() {
        GameObject altar = context.getDreambot().getGameObjects().closest("Mysterious ruins");
        if (altar.hasAction("Enter")) {
            if (altar.interact("Enter")) {
                MethodProvider.sleepUntil(() -> !altar.isOnScreen(),5000);
            }
        }
    }

    @Override
    public boolean validate() {
        if (!context.getDreambot().getInventory().contains("Pure essence")) {
            return false;
        }
        return type.getEntranceArea().contains(context.getDreambot().getLocalPlayer());
    }
}
