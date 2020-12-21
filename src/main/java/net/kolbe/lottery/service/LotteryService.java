package net.kolbe.lottery.service;

import net.kolbe.lottery.domain.valueobject.DrawLotteryContext;
import net.kolbe.lottery.facade.dto.IssueResponse;

public interface LotteryService {

    IssueResponse issueLottery(DrawLotteryContext lotteryContext);

}
