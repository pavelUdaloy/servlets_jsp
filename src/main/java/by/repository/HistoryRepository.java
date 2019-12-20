package by.repository;

import by.entity.Calculation;
import by.entity.CalculationValidator;
import by.entity.User;
import by.entity.UserValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistoryRepository {
    private static final HistoryRepository INSTANCE = new HistoryRepository();
    private HashMap<User, ArrayList<Calculation>> map = new HashMap<>();
    private CalculationValidator calculationValidator = new CalculationValidator();
    private UserValidator userValidator = new UserValidator();

    public HistoryRepository getInstance() {
        return INSTANCE;
    }

    public void setNewMap(HashMap<User, ArrayList<Calculation>> map) {
        this.map = map;
    }

    public HashMap<User, ArrayList<Calculation>> getMap() {
        return (HashMap<User, ArrayList<Calculation>>) this.map.clone();
    }

    public boolean add(User user, Calculation calculation) {
        if (map.get(user) == null) {
            map.put(user, new ArrayList<Calculation>());
        }
        if (calculationValidator.validCalculation(calculation)) {
            map.get(user).add(calculation);
            return true;
        } else return false;
    }

    public void delete(User user, Calculation calculation) {
        map.get(user).remove(calculation);
    }

    public void deleteAll(User user) {
//        map.put(user, new ArrayList<Calculation>());
        map.remove(user);
    }

    public void deleteAll() {
        map = new HashMap<User, ArrayList<Calculation>>();
    }


    public List<Calculation> get(User user) {
        return map.get(user);
    }
}
