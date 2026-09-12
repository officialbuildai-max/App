package u4;

import android.graphics.Path;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Collections;

/* loaded from: classes2.dex */
abstract class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76762a = JsonReader.a.a("nm", "c", "o", "fillEnabled", CampaignEx.JSON_KEY_AD_R, "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r4.j a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        q4.d dVar = null;
        String str = null;
        q4.a aVar = null;
        boolean z10 = false;
        boolean z11 = false;
        int i11 = 1;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76762a);
            if (v11 == 0) {
                str = jsonReader.r();
            } else if (v11 == 1) {
                aVar = d.c(jsonReader, hVar);
            } else if (v11 == 2) {
                dVar = d.h(jsonReader, hVar);
            } else if (v11 == 3) {
                z10 = jsonReader.n();
            } else if (v11 == 4) {
                i11 = jsonReader.p();
            } else if (v11 != 5) {
                jsonReader.w();
                jsonReader.x();
            } else {
                z11 = jsonReader.n();
            }
        }
        if (dVar == null) {
            dVar = new q4.d(Collections.singletonList(new w4.a(100)));
        }
        return new r4.j(str, z10, i11 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar, z11);
    }
}
