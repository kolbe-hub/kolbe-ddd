package net.kolbe.lottery.service.impl;

import net.kolbe.lottery.domain.aggregate.DrawLottery;
import net.kolbe.lottery.domain.valueobject.Award;
import net.kolbe.lottery.domain.valueobject.AwardPool;
import net.kolbe.lottery.domain.valueobject.DrawLotteryContext;
import net.kolbe.counter.facade.AwardCounterFacade;
import net.kolbe.lottery.facade.UserCityInfoFacade;
import net.kolbe.lottery.facade.dto.AwardSendResponse;
import net.kolbe.lottery.facade.dto.IssueResponse;
import net.kolbe.lottery.repository.DrawLotteryRepository;
import net.kolbe.lottery.service.AwardSendService;
import net.kolbe.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotteryServiceImpl implements LotteryService {

    @Autowired
    private DrawLotteryRepository drawLotteryRepo;
    @Autowired
    private UserCityInfoFacade UserCityInfoFacade;
    @Autowired
    private AwardSendService awardSendService;
    @Autowired
    private AwardCounterFacade awardCounterFacade;

    @Override
    public IssueResponse issueLottery(DrawLotteryContext lotteryContext) {
        DrawLottery drawLottery = drawLotteryRepo.getDrawLotteryById(lotteryContext.getLotteryId());//获取抽奖配置聚合根
        awardCounterFacade.incrTryCount(lotteryContext);//增加抽奖计数信息
        AwardPool awardPool = drawLottery.chooseAwardPool(lotteryContext);//选中奖池
        Award award = awardPool.randomGetAward();//选中奖品
        return buildIssueResponse(awardSendService.sendAward(award, lotteryContext));//发出奖品实体
    }

    private IssueResponse buildIssueResponse(AwardSendResponse awardSendResponse) {
        return null;
    }

}
