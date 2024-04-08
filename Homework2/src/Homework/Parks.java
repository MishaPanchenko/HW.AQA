package Homework;

public class Parks {
    public String attractions;
    public String time;
    public int price;

    public String valuta;

    public static class Inner extends Parks {
        public Inner(String attractions, String time, int price, String valuta) {
            this.attractions = attractions;
            this.time = time;
            this.price = price;
        this.valuta = valuta;
        }
    }
    @Override
    public String toString() {
        return String.format("Аттракцион: %s \nВремя работы: %s \nСтоимость: %s %s", attractions, time, price, valuta);
    }
    public static void main(String[] args) {
        Parks karusel = new Parks.Inner("Карусель", "9:00 - 14:00", 2, "BYN");
        Parks gorki = new Parks.Inner("Американские горки", "10:00 - 18:00", 4, "BYN");
        System.out.println(karusel);
        System.out.println();
        System.out.println(gorki);
    }
}
