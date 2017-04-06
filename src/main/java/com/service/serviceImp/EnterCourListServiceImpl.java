package com.service.serviceImp;

import com.service.EnterCourtListService;
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
@Service(value = "enterCourListService")
@Transactional
public class EnterCourListServiceImpl implements EnterCourtListService {
    @Resource HttpSolrClient enterprise_court_announcementSolr;
    @Override
    public JSONObject query(String company_id, Integer start, Integer rows)throws IOException, SolrServerException {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("enterCourList", SolrUtils.getEnterResult(enterprise_court_announcementSolr,company_id,start,rows));
        return jsonObject;
    }
}
