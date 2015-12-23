package org.frcron.util;

import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.interactive.Locatable;
import org.dreambot.api.wrappers.interactive.NPC;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zach on 12/23/2015.
 */
public class FrcUtil {

    private final MethodContext context;

    private final Comparator<Locatable> NEAREST = new Comparator<Locatable>() {
        @Override
        public int compare(Locatable o1, Locatable o2) {
            return (int) (o1.distance(context.getLocalPlayer().getTile()) - o2.distance(context.getLocalPlayer().getTile()));
        }
    };

    public FrcUtil(MethodContext context) {
        this.context = context;
    }

    public GameObject getNearestGameObject(String name){
        return getNearestGameObject(name, "");
    }
    public GameObject getNearestGameObject(String name, String action){
        List<GameObject> all = context.getGameObjects().all(new Filter<GameObject>() {
            @Override
            public boolean match(GameObject gameObject) {
                if (name.isEmpty() || gameObject.getName().equalsIgnoreCase(name)){
                    if (action.isEmpty() || gameObject.hasAction(action)){
                        return true;
                    }
                }
                return false;
            }
        });
        all.sort(NEAREST);
        return all.get(0);
    }

    public NPC getNearestNPC(String name){
        return getNearestNPC(name, "");
    }
    public NPC getNearestNPC(String name, String action){
        List<NPC> all = context.getNpcs().all(new Filter<NPC>() {
            @Override
            public boolean match(NPC npc) {
                if (name.isEmpty() || npc.getName().equalsIgnoreCase(name)){
                    if (action.isEmpty() || npc.hasAction(action)){
                        return true;
                    }
                }
                return false;
            }
        });
        all.sort(NEAREST);
        return all.get(0);
    }

}
