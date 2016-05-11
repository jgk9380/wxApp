package org.wx;

import org.entity.WxPromotionGift;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
//活动管理器，根据
public interface PromotionGiftSelector {   
    //boolean isUserAllowJoioned(long userId,int promotionId);
    /**
    @Transactional标注的位置@Transactional注解可以标注在类和方法上，
    也可以标注在定义的接口和接口方法上。如果我们在接口上标注@Transactional注解，
    会留下这样的隐患：因为注解不能被继承，
    所以业务接口中标注的@Transactional注解不会被业务实现类继承。
    所以可能会出现不启动事务的情况。所以，Spring建议我们将@Transaction注解在实现类上。
    在方法上的@Transactional注解会覆盖掉类上的@Transactional。**/
   // @Transactional(isolation = Isolation.SERIALIZABLE)
    WxPromotionGift getGiftId(long userId,int promotionId);    
}
