package u4;

import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class l0 {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76778a = JsonReader.a.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b, reason: collision with root package name */
    private static final JsonReader.a f76779b = JsonReader.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeStroke a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        char c11;
        ArrayList arrayList = new ArrayList();
        float f11 = 0.0f;
        boolean z10 = false;
        String str = null;
        q4.b bVar = null;
        q4.a aVar = null;
        q4.b bVar2 = null;
        q4.d dVar = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        while (jsonReader.m()) {
            switch (jsonReader.v(f76778a)) {
                case 0:
                    str = jsonReader.r();
                    break;
                case 1:
                    aVar = d.c(jsonReader, hVar);
                    break;
                case 2:
                    bVar2 = d.e(jsonReader, hVar);
                    break;
                case 3:
                    dVar = d.h(jsonReader, hVar);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.p() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.p() - 1];
                    break;
                case 6:
                    f11 = (float) jsonReader.o();
                    break;
                case 7:
                    z10 = jsonReader.n();
                    break;
                case 8:
                    jsonReader.d();
                    while (jsonReader.m()) {
                        jsonReader.h();
                        String str2 = null;
                        q4.b bVar3 = null;
                        while (jsonReader.m()) {
                            int v11 = jsonReader.v(f76779b);
                            if (v11 == 0) {
                                str2 = jsonReader.r();
                            } else if (v11 != 1) {
                                jsonReader.w();
                                jsonReader.x();
                            } else {
                                bVar3 = d.e(jsonReader, hVar);
                            }
                        }
                        jsonReader.l();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c11 = 0;
                                    break;
                                }
                                break;
                            case 103:
                                if (str2.equals(be.g.f16474b)) {
                                    c11 = 1;
                                    break;
                                }
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c11 = 2;
                                    break;
                                }
                                break;
                        }
                        c11 = 65535;
                        switch (c11) {
                            case 0:
                            case 1:
                                hVar.u(true);
                                arrayList.add(bVar3);
                                break;
                            case 2:
                                bVar = bVar3;
                                break;
                        }
                    }
                    jsonReader.k();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add((q4.b) arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    jsonReader.x();
                    break;
            }
        }
        return new ShapeStroke(str, bVar, arrayList, aVar, dVar == null ? new q4.d(Collections.singletonList(new w4.a(100))) : dVar, bVar2, lineCapType == null ? ShapeStroke.LineCapType.BUTT : lineCapType, lineJoinType == null ? ShapeStroke.LineJoinType.MITER : lineJoinType, f11, z10);
    }
}
