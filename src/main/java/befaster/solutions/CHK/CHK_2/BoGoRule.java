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

        }

        return currentSum;
    }
}

