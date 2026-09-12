package com.google.net.cronet.okhttptransport;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.base.s;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.m;
import com.google.common.util.concurrent.r;
import com.google.common.util.concurrent.t;
import com.google.common.util.concurrent.z;
import com.google.net.cronet.okhttptransport.UploadBodyDataBroker;
import com.google.net.cronet.okhttptransport.e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    private final b f32830a;

    /* renamed from: b, reason: collision with root package name */
    private final c f32831b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32832a;

        static {
            int[] iArr = new int[UploadBodyDataBroker.ReadResult.values().length];
            f32832a = iArr;
            try {
                iArr[UploadBodyDataBroker.ReadResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32832a[UploadBodyDataBroker.ReadResult.END_OF_BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b implements d {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a extends UploadDataProvider {

            /* renamed from: a, reason: collision with root package name */
            private volatile boolean f32833a = false;

            /* renamed from: b, reason: collision with root package name */
            private final Buffer f32834b = new Buffer();

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f32835c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RequestBody f32836d;

            a(long j11, RequestBody requestBody) {
                this.f32835c = j11;
                this.f32836d = requestBody;
            }

            @Override // org.chromium.net.UploadDataProvider
            public long getLength() {
                return this.f32835c;
            }

            @Override // org.chromium.net.UploadDataProvider
            public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                if (!this.f32833a) {
                    this.f32836d.writeTo(this.f32834b);
                    this.f32834b.flush();
                    this.f32833a = true;
                    long length = getLength();
                    long size = this.f32834b.size();
                    if (size != length) {
                        throw new IOException("Expected " + length + " bytes but got " + size);
                    }
                }
                if (this.f32834b.read(byteBuffer) == -1) {
                    throw new IllegalStateException("The source has been exhausted but we expected more!");
                }
                uploadDataSink.onReadSucceeded(false);
            }

            @Override // org.chromium.net.UploadDataProvider
            public void rewind(UploadDataSink uploadDataSink) {
                uploadDataSink.onRewindError(new UnsupportedOperationException());
            }
        }

        b() {
        }

        @Override // com.google.net.cronet.okhttptransport.d
        public UploadDataProvider a(RequestBody requestBody, int i11) {
            long contentLength = requestBody.contentLength();
            if (contentLength >= 0 && contentLength <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                return new a(contentLength, requestBody);
            }
            throw new IOException("Expected definite length less than 1048576but got " + contentLength);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class c implements d {

        /* renamed from: a, reason: collision with root package name */
        private final ExecutorService f32838a;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static class a extends UploadDataProvider {

            /* renamed from: a, reason: collision with root package name */
            private final RequestBody f32839a;

            /* renamed from: b, reason: collision with root package name */
            private final UploadBodyDataBroker f32840b;

            /* renamed from: c, reason: collision with root package name */
            private final t f32841c;

            /* renamed from: d, reason: collision with root package name */
            private final long f32842d;

            /* renamed from: e, reason: collision with root package name */
            private r f32843e;

            /* renamed from: f, reason: collision with root package name */
            private long f32844f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.google.net.cronet.okhttptransport.e$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0453a implements m {
                C0453a() {
                }

                @Override // com.google.common.util.concurrent.m
                public void onFailure(Throwable th2) {
                    a.this.f32840b.i(th2);
                }

                @Override // com.google.common.util.concurrent.m
                public void onSuccess(Object obj) {
                }
            }

            private a(RequestBody requestBody, UploadBodyDataBroker uploadBodyDataBroker, ExecutorService executorService, long j11) {
                this.f32839a = requestBody;
                this.f32840b = uploadBodyDataBroker;
                if (executorService instanceof t) {
                    this.f32841c = (t) executorService;
                } else {
                    this.f32841c = MoreExecutors.b(executorService);
                }
                this.f32842d = j11 == 0 ? 2147483647L : j11;
            }

            /* synthetic */ a(RequestBody requestBody, UploadBodyDataBroker uploadBodyDataBroker, ExecutorService executorService, long j11, a aVar) {
                this(requestBody, uploadBodyDataBroker, executorService, j11);
            }

            private void h() {
                if (this.f32843e == null) {
                    r submit = this.f32841c.submit(new Callable() { // from class: com.google.net.cronet.okhttptransport.f
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Void k11;
                            k11 = e.c.a.this.k();
                            return k11;
                        }
                    });
                    this.f32843e = submit;
                    Futures.a(submit, new C0453a(), MoreExecutors.a());
                }
            }

            private void i(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                byteBuffer.position(0);
                if (!m(byteBuffer).equals(UploadBodyDataBroker.ReadResult.END_OF_BODY)) {
                    throw l(getLength(), this.f32844f);
                }
                s.a(byteBuffer.position() == 0, "END_OF_BODY reads shouldn't write anything to the buffer", new Object[0]);
                byteBuffer.position(position);
                uploadDataSink.onReadSucceeded(false);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ Void k() {
                BufferedSink buffer = Okio.buffer(this.f32840b);
                this.f32839a.writeTo(buffer);
                buffer.flush();
                this.f32840b.h();
                return null;
            }

            private static IOException l(long j11, long j12) {
                return new IOException("Expected " + j11 + " bytes but got at least " + j12);
            }

            private UploadBodyDataBroker.ReadResult m(ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                UploadBodyDataBroker.ReadResult readResult = (UploadBodyDataBroker.ReadResult) z.b(this.f32840b.b(byteBuffer), this.f32842d, TimeUnit.MILLISECONDS);
                this.f32844f += byteBuffer.position() - position;
                return readResult;
            }

            private void n(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                try {
                    UploadBodyDataBroker.ReadResult m11 = m(byteBuffer);
                    if (this.f32844f > getLength()) {
                        throw l(getLength(), this.f32844f);
                    }
                    if (this.f32844f >= getLength()) {
                        i(uploadDataSink, byteBuffer);
                        return;
                    }
                    int i11 = a.f32832a[m11.ordinal()];
                    if (i11 == 1) {
                        uploadDataSink.onReadSucceeded(false);
                    } else if (i11 == 2) {
                        throw new IOException("The source has been exhausted but we expected more data!");
                    }
                } catch (ExecutionException e11) {
                    e = e11;
                    this.f32843e.cancel(true);
                    uploadDataSink.onReadError(new IOException(e));
                } catch (TimeoutException e12) {
                    e = e12;
                    this.f32843e.cancel(true);
                    uploadDataSink.onReadError(new IOException(e));
                }
            }

            private void o(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                try {
                    uploadDataSink.onReadSucceeded(m(byteBuffer).equals(UploadBodyDataBroker.ReadResult.END_OF_BODY));
                } catch (ExecutionException | TimeoutException e11) {
                    this.f32843e.cancel(true);
                    uploadDataSink.onReadError(new IOException(e11));
                }
            }

            @Override // org.chromium.net.UploadDataProvider
            public long getLength() {
                return this.f32839a.contentLength();
            }

            @Override // org.chromium.net.UploadDataProvider
            public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                h();
                if (getLength() == -1) {
                    o(uploadDataSink, byteBuffer);
                } else {
                    n(uploadDataSink, byteBuffer);
                }
            }

            @Override // org.chromium.net.UploadDataProvider
            public void rewind(UploadDataSink uploadDataSink) {
                uploadDataSink.onRewindError(new UnsupportedOperationException("Rewind is not supported!"));
            }
        }

        c(ExecutorService executorService) {
            this.f32838a = executorService;
        }

        @Override // com.google.net.cronet.okhttptransport.d
        public UploadDataProvider a(RequestBody requestBody, int i11) {
            return new a(requestBody, new UploadBodyDataBroker(), this.f32838a, i11, null);
        }
    }

    e(b bVar, c cVar) {
        this.f32830a = bVar;
        this.f32831b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e b(ExecutorService executorService) {
        return new e(new b(), new c(executorService));
    }

    @Override // com.google.net.cronet.okhttptransport.d
    public UploadDataProvider a(RequestBody requestBody, int i11) {
        long contentLength = requestBody.contentLength();
        return (contentLength == -1 || contentLength > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) ? this.f32831b.a(requestBody, i11) : this.f32830a.a(requestBody, i11);
    }
}
