package org.frcron.running.data;

import org.dreambot.api.methods.map.Area;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public enum AltarType {

    AIR_ALTAR(
            new Area(3018, 3358, 3009, 3353),
            new Area(2990, 3295, 2981, 3289),
            EntranceObject.AIR_ALTAR
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
