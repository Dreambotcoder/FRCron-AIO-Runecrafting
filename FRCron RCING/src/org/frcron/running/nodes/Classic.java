package org.frcron.running.nodes;

import com.frc.frc_api.node_framework.my_nodes.ParentNode;
import org.frcron.running.data.AltarType;
import org.frcron.util.APIContext;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public class Classic extends ParentNode {

    private AltarType type;

    public Classic(APIContext context, AltarType type) {
        super(context);
        this.type = type;
        initChildren();
    }

    @Override
    public void initChildren() {
        addAll(new ToAltar(context,this.type));
    }
}
