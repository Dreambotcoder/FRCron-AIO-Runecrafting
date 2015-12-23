package com.frc.frc_api.node_framework.my_nodes;



import com.frc.frc_api.node_framework.tags.optional.*;
import com.frc.frc_api.node_framework.tags.required.Node;
import org.dreambot.api.methods.MethodContext;
import org.frcron.util.APIContext;

/**
 * Created by zherridg on 7/10/2015.
 */
public abstract class ChildNode implements Node, Blocking, Executeable, Validateable, HasStatus, PrePost {

    private String status = "";
    protected APIContext context;

    public ChildNode(APIContext context) {
        this.context = context;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return getClassName() + (status.equals("") ? "" : (":" + status));
    }

    private String getClassName(){
        return this.getClass().getSimpleName().equals("") ? "Unnamed" : this.getClass().getSimpleName();
    }

    @Override
    public void onStart() {

    }
    @Override
    public void onFinish() {

    }
}
