package befaster.solutions.CHK.CHK_2;

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
        return new Sku(this.code, this.cost, newRule);
    }

    public int caclulate(int total) {
        if (rule != null) {
            return rule.solve(total, cost);
        }
        return total * cost;
    }
}

