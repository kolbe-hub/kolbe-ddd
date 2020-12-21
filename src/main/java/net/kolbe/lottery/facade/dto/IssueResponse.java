package net.kolbe.lottery.facade.dto;

import net.kolbe.lottery.domain.entity.PrizeInfo;

public class IssueResponse {

    private int code;

    private PrizeInfo prizeInfo;

    public int getCode() {
        return code;
    }

    public PrizeInfo getPrizeInfo() {
        return prizeInfo;
    }

    public static final int OK = 200;
}
