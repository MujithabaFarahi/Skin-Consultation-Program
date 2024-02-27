import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{

    static Scanner input = new Scanner(System.in);
    public static Doctor[] doctors=new Doctor[10];
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    static int count=doctors.length;
    static  Doctor[] copyDoctors;
    static ArrayList<Consultation> bookedConsultation = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("---------------------------------------------------------");
        System.out.println(" * * *    Westminster Skin Consultation Manager    * * * ");
        System.out.println("---------------------------------------------------------");
        System.out.println("Select an option to proceed");
        System.out.println("'V' : View all Doctors ");
        System.out.println("'A' : Add a Doctor ");
        System.out.println("'D' : Delete a Doctor ");
        System.out.println("'S' : Store details of a Doctor ");
        System.out.println("'C' : Book a Consultation ");
        System.out.println("'B' : View Booked Consultations");
        System.out.println("'W' : Exit Program");
        loadDoctor();
        String option = "";

        while(!option.equals("W")){
            try { //error handling
                System.out.println("\nEnter your option: ");
                option = input.next().toUpperCase(Locale.ROOT); //getting menu option and convert  it to upper case
                switch (option) {
                    case "V" :
                        viewDoctors();//calling view Doctor method
                        break;
                    case "A" :
                        WestminsterSkinConsultationManager WS = new WestminsterSkinConsultationManager();
                        WS.addDoctor();//calling add  Doctor method
                        break;

                    case "D" :
                        WestminsterSkinConsultationManager WSC = new WestminsterSkinConsultationManager();
                        WSC.deleteDoctor(); //calling delete Doctor method
                        break;

                    case "S" :
                        storeDoctor();//calling store Doctor method
                        break;

                    case "C" :
                        addPatient();
                        break;

                    case "B" :
                        bookedConsultationMethod();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);  //to show what type of error
                System.out.println("!!!Error!!!"); //print the error message
            }
    }

    }

    public static void viewDoctors() {
        copyDoctors = new Doctor[doctors.length]; //creating new array to sort
        int size = copyDoctors.length;

        if (count< doctors.length){
            for(int z=0; z<size; z++){
                copyDoctors[z]= doctors[z];  //copying each object to copy array
            }

            for (int i = 0; i < size-1; i++) {
                for (int j = i + 1; j < size; j++) {
                    //compares each element of the array to all the remaining elements
                    if (copyDoctors[i] != null && copyDoctors[j] != null) {
                        if ((copyDoctors[i].getSurname()).compareTo((copyDoctors[j].getSurname())) > 0) {
                            //swapping array objects
                            Doctor temp = copyDoctors[i];
                            copyDoctors[i] = copyDoctors[j];
                            copyDoctors[j] = temp;
                        }
                    }
                }
            }
        }
        else {
            System.out.println("No data of Doctors to view");
        }

        try {
            for (int i = 0; i < size; i++) {
                if((copyDoctors[i]) != null){
                    System.out.println("\nName : " + copyDoctors[i].getName());
                    System.out.println("SurName : " + copyDoctors[i].getSurname());
                    System.out.println("Date of Birth : " + copyDoctors[i].getDateOfBirth());
                    System.out.println("Mobile Number : " + copyDoctors[i].getMobileNumber());
                    System.out.println("Medical Licence Number : " + copyDoctors[i].getMedicalLicenseNo());
                    System.out.println("Specialization : " + copyDoctors[i].getSpecialization());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }

    public static void addDoctors() {
            try {
                if(count>0) {
                    System.out.println("Enter the name of the doctor : ");
                    String name = input.next().toUpperCase(Locale.ROOT);

                    System.out.println("Enter the surname of the doctor : ");
                    String surName = input.next().toUpperCase(Locale.ROOT);

                    System.out.println("Enter the doctor's Date of Birth (dd/MM/yyyy): ");
                    String date = input.next();
                    Date dOB = dateFormat.parse(date);

                    System.out.println("Enter the Mobile Number of the doctor  : ");
                    String mobileNumber = input.next();

                    System.out.println("Enter the Medical Licence Number of the Doctor: ");
                    String medicalLicenceNo = input.next();

                    System.out.println("Enter the Specialization : ");
                    String specialization = input.next();

                    Doctor doctor1 = new Doctor(name, surName, date, mobileNumber, medicalLicenceNo, specialization);

                    for (int i = 0; i < doctors.length; i++) {
                        if (doctors[i] == null) {
                            doctors[i] = doctor1;
                            System.out.println("Doctor " + doctors[i].getName() + " added Successfully.");
                            count--;
                            break;

                        }
                    }
                }
                else {
                    System.out.println("All spaces for doctors are occupied");
                }

            } catch (ParseException e) {
                System.out.println("Format of your entered value is invalid!");
            } catch (Exception e) {
                System.out.println(e);  //to show what type of error
                System.out.println("!!!Error!!!"); //print the error message
            }
    }

    @Override
    public void addDoctor() {
        addDoctors();
    }

    public static void deleteDoctors() {
        if (count == doctors.length) {
            System.out.println("No Doctors are added to the system to Delete");
        }
        if (count < doctors.length) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the Medical Licence Number : ");
            String licenceNo = input.next();
            boolean found = true;

            for (int i = 0; i < doctors.length; i++) {
                if (doctors[i] != null && doctors[i].getMedicalLicenseNo().equals(licenceNo)) {
                    System.out.println("\nDoctor " + doctors[i].getName() + " Deleted Successfully");
                    doctors[i] = null;
                    count++;
                    System.out.println("\n" + (doctors.length - count) + " more doctors are there in the system.");
                    found = false;
                    break;
                }
            }
            if (found) {
                System.out.println("Wrong Medical License Number");
            }
        }
    }

    @Override
    public void deleteDoctor() {
        deleteDoctors();
    }


    public static void storeDoctor() {
        try {
            FileWriter myWriter = new FileWriter("DoctorDetails.txt");
            for (int i = 0; i < doctors.length; i++ ){
                if (doctors[i]!=null) {
                    myWriter.write("Name : " + doctors[i].getName()+"\n"+
                            "SurName : " + doctors[i].getSurname()+"\n"+
                            "Date of Birth : " + doctors[i].getDateOfBirth()+"\n"+
                            "Mobile Number : " + doctors[i].getMobileNumber()+"\n"+
                            "Medical Licence Number : " + doctors[i].getMedicalLicenseNo()+"\n"+
                            "Specialization : " + doctors[i].getSpecialization()+"\n");

                    myWriter.write("\n");
                }
            }
            myWriter.close(); //closing the file

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void bookedConsultationMethod() {

        for (Consultation x: bookedConsultation) {
            System.out.println("Patient's Name : " + x.getPatient().getName() +" "+x.getPatient().getSurname()+"\n" +
                    "Patient's Date of Birth : "+ x.getPatient().getDateOfBirth()+"\n" +
                    "Patient's Mobile Number : "+ x.getPatient().getMobileNumber()+"\n" +
                    "Consultation Cost : " + "£" + x.getCost()+"\n" +
                    "Consultation Date : " + x.getConsultationDate()+"\n"+
                    "Consultation Time : " + x.getStartTime() + "-" + x.getEndTime() +"\n"+
                    "Consultation Doctor : " + x.getDoctor().getName() + x.getDoctor().getSurname()+ "\n" +
                    "----------------------------------------------------------");

        }
    }

    public static void addPatient(){
        PageOne one = new PageOne();
    }

    public static void loadDoctor() {
        String datas[]=new  String[6];

        try {
            File MyObject = new File("DoctorDetails.txt");
            Scanner myReader = new Scanner(MyObject);
            int round=0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine(); //reading from file
                String[] splitt = data.split(": ");
                if(round==6){
                    Doctor doc=new Doctor(datas[0],datas[1],datas[2],datas[3],datas[4],datas[5]);
                    for (int i = 0; i < doctors.length; i++) {
                        if (doctors[i] == null) {
                            doctors[i] = doc;
                            count--;
                            break;
                        }
                    }
                    round=0;

                }

                else {
                    datas[round]=splitt[1];
                    round++;
                }
            }
            if (count < doctors.length) {
                System.out.println("\nSuccessfully Loaded " + (doctors.length - count) + " Doctors from previous records.");
            }

            myReader.close(); //closing the file
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
