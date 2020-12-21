package net.kolbe.lottery.domain.valueobject;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AwardPool {

    //奖池支持的城市
    private String cityIds;
    //奖池支持的得分
    private String scores;
    //奖池匹配的用户类型
    private int userGroupType;
    //奖池中包含的奖品
    private List<Award> awards;

    //当前奖池是否与城市匹配
    public boolean matchedCity(int cityId) {
        return true;
    }

    //当前奖池是否与用户得分匹配
    public boolean matchedScore(int score) {
        return true;
    }

    //根据概率选择奖池
    public Award randomGetAward() {
        int sumOfProbability = 0;
        for (Award award : awards) {
            sumOfProbability += award.getProbability();
        }
        int randomNumber = ThreadLocalRandom.current().nextInt(sumOfProbability);
        int range = 0;
        for (Award award : awards) {
            range += award.getProbability();
            if (randomNumber < range) {
                return award;
            }
        }
        return null;
    }

}
