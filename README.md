# CdStore
Software of a Cd Store business using JavaFX

The main focus of this software will be to manage all important steps of a CD-Store business. The software keeps
data about all the items in the CD-Store, such as the name of the CD, genre, singer, purchased date, purchase
price etc... At the same time, we keep track of the sold items by bill number, their sold quantities, prices and
date.

The application will have a three-level user system: Cashier, Manager and Administrator; where each will have
different views and usage of the software. Each of these users has a username and a password to enter in
the software.

## **User Levels** 

### **Cashier** 
Has the right to check out the tech-items that a customer may need from the CD-Store. This means that
the cashier should create a bill and enter the data of the bought item, such as the title of the CD and its quantity. If
the CD does not exist or is out of stock, it should automatically give him an alert about it. The software should
provide him the total amount of the bill and it should be in a printable format ([BillNo].txt). The updates in the
software file should be done automatically by adding the data into the respective files.

### **Manager** 
The manager has the right to supply the CD-Store with the needed items. So he may enter in the stock
the new genre and/or add CDs of the same genre to the stock of the CD-Store. He should be informed when
entered in the system if there are few (usually less than 5) items of a category in the CD-Store stock, so he may add
them. The same user may also check the performance of the cashiers by checking their total number of bills, the
CDs sold and the total amount of money made for a certain date or between a certain period of time. Also the
statistics about the CDs sold and bought should be provided to them whenever requested from them daily, monthly
and/or total. The manager keeps a list of suppliers and the CDs they offer.

### **Administrator** 
The administrator has the right to manage almost everything that the Cashier and Manager do.
Beside them he has the right to manage the employees (Cashier and Manager), by registering, modifying and
deleting them including their access to the software. He may keep data about them such as: name, birthday, phone,
email, salary, access level, and other information about them. The software should provide him also data about
total incomes (total of items sold) and total cost (total of items bought and staff salaries) during a period of time.

## **Preview**

![ScreenRecord](https://user-images.githubusercontent.com/77446151/156042709-661c18cf-dbdf-4fbe-9b06-252b14738af3.gif)

###Login View
![LoginView](https://user-images.githubusercontent.com/77446151/156040668-0eb9baab-3f4b-47f8-83d4-2d97489e2b7a.png)


