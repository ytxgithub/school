package com.ytx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ytx.mapper.SubjectMapper;
import com.ytx.pojo.Subject;
import com.ytx.service.SubjectService;
@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class SubjectServiceImpl implements SubjectService {
	@Autowired private SubjectMapper subjectMapper;
	@Override
	public List<Subject> subjectLists(Long majorid) {
		// TODO Auto-generated method stub
		return subjectMapper.subjectLists(majorid);
	}

}
