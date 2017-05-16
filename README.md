#DatabaseOperation


conf 配置类
dao 数据库操作
dto 
model 实体
svc 服务接口层
web Controller
    
    
    
```
drop table if exists demo;
create table demo
(
  id varchar(50) not null comment '标识',
  name varchar(50) not null comment '姓名',
  pasv varchar(50) not null comment '密码',
  descr varchar(255) null comment '备注',
  primary key(id),
  unique index UK_DEMO_NAME(name)
)comment='样例表'
  collate='utf8_general_ci'
  engine=InnoDB;
```