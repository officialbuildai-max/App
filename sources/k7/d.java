package k7;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/* loaded from: classes3.dex */
public class d extends TypeAdapter {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f66798a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f66798a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66798a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Float f11) {
        jsonWriter.value(f11);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public Float read2(JsonReader jsonReader) {
        if (jsonReader == null) {
            return null;
        }
        int i11 = a.f66798a[jsonReader.peek().ordinal()];
        if (i11 == 1) {
            return Float.valueOf((float) jsonReader.nextDouble());
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
            return Float.valueOf(Float.parseFloat(nextString));
        } catch (Exception e11) {
            Log.getStackTraceString(e11);
            return null;
        }
    }
}
