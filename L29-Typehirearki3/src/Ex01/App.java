package Ex01;

public class App {
    public static void main(String[] args) {
        Measurable[] chilis = {new Chili(4999), new Chili(1000000), new Chili(500000)};
        Measurable[] beers = {new Beer("Turborg classic", 4.6), new Beer("Royal Export",
                5.8), new Beer("Giraff Øl", 10)};
        Filterclass f1 = new Filterclass(5000);

        System.out.printf("Average chilis with limit 5000: %.2f", avarage(chilis, f1));
        System.out.println();
        Measurable[] blackFriday = blackFridayMeal(chilis, beers);
        System.out.printf("Strongest chili: %.2f\n", blackFriday[0].getMeasure());
        System.out.printf("Strongest beer: %.2f\n", blackFriday[1].getMeasure());
    }

//    public static double average(Measurable[] objects) {
//        double sum = 0;
//        for(Measurable e : objects){
//            sum += e.getMeasure();
//        }
//        return sum/objects.length;
//    }

    public static double avarage(Measurable[] objects, Filter filter){
        double sum = 0;
        int count = 0;
        for(Measurable e : objects){
            if (filter.accept(e)) {
                sum += e.getMeasure();
                count++;
            }
        }
        return sum/count;
    }
    public static Measurable max(Measurable[] objects) {
        Measurable measureMax = objects[0];
        for(Measurable e : objects){
            if(e.getMeasure() > measureMax.getMeasure()){
                measureMax = e;
            }
        }
        return measureMax;
    }

    public static Measurable[] blackFridayMeal(Measurable[] chilies, Measurable[] beers){
        Measurable[] stronk = {max(chilies), max(beers)};
        return stronk;
    }
}
