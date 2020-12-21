package net.kolbe.lottery.application;

import net.kolbe.condition.domain.valueobject.LotteryConditionResult;
import net.kolbe.condition.facade.dto.RiskReq;
import net.kolbe.condition.service.LotteryConditionService;
import net.kolbe.lottery.application.dto.ErrorData;
import net.kolbe.lottery.application.dto.Response;
import net.kolbe.lottery.application.dto.ResponseCode;
import net.kolbe.lottery.domain.entity.PrizeInfo;
import net.kolbe.lottery.domain.valueobject.DrawLotteryContext;
import net.kolbe.lottery.facade.dto.IssueResponse;
import net.kolbe.lottery.service.LotteryService;
import net.kolbe.riskcontrol.LotteryRiskService;
import net.kolbe.riskcontrol.domain.valueobject.RiskAccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LotteryApplicationService {
    @Autowired
    private LotteryRiskService riskService;
    @Autowired
    private LotteryConditionService conditionService;
    @Autowired
    private LotteryService lotteryService;

    //用户参与抽奖活动
    public Response<PrizeInfo, ErrorData> participateLottery(DrawLotteryContext lotteryContext) {
        //校验用户登录信息
        validateLoginInfo(lotteryContext);
        //校验风控
        RiskAccessToken riskToken = riskService.accquire(buildRiskReq(lotteryContext));
        //活动准入检查
        LotteryConditionResult conditionResult = conditionService.checkLotteryCondition(lotteryContext.getLotteryId(), lotteryContext.getUserId());
        //抽奖并返回结果
        IssueResponse issueResponse = lotteryService.issueLottery(lotteryContext);
        if (issueResponse != null && issueResponse.getCode() == IssueResponse.OK) {
            return buildSuccessResponse(issueResponse.getPrizeInfo());
        } else {
            return buildErrorResponse(ResponseCode.ISSUE_LOTTERY_FAIL, "error");
        }
    }

    private void validateLoginInfo(DrawLotteryContext lotteryContext) {

    }

    private Response<PrizeInfo, ErrorData> buildErrorResponse(int code, String msg) {
        return null;
    }

    private Response<PrizeInfo, ErrorData> buildSuccessResponse(PrizeInfo prizeInfo) {
        return null;
    }

    private RiskReq buildRiskReq(DrawLotteryContext context) {
        return null;
    }
}

