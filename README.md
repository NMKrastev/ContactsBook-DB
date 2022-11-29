# ContactsBook-DB Console Application

This is simple application that through commands from the console does few operations in a locally created database.</br>
I tried to create something like a phonebook (like the one on our phones) but much simpler as it is my first attempt at working with DB using Java.</br>
<p>
Pre condition that you need to do in order for the application to work:</br>

1. Create a locally hosted DB. I used MySQL on a port: 3306</br>
2. Create a table with the following columns:</br>
   * rowNumber <span style="color:darkorange">INT AUTO_INCREMENT PRIMARY KEY</span>
   * firstName <span style="color:darkorange">VARCHAR(20) NOT NULL</span>
   * lastName <span style="color:darkorange">VARCHAR(20)</span>
   * company <span style="color:darkorange">VARCHAR(50)</span>
   * phoneNumber <span style="color:darkorange">VARCHAR(25) NOT NULL</span>
   * email <span style="color:darkorange">VARCHAR(100)</span>
   * age <span style="color:darkorange">INT(3)</span></br>
3. Or you can use this block of code to create the table directly:</br>
```sql
create table contacts (
rowNumber INT AUTO_INCREMENT PRIMARY KEY,
firstName VARCHAR(20) NOT NULL,
lastName VARCHAR(20),
company VARCHAR(50),
phoneNumber VARCHAR(25) NOT NULL,
email VARCHAR(100),
age INT(3)
)
```
- Note: All values can be change to correspond your specific needs, so feel free to do so!</br>
</p>
<p>
As stated in the begging the application works thanks to some simple commands that are entered on the console.</br>

The commands are as follows:
1. Add contact to the phonebook - <span style="color:green">Press number 1 and then enter</span>
   * Adds new contact in the table.
2. Show all contacts - <span style="color:green">Press number 2 and then enter</span>
   * Shows all contacts that are in the table ordered by first name (asc).
3. Show contact by its phone number - <span style="color:green">Press number 3 and then enter</span>
   * Shows the contact which phone number is entered from the console.
4. Delete contact from phonebook - <span style="color:green">Press number 4 and then enter</span>
   * Deletes a contact from the phonebook by its number as a parameter.
5. Update contact information from phonebook - <span style="color:green">Press number 5 and then enter</span>
   * Update first name - <span style="color:lightgreen">Press 1 and then enter to update first name</span>
     * Updates first name of the contact by using the phone number as a parameter.
   * Update last name - <span style="color:lightgreen">Press 2 and then enter to update last name</span>
     * Updates last name of the contact by using the phone number as a parameter.
   * Update company - <span style="color:lightgreen">Press 3 and then enter to update company</span>
     * Updates company of the contact by using the phone number as a parameter.
   * Update phone number - <span style="color:lightgreen">Press 4 and then enter to update company</span>
     * Updates phone number of the contact by using the phone number as a parameter.
   * Update email - <span style="color:lightgreen">Press 5 and then enter to update email</span>
     * Updates email of the contact by using the phone number as a parameter.
6. Exit the program - <span style="color:green">Press number 6 and then enter</span>
</p>