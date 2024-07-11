package com.example.qoutes;

import android.content.Context;
import android.content.Intent;

public class Share {

    public static void sharingqoute(Context context,String qoute)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,qoute);
        intent.setType("text/plain");
        context.startActivity(intent);
    }

}
