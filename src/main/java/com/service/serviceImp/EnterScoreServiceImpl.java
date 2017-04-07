package com.service.serviceImp;

import com.service.EnterScoreService;
import com.utils.SolrUtils;
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
 * Created by olxja_000 on 2017/3/15.
 */
@Service(value = "enterScoreService")
@Transactional
public class EnterScoreServiceImpl implements EnterScoreService {
    @Resource
    private HttpSolrClient enterprise_score;
    @Override
    public JSONObject query(String company_id,Integer start,Integer rows) throws IOException, SolrServerException {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("enterScore", SolrUtils.getEnterResult(enterprise_score,company_id,start,rows));
        return jsonObject;
    }
}
