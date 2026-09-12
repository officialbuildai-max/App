package com.google.net.cronet.okhttptransport;

import com.google.common.base.m;
import com.google.common.util.concurrent.r;
import com.google.common.util.concurrent.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Buffer;
import okio.Source;
import okio.Timeout;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class OkHttpBridgeRequestCallback extends UrlRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final y f32805a = y.s();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f32806b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f32807c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private final BlockingQueue f32808d = new ArrayBlockingQueue(2);

    /* renamed from: e, reason: collision with root package name */
    private final y f32809e = y.s();

    /* renamed from: f, reason: collision with root package name */
    private final long f32810f;

    /* renamed from: g, reason: collision with root package name */
    private final com.google.net.cronet.okhttptransport.c f32811g;

    /* renamed from: h, reason: collision with root package name */
    private volatile UrlRequest f32812h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum CallbackStep {
        ON_READ_COMPLETED,
        ON_SUCCESS,
        ON_FAILED,
        ON_CANCELED
    }

    /* loaded from: classes4.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32813a;

        static {
            int[] iArr = new int[CallbackStep.values().length];
            f32813a = iArr;
            try {
                iArr[CallbackStep.ON_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32813a[CallbackStep.ON_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32813a[CallbackStep.ON_CANCELED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32813a[CallbackStep.ON_READ_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final CallbackStep f32814a;

        /* renamed from: b, reason: collision with root package name */
        private final ByteBuffer f32815b;

        /* renamed from: c, reason: collision with root package name */
        private final CronetException f32816c;

        private b(CallbackStep callbackStep, ByteBuffer byteBuffer, CronetException cronetException) {
            this.f32814a = callbackStep;
            this.f32815b = byteBuffer;
            this.f32816c = cronetException;
        }

        /* synthetic */ b(CallbackStep callbackStep, ByteBuffer byteBuffer, CronetException cronetException, a aVar) {
            this(callbackStep, byteBuffer, cronetException);
        }
    }

    /* loaded from: classes4.dex */
    private class c implements Source {

        /* renamed from: a, reason: collision with root package name */
        private ByteBuffer f32817a;

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f32818b;

        private c() {
            this.f32817a = ByteBuffer.allocateDirect(32768);
            this.f32818b = false;
        }

        /* synthetic */ c(OkHttpBridgeRequestCallback okHttpBridgeRequestCallback, a aVar) {
            this();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f32818b) {
                return;
            }
            this.f32818b = true;
            if (OkHttpBridgeRequestCallback.this.f32806b.get()) {
                return;
            }
            OkHttpBridgeRequestCallback.this.f32812h.cancel();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) {
            b bVar;
            if (OkHttpBridgeRequestCallback.this.f32807c.get()) {
                throw new IOException("The request was canceled!");
            }
            m.e(buffer != null, "sink == null");
            m.h(j11 >= 0, "byteCount < 0: %s", j11);
            m.v(!this.f32818b, "closed");
            if (OkHttpBridgeRequestCallback.this.f32806b.get()) {
                return -1L;
            }
            if (j11 < this.f32817a.limit()) {
                this.f32817a.limit((int) j11);
            }
            OkHttpBridgeRequestCallback.this.f32812h.read(this.f32817a);
            try {
                bVar = (b) OkHttpBridgeRequestCallback.this.f32808d.poll(OkHttpBridgeRequestCallback.this.f32810f, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                bVar = null;
            }
            if (bVar == null) {
                OkHttpBridgeRequestCallback.this.f32812h.cancel();
                throw new CronetTimeoutException();
            }
            int i11 = a.f32813a[bVar.f32814a.ordinal()];
            if (i11 == 1) {
                OkHttpBridgeRequestCallback.this.f32806b.set(true);
                this.f32817a = null;
                throw new IOException(bVar.f32816c);
            }
            if (i11 == 2) {
                OkHttpBridgeRequestCallback.this.f32806b.set(true);
                this.f32817a = null;
                return -1L;
            }
            if (i11 == 3) {
                this.f32817a = null;
                throw new IOException("The request was canceled!");
            }
            if (i11 != 4) {
                throw new AssertionError("The switch block above is exhaustive!");
            }
            bVar.f32815b.flip();
            int write = buffer.write(bVar.f32815b);
            bVar.f32815b.clear();
            return write;
        }

        @Override // okio.Source
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return Timeout.NONE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpBridgeRequestCallback(long j11, com.google.net.cronet.okhttptransport.c cVar) {
        m.d(j11 >= 0);
        if (j11 == 0) {
            this.f32810f = 2147483647L;
        } else {
            this.f32810f = j11;
        }
        this.f32811g = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r f() {
        return this.f32805a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r g() {
        return this.f32809e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f32807c.set(true);
        this.f32808d.add(new b(CallbackStep.ON_CANCELED, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0));
        IOException iOException = new IOException("The request was canceled!");
        this.f32809e.setException(iOException);
        this.f32805a.setException(iOException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        if (this.f32809e.setException(cronetException) && this.f32805a.setException(cronetException)) {
            return;
        }
        this.f32808d.add(new b(CallbackStep.ON_FAILED, null, cronetException, 0 == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        this.f32808d.add(new b(CallbackStep.ON_READ_COMPLETED, byteBuffer, null, 0 == true ? 1 : 0));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        if (!this.f32811g.b()) {
            m.u(this.f32809e.set(urlResponseInfo));
            m.u(this.f32805a.set(new Buffer()));
            urlRequest.cancel();
        } else {
            if (urlResponseInfo.getUrlChain().size() <= this.f32811g.c()) {
                urlRequest.followRedirect();
                return;
            }
            urlRequest.cancel();
            ProtocolException protocolException = new ProtocolException("Too many follow-up requests: " + (this.f32811g.c() + 1));
            this.f32809e.setException(protocolException);
            this.f32805a.setException(protocolException);
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f32812h = urlRequest;
        m.u(this.f32809e.set(urlResponseInfo));
        m.u(this.f32805a.set(new c(this, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f32808d.add(new b(CallbackStep.ON_SUCCESS, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0));
    }
}
