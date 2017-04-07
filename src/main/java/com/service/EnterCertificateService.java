package com.service;

import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * Created by olxja_000 on 2017/3/17.
 */
public interface EnterCertificateService extends EnterInfoService  {
    JSONObject query(String company_id, Integer start, Integer rows) throws IOException, SolrServerException;
}
