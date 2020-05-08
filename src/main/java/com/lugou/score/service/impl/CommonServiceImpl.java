package com.lugou.score.service.impl;

import com.alibaba.fastjson.JSON;
import com.lugou.score.dao.CanShuMapper;
import com.lugou.score.model.BaoBiaoModel;
import com.lugou.score.model.BaoBiaoPyModel;
import com.lugou.score.model.CanShuModel;
import com.lugou.score.model.CanShuPyModel;
import com.lugou.score.service.CommonService;
import com.lugou.score.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class CommonServiceImpl implements CommonService {

    @Resource
    private CanShuMapper canShuMapper;

    @Override
    public Integer updateCanshuTable(CanShuModel canShuModel) {
        System.out.println("入库之前" + JSON.toJSONString(canShuModel));
        return canShuMapper.updateCanShu(
                canShuModel.get秤号(),
                canShuModel.get物料名称(),
                canShuModel.get信号(),
                canShuModel.get速度(),
                canShuModel.get流量(),
                canShuModel.get负荷(),
                canShuModel.get零点(),
                canShuModel.get累计量(),
                canShuModel.get吸收系数(),
                canShuModel.get流量限值(),
                canShuModel.get恒速数值(),
                canShuModel.get人工零点(),
                canShuModel.get测零时间(),
                canShuModel.get空态界限(),
                canShuModel.get是否选中(),
                canShuModel.get运行状态(),
                canShuModel.get班产量(),
                canShuModel.get日产量(),
                canShuModel.get旬产量(),
                canShuModel.get运行时间(),
                canShuModel.get运载时间()
        );
    }

    @Override
    public List<CanShuPyModel> canshuList() {
        return canShuMapper.canshuList();
    }

    @Override
    public Integer queryDayStatement(String date, int chenghao) {
        return canShuMapper.queryDayStatement(date, chenghao);
    }

    @Override
    public Integer updateDayStatement(BaoBiaoModel baoBiaoModel) {
        return canShuMapper.updateDayStatement(
                baoBiaoModel.get日期(),
                baoBiaoModel.get秤号(),
                baoBiaoModel.get一班产量(),
                baoBiaoModel.get二班产量(),
                baoBiaoModel.get三班产量(),
                baoBiaoModel.get四班产量(),
                baoBiaoModel.get一班运行(),
                baoBiaoModel.get二班运行(),
                baoBiaoModel.get三班运行(),
                baoBiaoModel.get四班运行(),
                baoBiaoModel.get一班运载(),
                baoBiaoModel.get二班运载(),
                baoBiaoModel.get三班运载(),
                baoBiaoModel.get四班运载()
        );
    }

    @Override
    public Integer insertDayStatement(BaoBiaoModel baoBiaoModel) {
        return canShuMapper.insertDayStatement(
                baoBiaoModel.get日期(),
                baoBiaoModel.get秤号(),
                baoBiaoModel.get一班产量(),
                baoBiaoModel.get二班产量(),
                baoBiaoModel.get三班产量(),
                baoBiaoModel.get四班产量(),
                baoBiaoModel.get一班运行(),
                baoBiaoModel.get二班运行(),
                baoBiaoModel.get三班运行(),
                baoBiaoModel.get四班运行(),
                baoBiaoModel.get一班运载(),
                baoBiaoModel.get二班运载(),
                baoBiaoModel.get三班运载(),
                baoBiaoModel.get四班运载(),
                new Date()
        );
    }

    @Override
    public void excuteStatement(BaoBiaoModel baoBiaoModel) {
        if (queryDayStatement(baoBiaoModel.get日期(), baoBiaoModel.get秤号()) >= 1) {
            updateDayStatement(baoBiaoModel);
        } else {
            insertDayStatement(baoBiaoModel);
        }
    }

    @Override
    public List<BaoBiaoPyModel> getDayStatement(String date) {
        return canShuMapper.getDayStatement(date);
    }

    @Override
    public List<BaoBiaoPyModel> getMonthStatement(String chenghao, Date start, Date end) {
        return canShuMapper.getMonthStatement(chenghao, start, end);
    }

    @Override
    public Integer updateChanliang(int chenghao, int banci, String chanliang) {
        if (queryDayStatement(DateUtil.getCurDateStr(DateUtil.FORMAT_YMD), chenghao) < 1) {
            BaoBiaoModel baoBiaoModel = new BaoBiaoModel();
            baoBiaoModel.set秤号(chenghao);
            baoBiaoModel.set日期(DateUtil.getCurDateStr(DateUtil.FORMAT_YMD));
            insertDayStatement(baoBiaoModel);
        }
        switch (banci) {
            case 1:
                return canShuMapper.updateOneChanliang(DateUtil.getCurDateStr(DateUtil.FORMAT_YMD), chenghao, chanliang);
            case 2:
                return canShuMapper.updateTwoChanliang(DateUtil.getCurDateStr(DateUtil.FORMAT_YMD), chenghao, chanliang);
            case 3:
                return canShuMapper.updateThreeChanliang(DateUtil.getCurDateStr(DateUtil.FORMAT_YMD), chenghao, chanliang);
        }
        return -1;

    }

}
