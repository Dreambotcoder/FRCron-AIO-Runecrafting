package org.frcron;

import com.frc.frc_api.node_framework.my_nodes.BaseNode;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.frcron.abyss.Abyss;
import org.frcron.running.data.AltarType;
import org.frcron.running.nodes.Classic;
import org.frcron.util.APIContext;
import org.frcron.util.MouseTip;

import java.awt.*;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */

@ScriptManifest(category = Category.RUNECRAFTING, name = "FRCron RC", author = "FRC & Articron", version = 0.03D)
public class Script extends AbstractScript{

    /**
     * debug vars
     */
    private final boolean ABYSS = false;
    private final boolean USE_CUSTOM_MOUSETIP = true;

    private APIContext api = new APIContext(this);
    private BaseNode baseNode = new BaseNode(api);
    private MouseTip tip;

    private final AltarType type = AltarType.MIND_ALTAR;


    public void onStart() {
        baseNode.add((ABYSS) ? new Abyss(api) : new Classic(api, type));
        if (USE_CUSTOM_MOUSETIP) {
            getClient().getInstance().setDrawMouse(false);
            tip = api.getCron().getMouseTip();
        }

    }

    public void onExit() {
        getClient().getInstance().setDrawMouse(true);
    }

    @Override
    public int onLoop() {
        baseNode.execute();
        return 0;
    }

    @Override
    public void onPaint(Graphics graphics) {
        //graphics.drawString("Status: " + baseNode.getStatus(), 100, 100);  Use the mouseTip instead, looks cooler xD
        tip.setStatus(baseNode.getStatus());
        tip.onPaint(graphics);
    }
}
