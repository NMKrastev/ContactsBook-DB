public class Contact {
    private int rowNumber;
    private String firstName;
    private String lastName;
    private String company;
    private String phoneNumber;
    private String email;
    private int age;

    public  Contact() {

    }

    public Contact(String firstName, String lastName, String company, String phoneNumber, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    public Contact(int rowNumber, String firstName, String lastName, String company, String phoneNumber, String email, int age) {
        this.rowNumber = rowNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "rowNumber=" + rowNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
