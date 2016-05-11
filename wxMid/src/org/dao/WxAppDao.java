package org.dao;


import java.util.List;


import javax.transaction.Transactional;

import org.entity.WxApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;


//@Repository("ied")
//@Transactional
public interface WxAppDao extends CrudRepository<WxApp, String> {
    
    WxApp findById(String id);

    WxApp findByAppName(String name);
    
    WxApp findByUserName(String userName);
}
