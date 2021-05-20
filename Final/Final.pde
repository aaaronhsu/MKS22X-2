
Player p;

void setup() {
  ellipseMode(CENTER);
  size(1000, 800);
  p = new Player(50, 50);
}

void draw() {
  background(0);
  p.draw();
}

void mousePressed() {
  if (mouseButton == LEFT) {
    p.shootProjectile();
  }
}

void keyPressed() {
  println(keyCode);
  if (keyCode == 87) p.movement[0] = true;
  else if (keyCode == 82) p.movement[1] = true;
  else if (keyCode == 65) p.movement[2] = true;
  else if (keyCode == 83) p.movement[3] = true;
  
  if (keyCode == 32) p.roll();
}

void keyReleased() {
  if (keyCode == 87) p.movement[0] = false;
  else if (keyCode == 82) p.movement[1] = false;
  else if (keyCode == 65) p.movement[2] = false;
  else if (keyCode == 83) p.movement[3] = false;
}

void mouseWheel(MouseEvent event) {
  if (event.getCount() > 0) {
    if (p.bulletSpeed == 3) return;
    p.bulletSpeed--;
  }
  else {
    if (p.bulletSpeed == 15) return;
    p.bulletSpeed++;
  }
}
