package u4;

import android.graphics.Path;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76785a = JsonReader.a.a("nm", be.g.f16474b, "o", "t", "s", "e", CampaignEx.JSON_KEY_AD_R, "hd");

    /* renamed from: b, reason: collision with root package name */
    private static final JsonReader.a f76786b = JsonReader.a.a(TtmlNode.TAG_P, CampaignEx.JSON_KEY_AD_K);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r4.e a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        q4.d dVar = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType = null;
        q4.c cVar = null;
        q4.f fVar = null;
        q4.f fVar2 = null;
        boolean z10 = false;
        while (jsonReader.m()) {
            switch (jsonReader.v(f76785a)) {
                case 0:
                    str = jsonReader.r();
                    break;
                case 1:
                    jsonReader.h();
                    int i11 = -1;
                    while (jsonReader.m()) {
                        int v11 = jsonReader.v(f76786b);
                        if (v11 == 0) {
                            i11 = jsonReader.p();
                        } else if (v11 != 1) {
                            jsonReader.w();
                            jsonReader.x();
                        } else {
                            cVar = d.g(jsonReader, hVar, i11);
                        }
                    }
                    jsonReader.l();
                    break;
                case 2:
                    dVar = d.h(jsonReader, hVar);
                    break;
                case 3:
                    gradientType = jsonReader.p() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    fVar = d.i(jsonReader, hVar);
                    break;
                case 5:
                    fVar2 = d.i(jsonReader, hVar);
                    break;
                case 6:
                    fillType = jsonReader.p() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z10 = jsonReader.n();
                    break;
                default:
                    jsonReader.w();
                    jsonReader.x();
                    break;
            }
        }
        return new r4.e(str, gradientType, fillType, cVar, dVar == null ? new q4.d(Collections.singletonList(new w4.a(100))) : dVar, fVar, fVar2, null, null, z10);
    }
}
