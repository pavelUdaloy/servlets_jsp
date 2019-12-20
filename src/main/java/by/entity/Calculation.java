package by.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Calculation {
    private double firNum;
    private double secNum;
    private String sign;
    private double rez;

    public Calculation(double firNum, double secNum, String sign) {
        this.firNum = firNum;
        this.secNum = secNum;
        this.sign = sign;
        switch (sign){
            case "+":
                this.rez=this.firNum+this.secNum;
                break;
            case "-":
                this.rez=this.firNum-this.secNum;
                break;
            case "*":
                this.rez=this.firNum*this.secNum;
                break;
            case "/":
                this.rez=this.firNum/this.secNum;
                break;
        }
    }

    @Override
    public String toString() {
        return "Calculation{" +
                firNum +
                sign + '\'' +
                secNum +
                " = " +
                rez +
                '}';
    }
}
