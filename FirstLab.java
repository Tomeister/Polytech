package Firstlab;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class FirstLab {
    public static void main(String[] args) {

        try {
            if (args.length != 3)
                throw new IncorrectArgsException("Incorrect amount of args.", args.length);
        }
        catch (IncorrectArgsException IAE) {
            System.out.println(IAE.getMessage());
            System.out.println("now is = " + IAE.getNumber());
            System.exit(1);
    }

        int[] inputArgs = new int[3];
        System.out.println("INPUT ARGS ");
        try {
            for (int i = 0; i < inputArgs.length; i++) {
                inputArgs[i] = Integer.parseInt(args[i]);
                if ( inputArgs[i]<0) {
                    System.out.println("ERROR - there was negative arg");
                    System.exit(1);
                }

                System.out.println("args [" + i + "] = " + inputArgs[i]);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Incorrect args format");
            System.exit(1);
        }
        catch (Exception exp){
            System.out.println("Ths went wrong!");
            System.exit(1);
        }
        try {
            LocalDate start = LocalDate.of(inputArgs[0], inputArgs[1], inputArgs[2]);
            LocalDate end = LocalDate.now(ZoneId.systemDefault());
            Period p = Period.between(start, end);
            System.out.print(p.getYears() + " year" + (p.getYears() > 1 ? "s " : " "));
            System.out.print(p.getMonths() + " month" + (p.getMonths() > 1 ? "s and " : " and "));
            System.out.print(p.getDays() + " day" + (p.getDays() > 1 ? "s.\n" : ".\n"));
        } catch (DateTimeException date) {
            System.out.println("Invalid date format ");
        }
    }
}