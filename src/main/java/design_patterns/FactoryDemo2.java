package design_patterns;

/**
 * @author shivanidwivedi on 01/06/20
 * @project JavaProgramming
 *
 * EXAMPLE OF FACTORY DESIGN PATTERN
 */
public class FactoryDemo2 {
    public static void main(String s[]){
        GetPlanFactory planFactory = new GetPlanFactory();
        Plan dom = planFactory.getPlan("DomesticPlan");
        dom.getRate();
        dom.calculateBill(3);
        Plan comm = planFactory.getPlan("CommercialPlan");
        comm.getRate();
        comm.calculateBill(3);
        Plan ins = planFactory.getPlan("InstitutionalPlan");
        ins.getRate();
        ins.calculateBill(5);
    }
}

class GetPlanFactory{
    public Plan getPlan(String planType){
        if (planType == null){
            return null;
        }
        if(planType.equalsIgnoreCase("DomesticPlan")){
            return new DomesticPlan();
        }
        if(planType.equalsIgnoreCase("CommercialPlan")){
            return new CommercialPlan();
        }
        if(planType.equalsIgnoreCase("InstitutionalPlan")){
            return new InstitutionalPlan();
        }
        return null;
    }
}

abstract class Plan{
    double rate;
    abstract void getRate();
    public void calculateBill(int units){
     System.out.println(units*rate);
 }
}

class DomesticPlan extends Plan{

    @Override
    void getRate() {
        rate = 3.50;
    }
}

class CommercialPlan extends Plan{

    @Override
    void getRate() {
        rate = 2.0;
    }
}

class InstitutionalPlan extends Plan{

    @Override
    void getRate() {
        rate = 7.50;
    }
}