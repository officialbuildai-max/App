package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes2.dex */
abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76752a = JsonReader.a.a("nm", "c", "o", "tr", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r4.g a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        String str = null;
        q4.b bVar = null;
        q4.b bVar2 = null;
        q4.n nVar = null;
        boolean z10 = false;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76752a);
            if (v11 == 0) {
                str = jsonReader.r();
            } else if (v11 == 1) {
                bVar = d.f(jsonReader, hVar, false);
            } else if (v11 == 2) {
                bVar2 = d.f(jsonReader, hVar, false);
            } else if (v11 == 3) {
                nVar = c.g(jsonReader, hVar);
            } else if (v11 != 4) {
                jsonReader.x();
            } else {
                z10 = jsonReader.n();
            }
        }
        return new r4.g(str, bVar, bVar2, nVar, z10);
    }
}
