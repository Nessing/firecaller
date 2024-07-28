package ru.nessing.firecaller.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nessing.firecaller.dispatcher.repositories.*;
import ru.nessing.firecaller.entities.*;
import ru.nessing.firecaller.entities.DTOs.FirefighterDTO;

import java.util.*;

@Service
public class DispatcherService {

    private final FirefightersRepository firefightersRepository;
    private final PositionRepository positionRepository;
    private final FireStationRepository fireStationRepository;
    private final CarsRepository carsRepository;
    private final TeamRepository teamRepository;
    private final RankRepository rankRepository;

    @Autowired
    public DispatcherService(FirefightersRepository firefightersRepository,
                             PositionRepository positionRepository,
                             FireStationRepository fireStationRepository,
                             CarsRepository carsRepository,
                             TeamRepository teamRepository,
                             RankRepository rankRepository)
    {
        this.firefightersRepository = firefightersRepository;
        this.positionRepository = positionRepository;
        this.fireStationRepository = fireStationRepository;
        this.carsRepository = carsRepository;
        this.teamRepository = teamRepository;
        this.rankRepository = rankRepository;
    }

    private List<FireStation> allFireStations = new ArrayList<>();

    private Map<Long, String> positions = new HashMap<>();

    private  List<Firefighter> firefighters1 = new ArrayList<>();
    private  List<Firefighter> firefighters2 = new ArrayList<>();
    private  List<Firefighter> firefighters3 = new ArrayList<>();

    private List<Square> squareStation1 = new ArrayList<>();
    private List<Square> squareStation2 = new ArrayList<>();

    {
        /* список частей */
        allFireStations.add(new FireStation(1L, 1,"1 пожарно-спасательная часть - П 01", "1 ПСЧ", "Комунальная 62"));
        allFireStations.add(new FireStation(2L, 11, "Отдельный пост 1 пожарно-спасательной части - П 011","ОП 1 ПСЧ", "Максима Горького, 16"));
        allFireStations.add(new FireStation(3L, 2, "2 пожарно-спасательная часть - П 02", "2 ПСЧ", "Вокзальная 12а"));
        allFireStations.add(new FireStation(4L, 3, "3 пожарно-спасательная часть - П 03", "3 ПСЧ", "Инженерная 5"));
        allFireStations.add(new FireStation(5L, 31, "Отдельный пост 3 пожарно-спасательной части - П 031", "ОП 3 ПСЧ", "Инженерная 92"));

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
//        firefighters1.add(new Firefighter(1L, "С.И. Иванов", "Начальник караула", 1L, allFireStations.get(0)));
//        firefighters1.add(new Firefighter(2L, "А.С. Петров", "Помощник нач. караула", 2L, allFireStations.get(0)));
//        firefighters1.add(new Firefighter(3L, "К.Ю. Сидоров", "Командир отделения 1", 3L, allFireStations.get(0)));
//        firefighters1.add(new Firefighter(4L, "М.С. Волин", "Водитель отделения 1", 4L, allFireStations.get(0)));
//        firefighters1.add(new Firefighter(5L, "К.И. Романов", "1 пожарный отделения 1", 5L, allFireStations.get(0)));
//        firefighters1.add(new Firefighter(11L, "Н.В. Гирин", "Водитель АЛ", 11L, allFireStations.get(0)));

        /* л/с 2 часть */
//        firefighters2.add(new Firefighter(1L,"Р.М. Михайлов", "Начальник караула", 1, 2));
//        firefighters2.add(new Firefighter(2L,"И.Ф. Федоров", "ПНК", 2, 2));
//        firefighters2.add(new Firefighter(3L,"П.В. Орехов", "Старший пожарный", 3, 2));

        /* машины 1 части */
//        squareStation1.add(new Square(1L, 1, "1 АЦ 1", StateFireStation.ON_THE_WAY.getState(), "Генерала Маргелова 3"));
//        squareStation1.add(new Square(2L, 2, "1 АЦ 2", StateFireStation.CALM.getState(), "Комунальная 62"));
//        squareStation1.add(new Square(3L, 3,"1 АЛ 1", StateFireStation.CALM.getState(), "Комунальная 62"));
//
//        /* машины 2 части */
//        squareStation2.add(new Square(1L, 1, "2 АЦ 1", StateFireStation.ON_THE_DESTINATION.getState(), "Яна Фабрициуса 11"));
//        squareStation2.add(new Square(2L, 2, "2 АЦ 2", StateFireStation.ON_THE_DESTINATION.getState(), "Яна Фабрициуса 11"));
//        squareStation2.add(new Square(3L, 3,"2 АЛ 1", StateFireStation.CALM.getState(), "Вокзальная 12а"));
    }

