package com.qualcomm.ftcrobotcontroller;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

/**
 * Created by adam on 1/7/16.
 */
public class ImgProc {

public static boolean isLeft(String path) {
	Bitmap b = BitmapFactory.decodeFile(path);

	int width = b.getWidth();
	int height = b.getHeight();
	int arrayloc = 0;
	int readvalues[]= new int[100];
	int sumleft = 0;
	int sumright = 0;
//Take samples from a 4 by 4 grid, 16 in total

	for (int x = 0; x < 4; x++){
		int xcord = (width/8)*((2*x)+1);

		for (int y = 0; y < 4; y++){

			int ycord = (height/8)*((2*x)+1);
			readvalues[arrayloc] = Color.blue(b.getPixel(xcord, ycord));
			arrayloc++;
		}
	}
	for (int i = 0; i  <=7; i++){
		sumleft += readvalues[i];
	}
	for (int i = 8; i <=15; i++) {
		sumright += readvalues[i];
	}
	double avgright = sumright/8;
	double avgleft = sumleft/8;
	if (avgleft > avgright){
		return true;
	}else {
		return false;
	}
}



public static boolean isRight (String path) {
	Bitmap b = BitmapFactory.decodeFile(path);

	int width = b.getWidth();
	int height = b.getHeight();
	int arrayloc = 0;
	int readvalues[];
	readvalues = new int[100];
	int sumleft = 0;
	int sumright = 0;



//Take samples from a 4 by 4 grid, 16 in total

	for (int x = 0; x < 4; x++){
		int xcord = (width/8)*((2*x)+1);

		for (int y = 0; y < 4; y++){

			int ycord = (height/8)*((2*x)+1);
			readvalues[arrayloc] = Color.blue(b.getPixel(xcord, ycord));
			arrayloc++;
		}
	}
	for (int i = 0; i  <=7; i++){
		sumleft += readvalues[i];
	}
	for (int i = 8; i <=15; i++) {
		sumright += readvalues[i];
	}
	double avgright = sumright/8;
	double avgleft = sumleft/8;
	if (avgleft < avgright){
		return true;
	}else {
		return false;
	}
}

}


