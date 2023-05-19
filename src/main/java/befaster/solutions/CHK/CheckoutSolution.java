package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static jdk.internal.net.http.SocketTube.listOf;

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
        if (skus == null) return -1;
        if (skus.isEmpty()) return 0;

        final Map<String, Integer> checkout = new HashMap<>();
        checkout.put("A", 50);
        checkout.put("B", 30);
        checkout.put("C", 20);
        checkout.put("D", 15);

        final Map<String, Rule> rules = new HashMap<>();
        rules.put("A", new Rule("A", 3, 130));
        rules.put("B", new Rule("B", 2, 45));

        final Map<String, Integer> skuCount = new HashMap<>();

        for (int i = 0; i < skus.length(); i++) {
            skuCount.compute(String.valueOf(skus.charAt(i)), (k,  v) -> (v == null) ? 1 : v + 1);
        }

        AtomicReference<Integer> sum = new AtomicReference<>(0);
        skuCount.forEach((sku, count) -> {
            if (checkout.containsKey(sku)) {
                if (rules.containsKey(sku)) {
                    Integer priceForOne = checkout.get(sku);
                    Rule rule = rules.get(sku);
                    sum.set(sum.get() + rule.getCost(count, priceForOne));
                }
                else {
                    sum.set(sum.get() + checkout.get(sku) * count);
                }
            }
        });

        return sum.get();
    }

    class Rule {

        private final String sku;
        private final Integer count;
        private final Integer price;

        public Rule(final String sku, final Integer count, final Integer price) {
            this.sku = sku;
            this.count = count;
            this.price = price;
        }

        public Integer getCost(final Integer total, final Integer originalPrice) {
            // I need to know how many times this promotion is counted.
            // Add the remaining number by the original price

            
            return -1;
        }
    }
}




