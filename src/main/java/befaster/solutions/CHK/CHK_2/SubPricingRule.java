package befaster.solutions.CHK.CHK_2;

 class SubPricingRule implements Rule {

    private final int count;
    private final int price;

    public SubPricingRule(final int count, final int price) {
        this.count = count;
        this.price = price;
    }

    @Override
    public int solve(int total, int originalPrice) {
        return -1;
    }
}

