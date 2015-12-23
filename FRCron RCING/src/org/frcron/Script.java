package org.frcron;

import com.frc.frc_api.node_framework.my_nodes.BaseNode;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.frcron.abyss.Abyss;
import org.frcron.running.data.AltarType;
import org.frcron.running.nodes.Classic;
import org.frcron.util.APIContext;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */

@ScriptManifest(category = Category.RUNECRAFTING, name = "FRCron RC", author = "FRC & Articron", version = 0.01D)
public class Script extends AbstractScript{


    private APIContext api = new APIContext(this);
    private BaseNode baseNode = new BaseNode(api);
    /**
     * debug -> change this if you want to test abyss stuff
     */
    private final boolean ABYSS = false;

    public void onStart() {
        baseNode.add((ABYSS) ? new Abyss(api) : new Classic(api,AltarType.AIR_ALTAR));
    }

    @Override
    public int onLoop() {
        baseNode.execute();
        return 0;
    }
}
