package com.nikhil.funmirror;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.FaceDetector;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class FaceDetectionArray extends Activity {
	private Bitmap face1, face2, face3, face4, face5, face6, face7, face8,
			face9, face10, face11;
	private TextView face1count, face2count, face3count, face4count,
			face5count, face6count, face7count, face8count, face9count,
			face10count, face11count;
	private ArrayList<TextView> textViews;
	private int imageWidth = 50, imageHeight = 50;
	private int numberOfFace = 10;
	private FaceDetector myFaceDetect;
	private FaceDetector.Face[] myFace;
	float myEyesDistance;
	int numberOfFaceDetected;

	ArrayList<Bitmap> myBitmap;
	private final String TAG = "FaceDector";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_face_detection_array);

		BitmapFactory.Options BitmapFactoryOptionsbfo = new BitmapFactory.Options();
		BitmapFactoryOptionsbfo.inPreferredConfig = Bitmap.Config.RGB_565;

		Log.i(TAG, " face decection start ");
		textViews = new ArrayList<TextView>();
		myBitmap = new ArrayList<Bitmap>();
		// face1 = (ImageView) findViewById(R.id.face1);
		face1count = (TextView) findViewById(R.id.face1Count);
		face2count = (TextView) findViewById(R.id.face2Count);
		face3count = (TextView) findViewById(R.id.face3Count);
		face4count = (TextView) findViewById(R.id.face4Count);
		face5count = (TextView) findViewById(R.id.face5Count);
		face6count = (TextView) findViewById(R.id.face6Count);
		face7count = (TextView) findViewById(R.id.face7Count);
		face8count = (TextView) findViewById(R.id.face8Count);
		face9count = (TextView) findViewById(R.id.face9Count);
		face10count = (TextView) findViewById(R.id.face10Count);
		face11count = (TextView) findViewById(R.id.face11Count);

		textViews.add(face1count);
		textViews.add(face2count);
		textViews.add(face3count);
		textViews.add(face4count);
		textViews.add(face5count);
		textViews.add(face6count);
		textViews.add(face7count);
		textViews.add(face8count);
		textViews.add(face9count);
		textViews.add(face10count);
		textViews.add(face11count);

		face1 = BitmapFactory.decodeResource(getResources(), R.drawable.face1,
				BitmapFactoryOptionsbfo);
		face2 = BitmapFactory.decodeResource(getResources(), R.drawable.face2,
				BitmapFactoryOptionsbfo);
		face3 = BitmapFactory.decodeResource(getResources(), R.drawable.face3,
				BitmapFactoryOptionsbfo);
		face4 = BitmapFactory.decodeResource(getResources(), R.drawable.face4,
				BitmapFactoryOptionsbfo);
		face5 = BitmapFactory.decodeResource(getResources(), R.drawable.face5,
				BitmapFactoryOptionsbfo);
		face6 = BitmapFactory.decodeResource(getResources(), R.drawable.face6,
				BitmapFactoryOptionsbfo);
		face7 = BitmapFactory.decodeResource(getResources(), R.drawable.face7,
				BitmapFactoryOptionsbfo);
		face8 = BitmapFactory.decodeResource(getResources(), R.drawable.face8,
				BitmapFactoryOptionsbfo);
		face9 = BitmapFactory.decodeResource(getResources(), R.drawable.face9,
				BitmapFactoryOptionsbfo);
		face10 = BitmapFactory.decodeResource(getResources(),
				R.drawable.face10, BitmapFactoryOptionsbfo);
		face11 = BitmapFactory.decodeResource(getResources(),
				R.drawable.face11, BitmapFactoryOptionsbfo);
		myBitmap.add(face1);
		myBitmap.add(face2);
		myBitmap.add(face3);
		myBitmap.add(face4);
		myBitmap.add(face5);
		myBitmap.add(face6);
		myBitmap.add(face7);
		myBitmap.add(face8);
		myBitmap.add(face9);
		myBitmap.add(face10);
		myBitmap.add(face11);

		myFace = new FaceDetector.Face[numberOfFace];
		int i = 0;
		for (TextView textView : textViews) {

			myFaceDetect = new FaceDetector(myBitmap.get(i).getWidth(),
					myBitmap.get(i).getHeight(), numberOfFace);
			Log.v("Sample", "face decteced ; " + myFaceDetect);
			numberOfFaceDetected = myFaceDetect.findFaces(myBitmap.get(i),
					myFace);
			Log.i(TAG, " face : " + numberOfFaceDetected);
			textView.setText("Number of faces : " + numberOfFaceDetected);
			i++;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.face_detection_array, menu);
		return true;
	}

}
