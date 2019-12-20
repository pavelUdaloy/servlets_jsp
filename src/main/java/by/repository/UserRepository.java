package by.repository;

import by.entity.User;
import by.entity.UserValidator;

import java.util.ArrayList;
import java.util.Collection;

public class UserRepository {
    private ArrayList<User> userList = new ArrayList<>();
    private UserValidator userValidator = new UserValidator();
    private static final UserRepository INSTANCE=new UserRepository();
    public void setNewList(Collection<User> userList){
        this.userList= (ArrayList<User>) userList;
    }
    public UserRepository getInstance(){
        return INSTANCE;
    }
    public Collection<User> getUserList(){
        return (Collection<User>) this.userList.clone();
    }

    public boolean add(User user) {
        if (userValidator.validUser(user)) {
            userList.add(user);
            return true;
        } else return false;
    }

    public boolean contains(User user) {
        return userList.contains(user);
    }

    public boolean contains(String eMail) {
        for (User user : userList) {
            if (user.getEmail().equals(eMail)) {
                return true;
            }
        }
        return false;
    }

    public void delete(User user) {
        userList.remove(user);
    }

    public void deleteAll() {
        userList = new ArrayList<User>();
    }

    public User get(String eMail) {
        for (User user : userList) {
            if (user.getEmail().equals(eMail)) {
                return user;
            }
        }
        return null;
    }

    public User get(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public boolean set(int id, User user) {
        if (userValidator.validUser(user)) {
            for (User user1 : userList) {
                if (user1.getId() == id) {
                    user1.setAge(user.getAge());
                    user1.setPass(user.getPass());
                    user1.setFirstName(user.getFirstName());
                    user1.setLastName(user.getLastName());
                    user1.setRole(user.getRole());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean set(String email, User user) {
        if (userValidator.validUser(user)) {
            for (User user1 : userList) {
                if (user1.getEmail().equals(email)) {
                    user1.setAge(user.getAge());
                    user1.setPass(user.getPass());
                    user1.setFirstName(user.getFirstName());
                    user1.setLastName(user.getLastName());
                    user1.setRole(user.getRole());
                    return true;
                }
            }
        }
        return false;
    }

}
