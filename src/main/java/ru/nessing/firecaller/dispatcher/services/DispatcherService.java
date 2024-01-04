package ru.nessing.firecaller.dispatcher.services;

import org.springframework.stereotype.Service;
import ru.nessing.firecaller.entities.FireStation;
import ru.nessing.firecaller.entities.Firefighter;
import ru.nessing.firecaller.entities.StateFireStation;

import java.util.ArrayList;
import java.util.List;

@Service
public class DispatcherService {

    private List<FireStation> allFireStations = new ArrayList<>();
    private  List<Firefighter> firefighters1 = new ArrayList<>();
    private  List<Firefighter> firefighters2 = new ArrayList<>();
    private  List<Firefighter> firefighters3 = new ArrayList<>();

    {
        firefighters1.add(new Firefighter(1L, "С.И. Иванов", "Начальник караула", 1));
        firefighters1.add(new Firefighter(2L, "А.С. Петров", "ПНК", 1));
        firefighters1.add(new Firefighter(3L, "К.Ю. Сидоров", "Старший пожарный", 1));

        firefighters2.add(new Firefighter(1L,"Р.М. Михайлов", "Начальник караула", 2));
        firefighters2.add(new Firefighter(2L,"И.Ф. Федоров", "ПНК", 2));
        firefighters2.add(new Firefighter(3L,"П.В. Орехов", "Старший пожарный", 2));

        allFireStations.add(new FireStation(1L,"1 ПСЧ", StateFireStation.CALM.getState(), "Комунальная 62", firefighters1));
        allFireStations.add(new FireStation(2L,"2 ПСЧ", StateFireStation.CALM.getState(), "Вокзальная 12а", firefighters2));
        allFireStations.add(new FireStation(3L,"3 ПСЧ", StateFireStation.ON_THE_WAY.getState(), "Инженерная 22", null));
    }

    public String getAllFireStationLocal() {
        StringBuilder builder = new StringBuilder();
        for (FireStation str : allFireStations) {
            builder.append(str.getTitle() + " " + str.getState() + " " + str.getLocation() + " || ");
//            builder.append(str.getTitle() + " " + str.getLocation() + " || ");
        }
        return builder.toString();
    }

    public List<FireStation> getAllFireStations() {
        return allFireStations;
    }

    public List<Firefighter> getFirefighters(int fireStation) {
        switch (fireStation) {
            case 1 : return firefighters1;
            case 2 : return firefighters2;
            case 3 : return firefighters3;
            default: return null;
        }
    }

    public Firefighter addFirefighter(Firefighter firefighter) {
        switch (firefighter.getFireStation()) {
            case 1 : firefighters1.add(firefighter);
                break;
            case 2 : firefighters2.add(firefighter);
                break;
            case 3 : firefighters3.add(firefighter);
                break;
        }
        return firefighter;
    }
}
