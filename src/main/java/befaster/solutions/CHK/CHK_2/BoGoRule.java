package befaster.solutions.CHK.CHK_2;

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
    public int solve(int total, int originalPrice, Iterator<Map.Entry<String, Integer>> codes) {
        int currentSum = total * originalPrice;
        int timesPromotionIsApplied = (total / count);

        // We have 2 E's and 2 B's.
        // The promotion is applied once, meaning the promotion is invalidated moving forward for B (in this case)
        if (timesPromotionIsApplied > 0) {
            int timesSkuAppears = 0;
            while (codes.hasNext()) {
                var entry = codes.next();
                if (entry.getKey().equals(boGoSku.getCode())) {
                    var totalInstances = entry.getValue();
                    if (timesPromotionIsApplied > totalInstances) {
                        codes.remove();
                    } else {
                        entry.setValue(totalInstances - timesPromotionIsApplied);
                    }
                }
            }

//            int temp = boGoSku.caclulate(timesSkuAppears, codes);
//            currentSum = currentSum - (temp);
//
//
//            if (timesSkuAppears > timesPromotionIsApplied) {
//
//                currentSum = currentSum - (temp);
//            }
//            if (timesSkuAppears == timesPromotionIsApplied) {
////                int temp = boGoSku.caclulate(timesSkuAppears, codes);
//                currentSum = (currentSum - (temp));
//            }
        }

        return currentSum;
    }
}
