public class App {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Part p = new Part();
        for(int i = 0; i < 20; i++){
            System.out.println(p.createRandom());
        }
    }
}
