package u4;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes2.dex */
abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76782a = JsonReader.a.a("s", "e", "o", "nm", "m", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeTrimPath a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        String str = null;
        ShapeTrimPath.Type type = null;
        q4.b bVar = null;
        q4.b bVar2 = null;
        q4.b bVar3 = null;
        boolean z10 = false;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76782a);
            if (v11 == 0) {
                bVar = d.f(jsonReader, hVar, false);
            } else if (v11 == 1) {
                bVar2 = d.f(jsonReader, hVar, false);
            } else if (v11 == 2) {
                bVar3 = d.f(jsonReader, hVar, false);
            } else if (v11 == 3) {
                str = jsonReader.r();
            } else if (v11 == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.p());
            } else if (v11 != 5) {
                jsonReader.x();
            } else {
                z10 = jsonReader.n();
            }
        }
        return new ShapeTrimPath(str, type, bVar, bVar2, bVar3, z10);
    }
}
