package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private Long patientId;
    private String passportId;
    private String patientFirstName;
    private String patientSecondName;
    private Integer patientAge;
    private String patientDiagnosis;
}
