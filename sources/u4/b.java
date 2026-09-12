package u4;

import com.airbnb.lottie.model.content.TextRangeUnits;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Collections;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76742a = JsonReader.a.a("s", "a");

    /* renamed from: b, reason: collision with root package name */
    private static final JsonReader.a f76743b = JsonReader.a.a("s", "e", "o", CampaignEx.JSON_KEY_AD_R);

    /* renamed from: c, reason: collision with root package name */
    private static final JsonReader.a f76744c = JsonReader.a.a("fc", "sc", "sw", "t", "o");

    public static q4.k a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        jsonReader.h();
        q4.m mVar = null;
        q4.l lVar = null;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76742a);
            if (v11 == 0) {
                lVar = b(jsonReader, hVar);
            } else if (v11 != 1) {
                jsonReader.w();
                jsonReader.x();
            } else {
                mVar = c(jsonReader, hVar);
            }
        }
        jsonReader.l();
        return new q4.k(mVar, lVar);
    }

    private static q4.l b(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        jsonReader.h();
        q4.d dVar = null;
        q4.d dVar2 = null;
        q4.d dVar3 = null;
        TextRangeUnits textRangeUnits = null;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76743b);
            if (v11 == 0) {
                dVar = d.h(jsonReader, hVar);
            } else if (v11 == 1) {
                dVar2 = d.h(jsonReader, hVar);
            } else if (v11 == 2) {
                dVar3 = d.h(jsonReader, hVar);
            } else if (v11 != 3) {
                jsonReader.w();
                jsonReader.x();
            } else {
                int p11 = jsonReader.p();
                if (p11 == 1 || p11 == 2) {
                    textRangeUnits = p11 == 1 ? TextRangeUnits.PERCENT : TextRangeUnits.INDEX;
                } else {
                    hVar.a("Unsupported text range units: " + p11);
                    textRangeUnits = TextRangeUnits.INDEX;
                }
            }
        }
        jsonReader.l();
        if (dVar == null && dVar2 != null) {
            dVar = new q4.d(Collections.singletonList(new w4.a(0)));
        }
        return new q4.l(dVar, dVar2, dVar3, textRangeUnits);
    }

    private static q4.m c(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        jsonReader.h();
        q4.a aVar = null;
        q4.a aVar2 = null;
        q4.b bVar = null;
        q4.b bVar2 = null;
        q4.d dVar = null;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76744c);
            if (v11 == 0) {
                aVar = d.c(jsonReader, hVar);
            } else if (v11 == 1) {
                aVar2 = d.c(jsonReader, hVar);
            } else if (v11 == 2) {
                bVar = d.e(jsonReader, hVar);
            } else if (v11 == 3) {
                bVar2 = d.e(jsonReader, hVar);
            } else if (v11 != 4) {
                jsonReader.w();
                jsonReader.x();
            } else {
                dVar = d.h(jsonReader, hVar);
            }
        }
        jsonReader.l();
        return new q4.m(aVar, aVar2, bVar, bVar2, dVar);
    }
}
