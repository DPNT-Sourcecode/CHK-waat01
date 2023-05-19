package befaster.solutions;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.jupiter.api.Test;

public class ChkTest {

    @Test
    void testThings() {
        String sku1 = "AAA";
        String sku2 = "AAAAB";
        String sku3 = "AAAAAAABB";
        CheckoutSolution solution = new CheckoutSolution();

//        Integer solved1 = solution.checkout(sku1);
//        Integer solved2 = solution.checkout(sku2);
        Integer solved3 = solution.checkout(sku3);

        System.out.println();

    }
}


