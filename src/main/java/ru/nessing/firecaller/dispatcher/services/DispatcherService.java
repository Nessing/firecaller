package ru.nessing.firecaller.dispatcher.services;

import org.springframework.stereotype.Service;
import ru.nessing.firecaller.entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DispatcherService {

    private List<FireStation> allFireStations = new ArrayList<>();

    private Map<Long, String> positions = new HashMap<>();

    private  List<Firefighter> firefighters1 = new ArrayList<>();
    private  List<Firefighter> firefighters2 = new ArrayList<>();
    private  List<Firefighter> firefighters3 = new ArrayList<>();

    private List<Square> squareStation1 = new ArrayList<>();
    private List<Square> squareStation2 = new ArrayList<>();

    {
        /* список частей */
        allFireStations.add(new FireStation(1L, 1,"1 пожарно-спасательная часть - П 01", "1 ПСЧ", StateFireStation.CALM.getState(), "Комунальная 62", firefighters1));
        allFireStations.add(new FireStation(2L, 11, "Отдельный пост 1 пожарно-спасательной части - П 011","ОП 3 ПСЧ", StateFireStation.ON_THE_WAY.getState(), "Максима Горького", null));
        allFireStations.add(new FireStation(3L, 2, "2 пожарно-спасательная часть - П 02", "2 ПСЧ", StateFireStation.CALM.getState(), "Вокзальная 12а", firefighters2));
        allFireStations.add(new FireStation(4L, 3, "3 пожарно-спасательная часть - П 03", "3 ПСЧ", StateFireStation.ON_THE_WAY.getState(), "Инженерная 22", null));
        allFireStations.add(new FireStation(5L, 31, "Отдельный пост 3 пожарно-спасательной части - П 031", "ОП 3 ПСЧ", StateFireStation.ON_THE_WAY.getState(), "Инженерная 92", null));

        /* список должностей */
        positions.put(1L, "Начальник караула");
        positions.put(2L, "Помощник нач. караула");
        positions.put(3L, "Командир отделения 1");
        positions.put(4L, "Водитель отделения 1");
        positions.put(5L, "1 пожарный отделения 1");
        positions.put(6L, "2 пожарный отделения 1");
        positions.put(7L, "Командир отделения 2");
        positions.put(8L, "Водитель отделения 2");
        positions.put(9L, "1 пожарный отделения 2");
        positions.put(10L, "2 пожарный отделения 2");
        positions.put(11L, "Водитель АЛ");

        /* л/с 1 часть */
        firefighters1.add(new Firefighter(1L, "С.И. Иванов", "Начальник караула", 1L, 1));
        firefighters1.add(new Firefighter(2L, "А.С. Петров", "Помощник нач. караула", 2L, 1));
        firefighters1.add(new Firefighter(3L, "К.Ю. Сидоров", "Командир отделения 1", 3L, 1));
        firefighters1.add(new Firefighter(4L, "М.С. Волин", "Водитель отделения 1", 4L, 1));
        firefighters1.add(new Firefighter(5L, "К.И. Романов", "1 пожарный отделения 1", 5L, 1));
        firefighters1.add(new Firefighter(11L, "Н.В. Гирин", "Водитель АЛ", 11L, 1));

        /* л/с 2 часть */
        firefighters2.add(new Firefighter(1L,"Р.М. Михайлов", "Начальник караула", 1L, 2));
        firefighters2.add(new Firefighter(2L,"И.Ф. Федоров", "ПНК", 2L, 2));
        firefighters2.add(new Firefighter(3L,"П.В. Орехов", "Старший пожарный", 3L, 2));

        /* машины 1 части */
        squareStation1.add(new Square(1L, 1, "1 АЦ 1", StateFireStation.ON_THE_WAY.getState(), "Генерала Маргелова 3"));
        squareStation1.add(new Square(2L, 2, "1 АЦ 2", StateFireStation.CALM.getState(), "Комунальная 62"));
        squareStation1.add(new Square(3L, 3,"1 АЛ 1", StateFireStation.CALM.getState(), "Комунальная 62"));

        /* машины 2 части */
        squareStation2.add(new Square(1L, 1, "2 АЦ 1", StateFireStation.ON_THE_DESTINATION.getState(), "Яна Фабрициуса 11"));
        squareStation2.add(new Square(2L, 2, "2 АЦ 2", StateFireStation.ON_THE_DESTINATION.getState(), "Яна Фабрициуса 11"));
        squareStation2.add(new Square(3L, 3,"2 АЛ 1", StateFireStation.CALM.getState(), "Вокзальная 12а"));
    }

    public List<FireStation> getAllFireStations() {
        return allFireStations;
    }

    public Map<Long, String> getPositions() {
        return positions;
    }

    public List<Firefighter> getFirefighters(int fireStation) {
        switch (fireStation) {
//            case 1 : return firefighters1;
            case 1 : {
                List<Firefighter> firefighters = firefighters1;
                for (Firefighter firefighter : firefighters) {
                    firefighter.setRank(positions.get(firefighter.getPosition()));
                }
                return firefighters;
            }
            case 2 : {
                List<Firefighter> firefighters = firefighters2;
                for (Firefighter firefighter : firefighters) {
                    firefighter.setRank(positions.get(firefighter.getPosition()));
                }
                return firefighters;
            }
            case 3 : return firefighters3;
            default: return null;
        }
    }

    public List<Square> getSquare(int fireStation) {
        switch (fireStation) {
            case 1 : return squareStation1;
            case 2 : return squareStation2;
//            case 3 : return firefighters3;
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
