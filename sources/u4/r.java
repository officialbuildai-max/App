package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes2.dex */
public class r implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final r f76790a = new r();

    private r() {
    }

    @Override // u4.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f11) {
        return Integer.valueOf(Math.round(s.g(jsonReader) * f11));
    }
}
