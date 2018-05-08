int stageW      = 600;
int stageH      = 600;
color bgC       = #2e2e2e;
String dataPATH = "../../data";

// ================================================================

import hype.*;
import hype.extended.behavior.*;
import hype.extended.colorist.*;
import hype.extended.layout.*;
import hype.interfaces.*;

import peasy.*;
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

void settings(){ 
	size(stageW, stageH, P3D);
}

// ================================================================

void setup() {
	colors = new HColorPool(#FFFFFF, #6699cc, #fff275, #ff8c42, #ff3c38, #a23e48);

	H.init(this).background(bgC).use3D(true);
	smooth();

	int rects = 10;

	for (int i = 1; i < rects; ++i) {
		for (int j = 1; j < rects; ++j) {
			d = new HBox();
			_r = 25.0;
			area = 200;
			bounce = 20;

			x = map(i * _r, 0, rects * _r, -area, area) ;
			y = map(j * _r, 0, rects * _r, -area, area);
			z = 0;
			
			alpha = 255;
			color fgC = color(colors.getColor(), alpha);

			d
				.size(_r)
				.loc(x,y,z)
				.anchorAt(H.CENTER)
				.fill(fgC)
				.noStroke();

			// r = new HRotate();
			// r
			// 	.target(d)
			// 	.speedY( random(-2, 2) );


		new HOscillator()
			.target(d)
			.property(H.Z)
			.relativeVal(0)
			.range(-bounce, bounce)
			.speed(random(.5, 1))
			.freq(5);

			H.add(d);
		}
	}

cam = new PeasyCam(this, 600);
}

// ================================================================
void draw() {
	lights();	
	H.drawStage();
}
