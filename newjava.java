
import java.awt.SystemTray;
import java.util.*;
import java.util.regex.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

class newjava {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        String[] menu_list = {"1 --------- Register.", "2 --------- Login.", "3 --------- Services List.", "4 --------- Select Service.", "5 --------- Search Customer by Number", "6 --------- Search Customer by ID.", "7 --------- Search Customer by Service.", "8 --------- Search Services by Customer.", "9 --------- Logout.", "10 --------- Exit."};
        Customer customer_logged_in = null;
        Customer[] customers = new Customer[100];
        Counter cus_no = new Counter(0);

        int customer_ids[] = new int[100];

        System.out.println("Hello! Welcome to the App.");
        System.out.println();

        do {
            for (String service : menu_list) {
                System.out.println(service);
            }
            x = sc.nextInt();

            switch (x) {
                case (1): {
                    System.out.println("Registration Page ! Go Ahead. We'll wait while you fill in the details.");

                    Register(customers, cus_no);
                    System.out.println();
                    System.out.println("Alright! So now you're registered. Go ahead, login and utilize our services.");
                    System.out.println();
                    break;
                }
                case (2): {
                    if (customer_logged_in != null) {
                        System.out.println("Already Logged in.");
                    } else {
                        System.out.println(cus_no);
                        customer_logged_in = Login(customers, cus_no);
                    }
                    break;
                }
                case (3): {
                    Services_List();
                    break;
                }
                case (4): {
                    if (customer_logged_in != null) {
                        Select_Service(customers, customer_logged_in);
                    } else {
                        System.out.println("No User Logged-in.");
                    }
                    break;
                }
                case (5): {
                    if (customer_logged_in != null) {

                        //Search_Customer_by_Number(); 
                    }
                    //else 
                    {
                        System.out.println("No user logged-in.");
                    }

                    break;
                }
                case (6): {
                    if (customer_logged_in != null) {
                        //Search_Customer_by_ID(); 
                    } else {
                        System.out.println("No user logged-in.");
                    }

                    break;
                }
                case (7): {
                    if (customer_logged_in != null) {
                        Search_Customer_By_Service(customers);
                    } else {
                        System.out.println("No user logged-in.");
                    }
                    break;
                }
                case (8): {
                    if (customer_logged_in != null) {
                        Search_Service_By_Customer(customers, cus_no);
                    } else {
                        System.out.println("No user logged-in.");
                    }
                    break;
                }
                case (9): {
                    if (customer_logged_in != null) {
                        customer_logged_in.Logout();
                        customer_logged_in = null;
                        break;
                    }
                }
                case (10): {
                    System.out.println("Exiting.");
                    break;
                }
                default: {
                    System.out.println("Key not recognized.");
                }
            }
        } while (x != 10);
        //sc.close();
    }

    public static void Register(Customer[] customers, Counter cus_no) {
        customers[cus_no.value++] = new Customer(cus_no);
        System.out.println(cus_no.value);
    }

    public static Customer Login(Customer[] customers, Counter cus_no) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter password: ");
        String p = sc.nextLine();
        boolean user_ = false;
        for (int i = 0; i < cus_no.value; i++) {
            if (id == customers[i].get_id()) {
                System.out.println("ID");
                user_ = true;
                if (p.equals(customers[i].get_password())) {
                    customers[i].Login();
                    return customers[i];
                }
            }
        }
        if (user_ == false) {
            System.out.println("User not registered.");
        } else {
            System.out.println("Wrong password entered.");
        }
        //sc.close();
        return null;
    }

    public static void Services_List() {
        String[] services = {"1 --------- TV Repair.", "2 --------- Washing Machine Repair."};

        for (String service : services) {

            System.out.println(service);

        }

        System.out.println();

    }

    public static void Select_Service(Customer[] customers, Customer customer_logged_in) {

        System.out.println("Welcome to the Services Menu.");
        System.out.println();
        String[] services = {"1 --------- TV Repair.", "2 --------- Washing Machine Repair.", "3 --------- Exit."};
        System.out.println();

        int x;

        Scanner sc = new Scanner(System.in);

        do {
            for (String service : services) {
                System.out.println(service);
            }

            System.out.print("Enter: ");
            x = sc.nextInt();
            switch (x) {

                case (1): {

                    customer_logged_in.generate_TV_Repair();
                    System.out.println();
                    break;
                }
                case (2): {
                    customer_logged_in.generate_Washing_Machine_Repair();
                    System.out.println();
                    break;
                }
                case (3): {
                    break;
                }
                default: {
                    System.out.println("Key not recognized.");
                }
            }
        } while (x != 3);
        //sc.close();
    }

    /*public static void TV_Repairr(Customer customer) { TV_Repair tv_repair = new TV_Repair(customer); }*/
    public static void Search_Customer_By_Service(Customer[] customers) {

        Scanner sc = new Scanner(System.in);

        String[] services = {"1 --------- TV Repair", "2 --------- Washing Machine Repair.", "3 --------- Exit."};

        System.out.println("Enter: ");

        int x;

        do {
            for (String service : services) {

                System.out.println(service);

            }
            System.out.println("Enter: ");

            x = sc.nextInt();

            switch (x) {

                case (1): {

                    Arrays.sort(TV_Repair.customers_TV_Repair, new customer_id_sort());

                    for (int i = 0; i < TV_Repair.tv_req; i++) {
                        System.out.println(TV_Repair.customers_TV_Repair[i].get_id());

                        System.out.println(TV_Repair.customers_TV_Repair[i].get_Name());

                        System.out.println(TV_Repair.customers_TV_Repair[i].get_email());
                    }

                    System.out.println();
                }

                break;

                case (2): {

                    Arrays.sort(Washing_Machine.customers_Washing_Machine_Repair, new customer_id_sort());

                    /*for(int j=0;j<Washing_Machine.customers_Washing_Machine_Repair.length;j++); { System.out.println(Washing_Machine.customers_Washing_Machine_Repair[j].get_id()); System.out.println(Washing_Machine.customers_Washing_Machine_Repair[j].get_Name()); System.out.println(Washing_Machine.customers_Washing_Machine_Repair[j].get_email()); }*/
                    for (int i = 0; i < Washing_Machine.washing_req; i++) {
                        System.out.println(Washing_Machine.customers_Washing_Machine_Repair[i].get_id());

                        System.out.println(Washing_Machine.customers_Washing_Machine_Repair[i].get_Name());

                        System.out.println(Washing_Machine.customers_Washing_Machine_Repair[i].get_email());
                    }

                    System.out.println();
                }

                break;

                case (3): {
                    break;
                }

                default: {
                    System.out.println("Select Again.");
                }
            }
        } while (x != 0);
        //sc.close();
    }

    public static void Search_Service_By_Customer(Customer[] customers, Counter cus_no) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customer id: ");
        int x = sc.nextInt();
        for (int i = 0; i < cus_no.value; i++) {
            if (x == customers[i].get_id()) {
                customers[i].get_services();
            }
        }
        //sc.close();
    }
}

