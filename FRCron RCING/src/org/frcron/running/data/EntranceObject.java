package org.frcron.running.data;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        23/12/2015
 */
public enum EntranceObject {

    AIR_ALTAR(
            "Air talisman",
            "Air tiara"
    );

    EntranceObject(String talisman, String tiara) {
        this.talisman = talisman;
        this.tiara = tiara;
    }

    private String talisman;
    private String tiara;

    private String getTalismanName() {
        return talisman;
    }

    public String getTiaraName() {
        return tiara;
    }
}
