package com.cloud.hisavana.protocol.okhttptransport;

import com.google.common.base.m;
import com.google.common.util.concurrent.r;
import com.google.common.util.concurrent.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
/* loaded from: classes3.dex */
public class OkHttpBridgeRequestCallback extends UrlRequest.Callback {

    /* renamed from: f, reason: collision with root package name */
    private final long f21528f;

    /* renamed from: h, reason: collision with root package name */
    private final com.cloud.hisavana.protocol.okhttptransport.c f21530h;

    /* renamed from: i, reason: collision with root package name */
    private volatile UrlRequest f21531i;

    /* renamed from: a, reason: collision with root package name */
    private final y f21523a = y.s();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f21524b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f21525c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private final BlockingQueue f21526d = new ArrayBlockingQueue(2);

    /* renamed from: e, reason: collision with root package name */
    private final y f21527e = y.s();

    /* renamed from: g, reason: collision with root package name */
    private final List f21529g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum CallbackStep {
        ON_READ_COMPLETED,
        ON_SUCCESS,
        ON_FAILED,
        ON_CANCELED
    }

    /* loaded from: classes3.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f21532a;

        static {
            int[] iArr = new int[CallbackStep.values().length];
            f21532a = iArr;
            try {
                iArr[CallbackStep.ON_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21532a[CallbackStep.ON_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21532a[CallbackStep.ON_CANCELED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21532a[CallbackStep.ON_READ_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final CallbackStep f21533a;

        /* renamed from: b, reason: collision with root package name */
        private final ByteBuffer f21534b;

        /* renamed from: c, reason: collision with root package name */
        private final CronetException f21535c;

        private b(CallbackStep callbackStep, ByteBuffer byteBuffer, CronetException cronetException) {
            this.f21533a = callbackStep;
            this.f21534b = byteBuffer;
            this.f21535c = cronetException;
        }

        /* synthetic */ b(CallbackStep callbackStep, ByteBuffer byteBuffer, CronetException cronetException, a aVar) {
            this(callbackStep, byteBuffer, cronetException);
        }
    }

    /* loaded from: classes3.dex */
    private class c implements Source {

        /* renamed from: a, reason: collision with root package name */
        private ByteBuffer f21536a;

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f21537b;

        private c() {
            this.f21536a = ByteBuffer.allocateDirect(32768);
            this.f21537b = false;
        }

        /* synthetic */ c(OkHttpBridgeRequestCallback okHttpBridgeRequestCallback, a aVar) {
            this();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f21537b) {
                return;
            }
            this.f21537b = true;
            if (OkHttpBridgeRequestCallback.this.f21524b.get()) {
                return;
            }
            OkHttpBridgeRequestCallback.this.f21531i.cancel();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) {
            b bVar;
            if (OkHttpBridgeRequestCallback.this.f21525c.get()) {
                throw new IOException("The request was canceled!");
            }
            m.e(buffer != null, "sink == null");
            m.h(j11 >= 0, "byteCount < 0: %s", j11);
            m.v(!this.f21537b, "closed");
            if (OkHttpBridgeRequestCallback.this.f21524b.get()) {
                return -1L;
            }
            if (j11 < this.f21536a.limit()) {
                this.f21536a.limit((int) j11);
            }
            OkHttpBridgeRequestCallback.this.f21531i.read(this.f21536a);
            try {
                bVar = (b) OkHttpBridgeRequestCallback.this.f21526d.poll(OkHttpBridgeRequestCallback.this.f21528f, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                bVar = null;
            }
            if (bVar == null) {
                OkHttpBridgeRequestCallback.this.f21531i.cancel();
                throw new CronetTimeoutException();
            }
            int i11 = a.f21532a[bVar.f21533a.ordinal()];
            if (i11 == 1) {
                OkHttpBridgeRequestCallback.this.f21524b.set(true);
                this.f21536a = null;
                throw new IOException(bVar.f21535c);
            }
            if (i11 == 2) {
                OkHttpBridgeRequestCallback.this.f21524b.set(true);
                this.f21536a = null;
                return -1L;
            }
            if (i11 == 3) {
                this.f21536a = null;
                throw new IOException("The request was canceled!");
            }
            if (i11 != 4) {
                throw new AssertionError("The switch block above is exhaustive!");
            }
            bVar.f21534b.flip();
            int write = buffer.write(bVar.f21534b);
            bVar.f21534b.clear();
            return write;
        }

        @Override // okio.Source
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return Timeout.NONE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpBridgeRequestCallback(long j11, com.cloud.hisavana.protocol.okhttptransport.c cVar) {
        m.d(j11 >= 0);
        if (j11 == 0) {
            this.f21528f = 2147483647L;
        } else {
            this.f21528f = j11;
        }
        this.f21530h = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r f() {
        return this.f21523a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r g() {
        return this.f21527e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List h() {
        return Collections.unmodifiableList(this.f21529g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f21525c.set(true);
        this.f21526d.add(new b(CallbackStep.ON_CANCELED, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0));
        IOException iOException = new IOException("The request was canceled!");
        this.f21527e.setException(iOException);
        this.f21523a.setException(iOException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        if (this.f21527e.setException(cronetException) && this.f21523a.setException(cronetException)) {
            return;
        }
        this.f21526d.add(new b(CallbackStep.ON_FAILED, null, cronetException, 0 == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        this.f21526d.add(new b(CallbackStep.ON_READ_COMPLETED, byteBuffer, null, 0 == true ? 1 : 0));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        if (!this.f21530h.b()) {
            m.u(this.f21527e.set(urlResponseInfo));
            m.u(this.f21523a.set(new Buffer()));
            urlRequest.cancel();
            return;
        }
        this.f21529g.add(urlResponseInfo);
        if (urlResponseInfo.getUrlChain().size() <= this.f21530h.c()) {
            urlRequest.followRedirect();
            return;
        }
        urlRequest.cancel();
        ProtocolException protocolException = new ProtocolException("Too many follow-up requests: " + (this.f21530h.c() + 1));
        this.f21527e.setException(protocolException);
        this.f21523a.setException(protocolException);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f21531i = urlRequest;
        m.u(this.f21527e.set(urlResponseInfo));
        m.u(this.f21523a.set(new c(this, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f21526d.add(new b(CallbackStep.ON_SUCCESS, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0));
    }
}
