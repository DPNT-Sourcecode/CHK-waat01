package befaster.solutions.CHK.CHK_2;

import java.util.Collection;

public record SinglePricingRule(int count, int price) implements Rule {

    @Override
    public int solve(final int total, final int originalPrice, final Collection<String> codes) {
        int timesPromotionIsApplied = (total / count);

        if (timesPromotionIsApplied <= 0) {
            return total * originalPrice;
        }

        int promotional = timesPromotionIsApplied * price;
        int remaining = total - (count * timesPromotionIsApplied);

        return promotional + (remaining * originalPrice);
    }
}

