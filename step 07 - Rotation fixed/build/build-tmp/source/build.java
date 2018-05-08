import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import hype.*; 
import hype.extended.behavior.*; 
import hype.extended.colorist.*; 
import hype.extended.layout.*; 
import hype.interfaces.*; 
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
int bgC       = 0xff222222;
String dataPATH = "../../data";

// ================================================================








PeasyCam cam;
HDrawable3D d;
HColorPool colors;
HRotate r;

float x;
float y;
float z;
int alpha;
// ================================================================

public void settings(){ 
	size(stageW, stageH, P3D);
}

// ================================================================

public void setup() {
	H.init(this).background(bgC).use3D(true);
	
	colors = new HColorPool(0xffFFFFFF, 0xffF7F7F7, 0xffECECEC, 0xff333333, 0xff0095A8, 0xff00616F, 0xffFF3300, 0xffFF6600);

	int rects = 100;

	for (int i = 0; i < rects; ++i) {
		d = new HBox();
		x = random(-width/2, width/2);
		y = random(-height/2, height/2);
		z = random(-100, 100);
		alpha = 100;
		int fgC = color(colors.getColor(), alpha);

		d
			.size((int)random(25,50))
			.loc(x,y,z)
			.anchorAt(H.CENTER)
			.fill(fgC)
			.noStroke();

		r = new HRotate();
		r
			.target(d)
			.speedX( random(-2, 2) );


	new HOscillator()
		.target(d)
		.property(H.Z)
		.relativeVal(0)
		.range(-100, 100)
		.speed(random(0, .5f))
		.freq(5);

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
