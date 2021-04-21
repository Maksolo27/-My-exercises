package converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import units.Unit;
import units.UnitConverter;
import units.UnitFactory;

/**
 * Created by maxim on 21.04.2021.
 */
public class Main {

    public static void main(String[] args) {
        String jsonObj = "{'distance': {'unit': 'sm', 'value': 1}, 'convert_to': 'ft'}";
        Gson gson = new GsonBuilder().create();
        JsonDistance fromJsonDistance = gson.fromJson(jsonObj, JsonDistance.class);
        System.out.println(fromJsonDistance.getDistance() + " " + fromJsonDistance.getConvert_to());
        Unit unit = Unit.setUnit(fromJsonDistance.getDistance().getUnit());
        UnitFactory factory = new UnitFactory();
        UnitConverter converter = factory.getUnit(unit);
        double result = converter.convert(fromJsonDistance.getConvert_to(), fromJsonDistance.getDistance().getValue());
        System.out.println(result);
    }

}
