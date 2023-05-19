package befaster.solutions.CHK.CHK_2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;

public record SinglePricingRule(int count, int price) implements Rule {

    @Override
    public int priority() {
        return 20;
    }

    @Override
    public int solve(final int total, final int originalPrice, Supplier<Map<String, Integer>> skusByCount) {
        int timesPromotionIsApplied = (total / count);

        if (timesPromotionIsApplied <= 0) {
            return total * originalPrice;
        }

        int promotional = timesPromotionIsApplied * price;
        int remaining = total - (count * timesPromotionIsApplied);

        return promotional + (remaining * originalPrice);
    }
}
