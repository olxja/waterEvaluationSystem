package com.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * Created by olxja_000 on 2017/3/15.
 */
public interface EnterScoreService {
    JSONObject query(String company_id, Integer start, Integer rows) throws IOException, SolrServerException;
}
