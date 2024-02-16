package mappers;

import entities.Patient;

import javax.servlet.http.HttpServletRequest;

import static utiles.PatientConstants.*;

public class PatientMapper {
    public Patient patientBuilder(HttpServletRequest request) {
        return Patient.builder()
                .passportId(request.getParameter(PASSPORT_ID))
                .patientFirstName(request.getParameter(PATIENT_FIRST_NAME))
                .patientSecondName(request.getParameter(PATIENT_SECOND_NAME))
                .patientAge(Integer.valueOf(request.getParameter(PATIENT_AGE)))
                .patientDiagnosis(request.getParameter(PATIENT_DIAGNOSIS))
                .build();
    }
}
