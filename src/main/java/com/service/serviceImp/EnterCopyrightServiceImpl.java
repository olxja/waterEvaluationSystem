package com.service.serviceImp;

import com.service.EnterCopyrightService;
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

@Service(value = "enterCopyrightService")
@Transactional
public class EnterCopyrightServiceImpl implements EnterCopyrightService {
    @Resource
    private HttpSolrClient enterprise_copyrightSolr;
    @Override
    public JSONObject query(String company_id, Integer start, Integer rows) throws IOException, SolrServerException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("enterprise_copyright", SolrUtils.getEnterResult(enterprise_copyrightSolr,company_id,start,rows));
        return jsonObject;
    }


}
