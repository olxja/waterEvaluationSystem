package com.service;

import net.sf.json.JSONArray;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * Created by olxja_000 on 2017/3/9.
 */
public interface EnterNumService {
    JSONArray queryCount(String company_id) throws IOException, SolrServerException;
}
