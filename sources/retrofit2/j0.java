package retrofit2;

import java.util.Objects;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes7.dex */
public final class j0<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Response f74578a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f74579b;

    /* renamed from: c, reason: collision with root package name */
    private final ResponseBody f74580c;

    private j0(Response response, Object obj, ResponseBody responseBody) {
        this.f74578a = response;
        this.f74579b = obj;
        this.f74580c = responseBody;
    }

    public static j0 c(ResponseBody responseBody, Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new j0(response, null, responseBody);
    }

    public static j0 g(Object obj, Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new j0(response, obj, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public Object a() {
        return this.f74579b;
    }

    public int b() {
        return this.f74578a.code();
    }

    public ResponseBody d() {
        return this.f74580c;
    }

    public boolean e() {
        return this.f74578a.isSuccessful();
    }

    public String f() {
        return this.f74578a.message();
    }

    public String toString() {
        return this.f74578a.toString();
    }
}
