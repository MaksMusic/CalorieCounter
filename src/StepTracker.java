import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;
import sun.security.rsa.RSAUtil;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class StepTracker {
    private int color;
    private int plan;

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        if (plan > 0) {
            this.plan = plan;
        }

    }

    Scanner scanner = new Scanner(System.in);
    Map<Integer, String> month = new HashMap();
    private final int[][] monthArray = new int[12][];

//    final private int[] month1 = new int[31];
//    final private int[] month2 = new int[31];
//    final private int[] month3 = new int[31];
//    final private int[] month4 = new int[31];
//    final private int[] month5 = new int[31];
//    final private int[] month6 = new int[31];
//    final private int[] month7 = new int[31];
//    final private int[] month8 = new int[31];
//    final private int[] month9 = new int[31];
//    final private int[] month10 = new int[31];
//    final private int[] month11 = new int[31];
//    final private int[] month12 = new int[31];


    public StepTracker() {
        plan = 10000;
        monthArray[0] = new int[31];
        monthArray[1] = new int[31];
        monthArray[2] = new int[31];
        monthArray[3] = new int[31];
        monthArray[4] = new int[31];
        monthArray[5] = new int[31];
        monthArray[6] = new int[31];
        monthArray[7] = new int[31];
        monthArray[8] = new int[31];
        monthArray[9] = new int[31];
        monthArray[10] = new int[31];
        monthArray[11] = new int[31];

        month.put(1, "Январь");
        month.put(2, "Февраль");
        month.put(3, "Март");
        month.put(4, "Апрель");
        month.put(5, "Май");
        month.put(6, "Июнь");
        month.put(7, "Июль");
        month.put(8, "Август");
        month.put(9, "Сентябрь");
        month.put(10, "Октярь");
        month.put(11, "Ноябрь");
        month.put(12, "Декабрь");

    }

    public void addSteps1() {
        System.out.println("Выберите месяц");
        spisokMonth();
        String otvet = scanner.nextLine();
        int otvetInt = Integer.parseInt(otvet);

        if (otvetInt > 0 && otvetInt <= 12) {
            addSteps2(otvetInt);
        } else {
            System.out.println("Нет такого Месяца");
            addSteps1();
        }
    }

    private void addSteps2(int otvet) {
        addSteps3(monthArray[otvet - 1], otvet);
    }


    private void addSteps3(int[] n, int nomer) {
        System.out.println("В какой день внести запись");
        String day = scanner.nextLine();
        int dayInt = Integer.parseInt(day);

        if (dayInt > 0 && dayInt < 32) {
            System.out.println("Введите количество шагов для записи");
            String shag = scanner.nextLine();
            int shagInt = Integer.parseInt(shag);

            if (shagInt > 0) {
                n[dayInt - 1] = shagInt;
                System.out.println("\033[0;94m" + "Шаги успешно добавленный в месяц " + month.get(nomer) + " в " + day + " день" + "\033[0m");


            }


        } else {
            System.out.println("Введите существующий день от 1 до 31");
            addSteps3(n, nomer);
        }


    }

    private void spisokMonth() {
        int c = 1;
        for (String month : month.values()) {
            System.out.println(c + " - " + month);
            c++;
        }
    }

    public void statistika1() {
        System.out.println("За какой месяц хотите получить статистику");
        spisokMonth();
        String month = scanner.nextLine();
        int otvet = Integer.parseInt(month);
        statistika2(otvet);


    }


    private void loading() {
        System.out.println("Подождите идет загрузка ");
        char s = 7470;

        for (int i = 0; i < 8; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private void statistika2(int month) {
        System.out.println("-----------------------------------------------------------");
        loading();
        for (int i = 0; i < monthArray[month - 1].length; i++) {
            System.out.printf("%d день - %d  шагов , ", i + 1, monthArray[month - 1][i]);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("План по кол - ву шагов в день " + plan + " шагов ");
        System.out.println("План по кол - ву шагов в Месяц " + plan * 31 + " шагов");
        int planItog = statistikaPlanMonth(month);
        if (this.color == 1) {
            System.out.println("\033[0;92m" + "План за " + this.month.get(month) + " Выполнен на " + planItog + " %" + "\033[0m");
        } else {

            System.out.println("\033[0;91m" + "План за " + this.month.get(month) + " Выполнен на " + planItog + " %" + "\033[0m");
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("ПОДГРУЖАЕТСЯ СТАТИСТИКА ЗА " + this.month.get(month));
        loading();
        System.out.println("Пройденно шагов  - " + sam(month));
        System.out.println("Максимальное количество пройденных шагов в месяце в   - " + maxSam(month));
        System.out.println("В среднем вы проходите   - " + averageSum(month) + " шагов за "+this.month.get(month) );
        System.out.println("Пройдено км за месяц   "+this.month.get(month) + " -  " + Convertor.getDistance(sam(month)) +  " км");
        System.out.println("Количество сожженных килокалорий  км за месяц  - " + Convertor.getCalories(sam(month)) );


    }

    private int averageSum(int month){
        return sam(month) / monthArray[month - 1].length;
    }



    private int maxSam(int month){
        int maxSam =  monthArray[month - 1][0];
        for (int i = 0; i < monthArray[month - 1].length; i++) {
            if (maxSam<monthArray[month - 1][i]){
                maxSam = monthArray[month - 1][i];
            }

        }
        return maxSam;
    }


    private int sam(int month){
        int sam = 0;
        for (int n : monthArray[month - 1]) {
            sam += n;

        }
        return sam;
    }


    private int statistikaPlanMonth(int month) {

        int plan = 31 * this.plan;        //план за месяц

        int procent1 = plan / 100;        // 1 процент от плана
        int planMonth = plan - sam(month);  // сколько не выполнено шагов за месяц

        if (planMonth < 0) {       //если все выполнено
            this.color = 1;
            return 100;
        } else {         //если не выполнен план
            this.color = 0;
            return sam(month) / procent1;    // процент на сколько выполнен план
        }

    }


}
