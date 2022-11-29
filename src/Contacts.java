import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Contacts implements ContactsInterface {
    @Override
    public boolean addContact(Contact contact) {
        boolean isAdded = false;
        try {
            Connection connection = DBConnection.createConnection();
            String query = "insert into contacts(firstName,lastName,company,phoneNumber,email,age) value(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.setString(3, contact.getCompany());
            preparedStatement.setString(4, contact.getPhoneNumber());
            preparedStatement.setString(5, contact.getEmail());
            preparedStatement.setInt(6, contact.getAge());
            preparedStatement.executeUpdate();
            isAdded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public boolean deleteContact(String phoneNumber) {
        boolean isPhoneDeleted = false;
        try {
            Connection connection = DBConnection.createConnection();
            String query = String.format("DELETE FROM contacts WHERE phoneNumber='%s'", phoneNumber);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            isPhoneDeleted = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isPhoneDeleted;
    }

    @Override
    public boolean updateContact(int row, String update, int ch, Contact contact) {
        return false;
    }

    @Override
    public void showAllContacts() {
        try {
            Connection connection = DBConnection.createConnection();
            String query = "SELECT * FROM contacts ORDER BY firstName ASC";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.printf("First name: %s; Last name: %s; Company: %s; Phone Number: %s; Email: %s; Age: %d\n",
                        resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getInt(7));
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean showContactByPhoneNumber(String phoneNumber) {
        boolean isPhonePresent = false;
        try {
            Connection connection = DBConnection.createConnection();
            String query = String.format("SELECT * FROM contacts WHERE phoneNumber='%s'", phoneNumber);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.printf("First name: %s; Last name: %s; Company: %s; Phone Number: %s; Email: %s; Age: %d\n",
                        resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getInt(7));
                isPhonePresent = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isPhonePresent;
    }
}
