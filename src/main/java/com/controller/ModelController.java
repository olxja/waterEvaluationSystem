package com.controller;

import com.bean.Permission;
import com.bean.Model;
import com.bean.Response;
import com.service.ModelService;
import com.utils.Constants;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * Created by 郑超一 on 2017/2/28.
 */
@Controller
public class ModelController {
    @Resource
    private ModelService ModelService;
    //列出所有模型
    @RequestMapping(value = "/ModelList")
    @ResponseBody
    public Response ModelList(@RequestParam String user_id) {          //
        Response response = new Response();
        ModelService.ModelList(response,user_id);
        return response;
    }
    //列出系统模型
    @RequestMapping(value = "/sysModelList")
    @ResponseBody
    public Response sysModelList() {          //
        Response response = new Response();
        ModelService.sysModelList(response);
        return response;
    }
    //列出我的模型
    @RequestMapping(value = "/myModelList")
    @ResponseBody
    public Response myModelList(@RequestParam String user_id) {          //
        Response response = new Response();
        ModelService.myModelList(response,user_id);
        return response;
    }
    //添加模型
    @RequestMapping(value = "/addModel")
    @ResponseBody
    public Response addModel(Model model) {
        Response response = new Response();
        ModelService.addModel(response,model);
        return response;
    }
    //得到大json表内容
    @RequestMapping(value = "/getModelJson")
    @ResponseBody
    public Response getModelJson(Model model) {          //
        Response response = new Response();
        ModelService.getModelJson(response,model);
        return response;
    }
    //得到临时json表内容
    @RequestMapping(value = "/getTemp")
    @ResponseBody
    public Response getTemp(Model model) {          //
        Response response = new Response();
        ModelService.getTemp(response,model);
        return response;
    }
    //操作临时json表
    @RequestMapping(value = "/updateTemp")
    @ResponseBody
    public Response updateTemp(Model model) {
        Response response = new Response();
        ModelService.updateTemp(response,model);
        return response;
    }
    //操作大json表
    @RequestMapping(value = "/updateJson")
    @ResponseBody
    public Response updateJson(Model model) {
        Response response = new Response();
        ModelService.updateJson(response,model);
        return response;
    }

//    //更新模型指标相对权重
//    @RequestMapping(value = "/updateIndex")
//    @ResponseBody
//    public Response updateIndex(Model model) {
//        Response response = new Response();
//        ModelService.updateIndex(response,model);
//        return response;
//    }
    //删除模型
    @RequestMapping(value = "/deleteModel")
    @ResponseBody
    public Response deleteModel(Model model) {
        Response response = new Response();
        ModelService.deleteModel(response,model);
        return response;
    }

}
