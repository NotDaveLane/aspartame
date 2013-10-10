package net.dlane.aspartame.model;

import android.content.Context;

import com.orm.SugarApp;
import com.orm.SugarRecord;

public class AspartameRecord<T> extends SugarRecord<T> {

    public AspartameRecord() {

        this( SugarApp.getSugarContext() );
    }

    public AspartameRecord(Context context) {

        super( context );
    }
}
