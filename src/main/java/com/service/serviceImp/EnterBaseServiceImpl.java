package com.service.serviceImp;

import com.service.EnterBaseService;
import com.utils.Constants;
import net.sf.json.JSONArray;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * Created by olxja_000 on 2017/3/6.
 */
@Service(value = "enterBaseService")
@Transactional
public class EnterBaseServiceImpl implements EnterBaseService {


    @Resource
    private HttpSolrClient enterprise_baseSolr;
    @Resource
    private Map<String,String> allIndustryMap;

    @Override
    public JSONArray query(String company_id) throws IOException, SolrServerException{
        SolrQuery solrQuery = new SolrQuery();
        Map<String,String> map = new HashMap<String,String>();
        map.put("wt","json");
        SolrParams params = new MapSolrParams(map);
        solrQuery.add(params);
        solrQuery.setQuery("*:*");
        solrQuery.setFilterQueries("company_id:"+company_id);
//        设置字段，沿用waterapp中的字段摘取
        solrQuery.setFields("company_id","company_name","company_logo","tag","updatetime",
                "legal_representative","register_capital","registerDate","phone_number",
                "email","registration_address","website","industry",
                "company_type","business_scope","operating_status");
        QueryResponse query = enterprise_baseSolr.query(solrQuery);
        SolrDocumentList results = query.getResults();
        Iterator<SolrDocument> iterator = results.iterator();
        while (iterator.hasNext()){
            SolrDocument doc = iterator.next();
            //根据字典获得行业类别
            String industry = (String) doc.remove("industry");
            if (null == industry){
                industry = "0";
            }
            industry = allIndustryMap.get(industry);
            if (null != industry){
                doc.put("industry",industry);
            }else {
                doc.put("industry", Constants.noData);
            }
        }
        JSONArray jsonArray = JSONArray.fromObject(results);
        return jsonArray;
    }
}
