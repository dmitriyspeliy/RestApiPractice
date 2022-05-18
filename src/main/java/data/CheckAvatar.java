package data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.testng.Assert;
import java.util.List;
import java.util.TreeSet;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CheckAvatar {
    private String page;
    private int id;
    private String first_name;
    private String last_name;
    private String avatar;

    public static void checkUnic(List<CheckAvatar> ob){
        TreeSet<String> unic = new TreeSet<>();
        for(CheckAvatar obj:ob){
            unic.add(obj.getAvatar());
        }
        Assert.assertEquals(ob.size(),unic.size(),"Имена файлов аватаров пользователей неуникальны");
    }
}
