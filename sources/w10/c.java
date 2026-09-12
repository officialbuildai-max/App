package w10;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import okhttp3.ResponseBody;
import retrofit2.k;

/* loaded from: classes7.dex */
final class c implements k {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f77672a;

    /* renamed from: b, reason: collision with root package name */
    private final TypeAdapter f77673b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Gson gson, TypeAdapter typeAdapter) {
        this.f77672a = gson;
        this.f77673b = typeAdapter;
    }

    @Override // retrofit2.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object convert(ResponseBody responseBody) {
        JsonReader newJsonReader = this.f77672a.newJsonReader(responseBody.charStream());
        try {
            Object read2 = this.f77673b.read2(newJsonReader);
            if (newJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return read2;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
