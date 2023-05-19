package befaster.solutions.CHK.CHK_2;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

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

    public Rule getRule() {
        return rule;
    }

    public Sku setRule(Rule newRule) {
        this.rule = newRule;
        return this;
    }

    public int getPriority() {
        if (rule == null) return 100;
        return rule.priority();
    }

    public int caclulate(int total, Supplier<Map<String, Integer>> skusByCount) {
        if (rule != null) {
            return rule.solve(new SkuCalculation(code, total, cost), skusByCount);
        }
        return total * cost;
    }
}
