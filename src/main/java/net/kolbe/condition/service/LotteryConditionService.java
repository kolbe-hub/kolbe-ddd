package net.kolbe.condition.service;

import net.kolbe.condition.domain.valueobject.LotteryConditionResult;

public interface LotteryConditionService {

    LotteryConditionResult checkLotteryCondition(int lotteryId, int userId);
}
