package com.service.serviceImp;

import com.service.EnterICService;
import com.utils.SolrUtils;
import net.sf.json.JSONObject;
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
import java.util.Map;

/**
 * Created by olxja_000 on 2017/3/10.
 */
@Service(value = "enterICService")
@Transactional

    public class EnterICServiceImpl implements EnterICService{
        @Resource
        private HttpSolrClient enterprise_baseSolr;
        @Resource
        private HttpSolrClient enterprise_shareholder_personSolr;
        @Resource
        private HttpSolrClient enterprise_key_personSolr;
        @Resource
        private HttpSolrClient enterprise_change_recordSolr;

        @Resource
        private Map<String,String> allIndustryMap;
        /**
         * 企业登记信息,股东信息,主要人员,变更记录
         * @param company_id
         */
        @Override
        public JSONObject query(String company_id) throws IOException, SolrServerException {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("enterprise_shareholder_person", SolrUtils.getEnterResult(enterprise_shareholder_personSolr,company_id));
            jsonObject.put("enterprise_key_person",SolrUtils.getEnterResult(enterprise_key_personSolr,company_id));
            jsonObject.put("enterprise_change_record",SolrUtils.getEnterResult(enterprise_change_recordSolr,company_id));
            return jsonObject;
        }
}
