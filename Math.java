package Math;

import java.math.BigDecimal;

public class newMath {
    public static void main(String[] args) {

        double N = 1.1;

        double P1 = 0.5;
        double P5 = 0.8;

        BigDecimal X1;
        BigDecimal P2;
        BigDecimal P4;

        double P;
        double X_1;
        double P_2;
        double P2_with_surpise;
        double SEARCH_LAMDA_ONLY;
        double ONLY_COUNT;
        double D;
        double LAMBDA1;
        double LAMBDA2;
        double D_eq_0;
        double D_less_0;

        double a11, a12, a21, a22;

        double L2, L3;

        System.out.println(" X2         P2           P4           X1         Lambda1       Lambda2");

        for (double i = 1; i < 7.9; i += 0.1) {
            double x2 = N;
            BigDecimal X_2 = new BigDecimal(N);
            P = (3.38 * x2 * (x2 - 1)) / (1.3 * x2 - 1.8);
            P4 = new BigDecimal(P);
            X_1 = (1.3 * x2) / (0.5 * P);
            X1 = new BigDecimal(X_1);
            P_2 = (P1 * X_1) / ((1 - X_1) * Math.exp(x2));
            P2 = new BigDecimal(P_2);


            P2_with_surpise = (P1 * X_1) / (1 - X_1);


            a11 = -0.5 - P2_with_surpise;
            a12 = -P2_with_surpise * P;
            a21 = P2_with_surpise * (1 - X_1);
            a22 = -0.5 - 0.8 + P2_with_surpise * P * (1 - X_1);

            L2 = -a11 - a22;
            L3 = a11 * a22 - a21 * a12;

            D = L2 * L2 - 4 * L3;


            if (D > 0) {
                LAMBDA1 = (-L2 + Math.sqrt(D)) / 2;
                LAMBDA2 = (-L2 - Math.sqrt(D)) / 2;
                BigDecimal Lam1 = new BigDecimal(LAMBDA1);
                BigDecimal Lam2 = new BigDecimal(LAMBDA2);
                System.out.println(X_2.setScale(1, BigDecimal.ROUND_HALF_UP).toString() + "      "
                        + P2.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "        "
                        + P4.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "        "
                        + X1.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "        "
                        + Lam1.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "        "
                        + Lam2.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "        "
                        );
            }

                if (D == 0) {
                    D_eq_0 = -L2 / 2;
                    BigDecimal Lam3 = new BigDecimal(D_eq_0);
                    System.out.println(X_2.setScale(1, BigDecimal.ROUND_HALF_UP).toString() + "      "
                            + P2.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "        "
                            + P4.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "        "
                            + X1.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "        "
                            + Lam3.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "        "
                    );
                }
                    if (D < 0) {
                        double LambdaL1 = (-L2 + Math.sqrt(-D)) / 2;
                        double LambdaL2 = (-L2 - Math.sqrt(-D)) / 2;
                        BigDecimal Lam4 = new BigDecimal(LambdaL1);
                        BigDecimal Lam5 = new BigDecimal(LambdaL2);
                        System.out.println(X_2.setScale(1, BigDecimal.ROUND_HALF_UP).toString() + "      "
                                + P2.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "        "
                                + P4.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "        "
                                + X1.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "        "
                                + Lam4.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "i" + "        "
                                + Lam5.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + "i" + "        "
                        );
                    }
            N += 0.1;
        }
    }
}
