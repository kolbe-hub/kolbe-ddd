package net.kolbe.lottery.domain.aggregate;

import net.kolbe.lottery.domain.valueobject.AwardPool;
import net.kolbe.lottery.domain.valueobject.DrawLotteryContext;
import net.kolbe.lottery.domain.valueobject.MtCifyInfo;

import java.util.List;

public class DrawLottery {

    private int lotteryId; //抽奖id
    private List<AwardPool> awardPools; //奖池列表

    //getter & setter
    public void setLotteryId(int lotteryId) {
        if (lotteryId <= 0) {
            throw new IllegalArgumentException("非法的抽奖id");
        }
        this.lotteryId = lotteryId;
    }

    //根据抽奖入参context选择奖池
    public AwardPool chooseAwardPool(DrawLotteryContext context) {
        if (context.getCityInfo() != null) {
            return chooseAwardPoolByCityInfo(awardPools, context.getCityInfo());
        } else {
            return chooseAwardPoolByScore(awardPools, context.getGameScore());
        }
    }

    //根据抽奖所在城市选择奖池
    private AwardPool chooseAwardPoolByCityInfo(List<AwardPool> awardPools, MtCifyInfo cityInfo) {
        for (AwardPool awardPool : awardPools) {
            if (awardPool.matchedCity(cityInfo.getCityId())) {
                return awardPool;
            }
        }
        return null;
    }

    //根据抽奖活动得分选择奖池
    private AwardPool chooseAwardPoolByScore(List<AwardPool> awardPools, int gameScore) {
        return awardPools.get(0);
    }

}
