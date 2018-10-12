import heapq
import math
graph = {'A': {'B':5, 'C':1},   #图用字典表示
         'B': {'A':5, 'C':2, 'D':1}, 
         'C': {'A':1, 'B':2, 'D':4, 'E':8}, 
         'D': {'B':1, 'C':4, 'E':3, 'F':6}, 
         'E':{'C':8, 'D':3}, 
         'F':{'D':6}}

def init_distance(graph, s):
	distance = {s:0}
	for i in graph.keys():
		if i is not s:
			distance[i] = math.inf
	return distance 

def short_path(graph, s):
	pqueue = []
	heapq.heappush(pqueue, (0, s))
	parent = {s:None}
	distance = init_distance(graph, s)
	seen = []
	while pqueue:
		dist, vertex = heapq.heappop(pqueue)
		seen.append(vertex)
		for w in graph[vertex].keys():
			if w not in seen:
				if dist + graph[vertex][w] < distance[w]:
					distance[w] = dist + graph[vertex][w]
					heapq.heappush(pqueue, (dist+graph[vertex][w], w))
					parent[w] = vertex
	return parent, distance
parent, distance = short_path(graph, 'A')
