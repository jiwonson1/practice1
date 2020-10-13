-- 사용자의 요청에 따른 실행할 sql문들 --

-- * 회원서비스
-- 1. 로그인 요청시 실행할 SQL문 (만약에 일치하는 회원 조회된다면 오로지 한행만 조회될것!)

SELECT *
FROM MEMBER
WHERE USER_ID = ?
    AND USER_PWD = ?
    AND STATUS = 'Y';

SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ? AND STATUS = 'Y';    
    