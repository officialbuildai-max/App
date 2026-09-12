package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
public class sP {
    public static com.bytedance.adsdk.sP.TKC.Sj.Ym Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.sP.TKC.Sj.Ym ym2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("a")) {
                ym2 = sP(jsonReader, jcg);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return ym2 == null ? new com.bytedance.adsdk.sP.TKC.Sj.Ym(null, null, null, null) : ym2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static com.bytedance.adsdk.sP.TKC.Sj.Ym sP(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.sP.TKC.Sj.Sj sj2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.Sj sj3 = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case GZIP_ENCODE_ERROR_VALUE:
                    if (nextName.equals("t")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3261:
                    if (nextName.equals("fc")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    sPVar2 = EjP.Sj(jsonReader, jcg);
                    break;
                case 1:
                    sj2 = EjP.Jcg(jsonReader, jcg);
                    break;
                case 2:
                    sj3 = EjP.Jcg(jsonReader, jcg);
                    break;
                case 3:
                    sPVar = EjP.Sj(jsonReader, jcg);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.sP.TKC.Sj.Ym(sj2, sj3, sPVar, sPVar2);
    }
}
