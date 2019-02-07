package org.pursuit.implicitintentsfromscratch.model;

import java.util.List;

public class ZodiacList {

    private List<ZodiacModel> zodiac;

    public ZodiacList(List<ZodiacModel> zodiac) {
        this.zodiac = zodiac;
    }

    public List<ZodiacModel> getZodiac() {
        return zodiac;
    }

    public void setZodiac(List<ZodiacModel> zodiac) {
        this.zodiac = zodiac;
    }
}
