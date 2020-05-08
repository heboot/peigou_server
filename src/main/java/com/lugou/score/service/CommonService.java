package com.lugou.score.service;

import com.lugou.score.model.BaoBiaoModel;
import com.lugou.score.model.BaoBiaoPyModel;
import com.lugou.score.model.CanShuModel;
import com.lugou.score.model.CanShuPyModel;

import java.util.Date;
import java.util.List;

public interface CommonService {

    Integer updateCanshuTable(CanShuModel canShuModel);

    List<CanShuPyModel> canshuList();

    Integer queryDayStatement(String date,int chenghao);

    Integer updateDayStatement(BaoBiaoModel baoBiaoModel);

    Integer insertDayStatement(BaoBiaoModel baoBiaoModel);

    void excuteStatement(BaoBiaoModel baoBiaoModel);

    List<BaoBiaoPyModel> getDayStatement(String date);

    List<BaoBiaoPyModel> getMonthStatement(String chenghao,Date start, Date end);

    //更新的是一班 二班 三班产量
    Integer updateChanliang(int chenghao,int banci,String chanliang);

}
