package repositories.patients;

import entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {
    Optional<Patient> createPatients(Patient patient);

    Optional<List<Patient>> readPatients();

    Optional<Patient> updatePatient(long patientId, Patient patient);

    Optional<Patient> deletePatient(long patientId);
    int getPatientId(long patientId);

    Optional<Patient> getPatient(long id);

}
