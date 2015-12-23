package com.frc.frc_api.node_framework.tags.optional;


/**
 * Created by zherridg on 7/10/2015.
 */
public interface Validateable {
    //Tags the node as validateable, no other actions will happen to the node if the return is not true.
    boolean validate();
}
