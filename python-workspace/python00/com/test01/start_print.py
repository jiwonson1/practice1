# 한 줄 주석

'''
    여러줄 주석
'''

# print문으로 출력 (기본적으로 줄바꿈 발생)
print('Hello')
print('Python')

# * end='' => 기본값 \n
print('Hello', end=' ')
print('Python', end='! ')
print('hahaha')

# 여러개의 값 연이어서 출력하기
# I 클래스의 정원은 xx명 입니다.
count = 27
#print('I 클래스의 정원은 ' + count + '명 입니다.')
# 위와 같이 자바처럼 문자열과 다른 타입과의 + 연산으로 연이어서 출력 불가
print('I 클래스의 정원은', count, '명 입니다.')
# 출력하고자 하는 값들을 ,로 나열하면 연이어서 출력됨 (자료형 상관없이)
# 게다가 사이에 공백이 구분자로 들어감

# * sep=' ' => 기본값이 공백
print('I 클래스의 정원은', count, '명 입니다', sep='@', end='!')
print('ㅎㅎㅎㅎ')

# * 포맷적용
# x클래스 수료일은 xxxx년 xx월 xx일 입니다.
ban = 'I'
year = 2021
month = 1
date = 12

print(ban, '클래스 수료일은', year, '년', month, '월', date, '일 입니다.')

# 자바에서의 printf("포맷%s %d", 값, 값, 값, ...)와 유사한 기능
print('%s클래스 수료일은 %d년 %d월 %d일 입니다.'%(ban, year, month, date))
print('{0}클래스 수료일은 {1}년 {2}월 {3}일 입니다.'.format(ban, year, month, date))

# 변수에 값 대입
# 변수에 값 대입시 미리 자료형 지정해둘 필요없음!!
# 동적바인딩 언어 == 값이 뭐가 담기냐에 따라서 그 때 자료형 지정
a = 100
b = 200
print(a)
print(b)
print(a + b)

print('a')
print("b")
print('c' + 'd')
#print('e' + a)


