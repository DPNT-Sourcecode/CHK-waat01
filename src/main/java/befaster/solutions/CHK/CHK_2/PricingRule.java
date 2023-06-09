package befaster.solutions.CHK.CHK_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;

public final class PricingRule implements Rule {
    private final TreeMap<Integer, SinglePricingRule> rulesMap = new TreeMap<>(Comparator.reverseOrder());

    public PricingRule(Collection<SinglePricingRule> rules) {
        rules.forEach(rule -> rulesMap.put(rule.count(), rule));
    }

    public static PricingRule singleton(final int count, final int price) {
        return new PricingRule(Collections.singleton(new SinglePricingRule(count, price)));
    }

    public static PricingRule create(final int... items) {
        if (items.length % 2 != 0) throw new IllegalArgumentException("Cannot create");

        final List<SinglePricingRule> rules = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            rules.add(new SinglePricingRule(items[i], items[i + 1]));
            i++;
        }

        return new PricingRule(rules);
    }


    @Override
    public int priority() {
        return 2;
    }

    @Override
    public int solve(SkuCalculation calculation, Supplier<Map<String, Integer>> skusByCount) {
        if (rulesMap.isEmpty()) return calculation.total() * calculation.originalPrice();
        if (rulesMap.size() == 1) return rulesMap.firstEntry().getValue().solve(calculation, skusByCount);

        int runningTotal = calculation.total();
        int sum = 0;
        for (Map.Entry<Integer, SinglePricingRule> entry: rulesMap.entrySet()) {
            int ruleCount = entry.getKey();
            int timesTotalGoesInto = runningTotal / ruleCount;
            if (timesTotalGoesInto < 1) continue;

            int totalToSolve = timesTotalGoesInto * ruleCount;
            var pricingCalculation = new SkuCalculation(calculation.code(), totalToSolve, calculation.originalPrice());
            sum = sum + entry.getValue().solve(pricingCalculation, skusByCount);
            runningTotal = runningTotal - totalToSolve;
        }

        if (runningTotal > 0) {
            sum = sum + (runningTotal * calculation.originalPrice());
        }

        return sum;
    }
}
