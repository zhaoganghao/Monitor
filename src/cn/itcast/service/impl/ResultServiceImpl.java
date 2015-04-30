package cn.itcast.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.Result;
import cn.itcast.service.ResultService;
import cn.itcast.service.base.DaoSupport;
@Service
@Transactional
public class ResultServiceImpl extends DaoSupport<Result> implements ResultService{

}
