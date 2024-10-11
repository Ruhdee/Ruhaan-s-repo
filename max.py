import random
from typing import List
# random.seed(42)
v = 7
n = v
matrix = [ [0 for _ in range(n)] for _ in range(n)]
# print(matrix)
for i in range(n):
    for j in range(n):
        matrix[i][j] = random.randint(1,100)
for row in matrix:
    print(row)
print()
result = [[-1 for _ in range(n-2)] for _ in range(n-2)]
def get_local_max(matrix,n) -> List[List[int]]:
    result = []
    i,j= 2,2
    while i < n:
        sub = []
        while j < n:
            maximum = -1
            for k in range(i-2,i+1):
                maximum = max(max([matrix[k][l] for l in range(j-2,j+1)]),maximum)
            sub.append(maximum)
            j+=1
        print()
        result.append(sub)
        j=2
        i+=1
    return result
    
res = get_local_max(matrix,n)
for r in res:
    print(r)
            
    
    
        