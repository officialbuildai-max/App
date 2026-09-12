package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import com.bytedance.adsdk.sP.TKC.sP.RiZ;
import java.io.IOException;

/* loaded from: classes2.dex */
class jb {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    public static com.bytedance.adsdk.sP.TKC.sP.RiZ Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        String str = null;
        RiZ.Sj sj2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar3 = null;
        boolean z10 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 109:
                    if (nextName.equals("m")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case INVALID_INDEX_URL_VALUE:
                    if (nextName.equals("s")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    sPVar2 = EjP.Sj(jsonReader, jcg, false);
                    break;
                case 1:
                    sj2 = RiZ.Sj.Sj(jsonReader.nextInt());
                    break;
                case 2:
                    sPVar3 = EjP.Sj(jsonReader, jcg, false);
                    break;
                case 3:
                    sPVar = EjP.Sj(jsonReader, jcg, false);
                    break;
                case 4:
                    z10 = jsonReader.nextBoolean();
                    break;
                case 5:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.sP.TKC.sP.RiZ(str, sj2, sPVar, sPVar2, sPVar3, z10);
    }
}
