package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Streaming;
import retrofit2.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class b extends k.a {

    /* loaded from: classes7.dex */
    static final class a implements k {

        /* renamed from: a, reason: collision with root package name */
        static final a f74509a = new a();

        a() {
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseBody convert(ResponseBody responseBody) {
            try {
                return o0.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* renamed from: retrofit2.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static final class C0933b implements k {

        /* renamed from: a, reason: collision with root package name */
        static final C0933b f74510a = new C0933b();

        C0933b() {
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* loaded from: classes7.dex */
    static final class c implements k {

        /* renamed from: a, reason: collision with root package name */
        static final c f74511a = new c();

        c() {
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class d implements k {

        /* renamed from: a, reason: collision with root package name */
        static final d f74512a = new d();

        d() {
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* loaded from: classes7.dex */
    static final class e implements k {

        /* renamed from: a, reason: collision with root package name */
        static final e f74513a = new e();

        e() {
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit convert(ResponseBody responseBody) {
            responseBody.close();
            return Unit.f67184a;
        }
    }

    /* loaded from: classes7.dex */
    static final class f implements k {

        /* renamed from: a, reason: collision with root package name */
        static final f f74514a = new f();

        f() {
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    @Override // retrofit2.k.a
    public k c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, k0 k0Var) {
        if (RequestBody.class.isAssignableFrom(o0.h(type))) {
            return C0933b.f74510a;
        }
        return null;
    }

    @Override // retrofit2.k.a
    public k d(Type type, Annotation[] annotationArr, k0 k0Var) {
        if (type == ResponseBody.class) {
            return o0.l(annotationArr, Streaming.class) ? c.f74511a : a.f74509a;
        }
        if (type == Void.class) {
            return f.f74514a;
        }
        if (o0.m(type)) {
            return e.f74513a;
        }
        return null;
    }
}
