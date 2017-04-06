package com.service.serviceImp;

import com.service.EnterPatentService;
import com.utils.SolrUtils;
import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by olxja_000 on 2017/3/17.
 */
@Service(value = "enterPatentService")
@Transactional
public class EnterPatentServiceImpl implements EnterPatentService{
    @Resource
    private HttpSolrClient enterprise_patentSolr;
    @Override
    public JSONObject query(String company_id, Integer start, Integer rows) throws IOException, SolrServerException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("enterprise_patent", SolrUtils.getEnterResult(enterprise_patentSolr,company_id,start,rows));
        return jsonObject;
    }
}
