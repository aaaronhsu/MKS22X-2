public class Projectile {
  float x, y, dx, dy;
  
  int despawnTime;
  
  Projectile(float x, float y, int bulletSpeed, int despawnTime) {
    float xDist = mouseX - x;
    float yDist = mouseY - y;
    
    float angle = atan2(yDist, xDist);
    
    this.x = x;
    this.y = y;
    
    this.dx = bulletSpeed * cos(angle);
    this.dy = bulletSpeed * sin(angle);
    
    this.despawnTime = despawnTime;
  }
  
  Projectile(float x, float y, int angle) {
    this.x = x;
    this.y = y;
    
    this.dx = 5 * cos(radians(angle));
    this.dy = 5 * sin(radians(angle));
    
    this.despawnTime = 15;
  }
  
  public void draw() {
    
    if (despawnTime == 0) return;
    if (despawnTime != -1) despawnTime--;
    ellipse(x, y, 10, 10);
    
    x += dx;
    y += dy;
  }
}
