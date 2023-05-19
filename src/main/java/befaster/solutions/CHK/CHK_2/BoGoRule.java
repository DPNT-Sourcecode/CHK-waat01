package befaster.solutions.CHK.CHK_2;

public class BoGoRule implements Rule {

    private final int count;
    private final int boGoValue;

    public BoGoRule(final int count, final int boGoValue) {
        this.count = count;
        this.boGoValue = boGoValue;
    }

    @Override
    public int solve(int total, int originalPrice) {
        return -1;
    }
}
