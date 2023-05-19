package befaster.solutions.CHK.CHK_2;

import java.util.Collection;
import java.util.Iterator;

public interface Rule {

    int solve(final int total, final int originalPrice, final Iterator<String> codes);
}

