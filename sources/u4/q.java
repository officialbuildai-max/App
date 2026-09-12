package u4;

import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76787a = JsonReader.a.a("nm", be.g.f16474b, "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b, reason: collision with root package name */
    private static final JsonReader.a f76788b = JsonReader.a.a(TtmlNode.TAG_P, CampaignEx.JSON_KEY_AD_K);

    /* renamed from: c, reason: collision with root package name */
    private static final JsonReader.a f76789c = JsonReader.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.content.a a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        String str;
        q4.c cVar;
        ArrayList arrayList = new ArrayList();
        float f11 = 0.0f;
        String str2 = null;
        GradientType gradientType = null;
        q4.c cVar2 = null;
        q4.f fVar = null;
        q4.f fVar2 = null;
        q4.b bVar = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        q4.b bVar2 = null;
        boolean z10 = false;
        q4.d dVar = null;
        while (jsonReader.m()) {
            switch (jsonReader.v(f76787a)) {
                case 0:
                    str2 = jsonReader.r();
                    continue;
                case 1:
                    str = str2;
                    jsonReader.h();
                    int i11 = -1;
                    while (jsonReader.m()) {
                        int v11 = jsonReader.v(f76788b);
                        if (v11 != 0) {
                            cVar = cVar2;
                            if (v11 != 1) {
                                jsonReader.w();
                                jsonReader.x();
                            } else {
                                cVar2 = d.g(jsonReader, hVar, i11);
                            }
                        } else {
                            cVar = cVar2;
                            i11 = jsonReader.p();
                        }
                        cVar2 = cVar;
                    }
                    jsonReader.l();
                    break;
                case 2:
                    dVar = d.h(jsonReader, hVar);
                    continue;
                case 3:
                    str = str2;
                    gradientType = jsonReader.p() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    fVar = d.i(jsonReader, hVar);
                    continue;
                case 5:
                    fVar2 = d.i(jsonReader, hVar);
                    continue;
                case 6:
                    bVar = d.e(jsonReader, hVar);
                    continue;
                case 7:
                    str = str2;
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.p() - 1];
                    break;
                case 8:
                    str = str2;
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.p() - 1];
                    break;
                case 9:
                    str = str2;
                    f11 = (float) jsonReader.o();
                    break;
                case 10:
                    z10 = jsonReader.n();
                    continue;
                case 11:
                    jsonReader.d();
                    while (jsonReader.m()) {
                        jsonReader.h();
                        String str3 = null;
                        q4.b bVar3 = null;
                        while (jsonReader.m()) {
                            int v12 = jsonReader.v(f76789c);
                            if (v12 != 0) {
                                q4.b bVar4 = bVar2;
                                if (v12 != 1) {
                                    jsonReader.w();
                                    jsonReader.x();
                                } else {
                                    bVar3 = d.e(jsonReader, hVar);
                                }
                                bVar2 = bVar4;
                            } else {
                                str3 = jsonReader.r();
                            }
                        }
                        q4.b bVar5 = bVar2;
                        jsonReader.l();
                        if (str3.equals("o")) {
                            bVar2 = bVar3;
                        } else {
                            if (str3.equals("d") || str3.equals(be.g.f16474b)) {
                                hVar.u(true);
                                arrayList.add(bVar3);
                            }
                            bVar2 = bVar5;
                        }
                    }
                    q4.b bVar6 = bVar2;
                    jsonReader.k();
                    if (arrayList.size() == 1) {
                        arrayList.add((q4.b) arrayList.get(0));
                    }
                    bVar2 = bVar6;
                    continue;
                default:
                    jsonReader.w();
                    jsonReader.x();
                    continue;
            }
            str2 = str;
        }
        String str4 = str2;
        if (dVar == null) {
            dVar = new q4.d(Collections.singletonList(new w4.a(100)));
        }
        return new com.airbnb.lottie.model.content.a(str4, gradientType, cVar2, dVar, fVar, fVar2, bVar, lineCapType, lineJoinType, f11, arrayList, bVar2, z10);
    }
}
