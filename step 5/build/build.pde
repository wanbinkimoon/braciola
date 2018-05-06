int stageW      = 600;
int stageH      = 600;
color bgC       = #202020;
String dataPATH = "../../data";

// ================================================================

import hype.*;
import peasy.*;
PeasyCam cam;
HDrawable3D d;

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
	for (int i = 0; i < rects; ++i) {
		d = new HBox();
		x = random(-width/2, width/2);
		y = random(-height/2, height/2);
		z = random(-100, 100);
		
		color fgC = color(255, 119, 0, 20);

		d
			.size((int)random(25,125))
			.loc(x,y,z)
			.anchorAt(H.CENTER)
			.fill(fgC)
			.stroke(#FF7700);

		H.add(d);
	}

cam = new PeasyCam(this, 600);
}

// ================================================================
void draw() {
	lights();	
	H.drawStage();
}
