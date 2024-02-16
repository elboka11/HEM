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

import static services.patinets.PatientServiceImpl.getInstance;
import static utiles.PagesConstants.CREATE_PATIENTS_PAGE;

@WebServlet(urlPatterns = "/patients/create")
public class CreatePatientsController extends HttpServlet {

    private final PatientService patientService = getInstance();
    private final PatientMapper patientMapper = new PatientMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(CREATE_PATIENTS_PAGE).forward(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Patient patient = patientMapper.patientBuilder(req);
        patientService.createPatient(patient);
        req.getRequestDispatcher("/patients/read").forward(req, resp);
    }
}
