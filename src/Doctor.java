import java.util.Date;

public class Doctor extends Person{
    private String medicalLicenseNo;
    private String specialization;

    public Doctor() {}

    public Doctor(String name, String surname, String dateOfBirth, String mobileNumber, String medicalLicenseNo, String specialization) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenseNo = medicalLicenseNo;
        this.specialization = specialization;
    }

    public String getMedicalLicenseNo() {
        return medicalLicenseNo;
    }

    public void setMedicalLicenseNo(String medicalLicenseNo) {
        this.medicalLicenseNo = medicalLicenseNo;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
