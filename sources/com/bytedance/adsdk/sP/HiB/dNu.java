package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import be.g;
import com.bytedance.adsdk.sP.TKC.sP.TzV;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class dNu {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x00bc. Please report as an issue. */
    public static com.bytedance.adsdk.sP.TKC.sP.vS Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        int i11;
        com.bytedance.adsdk.sP.TKC.sP.Jcg jcg2;
        int i12;
        int i13;
        int i14 = 1;
        ArrayList arrayList = new ArrayList();
        float f11 = 0.0f;
        String str = null;
        com.bytedance.adsdk.sP.TKC.sP.Jcg jcg3 = null;
        com.bytedance.adsdk.sP.TKC.Sj.TKC tkc = null;
        com.bytedance.adsdk.sP.TKC.Sj.vS vSVar = null;
        com.bytedance.adsdk.sP.TKC.Sj.vS vSVar2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar = null;
        TzV.Sj sj2 = null;
        TzV.sP sPVar2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar3 = null;
        boolean z10 = false;
        com.bytedance.adsdk.sP.TKC.Sj.EjP ejP = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName.hashCode()) {
                case 100:
                    if (nextName.equals("d")) {
                        i11 = 0;
                        break;
                    }
                    break;
                case 101:
                    if (nextName.equals("e")) {
                        i11 = i14;
                        break;
                    }
                    break;
                case 103:
                    if (nextName.equals(g.f16474b)) {
                        i11 = 2;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        i11 = 3;
                        break;
                    }
                    break;
                case INVALID_INDEX_URL_VALUE:
                    if (nextName.equals("s")) {
                        i11 = 4;
                        break;
                    }
                    break;
                case GZIP_ENCODE_ERROR_VALUE:
                    if (nextName.equals("t")) {
                        i11 = 5;
                        break;
                    }
                    break;
                case JSON_ENCODE_ERROR_VALUE:
                    if (nextName.equals("w")) {
                        i11 = 6;
                        break;
                    }
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        i11 = 7;
                        break;
                    }
                    break;
                case 3447:
                    if (nextName.equals("lc")) {
                        i11 = 8;
                        break;
                    }
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        i11 = 9;
                        break;
                    }
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        i11 = 10;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        i11 = 11;
                        break;
                    }
                    break;
            }
            i11 = -1;
            switch (i11) {
                case 0:
                    jcg2 = jcg3;
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar4 = null;
                        String str2 = null;
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            if (nextName2.equals("n")) {
                                str2 = jsonReader.nextString();
                            } else if (nextName2.equals("v")) {
                                sPVar4 = EjP.Sj(jsonReader, jcg);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        if (str2.equals("o")) {
                            sPVar3 = sPVar4;
                            i14 = 1;
                        } else {
                            if (str2.equals("d") || str2.equals(g.f16474b)) {
                                i13 = 1;
                                jcg.Sj(true);
                                arrayList.add(sPVar4);
                            } else {
                                i13 = 1;
                            }
                            i14 = i13;
                        }
                    }
                    i12 = i14;
                    jsonReader.endArray();
                    if (arrayList.size() == i12) {
                        arrayList.add(arrayList.get(0));
                        i14 = i12;
                        jcg3 = jcg2;
                        break;
                    }
                    i14 = i12;
                    jcg3 = jcg2;
                    break;
                case 1:
                    vSVar2 = EjP.TKC(jsonReader, jcg);
                    break;
                case 2:
                    jcg2 = jcg3;
                    jsonReader.beginObject();
                    int i15 = -1;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        nextName3.hashCode();
                        if (nextName3.equals(CampaignEx.JSON_KEY_AD_K)) {
                            tkc = EjP.Sj(jsonReader, jcg, i15);
                        } else if (nextName3.equals(TtmlNode.TAG_P)) {
                            i15 = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    jcg3 = jcg2;
                    break;
                case 3:
                    ejP = EjP.sP(jsonReader, jcg);
                    break;
                case 4:
                    vSVar = EjP.TKC(jsonReader, jcg);
                    break;
                case 5:
                    jcg3 = jsonReader.nextInt() == i14 ? com.bytedance.adsdk.sP.TKC.sP.Jcg.LINEAR : com.bytedance.adsdk.sP.TKC.sP.Jcg.RADIAL;
                    break;
                case 6:
                    sPVar = EjP.Sj(jsonReader, jcg);
                    break;
                case 7:
                    z10 = jsonReader.nextBoolean();
                    break;
                case 8:
                    sj2 = TzV.Sj.values()[jsonReader.nextInt() - i14];
                    break;
                case 9:
                    sPVar2 = TzV.sP.values()[jsonReader.nextInt() - i14];
                    break;
                case 10:
                    jcg2 = jcg3;
                    f11 = (float) jsonReader.nextDouble();
                    jcg3 = jcg2;
                    break;
                case 11:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    i12 = i14;
                    jcg2 = jcg3;
                    i14 = i12;
                    jcg3 = jcg2;
                    break;
            }
        }
        return new com.bytedance.adsdk.sP.TKC.sP.vS(str, jcg3, tkc, ejP == null ? new com.bytedance.adsdk.sP.TKC.Sj.EjP(Collections.singletonList(new com.bytedance.adsdk.sP.Jcg.Sj(100))) : ejP, vSVar, vSVar2, sPVar, sj2, sPVar2, f11, arrayList, sPVar3, z10);
    }
}
