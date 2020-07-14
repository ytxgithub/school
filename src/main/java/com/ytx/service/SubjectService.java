package com.ytx.service;

import java.util.List;

import com.ytx.pojo.Subject;

public interface SubjectService {
	
	List<Subject> subjectLists(Long majorid);
}
