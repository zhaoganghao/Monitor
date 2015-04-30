package cn.itcast.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.Criticize;
import cn.itcast.service.CriticizeService;
import cn.itcast.service.base.DaoSupport;
@Service
@Transactional
public class CriticizeServiceImpl extends DaoSupport<Criticize> implements CriticizeService{

}
