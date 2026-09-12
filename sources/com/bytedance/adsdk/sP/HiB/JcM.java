package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;

/* loaded from: classes2.dex */
public class JcM {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0018. Please report as an issue. */
    public static com.bytedance.adsdk.sP.TKC.sP.Fmk Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        String str = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar = null;
        boolean z10 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case ASSET_WRITE_ERROR_VALUE:
                    if (nextName.equals(CampaignEx.JSON_KEY_AD_R)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
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
                    sPVar = EjP.Sj(jsonReader, jcg, true);
                    break;
                case 1:
                    z10 = jsonReader.nextBoolean();
                    break;
                case 2:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (z10) {
            return null;
        }
        return new com.bytedance.adsdk.sP.TKC.sP.Fmk(str, sPVar);
    }
}