class customer_id_sort implements Comparator<Customer> {

    public int compare(Customer a, Customer b) {
        if (a != null && b != null) {
            return (a.get_id() - b.get_id());
        }
        return 0;
    }
}

class Counter {

    int value = 0;

    Counter(int value) {
        this.value = value;
    }
}

class TV_Repair {

    private int service_id;

    private String address;

    private String contact_number;

    private String manufacturer;

    private String date;

    private String time;

    static Customer[] customers_TV_Repair = new Customer[100];

    static int tv_req = 0;

    TV_Repair(Customer customer) {
        Scanner sc = new Scanner(System.in);

        System.out.println();

        System.out.print("Enter address: ");

        address = sc.nextLine();

        System.out.println();

        System.out.print("Enter contact number: ");

        contact_number = sc.nextLine();

        System.out.println();

        while (contact_number_check() == false) {
            System.out.println("The entered contact number is invalid. Try again.");

            System.out.print("Enter contact number: ");

            contact_number = sc.nextLine();

            System.out.println();
        }

        System.out.print("Enter manufacturer: ");

        manufacturer = sc.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        dateFormat.setLenient(false);

        Date date_ = null;

        do {
            System.out.println("Please enter a date in the format dd-MM-yyyy: ");

            date = sc.nextLine();

            try {

                date_ = dateFormat.parse(date);

                System.out.println("Date is valid: " + date_);

                System.out.println();
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }

        } while (date_ == null);

        //System.out.println("Enter time: ");
        //time = sc.nextLine();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        timeFormat.setLenient(false);

        Date time_ = null;

        do {
            System.out.println("Enter time in format HH:mm (24-hour format):");

            time = sc.nextLine();

            try {

                time_ = timeFormat.parse(time);

                System.out.println("Time is valid: " + timeFormat.format(time_));

                System.out.println();
            } catch (ParseException e) {
                System.out.println("Invalid time format. Please try again.");
            }

        } while (time_ == null);

        Random random = new Random();

        service_id = 1000 + random.nextInt(9000);

        System.out.println("Request sent successfully. Service ID: " + service_id);

        customer.set_TV_Service(this);
        //customer.tv_no++;
        //sc.close();
    }

