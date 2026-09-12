package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes2.dex */
class Fmk {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    public static com.bytedance.adsdk.sP.TKC.EjP Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        double d11 = 0.0d;
        String str = null;
        String str2 = null;
        char c11 = 0;
        double d12 = 0.0d;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c12 = 65535;
            switch (nextName.hashCode()) {
                case -1866931350:
                    if (nextName.equals("fFamily")) {
                        c12 = 0;
                        break;
                    }
                    break;
                case JSON_ENCODE_ERROR_VALUE:
                    if (nextName.equals("w")) {
                        c12 = 1;
                        break;
                    }
                    break;
                case 3173:
                    if (nextName.equals("ch")) {
                        c12 = 2;
                        break;
                    }
                    break;
                case 3076010:
                    if (nextName.equals("data")) {
                        c12 = 3;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals("size")) {
                        c12 = 4;
                        break;
                    }
                    break;
                case 109780401:
                    if (nextName.equals(TtmlNode.TAG_STYLE)) {
                        c12 = 5;
                        break;
                    }
                    break;
            }
            switch (c12) {
                case 0:
                    str2 = jsonReader.nextString();
                    break;
                case 1:
                    d11 = jsonReader.nextDouble();
                    break;
                case 2:
                    c11 = jsonReader.nextString().charAt(0);
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("shapes".equals(jsonReader.nextName())) {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((com.bytedance.adsdk.sP.TKC.sP.uvD) Dq.Sj(jsonReader, jcg));
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 4:
                    d12 = jsonReader.nextDouble();
                    break;
                case 5:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.sP.TKC.EjP(arrayList, c11, d12, d11, str, str2);
    }
}
