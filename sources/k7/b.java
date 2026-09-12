package k7;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/* loaded from: classes3.dex */
public class b extends TypeAdapter {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f66796a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f66796a = iArr;
            try {
                iArr[JsonToken.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66796a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f66796a[JsonToken.NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public Boolean read2(JsonReader jsonReader) {
        if (jsonReader == null) {
            return null;
        }
        int i11 = a.f66796a[jsonReader.peek().ordinal()];
        if (i11 == 1) {
            return Boolean.valueOf(jsonReader.nextBoolean());
        }
        if (i11 == 2) {
            return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
        }
        if (i11 == 3) {
            return Boolean.valueOf(jsonReader.nextInt() != 0);
        }
        jsonReader.skipValue();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Boolean bool) {
        jsonWriter.value(bool);
    }
}
