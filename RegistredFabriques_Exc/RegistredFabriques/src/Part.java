import factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
* Using Constructors and Class list instead of Factories list
* */

public class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    private static List<Class<? extends Part>> partFactories =
            new ArrayList<Class<? extends Part>>();

    static {
        partFactories.add(FuelFilter.class);
        partFactories.add(AirFilter.class);
        partFactories.add(CabinAirFilter.class);
        partFactories.add(OilFilter.class);
        partFactories.add(FanBelt.class);
        partFactories.add(GeneratorBelt.class);
        partFactories.add(PowerSteeringBelt.class);
    }

    private Random rand = new Random(47);

    public Part createRandom() throws IllegalAccessException, InstantiationException {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).newInstance();
    }

}

class Filter extends Part{}

class FuelFilter extends Filter{
    public static class Factory implements factory.Factory<FuelFilter>{
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter{
    public static class Factory implements factory.Factory<AirFilter>{
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter{
    public static class Factory implements factory.Factory<CabinAirFilter>{
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter{
    public static class Factory implements factory.Factory<OilFilter>{
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part{}

class FanBelt extends Belt{
    public static class Factory implements factory.Factory<FanBelt>{
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt{
    public static class Factory implements factory.Factory<GeneratorBelt>{
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt{
    public static class Factory implements factory.Factory<PowerSteeringBelt>{
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

