package my.it.nsfw.info.service.impl;


import javax.annotation.Resource;

import my.it.core.service.impl.BaseServiceImpl;
import my.it.nsfw.info.dao.InfoDao;
import my.it.nsfw.info.entity.Info;
import my.it.nsfw.info.service.InfoService;

import org.springframework.stereotype.Service;

@Service("infoService")
public class InfoServiceImpl extends BaseServiceImpl<Info> implements InfoService {

	private InfoDao infoDaoImpl;
	
	@Resource
	public void setInfoDaoImpl(InfoDao infoDaoImpl) {
		super.setBaseDao(infoDaoImpl);
		this.infoDaoImpl = infoDaoImpl;
	}

}
