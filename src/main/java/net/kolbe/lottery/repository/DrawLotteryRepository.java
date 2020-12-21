package net.kolbe.lottery.repository;

import net.kolbe.lottery.domain.aggregate.DrawLottery;
import net.kolbe.lottery.repository.dao.AwardDao;
import net.kolbe.lottery.repository.dao.AwardPoolDao;
import net.kolbe.lottery.repository.dao.DrawLotteryCacheAccessObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DrawLotteryRepository {

    @Autowired
    private AwardDao awardDao;
    @Autowired
    private AwardPoolDao awardPoolDao;
    @Autowired
    private DrawLotteryCacheAccessObj drawLotteryCacheAccessObj;

    public DrawLottery getDrawLotteryById(int lotteryId) {
        DrawLottery drawLottery = drawLotteryCacheAccessObj.get(lotteryId);
        if(drawLottery!=null){
            return drawLottery;
        }
        drawLottery = getDrawLotteryFromDB(lotteryId);
        drawLotteryCacheAccessObj.add(lotteryId, drawLottery);
        return drawLottery;
    }

    private DrawLottery getDrawLotteryFromDB(int lotteryId) {
        return null;
    }

}
