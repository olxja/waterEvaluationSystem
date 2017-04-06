package com.service.serviceImp;

import com.service.EnterCertificateService;
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
@Service(value = "enterCertificateService")
@Transactional
public class EnterCertificateServiceImpl implements EnterCertificateService{
    @Resource
    HttpSolrClient enterprise_certificateSolr;
    @Override
    public JSONObject query(String company_id, Integer start, Integer rows)throws IOException, SolrServerException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("enterprise_certificate", SolrUtils.getEnterResult(enterprise_certificateSolr, company_id, start, rows));
        return jsonObject;
    }
}
