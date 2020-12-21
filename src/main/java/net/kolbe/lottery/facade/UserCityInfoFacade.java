package net.kolbe.lottery.facade;

import net.kolbe.lottery.domain.valueobject.DrawLotteryContext;
import net.kolbe.lottery.domain.valueobject.MtCifyInfo;
import net.kolbe.lottery.facade.dto.LbsReq;
import net.kolbe.lottery.facade.dto.LbsResponse;
import net.kolbe.lottery.facade.service.LbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCityInfoFacade {

    @Autowired
    private LbsService lbsService;//外部用户城市信息RPC服务

    public MtCifyInfo getMtCityInfo(DrawLotteryContext context) {
        LbsReq lbsReq = new LbsReq();
        lbsReq.setLat(context.getLat());
        lbsReq.setLng(context.getLng());
        LbsResponse resp = lbsService.getLbsCityInfo(lbsReq);
        return buildMtCityInfo(resp);
    }

    private MtCifyInfo buildMtCityInfo(LbsResponse resp) {
        return null;
    }


}
