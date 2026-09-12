package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes2.dex */
abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76753a = JsonReader.a.a("nm", TtmlNode.TAG_P, "s", "hd", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r4.b a(JsonReader jsonReader, com.airbnb.lottie.h hVar, int i11) {
        boolean z10 = i11 == 3;
        boolean z11 = false;
        String str = null;
        q4.o oVar = null;
        q4.f fVar = null;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76753a);
            if (v11 == 0) {
                str = jsonReader.r();
            } else if (v11 == 1) {
                oVar = a.b(jsonReader, hVar);
            } else if (v11 == 2) {
                fVar = d.i(jsonReader, hVar);
            } else if (v11 == 3) {
                z11 = jsonReader.n();
            } else if (v11 != 4) {
                jsonReader.w();
                jsonReader.x();
            } else {
                z10 = jsonReader.p() == 3;
            }
        }
        return new r4.b(str, oVar, fVar, z10, z11);
    }
}
