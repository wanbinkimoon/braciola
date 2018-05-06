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
HDrawablePool pool;

float x;
float y;
float z;
// ================================================================

void settings(){ 
	size(stageW, stageH, P3D);
}

// ================================================================

void setup() {
	H.init(this).background(bgC).use3D(true);
	smooth();

	int rects = 25;
	pool = new HDrawablePool(rects);

		d = new HBox();
		color fgC = color(255, 119, 0, 20);

	new HOscillator()
		.target(d)
		.property(H.Z)
		.relativeVal(0)
		.range(-100, 100)
		.speed(random(0, .5))
		.freq(5);
	
	pool.autoAddToStage()
		.add(	new HBox()
			.size((int)random(25,125))
			.loc(random(-width/2, width/2),
					random(-height/2, height/2),
					random(-100, 100))
			.anchorAt(H.CENTER)
			.fill(fgC)
			.stroke(#FF7700))
		.colorist(new HColorPool(#FFFFFF, #F7F7F7, #ECECEC, #333333, #0095A8, #00616F, #FF3300, #FF6600).fillOnly())
		.requestAll();

cam = new PeasyCam(this, 600);
}

// ================================================================
void draw() {
	lights();	
	H.drawStage();
}
