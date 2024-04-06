insert into MEMBER_TB values (1,TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30, current_time),'이진혁');
insert into MEMBER_TB values (2,TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30, current_time),'황대선');
insert into MATERIAL_TB values (1, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30, current_time), 'FOOD','응애',1),
                               (2, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30, current_time), 'FOOD','응애2',1),
                               (3, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30, current_time), 'FOOD','응애3',1);

insert into PRODUCT_TB values (1,TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time), 2, '상품설명', '상품이름',1000,1,1),
                              (2,TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time), 2, '상품설명2', '상품이름2',2000,1,2),
                              (3,TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time), 2, '상품설명3', '상품이름3',3000,1,3),
                              (4,TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time), null, '상품설명3', '상품이름3',4000,1,1);

insert into IMAGE_TB values(1, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time),1),
                           (2, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time),1),
                           (3, TIMESTAMPADD(MINUTE, -30, current_time), TIMESTAMPADD(MINUTE, 30,current_time),1);