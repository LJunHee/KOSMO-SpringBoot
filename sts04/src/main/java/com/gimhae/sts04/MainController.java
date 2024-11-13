package com.gimhae.sts04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gimhae.sts04.model.DeptDao;
import com.gimhae.sts04.model.DeptVo;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class MainController {
	@Autowired
	DeptDao DeptDao;
	
	@ResponseBody
	@GetMapping("/")
	public List<DeptVo> index() {
		log.debug("index");
		return DeptDao.getList();
	}
	

}
