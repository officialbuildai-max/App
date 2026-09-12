package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class fF {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static com.bytedance.adsdk.sP.TKC.sP.aa Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        String str = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.aa aaVar = null;
        boolean z10 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 3710:
                    if (nextName.equals("tr")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    sPVar = EjP.Sj(jsonReader, jcg, false);
                    break;
                case 1:
                    sPVar2 = EjP.Sj(jsonReader, jcg, false);
                    break;
                case 2:
                    z10 = jsonReader.nextBoolean();
                    break;
                case 3:
                    str = jsonReader.nextString();
                    break;
                case 4:
                    aaVar = TKC.Sj(jsonReader, jcg);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.sP.TKC.sP.aa(str, sPVar, sPVar2, aaVar, z10);
    }
}
