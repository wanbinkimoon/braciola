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
	

}

// ================================================================
void draw() {
	background(bgC);
	for (int i = 0; i < 100; ++i) {
		d = new HRect();
		x = random(width);
		y = random(height);
		float r = random(360);
		d
			.size((int)random(25,125))
			.loc(x,y)
			.anchorAt(H.CENTER)
			.rotate(r)
			.noFill()
			.stroke(#FF7700);
		H.add(d);
	}

	H.drawStage();
}
