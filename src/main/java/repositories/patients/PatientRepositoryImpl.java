package repositories.patients;

import entities.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class PatientRepositoryImpl implements PatientRepository {

    private final List<Patient> patients = new ArrayList<>();
    private static PatientRepository patientRepository;

    private PatientRepositoryImpl() {
        patients.add(new Patient(1L, "14AC5514", "Sasha", "Mokhamedov", 35, "ophthalmology"));
        patients.add(new Patient(2L, "AU13BC45", "Maga", "davidov", 40, "neurology"));
        patients.add(new Patient(3L, "AB34R76C", "mariea", "smirnova", 26, "ophthalmology"));
        patients.add(new Patient(4L, "65SV12RT", "Natalia", "tretyakova", 30, "physiology"));
        patients.add(new Patient(5L, "11AD66CV", "Mark", "sterganov", 28, "oncology"));
    }

    public static PatientRepository getInstance() {
        if (patientRepository == null) {
            patientRepository = new PatientRepositoryImpl();
        }
        return patientRepository;
    }

    @Override
    public Optional<Patient> createPatients(Patient patient) {
        patient.setPatientId((long) (patients.size() + 1));
        patients.add(patient);
        return Optional.of(patient);
    }

    @Override
    public Optional<List<Patient>> readPatients() {
        return Optional.of(patients);
    }

    @Override
    public Optional<Patient> updatePatient(long patientId, Patient patient) {
        int patientIndex = patientRepository.getPatientId(patientId);
        patient.setPatientId(patientId);
        patients.set(patientIndex, patient);
        return Optional.of(patient);
    }

    @Override
    public Optional<Patient> deletePatient(long patientId) {
        Patient patient = patients.stream().filter(T -> Objects.equals(T.getPatientId(), patientId)).findAny().orElseThrow();
        patients.remove(patient);
        return Optional.of(patient);
    }

    @Override
    public int getPatientId(long patientId) {
        return IntStream.range(0, patients.size())
                .filter(i -> patients.get(i).getPatientId() == patientId)
                .findFirst().orElseThrow();
    }

    @Override
    public Optional<Patient> getPatient(long patientId) {
        Patient patient = patients.stream()
                .filter(findPatient -> findPatient.getPatientId() == patientId)
                .findFirst().orElseThrow();
        return Optional.of(patient);
    }
}
