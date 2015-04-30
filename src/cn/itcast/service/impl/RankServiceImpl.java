package cn.itcast.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.Rank;
import cn.itcast.service.RankService;
import cn.itcast.service.base.DaoSupport;
@Service
@Transactional
public class RankServiceImpl extends DaoSupport<Rank> implements RankService{

}
