```접근 아이디어
트리 구조에서 [A,B]에서 A가 B의 자손인 경우가 불가능한 경우다.
이런 구조에서 A->B로 움직이면 탐색과정에서 싸이클이 생긴다
주어진 순서를 주어진 입력에다가 추가해준 후에 그래프를 탐색하면
불가능한 경우에는 반드시 사이클이 존재할 수 밖에 없다.
bfs로 탐색하면 방향그래프처럼 탐색할 수 있다.
그 후 order에 있는 원소들을 추가해 준 다음
dfs로 탐색해서 싸이클을 찾아준다.
```
import sys
from collections import deque
sys.setrecursionlimit(10**9)

# 싸이클이 존재하는지 확인하기 위한 dfs
def dfs(node):
    visited[node] = 1
    check2[node] = 1
    for nextNode in dirGraph[node]:
        if not check2[nextNode]:
            if dfs(nextNode):
                return True
        if visited[nextNode]:
            return True
    visited[node] = 0
    return False
    
# 방향그래프로 만들어주기위한 bfs
def bfs():
    queue = deque([0])
    check[0] = 1
    dirGraph = [[] for _ in range(N+1)]
    while queue:
        node = queue.popleft()
        for n in graph[node]:
            if not check[n]:
                check[n] = 1
                dirGraph[node].append(n)
                queue.append(n)
    return dirGraph


def solution(n, path, order):
    global graph, dirGraph, check, check2, visited
    global N

    N = n
    
    graph = [[] for _ in range(N+1)]# 그래프 저장 배열
    check = [0 for _ in range(N+1)]# 그래프의 노드 방문 
    visited = [0 for _ in range(N+1)]# 방향그래프 탐색시 탐색 중인 경로에 속한 노드 저장
    check2 = [0 for _ in range(N+1)]# 방향그래프의 노드 방문여부 저장
    
    #그래프 입력 처리
    for roomA, roomB in path:
        graph[roomA].append(roomB)
        graph[roomB].append(roomA)
    #방향 그래프로 만들기위한 bfs     
    dirGraph = bfs()
    for roomA, roomB in order:
        dirGraph[roomA].append(roomB)
    
    #0번 노드는 시작하는 노드이므로 일단 방문했다고 표시
    check2[0] = 1
    visited[0] = 1
    #dfs 해서 걸리면 
    isCycle = dfs(startRoom)
    
    if(isCycle):
        return False
    else:
        return True
