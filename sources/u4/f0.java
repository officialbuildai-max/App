package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes2.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76754a = JsonReader.a.a("nm", CampaignEx.JSON_KEY_AD_R, "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r4.h a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        boolean z10 = false;
        String str = null;
        q4.b bVar = null;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76754a);
            if (v11 == 0) {
                str = jsonReader.r();
            } else if (v11 == 1) {
                bVar = d.f(jsonReader, hVar, true);
            } else if (v11 != 2) {
                jsonReader.x();
            } else {
                z10 = jsonReader.n();
            }
        }
        if (z10) {
            return null;
        }
        return new r4.h(str, bVar);
    }
}
