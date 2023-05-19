package befaster.solutions;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.jupiter.api.Test;

public class ChkTest {

    @Test
    void testThings() {
        String sku = "AAA";
        CheckoutSolution solution = new CheckoutSolution();

        Integer solved = solution.checkout(sku);
        
    }
}
