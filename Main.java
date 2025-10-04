import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] masiv = { 1, 2, 4, 3 };
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        for (int i = 0; i < masiv.length; i++) {
            if (masiv[i] % 2 == 0) {
                array1.add(masiv[i]);
            } else {
                array2.add(masiv[i]);
            }
        }
        for (int i = 0; i < array2.size(); i++) {
            array1.add(array2.get(i));
        }
        System.out.println(array1);

        Fraction infos = new Fraction(5, 2);
        System.out.println(infos.fractionalPart());
        System.out.println(infos.add(new Fraction(1, 2)).info());

        Country count = new Country(new City(100, 20.1), new City(200, 30.2), new City(300, 40.3), 20.4, 30);
        System.out.println(count.info_max_pop().display());

    }
}

class Fraction {
    public int numerator;
    public int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double fractionalPart() {
        int wholePart = numerator / denominator;
        int fractionalNumerator = numerator - wholePart * denominator;
        return (double) fractionalNumerator / denominator;
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public String info() {
        return this.numerator + " " + this.denominator;
    }

}

class City {
    public int number_of_inhabitants;
    public double square;

    public City(int number_of_inhabitants, double square) {
        this.number_of_inhabitants = number_of_inhabitants;
        this.square = square;
    }

    public double population_area() {
        return (double) this.number_of_inhabitants / this.square;
    }

    public String display() {
        return number_of_inhabitants + " Число чел " + square + " арена ";
    }
}

class Country {
    public City city1;
    public City city2;
    public City city3;
    public double square;
    public int pop;

    public Country(City city1, City city2, City city3, double square, int pop) {
        this.city1 = city1;
        this.city2 = city2;
        this.city3 = city3;
        this.square = square;
        this.pop = pop;
    }

    public double srplot() {
        double info = this.square / this.pop;
        return (this.city1.population_area() + this.city2.population_area() + this.city3.population_area() + info) / 4;
    }

    public City info_max_pop() {
        City[] cities = { city1, city2, city3 };
        City maxCity = cities[0];
        for (int i = 1; i < cities.length; i++) {
            if (cities[i].population_area() > maxCity.population_area()) {
                maxCity = cities[i];
            }
        }
        return maxCity;
    }

}

public void info_all() {
    System.out.println(null);
}