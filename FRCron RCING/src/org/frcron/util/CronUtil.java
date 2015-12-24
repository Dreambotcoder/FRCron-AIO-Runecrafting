package org.frcron.util;

import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.walking.path.impl.GlobalPath;
import org.dreambot.api.methods.walking.web.node.AbstractWebNode;
import org.dreambot.api.wrappers.interactive.Locatable;


/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        24/12/2015
 */
public class CronUtil {

    private MethodContext context;
    private MouseTip mouseTip;

    public CronUtil(MethodContext context) {
        this.context = context;
        mouseTip = new MouseTip(context);
    }

    //BUGGED
    public WebDebug createDebugPath(Tile start, Tile end) {
        GlobalPath<AbstractWebNode> path = context.getWalking().getWebPathFinder()
                .calculate(start.getX(),start.getY(),start.getZ(),end.getX(),end.getY(),end.getZ());
        return new WebDebug(path,context);
    }

    //TODO
    public boolean recursiveForceWalk(Locatable locatable) {
        return context.getWalking().walk(locatable.getTile());
    }

    public MouseTip getMouseTip() {
        return mouseTip;
    }
}
