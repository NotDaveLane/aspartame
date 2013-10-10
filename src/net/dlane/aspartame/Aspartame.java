package net.dlane.aspartame;

import net.dlane.aspartame.service.gson.SugarExclusionStrategy;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class Aspartame {

    public static <T> T newService( String server, Class<T> serviceClass ) {

        Gson gson = new GsonBuilder().setExclusionStrategies( new SugarExclusionStrategy() ).create();
        RestAdapter restAdapter = new RestAdapter.Builder().setServer( server ).setConverter( new GsonConverter( gson ) ).build();
        return restAdapter.create( serviceClass );
    }
}
