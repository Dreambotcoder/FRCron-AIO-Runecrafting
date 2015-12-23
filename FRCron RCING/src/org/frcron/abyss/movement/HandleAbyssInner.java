package org.frcron.abyss.movement;

import com.frc.frc_api.node_framework.my_nodes.ChildNode;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.frcron.abyss.AbyssConstants;
import org.frcron.util.APIContext;

/**
 * Created by zach on 12/23/2015.
 */
public class HandleAbyssInner extends ChildNode {

    private String exitName = "Nature rift";

    public HandleAbyssInner(APIContext context) {
        super(context);
    }

    @Override
    public void execute() {
        GameObject nearestGameObject = context.getFRC().getNearestGameObject(exitName);

        if (nearestGameObject != null){
            nearestGameObject.interact("Exit-through");
        }
        else {
            context.getDreambot().getWalking().walk(AbyssConstants.ABYSS_MIDDLE);
        }
    }

    @Override
    public boolean validate() {
        return AbyssConstants.ABYSS_MIDDLE.distance() <= 15;
    }
}
