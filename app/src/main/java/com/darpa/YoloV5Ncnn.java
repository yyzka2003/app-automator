//DARPA – an end-to-end and generic CV-based solution to
//identify AUIs at run-time and mitigate the risks
//by highlighting the AUIs with run-time UI decoration.
//Copyright (c) [2022] [DARPA-4-AUI]. All rights reserved.

package com.darpa;

import android.content.res.AssetManager;
import android.graphics.Bitmap;

class ObjGod {
    public float x;
    public float y;
    public float w;
    public float h;
    public String label;
    public float prob;

    public ObjGod() {
    }

    public ObjGod(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Obj{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}
