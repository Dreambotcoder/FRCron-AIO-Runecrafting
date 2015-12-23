package org.frcron.running.data;

import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public enum AltarType {

    AIR_ALTAR(
            new Area(new Tile(3018,3358,0), new Tile(3009,3353,0)),
            new Area(new Tile(2990,3295,0), new Tile(2981,3289,0)),
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
