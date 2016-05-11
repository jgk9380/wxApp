create  sequence wx_seq_generator  start with 10000
create  sequence wx_qr_scenen_id_seq_generator

drop table  wx_app
create table wx_app(
  id varchar2(100) primary key,--app_id��֧�ֶ��΢�źŽ���
  app_name varchar2(20) unique ,
  App_Secret varchar2(100) ,--���ڼ��ܴ洢
  app_token varchar(100),      --���ڼ��ܴ洢
  user_name varchar2(100)  unique ,--���ͷ��ʺţ�һ��OpenID��
  token varchar2(100),--
  token_date date,--token��ȡʱ�䡣
  toke_expire integer, --��ʱ����
  remark varchar2(20)
)



drop table wx_user
create table wx_user(
  id integer primary key,
  app_id  references wx_app,--֧�ֶ��΢�źŽ��롣
  open_id varchar2(60) ,
  NICKNAME varchar2(100),
  SEX varchar2(6),
  COUNTRY varchar2(40),
  PROVINCE varchar2(40),
  CITY varchar2(40),
  LANGUAGE varchar2(40),
  HEADIMGURL varchar2(40),
  user_group varchar2(60),    
  SUBSCRIBE_date date,  --�״ι�עʱ�䡣
  SUBSCRIBE_status number ,--0 Ϊ��ע��1��ע��-1��ע��ȡ���� 
  unique(app_id,open_id) 
)

create table wx_user_add_info(--�û�������Ϣ��
       id integer primary key references wx_user,
       tele varchar2(11), --�Ǽǵĺ���
       Long_NAME varchar2(40),--�Ǽǵ�����
       mail_ADDR  varchar2(200),--�Ǽǵ��ʼ���ַ
       PROMOTION_CODE varchar2(20),--�ǼǵĻ����
       referee_id  references wx_user, --�Ƽ���       
       USER_TYPE varchar2(40) check(user_type in ('employee','traditionAgent','wxagent','comm'))--�û�����:Ա���������̣�΢�Ŵ����̣���ͨ�û�
  )
  
drop table wx_msg_type

create table wx_msg_type(    
  id varchar2(20) primary key,--msg_type
  remark varchar2(200),
  handle_class_name varchar2(200), --�����������Ϊ��ȡĬ�ϴ����ࡣ
  defer integer default 0 check (defer in (0,1))--�Ƿ��ӳٴ���   
)

create table wx_event_type(
  id varchar2(20) primary key,
  remark varchar2(200),
  handle_class_name varchar2(200), --�����������Ϊ��ȡĬ�ϴ����ࡣ
  defer integer default 0 check (defer in (0,1))--�Ƿ��ӳٴ���   
)

drop table  wx_user_msg

create table wx_user_msg(
  id integer primary key,
  user_id  references wx_user,
  msg_type  references wx_msg_type, 
  msg_id varchar2(30),  
  event_type varchar2(60) references wx_event_type,
  event_key varchar2(600),
  scene_args varchar2(2000) ,--����������json�ַ�����
  create_time date ,--���ʱ��
  occur_date date default sysdate,--����ʱ��
  handle_time date,
  handle_result varchar2(2000),--������ json�ַ���
  handled_flag varchar2(20),--������ sucess ,fail,fail�ĸ�Ԥ�����´��� 
  remark varchar2(200)  
)



drop table  wx_promotion

create table wx_promotion(
  id integer  primary key,
  alias varchar2(80) unique,
  start_date date,
  end_date date,
  allow_join_Sql clob,--��ɲμӵ��û�sql��userId ����,������Ϊ   list<userId> --Ϊ�����нԿ�
  allow_interface_name  varchar2(200),--�ж��û��Ƿ���Բμӻ��Ϊ��Ĭ��Ϊִ�������Sql
  gift_select_sql clob,--��Ʒѡ��Χ��openId���� ,����list<giftId>    --Ϊ�գ���ȫ���
  gift_select_interface_name varchar2(200),--�û�ѡ�����Ʒ��Χ��Ϊ��Ĭ��Ϊִ�������Sql  
  remark varchar2(200), --
  note varchar2(200),--�û���֪
  is_passive integer default 0 check( is_passive in (0,1)) --1Ϊ����
)

drop table wx_gift_model

create table wx_gift_model(  --��Ϊ�ɷָ��࣬����ȯ�༰ʵ����
  id integer primary key,
  alias varchar2(40) unique ,-- ��������
  unit varchar2(8) default '��',
  gift_type varchar2(20) check (gift_type in ('cash','fee','traffic','coupon','matter')),--enum����  
  class_name varchar2(20),--��Ʒ������࣬�̳�Gift
  remark varchar2(200),
  notes  varchar2(200)--�û���֪�� 
)


