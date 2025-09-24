import time
start = time.time()
outputs = list(range(1,21 ))
removeList = []

for i in outputs:
    if i % 3 == 0:
        removeList.append( i -1)
for i in removeList:
    outputs.remove(i +1 )
    outputs.insert(i, "*")
end = time.time()
print(end - start)