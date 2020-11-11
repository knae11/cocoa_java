package mission3_mission4;

public class CalculateMoneyData {
    private int income;
    private int spending;
    private int total;

    public void setIncome(int income){
         this.income = income;
    }
    public void setSpending(int spending){
         this.spending = spending;
    }

    public int addIncome(int income){
        return this.income += income;
    }
    public int addSpending(int spending){
        return this.spending += spending;
    }

    public int getIncome(){
        return this.income;
    }
    public int getSpending(){
        return this.spending;
    }
    public int getTotal(){
        this.total = this.income - this.spending;
        return this.total;
    }



}
