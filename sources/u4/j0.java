package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76768a = JsonReader.a.a("nm", "hd", "it");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r4.k a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z10 = false;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76768a);
            if (v11 == 0) {
                str = jsonReader.r();
            } else if (v11 == 1) {
                z10 = jsonReader.n();
            } else if (v11 != 2) {
                jsonReader.x();
            } else {
                jsonReader.d();
                while (jsonReader.m()) {
                    r4.c a11 = h.a(jsonReader, hVar);
                    if (a11 != null) {
                        arrayList.add(a11);
                    }
                }
                jsonReader.k();
            }
        }
        return new r4.k(str, arrayList, z10);
    }
}
