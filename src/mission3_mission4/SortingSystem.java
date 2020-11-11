package mission3_mission4;

import java.util.ArrayList;
import java.util.HashMap;

public class SortingSystem {

    private HashMap<Integer, MoneyDataSet> moneyBookMapById;
    private HashMap<Integer, ArrayList<Integer>> moneyBookMapByDate;
    private Prompt prompt;
    private CalculateMoneyData calculateMoneyData ;


    public SortingSystem(HashMap<Integer, MoneyDataSet> moneyBookMapById,HashMap<Integer, ArrayList<Integer>> moneyBookMapByDate){
        this.moneyBookMapByDate= moneyBookMapByDate;
        this.moneyBookMapById = moneyBookMapById;
        this.prompt = new Prompt();
        this.calculateMoneyData = new CalculateMoneyData();
    }

    public void sortByContents(int yearAndMonth) {
        String keyword = prompt.selectKeyword();
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);
            if(value.getContents().contains(keyword)){
                System.out.println(key + ", " + value);
            }
        }
    }

    public void sortByDate(int yearAndMonth) {
        int day = prompt.selectDay();
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);
            if(value.getDay() == day){
                System.out.println(key + ", " + value);
            }
        }
    }

    public void sortBySpendingMethod(int yearAndMonth) {
        String method = prompt.selectSpendingMethod();
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);
            if(value.getSpendingMethod().equals(method)){
                System.out.println(key + ", " + value);
            }
        }
    }

    public void sortByMoney(int yearAndMonth) {
        int money = prompt.selectMoney();
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);
            if(value.getIncome() == money || value.getSpending() == money){
                System.out.println(key + ", " + value);
            }
        }
    }

    public void sortByIncome(int yearAndMonth){
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);
            if(value.getIncome() != 0){
                System.out.println(key + ", " + value);
            }
        }
    }
    public void sortBySpending(int yearAndMonth){
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);
            if(value.getSpending() != 0){
                System.out.println(key + ", " + value);
            }
        }
    }

    private void calculateThisMonthMoney(int key, MoneyDataSet value) {
        System.out.println(key + ", " + value);
        calculateMoneyData.addIncome(value.getIncome());
        calculateMoneyData.addSpending(value.getSpending());
    }

    public void readWholeDataByMonth(int yearAndMonth) {
        calculateMoneyData.setIncome(0);
        calculateMoneyData.setSpending(0);
        prompt.printWhichMonth(yearAndMonth);
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);

            calculateThisMonthMoney(key, value);
        }
        prompt.printThisMonthMoney(calculateMoneyData.getIncome(), calculateMoneyData.getSpending(), calculateMoneyData.getTotal());
    }
}
