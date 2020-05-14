package org.javaboy.vhr.service.impl;

import org.javaboy.vhr.mapper.AppraiseMapper;
import org.javaboy.vhr.model.Appraise;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.model.util.DateUtil;
import org.javaboy.vhr.model.vo.AppraiseRespVo;
import org.javaboy.vhr.service.AppraiseService;
import org.javaboy.vhr.model.vo.AppraiseListReqVo;
import org.javaboy.vhr.model.vo.AppraiseReqVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Service
public class AppraiseServiceImpl implements AppraiseService {

    @Autowired
    private AppraiseMapper appraiseMapper;

    @Override
    public RespPageBean list(Integer page,Integer size) {
        List<AppraiseRespVo> resultList = new ArrayList<>();
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Appraise> list = appraiseMapper.getPage(page, size);
        list.forEach(item->{
            AppraiseRespVo respVo = new AppraiseRespVo();
            BeanUtils.copyProperties(item,respVo);
            respVo.setAppdate(DateUtil.formatDate(item.getAppdate(),"yyyy-MM-dd"));
            resultList.add(respVo);
        });
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(resultList);
        respPageBean.setTotal(appraiseMapper.getTotal());
        return respPageBean;
    }

    @Override
    public void add(AppraiseReqVo appraiseReqVo) {
        Appraise appraise = new Appraise();
        BeanUtils.copyProperties(appraiseReqVo,appraise);
        appraiseMapper.insertSelective(appraise);
    }

    @Override
    public void update(AppraiseReqVo appraiseReqVo) {
        Appraise appraise = new Appraise();
        BeanUtils.copyProperties(appraiseReqVo,appraise);
        appraiseMapper.updateByPrimaryKeySelective(appraise);
    }

    @Override
    public void delete(Integer id) {
        appraiseMapper.deleteByPrimaryKey(id);
    }


}
