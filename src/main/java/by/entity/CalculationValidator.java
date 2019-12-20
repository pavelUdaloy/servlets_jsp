package by.entity;

public class CalculationValidator {
    public boolean validNum(String num){
        try {
            double v = Double.parseDouble(num);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public boolean validSign(String sign){
        return sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/");
    }

    public boolean validRez(String rez){
        return validNum(rez);
    }

    public boolean validCalculation(Calculation calculation){
        return ((validNum(String.valueOf(calculation.getFirNum()))) && (validNum(String.valueOf(calculation.getSecNum())))
                && (validSign(calculation.getSign())) && (validRez(String.valueOf(calculation.getRez()))));
    }

    public static void main(String[] args) {
        CalculationValidator calculationValidator = new CalculationValidator();
        Calculation calculation = new Calculation(3.4,5.4,"+", 3);
        System.out.println(calculationValidator.validCalculation(calculation));
    }
}
