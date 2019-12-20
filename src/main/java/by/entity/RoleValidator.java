package by.entity;

public class RoleValidator {
    public boolean roleValidator(String role){
        for (Roles value : Roles.values()) {
            if (role.equals(value.name())) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RoleValidator().roleValidator("sss"));
    }
}
