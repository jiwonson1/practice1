
# tuple : 배열 (불변)
# list와 tuple의 차이점으로는 값을 변경하는게 불가

# 생성자 사용
a = tuple()
print(a)
print(type(a))

b = tuple([1, 2, '3'])
print(b)

# ()
c = (1, 2, 3, 4)
print(c)
print(type(c))

# 값 변경(추가, 수정, 삭제)
#c.append(5)
#print(c)
#c[1] = 100
#print(c)

d = tuple([3, 4, 5, 6, 7, 8, 9])
print(d)

# range함수 => 반복문에서도 많이 쓰일 예정
d = tuple(range(3, 6)) # 3<=  <6
print(d)

# tuple + tuple
print(b + d)

# tuple과 list간의 형변환
e = list(d)
print(e)
e.append('6')
print(e)

d = tuple(e)
print(d) # 3, 4, 5, '6'

# unpacking
# d의 각 인덱스에 있던 애들이 각각 f,g,h,i 변수에 담김
f, g, h, i = d
print(f)
print(g)
print(h)
print(i)

#x, y = 10, 20








