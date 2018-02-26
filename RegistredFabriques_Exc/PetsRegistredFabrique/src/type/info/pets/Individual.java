package type.info.pets;

public class Individual {
    private static int count = 0;
    private final int id = count++;;
    private String name;


    Individual(){
        name = getClass().getSimpleName() + ": " + id;
    }

    Individual(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
