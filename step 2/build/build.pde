int stageW      = 600;
int stageH      = 600;
color bgC       = #FF7700;
String dataPATH = "../../data";

// ================================================================

import hype.*;
HDrawable d1;
// ================================================================

void settings(){ 
	size(stageW, stageH);
}

// ================================================================

void setup() {
	H.init(this).background(bgC);

	d1 = new HRect(6).size(50).loc(100,100).anchorAt(H.CENTER).noStroke().fill(#FF0044);
	H.add(d1);
	
}

// ================================================================
void draw() {
	H.drawStage();
}
