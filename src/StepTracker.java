import java.util.*;
import java.util.HashMap;
        import java.util.Map;

public class StepTracker {
    private int plan  = 10000;

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        if(plan>0){
            this.plan = plan;
        }

    }

    Scanner scanner = new Scanner(System.in);
    Map<Integer,String> month  = new HashMap();

    final private int[] month1 = new int[31];
    final private int[] month2 = new int[31];
    final private int[] month3 = new int[31];
    final private int[] month4 = new int[31];
    final private int[] month5 = new int[31];
    final private int[] month6 = new int[31];
    final private int[] month7 = new int[31];
    final private int[] month8 = new int[31];
    final private int[] month9 = new int[31];
    final private int[] month10 = new int[31];
    final private int[] month11 = new int[31];
    final private int[] month12 = new int[31];


    public StepTracker() {
        month.put(1,"Январь");
        month.put(2,"Февраль");
        month.put(3,"Март");
        month.put(4,"Апрель");
        month.put(5,"Май");
        month.put(6,"Июнь");
        month.put(7,"Июль");
        month.put(8,"Август");
        month.put(9,"Сентябрь");
        month.put(10,"Октярь");
        month.put(11,"Ноябрь");
        month.put(12,"Декабрь");

    }

    public void addSteps1(){
        System.out.println("Выберите месяц" );
        int n = 1;
        for (String name:month.values()){
            System.out.println(n + " " +  name);
            n++;
        }
        String otvet  = scanner.nextLine();
        int otvetInt = Integer.parseInt(otvet);

        if (otvetInt> 0 && otvetInt<=12){
            addSteps2(otvetInt);
        }else {
            System.out.println("Нет такого Месяца");
            addSteps1();
        }
    }

    public void addSteps2(int otvet){
        switch (otvet){
            case 1:
                addSteps3(month1,otvet);
                break;
            case 2:
                addSteps3(month2,otvet);
                break;
            case 3:
                addSteps3(month3,otvet);
                break;
            case 4:
                addSteps3(month4,otvet);
                break;
            case 5:
                addSteps3(month5,otvet);
                break;
            case 6:
                addSteps3(month6,otvet);
                break;
            case 7:
                addSteps3(month7,otvet);
                break;
            case 8:
                addSteps3(month8,otvet);
                break;
            case 9:
                addSteps3(month9,otvet);
                break;
            case 10:
                addSteps3(month10,otvet);
                break;
            case 11:
                addSteps3(month11,otvet);
                break;
            case 12:
                addSteps3(month12,otvet);
                break;


        }


    }
    public void addSteps3(int [] n ,int nomer){
        System.out.println("В какой день внести запись");
        String day  = scanner.nextLine();
        int dayInt = Integer.parseInt(day);

        if (dayInt>0 && dayInt < 32){
            System.out.println("Введите количество шагов для записи");
            String shag  = scanner.nextLine();
            int shagInt = Integer.parseInt(shag);

            if (shagInt > 0 ){
                n[dayInt-1]=shagInt;
                System.out.println("\033[0;94m"   + "Шаги успешно добавленный в месяц "  + month.get(nomer) + " в " + day +" день"+"\033[0m" );


            }



        }else {
            System.out.println("Введите существующий день от 1 до 31");
            addSteps3(n,nomer);
        }


    }




}
