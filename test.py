f = open("hold.txt")

data = f.readlines()

for i in range(len(data) - 1):
  data[i] = data[i][:-1]

# for i in range(len(data)):
#   data[i] = "\"Anonymous " + data[i] + "\""

animals = []

for i in data:
  if (i.count(" ") == 0):
    print(i)
    animals += ["\"Anonymous " + i + "\""]

f = open("out.txt", "w+")

for i in animals:
  f.write(i + ", \n")