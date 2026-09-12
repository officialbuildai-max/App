package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
public class Ym {
    private com.bytedance.adsdk.sP.TKC.Sj.sP EjP;
    private com.bytedance.adsdk.sP.TKC.Sj.sP HiB;
    private com.bytedance.adsdk.sP.TKC.Sj.Sj Sj;
    private com.bytedance.adsdk.sP.TKC.Sj.sP TKC;
    private com.bytedance.adsdk.sP.TKC.Sj.sP sP;

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0034. Please report as an issue. */
    private void sP(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        jsonReader.beginObject();
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("v")) {
                str.hashCode();
                char c11 = 65535;
                switch (str.hashCode()) {
                    case 353103893:
                        if (str.equals("Distance")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case 397447147:
                        if (str.equals("Opacity")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 1041377119:
                        if (str.equals("Direction")) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case 1379387491:
                        if (str.equals("Shadow Color")) {
                            c11 = 3;
                            break;
                        }
                        break;
                    case 1383710113:
                        if (str.equals("Softness")) {
                            c11 = 4;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        this.EjP = EjP.Sj(jsonReader, jcg);
                        break;
                    case 1:
                        this.sP = EjP.Sj(jsonReader, jcg, false);
                        break;
                    case 2:
                        this.TKC = EjP.Sj(jsonReader, jcg, false);
                        break;
                    case 3:
                        this.Sj = EjP.Jcg(jsonReader, jcg);
                        break;
                    case 4:
                        this.HiB = EjP.Sj(jsonReader, jcg);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (nextName.equals("nm")) {
                str = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TEQ Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar2;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar3;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar4;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    sP(jsonReader, jcg);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        com.bytedance.adsdk.sP.TKC.Sj.Sj sj2 = this.Sj;
        if (sj2 == null || (sPVar = this.sP) == null || (sPVar2 = this.TKC) == null || (sPVar3 = this.EjP) == null || (sPVar4 = this.HiB) == null) {
            return null;
        }
        return new TEQ(sj2, sPVar, sPVar2, sPVar3, sPVar4);
    }
}
