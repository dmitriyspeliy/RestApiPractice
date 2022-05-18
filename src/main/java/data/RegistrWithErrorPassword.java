package data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RegistrWithErrorPassword {
    private String email;

    public RegistrWithErrorPassword(){
        super();
    }

    public RegistrWithErrorPassword(String email) {
        this.email = email;
    }
}
