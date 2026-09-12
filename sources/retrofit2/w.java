package retrofit2;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class w implements d {

    /* renamed from: a, reason: collision with root package name */
    private final i0 f74635a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f74636b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f74637c;

    /* renamed from: d, reason: collision with root package name */
    private final Call.Factory f74638d;

    /* renamed from: e, reason: collision with root package name */
    private final k f74639e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f74640f;

    /* renamed from: g, reason: collision with root package name */
    private Call f74641g;

    /* renamed from: h, reason: collision with root package name */
    private Throwable f74642h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f74643i;

    /* loaded from: classes7.dex */
    class a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f74644a;

        a(f fVar) {
            this.f74644a = fVar;
        }

        private void a(Throwable th2) {
            try {
                this.f74644a.a(w.this, th2);
            } catch (Throwable th3) {
                o0.t(th3);
                th3.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                try {
                    this.f74644a.b(w.this, w.this.d(response));
                } catch (Throwable th2) {
                    o0.t(th2);
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                o0.t(th3);
                a(th3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b extends ResponseBody {

        /* renamed from: a, reason: collision with root package name */
        private final ResponseBody f74646a;

        /* renamed from: b, reason: collision with root package name */
        private final BufferedSource f74647b;

        /* renamed from: c, reason: collision with root package name */
        IOException f74648c;

        /* loaded from: classes7.dex */
        class a extends ForwardingSource {
            a(Source source) {
                super(source);
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j11) {
                try {
                    return super.read(buffer, j11);
                } catch (IOException e11) {
                    b.this.f74648c = e11;
                    throw e11;
                }
            }
        }

        b(ResponseBody responseBody) {
            this.f74646a = responseBody;
            this.f74647b = Okio.buffer(new a(responseBody.getSource()));
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f74646a.close();
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentLength */
        public long getContentLength() {
            return this.f74646a.getContentLength();
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentType */
        public MediaType get$contentType() {
            return this.f74646a.get$contentType();
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: source */
        public BufferedSource getSource() {
            return this.f74647b;
        }

        void throwIfCaught() {
            IOException iOException = this.f74648c;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends ResponseBody {

        /* renamed from: a, reason: collision with root package name */
        private final MediaType f74650a;

        /* renamed from: b, reason: collision with root package name */
        private final long f74651b;

        c(MediaType mediaType, long j11) {
            this.f74650a = mediaType;
            this.f74651b = j11;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentLength */
        public long getContentLength() {
            return this.f74651b;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentType */
        public MediaType get$contentType() {
            return this.f74650a;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: source */
        public BufferedSource getSource() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(i0 i0Var, Object obj, Object[] objArr, Call.Factory factory, k kVar) {
        this.f74635a = i0Var;
        this.f74636b = obj;
        this.f74637c = objArr;
        this.f74638d = factory;
        this.f74639e = kVar;
    }

    private Call b() {
        Call newCall = this.f74638d.newCall(this.f74635a.a(this.f74636b, this.f74637c));
        if (newCall != null) {
            return newCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    private Call c() {
        Call call = this.f74641g;
        if (call != null) {
            return call;
        }
        Throwable th2 = this.f74642h;
        if (th2 != null) {
            if (th2 instanceof IOException) {
                throw ((IOException) th2);
            }
            if (th2 instanceof RuntimeException) {
                throw ((RuntimeException) th2);
            }
            throw ((Error) th2);
        }
        try {
            Call b11 = b();
            this.f74641g = b11;
            return b11;
        } catch (IOException | Error | RuntimeException e11) {
            o0.t(e11);
            this.f74642h = e11;
            throw e11;
        }
    }

    @Override // retrofit2.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public w clone() {
        return new w(this.f74635a, this.f74636b, this.f74637c, this.f74638d, this.f74639e);
    }

    @Override // retrofit2.d
    public void cancel() {
        Call call;
        this.f74640f = true;
        synchronized (this) {
            call = this.f74641g;
        }
        if (call != null) {
            call.cancel();
        }
    }

    j0 d(Response response) {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new c(body.get$contentType(), body.getContentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return j0.c(o0.a(body), build);
            } finally {
                body.close();
            }
        }
        if (code == 204 || code == 205) {
            body.close();
            return j0.g(null, build);
        }
        b bVar = new b(body);
        try {
            return j0.g(this.f74639e.convert(bVar), build);
        } catch (RuntimeException e11) {
            bVar.throwIfCaught();
            throw e11;
        }
    }

    @Override // retrofit2.d
    public j0 execute() {
        Call c11;
        synchronized (this) {
            if (this.f74643i) {
                throw new IllegalStateException("Already executed.");
            }
            this.f74643i = true;
            c11 = c();
        }
        if (this.f74640f) {
            c11.cancel();
        }
        return d(FirebasePerfOkHttpClient.execute(c11));
    }

    @Override // retrofit2.d
    public void h(f fVar) {
        Call call;
        Throwable th2;
        Objects.requireNonNull(fVar, "callback == null");
        synchronized (this) {
            try {
                if (this.f74643i) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f74643i = true;
                call = this.f74641g;
                th2 = this.f74642h;
                if (call == null && th2 == null) {
                    try {
                        Call b11 = b();
                        this.f74641g = b11;
                        call = b11;
                    } catch (Throwable th3) {
                        th2 = th3;
                        o0.t(th2);
                        this.f74642h = th2;
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        if (th2 != null) {
            fVar.a(this, th2);
            return;
        }
        if (this.f74640f) {
            call.cancel();
        }
        FirebasePerfOkHttpClient.enqueue(call, new a(fVar));
    }

    @Override // retrofit2.d
    public boolean isCanceled() {
        boolean z10 = true;
        if (this.f74640f) {
            return true;
        }
        synchronized (this) {
            try {
                Call call = this.f74641g;
                if (call == null || !call.getCanceled()) {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // retrofit2.d
    public synchronized Request request() {
        try {
        } catch (IOException e11) {
            throw new RuntimeException("Unable to create request.", e11);
        }
        return c().request();
    }
}
