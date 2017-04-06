package com.service.serviceImp;

import com.service.EnterNewsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
 * Created by olxja_000 on 2017/3/27.
 */
@Service(value = "enterNewsService")
@Transactional
public class EnterNewsServiceImpl implements EnterNewsService {
    @Resource
    private HttpSolrClient enterprise_newsSolr;

    @Override
    public JSONObject query(String news_query, Integer start, Integer rows) throws IOException, SolrServerException {
        SolrQuery solrQuery = new SolrQuery();
        Map<String,String> map = new HashMap<String,String>();
        map.put("wt","json");
        SolrParams params = new MapSolrParams(map);
        solrQuery.add(params);
        //关键词
        solrQuery.setQuery("*:*");
        //过滤
        solrQuery.setFilterQueries("news_title:"+news_query+"* "+"and news_title: *"+news_query);
        //分页
        solrQuery.setStart(start);
        solrQuery.setRows(rows);
        //查询
        QueryResponse query = enterprise_newsSolr.query(solrQuery);
        SolrDocumentList results = query.getResults();
        //返回列表
        JSONArray jsonArray = JSONArray.fromObject(results);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("enterNews",jsonArray);
        return jsonObject;
    }
}
