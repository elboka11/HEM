package services.patinets;

import entities.Patient;

import java.util.List;

public interface PatientService {
    void createPatient(Patient patient);

    List<Patient> readPatients();

    void updatePatient(long id, Patient patient);

    void deletePatient(long patientId);

    Patient getPatient(long id);
}
