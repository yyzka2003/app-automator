package com.darpa;

import android.util.Log;

public class StaticData {
    public static String LABEL_OPEN = "open";
    public static String LABEL_CROSS = "cross";
    public static String LABEL_SKIP = "skip";

    public static String JSON_OBJECT_BOXES = "boxes";
    public static String JSON_OBJECT_SCORES = "scores";
    public static String JSON_OBJECT_LABELS = "labels";

    public static String PREDICT_URL = "http://211.66.130.46:12401/predict";

    public static volatile boolean RUN = false;

}
