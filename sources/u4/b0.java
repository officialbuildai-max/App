package u4;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes2.dex */
public class b0 implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f76745a = new b0();

    private b0() {
    }

    @Override // u4.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(JsonReader jsonReader, float f11) {
        JsonReader.Token t11 = jsonReader.t();
        if (t11 != JsonReader.Token.BEGIN_ARRAY && t11 != JsonReader.Token.BEGIN_OBJECT) {
            if (t11 == JsonReader.Token.NUMBER) {
                PointF pointF = new PointF(((float) jsonReader.o()) * f11, ((float) jsonReader.o()) * f11);
                while (jsonReader.m()) {
                    jsonReader.x();
                }
                return pointF;
            }
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + t11);
        }
        return s.e(jsonReader, f11);
    }
}
