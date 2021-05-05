public class Cow {
  float x, y, dx, dy, radius;
  color c;
  
  boolean selected = false;
  boolean colliding = false;

  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  Cow(float x, float y) {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
    
    this.x = x;
    this.y = y;
  }
  
  void move() {
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  
  void display() {
    
    stroke(0);
    fill(c);
    ellipse(x, y, radius*2, radius*2);
    
    if (this.selected) {
      fill(255);
      ellipse(x - radius / 2, y - 10, radius / 2, radius / 2);
      ellipse(x + radius / 2, y - 10, radius / 2, radius / 2);
      
      fill(0);
      ellipse(x - radius / 2, y - 10, radius / 8, radius / 8);
      ellipse(x + radius / 2, y - 10, radius / 8, radius / 8);
      
      fill(255);
      arc(this.x, this.y + radius / 4, radius / 2, radius / 2, 0, PI);
      
      fill(0);
      text("dx: " + dx, x + radius + 5, y - radius / 2);
      text("dy: " + dy, x + radius + 5, y - radius / 2 + 20);
    }
    
  }

  void select(){
   //if the mouseX and mouseY are touching this cow, change the cow somehow.
    this.selected = !this.selected;
  }
  
  void colliding(ArrayList<Cow> others) {
    for (Cow i : others) {
      if (i == this) continue;
      
      this.colliding = dist(i.x, i.y, x, y) <= radius + i.radius;
    }
  }

}
