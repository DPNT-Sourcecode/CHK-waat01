package befaster.solutions.CHK.CHK_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class PricingRule implements Rule {
    private final Collection<SubPricingRule> rules;

    public PricingRule(Collection<SubPricingRule> rules) {
        this.rules = rules;
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
        return -1;
    }
}
