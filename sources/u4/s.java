package u4;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76791a = JsonReader.a.a("x", "y");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f76792a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f76792a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f76792a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f76792a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF a(JsonReader jsonReader, float f11) {
        jsonReader.d();
        float o11 = (float) jsonReader.o();
        float o12 = (float) jsonReader.o();
        while (jsonReader.t() != JsonReader.Token.END_ARRAY) {
            jsonReader.x();
        }
        jsonReader.k();
        return new PointF(o11 * f11, o12 * f11);
    }

    private static PointF b(JsonReader jsonReader, float f11) {
        float o11 = (float) jsonReader.o();
        float o12 = (float) jsonReader.o();
        while (jsonReader.m()) {
            jsonReader.x();
        }
        return new PointF(o11 * f11, o12 * f11);
    }

    private static PointF c(JsonReader jsonReader, float f11) {
        jsonReader.h();
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76791a);
            if (v11 == 0) {
                f12 = g(jsonReader);
            } else if (v11 != 1) {
                jsonReader.w();
                jsonReader.x();
            } else {
                f13 = g(jsonReader);
            }
        }
        jsonReader.l();
        return new PointF(f12 * f11, f13 * f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(JsonReader jsonReader) {
        jsonReader.d();
        int o11 = (int) (jsonReader.o() * 255.0d);
        int o12 = (int) (jsonReader.o() * 255.0d);
        int o13 = (int) (jsonReader.o() * 255.0d);
        while (jsonReader.m()) {
            jsonReader.x();
        }
        jsonReader.k();
        return Color.argb(255, o11, o12, o13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF e(JsonReader jsonReader, float f11) {
        int i11 = a.f76792a[jsonReader.t().ordinal()];
        if (i11 == 1) {
            return b(jsonReader, f11);
        }
        if (i11 == 2) {
            return a(jsonReader, f11);
        }
        if (i11 == 3) {
            return c(jsonReader, f11);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.t());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List f(JsonReader jsonReader, float f11) {
        ArrayList arrayList = new ArrayList();
        jsonReader.d();
        while (jsonReader.t() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.d();
            arrayList.add(e(jsonReader, f11));
            jsonReader.k();
        }
        jsonReader.k();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float g(JsonReader jsonReader) {
        JsonReader.Token t11 = jsonReader.t();
        int i11 = a.f76792a[t11.ordinal()];
        if (i11 == 1) {
            return (float) jsonReader.o();
        }
        if (i11 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + t11);
        }
        jsonReader.d();
        float o11 = (float) jsonReader.o();
        while (jsonReader.m()) {
            jsonReader.x();
        }
        jsonReader.k();
        return o11;
    }
}
