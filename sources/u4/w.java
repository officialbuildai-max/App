package u4;

import android.graphics.Rect;
import androidx.collection.y0;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76802a = JsonReader.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b, reason: collision with root package name */
    static JsonReader.a f76803b = JsonReader.a.a("id", "layers", "w", "h", TtmlNode.TAG_P, TmcStartParams.KEY_URL_SHORT);

    /* renamed from: c, reason: collision with root package name */
    private static final JsonReader.a f76804c = JsonReader.a.a("list");

    /* renamed from: d, reason: collision with root package name */
    private static final JsonReader.a f76805d = JsonReader.a.a("cm", "tm", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE);

    public static com.airbnb.lottie.h a(JsonReader jsonReader) {
        HashMap hashMap;
        ArrayList arrayList;
        JsonReader jsonReader2 = jsonReader;
        float e11 = v4.l.e();
        androidx.collection.x xVar = new androidx.collection.x();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        y0 y0Var = new y0();
        com.airbnb.lottie.h hVar = new com.airbnb.lottie.h();
        jsonReader.h();
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        int i11 = 0;
        int i12 = 0;
        while (jsonReader.m()) {
            switch (jsonReader2.v(f76802a)) {
                case 0:
                    i12 = jsonReader.p();
                    continue;
                case 1:
                    i11 = jsonReader.p();
                    continue;
                case 2:
                    f11 = (float) jsonReader.o();
                    continue;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f12 = ((float) jsonReader.o()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f13 = (float) jsonReader.o();
                    break;
                case 5:
                    String[] split = jsonReader.r().split("\\.");
                    if (v4.l.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        break;
                    } else {
                        hVar.a("Lottie only supports bodymovin >= 4.4.0");
                        continue;
                    }
                case 6:
                    e(jsonReader2, hVar, arrayList2, xVar);
                    continue;
                case 7:
                    b(jsonReader2, hVar, hashMap2, hashMap3);
                    continue;
                case 8:
                    d(jsonReader2, hashMap4);
                    continue;
                case 9:
                    c(jsonReader2, hVar, y0Var);
                    continue;
                case 10:
                    f(jsonReader2, arrayList3);
                    continue;
                default:
                    jsonReader.w();
                    jsonReader.x();
                    continue;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        hVar.s(new Rect(0, 0, (int) (i12 * e11), (int) (i11 * e11)), f11, f12, f13, arrayList2, xVar, hashMap2, hashMap3, v4.l.e(), y0Var, hashMap4, arrayList3, i12, i11);
        return hVar;
    }

    private static void b(JsonReader jsonReader, com.airbnb.lottie.h hVar, Map map, Map map2) {
        jsonReader.d();
        while (jsonReader.m()) {
            ArrayList arrayList = new ArrayList();
            androidx.collection.x xVar = new androidx.collection.x();
            jsonReader.h();
            int i11 = 0;
            int i12 = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (jsonReader.m()) {
                int v11 = jsonReader.v(f76803b);
                if (v11 == 0) {
                    str = jsonReader.r();
                } else if (v11 == 1) {
                    jsonReader.d();
                    while (jsonReader.m()) {
                        Layer b11 = v.b(jsonReader, hVar);
                        xVar.k(b11.e(), b11);
                        arrayList.add(b11);
                    }
                    jsonReader.k();
                } else if (v11 == 2) {
                    i11 = jsonReader.p();
                } else if (v11 == 3) {
                    i12 = jsonReader.p();
                } else if (v11 == 4) {
                    str2 = jsonReader.r();
                } else if (v11 != 5) {
                    jsonReader.w();
                    jsonReader.x();
                } else {
                    str3 = jsonReader.r();
                }
            }
            jsonReader.l();
            if (str2 != null) {
                com.airbnb.lottie.l0 l0Var = new com.airbnb.lottie.l0(i11, i12, str, str2, str3);
                map2.put(l0Var.e(), l0Var);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.k();
    }

    private static void c(JsonReader jsonReader, com.airbnb.lottie.h hVar, y0 y0Var) {
        jsonReader.d();
        while (jsonReader.m()) {
            p4.c a11 = m.a(jsonReader, hVar);
            y0Var.l(a11.hashCode(), a11);
        }
        jsonReader.k();
    }

    private static void d(JsonReader jsonReader, Map map) {
        jsonReader.h();
        while (jsonReader.m()) {
            if (jsonReader.v(f76804c) != 0) {
                jsonReader.w();
                jsonReader.x();
            } else {
                jsonReader.d();
                while (jsonReader.m()) {
                    p4.b a11 = n.a(jsonReader);
                    map.put(a11.b(), a11);
                }
                jsonReader.k();
            }
        }
        jsonReader.l();
    }

    private static void e(JsonReader jsonReader, com.airbnb.lottie.h hVar, List list, androidx.collection.x xVar) {
        jsonReader.d();
        int i11 = 0;
        while (jsonReader.m()) {
            Layer b11 = v.b(jsonReader, hVar);
            if (b11.g() == Layer.LayerType.IMAGE) {
                i11++;
            }
            list.add(b11);
            xVar.k(b11.e(), b11);
            if (i11 > 4) {
                v4.f.c("You have " + i11 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.k();
    }

    private static void f(JsonReader jsonReader, List list) {
        jsonReader.d();
        while (jsonReader.m()) {
            jsonReader.h();
            float f11 = 0.0f;
            String str = null;
            float f12 = 0.0f;
            while (jsonReader.m()) {
                int v11 = jsonReader.v(f76805d);
                if (v11 == 0) {
                    str = jsonReader.r();
                } else if (v11 == 1) {
                    f11 = (float) jsonReader.o();
                } else if (v11 != 2) {
                    jsonReader.w();
                    jsonReader.x();
                } else {
                    f12 = (float) jsonReader.o();
                }
            }
            jsonReader.l();
            list.add(new p4.g(str, f11, f12));
        }
        jsonReader.k();
    }
}
