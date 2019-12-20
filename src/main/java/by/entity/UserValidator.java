package by.entity;

import by.repository.UserRepository;

public class UserValidator {
    public boolean validEmail(String email){
        UserRepository userRepository = new UserRepository().getInstance();
        if (userRepository.contains(email)) {
            return false;
        }else return email.length()>=3;
    }
    public boolean validFirstName(String firstName){
        return firstName.length()>=3;
    }
    public boolean validLastName(String lastName){
        return lastName.length()>=3;
    }
    public boolean validAge(String age){
        try {
            int i = Integer.parseInt(age);
            return i>=18;
        }catch (NumberFormatException | NullPointerException e){
            return false;
        }
    }
    public boolean validAge(int age){
        return age>=18;
    }
    public boolean validRole(String role){
        return new RoleValidator().roleValidator(role);
    }
    public boolean validPassword(String password){
        return password.length()>=8;
    }
    public boolean validUser(User user){
        return (validAge(user.getAge()) && validEmail(user.getEmail()) && validFirstName(user.getFirstName())&&
                validLastName(user.getLastName()) && validPassword(user.getPass()) && validRole(user.getRole().getName()));
    }
    public boolean validMainData(String password, String email){
        return (validPassword(password)&&validEmail(email));
    }
}
