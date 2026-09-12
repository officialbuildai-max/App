package u4;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes2.dex */
public class g implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final g f76755a = new g();

    private g() {
    }

    @Override // u4.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f11) {
        boolean z10 = jsonReader.t() == JsonReader.Token.BEGIN_ARRAY;
        if (z10) {
            jsonReader.d();
        }
        double o11 = jsonReader.o();
        double o12 = jsonReader.o();
        double o13 = jsonReader.o();
        double o14 = jsonReader.t() == JsonReader.Token.NUMBER ? jsonReader.o() : 1.0d;
        if (z10) {
            jsonReader.k();
        }
        if (o11 <= 1.0d && o12 <= 1.0d && o13 <= 1.0d) {
            o11 *= 255.0d;
            o12 *= 255.0d;
            o13 *= 255.0d;
            if (o14 <= 1.0d) {
                o14 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) o14, (int) o11, (int) o12, (int) o13));
    }
}
