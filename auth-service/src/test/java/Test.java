import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/5/23
 */
public class Test {
    public static void main(String[] args) {
        String a = "1.QQ截图20160510134033.png";
        String ends = a.substring(a.lastIndexOf("."), a.length());
        System.out.println(ends);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        System.out.println(list.toString().replaceAll("\\[", "(").replaceAll("\\]", ")"));
    }
}
