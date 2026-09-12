package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class HiB {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.bytedance.adsdk.sP.TKC.sP.Sj Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        com.bytedance.adsdk.sP.TKC.sP.Sj sj2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.sP.TKC.sP.Sj sP = sP(jsonReader, jcg);
                    if (sP != null) {
                        sj2 = sP;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return sj2;
    }

    private static com.bytedance.adsdk.sP.TKC.sP.Sj sP(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.sP.TKC.sP.Sj sj2 = null;
        while (true) {
            boolean z10 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (nextName.equals("v")) {
                    if (z10) {
                        sj2 = new com.bytedance.adsdk.sP.TKC.sP.Sj(EjP.Sj(jsonReader, jcg));
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (!nextName.equals("ty")) {
                    jsonReader.skipValue();
                } else if (jsonReader.nextInt() == 0) {
                    z10 = true;
                }
            }
            jsonReader.endObject();
            return sj2;
        }
    }
}
