package org.dao;


import java.util.List;


import javax.transaction.Transactional;

import org.entity.WxApp;

import org.entity.WxShareLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;


//@Repository("ied")
//@Transactional
public interface WxShareLogDao extends CrudRepository<WxShareLog, Long> {    
   
}
