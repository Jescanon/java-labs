import java.util.ArrayList;
import java.util.Scanner;

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

        Fraction infos = new Fraction().init(5, 2);
        System.out.println(infos.fractionalPart());
        System.out.println(infos.add(new Fraction().init(1, 2)).display());

        Country count = new Country().init(new City().init(30, 2), new City().init(40, 10), new City().init(200, 30), 50, 20);
        System.out.println(count.info_max_pop().display());
    }
}

class Fraction {
    public int numerator;
    public int denominator;

    public Fraction init(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
        return this;
    }

    public Fraction read(Scanner sc) {
        this.numerator = sc.nextInt();
        this.denominator = sc.nextInt();
        return this;
    }

    public double fractionalPart() {
        int wholePart = numerator / denominator;
        int fractionalNumerator = numerator - wholePart * denominator;
        return (double) fractionalNumerator / denominator;
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction().init(newNumerator, newDenominator);
    }

    public String display() {
        return this.numerator + " " + this.denominator;
    }
}

class City {
    public int number_of_inhabitants;
    public double square;

    public City init(int number_of_inhabitants, double square) {
        this.number_of_inhabitants = number_of_inhabitants;
        this.square = square;
        return this;
    }

    public City read(Scanner sc) {
        this.number_of_inhabitants = sc.nextInt();
        this.square = sc.nextDouble();
        return this;
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

    public Country init(City city1, City city2, City city3, double square, int pop) {
        this.city1 = city1;
        this.city2 = city2;
        this.city3 = city3;
        this.square = square;
        this.pop = pop;
        return this;
    }

public Country read(Scanner sc) {
    this.city1 = new City().read(sc);
    this.city2 = new City().read(sc);
    this.city3 = new City().read(sc);

    this.square = sc.nextDouble();
    this.pop = sc.nextInt();
    return this;
}

    public String display(){
        return this.city1 + " " + this.city2 + " " + this.city3 + " " + this.square + " " + this.pop;
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
