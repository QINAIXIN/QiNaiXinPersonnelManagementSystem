package org.javaboy.vhr.service;

import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.model.vo.AppraiseListReqVo;
import org.javaboy.vhr.model.vo.AppraiseReqVo;

public interface AppraiseService {
    void add(AppraiseReqVo appraiseReqVo);

    void update(AppraiseReqVo appraiseReqVo);

    void delete(Integer id);

    RespPageBean list(Integer page,Integer size);
}
