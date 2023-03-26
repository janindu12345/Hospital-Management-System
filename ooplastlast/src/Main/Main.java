package Main;


import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;




public class Main {


    private static final Scanner myScanner = new Scanner(System.in);  //creating a global scanner
    static SkinConsultationManager consultationManager = new WestminsterSkinConsultationManager();



    public static void main(String[] args ){

        displayMenu();
 }


    private static void displayMenu() {

        menu:
        //infinite loop
        while (true) {
            System.out.println("");
            System.out.println( "Press 1 to Register a Doctor");
            System.out.println("Press 2 to Delete a Doctor");
            System.out.println("Press 3 to Print Doctors List");
            System.out.println("Press 4 to Display GUI");
            System.out.println("Press 5 to Save Details in a Text File");
            System.out.println("Press 0 to Quit from the Application" );
            System.out.println("Enter your choice : ");
            int choice;
            boolean flag = Boolean.TRUE;

            while (flag) {
                //checking input is an integer or not using try catch
                try {
                    choice = myScanner.nextInt();

                    switch (choice) {
                        case 1:
                            addDoctor();
                            break;
                        case 2:
                            deleteDoctor();
                            break;
                        case 3:
                           consultationManager.printDoctorsList();
                            break;
                        case 4:
                            consultationManager.displayGUI();
                            break;
                        case 5:
                            consultationManager.saveDataToFile();
                            backToMenu();

                        case 0:
                            System.out.println("Thank You for using the System. Have a Pleasant Day!");
                            System.exit(0);
                            break menu;
                        default:
                            System.out.println("You Selected an Invalid Option. Please Try Again!");
                            displayMenu();
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Please enter valid option!!!...");
                    String input = myScanner.next();
                    if (input.equalsIgnoreCase("y")) {
                        backToMenu();
                    } else {
                        break;
                    }
                }
                flag = false;
            }
        }
    }




    private static void backToMenu() {
        System.out.println("Press \"Y\" to continue menu and press \"Q\" to exit:..");
        String input = myScanner.next();
        if (input.equalsIgnoreCase("y")) {
            displayMenu();
        } else if(input.equalsIgnoreCase("Q")) {
            System.exit(0);
        }
        else {

        }
    }




    private static void addDoctor() {
        Doctor doctor = new Doctor();
        SimpleDateFormat dateInput = new SimpleDateFormat("yyyy-MM-dd");

        //getting user inputs

        System.out.println("Enter the Doctor licence number : ");
        String licence = myScanner.next();
        if (consultationManager.checkDoctorRegistered(licence)) {
            System.out.println("This licence number already registered!!!...");
            return;
        } else {
            doctor.setMedicalLicenceNumber(licence);
        }
        System.out.println("Enter Doctor name : ");
        String name = myScanner.next();
        name += myScanner.nextLine();

        // accept inputs with spaces
        //setting values using setters4


        doctor.setName(name);
        System.out.println("Enter Doctor surname : ");
        String surname = myScanner.next();
        doctor.setSurname(surname);
        System.out.println("Enter the specialization of the Doctor : ");
        String specialization = myScanner.next();
        specialization += myScanner.nextLine();


        //setting values using setters

        doctor.setSpecialisation(specialization);
        System.out.println("Enter date of birth (yyyy-MM-dd) : ");
        String dob = myScanner.next();
        try {
            Date date = dateInput.parse(dob);
            doctor.setDateOfBirth(date);
        } catch (ParseException e) {
            System.out.println("Invalid input!!!...");
            return;
        }
        System.out.println("Enter Doctor mobile number : ");
        int mobileNumber = myScanner.nextInt();
        doctor.setMobileNumber(mobileNumber);

        consultationManager.addDoctor(doctor);
    }




    private static void deleteDoctor() {

        System.out.println("Enter the Doctor name (name surname) : ");
        String fullName = myScanner.next();
        fullName += myScanner.nextLine(); // accept inputs with spaces
        System.out.println("Enter Doctor licence number : ");
        String licenceNo = myScanner.next();
        consultationManager.deleteDoctor(fullName, licenceNo);
    }



}
