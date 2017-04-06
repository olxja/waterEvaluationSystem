package com.service;

import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * Created by lenovo on 2016/11/9.
 */
public interface EnterRelationService extends EnterInfoService{
    JSONObject nextForeignInvestment(String company_id, Integer start, Integer rows) throws IOException, SolrServerException;

    JSONObject nextAffiliate(String company_id, Integer start, Integer rows) throws IOException, SolrServerException;
}
