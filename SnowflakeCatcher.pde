SnowFlake [] snow;
void setup()
{
  size(500,500);
  background(0);
  snow = new SnowFlake[100];
  for(int i = 0; i < snow.length;i++)
  {
  snow[i] = new SnowFlake();
  }
}
void draw()
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
void mouseDragged()
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
  void show()
  {
    fill(255);
    ellipse(x, y, size, size); 
  }
  void lookDown()
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
  void erase()
  {
    fill(0);
    ellipse(x, y, size+2, size+2);
    
  }
  void move()
  {
    if(isMoving == true)
    {
    y++;
    }
  }
    
  void wrap()
  {
    if(y > 500)
    {
    y = 0;
    x = (int)(Math.random()*500);
    }
  }
}



