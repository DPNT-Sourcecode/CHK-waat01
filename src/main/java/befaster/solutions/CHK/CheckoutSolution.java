package befaster.solutions.CHK;

import befaster.solutions.CHK.CHK_2.BoGoRule;
import befaster.solutions.CHK.CHK_2.PricingRule;
import befaster.solutions.CHK.CHK_2.Rule;
import befaster.solutions.CHK.CHK_2.SinglePricingRule;
import befaster.solutions.CHK.CHK_2.Sku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

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


AABBCCDDEE

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
    private static final Sku A = new Sku("A", 50, PricingRule.create(5, 200, 3, 130));
    private static final Sku B = new Sku("B", 30, new SinglePricingRule(2, 45));
    private static final Sku C = new Sku("C", 20);
    private static final Sku D = new Sku("D", 15);
    private static final Sku E = new Sku("E", 40, new BoGoRule(2, B));

    public Integer checkout(String skus) {
        if (skus == null) return -1;
        if (skus.isEmpty()) return 0;

        final List<Sku> skuList = new ArrayList<>();
        skuList.add(A);
        skuList.add(B);
        skuList.add(C);
        skuList.add(D);
        skuList.add(E);


        final Map<String, Sku> checkoutDictionary = skuList.stream().collect(Collectors.toMap(Sku::getCode, Function.identity()));

        final List<String> allSkus = new ArrayList<>();
        final Map<String, Integer> skuDictionaryByCount = new HashMap<>();
        for (int i = 0; i < skus.length(); i++) {
            String singleSku = String.valueOf(skus.charAt(i));
            allSkus.add(singleSku);
            if (checkoutDictionary.containsKey(singleSku)) {
                skuDictionaryByCount.compute(singleSku, (k,  v) -> (v == null) ? 1 : v + 1);
            }
            else return -1;
        }

        var ordered = checkoutDictionary.values()
                .stream()
                .sorted(Comparator.comparing(Sku::getPriority))
                .map(Sku::getCode)
                .toList();

        var sum = 0;
        for (String code : ordered) {
            var sku = checkoutDictionary.get(code);
            if (skuDictionaryByCount.containsKey(code)) {
                var total = skuDictionaryByCount.get(code);
                sum = sum + sku.caclulate(total, () -> skuDictionaryByCount);
            }
        }

        return sum;
    }
}
