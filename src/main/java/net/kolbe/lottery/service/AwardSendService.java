package net.kolbe.lottery.service;

import net.kolbe.lottery.domain.valueobject.Award;
import net.kolbe.lottery.domain.valueobject.DrawLotteryContext;
import net.kolbe.lottery.facade.dto.AwardSendResponse;

public interface AwardSendService {

    AwardSendResponse sendAward(Award award, DrawLotteryContext context);

}
