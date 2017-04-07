import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.python.core.*;
import org.python.util.PythonInterpreter;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by olxja_000 on 2017/2/28.
 */
public class testPython {
    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        try {
            InputStream filepy = new FileInputStream("E:\\JAVA\\waterEvaluationSystem\\src\\main\\java\\com\\python\\testconnection.py");
            interpreter.execfile(filepy);  ///执行python py文件
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("company_name","新华书店");
            jsonObject.put("company_id","11112222");

            PyFunction func1=(PyFunction)interpreter.get("firstprintf",PyFunction.class);// python解释器，装载.py文件中的firstprintf函数
            String str=jsonObject.toString();
            System.out.println("======"+jsonObject.toString()+"======");
            PyString str4 = Py.newStringUTF8(str);//转化为Jython中的pystring方便传参
            PyObject pyObject=func1.__call__(str4);//向函数传参,pyObject接收
            String ret = "";
            ret=pyObject.toString();
            String newStr = new String(ret.getBytes("iso8859-1"), "utf-8");//返回值重新定义编码方式
            System.out.println("+++++"+newStr+"+++++++");
            interpreter.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}
