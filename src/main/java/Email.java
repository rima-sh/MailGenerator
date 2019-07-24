import java.util.Random;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Email {
    private transient String name;
    private transient String surname;
    private transient Department department = null;
    private transient String company = "synergy";
    private String password ;
    private String email;

    @JsonCreator
    public Email(@JsonProperty String email, @JsonProperty String password)
    {

    }


    public Email(String FullName) {
        this.name = FullName.split(" ")[0];
        this.surname = FullName.split(" ")[1];
        System.out.println("Email was successfully generated!");
        setDepartment();
        System.out.println( department.toString().substring(0,1).toUpperCase()+
                department.toString().substring(1)
                +" department was chosen.");
        generatePass();
        System.out.println("Your password is: "+  getPassword());

        String dep =(department.equals(null))? "": department.toString()+".";
        email =( getName()+"."+ getSurname()+"@"+dep+company+".com").toLowerCase();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment() {
        System.out.println("Choose the department \n    1 for sales" +
                "\n    2 for development \n    3 for accounting \n    0 for other.........");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt())
        {
            case 1: department = Department.sales; break;
            case 2: department = Department.development; break;
            case 3: department = Department.accounting; break;
        }
        sc.close();
    }
    private void generatePass()
    {
        String symbols = "abcdefghijklmnopqrstuvwxyz0123456789*/-+%$#@!#$^&()_";

        char[] pasChar = symbols.toCharArray();
        for (int i = 1; i < 16 ; i++) {
            Random rand = new Random();
            password+= pasChar[rand.nextInt(pasChar.length)];
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }
}
enum Department {
    sales, development, accounting
}