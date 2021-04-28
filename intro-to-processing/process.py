from PIL import Image
i = Image.open("face2.png")

f = open("rgb.txt", "w+")

pixels = i.load()
width, height = i.size

f.write('{')

for x in range(width):
  f.write('{')

  for y in range(height):
    cpixel = pixels[x, y]

    f.write('{')
    f.write(str(cpixel[0]) + ', ')
    f.write(str(cpixel[1]) + ', ')
    f.write(str(cpixel[2]))

    if y == height - 1:
      f.write('}')
    else:
      f.write('}, ')
  
  if x == width - 1:
    f.write('}')
    f.write('};\n')
  else:
    f.write('},\n')

print(width)
print(height)