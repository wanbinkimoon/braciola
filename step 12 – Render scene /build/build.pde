int stageW      = 600;
int stageH      = 600;
color bgC       = #2e2e2e;
String dataPATH = "../../data";

// ================================================================


boolean   letsRender       = false;
boolean   letsRenderHD     = true;

int       renderNum        = 0;
int       renderMax        = 5;
int       renderModulo     = 20;

PGraphics renderCanvas;

PGraphics renderCanvasHD;
int       renderCanvasHD_w;
int       renderCanvasHD_h;
int       renderCanvasHD_s = 6; // s=scale / scale factor based on stageW + stageH - so a 1920 x 1080 stage is a 11520 x 6480 image, 72DPI yes, but 160x90 inches or 13x7.5 feet, lol

String    renderPATH       = "../render/";

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
	renderCanvasHD_w = stageW*renderCanvasHD_s;
	renderCanvasHD_h = stageH*renderCanvasHD_s;

	size(stageW,stageH,P3D);
}

// ================================================================

void setup() {
	renderCanvasHD = createGraphics(renderCanvasHD_w,renderCanvasHD_h,P3D);
	renderCanvas   = createGraphics(stageW,stageH,P3D);

	colors = new HColorPool(#FFFFFF, #6699cc, #fff275, #ff8c42, #ff3c38, #a23e48);


	H.init(this).background(bgC).use3D(true);
	smooth();

	int rects = 10;

	for (int i = 1; i < rects; ++i) {
		for (int j = 1; j < rects; ++j) {
			for (int k = 0; k < rects; ++k) {
				
				d = new HBox();

				_r = 25.0;
				area = 200;
				bounce = 20;

				x = map(i * _r, 0, rects * _r, -area, area);
				y = map(j * _r, 0, rects * _r, -area, area);
				z = map(k * _r, 0, rects * _r, -area, area);
				
				alpha = 255;
				color fgC = color(colors.getColor(), alpha);

				d
					.size(_r)
					.loc(x,y,z)
					.anchorAt(H.CENTER)
					.fill(fgC)
					.noStroke()
					.rotateX(45)
					.rotateZ(45);

				r = new HRotate();
				r
					.target(d)
					.speedZ(1);

				H.add(d);
				
			}
		}
	}

cam = new PeasyCam(this, 600);
}

// ================================================================
void draw() {
		PGraphics _whichCanvas;
	int       _w; // width
	int       _h; // height
	float     _s; // scale

	if (letsRenderHD) {
		_whichCanvas = renderCanvasHD;
		_w           = renderCanvasHD_w;
		_h           = renderCanvasHD_h;
		_s           = renderCanvasHD_s;
	} else {
		_whichCanvas = renderCanvas;
		_w           = stageW;
		_h           = stageH;
		_s           = 1.0;
	}

				H.drawStage();
}
