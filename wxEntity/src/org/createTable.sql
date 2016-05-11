create  sequence wx_seq_generator  start with 10000
create  sequence wx_qr_scenen_id_seq_generator

drop table  wx_app
create table wx_app(
  id varchar2(100) primary key,--app_id，支持多个微信号接入
  app_name varchar2(20) unique ,
  App_Secret varchar2(100) ,--后期加密存储
  app_token varchar(100),      --后期加密存储
  user_name varchar2(100)  unique ,--发送方帐号（一个OpenID）
  token varchar2(100),--
  token_date date,--token获取时间。
  toke_expire integer, --超时秒数
  remark varchar2(20)
)



drop table wx_user
create table wx_user(
  id integer primary key,
  app_id  references wx_app,--支持多个微信号接入。
  open_id varchar2(60) ,
  NICKNAME varchar2(100),
  SEX varchar2(6),
  COUNTRY varchar2(40),
  PROVINCE varchar2(40),
  CITY varchar2(40),
  LANGUAGE varchar2(40),
  HEADIMGURL varchar2(40),
  user_group varchar2(60),    
  SUBSCRIBE_date date,  --首次关注时间。
  SUBSCRIBE_status number ,--0 为关注，1关注，-1关注后取消。 
  unique(app_id,open_id) 
)

create table wx_user_add_info(--用户附加信息表
       id integer primary key references wx_user,
       tele varchar2(11), --登记的号码
       Long_NAME varchar2(40),--登记的名称
       mail_ADDR  varchar2(200),--登记的邮件地址
       PROMOTION_CODE varchar2(20),--登记的活动代码
       referee_id  references wx_user, --推荐人       
       USER_TYPE varchar2(40) check(user_type in ('employee','traditionAgent','wxagent','comm'))--用户类型:员工，代理商，微信代理商，普通用户
  )
  
drop table wx_msg_type

create table wx_msg_type(    
  id varchar2(20) primary key,--msg_type
  remark varchar2(200),
  handle_class_name varchar2(200), --处理的类名，为空取默认处理类。
  defer integer default 0 check (defer in (0,1))--是否延迟处理   
)

create table wx_event_type(
  id varchar2(20) primary key,
  remark varchar2(200),
  handle_class_name varchar2(200), --处理的类名，为空取默认处理类。
  defer integer default 0 check (defer in (0,1))--是否延迟处理   
)

drop table  wx_user_msg

create table wx_user_msg(
  id integer primary key,
  user_id  references wx_user,
  msg_type  references wx_msg_type, 
  msg_id varchar2(30),  
  event_type varchar2(60) references wx_event_type,
  event_key varchar2(600),
  scene_args varchar2(2000) ,--场景参数，json字符串。
  create_time date ,--入库时间
  occur_date date default sysdate,--发生时间
  handle_time date,
  handle_result varchar2(2000),--处理结果 json字符串
  handled_flag varchar2(20),--处理结果 sucess ,fail,fail的干预后重新处理 
  remark varchar2(200)  
)



drop table  wx_promotion

create table wx_promotion(
  id integer  primary key,
  alias varchar2(80) unique,
  start_date date,
  end_date date,
  allow_join_Sql clob,--许可参加的用户sql，userId 参数,输出结果为   list<userId> --为空所有皆可
  allow_interface_name  varchar2(200),--判断用户是否可以参加活动，为空默认为执行上面的Sql
  gift_select_sql clob,--礼品选择范围。openId参数 ,返回list<giftId>    --为空，完全随机
  gift_select_interface_name varchar2(200),--用户选择的礼品范围，为空默认为执行上面的Sql  
  remark varchar2(200), --
  note varchar2(200),--用户须知
  is_passive integer default 0 check( is_passive in (0,1)) --1为被动
)

drop table wx_gift_model

