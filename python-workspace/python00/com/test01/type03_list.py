# list : 배열
# == 자바 컬렉션의 List와 유사 (순서유지O, 중복저장가능)

# 생성자 사용
a = list()
print(a)
print(type(a))

a.append(1) # 0번인덱스에 1담음
print(a)

#a[1] = 2 # 존재하지 않은 index에 접근 불가
#print(a)
a[0] = 2 # 존재하는 index에는 값 변경식으로 대입 가능
print(a)

a.append('a')
print(a)
print(a[1])

# [] 사용
b = []
print(b)
print(type(b))

b = [1, 2, 3, 4, 5]
print(b)

print(b[0] + b[2])

# reverse
b.reverse()
print(b)
# sort
b.sort()
print(b)

# 중첩
c = ['a', 'b', 'c', 'd', ['e', 'f', 'g'], 'h']
print(c)
print(c[4])

print(c[4][1])

print(b + c)



