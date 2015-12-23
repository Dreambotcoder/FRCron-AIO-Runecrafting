package com.frc.frc_api.node_framework.tags.optional;

/**
 * Created by zherridg on 7/22/2015.
 */
public interface PrePost {
    //Tags the node as having a pre/post execution
    void onStart();
    void onFinish();
}
