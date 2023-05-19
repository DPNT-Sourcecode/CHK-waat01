package befaster.solutions.CHK.CHK_2;

import java.util.Map;
import java.util.function.Supplier;

public class BoGNSelfRule extends BoGNRule {

    public BoGNSelfRule(final int n, final int count, final Sku boGoSku) {
        super(n, count, boGoSku);
    }

    public BoGNSelfRule(final int n, final int count, final String code) {
        super(n, count, code);
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public int solve(SkuCalculation calculation, Supplier<Map<String, Integer>> skusByCount) {
        int currentSum = 0;
        if (getSkuCode().equals(calculation.code())) {
            currentSum = calculation.total() * calculation.originalPrice();
            int timesPromotionIsApplied = (calculation.total() / getCount()) * getN();

//            int other = ;

            if (calculation.total() % getCount() > 0) {
                currentSum = currentSum - (timesPromotionIsApplied * calculation.originalPrice());
            }
        }
        return currentSum;
    }
}

