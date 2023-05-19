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
    public int solve(int total, int originalPrice, Collection<String> codes) {
        int currentSum = total * originalPrice;
        int timesPromotionIsApplied = (total / count);

        if (timesPromotionIsApplied > 0) {
            int timesSkuAppears = (int) codes.stream().filter( code -> code.equals(boGoSku.getCode())).count();
            if (timesSkuAppears > 0) {
                currentSum = (currentSum - (timesSkuAppears * boGoSku.getCost()));
            }
        }

        return currentSum;
    }
}
