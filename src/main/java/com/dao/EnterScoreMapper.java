package com.dao;

import com.bean.Enterprise_score;
import org.springframework.stereotype.Repository;

/**
 * Created by olxja_000 on 2017/4/6.
 */
@Repository("enterScoreMapper")
public interface EnterScoreMapper {
    Integer insertEnterScore(Enterprise_score score);
}
