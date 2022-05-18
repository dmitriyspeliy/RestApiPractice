package data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RegistrSuccesful {
    private String email;
    private String password;

    public RegistrSuccesful(){
        super();
    }

    public RegistrSuccesful(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
