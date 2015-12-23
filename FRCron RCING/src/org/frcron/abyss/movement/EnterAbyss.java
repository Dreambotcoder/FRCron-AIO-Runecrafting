package org.frcron.abyss.movement;

import com.frc.frc_api.node_framework.my_nodes.ChildNode;
import org.dreambot.api.utilities.impl.Condition;
import org.dreambot.api.wrappers.interactive.NPC;
import org.frcron.abyss.AbyssConstants;
import org.frcron.util.APIContext;

/**
 * Created by zach on 12/23/2015.
 */
public class EnterAbyss extends ChildNode {

    public EnterAbyss(APIContext context) {
        super(context);
    }

    @Override
    public void execute() {
        if (AbyssConstants.MAGE_TILE.distance() <= 5){
            NPC teleport = context.getFRC().getNearestNPC("Mage of Zamorak", "Teleport");
            if (teleport != null){
                teleport.interact("Teleport");
            }
        }
        else {
            context.getDreambot().sleepUntil(new Condition() {
                @Override
                public boolean verify() {
                    return context.getDreambot().getWalking().getDestinationDistance() <= 4;
                }
            }, 3000);
        }
    }

    @Override
    public boolean validate() {
        if (AbyssConstants.MAGE_TILE.distance() <= 5){
            return true;
        }
        return context.getDreambot().getWalking().walk(AbyssConstants.MAGE_TILE);
    }
}
