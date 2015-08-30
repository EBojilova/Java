import java.math.BigDecimal;

public class FloatingPointTypes {
    public static void main(String[] args) {
        float f = 0.33f;
        double d = 1.67;
        double sum = f + d;
        //float fSum = f + d; // This will not compile
        double infinity = 3.14 / 0;
        System.out.println(f); // 0.33
        System.out.println(d); // 1.67
        // Ako sumata e samo ot doubles ili floats, ste bade korektna, no ako gi omesime, ste ima greshka
        System.out.println(sum); // 2.000000013113022
        System.out.println(infinity); // Infinity
        //BigDecimal ne e primitiven tip, a e klas, koito se namira v java.math.BigDecimal;
        BigDecimal bigF = new BigDecimal("0.33");
        BigDecimal bigD = new BigDecimal("1.67");
        // Ne e pravilno tai kato parvo go smiata, posle go prehvarlia kam BigDecimal
        BigDecimal sumNotCorrect= new BigDecimal(f+d);
        System.out.println(sumNotCorrect);
        BigDecimal sumNotCurrect2= new BigDecimal(f).add(new BigDecimal(d));
        System.out.println(sumNotCurrect2);
        // Sum ne e vazmojno da se napravi s +, a se izpolzva method kam klasa BigDecimal, tai kato Java niama pisane na custom operators, koeto e seriozen nedostatak na Java
        BigDecimal bigSum = bigF.add(bigD);
        System.out.println(bigSum);
    }
}
