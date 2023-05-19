package befaster.solutions.CHK.CHK_2;

class SubPricingRule implements Rule {

    private final int count;
    private final int price;

    public SubPricingRule(final int count, final int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int solve(int total, int originalPrice) {
        int timesPromotionIsApplied = (total / count);

        if (timesPromotionIsApplied <= 0) {
            return total * originalPrice;
        }

        int promotional = timesPromotionIsApplied * price;
        int remaining = total - (count * timesPromotionIsApplied);

        return promotional + (remaining * originalPrice);
    }
}
