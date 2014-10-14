import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] snow;
public void setup()
{
  size(500,500);
  background(0);
  snow = new SnowFlake[100];
  for(int i = 0; i < snow.length;i++)
  {
  snow[i] = new SnowFlake();
  }
}
public void draw()
{
 for (int i = 0; i < snow.length; i++) 
  {
   snow[i].erase();
   snow[i].lookDown();

  snow[i].move();
   snow[i].wrap();
   snow[i].show();
   
  }
}
public void mouseDragged()
{
   if(mouseButton == LEFT)
  {  
    noStroke();
    fill(255,5,5);
    ellipse(mouseX,mouseY, 20, 20);
  }

   if(mouseButton == RIGHT)
  {  
    noStroke();
    fill(0);
    ellipse(mouseX,mouseY, 20, 20);
  }
  
    
}

 class SnowFlake
{
 int x,y, size;
 boolean isMoving; 
  SnowFlake()
  {
    x = (int)(Math.random()*501);
    y = (int)(Math.random()*501);
    isMoving = true;
    size = 7;//class member variable initializations
  }
  public void show()
  {
    fill(255);
    ellipse(x, y, size, size); 
  }
  public void lookDown()
  {
    if(x>= 2 && x< 498 && y >= 0 && y < 490 && (get(x-2,y+5)!=color(0,0,0) || get(x+2,y+5)!=color(0,0,0)))
    {
      isMoving = false;
    }
    else
    {
      isMoving = true;
    }
  }
  public void erase()
  {
    fill(0);
    ellipse(x, y, size+2, size+2);
    
  }
  public void move()
  {
    if(isMoving == true)
    {
    y++;
    }
  }
    
  public void wrap()
  {
    if(y > 500)
    {
    y = 0;
    x = (int)(Math.random()*500);
    }
  }
}



  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
