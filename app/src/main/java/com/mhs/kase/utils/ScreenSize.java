package com.mhs.kase.utils;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;

public class ScreenSize {
    private Activity ctx;

    public ScreenSize(Activity ini) {
        ctx = ini;
    }

    public int getWidth() {
        Display display = ctx.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    public int getHeight() {
        Display display = ctx.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }
}
