package services.patinets;

import entities.Patient;
import repositories.patients.PatientRepository;
import repositories.patients.PatientRepositoryImpl;

import java.util.List;

public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository = PatientRepositoryImpl.getInstance();
    private static PatientService patientService;

    private PatientServiceImpl() {
    }

    public static PatientService getInstance() {
        if (patientService == null) {
            patientService = new PatientServiceImpl();
        }
        return patientService;
    }

    @Override
    public void createPatient(Patient patient) {
        patientRepository.createPatients(patient).orElseThrow();
    }

    @Override
    public List<Patient> readPatients() {
        return patientRepository.readPatients().orElseThrow();
    }

    @Override
    public void updatePatient(long id, Patient patient) {
        patientRepository.updatePatient(id, patient).orElseThrow();
    }

    @Override
    public void deletePatient(long patientId) {
        patientRepository.deletePatient(patientId).orElseThrow();
    }

    @Override
    public Patient getPatient(long patientId) {
        return patientRepository.getPatient(patientId).orElseThrow();
    }
}
