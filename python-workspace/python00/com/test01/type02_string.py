
# string: 문자열 (', "의 차이 없음)

# single * 1
# python's Hello,World!
a = 'python\'s Hello, World!'
print(a)
print(type(a))

# single * 3
b = '''python's 
Hello,   "world"!
      Bye, Python!!'''
print(b)
# 한개랑 3개의 차이점 (3개 같은 경우 안에 개행이나 따옴표 자유롭게 작성 가능)

# double * 1
c = "abc"
print(c)
print(type(c))

d = """
abc
def   "ghi" ' e' """
print(d)

# 문자열 덧셈, 곱셈
str1 = "Hello, "
str2 = "World!"
print(str1 + str2)
print(str1 * 2 + str2)