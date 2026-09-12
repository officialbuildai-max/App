package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes2.dex */
abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    static JsonReader.a f76776a = JsonReader.a.a("nm", "ind", "ks", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r4.l a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        String str = null;
        int i11 = 0;
        boolean z10 = false;
        q4.h hVar2 = null;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76776a);
            if (v11 == 0) {
                str = jsonReader.r();
            } else if (v11 == 1) {
                i11 = jsonReader.p();
            } else if (v11 == 2) {
                hVar2 = d.k(jsonReader, hVar);
            } else if (v11 != 3) {
                jsonReader.x();
            } else {
                z10 = jsonReader.n();
            }
        }
        return new r4.l(str, i11, hVar2, z10);
    }
}
