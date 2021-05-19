public class Kernel {
  float[][] kernel;
  
  public Kernel(float[][] init) {
    float[][] copy = new float[3][3];
    
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        copy[i][j] = init[i][j];
      }
    }
    
    kernel = copy;
  }
  
  color calcNewColor(PImage img, int x, int y) {
    int r = 0;
    int g = 0; 
    int b = 0;
    
    for (int i = x - 1; i <= x + 1; i++) {
      for (int j = y - 1; j <= y + 1; j++) {
        try {
          color c = img.get(i, j);
          
          r += red(c) * kernel[i - x + 1][j - y + 1];
          g += green(c) * kernel[i - x + 1][j - y + 1];
          b += blue(c) * kernel[i - x + 1][j - y + 1];          
        }
        catch (Exception e) {
          return color(0);
        }
      }
    }
    
    return color(r / 9, g / 9, b / 9);
    
  }
  
  void apply(PImage source, PImage destination) {
    int w = source.width;
    int h = source.height;
    
    for (int i = 0; i < w; i++) {  
      for (int j = 0; j < h; j++) {
        destination.set(i, j, calcNewColor(source, i, j));
      }
    }
    
    image(destination, 0, 0);
    
  }
}
