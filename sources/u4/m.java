package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76780a = JsonReader.a.a("ch", "size", "w", TtmlNode.TAG_STYLE, "fFamily", "data");

    /* renamed from: b, reason: collision with root package name */
    private static final JsonReader.a f76781b = JsonReader.a.a("shapes");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p4.c a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        ArrayList arrayList = new ArrayList();
        jsonReader.h();
        double d11 = 0.0d;
        String str = null;
        String str2 = null;
        char c11 = 0;
        double d12 = 0.0d;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76780a);
            if (v11 == 0) {
                c11 = jsonReader.r().charAt(0);
            } else if (v11 == 1) {
                d12 = jsonReader.o();
            } else if (v11 == 2) {
                d11 = jsonReader.o();
            } else if (v11 == 3) {
                str = jsonReader.r();
            } else if (v11 == 4) {
                str2 = jsonReader.r();
            } else if (v11 != 5) {
                jsonReader.w();
                jsonReader.x();
            } else {
                jsonReader.h();
                while (jsonReader.m()) {
                    if (jsonReader.v(f76781b) != 0) {
                        jsonReader.w();
                        jsonReader.x();
                    } else {
                        jsonReader.d();
                        while (jsonReader.m()) {
                            arrayList.add((r4.k) h.a(jsonReader, hVar));
                        }
                        jsonReader.k();
                    }
                }
                jsonReader.l();
            }
        }
        jsonReader.l();
        return new p4.c(arrayList, c11, d12, d11, str, str2);
    }
}
