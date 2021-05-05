f = open("10k.txt")

data = f.readlines()

for i in range(len(data) - 1):
  data[i] = data[i][:-1]

# for i in range(len(data)):
#   data[i] = "\"Anonymous " + data[i] + "\""

# animals = []

# for i in data:
#   if (i.count(" ") == 0):
#     print(i)
#     animals += ["\"Anonymous " + i + "\""]

words = []

for i in data:
  containsVowel = False
  if len(i) >= 3:
    for letter in i:
      if letter in ['a', 'e', 'i', 'o', 'u', 'y']:
        containsVowel = True
    if containsVowel:
      words += ['wordList.add("' + i + '")']
f = open("out.txt", "w+")

for i in words:
  f.write(i + ";\n")