package com.service;

import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**企业service的根接口
 * Created by lenovo on 2016/9/29.
 */
public interface EnterInfoService {
    JSONObject query(String company_id, Integer start, Integer rows) throws IOException, SolrServerException;
}
