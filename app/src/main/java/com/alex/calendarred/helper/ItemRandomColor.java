package com.alex.calendarred.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

import com.alex.calendarred.R;

import java.util.Random;

public final class ItemRandomColor {

    private  Context context;

    public ItemRandomColor(Context context) {
        this.context = context;
    }

    public final int generateRandomColor() {

        int[] androidColors = context.getResources().getIntArray(R.array.androidcolors);
        return androidColors[new Random().nextInt(androidColors.length)];
    }
}
