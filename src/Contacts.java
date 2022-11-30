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
            String query = "DELETE FROM contacts WHERE phoneNumber=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.executeUpdate();
            isPhoneDeleted = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isPhoneDeleted;
    }

    @Override
    public boolean updateContact(int row, String update, int command, Contact contact) {
        boolean isUpdated = false;
        try {
            Connection connection = DBConnection.createConnection();
            if (command == 1) {
                String query = "UPDATE contacts SET firstName=? WHERE rowNumber=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, update);
                preparedStatement.setInt(2, row);
                preparedStatement.executeUpdate();
                isUpdated = true;
            } else if (command == 2) {
                String query = "UPDATE contacts SET lastName=? WHERE rowNumber=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, update);
                preparedStatement.setInt(2, row);
                preparedStatement.executeUpdate();
                isUpdated = true;
            } else if (command == 3) {
                String query = "UPDATE contacts SET company=? WHERE rowNumber=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, update);
                preparedStatement.setInt(2, row);
                preparedStatement.executeUpdate();
                isUpdated = true;
            } else if (command == 4) {
                String query = "UPDATE contacts SET phoneNumber=? WHERE rowNumber=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, update);
                preparedStatement.setInt(2, row);
                preparedStatement.executeUpdate();
                isUpdated = true;
            } else if (command == 5) {
                String query = "UPDATE contacts SET email=? WHERE rowNumber=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, update);
                preparedStatement.setInt(2, row);
                preparedStatement.executeUpdate();
                isUpdated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
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
        System.out.println();
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
                System.out.println();
                isPhonePresent = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isPhonePresent;
    }

    public static int getRowNumber(String phoneNumber) {
        int rowNum = 0;
        try {
            Connection connection = DBConnection.createConnection();
            String query = String.format("SELECT * FROM contacts WHERE phoneNumber='%s'", phoneNumber);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                rowNum = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowNum;
    }
}
