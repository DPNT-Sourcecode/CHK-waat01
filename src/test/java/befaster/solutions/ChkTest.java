package befaster.solutions;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChkTest {

    @Test
    void testThings() {
        CheckoutSolution solution = new CheckoutSolution();

        Integer solvedE = solution.checkout("E");
        Integer solvedABCDE = solution.checkout("ABCDE");
        Integer solvedEE = solution.checkout("EE");

        int solvedEEB = solution.checkout("EEB");
        int solvedEEEB = solution.checkout("EEEB");
        int solvedEEEEBB = solution.checkout("EEEEBB");

        assertEquals(40, solvedE);
        assertEquals(155, solvedABCDE);
        assertEquals(80, solvedEE);
        assertEquals(80, solvedEEB);
        assertEquals(120, solvedEEEB);
        assertEquals(160, solvedEEEEBB);

        System.out.println();
    }

    @Test
    void next() {
        CheckoutSolution solution = new CheckoutSolution();

        int solutionABCDEABCDE = solution.checkout("ABCDEABCDE");
        int solutionAAAAAEEBAAABB = solution.checkout("AAAAAEEBAAABB");
//        int solutionCCADDEEBBA = solution.checkout("CCADDEEBBA");

        assertEquals(280, solutionABCDEABCDE);
//        assertEquals(280, solutionCCADDEEBBA);
//        assertEquals(455, solutionAAAAAEEBAAABB);
        System.out.println();
    }
}
