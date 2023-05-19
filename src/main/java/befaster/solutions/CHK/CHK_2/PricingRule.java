package befaster.solutions.CHK.CHK_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PricingRule implements Rule {
    private final Collection<SubPricingRule> rules;

    public PricingRule(Collection<SubPricingRule> rules) {
        this.rules = rules;
    }

    public static PricingRule singleton(final int count, final int price) {
        return new PricingRule(Collections.singleton(new SubPricingRule(count, price)));
    }

    @Override
    public int solve(int total, int originalPrice) {
        return -1;
    }
}

