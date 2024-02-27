import java.time.LocalTime;
import java.util.Date;

public class Consultation {
    private Date consultationDate ;
    private LocalTime startTime;
    private LocalTime endTime;
    private double cost;
    private String notes;
    private Doctor doctor;
    private Patient patient;

    public Consultation(){}

    public Consultation(Date consultationDate, LocalTime startTime, LocalTime endTime, double cost, String notes, Doctor doctor, Patient patient) {
        this.consultationDate = consultationDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
        this.notes = notes;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
