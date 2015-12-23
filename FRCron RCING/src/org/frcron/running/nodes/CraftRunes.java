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
public class CraftRunes extends ChildNode {

    public CraftRunes(APIContext context) {
        super(context);
    }

    @Override
    public void execute() {
        GameObject altar = context.getDreambot().getGameObjects()
                .all(gameObject -> gameObject.hasAction("Craft-rune") && gameObject.getName().equals("Altar"))
                .stream()
                .findFirst()
                .get();
        if (altar.interact("Craft-rune")) {
            MethodProvider.sleepUntil(() -> !context.getDreambot().getInventory().contains(7936),5000);
        }
    }

    @Override
    public boolean validate() {
        if (!context.getDreambot().getInventory().contains("Pure essence")) {
            return false;
        }
        return !context.getDreambot().getGameObjects()
                .all(gameObject -> gameObject.hasAction("Craft-rune") && gameObject.getName().equals("Altar")).isEmpty();
    }
}
