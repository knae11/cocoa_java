package mission3_mission4;

public class MoneyDataSet {
    private  String date;
    private  String contents;
    private int income;
    private int spending;
    private String spendingMethod;

    public  MoneyDataSet( String date, String contents, int income, int spending, String spendingMethod){

        this.date = date;
        this.contents = contents;
        this.income = income;
        this.spending = spending;
        this.spendingMethod = spendingMethod;
    }
    @Override
    public String toString(){
        return "" + this.date + "," + this.contents + "," + this.income + "," + this.spending + ","+ this.spendingMethod;
    }

    public int getYearAndMonth(){
        return Integer.parseInt(this.date.split("-")[0]);
    }
    public int getIncome(){
        return this.income;
    }
    public int getSpending(){
        return this.spending;
    }
}
