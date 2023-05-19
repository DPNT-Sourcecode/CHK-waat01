package befaster.solutions.CHK.CHK_2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;

public interface Rule {

    int priority();

    int solve(final int total, final int originalPrice, final Supplier<Map<String, Integer>> skusByCount);
}
