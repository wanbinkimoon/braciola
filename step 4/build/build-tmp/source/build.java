import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import hype.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class build extends PApplet {

int stageW      = 600;
int stageH      = 600;
int bgC       = 0xff202020;
String dataPATH = "../../data";

// ================================================================


HDrawable d;
HRotatable r;

float x;
float y;
// ================================================================

public void settings(){ 
	size(stageW, stageH);
}

// ================================================================

public void setup() {
	H.init(this).background(bgC);
	
	
	for (int i = 0; i < 100; ++i) {
		d = new HRect();
		x = random(width);
		y = random(height);
		d
			.size((int)random(25,125))
			.loc(x,y)
			.anchorAt(H.CENTER)
			.noFill()
			.stroke(0xffFF7700);

		HRotate r = new HRotate();
		r.target(d).speedRad( TWO_PI/90 );

		H.add(d);
	}

}

// ================================================================
public void draw() {
	background(bgC);


	H.drawStage();
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
