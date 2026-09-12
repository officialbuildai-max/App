package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes2.dex */
abstract class d0 {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76749a = JsonReader.a.a("nm", TtmlNode.TAG_P, "s", CampaignEx.JSON_KEY_AD_R, "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r4.f a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        String str = null;
        q4.o oVar = null;
        q4.f fVar = null;
        q4.b bVar = null;
        boolean z10 = false;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76749a);
            if (v11 == 0) {
                str = jsonReader.r();
            } else if (v11 == 1) {
                oVar = a.b(jsonReader, hVar);
            } else if (v11 == 2) {
                fVar = d.i(jsonReader, hVar);
            } else if (v11 == 3) {
                bVar = d.e(jsonReader, hVar);
            } else if (v11 != 4) {
                jsonReader.x();
            } else {
                z10 = jsonReader.n();
            }
        }
        return new r4.f(str, oVar, fVar, bVar, z10);
    }
}
