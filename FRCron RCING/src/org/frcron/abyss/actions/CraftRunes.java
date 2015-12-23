package org.frcron.abyss.actions;

import com.frc.frc_api.node_framework.my_nodes.ChildNode;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.frcron.util.APIContext;

/**
 * Created by zach on 12/23/2015.
 */
public class CraftRunes extends ChildNode {

    private Tile alterTile = new Tile(2401, 4843);

    public CraftRunes(APIContext context) {
        super(context);
    }

    @Override
    public void execute() {
        GameObject altar = context.getFRC().getNearestGameObject("Altar");
        if (altar != null){
            altar.interact("Craft-rune");
        }
    }

    @Override
    public boolean validate() {
        return alterTile.distance() <= 15 && context.getDreambot().getInventory().contains("Pure essence");
    }
}
