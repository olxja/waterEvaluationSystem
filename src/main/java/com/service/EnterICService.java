package com.service;

import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * Created by olxja_000 on 2017/3/10.
 */
public interface EnterICService {
    JSONObject query(String company_id)throws IOException, SolrServerException;
}
