package com.utils;

import com.bean.MyDatabase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2016/9/29.
 */
public class SolrUtils {
    public static JSONArray getEnterResult(HttpSolrClient solrClient, String company_id) throws IOException, SolrServerException {
        SolrQuery solrQuery = new SolrQuery();
        Map<String,String> map = new HashMap<String,String>();
        map.put("wt","json");
        SolrParams params = new MapSolrParams(map);
        solrQuery.add(params);
        //关键词
        solrQuery.setQuery("*:*");
        //过滤
        solrQuery.setFilterQueries("company_id:"+company_id);
        QueryResponse query = solrClient.query(solrQuery);
        SolrDocumentList results = query.getResults();
        //返回列表
        JSONArray jsonArray = JSONArray.fromObject(results);
        return jsonArray;
    }
    public static JSONArray getEnterResult(HttpSolrClient solrClient, String company_id, Integer start, Integer rows) throws IOException, SolrServerException {
        SolrQuery solrQuery = new SolrQuery();
        Map<String,String> map = new HashMap<String,String>();
        map.put("wt","json");
        SolrParams params = new MapSolrParams(map);
        solrQuery.add(params);
        //关键词
        solrQuery.setQuery("*:*");
        //过滤
        solrQuery.setFilterQueries("company_id:"+company_id);
        //分页
        solrQuery.setStart(start);
        solrQuery.setRows(rows);
        //查询
        QueryResponse query = solrClient.query(solrQuery);
        SolrDocumentList results = query.getResults();
        //返回列表
        JSONArray jsonArray = JSONArray.fromObject(results);
        return jsonArray;
    }

    public static JSONArray getStartupResult(HttpSolrClient solrClient, String startup_id) throws IOException, SolrServerException {
        SolrQuery solrQuery = new SolrQuery();
        Map<String,String> map = new HashMap<String,String>();
        map.put("wt","json");
        SolrParams params = new MapSolrParams(map);
        solrQuery.add(params);
        //关键词
        solrQuery.setQuery("*:*");
        //过滤
        solrQuery.setFilterQueries("startup_id:"+startup_id);
        QueryResponse query = solrClient.query(solrQuery);
        SolrDocumentList results = query.getResults();
        //返回列表
        JSONArray jsonArray = JSONArray.fromObject(results);
        return jsonArray;
    }
   public static void getJSONform(JSONObject jsonObject,MyDatabase data) throws IOException {
//       成长力
       JSONObject jsonObjectGF=new JSONObject();
       JSONObject jsonObjectSI1=new JSONObject();
       jsonObjectSI1.put("main_business_income_2015",data.getMain_business_income_2015());
       jsonObjectSI1.put("main_business_income_2014",data.getMain_business_income_2014());
       jsonObjectSI1.put("main_business_income_2013",data.getMain_business_income_2013());
       jsonObjectSI1.put("main_business_cgr_3years",data.getMain_business_cgr_3years());
       jsonObjectSI1.put("net_profit_2015",data.getNet_profit_2015());
       jsonObjectSI1.put("net_profit_2014",data.getNet_profit_2014());
       jsonObjectSI1.put("net_profit_2013",data.getNet_profit_2013());
       jsonObjectSI1.put("net_profit_cgr_3years",data.getNet_profit_cgr_3years());
       jsonObjectSI1.put("total_assets_2015",data.getTotal_assets_2015());
       jsonObjectSI1.put("total_assets_2014",data.getTotal_assets_2014());
       jsonObjectSI1.put("total_assets_2013",data.getTotal_assets_2013());
       jsonObjectSI1.put("total_assets_cgr_3years",data.getTotal_assets_cgr_3years());
       jsonObjectSI1.put("capital_2015",data.getCapital_2015());
       jsonObjectSI1.put("capital_2014",data.getCapital_2014());
       jsonObjectSI1.put("capital_2013",data.getCapital_2013());
       jsonObjectSI1.put("capital_cgr_3years",data.getCapital_cgr_3years());
       jsonObjectSI1.put("main_business_profit",data.getMain_business_profit());
       jsonObjectSI1.put("main_business_income",data.getMain_business_income());
       jsonObjectSI1.put("main_business_profit_rate",data.getMain_business_profit_rate());
       jsonObjectSI1.put("total_assets_yield_rate",data.getTotal_assets_yield_rate());
       jsonObjectSI1.put("net_asset_yield_rate",data.getNet_asset_yield_rate());
       jsonObjectSI1.put("capital_stock",data.getCapital_stock());
       jsonObjectSI1.put("total_assets",data.getTotal_assets());
       jsonObjectSI1.put("workers_sum",data.getWorkers_sum());
       jsonObjectSI1.put("time_of_operation",data.getTime_of_operation());
       jsonObjectGF.put("growth_force",jsonObjectSI1);
//       竞争力
       JSONObject jsonObjectCF=new JSONObject();
       JSONObject jsonObjectSI2=new JSONObject();
       jsonObjectSI2.put("baidu_included",data.getBaidu_included());
       jsonObjectSI2.put("webmaster_ranking",data.getWebmaster_ranking());
       jsonObjectSI2.put("search_engine_index",data.getSearch_engine_index());
       jsonObjectCF.put("competitive_force",jsonObjectSI2);
//       融资力
       JSONObject jsonObjectFF=new JSONObject();
       JSONObject jsonObjectSI3=new JSONObject();
       jsonObjectSI3.put("shareholder_number",data.getShareholder_number());
       jsonObjectSI3.put("business_valuation",data.getBusiness_valuation());
       jsonObjectSI3.put("shareholder_equity",data.getShareholder_equity());
       jsonObjectSI3.put("Market_makers_number",data.getMarket_makers_number());
       jsonObjectSI3.put("investor_name",data.getInvestor_name());
       jsonObjectSI3.put("investor_number",data.getInvestor_number());
       jsonObjectSI3.put("equity_investment_number",data.getEquity_investment_frequency());
       jsonObjectSI3.put("equity_investment_frequency",data.getEquity_investment_frequency());
       jsonObjectSI3.put("bond_financing_amount",data.getBond_financing_amount());
       jsonObjectSI3.put("amount_of_financing",data.getAmount_of_financing());
       jsonObjectFF.put("financing_force",jsonObjectSI3);

       jsonObject.put("company_id",data.getCompany_id());
       jsonObject.put("growth_force",jsonObjectSI1);
       jsonObject.put("competitive_force",jsonObjectSI2);
       jsonObject.put("financing_force",jsonObjectSI3);
   }

}
