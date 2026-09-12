package u4;

import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes2.dex */
abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76748a = JsonReader.a.a("nm", "sy", "pt", TtmlNode.TAG_P, CampaignEx.JSON_KEY_AD_R, "or", "os", "ir", "is", "hd", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PolystarShape a(JsonReader jsonReader, com.airbnb.lottie.h hVar, int i11) {
        boolean z10 = false;
        boolean z11 = i11 == 3;
        String str = null;
        PolystarShape.Type type = null;
        q4.b bVar = null;
        q4.o oVar = null;
        q4.b bVar2 = null;
        q4.b bVar3 = null;
        q4.b bVar4 = null;
        q4.b bVar5 = null;
        q4.b bVar6 = null;
        while (jsonReader.m()) {
            switch (jsonReader.v(f76748a)) {
                case 0:
                    str = jsonReader.r();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.p());
                    break;
                case 2:
                    bVar = d.f(jsonReader, hVar, false);
                    break;
                case 3:
                    oVar = a.b(jsonReader, hVar);
                    break;
                case 4:
                    bVar2 = d.f(jsonReader, hVar, false);
                    break;
                case 5:
                    bVar4 = d.e(jsonReader, hVar);
                    break;
                case 6:
                    bVar6 = d.f(jsonReader, hVar, false);
                    break;
                case 7:
                    bVar3 = d.e(jsonReader, hVar);
                    break;
                case 8:
                    bVar5 = d.f(jsonReader, hVar, false);
                    break;
                case 9:
                    z10 = jsonReader.n();
                    break;
                case 10:
                    if (jsonReader.p() != 3) {
                        z11 = false;
                        break;
                    } else {
                        z11 = true;
                        break;
                    }
                default:
                    jsonReader.w();
                    jsonReader.x();
                    break;
            }
        }
        return new PolystarShape(str, type, bVar, oVar, bVar2, bVar3, bVar4, bVar5, bVar6, z10, z11);
    }
}
