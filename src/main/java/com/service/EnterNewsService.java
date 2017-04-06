package com.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * Created by olxja_000 on 2017/3/27.
 */
public interface EnterNewsService extends EnterInfoService {
    JSONObject query(String news_query, Integer start, Integer rows) throws IOException, SolrServerException;
}
