import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Bank {

    static Scanner input = new Scanner(System.in);
    private Account[] accounts;
    private int numAccounts;
    private File dataFile;

    public Bank(String dataFileName) {
        this.accounts = new Account[100]; // Assuming a maximum of 100 accounts
        this.numAccounts = 0;
        this.dataFile = new File("account.txt");
    }

    // Method to display the menu
    public void displayMainMenu() {
        System.out.println("Welcome to the ABC Bank Account Management System! ");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Please Select an Operation (1-8):");
        System.out.println("1- Add Account");
        System.out.println("2- View All Accounts");
        System.out.println("3- Add Amount");
        System.out.println("4- Withdraw Amount");
        System.out.println("5- View Account Details");
        System.out.println("6- Modify Account");
        System.out.println("7- Close an Account");
        System.out.println("8- Exit");
        System.out.println("--------------------------------------------------------------");
    }

    public boolean addAccount(Account account) {
        if (findAccountByID(account.getId()) == null) {
            accounts[numAccounts++] = account;
            System.out.println("Account added successfully");
            return true;
        } else {
            System.out.println("Account ID already exists. Failed to add account.");
            return false;
        }
    }


    // Method to show account information
    public void displayAccounts() {

        for (int i = 0; i < numAccounts; i++) {
            System.out.println(accounts[i]);
        }
    }


    public void modifyAccountDetails(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.print("Enter the account ID to modify: ");
                int modifyID = scanner.nextInt();
                Account modifyAccountByID = findAccountByID(modifyID);
                if (modifyAccountByID != null) {
                    System.out.print("Choose the attribute to modify (1: ID, 2: Account holder name, 3: Phone number, 4: Account type, 5: Balance): ");
                    int Choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    switch (Choice) {
                        case 1:
                            System.out.print("Enter the new account ID: ");
                            int newID = scanner.nextInt();
                            modifyAccountByID.setId(newID);
                            System.out.println("Account ID modified successfully.");
                            break;
                        case 2:
                            System.out.print("Enter the new account holder name: ");
                            String newHolderName = scanner.nextLine();
                            modifyAccountByID.setHolderName(newHolderName);
                            System.out.println("Account holder name modified successfully.");
                            break;
                        case 3:
                            System.out.print("Enter the new phone number: ");
                            long newPhoneNumber = scanner.nextLong();
                            modifyAccountByID.setPhoneNumber(newPhoneNumber);
                            System.out.println("Phone number modified successfully.");
                            break;
                        case 4:
                            System.out.print("Enter the new account type (s: saving, o: others): ");
                            char newAccountType = scanner.next().charAt(0);
                            modifyAccountByID.setAccountType(newAccountType);
                            System.out.println("Account type modified successfully.");
                            break;
                        case 5:
                            System.out.print("Enter the new balance: ");
                            double newBalance = scanner.nextDouble();
                            modifyAccountByID.setBalance(newBalance);
                            System.out.println("Balance modified successfully.");
                            break;
                        default:
                            System.out.println("Invalid attribute choice. No modifications made.");
                            break;
                    }
                } else
                    System.out.println("Account not found");
                break;
            case 2:
                System.out.print("Enter a part of the account holder name to modify: ");
                //scanner.nextLine(); // Consume the newline character
                String holderName = scanner.nextLine();
                Account modifyAccount = findAccountByHolderName(holderName);
                if (modifyAccount != null) {
                    System.out.print("Choose the attribute to modify (1: ID, 2: Account holder name, 3: Phone number, 4: Account type, 5: Balance): ");
                    int Choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    switch (Choice) {
                        case 1:
                            System.out.print("Enter the new account ID: ");
                            int newID = scanner.nextInt();
                            modifyAccount.setId(newID);
                            System.out.println("Account ID modified successfully.");
                            break;
                        case 2:
                            System.out.print("Enter the new account holder name: ");
                            String newHolderName = scanner.nextLine();
                            modifyAccount.setHolderName(newHolderName);
                            System.out.println("Account holder name modified successfully.");
                            break;
                        case 3:
                            System.out.print("Enter the new phone number: ");
                            long newPhoneNumber = scanner.nextLong();
                            modifyAccount.setPhoneNumber(newPhoneNumber);
                            System.out.println("Phone number modified successfully.");
                            break;
                        case 4:
                            System.out.print("Enter the new account type (s: saving, o: others): ");
                            char newAccountType = scanner.next().charAt(0);
                            modifyAccount.setAccountType(newAccountType);
                            System.out.println("Account type modified successfully.");
                            break;
                        case 5:
                            System.out.print("Enter the new balance: ");
                            double newBalance = scanner.nextDouble();
                            modifyAccount.setBalance(newBalance);
                            System.out.println("Balance modified successfully.");
                            break;
                        default:
                            System.out.println("Invalid attribute choice. No modifications made.");
                            break;
                    }
                } else
                    System.out.println("Account not found");
                break;
            case 3:
                System.out.print("Enter a part of the account holder name to modify: ");
                //scanner.nextLine(); // Consume the newline character
                String partialName = scanner.nextLine();
                modifyAccount = findAccountByPartialName(partialName);
                if (modifyAccount != null) {
                    System.out.print("Choose the attribute to modify (1: ID, 2: Account holder name, 3: Phone number, 4: Account type, 5: Balance): ");
                    int Choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    switch (Choice) {
                        case 1:
                            System.out.print("Enter the new account ID: ");
                            int newID = scanner.nextInt();
                            modifyAccount.setId(newID);
                            System.out.println("Account ID modified successfully.");
                            break;
                        case 2:
                            System.out.print("Enter the new account holder name: ");
                            String newHolderName = scanner.nextLine();
                            modifyAccount.setHolderName(newHolderName);
                            System.out.println("Account holder name modified successfully.");
                            break;
                        case 3:
                            System.out.print("Enter the new phone number: ");
                            long newPhoneNumber = scanner.nextLong();
                            modifyAccount.setPhoneNumber(newPhoneNumber);
                            System.out.println("Phone number modified successfully.");
                            break;
                        case 4:
                            System.out.print("Enter the new account type (s: saving, o: others): ");
                            char newAccountType = scanner.next().charAt(0);
                            modifyAccount.setAccountType(newAccountType);
                            System.out.println("Account type modified successfully.");
                            break;
                        case 5:
                            System.out.print("Enter the new balance: ");
                            double newBalance = scanner.nextDouble();
                            modifyAccount.setBalance(newBalance);
                            System.out.println("Balance modified successfully.");
                            break;
                        default:
                            System.out.println("Invalid attribute choice. No modifications made.");
                            break;
                    }
                } else
                    System.out.println("Account not found");
        }
    }


    public Account viewAccountDetails(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Enter account Id: ");
                int id = input.nextInt();
                return findAccountByID(id);

            case 2:
                System.out.println("Enter account holder name: ");
                String holderName = input.nextLine();
                return findAccountByHolderName(holderName);

            case 3:
                System.out.println("Enter partial account holder name: ");
                String partialName = input.next();
                return findAccountByPartialName(partialName);

            default:
                return null;
        }
    }


    public boolean updateDataFile() {
        try {
            PrintWriter writer = new PrintWriter(dataFile);
            for (int i = 0; i < numAccounts; i++) {
                Account account = accounts[i];
                writer.println(account.getId() + "," + account.getHolderName() + "," +
                        account.getPhoneNumber() + "," + account.getAccountType() + "," +
                        account.getBalance());
            }
            writer.close();
            System.out.println("Data file updated successfully.");
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found. Failed to update data.");
            return false;
        }
    }


    public boolean uploadDataFile() {
        try {
            Scanner scanner = new Scanner(dataFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int id = Integer.valueOf(parts[0]);
                String holderName = parts[1];
                long phoneNumber = Long.valueOf(parts[2]);
                char accountType = parts[3].charAt(0);
                double balance = Double.valueOf(parts[4]);
                Account account = new Account(id, holderName, phoneNumber, accountType, balance);
                addAccount(account);
            }
            scanner.close();
            System.out.println("Data file uploaded successfully.");
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found. Failed to upload data.");
            return false;
        } catch (Exception e) {
            System.out.println("Failed to parse data file. Failed to upload data.");
            return false;
        }
    }

    public void addAmount(double amount) {
        Account account = viewAccountDetails(1); // Search by ID
        if (account != null) {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            System.out.println("Amount added successfully.");
        } else {
            System.out.println("Account not found. Failed to add amount.");
        }
    }

    boolean withdrawAmount(double amount) {
        Account account = viewAccountDetails(1); // Search by ID
        if (account != null) {
            if (account.getAccountType() == 's' && amount > 500) {
                System.out.println("Cannot withdraw more than 500 from a saving account.");
                return false;
            }
            double newBalance = account.getBalance() - amount;
            if (newBalance >= 0) {
                account.setBalance(newBalance);
                System.out.println("Amount withdrawn successfully.");
                return true;
            } else {
                System.out.println("Insufficient funds. Failed to withdraw amount.");
                return false;
            }
        } else {
            System.out.println("Account not found. Failed to withdraw amount.");
            return false;
        }
    }

    public boolean closeAccount(Account account) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].equals(account)) {
                // Shift accounts to fill the gap
                //احنا هان بنستبدل كل حساب ب الي بعده لحد ما يصير الحساب الاخير و قبل الاخير نفس البانات
                for (int j = i; j < numAccounts - 1; j++) {
                    accounts[j] = accounts[j + 1];
                }
                // عملنا ديكريمنت للاراي عشان ما يكون الحساب الاخير و قبل الاخير بنفس البيانات
                numAccounts--;
                return true;
            }
        }
        System.out.println("Account not found. Failed to close account.");
        return false;
    }

    Account findAccountByID(int id) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getId() == id) {
                return accounts[i];
            }
        }
        return null;
    }

    private Account findAccountByHolderName(String holderName) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getHolderName().equalsIgnoreCase(holderName)) {
                return accounts[i];
            }
        }
        return null;
    }

    private Account findAccountByPartialName(String partialName) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getHolderName().toLowerCase().contains(partialName.toLowerCase())) {
                return accounts[i];
            }
        }
        return null;
    }

    Account findAccountByID1(int id) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getId() == id) {
                int nID = input.nextInt();

            }
        }
        return null;
    }


}




