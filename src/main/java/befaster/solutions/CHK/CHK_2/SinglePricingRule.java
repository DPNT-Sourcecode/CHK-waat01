package befaster.solutions.CHK.CHK_2;

import java.util.Map;
import java.util.function.Supplier;

public record SinglePricingRule(int count, int price) implements Rule {

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public int solve(SkuCalculation calculation, Supplier<Map<String, Integer>> skusByCount) {
        int timesPromotionIsApplied = (calculation.total() / count);

        if (timesPromotionIsApplied <= 0) {
            return calculation.total() * calculation.originalPrice();
        }

        int promotional = timesPromotionIsApplied * price;
        int remaining = calculation.total() - (count * timesPromotionIsApplied);

        return promotional + (remaining * calculation.originalPrice());
    }
}
