package Concurrency;

import java.util.HashMap;
import java.util.HashSet;

public class HashCodeEquals {
    public static void main(String[] args) {
        User user=new User("CK","LOB",2000);
        User userDup=new User("CK","LOB",2000);
        User userd=new User("CK","LOB",2000);
        User user1=new User("ab","LOB",2000);
        User user2=new User("cd","LOB",2000);
        HashSet<User> hs=new HashSet<>();
        hs.add(user);
        hs.add(user1);
        hs.add(user2);
        hs.add(userDup);
        hs.add(userd);
        System.out.println(hs.size());
        System.out.println(hs);
    }



}

 class User
{
    String userName;
    String department;
    Integer salary;

    public User(String userName, String department, Integer salary) {
        this.userName = userName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (department != null ? !department.equals(user.department) : user.department != null) return false;
        return salary != null ? salary.equals(user.salary) : user.salary == null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }
}
