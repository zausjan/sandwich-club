package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);

            String description = jsonObject.getString("description");
            String sandwichImage = jsonObject.getString("image");
            String origin = jsonObject.getString("placeOfOrigin");

            JSONArray ingredientsArray = jsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();
            for(int i = 0; i < ingredientsArray.length(); i++){
                ingredients.add(ingredientsArray.getString(i));
            }

            JSONObject nameObject = jsonObject.getJSONObject("name");

            String mainName = nameObject.getString("mainName");
            JSONArray knownAsArray = nameObject.getJSONArray("alsoKnownAs");
            ArrayList<String> knownAs = new ArrayList<>();
            for(int i = 0; i < knownAsArray.length(); i++){
                knownAs.add(knownAsArray.getString(i));
            }

            return new Sandwich(mainName, knownAs, origin, description,
                                             sandwichImage, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
