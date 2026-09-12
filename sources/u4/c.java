package u4;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76746a = JsonReader.a.a("a", TtmlNode.TAG_P, "s", "rz", CampaignEx.JSON_KEY_AD_R, "o", "so", "eo", "sk", "sa");

    /* renamed from: b, reason: collision with root package name */
    private static final JsonReader.a f76747b = JsonReader.a.a(CampaignEx.JSON_KEY_AD_K);

    private static boolean a(q4.e eVar) {
        return eVar == null || (eVar.c() && ((PointF) ((w4.a) eVar.b().get(0)).f77687b).equals(0.0f, 0.0f));
    }

    private static boolean b(q4.o oVar) {
        return oVar == null || (!(oVar instanceof q4.i) && oVar.c() && ((PointF) ((w4.a) oVar.b().get(0)).f77687b).equals(0.0f, 0.0f));
    }

    private static boolean c(q4.b bVar) {
        return bVar == null || (bVar.c() && ((Float) ((w4.a) bVar.b().get(0)).f77687b).floatValue() == 0.0f);
    }

    private static boolean d(q4.g gVar) {
        return gVar == null || (gVar.c() && ((w4.d) ((w4.a) gVar.b().get(0)).f77687b).a(1.0f, 1.0f));
    }

    private static boolean e(q4.b bVar) {
        return bVar == null || (bVar.c() && ((Float) ((w4.a) bVar.b().get(0)).f77687b).floatValue() == 0.0f);
    }

    private static boolean f(q4.b bVar) {
        return bVar == null || (bVar.c() && ((Float) ((w4.a) bVar.b().get(0)).f77687b).floatValue() == 0.0f);
    }

    public static q4.n g(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        boolean z10;
        boolean z11 = false;
        boolean z12 = jsonReader.t() == JsonReader.Token.BEGIN_OBJECT;
        if (z12) {
            jsonReader.h();
        }
        q4.b bVar = null;
        q4.e eVar = null;
        q4.o oVar = null;
        q4.g gVar = null;
        q4.b bVar2 = null;
        q4.b bVar3 = null;
        q4.d dVar = null;
        q4.b bVar4 = null;
        q4.b bVar5 = null;
        while (jsonReader.m()) {
            switch (jsonReader.v(f76746a)) {
                case 0:
                    boolean z13 = z11;
                    jsonReader.h();
                    while (jsonReader.m()) {
                        if (jsonReader.v(f76747b) != 0) {
                            jsonReader.w();
                            jsonReader.x();
                        } else {
                            eVar = a.a(jsonReader, hVar);
                        }
                    }
                    jsonReader.l();
                    z11 = z13;
                    continue;
                case 1:
                    oVar = a.b(jsonReader, hVar);
                    continue;
                case 2:
                    gVar = d.j(jsonReader, hVar);
                    continue;
                case 3:
                    hVar.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVar = d.h(jsonReader, hVar);
                    continue;
                case 6:
                    bVar4 = d.f(jsonReader, hVar, z11);
                    continue;
                case 7:
                    bVar5 = d.f(jsonReader, hVar, z11);
                    continue;
                case 8:
                    bVar2 = d.f(jsonReader, hVar, z11);
                    continue;
                case 9:
                    bVar3 = d.f(jsonReader, hVar, z11);
                    continue;
                default:
                    jsonReader.w();
                    jsonReader.x();
                    continue;
            }
            q4.b f11 = d.f(jsonReader, hVar, z11);
            if (f11.b().isEmpty()) {
                f11.b().add(new w4.a(hVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(hVar.f())));
            } else if (((w4.a) f11.b().get(0)).f77687b == null) {
                z10 = false;
                f11.b().set(0, new w4.a(hVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(hVar.f())));
                z11 = z10;
                bVar = f11;
            }
            z10 = false;
            z11 = z10;
            bVar = f11;
        }
        if (z12) {
            jsonReader.l();
        }
        q4.e eVar2 = a(eVar) ? null : eVar;
        q4.o oVar2 = b(oVar) ? null : oVar;
        q4.b bVar6 = c(bVar) ? null : bVar;
        if (d(gVar)) {
            gVar = null;
        }
        return new q4.n(eVar2, oVar2, gVar, bVar6, dVar, bVar4, bVar5, f(bVar2) ? null : bVar2, e(bVar3) ? null : bVar3);
    }
}
