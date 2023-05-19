package befaster.solutions;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChkTest {

    @Test
    void testThings() {
        String sku1 = "AAA";
        String sku2 = "AAAAB";
        String sku3 = "AAAAAAABB";
        CheckoutSolution solution = new CheckoutSolution();

//        Integer solved1 = solution.checkout(sku1);
//        Integer solved2 = solution.checkout(sku2);
//        Integer solved3 = solution.checkout(sku3);
//        Integer solved4 = solution.checkout("a");
//        Integer solved5 = solution.checkout("-");
//        Integer solved6 = solution.checkout("ABCa");
        Integer solvedE = solution.checkout("E");
        Integer solvedABCDE = solution.checkout("ABCDE");
        Integer solvedEE = solution.checkout("EE");

        int solvedEEB = solution.checkout("EEB");
        int solvedEEEB = solution.checkout("EEEB");
        int solvedEEB = solution.checkout("EEB");
//        Integer solved2 = solution.checkout("AAAAAAAA");
//        Integer solved3 = solution.checkout("AAAAAAAAA");

        assertEquals(40, solvedE);
        assertEquals(155, solvedABCDE);
        assertEquals(80, solvedEE);

        System.out.println();

    }
}

