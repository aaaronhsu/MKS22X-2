
void setup() {
  PImage img;
  size(1600, 1000);
  
  img = loadImage("redcar.jpg");

  //for (int x =0; x < img.width; x ++) {
  //  for (int y =0; y < img.height; y ++) {
  //    if ( y > img.height/2){
  //     img.set(x,y,color(200)); 
  //    }
  //  }
  //}
  
  //image(img, 0, 0);
  
  float[][] kernel = { {0, -1, 0}, 
                       {-1, 15, -1}, 
                       {0, -1, 0}};
  
  Kernel k = new Kernel(kernel);
  
  PImage img2 = loadImage("redcar.jpg");
  
  k.apply(img, img2);
}
