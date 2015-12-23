package org.frcron.running.nodes;

import com.frc.frc_api.node_framework.my_nodes.ChildNode;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.frcron.util.APIContext;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public class ExitAltar extends ChildNode {

    public ExitAltar(APIContext context) {
        super(context);
    }

    @Override
    public void execute() {
        GameObject portal = context.getDreambot().getGameObjects().closest("Portal");
        if (!portal.isOnScreen()) {
            if (context.getDreambot().getWalking().walk(portal)) {
                MethodProvider.sleepUntil(portal::isOnScreen,5000);
            }
        }
        if (portal.isOnScreen()) {
            if (portal.interact("Use")) {
                MethodProvider.sleepUntil(() -> !portal.isOnScreen(),5000);
            }
        }
    }

    @Override
    public boolean validate() {
        if (context.getDreambot().getInventory().contains("Pure essence")) {
            return false;
        }
        return context.getDreambot().getGameObjects().closest("Portal").exists();
    }
}
