package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76740a = JsonReader.a.a(CampaignEx.JSON_KEY_AD_K, "x", "y");

    public static q4.e a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.t() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.d();
            while (jsonReader.m()) {
                arrayList.add(z.a(jsonReader, hVar));
            }
            jsonReader.k();
            u.b(arrayList);
        } else {
            arrayList.add(new w4.a(s.e(jsonReader, v4.l.e())));
        }
        return new q4.e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q4.o b(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        jsonReader.h();
        q4.e eVar = null;
        q4.b bVar = null;
        boolean z10 = false;
        q4.b bVar2 = null;
        while (jsonReader.t() != JsonReader.Token.END_OBJECT) {
            int v11 = jsonReader.v(f76740a);
            if (v11 == 0) {
                eVar = a(jsonReader, hVar);
            } else if (v11 != 1) {
                if (v11 != 2) {
                    jsonReader.w();
                    jsonReader.x();
                } else if (jsonReader.t() == JsonReader.Token.STRING) {
                    jsonReader.x();
                    z10 = true;
                } else {
                    bVar = d.e(jsonReader, hVar);
                }
            } else if (jsonReader.t() == JsonReader.Token.STRING) {
                jsonReader.x();
                z10 = true;
            } else {
                bVar2 = d.e(jsonReader, hVar);
            }
        }
        jsonReader.l();
        if (z10) {
            hVar.a("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new q4.i(bVar2, bVar);
    }
}
