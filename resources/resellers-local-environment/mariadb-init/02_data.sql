-- Use resellers database
USE resellers;

set foreign_key_checks = 0;
truncate IMAGE_TB;
truncate MATERIAL_TB;
truncate PRODUCT_TB;
truncate MEMBER_TB;
truncate TRADE_TB;
set foreign_key_checks = 1;

-- Insert members into MEMBER_TB
INSERT INTO MEMBER_TB
VALUES (1, '이진혁', TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '98102214801017',
        '기업은행', '010-2293-5028'),
       (2, '황대선', TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '1231231231', '기업은행',
        '010-1212-1212');

-- Insert products into PRODUCT_TB
INSERT INTO PRODUCT_TB
VALUES (1, TIMESTAMPADD(WEEK , -12, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '상품설명', '상품이름', 200000, 0,
        '상품결함', 2),
       (2, TIMESTAMPADD(WEEK , -11, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '상품설명2', '상품이름2', 200000, 0,
        '상품결함', 2),
       (3, TIMESTAMPADD(WEEK , -10, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '상품설명3', '상품이름3', 250000, 0,
        '상품결함', 2),
       (4, TIMESTAMPADD(WEEK , -9, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '상품설명4', '상품이름4', 300000, 0,
        '상품결함', 2),
         (5, TIMESTAMPADD(WEEK , -8, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '상품설명5', '상품이름5', 350000, 0,
        '상품결함', 2),
         (6, TIMESTAMPADD(WEEK , -7, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '상품설명6', '상품이름6', 400000, 0,
        '상품결함', 2),
         (7, TIMESTAMPADD(WEEK , -6, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '상품설명7', '상품이름7', 350000, 0,
        '상품결함', 2),
         (8, TIMESTAMPADD(WEEK , -5, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '상품설명8', '상품이름8', 380000, 0,
        '상품결함', 2),
         (9, TIMESTAMPADD(WEEK , -4, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '상품설명9', '상품이름9', 278500, 0,
        '상품결함', 2),
         (10, TIMESTAMPADD(WEEK , -3, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '상품설명10', '상품이름10', 500000, 0,
        '상품결함', 2),
         (11, TIMESTAMPADD(WEEK , -2, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '상품설명11', '상품이름11', 480000, 0,
        '상품결함', 2),
         (12, TIMESTAMPADD(WEEK , -1, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), '상품설명12', '상품이름12', 380000, 0,
        '상품결함', 2);

-- Insert materials into MATERIAL_TB
INSERT INTO MATERIAL_TB
VALUES (1, TIMESTAMPADD(WEEK , -12, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 'REFRIGERATOR', '010-2293-5028',
        2, 1),
       (2, TIMESTAMPADD(WEEK , -11, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 'REFRIGERATOR', '010-1212-1212',
        2, 2),
       (3, TIMESTAMPADD(WEEK , -10, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 'REFRIGERATOR', '010-2293-5028',
        2, 3),
         (4, TIMESTAMPADD(WEEK , -9, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 'REFRIGERATOR', '010-2293-5028',
        2, 4),
         (5, TIMESTAMPADD(WEEK , -8, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 'REFRIGERATOR', '010-2293-5028',
        2, 5),
         (6, TIMESTAMPADD(WEEK , -7, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 'REFRIGERATOR', '010-2293-5028',
        2, 6),
         (7, TIMESTAMPADD(WEEK , -6, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 'REFRIGERATOR', '010-2293-5028',
        2, 7),
         (8, TIMESTAMPADD(WEEK , -5, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 'REFRIGERATOR', '010-2293-5028',
        2, 8),
         (9, TIMESTAMPADD(WEEK , -4, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 'REFRIGERATOR', '010-2293-5028',
        2, 9),
         (10, TIMESTAMPADD(WEEK , -3, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 'REFRIGERATOR', '010-2293-5028',
        2, 10),
         (11, TIMESTAMPADD(WEEK , -2, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 'REFRIGERATOR', '010-2293-5028',
        2, 11),
         (12, TIMESTAMPADD(WEEK , -1, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 'REFRIGERATOR', '010-2293-5028'
        , 2, 12);


-- Insert images into IMAGE_TB
INSERT INTO IMAGE_TB
VALUES (1, TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP),'냉장고1.png', 1),
       (2, TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP),'냉장고2.png', 2),
       (3, TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP),'냉장고3.png', 3),
       (4, TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP),'냉장고4.png', 4),
       (5, TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP),'냉장고5.png', 5),
       (6, TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP),'냉장고6.png', 6),
       (7, TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP),'냉장고7.png', 7),
       (8, TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP),'냉장고8.png', 8),
       (9, TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP),'냉장고9.png', 9),
       (10, TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP),'냉장고10.png', 10),
       (11, TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP),'냉장고11.png', 11),
       (12, TIMESTAMPADD(MINUTE, -30, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP),'냉장고12.png', 12),

-- Insert trades into TRADE_TB
INSERT INTO TRADE_TB
VALUES (1, TIMESTAMPADD(WEEK , -12, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 0, 20, 'REFRIGERATOR', 1, 2),
       (2, TIMESTAMPADD(WEEK , -11, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 0, 20, 'REFRIGERATOR', 2, 2),
         (3, TIMESTAMPADD(WEEK , -10, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 0, 20, 'REFRIGERATOR', 3, 2),
         (4, TIMESTAMPADD(WEEK , -9, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 0, 20, 'REFRIGERATOR', 4, 2),
         (5, TIMESTAMPADD(WEEK , -8, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 0, 20, 'REFRIGERATOR', 5, 2),
         (6, TIMESTAMPADD(WEEK , -7, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 0, 20, 'REFRIGERATOR', 6, 2),
         (7, TIMESTAMPADD(WEEK , -6, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 0, 20, 'REFRIGERATOR', 7, 2),
         (8, TIMESTAMPADD(WEEK , -5, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 0, 20, 'REFRIGERATOR', 8, 2),
         (9, TIMESTAMPADD(WEEK , -4, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 0, 20, 'REFRIGERATOR', 9, 2),
         (10, TIMESTAMPADD(WEEK , -3, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 0, 20, 'REFRIGERATOR', 10, 2),
         (11, TIMESTAMPADD(WEEK , -2, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 0, 20, 'REFRIGERATOR', 11, 2),
         (12, TIMESTAMPADD(WEEK , -1, CURRENT_TIMESTAMP), TIMESTAMPADD(MINUTE, 30, CURRENT_TIMESTAMP), 0, 20, 'REFRIGERATOR', 12, 2);


-- Insert actions into ACTION_TB

-- Insert auctions into AUCTION_TB
INSERT INTO AUCTION_TB
VALUES (1, TIMESTAMPADD(DAY, 7, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, -7, CURRENT_TIMESTAMP), 5, 10000, 500000, 0, 2, 1),
       (2, TIMESTAMPADD(DAY, 14, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, -14, CURRENT_TIMESTAMP), 10, 10000, 600000, 0, 2, 2),
       (3, TIMESTAMPADD(DAY, 21, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, -21, CURRENT_TIMESTAMP), 15, 10000, 700000, 0, 2, 3),
       (4, TIMESTAMPADD(DAY, 28, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, -28, CURRENT_TIMESTAMP), 20, 10000, 720000,0, 2, 4),
       (5, TIMESTAMPADD(DAY, 35, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, -35, CURRENT_TIMESTAMP), 25, 10000, 680000, 1,2, 5),
       (6, TIMESTAMPADD(DAY, 42, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, -42, CURRENT_TIMESTAMP), 30, 10000, 700000, 0, 2, 6)

