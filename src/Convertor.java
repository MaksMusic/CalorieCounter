public class Convertor {


    public static double getDistance(int step) { // преобразуем шаги в киллометры  для подсчета дистанции можно считать, что один шаг равен 75см

        double distance = step * 75; // это у нас см получаются

        double result = distance / 100000;

        return result;

    }

    public static double getCalories(int step) {
        return step * 0.05;     // перевод шагов в калории ( 1 шаг = 1 * 0.05 = 0,05 калорий)
    }

    public static double getKilocalories(double calories) { // перевод калорий в киллокалории  ( в 1 килокалории находится 1000 калорий)
        return calories / 100;
    }


}

