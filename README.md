# Bank-Accounts
#Bank-Accounts

This is a spring boot application.

It is developped with spring data, spring webMVC and spring Security to create accounts and manage authentication.

The front end is developped with thymleaf. Requirement: MySQL database named "mybank" running on port 3306

to launch application either:

-run the class "BankAccountsApplication" as Java application

OR

-run the command "mvn clean install"

then enter this URL in your browser: http://localhost:8081/

When application starts a user with name "Moncef.NSIRI" will be created with password "1234" and 2 accounts "accnt1" and "accnt2" will be affected to this user and some deposit and withdrawal operations will be done on these accounts.

When entering the account code, you can:

-consult operation history

-make deposit and withdrawal operations
