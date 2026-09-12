package com.bytedance.adsdk.sP.HiB;

import android.graphics.PointF;
import android.util.JsonReader;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class vS {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0020. Please report as an issue. */
    public static com.bytedance.adsdk.sP.TKC.sP.sP Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg, int i11) throws IOException {
        boolean z10 = i11 == 3;
        boolean z11 = false;
        String str = null;
        com.bytedance.adsdk.sP.TKC.Sj.Fmk<PointF, PointF> fmk = null;
        com.bytedance.adsdk.sP.TKC.Sj.vS vSVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case 100:
                    if (nextName.equals("d")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 112:
                    if (nextName.equals(TtmlNode.TAG_P)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case INVALID_INDEX_URL_VALUE:
                    if (nextName.equals("s")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    if (jsonReader.nextInt() != 3) {
                        z10 = false;
                        break;
                    } else {
                        z10 = true;
                        break;
                    }
                case 1:
                    fmk = Sj.sP(jsonReader, jcg);
                    break;
                case 2:
                    vSVar = EjP.TKC(jsonReader, jcg);
                    break;
                case 3:
                    z11 = jsonReader.nextBoolean();
                    break;
                case 4:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.sP.TKC.sP.sP(str, fmk, vSVar, z10, z11);
    }
}
