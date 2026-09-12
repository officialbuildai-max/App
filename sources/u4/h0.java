package u4;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class h0 implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final h0 f76758a = new h0();

    /* renamed from: b, reason: collision with root package name */
    private static final JsonReader.a f76759b = JsonReader.a.a("c", "v", "i", "o");

    private h0() {
    }

    @Override // u4.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r4.i a(JsonReader jsonReader, float f11) {
        if (jsonReader.t() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.d();
        }
        jsonReader.h();
        List list = null;
        List list2 = null;
        List list3 = null;
        boolean z10 = false;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76759b);
            if (v11 == 0) {
                z10 = jsonReader.n();
            } else if (v11 == 1) {
                list = s.f(jsonReader, f11);
            } else if (v11 == 2) {
                list2 = s.f(jsonReader, f11);
            } else if (v11 != 3) {
                jsonReader.w();
                jsonReader.x();
            } else {
                list3 = s.f(jsonReader, f11);
            }
        }
        jsonReader.l();
        if (jsonReader.t() == JsonReader.Token.END_ARRAY) {
            jsonReader.k();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (list.isEmpty()) {
            return new r4.i(new PointF(), false, Collections.emptyList());
        }
        int size = list.size();
        PointF pointF = (PointF) list.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 1; i11 < size; i11++) {
            PointF pointF2 = (PointF) list.get(i11);
            int i12 = i11 - 1;
            arrayList.add(new p4.a(v4.k.a((PointF) list.get(i12), (PointF) list3.get(i12)), v4.k.a(pointF2, (PointF) list2.get(i11)), pointF2));
        }
        if (z10) {
            PointF pointF3 = (PointF) list.get(0);
            int i13 = size - 1;
            arrayList.add(new p4.a(v4.k.a((PointF) list.get(i13), (PointF) list3.get(i13)), v4.k.a(pointF3, (PointF) list2.get(0)), pointF3));
        }
        return new r4.i(pointF, z10, arrayList);
    }
}
