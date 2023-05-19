package befaster.solutions.CHK;

import befaster.solutions.CHK.CHK_2.BoGoRule;
import befaster.solutions.CHK.CHK_2.PricingRule;
import befaster.solutions.CHK.CHK_2.Rule;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class CheckoutSolution {




    /*
    CHK_R2
ROUND 2 - More offers
The checkout feature is great and our supermarket is doing fine. Is time to think about growth.
Our marketing teams wants to experiment with new offer types and we should do our best to support them.

We are going to sell a new item E.
Normally E costs 40, but if you buy 2 of Es you will get B free. How cool is that ? Multi-priced items also seemed to work well so we should have more of these.

Our price table and offers:
+------+-------+------------------------+
| Item | Price | Special offers         |
+------+-------+------------------------+
| A    | 50    | 3A for 130, 5A for 200 |
| B    | 30    | 2B for 45              |
| C    | 20    |                        |
| D    | 15    |                        |
| E    | 40    | 2E get one B free      |
+------+-------+------------------------+


Notes:
 - The policy of the supermarket is to always favor the customer when applying special offers.
 - All the offers are well balanced so that they can be safely combined.
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
        checkout.put("E", 40);

        final Map<String, Rule> rules = new HashMap<>();
        rules.put("A", PricingRule.create(5, 200, 3, 130));
        rules.put("B", PricingRule.singleton (2, 45));
        rules.put("E", new BoGoRule(2, 30));

        final Map<String, Integer> skuCount = new HashMap<>();

        for (int i = 0; i < skus.length(); i++) {
            String singleSku = String.valueOf(skus.charAt(i));
            if (checkout.containsKey(singleSku)) {
                skuCount.compute(singleSku, (k,  v) -> (v == null) ? 1 : v + 1);
            }
            else return -1;
        }

        AtomicReference<Integer> sum = new AtomicReference<>(0);
        skuCount.forEach((sku, count) -> {
            if (checkout.containsKey(sku)) {
                if (rules.containsKey(sku)) {
                    Integer priceForOne = checkout.get(sku);
                    Rule rule = rules.get(sku);
                    sum.set(sum.get() + rule.solve(count, priceForOne));
                }
                else {
                    sum.set(sum.get() + checkout.get(sku) * count);
                }
            }
        });

        return sum.get();
    }

//    class Rule {
//
//        private final Integer count;
//        private final Integer price;
//
//        public Rule(final Integer count, final Integer price) {
//            this.count = count;
//            this.price = price;
//        }
//
//        public int getCost(final Integer total, final Integer originalPrice) {
//            // I need to know how many times this promotion is counted.
//            // Add the remaining number by the original price
//
//            int timesPromotionIsApplied = (total / count);
//
//            if (timesPromotionIsApplied <= 0) {
//                return total * originalPrice;
//            }
//
//            int promotional = timesPromotionIsApplied * price;
//            int remaining = total - (count * timesPromotionIsApplied);
//
//            return promotional + (remaining * originalPrice);
//        }
//    }
//
//    class SubRule {
//        private final Integer count;
//        private final Integer price;
//
//        public SubRule(final Integer count, final Integer price) {
//            this.count = count;
//            this.price = price;
//        }
//    }
}
