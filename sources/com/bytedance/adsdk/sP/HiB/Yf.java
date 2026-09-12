package com.bytedance.adsdk.sP.HiB;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.sP.TKC.sP.TEQ;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class Yf {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x002f. Please report as an issue. */
    public static com.bytedance.adsdk.sP.TKC.sP.TEQ Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg, int i11) throws IOException {
        boolean z10 = false;
        boolean z11 = i11 == 3;
        String str = null;
        TEQ.Sj sj2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar = null;
        com.bytedance.adsdk.sP.TKC.Sj.Fmk<PointF, PointF> fmk = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar3 = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar4 = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar5 = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar6 = null;
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
                case ASSET_WRITE_ERROR_VALUE:
                    if (nextName.equals(CampaignEx.JSON_KEY_AD_R)) {
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
                case 3369:
                    if (nextName.equals("ir")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 3370:
                    if (nextName.equals("is")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 3555:
                    if (nextName.equals("or")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c11 = '\b';
                        break;
                    }
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        c11 = '\t';
                        break;
                    }
                    break;
                case 3686:
                    if (nextName.equals("sy")) {
                        c11 = '\n';
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    if (jsonReader.nextInt() != 3) {
                        z11 = false;
                        break;
                    } else {
                        z11 = true;
                        break;
                    }
                case 1:
                    fmk = Sj.sP(jsonReader, jcg);
                    break;
                case 2:
                    sPVar2 = EjP.Sj(jsonReader, jcg, false);
                    break;
                case 3:
                    z10 = jsonReader.nextBoolean();
                    break;
                case 4:
                    sPVar3 = EjP.Sj(jsonReader, jcg);
                    break;
                case 5:
                    sPVar5 = EjP.Sj(jsonReader, jcg, false);
                    break;
                case 6:
                    str = jsonReader.nextString();
                    break;
                case 7:
                    sPVar4 = EjP.Sj(jsonReader, jcg);
                    break;
                case '\b':
                    sPVar6 = EjP.Sj(jsonReader, jcg, false);
                    break;
                case '\t':
                    sPVar = EjP.Sj(jsonReader, jcg, false);
                    break;
                case '\n':
                    sj2 = TEQ.Sj.Sj(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.sP.TKC.sP.TEQ(str, sj2, sPVar, fmk, sPVar2, sPVar3, sPVar4, sPVar5, sPVar6, z10, z11);
    }
}
