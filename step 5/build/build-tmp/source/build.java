import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import hype.*; 
import peasy.*; 

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



PeasyCam cam;
HDrawable3D d;

float x;
float y;
float z;
// ================================================================

public void settings(){ 
	size(stageW, stageH, P3D);
}

// ================================================================

public void setup() {
	H.init(this).background(bgC).use3D(true);
	

	int rects = 25;
	for (int i = 0; i < rects; ++i) {
		d = new HBox();
		x = random(-width/2, width/2);
		y = random(-height/2, height/2);
		z = random(-100, 100);
		int fgC = color(255, 119, 0, 20);

		d
			.size((int)random(25,125))
			.loc(x,y,z)
			.anchorAt(H.CENTER)
			.fill(fgC)
			.stroke(0xffFF7700);

		H.add(d);
	}

cam = new PeasyCam(this, 600);
}

// ================================================================
public void draw() {
	lights();	
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
