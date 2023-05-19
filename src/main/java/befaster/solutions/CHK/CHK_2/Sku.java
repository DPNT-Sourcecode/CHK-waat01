package befaster.solutions.CHK.CHK_2;

import java.util.Collection;
import java.util.Set;

public class Sku {
    private final String code;
    private final int cost;
    private Rule rule;

    public Sku(final String code, final int cost) {
        this.code = code;
        this.cost = cost;
        rule = null;
    }

    public Sku(final String code, final int cost, final Rule rule) {
        this.code = code;
        this.cost = cost;
        this.rule = rule;
    }

    public String getCode() {
        return code;
    }

    public int getCost() {
        return cost;
    }

    public Sku setRule(Rule newRule) {
        this.rule = newRule;
        return this;
    }

    public int caclulate(int total, Collection<String> otherSkus) {
        if (rule != null) {
            return rule.solve(total, cost, otherSkus);
        }
        return total * cost;
    }
}
