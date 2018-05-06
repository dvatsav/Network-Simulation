"""
3
4 3 0:15 1:30
3 5 1:40 2:30
5 1 2:40 3:55
"""

"""
"""

def convert_time(time):
    comps = time.split(":");
    return int(comps[0]) * 60 + int(components[1])

def convert_back(time):
	hour = time / 60
	minute = time % 60
	return str(hour) + ":" + str(minute)




num_stations = 3
source = [4, 3, 5]
dest = [3, 5, 1]
wait = [0, 10, 10]
duration = [75, 50, 75]

f1 = open('temp.txt', 'w')
for i in range(0, 60):
	L = []
	with open("testcase2.txt", 'r') as f:
		L = f.readlines()
	for line in range(len(L)):
		L[line] = L[line].strip("\r\n")
	L.append(num_stations)
	cur_sum = 0
	for j in range(num_stations):
	
		start = i + wait[j] + cur_sum
		end = start + duration[j]
		cur_sum = end
		L.append(str(source[j]) + " " + str(dest[j]) + " " + convert_back(start) + " " + convert_back(end))
	for j in range(5):
		for i in L:
			f1.write(str(i) + "\n")
f1.close()