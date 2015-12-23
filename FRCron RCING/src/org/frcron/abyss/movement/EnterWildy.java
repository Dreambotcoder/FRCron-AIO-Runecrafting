package org.frcron.abyss.movement;

import com.frc.frc_api.node_framework.my_nodes.ChildNode;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.frcron.abyss.AbyssConstants;
import org.frcron.util.APIContext;

/**
 * Created by zach on 12/23/2015.
 */
public class EnterWildy extends ChildNode{

    public EnterWildy(APIContext context) {
        super(context);
    }

    @Override
    public void execute() {
        if (AbyssConstants.WILDY_DITCH_TILE.distance() <= 5){
            GameObject ditch = context.getFRC().getNearestGameObject("Wilderness Ditch", "Cross");
            if (ditch != null){
                ditch.interact("Cross");
            }
        }
        else {
            context.getDreambot().getWalking().walk(AbyssConstants.WILDY_DITCH_TILE);
        }
    }

    @Override
    public boolean validate() {
        return true;
    }
}
