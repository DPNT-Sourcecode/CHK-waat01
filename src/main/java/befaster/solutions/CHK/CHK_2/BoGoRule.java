package befaster.solutions.CHK.CHK_2;

public class BoGoRule extends BoGNRule {

    public BoGoRule(final int count, final Sku boGoSku) {
        super(1, count, boGoSku);
    }

    public BoGoRule(final int count, final String code) {
        super(1, count, code);
    }
}
