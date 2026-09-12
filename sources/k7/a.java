package k7;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class a extends TypeAdapter {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0836a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f66795a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f66795a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66795a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public BigDecimal read2(JsonReader jsonReader) {
        if (jsonReader == null) {
            return null;
        }
        int i11 = C0836a.f66795a[jsonReader.peek().ordinal()];
        if (i11 != 1 && i11 != 2) {
            jsonReader.skipValue();
            return null;
        }
        String nextString = jsonReader.nextString();
        if (TextUtils.isEmpty(nextString)) {
            return null;
        }
        try {
            return new BigDecimal(nextString);
        } catch (Exception e11) {
            Log.getStackTraceString(e11);
            return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) {
        jsonWriter.value(bigDecimal);
    }
}
