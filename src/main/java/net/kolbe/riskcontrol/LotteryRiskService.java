package net.kolbe.riskcontrol;

import net.kolbe.condition.facade.dto.RiskReq;
import net.kolbe.riskcontrol.domain.valueobject.RiskAccessToken;

public interface LotteryRiskService {

    RiskAccessToken accquire(RiskReq req);

}
