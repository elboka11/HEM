package controllers.patients;

import entities.Patient;
import services.patinets.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static services.patinets.PatientServiceImpl.getInstance;
import static utiles.PagesConstants.READ_PATIENTS_PAGE;

@WebServlet(urlPatterns = "/patients/read")
public class ReadPatientsController extends HttpServlet {
    private static final PatientService patientService = getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> patients = patientService.readPatients();
        req.setAttribute("patients", patients);
        req.getRequestDispatcher(READ_PATIENTS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
