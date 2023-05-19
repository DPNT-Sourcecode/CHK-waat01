package befaster.solutions.CHK.CHK_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class PricingRule implements Rule {
    private final TreeMap<Integer, SubPricingRule> rulesMap = new TreeMap<>(Comparator.reverseOrder());

    public PricingRule(Collection<SubPricingRule> rules) {
        rules.forEach(rule -> rulesMap.put(rule.getCount(), rule));
    }

    public static PricingRule singleton(final int count, final int price) {
        return new PricingRule(Collections.singleton(new SubPricingRule(count, price)));
    }

    public static PricingRule create(final int... items) {
        if (items.length % 2 != 0) throw new IllegalArgumentException("Cannot create");

        final List<SubPricingRule> rules = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            rules.add(new SubPricingRule(items[i], items[i + 1]));
            i++;
        }

        return new PricingRule(rules);
    }

    @Override
    public int solve(int total, int originalPrice) {
        if (rulesMap.isEmpty()) return total * originalPrice;
        if (rulesMap.size() == 1) return rulesMap.pollFirstEntry().getValue().solve(total, originalPrice);

        // Okay, so I need the
        for (Map.Entry<Integer, SubPricingRule> entry: rulesMap.entrySet()) {
            // We know the count. I need to know how manytimes this count is satisfied.
            // If its not satisfied, move to the next rule.
        }

        rulesMap.forEach((count, rulesMap) -> {

        });


        return -1;
//        int timesPromotionIsApplied = (total / count);
//
//        if (timesPromotionIsApplied <= 0) {
//            return total * originalPrice;
//        }
//
//        int promotional = timesPromotionIsApplied * price;
//        int remaining = total - (count * timesPromotionIsApplied);
//
//        return promotional + (remaining * originalPrice);
    }
}


