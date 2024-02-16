package controllers.patients;

import services.patinets.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static services.patinets.PatientServiceImpl.getInstance;
import static utiles.PatientConstants.PATIENT_ID;

@WebServlet(urlPatterns = "/patients/delete")
public class DeletePatientsController extends HttpServlet {

    private final PatientService patientService = getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        patientService.deletePatient(Long.parseLong(req.getParameter(PATIENT_ID)));
        req.getRequestDispatcher("/patients/read").forward(req, resp);
    }


}
