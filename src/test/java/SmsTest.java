import com.taobao.api.ApiException;
import com.utils.SmsUtil;
import com.utils.StringUtil;
import net.sf.json.JSONObject;
import org.junit.Test;

/**
 * Created by lenovo on 2016/11/23.
 */
public class SmsTest {
    @Test
    public void test() throws ApiException {
        String smsTemplateCode = "SMS_27930139";
        String code = StringUtil.getSixRandom();
        String phoneNum = "15039265796";
        JSONObject param = new JSONObject();
        param.put("code", code);
        param.put("name", phoneNum);
        String paramString = param.toString();
        SmsUtil.sendSms(phoneNum, smsTemplateCode, paramString);
    }
}
