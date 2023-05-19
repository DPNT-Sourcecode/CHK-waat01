package befaster.solutions.CHK.CHK_2;

public class BoGoRule implements Rule {

    private final int count;
    private final int boGoValue;

    private final Sku boGoSku;

    public BoGoRule(final int count, final int boGoValue) {
        this.count = count;
        this.boGoValue = boGoValue;
        this.boGoSku = null;
    }

    public BoGoRule(final int count, final Sku boGoSku) {
        this.count = count;
        this.boGoSku = boGoSku;
        this.boGoValue = boGoSku.getCost();
    }


    @Override
    public int solve(int total, int originalPrice) {
        int timesPromotionIsApplied = (total / count);


        return total * originalPrice;
    }
}

