package controllers.patients;

import entities.Patient;
import mappers.PatientMapper;
import services.patinets.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Long.parseLong;
import static services.patinets.PatientServiceImpl.getInstance;
import static utiles.PagesConstants.UPDATE_PATIENTS_PAGE;
import static utiles.PatientConstants.*;

@WebServlet(urlPatterns = "/patients/update")
public class UpdatePatientsController extends HttpServlet {
    private final PatientService patientService = getInstance();
    private final PatientMapper patientMapper = new PatientMapper();
    private long id;
    private Patient patient;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = parseLong(req.getParameter(PATIENT_ID));
        patient = patientService.getPatient(id);
        req.setAttribute(PASSPORT_ID, patient.getPassportId());
        req.setAttribute(PATIENT_FIRST_NAME, patient.getPatientFirstName());
        req.setAttribute(PATIENT_SECOND_NAME, patient.getPatientSecondName());
        req.setAttribute(PATIENT_AGE, patient.getPatientAge());
        req.setAttribute(PATIENT_DIAGNOSIS, patient.getPatientDiagnosis());
        req.getRequestDispatcher(UPDATE_PATIENTS_PAGE).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        patient = patientMapper.patientBuilder(req);
        patientService.updatePatient(id, patient);
        req.getRequestDispatcher("/patients/read").forward(req, resp);
    }
}
