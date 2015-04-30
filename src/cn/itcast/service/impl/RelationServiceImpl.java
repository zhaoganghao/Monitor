package cn.itcast.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.Relation;
import cn.itcast.service.RelationService;
import cn.itcast.service.base.DaoSupport;
@Service
@Transactional
public class RelationServiceImpl extends DaoSupport<Relation> implements RelationService{

}
