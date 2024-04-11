
SET foreign_key_checks = 0;

truncate table MEMBER_TB;
truncate table IMAGE_TB;
truncate table MATERIAL_TB;
truncate table PRODUCT_TB;
truncate table TRADE_TB;

SET foreign_key_checks = 1;

insert into MEMBER_TB values (1,'이진혁',TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30, current_time), '98102214801017', '기업은행',010-2293-5028);
insert into MEMBER_TB values (2,'황대선',TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30, current_time), '1231231231', '기업은행',010-1212-1212);
insert into MATERIAL_TB values (1, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30, current_time), 'FOOD','응애',1),
                               (2, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30, current_time), 'FOOD','응애2',2),
                               (3, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30, current_time), 'FOOD','응애3',1);

insert into PRODUCT_TB values (1,TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time), '상품설명', '상품이름',1000,2,20,1),
                              (2,TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time), '상품설명2', '상품이름2',2000,1,10,2),
                              (3,TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time), '상품설명3', '상품이름3',3000,1,30,3),
                              (4,TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time), '상품설명3', '상품이름3',4000,1,50,1);

insert into IMAGE_TB values(1, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time),1),
                           (2, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time),1),
                           (3, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time),1);

insert into TRADE_TB values(1, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time),0,20,1,1);