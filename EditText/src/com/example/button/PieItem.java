package com.example.button;

/**
 * Created by su on 2014/12/26.
 */
/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import android.graphics.Path;
import android.graphics.PointF;
import android.view.View;

/**
 * Pie menu item
 */
public class PieItem {

    private View mView;
    private int mLevel;
    private int mStart;
    private int mSweep;
    private int mInner;
    private int mOuter;
    private boolean mPressed;
    private Path mPath;
    private PointF mCenter = null;
    
    public PieItem(View view, int level) {
        mView = view;
        mLevel = level;
    }
    
    public void setPressed(boolean pressed) {
        mPressed = pressed;
        if (mView != null) {
            mView.setPressed(pressed);
        }
    }

    public boolean isPressed() {
        return mPressed;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setCenter(PointF center){
        mCenter = center;
    }

    public PointF getCenter(){
        return mCenter;
    }

    public void setGeometry(int start, int sweep, int inside, int outside, Path p) {
        mStart = start;
        mSweep = sweep;
        mInner = inside;
        mOuter = outside;
        mPath = p;
    }

    public int getStartAngle() {
        return mStart;
    }

    public int getSweep() {
        return mSweep;
    }

    public int getInnerRadius() {
        return mInner;
    }

    public int getOuterRadius() {
        return mOuter;
    }

    public View getView() {
        return mView;
    }

    public Path getPath() {
        return mPath;
    }

}
