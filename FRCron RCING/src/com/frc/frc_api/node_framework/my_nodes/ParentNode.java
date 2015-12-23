package com.frc.frc_api.node_framework.my_nodes;


import com.frc.frc_api.node_framework.tags.optional.*;
import com.frc.frc_api.node_framework.tags.required.Node;
import org.dreambot.api.methods.MethodContext;
import org.frcron.util.APIContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public abstract class ParentNode extends ChildNode {

    private List<Node> nodeList = new ArrayList<>();
    private String status = "Script Startup";

    public ParentNode(APIContext context) {
        super(context);
        //initChildren();
    }

    @Override
    public void execute() {
        boolean blocked = false;
        for (Node node : new ArrayList<>(nodeList)) {
            if (!isBlocking(node) || !blocked){
                if (validates(node)){
                    if (!blocked && isBlocking(node)){
                        blocked = true;
                    }
                    if (node instanceof HasStatus){
                        status = ((HasStatus) node).getStatus();
                    }
                    if (node instanceof PrePost){
                        ((PrePost) node).onStart();
                    }
                    if (node instanceof Executeable){
                        ((Executeable) node).execute();
                    }
                    if (node instanceof PrePost){
                        ((PrePost) node).onFinish();
                    }
                    if (node instanceof SelfRemoving && ((SelfRemoving) node).shouldRemove()){
                        remove(node);
                    }
                }
            }

        }
    }

    public abstract void initChildren();

    @Override
    public boolean validate() {
        return conditions() && getFirstNode() != null;
    }

    public boolean conditions(){
        return true;
    }

    @Override
    public String getStatus() {
        return getClassName() + (status.equals("") ? "" : (":" + status));
    }

    public String getChildStatus(){
        return status;
    }

    private String getClassName(){
        return this.getClass().getSimpleName().equals("") ? "Unnamed" : this.getClass().getSimpleName();
    }

    private Node getFirstNode(){
        for (Node node : nodeList){
            if (node instanceof Validateable && ((Validateable) node).validate()){
                return node;
            }
        }
        return null;
    }


    public void sort(Comparator<Node> comparator){
        Collections.sort(nodeList, comparator);
    }

    public void remove(Node node){
        nodeList.remove(node);
    }

    private boolean isBlocking(Node node){
        return node instanceof Blocking;
    }

    private boolean validates(Node node){
        return !(node instanceof Validateable) || ((Validateable) node).validate();
    }

    public void add(Node node){
        nodeList.add(node);
    }

    public void addAll(Node... nodes){
        Collections.addAll(nodeList, nodes);
    }

    public int getSize(){
        return nodeList.size();
    }
}
