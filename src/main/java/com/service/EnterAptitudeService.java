package com.service;

import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * Created by olxja_000 on 2017/3/26.
 */
public interface EnterAptitudeService extends EnterInfoService {
    JSONObject query(String company_id, Integer start, Integer rows) throws IOException, SolrServerException;
}