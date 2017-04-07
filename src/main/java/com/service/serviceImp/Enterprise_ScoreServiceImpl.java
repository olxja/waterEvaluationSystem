package com.service.serviceImp;

import com.bean.Enterprise_score;
import com.bean.Response;
import com.dao.EnterScoreMapper;
import com.service.Enterprise_ScoreService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by olxja_000 on 2017/4/6.
 */
@Service("Enterprise_ScoreService")
@Transactional
public class Enterprise_ScoreServiceImpl implements Enterprise_ScoreService {

     private EnterScoreMapper enterScore;
    @Override
    public Response insertEnterScore (Response response,Enterprise_score score){
        Integer num=0;
        try {
            num=enterScore.insertEnterScore(score);
            if(num==0){
                response.setSuccess(false);
                String info="already exit this data";
                response.setData(info);
            }else{
                String info="insert "+num+" row success";
                response.success(info);
            }
        }catch (Exception e){
            response.failure(e.getMessage());
        }

        return response;
    }
}
