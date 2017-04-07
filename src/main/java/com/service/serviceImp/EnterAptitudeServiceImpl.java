package com.service.serviceImp;

import com.service.EnterAptitudeService;
import com.utils.SolrUtils;
import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by olxja_000 on 2017/3/26.
 */
@Service(value = "enterAptitudeService")
@Transactional
public class EnterAptitudeServiceImpl implements EnterAptitudeService {
    @Resource
    HttpSolrClient enterprise_aptitudeSolr1;
    @Resource
    HttpSolrClient enterprise_aptitudeSolr2;
    @Resource
    HttpSolrClient enterprise_aptitudeSolr3;
    @Resource
    HttpSolrClient enterprise_aptitudeSolr4;
    @Resource
    HttpSolrClient enterprise_aptitudeSolr5;
    @Resource
    HttpSolrClient enterprise_aptitudeSolr6;
    @Resource
    HttpSolrClient enterprise_aptitudeSolr7;

    @Override
    public JSONObject query(String company_id, Integer start, Integer rows) throws IOException, SolrServerException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("enterprise_eaglesplan", SolrUtils.getEnterResult(enterprise_aptitudeSolr1, company_id, start, rows));
        jsonObject.put("enterprise_gold_seeds", SolrUtils.getEnterResult(enterprise_aptitudeSolr2, company_id, start, rows));
        jsonObject.put("enterprise_high_tech_achievement_transformation_project", SolrUtils.getEnterResult(enterprise_aptitudeSolr3, company_id, start, rows));
        jsonObject.put("enterprise_innovation_technology_funding", SolrUtils.getEnterResult(enterprise_aptitudeSolr4, company_id, start, rows));
        jsonObject.put("enterprise_national_high_tech_enterprise", SolrUtils.getEnterResult(enterprise_aptitudeSolr5, company_id, start, rows));
        jsonObject.put("enterprise_science_technology_service", SolrUtils.getEnterResult(enterprise_aptitudeSolr6, company_id, start, rows));
        jsonObject.put("enterprise_zhongguanchun_high_tech", SolrUtils.getEnterResult(enterprise_aptitudeSolr7, company_id, start, rows));
        return jsonObject;
    }
    }
