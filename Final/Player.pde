public class Player {
  float x, y;
  boolean[] movement = {false, false, false, false};
  int bulletSpeed = 8;
  
  
  ArrayList<Projectile> projectiles = new ArrayList();
  
  Player(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public void draw() {
    ellipse(x, y, 50, 50);
    
    move();
    
    drawProjectileLine(mouseX, mouseY, x, y);
    
    text("bullet speed: " + bulletSpeed, 100, 100);
    
    for (Projectile p : projectiles) {
      p.draw();
    }
  }
  
  
  public void move() {
    if (movement[0]) y -= 5;
    if (movement[1]) y += 5;
    if (movement[2]) x -= 5;
    if (movement[3]) x += 5;
  }
  
  public void drawProjectileLine(float x1, float y1, float x2, float y2) {
    
    float xDist = x1 - x2;
    float yDist = y1 - y2;
    
    float numCircles = dist(x1, y1, x2, y2) / 50;
    
    for (int i = 1; i < numCircles; i++) {
      ellipse(x2 + (xDist * i / numCircles), y2 + (yDist * i / numCircles), 8, 8);
    }
  }
  
  public void shootProjectile() {
    Projectile proj = new Projectile(x, y, bulletSpeed, -1);
    
    projectiles.add(proj);
  }
  
  public void forcefield() {
    for (int i = 0; i < 360; i += 10) {
      Projectile proj = new Projectile(x, y, i);
      projectiles.add(proj);
    }
  }
}
