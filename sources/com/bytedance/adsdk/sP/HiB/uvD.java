package com.bytedance.adsdk.sP.HiB;

import android.graphics.Path;
import android.util.JsonReader;
import be.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class uvD {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.bytedance.adsdk.sP.TKC.sP.HiB Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        char c11;
        com.bytedance.adsdk.sP.TKC.Sj.EjP ejP = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        com.bytedance.adsdk.sP.TKC.sP.Jcg jcg2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.TKC tkc = null;
        com.bytedance.adsdk.sP.TKC.Sj.vS vSVar = null;
        com.bytedance.adsdk.sP.TKC.Sj.vS vSVar2 = null;
        boolean z10 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 103:
                    if (nextName.equals(g.f16474b)) {
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
                case ASSET_WRITE_ERROR_VALUE:
                    if (nextName.equals(CampaignEx.JSON_KEY_AD_R)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case INVALID_INDEX_URL_VALUE:
                    if (nextName.equals("s")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case GZIP_ENCODE_ERROR_VALUE:
                    if (nextName.equals("t")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c11 = 7;
                        break;
                    }
                    break;
            }
            c11 = 65535;
            switch (c11) {
                case 0:
                    vSVar2 = EjP.TKC(jsonReader, jcg);
                    break;
                case 1:
                    jsonReader.beginObject();
                    int i11 = -1;
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.hashCode();
                        if (nextName2.equals(CampaignEx.JSON_KEY_AD_K)) {
                            tkc = EjP.Sj(jsonReader, jcg, i11);
                        } else if (nextName2.equals(TtmlNode.TAG_P)) {
                            i11 = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    ejP = EjP.sP(jsonReader, jcg);
                    break;
                case 3:
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 4:
                    vSVar = EjP.TKC(jsonReader, jcg);
                    break;
                case 5:
                    jcg2 = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.sP.TKC.sP.Jcg.LINEAR : com.bytedance.adsdk.sP.TKC.sP.Jcg.RADIAL;
                    break;
                case 6:
                    z10 = jsonReader.nextBoolean();
                    break;
                case 7:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.sP.TKC.sP.HiB(str, jcg2, fillType, tkc, ejP == null ? new com.bytedance.adsdk.sP.TKC.Sj.EjP(Collections.singletonList(new com.bytedance.adsdk.sP.Jcg.Sj(100))) : ejP, vSVar, vSVar2, null, null, z10);
    }
}
