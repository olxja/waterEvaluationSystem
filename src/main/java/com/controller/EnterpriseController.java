package com.controller;

import com.bean.Response;
import com.service.*;
import com.utils.Constants;
import com.utils.StringUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by olxja_000 on 2017/3/8.
 */
@Controller
public class EnterpriseController {
    @Resource
    private EnterBaseService enterBaseService;
    @Resource
    private EnterNumService enterNumService;
    @Resource
    private EnterICService enterICService;
    @Resource
    private EnterScoreService enterScoreService;
    @Resource
    private EnterUnpromiseService enterUnpromiseService;
    @Resource
    private EnterCourtListService enterCourtListService;
    @Resource
    private EnterDocListService enterDocListService;
    @Resource
    private EnterBrandService enterBrandService;
    @Resource
    private EnterPatentService enterPatentService;
    @Resource
    private  EnterCertificateService enterCertificateService;
    @Resource
    private EnterCopyrightService enterCopyrightService;
    @Resource
    private  EnterSoftService enterSoftService;
    @Resource
    private EnterAnnualService enterAnnualService;
    @Resource
    private  EnterRelationService enterRelationService;
    @Resource
    private  EnterAptitudeService enterAptitudeService;
    @Resource
    private EnterNewsService enterNewsService;
//    ==============================================================公司得分=================================================================
    /*
    @param company_id
    @param start
    @param rows
    @return companyScore
    @throw IOException
    @throw SolrServerException
     */
    @RequestMapping(value = "/getEnterScore")
    @ResponseBody
    public Response getEnterScore(String company_id,Integer start, Integer rows){
        JSONObject jsonObject= new JSONObject();
        Response response=new Response();
        if(null == company_id){
            response.failure("公司id为空");
            return response;
        }
        if (start == null) {
            start = 0;
        }
        if (rows == null) {
            rows = 10;
        }
        try{
//            查询公司得分
            response.success(enterScoreService.query(company_id,start,rows));
        }catch (Exception e){
            response.failure(e.getMessage());
        }
        return response;
    }
//    ==============================================================企业详情=================================================================
    /*
    @param company_id
    @return companyBaseInfo
    @throw IOException
    @throws SolrServerException
     */
    @RequestMapping("/getEnterInfo")
    @ResponseBody
    public Response getEnterInfo(String user_id, String company_id) {
        JSONObject jsonObject = new JSONObject();
        Response response=new Response();
        if (null == user_id) {
            response.failure("请登录!");
            return response;
        }
        if (null == company_id) {
            response.failure("公司id为空!");
            return response;
        }
        try {
            //查询企业基本信息
            jsonObject.put("baseJson", enterBaseService.query(company_id));
            response.success(jsonObject);
        } catch (Exception e) {
            response.failure("查询失败: "+e.getMessage());
        }
        return response;
    }
//    ============================================工商数据======================================================
    /*

     */
    @RequestMapping(value = "/getEnterICInfo")
    @ResponseBody
    public Response getEnterICInfo(String company_id) {
        Response response = new Response();
        try {
            JSONObject jsonObject = enterICService.query(company_id);
            response.success(jsonObject);
        } catch (Exception e) {
            response.failure("查询失败：" + e.getMessage());
        }
        return response;
    }

    //==========================================法律信息：企业失信=========================================

    /**
     * @param company_id
     * @return
     */
    @RequestMapping(value = "/getEnterUnpromiseInfo")
    @ResponseBody
    public Response getEnterUnpromiseInfo(String company_id, Integer pageNum, Integer pageSize) {
            Response response = query(enterUnpromiseService, company_id, pageNum, pageSize);
            return response;
    }
    //==========================================法律信息：法院公告列表=========================================

    /**
     * @param company_id
     * @return
     */
    @RequestMapping(value = "/getEnterCourtList")
    @ResponseBody
    public Response getEnterCourtList(String company_id, Integer pageNum, Integer pageSize) {
        Response response = query(enterCourtListService, company_id, pageNum, pageSize);
        return response;
    }
    //==========================================法律信息：企业裁判文书列表=========================================

