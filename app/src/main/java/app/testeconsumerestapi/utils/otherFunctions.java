package app.testeconsumerestapi.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Alisson on 01/11/2017.
 */

public class otherFunctions {

    public static String getProperty(String key, Context context) throws IOException {
        Properties properties = new Properties();
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("rest_config.properties");
        properties.load(inputStream);
        return properties.getProperty(key);

    }



}
