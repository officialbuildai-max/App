package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes2.dex */
abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76783a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p4.b a(JsonReader jsonReader) {
        jsonReader.h();
        String str = null;
        String str2 = null;
        float f11 = 0.0f;
        String str3 = null;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76783a);
            if (v11 == 0) {
                str = jsonReader.r();
            } else if (v11 == 1) {
                str3 = jsonReader.r();
            } else if (v11 == 2) {
                str2 = jsonReader.r();
            } else if (v11 != 3) {
                jsonReader.w();
                jsonReader.x();
            } else {
                f11 = (float) jsonReader.o();
            }
        }
        jsonReader.l();
        return new p4.b(str, str3, str2, f11);
    }
}
