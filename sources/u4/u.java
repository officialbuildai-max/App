package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
abstract class u {

    /* renamed from: a, reason: collision with root package name */
    static JsonReader.a f76797a = JsonReader.a.a(CampaignEx.JSON_KEY_AD_K);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List a(JsonReader jsonReader, com.airbnb.lottie.h hVar, float f11, n0 n0Var, boolean z10) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.t() == JsonReader.Token.STRING) {
            hVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.h();
        while (jsonReader.m()) {
            if (jsonReader.v(f76797a) != 0) {
                jsonReader.x();
            } else if (jsonReader.t() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.d();
                if (jsonReader.t() == JsonReader.Token.NUMBER) {
                    arrayList.add(t.c(jsonReader, hVar, f11, n0Var, false, z10));
                } else {
                    while (jsonReader.m()) {
                        arrayList.add(t.c(jsonReader, hVar, f11, n0Var, true, z10));
                    }
                }
                jsonReader.k();
            } else {
                arrayList.add(t.c(jsonReader, hVar, f11, n0Var, false, z10));
            }
        }
        jsonReader.l();
        b(arrayList);
        return arrayList;
    }

    public static void b(List list) {
        int i11;
        Object obj;
        int size = list.size();
        int i12 = 0;
        while (true) {
            i11 = size - 1;
            if (i12 >= i11) {
                break;
            }
            w4.a aVar = (w4.a) list.get(i12);
            i12++;
            w4.a aVar2 = (w4.a) list.get(i12);
            aVar.f77693h = Float.valueOf(aVar2.f77692g);
            if (aVar.f77688c == null && (obj = aVar2.f77687b) != null) {
                aVar.f77688c = obj;
                if (aVar instanceof n4.i) {
                    ((n4.i) aVar).j();
                }
            }
        }
        w4.a aVar3 = (w4.a) list.get(i11);
        if ((aVar3.f77687b == null || aVar3.f77688c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
