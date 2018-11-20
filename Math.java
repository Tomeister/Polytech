import java.math.BigDecimal;
import java.math.RoundingMode;

public class newMath {
    public static void main(String[] args) {
            double N = 0.1;
            final BigDecimal X1 = new BigDecimal(0);
            BigDecimal P2;
            BigDecimal P4;
            System.out.println("X2        P2          P4         X1");
            for (double i = 0; i < 8; i += 0.1) {
                BigDecimal X2 = new BigDecimal(N);
                P2 = (new BigDecimal(5).divide(X2,2, RoundingMode.HALF_UP));
                P4 = (X2.multiply(X2).multiply(new BigDecimal(1.3)).divide(BigDecimal.valueOf(5)));
                System.out.println(X2.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "      "
                        + P2.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "        "
                        + P4.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "        "
                        + X1);
                N += 0.1;
            }
    }
}
