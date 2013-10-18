package net.dlane.aspartame;

import retrofit.Callback;
import retrofit.RetrofitError;
import android.util.Log;
import android.widget.Toast;

import com.orm.SugarApp;

public abstract class AspartameCallback<T> implements Callback<T> {

    @Override
    public void failure( RetrofitError error ) {

        Log.e( "Callback", "Error processing request.", error );
        Toast.makeText( SugarApp.getSugarContext(), "error: " + error.getMessage(), Toast.LENGTH_LONG ).show();
    }
}
