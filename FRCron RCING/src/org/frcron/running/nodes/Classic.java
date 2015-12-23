package org.frcron.running.nodes;

import com.frc.frc_api.node_framework.my_nodes.ParentNode;
import org.dreambot.api.methods.MethodContext;
import org.frcron.running.data.AltarType;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public class Classic extends ParentNode {

    private AltarType type;

    public Classic(MethodContext context, AltarType type) {
        super(context);
        this.type = type;
    }

    @Override
    public void initChildren() {
        addAll(new ToAltar(context,type));
    }
}
