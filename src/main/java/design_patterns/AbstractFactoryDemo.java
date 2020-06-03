package design_patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shivanidwivedi on 01/06/20
 * @project JavaProgramming
 * EXAMPLE OF ABSTRACT FACTORY PATTERN
 */
public class AbstractFactoryDemo {
    public static void main(String s[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String bankName=br.readLine();
        String loanName=br.readLine();
        AbstractFactory bankFactory = FactoryCreator.getFactory("Bank");
        Bank b = bankFactory.getBank(bankName);
        System.out.print("Enter the interest rate for "+b.getBankName()+ ": ");

        double rate=Double.parseDouble(br.readLine());
        double loanAmount=Double.parseDouble(br.readLine());
        int tenure = Integer.parseInt(br.readLine());
        System.out.println("you are taking the loan from "+ b.getBankName());
        AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");
        Loan l = loanFactory.getLoan(loanName);
        l.getInterestRate(rate);
        l.calculateLoanPayment(loanAmount,tenure);
    }
}

interface Bank{
    String getBankName();
}
 abstract class Loan{
    double rate;

    abstract void getInterestRate(double rate);

    void calculateLoanPayment(double loanAmount, int tenure){
        double EMI;
        int n;

        n=tenure*12;
        rate=rate/1200;
        EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanAmount;

        System.out.println("your monthly EMI is "+ EMI +" for the amount"+loanAmount+" you have borrowed");
    }
 }

 abstract class AbstractFactory{
    abstract Bank getBank(String bank);
    abstract Loan getLoan(String loan);
 }
class BankFactory extends AbstractFactory{
     public Bank getBank(String bank){
        if(bank == null){
            return null;
        }
        if(bank.equalsIgnoreCase("HDFC")){
            System.out.println("HDFC called");
            return new HDFC();
        }
         if(bank.equalsIgnoreCase("ICICI")){
             return new ICICI();
         }
         if(bank.equalsIgnoreCase("SBI")){
             return new SBI();
         }
         return null;
    }
    public Loan getLoan(String loan){
         return null;
    }
 }
 class LoanFactory extends AbstractFactory{
    public Loan getLoan(String loan){
        if (loan == null){
            return null;
        }
        if (loan.equalsIgnoreCase("HomeLoan")){
            return new HomeLoan();
        }
        if (loan.equalsIgnoreCase("BusinessLoan")){
            return new BusinessLoan();
        }
        if (loan.equalsIgnoreCase("EducationLoan")){
            return new EducationLoan();
        }
        return null;
    }
    public Bank getBank(String bank){
        return null;
    }
 }
 class HDFC implements Bank{
    private final String BName;
    public HDFC(){
        BName = "HDFC";
    }
     @Override
     public String getBankName() {
         return BName;
     }
 }
class ICICI implements Bank{
    private final String BName;
    public ICICI(){
        BName = "ICICI";
    }
    @Override
    public String getBankName() {
        return BName;
    }
}
class SBI implements Bank{
    private final String BName;
    public SBI(){
        BName = "SBI";
    }
    @Override
    public String getBankName() {
        return BName;
    }
}
class HomeLoan extends Loan{

    @Override
    void getInterestRate(double r) {
        rate = r;
    }
}
class BusinessLoan extends Loan{

    @Override
    void getInterestRate(double r) {
        rate = r;
    }
}
class EducationLoan extends Loan{

    @Override
    void getInterestRate(double r) {
        rate = r;
    }
}
class FactoryCreator{
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("bank")){
            return new BankFactory();
        }
        if (choice.equalsIgnoreCase("loan")){
            return new LoanFactory();
        }
        return null;
    }
}