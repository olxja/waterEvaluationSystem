package com.service.serviceImp;

import com.service.EnterNumService;
import net.sf.json.JSONArray;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by olxja_000 on 2017/3/9.
 */
@Service(value = "enterNumService")
@Transactional
public class EnterNumServiceImpl implements EnterNumService {

    @Resource
    private HttpSolrClient company_number_appSolr;
   @Override
    public JSONArray queryCount(String company_id) throws IOException, SolrServerException{
       SolrQuery solrQuery = new SolrQuery();
       Map<String,String> map = new HashMap<String,String>();
       map.put("wt","json");
       SolrParams params = new MapSolrParams(map);
       solrQuery.add(params);
       //关键词
       solrQuery.setQuery("*:*");
       //过滤
       solrQuery.setFilterQueries("company_id:"+company_id);
       QueryResponse query = company_number_appSolr.query(solrQuery);
       SolrDocumentList results = query.getResults();
       //返回列表
       JSONArray jsonArray = JSONArray.fromObject(results);
       return jsonArray;
   }

}