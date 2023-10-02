import java.util.*;

public class Driver {

    // we use static to be able to the Scanner in any method inside this class
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        //we call up the class Bank by adding an object called bank

        Bank bank = new Bank("account.txt");



        bank.uploadDataFile();

        //we call up the method displayMainMenu from the class Bank by the object bank to show the menu

        bank.displayMainMenu();

        String x = in.next();

        char choice;
        if (x.length() == 1)
            choice = x.charAt(0);
        else
            choice = '0';
        // we do this here to let the program continue when user enter character or word
        while (choice != '8') {

            // each case call up a specific method from Bank class by bank object
            switch (choice) {
                case '1': {

                    // This to add the id of the new account
                    System.out.println("Enter the ID of the new account: ");
                    int id = in.nextInt();

                    // This to verify the id of the account again
                    System.out.println("Enter the ID of the new account again to verify: ");
                    int id1 = in.nextInt();


                    // we do this to make the zero in left has a value
                    /*مثلا الانتجر يعتبر ان الصفر على اليسار لا قيمة له لو ادخلت رقم الاي دي 122 و فالمرة الثانية ادخلته 0122 سيعتبرهن متساويات في حالة الانتجر و لكن في حالة السترينغ لا
                     عملنا هاي الحركة لانه فالاي دي الصفر على اليسار بفرق
                      */

                    while (id != id1) {

                        System.out.println("The two ids are not identical");
                        break;
                    }
                    if (id != id1)
                        break;

                    in.nextLine();
                    //This to enter the holder name of the new account
                    System.out.println("Enter the Holder Name: ");

                    // we use nextLine not next to  reads input including space between the words (that is, it reads till the end of line)
                    String HolderName = in.nextLine();


                    try {
                        while (true) {
                            Integer.parseInt(HolderName); // Attempt to parse the input as an integer
                            System.out.println("Error: Invalid input. Please enter a string.");
                            HolderName = in.nextLine();
                        }
                    } catch (NumberFormatException e) {

                    }

                    // This to enter the phone number of the owner of the new account
                    //عملنا هاي الحركة عشان نتاكد انو اليوزر دخل رقم التلفون خالي من الاحرف و من الرموز لذلك عرفنا متغير سترينغ و بعدها عملنا ميثود بتحول السترينغ ل لونغ
                    // استخدمنا ال ASCII CODE فالحل عشان نعرف اذا بحتوي على رموز او احرف
                    System.out.println("Enter the phone number: ");
                    String s = in.nextLine();
                    int[] q = {0};
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                                System.out.println("You cannot use letters in index : " + (i + 1));
                            } else {
                                System.out.println("You cannot use symbols in index : " + (i + 1));
                            }
                            System.out.println();
                            System.out.print("Please enter your number again: ");
                            s = in.nextLine();
                            i = -1;
                        }
                    }
                    long PhoneNumber = convert(s, q);
                    // this to add zero to the left of the number if the user enter zero to the left
                    for (int i = 0; i < q[0]; i++) {
                        PhoneNumber = '0' + PhoneNumber;
                    }


                    // This to enter the type of the account
                    System.out.println("Enter the type of the account (s: saving, o: others): ");
                    //We use a string to check if the input is a character or a string
                    String input = in.next();

                    //here we check if the input string or char by check the length of the input
                    char type;
                    if (input.length() == 1) {
                        type = input.charAt(0);
                    } else {
                        type = ' ';
                    }

                    while (type != 's' && type != 'S' && type != 'o' && type != 'O') {
                        System.out.println("Invalid input. You should enter a single character (s: saving, o: others):");
                        input = in.next();

                        if (input.length() == 1) {
                            type = input.charAt(0);
                        } else {
                            type = ' ';
                        }
                    }


                    System.out.println("Enter the balance of the new account: ");
                    double balance;
                    while (true) {
                        try {
                            //This to enter the balance of the account
                            balance = in.nextDouble();
                            break;
                        }

                        //InputMismatchException – if the next token does not match the Integer regular expression, or is out of range

                        catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a double value :\n");

                            in.nextLine(); // this to clear non-double input from the buffer

                        }

                    }
                    Account account11 = new Account(id, HolderName, PhoneNumber, type, balance);
                    bank.addAccount(account11);

                    break;

                }
                case '2': {
                    bank.displayAccounts();
                    break;
                }
                case '3': {
                    // when user choose 3 the program will add the amount
                    try {
                        System.out.println("Enter amount to add: ");
                        double amountToAdd = in.nextDouble();
                        bank.addAmount(amountToAdd);
                    } catch (InputMismatchException e) {
                        System.out.println("Enter again. The amount should be double: ");
                        in.nextLine();
                        double amountToAdd = in.nextDouble();
                        bank.addAmount(amountToAdd);
                    }
                    break;
                }
                case '4': {
                    // when user choose 4 the program will decrease
                    try {
                        System.out.println("Enter withdraw amount:");
                        double amount = in.nextDouble();
                        bank.withdrawAmount(amount);
                    } catch (InputMismatchException e) {
                        System.out.println("Enter withdraw amount again(should be double): ");
                        in.nextLine();// to clear non-integer from buffer memory
                        double amount = in.nextDouble();
                        bank.withdrawAmount(amount);
                    }
                    break;
                }
                case '5': {

                    System.out.println("Enter 1 to search by the id:\nEnter 2 to search by the holder name:\nEnter 3 to search by the parcial name:");
                    int choiceToView = in.nextInt();

                    Account searchedAccount = bank.viewAccountDetails(choiceToView);
                    if (searchedAccount != null) {
                        System.out.println(searchedAccount);
                    } else {
                        System.out.println("Account not found.");
                    }

                    break;
                }
                case '6': {
                    int option;
                    System.out.println("Modify by (1: ID, 2: Account holder name, 3: Partial name): ");
                    option = in.nextInt();
                    bank.modifyAccountDetails(option);

                    break;
                }
                case '7': {
                    System.out.println("Enter account ID to close: ");
                    int closeChoice = in.nextInt();
                    Account closeAccount = bank.findAccountByID(closeChoice);
                    if (closeAccount != null) {
                        bank.closeAccount(closeAccount);
                        System.out.println("Account closed successfully.");
                    } else {
                        System.out.println("Account not found. Failed to close account.");
                    }
                    break;
                }

                // when user enter wronge input this will appear ( wronge input like characters, words,numbers less thean 1 or above 8

                default:
                    System.out.println("Invalid input. Please Select an Operation (1-8):\n" + "-----------------------------------------\n");
                    System.out.println();

            }
            bank.displayMainMenu();

            x = in.next();

            if (x.length() == 1)
                choice = x.charAt(0);
            else
                choice = '0';
        }

        bank.updateDataFile();
        System.out.println("Thank you!");


    }

    public static long convert(String s, int[] q) {

        long sum = 0;
        int a = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                boolean y = true;
                for (int x = 0; x < i; x++) {
                    if (s.charAt(x) != '0') {
                        y = false;
                    }
                }
                if (y) {
                    q[0]++;
                }
            }
            sum += ((s.charAt(i) - '0') * (Math.pow(10, a)));
            a--;
        }

        return sum;
    }


}