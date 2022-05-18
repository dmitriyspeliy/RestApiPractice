package data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.testng.Assert;
import java.util.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ListResource {
    private int year;

    public static void filtredList(List<ListResource> list){
        TreeSet<Integer> filtrList = new TreeSet<>();
        List<Integer> tmpList = new ArrayList<>();
        for(ListResource obj:list){
            filtrList.add(obj.getYear());
            tmpList.add(obj.getYear());
        }
        List<Integer> exampleList = new ArrayList<>(filtrList);
        Assert.assertEquals(tmpList,exampleList,"Массив не отфильтрован по возрастанию");
    }


}
