package cn.itcast.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.Other;
import cn.itcast.service.OtherService;
import cn.itcast.service.base.DaoSupport;
@Service
@Transactional
public class OtherServiceImpl extends DaoSupport<Other> implements OtherService{

}
