package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes2.dex */
abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76750a = JsonReader.a.a("ef");

    /* renamed from: b, reason: collision with root package name */
    private static final JsonReader.a f76751b = JsonReader.a.a("ty", "v");

    private static r4.a a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        jsonReader.h();
        r4.a aVar = null;
        while (true) {
            boolean z10 = false;
            while (jsonReader.m()) {
                int v11 = jsonReader.v(f76751b);
                if (v11 != 0) {
                    if (v11 != 1) {
                        jsonReader.w();
                        jsonReader.x();
                    } else if (z10) {
                        aVar = new r4.a(d.e(jsonReader, hVar));
                    } else {
                        jsonReader.x();
                    }
                } else if (jsonReader.p() == 0) {
                    z10 = true;
                }
            }
            jsonReader.l();
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r4.a b(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        r4.a aVar = null;
        while (jsonReader.m()) {
            if (jsonReader.v(f76750a) != 0) {
                jsonReader.w();
                jsonReader.x();
            } else {
                jsonReader.d();
                while (jsonReader.m()) {
                    r4.a a11 = a(jsonReader, hVar);
                    if (a11 != null) {
                        aVar = a11;
                    }
                }
                jsonReader.k();
            }
        }
        return aVar;
    }
}
