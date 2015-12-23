package org.frcron.running.nodes;

import com.frc.frc_api.node_framework.my_nodes.ChildNode;
import org.dreambot.api.methods.MethodContext;
import org.frcron.running.data.AltarType;
import org.frcron.util.APIContext;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public class ToAltar extends ChildNode {

    private AltarType type;

    public ToAltar(APIContext context, AltarType type) {
        super(context);
        this.type = type;
    }

    @Override
    public void execute() {
        context.getDreambot().getWalking().walk(type.getEntranceArea().getRandomTile());
    }

    @Override
    public boolean validate() {
        return true;
    }
}
