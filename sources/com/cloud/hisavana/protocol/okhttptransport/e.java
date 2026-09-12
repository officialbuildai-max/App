package com.cloud.hisavana.protocol.okhttptransport;

import android.support.v4.media.session.PlaybackStateCompat;
import com.cloud.hisavana.protocol.okhttptransport.UploadBodyDataBroker;
import com.cloud.hisavana.protocol.okhttptransport.e;
import com.google.common.base.s;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.m;
import com.google.common.util.concurrent.r;
import com.google.common.util.concurrent.t;
import com.google.common.util.concurrent.z;
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

/* loaded from: classes3.dex */
final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    private final b f21549a;

    /* renamed from: b, reason: collision with root package name */
    private final c f21550b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f21551a;

        static {
            int[] iArr = new int[UploadBodyDataBroker.ReadResult.values().length];
            f21551a = iArr;
            try {
                iArr[UploadBodyDataBroker.ReadResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21551a[UploadBodyDataBroker.ReadResult.END_OF_BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class b implements d {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a extends UploadDataProvider {

            /* renamed from: a, reason: collision with root package name */
            private volatile boolean f21552a = false;

            /* renamed from: b, reason: collision with root package name */
            private final Buffer f21553b = new Buffer();

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f21554c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RequestBody f21555d;

            a(long j11, RequestBody requestBody) {
                this.f21554c = j11;
                this.f21555d = requestBody;
            }

            @Override // org.chromium.net.UploadDataProvider
            public long getLength() {
                return this.f21554c;
            }

            @Override // org.chromium.net.UploadDataProvider
            public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                if (!this.f21552a) {
                    this.f21555d.writeTo(this.f21553b);
                    this.f21553b.flush();
                    this.f21552a = true;
                    long length = getLength();
                    long size = this.f21553b.size();
                    if (size != length) {
                        throw new IOException("Expected " + length + " bytes but got " + size);
                    }
                }
                if (this.f21553b.read(byteBuffer) == -1) {
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

        @Override // com.cloud.hisavana.protocol.okhttptransport.d
        public UploadDataProvider a(RequestBody requestBody, int i11) {
            long contentLength = requestBody.contentLength();
            if (contentLength >= 0 && contentLength <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                return new a(contentLength, requestBody);
            }
            throw new IOException("Expected definite length less than 1048576but got " + contentLength);
        }
    }

    /* loaded from: classes3.dex */
    static final class c implements d {

        /* renamed from: a, reason: collision with root package name */
        private final ExecutorService f21557a;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static class a extends UploadDataProvider {

            /* renamed from: a, reason: collision with root package name */
            private final RequestBody f21558a;

            /* renamed from: b, reason: collision with root package name */
            private final UploadBodyDataBroker f21559b;

            /* renamed from: c, reason: collision with root package name */
            private final t f21560c;

            /* renamed from: d, reason: collision with root package name */
            private final long f21561d;

            /* renamed from: e, reason: collision with root package name */
            private r f21562e;

            /* renamed from: f, reason: collision with root package name */
            private long f21563f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.cloud.hisavana.protocol.okhttptransport.e$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0303a implements m {
                C0303a() {
                }

                @Override // com.google.common.util.concurrent.m
                public void onFailure(Throwable th2) {
                    a.this.f21559b.i(th2);
                }

                @Override // com.google.common.util.concurrent.m
                public void onSuccess(Object obj) {
                }
            }

            private a(RequestBody requestBody, UploadBodyDataBroker uploadBodyDataBroker, ExecutorService executorService, long j11) {
                this.f21558a = requestBody;
                this.f21559b = uploadBodyDataBroker;
                if (executorService instanceof t) {
                    this.f21560c = (t) executorService;
                } else {
                    this.f21560c = MoreExecutors.b(executorService);
                }
                this.f21561d = j11 == 0 ? 2147483647L : j11;
            }

            /* synthetic */ a(RequestBody requestBody, UploadBodyDataBroker uploadBodyDataBroker, ExecutorService executorService, long j11, a aVar) {
                this(requestBody, uploadBodyDataBroker, executorService, j11);
            }

            private void h() {
                if (this.f21562e == null) {
                    r submit = this.f21560c.submit(new Callable() { // from class: com.cloud.hisavana.protocol.okhttptransport.f
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Void k11;
                            k11 = e.c.a.this.k();
                            return k11;
                        }
                    });
                    this.f21562e = submit;
                    Futures.a(submit, new C0303a(), MoreExecutors.a());
                }
            }

            private void i(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                byteBuffer.position(0);
                if (!m(byteBuffer).equals(UploadBodyDataBroker.ReadResult.END_OF_BODY)) {
                    throw l(getLength(), this.f21563f);
                }
                s.a(byteBuffer.position() == 0, "END_OF_BODY reads shouldn't write anything to the buffer", new Object[0]);
                byteBuffer.position(position);
                uploadDataSink.onReadSucceeded(false);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ Void k() {
                BufferedSink buffer = Okio.buffer(this.f21559b);
                this.f21558a.writeTo(buffer);
                buffer.flush();
                this.f21559b.h();
                return null;
            }

            private static IOException l(long j11, long j12) {
                return new IOException("Expected " + j11 + " bytes but got at least " + j12);
            }

            private UploadBodyDataBroker.ReadResult m(ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                UploadBodyDataBroker.ReadResult readResult = (UploadBodyDataBroker.ReadResult) z.b(this.f21559b.b(byteBuffer), this.f21561d, TimeUnit.MILLISECONDS);
                this.f21563f += byteBuffer.position() - position;
                return readResult;
            }

            private void n(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                try {
                    UploadBodyDataBroker.ReadResult m11 = m(byteBuffer);
                    if (this.f21563f > getLength()) {
                        throw l(getLength(), this.f21563f);
                    }
                    if (this.f21563f >= getLength()) {
                        i(uploadDataSink, byteBuffer);
                        return;
                    }
                    int i11 = a.f21551a[m11.ordinal()];
                    if (i11 == 1) {
                        uploadDataSink.onReadSucceeded(false);
                    } else if (i11 == 2) {
                        throw new IOException("The source has been exhausted but we expected more data!");
                    }
                } catch (ExecutionException e11) {
                    e = e11;
                    this.f21562e.cancel(true);
                    uploadDataSink.onReadError(new IOException(e));
                } catch (TimeoutException e12) {
                    e = e12;
                    this.f21562e.cancel(true);
                    uploadDataSink.onReadError(new IOException(e));
                }
            }

            private void o(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                try {
                    uploadDataSink.onReadSucceeded(m(byteBuffer).equals(UploadBodyDataBroker.ReadResult.END_OF_BODY));
                } catch (ExecutionException | TimeoutException e11) {
                    this.f21562e.cancel(true);
                    uploadDataSink.onReadError(new IOException(e11));
                }
            }

            @Override // org.chromium.net.UploadDataProvider
            public long getLength() {
                return this.f21558a.contentLength();
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
            this.f21557a = executorService;
        }

        @Override // com.cloud.hisavana.protocol.okhttptransport.d
        public UploadDataProvider a(RequestBody requestBody, int i11) {
            return new a(requestBody, new UploadBodyDataBroker(), this.f21557a, i11, null);
        }
    }

    e(b bVar, c cVar) {
        this.f21549a = bVar;
        this.f21550b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e b(ExecutorService executorService) {
        return new e(new b(), new c(executorService));
    }

    @Override // com.cloud.hisavana.protocol.okhttptransport.d
    public UploadDataProvider a(RequestBody requestBody, int i11) {
        long contentLength = requestBody.contentLength();
        return (contentLength == -1 || contentLength > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) ? this.f21550b.a(requestBody, i11) : this.f21549a.a(requestBody, i11);
    }
}
