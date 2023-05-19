package befaster.solutions.CHK.CHK_2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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
                // So we have a promotion and we have the total number of codes.
                // No we need to simulate negation of the total cost.
                if (boGoSku is SubPricingRule) {

                }

                var temp = boGoSku.caclulate(totalCodesFound - timesPromotionIsApplied, codes);
                currentSum = currentSum - temp;
            }
        }

        return currentSum;
    }
}





