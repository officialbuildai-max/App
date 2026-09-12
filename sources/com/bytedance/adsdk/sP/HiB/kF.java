package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import com.bytedance.adsdk.sP.TKC.sP.Dq;
import java.io.IOException;

/* loaded from: classes2.dex */
class kF {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.bytedance.adsdk.sP.TKC.sP.Dq Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        boolean z10;
        boolean z11;
        jsonReader.beginObject();
        Dq.Sj sj2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.Dq dq2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.EjP ejP = null;
        boolean z12 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName.hashCode()) {
                case 111:
                    if (nextName.equals("o")) {
                        z10 = false;
                        break;
                    }
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        z10 = true;
                        break;
                    }
                    break;
                case 104433:
                    if (nextName.equals("inv")) {
                        z10 = 2;
                        break;
                    }
                    break;
                case 3357091:
                    if (nextName.equals("mode")) {
                        z10 = 3;
                        break;
                    }
                    break;
            }
            z10 = -1;
            switch (z10) {
                case false:
                    ejP = EjP.sP(jsonReader, jcg);
                    break;
                case true:
                    dq2 = EjP.HiB(jsonReader, jcg);
                    break;
                case true:
                    z12 = jsonReader.nextBoolean();
                    break;
                case true:
                    String nextString = jsonReader.nextString();
                    nextString.hashCode();
                    switch (nextString.hashCode()) {
                        case 97:
                            if (nextString.equals("a")) {
                                z11 = false;
                                break;
                            }
                            break;
                        case 105:
                            if (nextString.equals("i")) {
                                z11 = true;
                                break;
                            }
                            break;
                        case 110:
                            if (nextString.equals("n")) {
                                z11 = 2;
                                break;
                            }
                            break;
                        case INVALID_INDEX_URL_VALUE:
                            if (nextString.equals("s")) {
                                z11 = 3;
                                break;
                            }
                            break;
                    }
                    z11 = -1;
                    switch (z11) {
                        case false:
                            sj2 = Dq.Sj.MASK_MODE_ADD;
                            break;
                        case true:
                            jcg.Sj("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            sj2 = Dq.Sj.MASK_MODE_INTERSECT;
                            break;
                        case true:
                            sj2 = Dq.Sj.MASK_MODE_NONE;
                            break;
                        case true:
                            sj2 = Dq.Sj.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            sj2 = Dq.Sj.MASK_MODE_ADD;
                            break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.sP.TKC.sP.Dq(sj2, dq2, ejP, z12);
    }
}
