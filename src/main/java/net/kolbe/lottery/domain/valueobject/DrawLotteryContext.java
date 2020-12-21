package net.kolbe.lottery.domain.valueobject;

import java.math.BigDecimal;

public class DrawLotteryContext {

    private int lotteryId;

    private int userId;

    private MtCifyInfo cityInfo;

    private int gameScore;

    private BigDecimal lng;

    private BigDecimal lat;

    public MtCifyInfo getCityInfo() {
        return cityInfo;
    }

    public int getGameScore() {
        return gameScore;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public int getLotteryId() {
        return lotteryId;
    }

    public int getUserId() {
        return userId;
    }
}
