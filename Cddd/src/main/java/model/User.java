package model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int NOTDEF = -1;
    public static final int CASHIER = 0;
    public static final int MANAGER = 1;
    public static final int ADMIN = 2;

    private int Id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String number;
    private String email;
    private double salary;
    private int positon = NOTDEF;
    private static int nr=0;

    public User(int id, String username, String password, String name, String surname, String number, String email, double salary, int positon) {
        this.Id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.email = email;
        this.salary = salary;
        this.positon = positon;
    }

    /*public User(){
        this(nr++,"","",NOTDEF);
    }*/

    /*public User(int id, String user, String pass, int pos) {
        super();

        this.Id=id;
        if(nr<Id) nr=Id;
        this.username = user;
        this.password = pass;
        this.positon = pos;
    }
*/

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPositon() {
        return positon;
    }

    public void setPositon(int positon) {
        this.positon = positon;
    }

    public static int getNr() {
        return nr;
    }

    public static void setNr(int nr) {
        User.nr = nr;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", positon=" + positon +
                '}';
    }

    /*ArrayList<Person> user = null;
    private File file = new File("UserData.txt");

    private static User instance = null;


    public User(File file) throws FileNotFoundException {

        this.user = new ArrayList<Person>();

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split("-");
                user.add(new Person(parts[0], parts[1], new Credentials(parts[2], parts[3])));
            }
        }
    }

    public static User getInstance() {
        return instance;
    }

    public int getTypePerson() {
        return typePerson;
    }

    public boolean signUp(Person person) throws IOException {
        if (!sameUsername(person.getCredentials().getUsername())) {
            System.out.println("This username already exists! Please enter another one.");
            return false;
        }
        if (allLabelsFilled(person)) {
            System.out.println("Please fill all the labels");
            return false;
        }
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            this.user.add(person);
            out.println("\n" + person.getName() + "-" + person.getSurname() + "-" +
                    person.getCredentials().getUsername() + "-" + person.getCredentials().getPassword());
            return true;
        } catch (FileNotFoundException e) {
            e.getMessage();
            return false;
        }
    }

    //check if the username given is used by someone else;
    private boolean sameUsername(String username) {
        for (Person pe : this.user) {
            if (pe.getCredentials().getUsername().equals(username))
                return true;
        }
        return false;
    }

    //check if any label is not filled
    private boolean allLabelsFilled(Person person) {
        return person.getName() != null && person.getSurname() != null &&
                person.getCredentials().getUsername() != null && person.getCredentials().getPassword() != null;
    }

    private boolean CheckCredentials(Credentials credentials) {
        for (Person pe : this.user)
            if (pe.getCredentials().equals(credentials))
                return true;
        return false;
    }

    private void changeTypeOfPersonLoggedIn() {
        if (this.loggedIn == null)
            this.typePerson = NOTDEF;

        if (this.loggedIn instanceof Cashier)
            this.typePerson = CASHIER;

        if (this.loggedIn instanceof Manager)
            this.typePerson = MANAGER;

        if (this.loggedIn instanceof Administrator)
            this.typePerson = ADMIN;
    }*/


}
