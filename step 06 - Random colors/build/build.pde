int stageW      = 600;
int stageH      = 600;
color bgC       = #202020;
String dataPATH = "../../data";

// ================================================================

import hype.*;
import hype.extended.behavior.HOscillator;
import hype.extended.colorist.HColorPool;
// import hype.extended.layout.HGridLayout;

import peasy.*;
PeasyCam cam;
HDrawable3D d;
HColorPool colors;

float x;
float y;
float z;
int alpha;
// ================================================================

void settings(){ 
	size(stageW, stageH, P3D);
}

// ================================================================

void setup() {
	H.init(this).background(bgC).use3D(true);
	smooth();
	colors = new HColorPool(#FFFFFF, #F7F7F7, #ECECEC, #333333, #0095A8, #00616F, #FF3300, #FF6600);

	int rects = 25;
	for (int i = 0; i < rects; ++i) {
		d = new HBox();
		x = random(-width/2, width/2);
		y = random(-height/2, height/2);
		z = random(-100, 100);
		alpha = 50;
		color fgC = color(colors.getColor(), alpha);

		d
			.size((int)random(25,125))
			.loc(x,y,z)
			.anchorAt(H.CENTER)
			.fill(fgC)
			.noStroke();



	new HOscillator()
		.target(d)
		.property(H.Z)
		.relativeVal(0)
		.range(-100, 100)
		.speed(random(0, .5))
		.freq(5);

		H.add(d);

	}

cam = new PeasyCam(this, 600);
}

// ================================================================
void draw() {
	lights();	
	H.drawStage();
}
