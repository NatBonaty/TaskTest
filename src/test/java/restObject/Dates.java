package restObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dates {


    @JsonProperty("checkin")
    private LocalDate checkin;
    @JsonProperty("checkout")
    private LocalDate checkout;
}
