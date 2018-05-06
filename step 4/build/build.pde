int stageW      = 600;
int stageH      = 600;
color bgC       = #202020;
String dataPATH = "../../data";

// ================================================================

import hype.*;
HDrawable d;

float x;
float y;
// ================================================================

void settings(){ 
	size(stageW, stageH);
}

// ================================================================

void setup() {
	H.init(this).background(bgC);
	smooth();

	for (int i = 0; i < 100; ++i) {
		d = new HRect();
		x = random(width);
		y = random(height);
		d
			.size((int)random(25,125))
			.loc(x,y)
			.anchorAt(H.CENTER)
			.noFill()
			.stroke(#FF7700);

		HRotate r = new HRotate();
		r.target(d).speedRad( TWO_PI/90 );

		H.add(d);
	}

}

// ================================================================
void draw() {
	background(bgC);


	H.drawStage();
}
