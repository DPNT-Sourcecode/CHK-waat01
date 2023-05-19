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

        int runningTotal = total;
        int sum = 0;
        for (Map.Entry<Integer, SubPricingRule> entry: rulesMap.entrySet()) {
            int ruleCount = entry.getKey();
            int timesTotalGoesInto = runningTotal / ruleCount;
            if (timesTotalGoesInto < 1) continue;

            int totalToSolve = timesTotalGoesInto * ruleCount;
            sum = sum + entry.getValue().solve(totalToSolve, originalPrice);
            runningTotal = runningTotal - totalToSolve;
        }

        if (runningTotal > 0) {
            sum = sum + (runningTotal * originalPrice);
        }

        return sum;
    }
}