    /** use DB **/
//    public Firefighter createTestFirefighter() {
//        Firefighter firefighter = Firefighter.builder()
//                .id(null)
//                .name("Алексей")
//                .rank("Первый ранг")
//                .position(1L)
//                .fireStation(allFireStations.get(0))
//                .build();
//        return firefightersRepository.save(firefighter);
//    }

    public Firefighter getFire(Long id) {
        return firefightersRepository.findFirefighterById(id);
    }
    /****/

    public List<FireStation> getAllFireStations() {
        return fireStationRepository.findAll();
    }

    public Map<Long, String> getPositions() {
        return positions;
    }

    public List<Firefighter> getFirefighters(Long fireStation) {
        return firefightersRepository.findFirefightersByFireStation_Id(fireStation);
    }

    public List<Car> getCars(Long fireStation) {
        return carsRepository.findCarsByFireStation_Id(fireStation);
    }

    public List<Square> getSquare(int fireStation) {
        switch (fireStation) {
            case 1 : return squareStation1;
            case 2 : return squareStation2;
//            case 3 : return firefighters3;
            default: return null;
        }
    }

    public Boolean addFirefighter(Firefighter firefighter) {
        FirefighterDTO firefighterDTO = new FirefighterDTO();
        firefighterDTO.createShortName(firefighter.getFirstName(), firefighter.getMidName(), firefighter.getLastName());
        firefighter.setId(null);
        firefighter.setShortName(firefighterDTO.getShortName());
//        firefighter.setRank("Сержант");
        if (firefighter.getPosition() == null) {
            return false;
        }
        if (firefighter.getFireStation() == null) {
            return false;
        }
        FireStation fireStation = fireStationRepository.findFireStationById(firefighter.getFireStation().getId());
        firefighter.setFireStation(fireStation);
        firefightersRepository.save(firefighter);
        return true;
    }

    public Boolean deleteFirefighter(Long id) {
        if (id != null) {
            firefightersRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean addPosition(String position) {
        if (positionRepository.findPositionByName(position) == null) {
                Position newPosition = Position.builder()
                        .id(null)
                        .name(position)
                        .build();
                positionRepository.save(newPosition);
                return true;
        }
        return false;
    }

    public Boolean addRank(String rank) {
        if (rankRepository.findRankByName(rank) == null) {
            Rank newRank = Rank.builder()
                    .id(null)
                    .name(rank)
                    .build();
            rankRepository.save(newRank);
            return true;
        }
        return false;
    }

    public Boolean deletePosition(Position position) {
        Position pos = positionRepository.findPositionByName(position.getName());
        if (pos != null) {
            positionRepository.delete(pos);
            return true;
        }
        return false;
    }

    public Boolean deleteRank(Rank rank) {
        Rank pos = rankRepository.findRankByName(rank.getName());
        if (pos != null) {
            rankRepository.delete(pos);
            return true;
        }
        return false;
    }

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public List<Rank> getAllRanks() {
        return rankRepository.findAll();
    }

    public Optional<FireStation> getFireStation(Long stationId) {
        return fireStationRepository.findById(stationId);
    }

    public List<Square> getSquareOfStation(Long stationId) {
        List<Square> squares = new ArrayList<>();
        FireStation fireStation = fireStationRepository.findFireStationById(stationId);
        List<Firefighter> firefighters = firefightersRepository.findFirefightersByFireStation_Id(stationId);
        List<Car> cars = carsRepository.findCarsByFireStation_Id(stationId);

        for (Car car : cars) {
            Square square = new Square();
            square.setFireStation(fireStation);
            square.setCar(car);
            square.setTeam(car.getTeam());
            for (Firefighter firefighter : firefighters) {
                if (firefighter.getTeam() != null && firefighter.getTeam().equals(square.getTeam())) {
                    square.getFirefighters().add(firefighter);
                }
            }
            squares.add(square);
        }
        return squares;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }


    public Boolean createCar(Car car) {
        if (carsRepository.findCarByNameAndAndNumberCar(car.getName(), car.getNumberCar()) == null) {
            carsRepository.save(car);
            return true;
        } else {
            return false;
        }
    }

}
