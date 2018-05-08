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
	renderCanvasHD_w = stageW*renderCanvasHD_s;
	renderCanvasHD_h = stageH*renderCanvasHD_s;

	size(stageW,stageH,P3D);
}

// ================================================================

public void setup() {
	renderCanvasHD = createGraphics(renderCanvasHD_w,renderCanvasHD_h,P3D);
	renderCanvas   = createGraphics(stageW,stageH,P3D);

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

				x = map(i * _r, 0, rects * _r, -area, area);
				y = map(j * _r, 0, rects * _r, -area, area);
				z = map(k * _r, 0, rects * _r, -area, area);
				
				alpha = 255;
				int fgC = color(colors.getColor(), alpha);

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
public void draw() {
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
		_s           = 1.0f;
	}

	_whichCanvas.beginDraw();
	_whichCanvas.clear();

		_whichCanvas.pushMatrix();
			_whichCanvas.translate(0, 0, 0);
			_whichCanvas.scale(_s);
			_whichCanvas.lights();	
			_whichCanvas.H.drawStage();

			_whichCanvas.popMatrix();

	_whichCanvas.endDraw();
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
