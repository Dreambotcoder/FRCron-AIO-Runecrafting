package com.frc.frc_api.node_framework.my_nodes;

import com.frc.frc_api.node_framework.tags.optional.Priority;
import com.frc.frc_api.node_framework.tags.required.Node;
import org.dreambot.api.methods.MethodContext;
import org.frcron.util.APIContext;

import java.util.Comparator;

/**
 * Created by zach on 9/4/2015.
 */
public abstract class PriorityNode extends ParentNode {

    private Comparator<Node> sort = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if ((o1 instanceof Priority) && (o2 instanceof Priority)){
                return ((Priority) o1).getPriority() - ((Priority) o2).getPriority();
            }
            else if (o1 instanceof Priority){
                return 1;
            }
            else {
                return -1;
            }
        }
    };

    public PriorityNode(APIContext context) {
        super(context);
    }

    @Override
    public void execute() {
        sort(sort);
        super.execute();
    }
}
