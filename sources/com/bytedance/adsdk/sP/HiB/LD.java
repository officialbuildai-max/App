package com.bytedance.adsdk.sP.HiB;

import android.graphics.PointF;
import android.util.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class LD {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static com.bytedance.adsdk.sP.TKC.sP.Ym Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        String str = null;
        com.bytedance.adsdk.sP.TKC.Sj.Fmk<PointF, PointF> fmk = null;
        com.bytedance.adsdk.sP.TKC.Sj.vS vSVar = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar = null;
        boolean z10 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case 112:
                    if (nextName.equals(TtmlNode.TAG_P)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case ASSET_WRITE_ERROR_VALUE:
                    if (nextName.equals(CampaignEx.JSON_KEY_AD_R)) {
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
                    fmk = Sj.sP(jsonReader, jcg);
                    break;
                case 1:
                    sPVar = EjP.Sj(jsonReader, jcg);
                    break;
                case 2:
                    vSVar = EjP.TKC(jsonReader, jcg);
                    break;
                case 3:
                    z10 = jsonReader.nextBoolean();
                    break;
                case 4:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.sP.TKC.sP.Ym(str, fmk, vSVar, sPVar, z10);
    }
}
