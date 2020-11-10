package mission3;

public class MoneyData {
    private int id =1;
    private int income;
    private int spending;
    private int total;

    public int addId(){
        return this.id +=1;
    }

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

    public int getId(){
        return this.id;
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
