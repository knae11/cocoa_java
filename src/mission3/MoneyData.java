package mission3;

public class MoneyData {
    private String user;
    private int password;
    private int income;
    private int spending;
    private int total;

    public String setUser(String user){
        return this.user = user;
    }
    public int setPassword(int password){
        return this.password = password;
    }

    public int setIncome(int income){
        return this.income = income;
    }
    public int setSpending(int spending){
        return this.spending = spending;
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
