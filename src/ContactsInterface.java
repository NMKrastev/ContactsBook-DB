public interface ContactsInterface {
    public boolean addContact(Contact contact);
    public boolean deleteContact(int row);
    public boolean updateContact(int row, String update, int ch, Contact contact);
    public void showAllContacts();
    public boolean showContactByPhoneNumber(String phoneNumber);
}
