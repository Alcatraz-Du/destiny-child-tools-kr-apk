package com.arsylk.mammonsmite.Adapters;

import android.graphics.Bitmap;
import com.arsylk.mammonsmite.utils.Define;
import org.json.JSONObject;

import java.util.Locale;


public class OnlineModelItem {
    private String modelUrl = null, previewUrl = null;
    private int id;
    private String modelId;
    private String modelName, creator, description;
    private JSONObject modelInfo = null;
    private Bitmap bitmap = null;

    //constructors
    public OnlineModelItem(JSONObject json) {
        load(json);
    }

    private void load(JSONObject json) {
        try {
            //model
            id = json.getInt("id");
            modelId = json.getString("model_id");
            modelName = json.getString("model_name");

            //mod
            creator = json.getString("creator");
            if(!json.isNull("description"))
                description = json.getString("description");
            else
                description = "";

            //files
            modelUrl = String.format(Locale.US, Define.ONLINE_MODEL_FILE_URL, id);
            if(!json.isNull("model_preview")) {
                previewUrl = String.format(Locale.US, Define.ONLINE_MODEL_PREVIEW_URL, id);
            }

            //model info
            if(!json.isNull("model_info")) {
                modelInfo = new JSONObject(json.getString("model_info"));
            }
        }catch(Exception e) {
        }
    }

    //setters
    public void setPreviewBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getModelId() {
        return modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public String getCreator() {
        return creator;
    }

    public String getDescription() {
        return description;
    }

    public JSONObject getModelInfo() {
        return modelInfo;
    }

    public String getModelUrl() {
        return modelUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public Bitmap getPreviewBitmap() {
        return bitmap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(" modelUrl: ");
        sb.append(modelUrl);
        sb.append("previewUrl: ");
        sb.append(previewUrl);
        sb.append(" id: ");
        sb.append(id);
        sb.append(" modelId: ");
        sb.append(modelId);
        sb.append(" modelName: ");
        sb.append(modelName);
        sb.append(" }");
        return sb.toString();
    }
}
