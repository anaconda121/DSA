import java.util.ArrayList;
import java.util.List;

public class MathAlgorithms {

    List<Integer> extractDigits(int n) {
        List<Integer> res = new ArrayList<>();
        while (n != 0) {
            int digit = n % 10;
            n /= 10;
            res.add(digit);
        }
        return res;
    }
}