drop table  wx_promotion_gift
create table wx_promotion_gift(
    id varchar2(30) primary key,--��� ������ʾ
    promotion_id  references wx_promotion,--�ID
    gift_model_id   references wx_gift_model,--
    face_value number  default 1 check(face_value>0),-- ��ֵ ������ȯ��ʾ��ֵ, ʵ��һ��Ϊ1
    gainer integer references wx_user, --Ϊ�ձ�ʾ��δ����ȡ
    gain_date  date,
    gain_way varchar2(200),
    remark varchar2(200) 
)

drop table wx_account_rec

create table wx_account_rec(--��Ʒ����Ϊ�ɷָ��࣬����ȯ��ʵ����
    id integer  primary key,--��ˮ��
    user_id references  wx_user(id),
    gift_model integer references wx_gift_model,
    face_vaule number, --��ֵ  ����Ϊ���룬�����ѣ��ֽ�����������Ϊ֧��  
    gift_id references wx_promotion_gift,--���ͨ����Ʒ��ã���־��Ʒ��,֧��Ϊ��
    occur_date date,--���ʱ���ɷָ����ʹ��ʱ��
    is_used integer check (is_used in (0,1)), --����ʵ�Ｐ����ȯ ���ø�����ʾ
    used_date date,--ʵ�Ｐ����ȯ
    use_remark varchar2(300),--��ȡ���ʼĽ����ʹ�����˵��
    remark varchar2(200)
)




select * from wx_app for update

select * from wx_event_type for update

select * from wx_gift_model for update

select * from wx_promotion for update

commit


--�˵����˵�����



drop table wx_article
create table  wx_article(--���¹���
    id integer  primary key,
    content clob,
    type varchar2(40) check (type in ('joke','Essay','news','breakEvent','notice')),-- 0��Ц����1������ 2������ 3��ͻ���¼� 4֪ͨ
    create_date date default sysdate
    
)

drop table  wx_article_read_history
create table wx_article_read_history(--�Ķ���ʷ
    id integer primary key ,
    article_id integer references wx_article,
    user_id integer references wx_user,
    read_date date default sysdate
)

create table wx_article_retrans_history(--ת����ʷ
    id integer primary key ,
    article_id integer references wx_article,
    user_id references wx_user,  
    retrans_date date default sysdate, --ת������
    read_count integer --���Ķ�����
)

drop table wx_per_qr_code
create table wx_per_qr_code(--��ά�����
    ticket varchar2(200) primary key,
    action_name varchar2(20)  default 'QR_LIMIT_SCENE' check(action_name in ('QR_LIMIT_SCENE' , 'QR_LIMIT_STR_SCENE')) , --QR_SCENEΪ��ʱ,QR_LIMIT_SCENEΪ����,QR_LIMIT_STR_SCENE
    action_info varchar2(300), --��ά����ϸ��Ϣ  (app,createDate,userId,promotionId��)
    sencen_id  integer unique,  --����ID  ��ʱ��ά��ʱΪ32λ��0���ͣ����ö�ά��ʱ���ֵΪ100000��Ŀǰ����ֻ֧��1--100000��
    scene_str  varchar2(64),--����ֵID���ַ�����ʽ��ID�����ַ������ͣ���������Ϊ1��64�������ö�ά��֧�ִ��ֶ�
    --sencen_value varchar2(300), --����json�ַ�(app,createDate,userId,promotionId��)
    picture_url varchar2(600),--ͼƬurl
    picture blob,     --ͼƬ       
    scene_flag varchar2(20) default 'user' check(scene_flag in ('user','promotion','mix')),--0Ϊuser ,1Ϊ�
    create_date date, --����ʱ�䡣
    user_Id unique references wx_user,
    media_Id varchar2(300) ,--ý��ID���������������ϴ�
    media_UpTime date--�ϴ�ʱ��
    
)

drop table wx_temp_qr_code
create table wx_temp_qr_code(--��ά�����
    ticket varchar2(200) primary key,
    --action_name varchar2(20) check(action_name in ('QR_SCENE'), --  QR_SCENEΪ��ʱ,QR_LIMIT_SCENEΪ����,QR_LIMIT_STR_SCENE
    action_info integer, --��ά����ϸ��Ϣ  
    sencen_id   integer, --����ID  ��ʱ��ά��ʱΪ32λ��0���ͣ����ö�ά��ʱ���ֵΪ100000��Ŀǰ����ֻ֧��1--100000��
    picture_url varchar2(200),--ͼƬurl
    picture blob,     --ͼƬ       
    scene_flag varchar2(20) default 'user' check(scene_flag in ('user','promotion','mix')),--0Ϊuser ,1Ϊ�
    expire_seconds integer,--ʧЧʱ��
    create_date date, --����ʱ�䡣
    userId references wx_user
)

select * from wx_app for update









