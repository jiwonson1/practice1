-- ������� ��û�� ���� ������ sql���� --

-- * ȸ������
-- 1. �α��� ��û�� ������ SQL�� (���࿡ ��ġ�ϴ� ȸ�� ��ȸ�ȴٸ� ������ ���ุ ��ȸ�ɰ�!)

SELECT *
FROM MEMBER
WHERE USER_ID = ?
    AND USER_PWD = ?
    AND STATUS = 'Y';

SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ? AND STATUS = 'Y';    
    