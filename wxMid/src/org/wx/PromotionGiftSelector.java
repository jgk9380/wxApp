package org.wx;

import org.entity.WxPromotionGift;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
//�������������
public interface PromotionGiftSelector {   
    //boolean isUserAllowJoioned(long userId,int promotionId);
    /**
    @Transactional��ע��λ��@Transactionalע����Ա�ע����ͷ����ϣ�
    Ҳ���Ա�ע�ڶ���Ľӿںͽӿڷ����ϡ���������ڽӿ��ϱ�ע@Transactionalע�⣬
    ��������������������Ϊע�ⲻ�ܱ��̳У�
    ����ҵ��ӿ��б�ע��@Transactionalע�ⲻ�ᱻҵ��ʵ����̳С�
    ���Կ��ܻ���ֲ������������������ԣ�Spring�������ǽ�@Transactionע����ʵ�����ϡ�
    �ڷ����ϵ�@Transactionalע��Ḳ�ǵ����ϵ�@Transactional��**/
   // @Transactional(isolation = Isolation.SERIALIZABLE)
    WxPromotionGift getGiftId(long userId,int promotionId);    
}
