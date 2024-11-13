package com.gimhae.sts10.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimhae.sts10.model.entity.Dept02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeptService {
	@Autowired
	DeptRepo deptRepo;

	public List<Dept02> getList(){
		Iterable<Dept02> iteObj = deptRepo.findAll();
		List<Dept02> list=new ArrayList<>();
		
//		Iterator<Dept02> ite = iteObj.iterator();
//		while(ite.hasNext()) {
//			Dept02 bean = ite.next();
//			if(bean==null)break;
//			list.add(bean);
//		}
		
//		Consumer consum=new Consumer<Dept02>() {
//			@Override
//			public void accept(Dept02 ele) {
//				list.add(ele);
//			}
//		};
//		iteObj.forEach(consum);
		
		
//		Consumer<Dept02> consum=ele->list.add(ele);
//		iteObj.forEach(consum);

//		Consumer<Dept02> consum=ele->{list.add(ele);};
		
		iteObj.forEach(ele->list.add(ele));
		return list;
	}

	public void addList(DeptVo bean) {
		deptRepo.save(Dept02.builder()
				.dname(bean.getDname())
				.loc(bean.getLoc())
				.build());
	}

	public DeptVo getOne(int deptno) {
		Optional<Dept02> entity = deptRepo.findById(deptno);
		log.debug(entity.toString());
		if(entity.isEmpty()) return null;
		DeptVo bean=DeptVo.builder()
				.deptno(entity.get().getDeptno())
				.dname(entity.get().getDname())
				.loc(entity.get().getLoc())
				.build();
		return bean;
	
	}

	public void editOne(DeptVo bean) {
		Dept02 entity=deptRepo.findById(bean.getDeptno()).get();
		entity.setDname(bean.getDname());
		entity.setLoc(bean.getLoc());
		deptRepo.save(entity);
	}
}












