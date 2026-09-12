package k7;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class f extends TypeAdapter {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f66800a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f66800a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66800a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer read2(JsonReader jsonReader) {
        if (jsonReader == null) {
            return null;
        }
        int i11 = a.f66800a[jsonReader.peek().ordinal()];
        if (i11 == 1) {
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException unused) {
                return Integer.valueOf((int) jsonReader.nextDouble());
            }
        }
        if (i11 != 2) {
            jsonReader.skipValue();
            return null;
        }
        String nextString = jsonReader.nextString();
        if (nextString != null && !"".equals(nextString)) {
            try {
                try {
                    return Integer.valueOf(Integer.parseInt(nextString));
                } catch (NumberFormatException unused2) {
                    return Integer.valueOf((int) new BigDecimal(nextString).floatValue());
                }
            } catch (Exception unused3) {
            }
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Integer num) {
        jsonWriter.value(num);
    }
}
