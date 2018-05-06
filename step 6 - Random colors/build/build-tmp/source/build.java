import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import hype.*; 
import hype.extended.behavior.HOscillator; 
import hype.extended.colorist.HColorPool; 
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




// import hype.extended.layout.HGridLayout;


PeasyCam cam;
HDrawable3D d;
HDrawablePool pool;

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
	pool = new HDrawablePool(rects);

		d = new HBox();
		int fgC = color(255, 119, 0, 20);

	new HOscillator()
		.target(d)
		.property(H.Z)
		.relativeVal(0)
		.range(-100, 100)
		.speed(random(0, .5f))
		.freq(5);
	
	pool.autoAddToStage()
		.add(	new HBox()
			.size((int)random(25,125))
			.loc(random(-width/2, width/2),
					random(-height/2, height/2),
					random(-100, 100))
			.anchorAt(H.CENTER)
			.fill(fgC)
			.stroke(0xffFF7700))
		.colorist(new HColorPool(0xffFFFFFF, 0xffF7F7F7, 0xffECECEC, 0xff333333, 0xff0095A8, 0xff00616F, 0xffFF3300, 0xffFF6600).fillOnly())
		.requestAll();

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
