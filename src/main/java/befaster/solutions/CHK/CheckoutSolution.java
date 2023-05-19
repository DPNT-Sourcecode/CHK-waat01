package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CheckoutSolution {

    /*
    CHK_R1
ROUND 1 - Our supermarket
The purpose of this challenge is to implement a supermarket checkout that calculates the total price of a number of items.

In a normal supermarket, things are identified using Stock Keeping Units, or SKUs.
In our store, we'll use individual letters of the alphabet (A, B, C, and so on).
Our goods are priced individually. In addition, some items are multi-priced: buy n of them, and they'll cost you y pounds.
For example, item A might cost 50 pounds individually, but this week we have a special offer:
 buy three As and they'll cost you 130.

Our price table and offers:
+------+-------+----------------+
| Item | Price | Special offers |
+------+-------+----------------+
| A    | 50    | 3A for 130     |
| B    | 30    | 2B for 45      |
| C    | 20    |                |
| D    | 15    |                |
+------+-------+----------------+


Notes:
 - For any illegal input return -1

In order to complete the round you need to implement the following method:
     checkout(String) -> Integer

Where:
 - param[0] = a String containing the SKUs of all the products in the basket
 - @return = an Integer representing the total checkout value of the items

     */




    public Integer checkout(String skus) {

//        if (skus == null || skus.isEmpty()) return -1;

        if (skus == null) return -1;
        if (skus.isEmpty()) return 0;

        final Map<String, Integer> checkout = new HashMap<>();
        checkout.put("A", 50);
        checkout.put("B", 30);
        checkout.put("C", 20);
        checkout.put("D", 15);

        final Map<String, Integer> skuCount = new HashMap<>();

        for (int i = 0; i < skus.length(); i++) {
            skuCount.compute(String.valueOf(skus.charAt(i)), (k,  v) -> (v == null) ? 1 : v + 1);
        }

        Optional<Integer> aCount = Optional.ofNullable(skuCount.remove("A"));
        Optional<Integer> bCount = Optional.ofNullable(skuCount.remove("B"));

        return -1;
    }
}

