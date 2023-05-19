package befaster.solutions.CHK.CHK_2;

import java.util.Collection;

public class BoGoRule implements Rule {

    private final int count;
    private final Sku boGoSku;

    public BoGoRule(final int count, final Sku boGoSku) {
        this.count = count;
        this.boGoSku = boGoSku;
    }


    @Override
    public int solve(final int total, final int originalPrice, final Collection<String> codes) {
        int currentSum = total * originalPrice;
        int timesPromotionIsApplied = (total / count);

        // We have 2 E's and 2 B's.
        // The promotion is applied once, meaning the promotion is invalidated moving forward for B (in this case)
        if (timesPromotionIsApplied > 0) {
            var totalCodesFound = (int) codes.stream().filter(code -> code.equals(boGoSku.getCode())).count();
            if (totalCodesFound > 0) {
                var bogoRule = boGoSku.getRule();
                var temp = 0;
                if (bogoRule == null) {
                    // There is no calculation. Return the times promotion is applied to the codes cost
                    temp = (timesPromotionIsApplied * boGoSku.getCost());
                }
                // So we have a promotion and we have the total number of codes.
                // No we need to simulate negation of the total cost.
                else if (bogoRule instanceof SinglePricingRule) {
                    var tempRole = (SinglePricingRule) bogoRule;
                    var additional = totalCodesFound - timesPromotionIsApplied;

//                    temp = boGoSku.caclulate(totalCodesFound, codes) + (additional * tempRole.price());
                }
                else {
                    temp = boGoSku.caclulate(totalCodesFound, codes);
                }
                currentSum = currentSum - temp;
            }
        }

        return currentSum;
    }
}








