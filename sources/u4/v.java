package u4;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes2.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76798a = JsonReader.a.a("nm", "ind", "refId", "ty", "parent", "sw", com.mbridge.msdk.foundation.entity.b.JSON_KEY_SH, "sc", "ks", TtmlNode.TAG_TT, "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd", "ao", "bm");

    /* renamed from: b, reason: collision with root package name */
    private static final JsonReader.a f76799b = JsonReader.a.a("d", "a");

    /* renamed from: c, reason: collision with root package name */
    private static final JsonReader.a f76800c = JsonReader.a.a("ty", "nm");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f76801a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f76801a = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f76801a[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Layer a(com.airbnb.lottie.h hVar) {
        Rect b11 = hVar.b();
        return new Layer(Collections.emptyList(), hVar, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new q4.n(), 0, 0, 0, 0.0f, 0.0f, b11.width(), b11.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false, null, null, LBlendMode.NORMAL);
    }

    public static Layer b(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        ArrayList arrayList;
        boolean z10;
        float f11;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        LBlendMode lBlendMode = LBlendMode.NORMAL;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jsonReader.h();
        Float valueOf = Float.valueOf(0.0f);
        Float valueOf2 = Float.valueOf(1.0f);
        Layer.MatteType matteType2 = matteType;
        LBlendMode lBlendMode2 = lBlendMode;
        Layer.LayerType layerType = null;
        String str = null;
        q4.j jVar = null;
        q4.k kVar = null;
        q4.b bVar = null;
        r4.a aVar = null;
        j jVar2 = null;
        long j11 = 0;
        boolean z11 = false;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        boolean z12 = false;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        long j12 = -1;
        float f17 = 1.0f;
        String str2 = "UNSET";
        String str3 = null;
        q4.n nVar = null;
        while (jsonReader.m()) {
            switch (jsonReader.v(f76798a)) {
                case 0:
                    str2 = jsonReader.r();
                    break;
                case 1:
                    j11 = jsonReader.p();
                    break;
                case 2:
                    str = jsonReader.r();
                    break;
                case 3:
                    int p11 = jsonReader.p();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (p11 >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[p11];
                        break;
                    }
                case 4:
                    j12 = jsonReader.p();
                    break;
                case 5:
                    i11 = (int) (jsonReader.p() * v4.l.e());
                    break;
                case 6:
                    i12 = (int) (jsonReader.p() * v4.l.e());
                    break;
                case 7:
                    i13 = Color.parseColor(jsonReader.r());
                    break;
                case 8:
                    nVar = c.g(jsonReader, hVar);
                    break;
                case 9:
                    int p12 = jsonReader.p();
                    if (p12 < Layer.MatteType.values().length) {
                        matteType2 = Layer.MatteType.values()[p12];
                        int i14 = a.f76801a[matteType2.ordinal()];
                        if (i14 == 1) {
                            hVar.a("Unsupported matte type: Luma");
                        } else if (i14 == 2) {
                            hVar.a("Unsupported matte type: Luma Inverted");
                        }
                        hVar.r(1);
                        break;
                    } else {
                        hVar.a("Unsupported matte type: " + p12);
                        break;
                    }
                case 10:
                    jsonReader.d();
                    while (jsonReader.m()) {
                        arrayList2.add(x.a(jsonReader, hVar));
                    }
                    hVar.r(arrayList2.size());
                    jsonReader.k();
                    break;
                case 11:
                    jsonReader.d();
                    while (jsonReader.m()) {
                        r4.c a11 = h.a(jsonReader, hVar);
                        if (a11 != null) {
                            arrayList3.add(a11);
                        }
                    }
                    jsonReader.k();
                    break;
                case 12:
                    jsonReader.h();
                    while (jsonReader.m()) {
                        int v11 = jsonReader.v(f76799b);
                        if (v11 == 0) {
                            jVar = d.d(jsonReader, hVar);
                        } else if (v11 != 1) {
                            jsonReader.w();
                            jsonReader.x();
                        } else {
                            jsonReader.d();
                            if (jsonReader.m()) {
                                kVar = b.a(jsonReader, hVar);
                            }
                            while (jsonReader.m()) {
                                jsonReader.x();
                            }
                            jsonReader.k();
                        }
                    }
                    jsonReader.l();
                    break;
                case 13:
                    jsonReader.d();
                    ArrayList arrayList4 = new ArrayList();
                    while (jsonReader.m()) {
                        jsonReader.h();
                        while (jsonReader.m()) {
                            int v12 = jsonReader.v(f76800c);
                            if (v12 == 0) {
                                int p13 = jsonReader.p();
                                if (p13 == 29) {
                                    aVar = e.b(jsonReader, hVar);
                                } else if (p13 == 25) {
                                    jVar2 = new k().b(jsonReader, hVar);
                                }
                            } else if (v12 != 1) {
                                jsonReader.w();
                                jsonReader.x();
                            } else {
                                arrayList4.add(jsonReader.r());
                            }
                        }
                        jsonReader.l();
                    }
                    jsonReader.k();
                    hVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    break;
                case 14:
                    f17 = (float) jsonReader.o();
                    break;
                case 15:
                    f13 = (float) jsonReader.o();
                    break;
                case 16:
                    f14 = (float) (jsonReader.o() * v4.l.e());
                    break;
                case 17:
                    f15 = (float) (jsonReader.o() * v4.l.e());
                    break;
                case 18:
                    f12 = (float) jsonReader.o();
                    break;
                case 19:
                    f16 = (float) jsonReader.o();
                    break;
                case 20:
                    bVar = d.f(jsonReader, hVar, false);
                    break;
                case 21:
                    str3 = jsonReader.r();
                    break;
                case 22:
                    z12 = jsonReader.n();
                    break;
                case 23:
                    if (jsonReader.p() != 1) {
                        z11 = false;
                        break;
                    } else {
                        z11 = true;
                        break;
                    }
                case 24:
                    int p14 = jsonReader.p();
                    if (p14 < LBlendMode.values().length) {
                        lBlendMode2 = LBlendMode.values()[p14];
                        break;
                    } else {
                        hVar.a("Unsupported Blend Mode: " + p14);
                        lBlendMode2 = LBlendMode.NORMAL;
                        break;
                    }
                default:
                    jsonReader.w();
                    jsonReader.x();
                    break;
            }
        }
        jsonReader.l();
        ArrayList arrayList5 = new ArrayList();
        if (f12 > 0.0f) {
            arrayList = arrayList2;
            z10 = z11;
            arrayList5.add(new w4.a(hVar, valueOf, valueOf, null, 0.0f, Float.valueOf(f12)));
            f11 = 0.0f;
        } else {
            arrayList = arrayList2;
            z10 = z11;
            f11 = 0.0f;
        }
        if (f16 <= f11) {
            f16 = hVar.f();
        }
        arrayList5.add(new w4.a(hVar, valueOf2, valueOf2, null, f12, Float.valueOf(f16)));
        arrayList5.add(new w4.a(hVar, valueOf, valueOf, null, f16, Float.valueOf(Float.MAX_VALUE)));
        if (str2.endsWith(".ai") || "ai".equals(str3)) {
            hVar.a("Convert your Illustrator layers to shape layers.");
        }
        if (z10) {
            if (nVar == null) {
                nVar = new q4.n();
            }
            nVar.m(z10);
        }
        return new Layer(arrayList3, hVar, str2, j11, layerType, j12, str, arrayList, nVar, i11, i12, i13, f17, f13, f14, f15, jVar, kVar, arrayList5, matteType2, bVar, z12, aVar, jVar2, lBlendMode2);
    }
}
