package com.service.serviceImp;

import com.service.EnterUnpromiseService;
import com.utils.SolrUtils;
import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by olxja_000 on 2017/3/16.
 */
@Service(value = "enterUnpromiseService")
@Transactional
public class EnterUnpromiseServiceImpl implements EnterUnpromiseService {
    @Resource HttpSolrClient enterprise_unpromise;

    @Override
    public JSONObject query(String company_id,Integer start,Integer rows) throws IOException, SolrServerException {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("enterUnpromise", SolrUtils.getEnterResult(enterprise_unpromise,company_id,start,rows));
        return jsonObject;
    }
}
