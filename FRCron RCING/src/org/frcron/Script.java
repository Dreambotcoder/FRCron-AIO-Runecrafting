package org.frcron;

import com.frc.frc_api.node_framework.my_nodes.BaseNode;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.frcron.abyss.Abyss;
import org.frcron.running.data.AltarType;
import org.frcron.running.nodes.Classic;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */

@ScriptManifest(category = Category.RUNECRAFTING, name = "FRCron RC", author = "FRC & Articron", version = 0.01D)
public class Script extends AbstractScript{

    private AltarType chosenType;

    private BaseNode baseNode = new BaseNode(this);

    /**
     * debug -> change this if you want to test abyss stuff
     */
    private final boolean ABYSS = false;

    public void onStart() {
        chosenType = AltarType.AIR_ALTAR;
        baseNode.add((ABYSS) ? new Abyss(this) : new Classic(this,chosenType));
    }

    @Override
    public int onLoop() {
        return 0;
    }
}
