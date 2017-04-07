import com.bean.User;
import net.sf.json.JSONObject;

/**
 * Created by lenovo on 2017/1/3.
 */
public class TestDemo1 {
    public static void main(String[] args) {
        /*String a = "[&]{2}|[/]|[&]";
        String b = "北京/天津&&河北&河南";
        String[] split = b.split(a);
        for (String s :split){
            System.out.println(s);
        }*/

        JSONObject jsonObject = new JSONObject();
        User user = new User();
        user.setEmail("123");
        user.setDepartmentName("aaaa");
        jsonObject.put("user",user);
        System.out.println(jsonObject.toString());
    }
}
