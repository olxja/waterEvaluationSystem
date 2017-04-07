package com.service.serviceImp;

import com.service.EnterRelationService;
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
@Service(value = "enterRelationService")
@Transactional
public class EnterRelationServiceImpl implements EnterRelationService {
    @Resource
    private HttpSolrClient enterprise_foreign_investmentSolr;
    @Resource
    private HttpSolrClient enterprise_affiliateSolr;

    @Override
    public JSONObject query(String company_id, Integer start, Integer rows) throws IOException, SolrServerException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("enterprise_foreign_investment", SolrUtils.getEnterResult(enterprise_foreign_investmentSolr,company_id,start,rows));
        jsonObject.put("enterprise_affiliate",SolrUtils.getEnterResult(enterprise_affiliateSolr,company_id,start,rows));
        return jsonObject;
    }

    @Override
    public JSONObject nextForeignInvestment(String company_id, Integer start, Integer rows) throws IOException, SolrServerException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("enterprise_foreign_investment", SolrUtils.getEnterResult(enterprise_foreign_investmentSolr,company_id,start,rows));
        return jsonObject;
    }

    @Override
    public JSONObject nextAffiliate(String company_id, Integer start, Integer rows) throws IOException, SolrServerException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("enterprise_affiliate", SolrUtils.getEnterResult(enterprise_affiliateSolr,company_id,start,rows));
        return jsonObject;
    }
}
