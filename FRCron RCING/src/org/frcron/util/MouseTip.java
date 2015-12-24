//package org.dreambot.cronscript.visual;
package org.frcron.util;


import org.dreambot.api.methods.MethodContext;

import java.awt.*;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        12/12/2015
 */
public class MouseTip {

    private MethodContext context;
    private Font font;
    private Color background = new Color(47 * (1/255f),52* (1/255f),79* (1/255f), .6f);
    private Color details = new Color(246 * (1 / 255f), 88 * (1 / 255f), 106 * (1 / 255f));
    private String status;

    public MouseTip(MethodContext context) {
        font = new Font(Font.SANS_SERIF,Font.BOLD,10);
        this.context = context;
        status = "Starting...";
    }

    public void setStatus(String stat) {
        if (!status.equals(stat) && stat != null) {
            status = stat;
        }
    }

    public void onPaint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setFont(font);
            int width = g2.getFontMetrics().stringWidth(status);
            g2.setColor(background);
            g2.fillRoundRect(context.getMouse().getX(), context.getMouse().getY() - 6, width + 10, 12, 5, 5);
            g2.setColor(details);
            drawCenteredCircle(g2, context.getMouse().getX(), context.getMouse().getY(), 10);
            g2.setColor(background);
            drawCenteredCircle(g2, context.getMouse().getX(), context.getMouse().getY(), 4);
            g2.setColor(details);
            g2.drawString(status, context.getMouse().getX() + 7, context.getMouse().getY() + 3);
    }

    private void drawCenteredCircle(Graphics2D g, int x, int y, int r) {
        x = x-(r/2);
        y = y-(r/2);
        g.fillOval(x,y,r,r);
    }
}