package u4;

import android.graphics.PointF;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.cloud.tmc.integration.params.TmcStartParams;

/* loaded from: classes2.dex */
public class i implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i f76760a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final JsonReader.a f76761b = JsonReader.a.a("t", "f", "s", com.mbridge.msdk.foundation.same.report.j.f35620b, "tr", "lh", TmcStartParams.KEY_LANDSCAPE_SHORT, "fc", "sc", "sw", "of", "ps", "sz");

    private i() {
    }

    @Override // u4.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public DocumentData a(JsonReader jsonReader, float f11) {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.h();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        boolean z10 = true;
        while (jsonReader.m()) {
            switch (jsonReader.v(f76761b)) {
                case 0:
                    str = jsonReader.r();
                    break;
                case 1:
                    str2 = jsonReader.r();
                    break;
                case 2:
                    f12 = (float) jsonReader.o();
                    break;
                case 3:
                    int p11 = jsonReader.p();
                    justification2 = DocumentData.Justification.CENTER;
                    if (p11 <= justification2.ordinal() && p11 >= 0) {
                        justification2 = DocumentData.Justification.values()[p11];
                        break;
                    }
                    break;
                case 4:
                    i11 = jsonReader.p();
                    break;
                case 5:
                    f13 = (float) jsonReader.o();
                    break;
                case 6:
                    f14 = (float) jsonReader.o();
                    break;
                case 7:
                    i12 = s.d(jsonReader);
                    break;
                case 8:
                    i13 = s.d(jsonReader);
                    break;
                case 9:
                    f15 = (float) jsonReader.o();
                    break;
                case 10:
                    z10 = jsonReader.n();
                    break;
                case 11:
                    jsonReader.d();
                    PointF pointF3 = new PointF(((float) jsonReader.o()) * f11, ((float) jsonReader.o()) * f11);
                    jsonReader.k();
                    pointF = pointF3;
                    break;
                case 12:
                    jsonReader.d();
                    PointF pointF4 = new PointF(((float) jsonReader.o()) * f11, ((float) jsonReader.o()) * f11);
                    jsonReader.k();
                    pointF2 = pointF4;
                    break;
                default:
                    jsonReader.w();
                    jsonReader.x();
                    break;
            }
        }
        jsonReader.l();
        return new DocumentData(str, str2, f12, justification2, i11, f13, f14, i12, i13, f15, z10, pointF, pointF2);
    }
}