    private boolean contact_number_check() {
        Pattern p = Pattern.compile("(0|91)?[6-9][0-9]{9}");

        Matcher m = p.matcher(contact_number);

        return (m.find() && m.group().equals(contact_number));
    }

    int get_id() {
        return service_id;
    }
}

class Washing_Machine {

    private int service_id;

    private String address;

    private String contact_number;

    private String manufacturer;

    private String date;

    private String time;

    static Customer[] customers_Washing_Machine_Repair = new Customer[100];

    static int washing_req = 0;

    Washing_Machine(Customer customer) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter address: ");

        address = sc.nextLine();

        System.out.println();

        System.out.print("Enter contact number: ");

        contact_number = sc.nextLine();

        System.out.println();

        while (contact_number_check() == false) {
            System.out.println("The entered contact number is invalid. Try again.");

            contact_number = sc.nextLine();
        }

        System.out.println("Enter manufacturer: ");

        manufacturer = sc.nextLine();

        System.out.println();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        dateFormat.setLenient(false);

        Date date_ = null;

        do {
            System.out.println("Please enter a date in the format dd-MM-yyyy: ");

            date = sc.nextLine();

            try {

                date_ = dateFormat.parse(date);

                System.out.println("Date is valid: " + date_);

                System.out.println();
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }

        } while (date_ == null);

        //System.out.println("Enter time: ");
        //time = sc.nextLine();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        timeFormat.setLenient(false);

        Date time_ = null;

        do {
            System.out.println("Enter time in format HH:mm (24-hour format):");

            time = sc.nextLine();

            try {

                time_ = timeFormat.parse(time);

                System.out.println("Time is valid: " + timeFormat.format(time_));

                System.out.println();
            } catch (ParseException e) {
                System.out.println("Invalid time format. Please try again.");
            }

        } while (time_ == null);

        Random random = new Random();

        service_id = 1000 + random.nextInt(9000);

        System.out.println("Request sent successfully. Service ID: " + service_id);

        customer.set_Washing_Machine_Service(this);
        //sc.close();
    }

    int get_id() {
        return service_id;
    }

    private boolean contact_number_check() {

        Pattern p = Pattern.compile("(0|91)?[6-9][0-9]{9}");

        Matcher m = p.matcher(contact_number);

        return (m.find() && m.group().equals(contact_number));
    }
}

class Customer {

    private int customer_id;

    private String user_name;

    private String Name;

    private String email;

    private String address;

    private String contact_number;

    private String pwd;

    private boolean is_logged_in = false;

    private TV_Repair[] TV_Service = new TV_Repair[100];

    int tv_no = 0;

    private Washing_Machine[] Washing_Machine_Service = new Washing_Machine[1000];

    int wash_no = 0;