    /**
     * @param company_id
     * @return
     */
    @RequestMapping(value = "/getEnterDocList")
    @ResponseBody
    public Response getEnterDocList(String company_id, Integer pageNum, Integer pageSize) {
        Response response = query(enterDocListService, company_id, pageNum, pageSize);
        return response;
    }

    //==========================================商标=========================================

    /**
     * @param company_id
     * @return
     */
    @RequestMapping(value = "/getEnterBrand")
    @ResponseBody
    public Response getEnterBrand(String company_id, Integer pageNum, Integer pageSize) {
        Response response = query(enterBrandService, company_id, pageNum, pageSize);
        return response;
    }
    //==========================================专利=========================================

    /**
     * @param company_id
     * @return
     */
    @RequestMapping(value = "/getEnterPatent")
    @ResponseBody
    public Response getEnterPatent(String company_id, Integer pageNum, Integer pageSize) {
        Response response = query(enterPatentService, company_id, pageNum, pageSize);
        return response;
    }
    //==========================================证书=========================================

    /**
     * @param company_id
     * @return
     */
    @RequestMapping(value = "/getEnterCertificate")
    @ResponseBody
    public Response getEnterCertificate(String company_id, Integer pageNum, Integer pageSize) {
        Response response = query(enterCertificateService, company_id, pageNum, pageSize);
        return response;
    }
    //==========================================作品著作权=========================================

    /**
     * @param company_id
     * @return
     */
    @RequestMapping(value = "/getEnterCopyright")
    @ResponseBody
    public Response getEnterCopyright(String company_id, Integer pageNum, Integer pageSize) {
        Response response = query(enterCopyrightService, company_id, pageNum, pageSize);
        return response;
    }
    //==========================================软件著作权=========================================

    /**
     * @param company_id
     * @return
     */
    @RequestMapping(value = "/getEnterSoft")
    @ResponseBody
    public Response getEnterSoft(String company_id, Integer pageNum, Integer pageSize) {
        Response response = query(enterSoftService, company_id, pageNum, pageSize);
        return response;
    }
    //==========================================企业年报=========================================

    /**
     * @param company_id
     * @return
     */
    @RequestMapping(value = "/getEnterAnnualInfo")
    @ResponseBody
    public Response getEnterAnnualInfo(String company_id, Integer pageNum, Integer pageSize) {
        Response response = query(enterAnnualService, company_id, pageNum, pageSize);
        return response;
    }
    //==========================================关联关系=========================================
    /*
    *@param company_id
    * @return
     */
    @RequestMapping(value = "/getEnterRelationInfo")
    @ResponseBody
    public Response getEnterRelationInfo(String company_id, Integer pageNum, Integer pageSize) {
        Response response = query(enterRelationService, company_id, pageNum, pageSize);
        return response;
    }
    //==========================================企业资质=========================================
    /*
    *@param company_id
    * @return
     */
    @RequestMapping(value = "getEnterAptitude")
    @ResponseBody
    public Response getEnterAptitude(String company_id,Integer pageNum,Integer pageSize){
        Response response = query(enterAptitudeService, company_id,pageNum,pageSize);
        return response;
    }
    //==========================================企业新闻=========================================
    /*
    *param
    * @return
     */
    @RequestMapping(value = "getEnterNews")
    @ResponseBody
    public Response getEnterNews(String news_query,Integer pageNum,Integer pageSize){
        Response response = query(enterNewsService,news_query,pageNum,pageSize);
        return response;
    }
    //==========================================查询企业详情公用方法=========================================
    private Response query(EnterInfoService enterInfoService, String company_id, Integer pageNum, Integer pageSize) {
        JSONObject jsonObject = new JSONObject();
        Response response=new Response();
        if (StringUtil.isNullAll(company_id)) {

            response.failure("查询参数有误.");
            return response;
        }
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        try {
            Integer start = (pageNum - 1) * pageSize;
            Integer rows = pageSize;
            jsonObject = enterInfoService.query(company_id, start, rows);
        } catch (Exception e) {
            response.failure("查询失败:"+e.getMessage());
            return response;
        }
        //成功返回状态 1
        response.success(jsonObject);
        return response;
    }

}

