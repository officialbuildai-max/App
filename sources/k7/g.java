package k7;

import android.text.TextUtils;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class g extends TypeAdapter {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f66801a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f66801a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66801a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long read2(JsonReader jsonReader) {
        if (jsonReader == null) {
            return null;
        }
        int i11 = a.f66801a[jsonReader.peek().ordinal()];
        if (i11 == 1) {
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException unused) {
                return Long.valueOf(new BigDecimal(jsonReader.nextString()).longValue());
            }
        }
        if (i11 != 2) {
            jsonReader.skipValue();
            return null;
        }
        String nextString = jsonReader.nextString();
        if (TextUtils.isEmpty(nextString)) {
            return null;
        }
        try {
            try {
                return Long.valueOf(Long.parseLong(nextString));
            } catch (Exception unused2) {
                return null;
            }
        } catch (NumberFormatException unused3) {
            return Long.valueOf(new BigDecimal(nextString).longValue());
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Long l11) {
        jsonWriter.value(l11);
    }
}
