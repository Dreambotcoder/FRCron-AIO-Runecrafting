package org.frcron.util;

import org.dreambot.api.Client;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.wrappers.items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        24/12/2015
 */
public class CacheBank extends Bank {

    private List<Item> bankMap;

    public CacheBank(Client client) {
        super(client);
        bankMap = new ArrayList<>();
    }

    public boolean open() {
        if (super.open())
            return updateCache();
        return false;
    }

    private boolean updateCache() {
        bankMap.clear();
        bankMap.addAll(super.all());
        bankMap.stream().filter(i -> i != null).forEach(i -> MethodProvider.log(i.getName() + " -> x" + i.getAmount()));
        return true;
    }

    public Item[] getCachedItems() {
        return bankMap.toArray(new Item[bankMap.size()]);
    }
}
