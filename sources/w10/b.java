package w10;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.k;

/* loaded from: classes7.dex */
final class b implements k {

    /* renamed from: c, reason: collision with root package name */
    private static final MediaType f77669c = MediaType.get("application/json; charset=UTF-8");

    /* renamed from: a, reason: collision with root package name */
    private final Gson f77670a;

    /* renamed from: b, reason: collision with root package name */
    private final TypeAdapter f77671b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Gson gson, TypeAdapter typeAdapter) {
        this.f77670a = gson;
        this.f77671b = typeAdapter;
    }

    @Override // retrofit2.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RequestBody convert(Object obj) {
        Buffer buffer = new Buffer();
        JsonWriter newJsonWriter = this.f77670a.newJsonWriter(new OutputStreamWriter(buffer.outputStream(), StandardCharsets.UTF_8));
        this.f77671b.write(newJsonWriter, obj);
        newJsonWriter.close();
        return RequestBody.create(f77669c, buffer.readByteString());
    }
}