create table wx_gift_model(  --分为可分割类，代金券类及实物类
  id integer primary key,
  alias varchar2(40) unique ,-- 中文名称
  unit varchar2(8) default '个',
  gift_type varchar2(20) check (gift_type in ('cash','fee','traffic','coupon','matter')),--enum类型  
  class_name varchar2(20),--礼品代表的类，继承Gift
  remark varchar2(200),
  notes  varchar2(200)--用户须知。 
)


drop table  wx_promotion_gift
create table wx_promotion_gift(
    id varchar2(30) primary key,--编号 界面显示
    promotion_id  references wx_promotion,--活动ID
    gift_model_id   references wx_gift_model,--
    face_value number  default 1 check(face_value>0),-- 面值 ，代金券表示面值, 实物一般为1
    gainer integer references wx_user, --为空表示还未被领取
    gain_date  date,
    gain_way varchar2(200),
    remark varchar2(200) 
)

drop table wx_account_rec

create table wx_account_rec(--礼品，分为可分割类，代金券及实物类
    id integer  primary key,--流水号
    user_id references  wx_user(id),
    gift_model integer references wx_gift_model,
    face_vaule number, --面值  正数为收入，（话费，现金，流量）负数为支出  
    gift_id references wx_promotion_gift,--如果通过礼品获得，标志礼品号,支出为空
    occur_date date,--获得时间或可分割类的使用时间
    is_used integer check (is_used in (0,1)), --用于实物及代金券 不用负数表示
    used_date date,--实物及代金券
    use_remark varchar2(300),--自取，邮寄结果及使用情况说明
    remark varchar2(200)
)




select * from wx_app for update

select * from wx_event_type for update

select * from wx_gift_model for update

select * from wx_promotion for update

commit


--菜单及菜单分组



drop table wx_article
create table  wx_article(--文章管理
    id integer  primary key,
    content clob,
    type varchar2(40) check (type in ('joke','Essay','news','breakEvent','notice')),-- 0：笑话，1：美文 2：新闻 3：突发事件 4通知
    create_date date default sysdate
    
)

drop table  wx_article_read_history
create table wx_article_read_history(--阅读历史
    id integer primary key ,
    article_id integer references wx_article,
    user_id integer references wx_user,
    read_date date default sysdate
)

create table wx_article_retrans_history(--转发历史
    id integer primary key ,
    article_id integer references wx_article,
    user_id references wx_user,  
    retrans_date date default sysdate, --转发日期
    read_count integer --被阅读次数
)

drop table wx_per_qr_code
create table wx_per_qr_code(--二维码管理
    ticket varchar2(200) primary key,
    action_name varchar2(20)  default 'QR_LIMIT_SCENE' check(action_name in ('QR_LIMIT_SCENE' , 'QR_LIMIT_STR_SCENE')) , --QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE
    action_info varchar2(300), --二维码详细信息  (app,createDate,userId,promotionId等)
    sencen_id  integer unique,  --场景ID  临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
    scene_str  varchar2(64),--场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
    --sencen_value varchar2(300), --场景json字符(app,createDate,userId,promotionId等)
    picture_url varchar2(600),--图片url
    picture blob,     --图片       
    scene_flag varchar2(20) default 'user' check(scene_flag in ('user','promotion','mix')),--0为user ,1为活动
    create_date date, --创建时间。
    user_Id unique references wx_user,
    media_Id varchar2(300) ,--媒体ID，当天无需重新上传
    media_UpTime date--上传时间
    
)

drop table wx_temp_qr_code
create table wx_temp_qr_code(--二维码管理
    ticket varchar2(200) primary key,
    --action_name varchar2(20) check(action_name in ('QR_SCENE'), --  QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE
    action_info integer, --二维码详细信息  
    sencen_id   integer, --场景ID  临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
    picture_url varchar2(200),--图片url
    picture blob,     --图片       
    scene_flag varchar2(20) default 'user' check(scene_flag in ('user','promotion','mix')),--0为user ,1为活动
    expire_seconds integer,--失效时间
    create_date date, --创建时间。
    userId references wx_user
)

select * from wx_app for update









