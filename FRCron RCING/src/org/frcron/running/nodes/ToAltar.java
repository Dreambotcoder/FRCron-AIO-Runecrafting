package org.frcron.running.nodes;

import com.frc.frc_api.node_framework.my_nodes.ChildNode;
import org.dreambot.api.methods.MethodContext;
import org.frcron.running.data.AltarType;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public class ToAltar extends ChildNode {

    private AltarType type;

    public ToAltar(MethodContext context,AltarType type) {
        super(context);
        this.type = type;
    }

    @Override
    public void execute() {
        context.getWalking().walk(type.getEntranceArea().getRandomTile());
    }

    @Override
    public boolean validate() {
        return true;
    }
}
