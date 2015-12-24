package org.frcron.util;

import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.walking.path.impl.GlobalPath;
import org.dreambot.api.methods.walking.web.node.AbstractWebNode;

import java.awt.*;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        24/12/2015
 */
public class WebDebug {

    /**
     * BUGGED
     */
    private GlobalPath<AbstractWebNode> path;
    private MethodContext context;

    public WebDebug(GlobalPath<AbstractWebNode> path,MethodContext context) {
        this.path = path;
        this.context = context;
    }

    public void onPaint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (AbstractWebNode node : path) {
            node.paint(g2,context.getMap().tileToMiniMap(node.getTile()));
        }
    }
}
