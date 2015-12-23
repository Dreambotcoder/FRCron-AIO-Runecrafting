package org.frcron.running.nodes;

import com.frc.frc_api.node_framework.my_nodes.ChildNode;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.frcron.running.data.AltarType;
import org.frcron.util.APIContext;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public class DoBank extends ChildNode {

    private AltarType type;

    public DoBank(APIContext context,AltarType type) {
        super(context);
        this.type = type;
    }

    @Override
    public void execute() {
        Bank bank = context.getDreambot().getBank();
        if (!bank.isOpen()) {
            if (bank.open()) {
                MethodProvider.sleepUntil(bank::isOpen, 5000);
            }
        }
        if (bank.isOpen()) {
            if (bank.depositAllItems()) {
                MethodProvider.sleepUntil(() -> context.getDreambot().getInventory().isEmpty(),5000);
            }
            if (context.getDreambot().getInventory().isEmpty()) {
                if (bank.withdrawAll("Pure essence")) {
                    MethodProvider.sleepUntil(() -> context.getDreambot().getInventory().contains("Pure essence"),5000);
                }
            }
            if (context.getDreambot().getBank().contains("Pure essence")) {
                bank.close();
            }
        }
    }

    @Override
    public boolean validate() {
        if (context.getDreambot().getInventory().contains("Pure essence")) {
            return false;
        }
        return type.getBankArea().contains(context.getDreambot().getLocalPlayer());
    }
}
