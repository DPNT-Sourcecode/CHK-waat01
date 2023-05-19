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

        // We have 2 E's and 2 B's.
        // The promotion is applied once, meaning the promotion is invalidated moving forward for B (in this case)
        if (timesPromotionIsApplied > 0) {
            int timesSkuAppears = (int) codes.stream().filter( code -> code.equals(boGoSku.getCode())).count();

            int temp = boGoSku.caclulate(timesSkuAppears, codes);
            // The sku appears 3 times and the promotion is only applied once.
            if (timesSkuAppears > timesPromotionIsApplied) {

                currentSum = currentSum - (temp);
            }
            if (timesSkuAppears == timesPromotionIsApplied) {
//                int temp = boGoSku.caclulate(timesSkuAppears, codes);
                currentSum = (currentSum - (temp));
            }
        }

        return currentSum;
    }
}


