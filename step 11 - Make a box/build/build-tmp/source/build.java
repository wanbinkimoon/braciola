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
int bgC       = 0xff2e2e2e;
String dataPATH = "../../data";

// ================================================================








PeasyCam cam;
HDrawable3D d;
HColorPool colors;
HRotate r;

float x;
float y;
float z;
float _r;

int alpha;
int area;
int bounce;
// ================================================================

public void settings(){ 
	size(stageW, stageH, P3D);
}

// ================================================================

public void setup() {
	colors = new HColorPool(0xffFFFFFF, 0xff6699cc, 0xfffff275, 0xffff8c42, 0xffff3c38, 0xffa23e48);

	H.init(this).background(bgC).use3D(true);
	

	int rects = 10;

	for (int i = 1; i < rects; ++i) {
		for (int j = 1; j < rects; ++j) {
			for (int k = 0; k < rects; ++k) {
				
				d = new HBox();

				_r = 25.0f;
				area = 200;
				bounce = 20;

				x = map(i * _r, 0, rects * _r, -area, area) ;
				y = map(j * _r, 0, rects * _r, -area, area);
				z = map(j * _r, 0, rects * _r, -area, area);
				
				alpha = 255;
				int fgC = color(colors.getColor(), alpha);

				d
					.size(_r)
					.loc(x,y,z)
					.anchorAt(H.CENTER)
					.fill(fgC)
					.noStroke();

				r = new HRotate();
				r
					.target(d)
					.speedY( random(-2, 2) );


			new HOscillator()
				.target(d)
				.property(H.Z)
				.relativeVal(z)
				.range(-bounce, bounce)
				.speed(random(.5f, 1))
				.freq(5);

				H.add(d);
				
			}
		}
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