    Customer(Counter cus_no) {

        Random random = new Random();

        customer_id = 1000000 + random.nextInt(9000000);

        //customer_ids[cus_no.value] = customer_id;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the user_name: ");

        user_name = sc.nextLine();

        System.out.println();

        System.out.print("Enter your Name: ");

        Name = sc.nextLine();

        System.out.println();

        System.out.print("Enter your Email: ");

        email = sc.nextLine();

        System.out.println();

        while (email.contains("@") == false) {
            System.out.println("Incorrect email.");

            email = sc.nextLine();

            System.out.println();
        }

        System.out.print("Enter address: ");

        address = sc.nextLine();

        System.out.println();

        System.out.print("Enter contact number: ");

        contact_number = sc.nextLine();

        System.out.println();

        while (contact_number_check() == false) {
            System.out.println("Incorrect contact number. Try again.");

            System.out.print("Enter contact number: ");

            contact_number = sc.nextLine();

            System.out.println();
        }

        System.out.print("Enter password: ");

        pwd = sc.nextLine();

        System.out.println();

        while (check_pwd() == false) {
            System.out.println("Incorrect password. Try again");

            System.out.print("Enter password: ");

            pwd = sc.nextLine();

            System.out.println();
        }

        System.out.println("Confirm password: ");

        String pwd_2 = sc.nextLine();

        System.out.println();

        while (!pwd.equals(pwd_2)) {

            System.out.println("Passwords do not match. Try again.");

            System.out.print("Confirm password: ");

            pwd_2 = sc.nextLine();

            System.out.println();
        }

        System.out.println("Customer registered successfully.");

        System.out.println("Customer ID: " + customer_id);
        //sc.close();
    }

    void get_services() {
        System.out.println("TV Service Requests: ");

        System.out.println("No of requests." + tv_no);

        for (int i = 0; i < tv_no; i++) {

            System.out.println(tv_no);

            System.out.println(TV_Service[i].get_id());
        }
    }

    int get_id() {
        return customer_id;
    }

    String get_password() {
        return pwd;
    }

    String get_Name() {
        return Name;
    }

    String get_email() {
        return email;
    }

    void Login() {
        is_logged_in = true;

        System.out.println("User logged-in successfully.");
    }

    void Logout() {
        is_logged_in = false;

        System.out.println("User logged-out successfully.");
    }

    void set_TV_Service(TV_Repair request) {
        TV_Service[tv_no++] = request;

        System.out.println(tv_no);
    }

    void set_Washing_Machine_Service(Washing_Machine request) {
        Washing_Machine_Service[wash_no++] = request;
    }

    void generate_TV_Repair() {
        TV_Repair a = new TV_Repair(this);

        System.out.println("A");

        TV_Repair.customers_TV_Repair[TV_Repair.tv_req++] = this;

        System.out.println("B");
    }

    void generate_Washing_Machine_Repair() {
        Washing_Machine a = new Washing_Machine(this);

        Washing_Machine.customers_Washing_Machine_Repair[Washing_Machine.washing_req++] = this;
    }

    public Comparator<Customer> sortbyid = new Comparator<Customer>() {
        public int compare(Customer a, Customer b) {
            int id1 = a.get_id();

            int id2 = b.get_id();

            return id1 - id2;
        }
    };

    private boolean check_pwd() {
        boolean upper = false;

        boolean lower = false;

        boolean digit = false;

        boolean special = false;

        char ch;

        for (int i = 0; i < pwd.length(); i++) {

            ch = pwd.charAt(i);

            if (Character.isDigit(ch)) {
                digit = true;
            } else if (Character.isUpperCase(ch)) {
                upper = true;
            } else if (Character.isLowerCase(ch)) {
                lower = true;
            } else {
                special = true;
            }
        }

        if (digit == true && upper == true && lower == true && special == true) {
            System.out.println(special);

            return true;
        } else {
            return false;
        }
    }

    private boolean contact_number_check() {
        Pattern p = Pattern.compile("(0|91)?[6-9][0-9]{9}");

        Matcher m = p.matcher(contact_number);

        return (m.find() && m.group().equals(contact_number));
    }
}
