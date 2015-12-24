package org.frcron.running.data;

import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.web.node.impl.bank.WebBankArea;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public enum AltarType {

    AIR_ALTAR(
            WebBankArea.FALADOR_EAST.getArea(),
            new Area(2990, 3295, 2981, 3289),
            EntranceObject.AIR_ALTAR
    ),

    MIND_ALTAR(
            WebBankArea.FALADOR_WEST.getArea(),
            new Area(2986,3518,2978,3511),
            null
    ),

    /**
     *  TODO
     */

    FIRE_ALTAR_NO_RING(
            WebBankArea.DUEL_ARENA.getArea(),
            null,
            null
    ),

    FIRE_ALTAR_RING(
            WebBankArea.CASTLE_WARS.getArea(),
            null,
            null
    );


    AltarType(Area bankArea, Area entranceArea, EntranceObject entranceObject) {
        this.bankArea = bankArea;
        this.entranceArea = entranceArea;
        this.entranceObject = entranceObject;
    }

    private Area bankArea;
    private Area entranceArea;
    private EntranceObject entranceObject;

    public Area getBankArea() {
        return bankArea;
    }

    public Area getEntranceArea() {
        return entranceArea;
    }

    public EntranceObject getEntranceObjects() {
        return entranceObject;
    }

}
