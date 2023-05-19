package befaster.solutions.CHK.CHK_2;

import java.util.Map;
import java.util.function.Supplier;

public class BoGNRule implements Rule {

    private final int n;
    private final int count;
    private final Sku sku;

    public BoGNRule(final int n, final int count, final Sku boGoSku) {
        this.n = n;
        this.count = count;
        this.sku = boGoSku;
    }

    public BoGNRule(final int n, final int count, final String code) {
        this(n, count, new Sku(code, 0));
    }

    @Override
    public int priority() {
        return 1;
    }

    String getSkuCode() {
        return sku.getCode();
    }

    int getN() {
        return n;
    }

    int getCount() {
        return count;
    }

    @Override
    public int solve(SkuCalculation calculation, Supplier<Map<String, Integer>> skusByCount) {
        int currentSum = calculation.total() * calculation.originalPrice();
        int timesPromotionIsApplied = (calculation.total() / count) * n;

        // We have 2 E's and 2 B's.
        // The promotion is applied once, meaning the promotion is invalidated moving forward for B (in this case)
        if (timesPromotionIsApplied > 0) {
            var map = skusByCount.get();
            map.computeIfPresent(sku.getCode(), (k, v) -> (v > timesPromotionIsApplied) ? v - timesPromotionIsApplied : 0);
        }

        return currentSum;
    }
}
