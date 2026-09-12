package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import com.bytedance.adsdk.sP.TKC.sP.uA;
import java.io.IOException;

/* loaded from: classes2.dex */
class uP {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0016. Please report as an issue. */
    public static com.bytedance.adsdk.sP.TKC.sP.uA Sj(JsonReader jsonReader) throws IOException {
        String str = null;
        uA.Sj sj2 = null;
        boolean z10 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case 3324:
                    if (nextName.equals("hd")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3488:
                    if (nextName.equals("mm")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    z10 = jsonReader.nextBoolean();
                    break;
                case 1:
                    sj2 = uA.Sj.Sj(jsonReader.nextInt());
                    break;
                case 2:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.sP.TKC.sP.uA(str, sj2, z10);
    }
}
