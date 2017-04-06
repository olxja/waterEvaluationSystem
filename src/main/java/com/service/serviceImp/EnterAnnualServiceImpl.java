package com.service.serviceImp;

import com.service.EnterAnnualService;
import com.utils.SolrUtils;
import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by lenovo on 2016/9/29.
 */
@Service(value = "enterAnnualService")
@Transactional
public class EnterAnnualServiceImpl implements EnterAnnualService {
    @Resource
    private HttpSolrClient enterprise_annual_report_baseSolr;
    @Resource
    private HttpSolrClient enterprise_annual_report_shareholderSolr;
    @Resource
    private HttpSolrClient enterprise_annual_report_foreign_investmentSolr;
    @Resource
    private HttpSolrClient enterprise_annual_report_change_recordSolr;
    @Resource
    private HttpSolrClient enterprise_annual_report_share_changeSolr;

    /**
     * 企业登记信息,股东信息,主要人员,变更记录
     *
     * @param company_id
     */
    @Override
    public JSONObject query(String company_id, Integer start, Integer rows) throws IOException, SolrServerException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("enterprise_annual_report_base", SolrUtils.getEnterResult(enterprise_annual_report_baseSolr, company_id));
        jsonObject.put("enterprise_annual_report_shareholder", SolrUtils.getEnterResult(enterprise_annual_report_shareholderSolr, company_id));
        jsonObject.put("enterprise_annual_report_foreign_investment", SolrUtils.getEnterResult(enterprise_annual_report_foreign_investmentSolr, company_id));
        jsonObject.put("enterprise_annual_report_change_record", SolrUtils.getEnterResult(enterprise_annual_report_change_recordSolr, company_id));
        jsonObject.put("enterprise_annual_report_share_change", SolrUtils.getEnterResult(enterprise_annual_report_share_changeSolr, company_id));
        return jsonObject;
    }

}
