package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.exoplayer2.source.rtsp.u;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class u implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    public static final Charset f26542g = com.google.common.base.c.f30282c;

    /* renamed from: a, reason: collision with root package name */
    private final d f26543a;

    /* renamed from: b, reason: collision with root package name */
    private final Loader f26544b = new Loader("ExoPlayer:RtspMessageChannel:ReceiverLoader");

    /* renamed from: c, reason: collision with root package name */
    private final Map f26545c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d, reason: collision with root package name */
    private g f26546d;

    /* renamed from: e, reason: collision with root package name */
    private Socket f26547e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f26548f;

    /* loaded from: classes3.dex */
    public interface b {
        void f(byte[] bArr);
    }

    /* loaded from: classes3.dex */
    private final class c implements Loader.b {
        private c() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void j(f fVar, long j11, long j12, boolean z10) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void l(f fVar, long j11, long j12) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c n(f fVar, long j11, long j12, IOException iOException, int i11) {
            if (!u.this.f26548f) {
                u.this.f26543a.a(iOException);
            }
            return Loader.f27300f;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(Exception exc);

        void b(List list, Exception exc);

        void c(List list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private final List f26550a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private int f26551b = 1;

        /* renamed from: c, reason: collision with root package name */
        private long f26552c;

        private ImmutableList a(byte[] bArr) {
            com.google.android.exoplayer2.util.a.g(this.f26551b == 3);
            if (bArr.length <= 0 || bArr[bArr.length - 1] != 10) {
                throw new IllegalArgumentException("Message body is empty or does not end with a LF.");
            }
            this.f26550a.add((bArr.length <= 1 || bArr[bArr.length + (-2)] != 13) ? new String(bArr, 0, bArr.length - 1, u.f26542g) : new String(bArr, 0, bArr.length - 2, u.f26542g));
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.f26550a);
            e();
            return copyOf;
        }

        private ImmutableList b(byte[] bArr) {
            com.google.android.exoplayer2.util.a.a(bArr.length >= 2 && bArr[bArr.length - 2] == 13 && bArr[bArr.length - 1] == 10);
            String str = new String(bArr, 0, bArr.length - 2, u.f26542g);
            this.f26550a.add(str);
            int i11 = this.f26551b;
            if (i11 == 1) {
                if (!y.e(str)) {
                    return null;
                }
                this.f26551b = 2;
                return null;
            }
            if (i11 != 2) {
                throw new IllegalStateException();
            }
            long f11 = y.f(str);
            if (f11 != -1) {
                this.f26552c = f11;
            }
            if (!str.isEmpty()) {
                return null;
            }
            if (this.f26552c > 0) {
                this.f26551b = 3;
                return null;
            }
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.f26550a);
            e();
            return copyOf;
        }

        private static byte[] d(byte b11, DataInputStream dataInputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = {b11, dataInputStream.readByte()};
            byteArrayOutputStream.write(bArr);
            while (true) {
                if (bArr[0] == 13 && bArr[1] == 10) {
                    return byteArrayOutputStream.toByteArray();
                }
                bArr[0] = bArr[1];
                byte readByte = dataInputStream.readByte();
                bArr[1] = readByte;
                byteArrayOutputStream.write(readByte);
            }
        }

        private void e() {
            this.f26550a.clear();
            this.f26551b = 1;
            this.f26552c = 0L;
        }

        public ImmutableList c(byte b11, DataInputStream dataInputStream) {
            ImmutableList b12 = b(d(b11, dataInputStream));
            while (b12 == null) {
                if (this.f26551b == 3) {
                    long j11 = this.f26552c;
                    if (j11 <= 0) {
                        throw new IllegalStateException("Expects a greater than zero Content-Length.");
                    }
                    int d11 = Ints.d(j11);
                    com.google.android.exoplayer2.util.a.g(d11 != -1);
                    byte[] bArr = new byte[d11];
                    dataInputStream.readFully(bArr, 0, d11);
                    b12 = a(bArr);
                } else {
                    b12 = b(d(dataInputStream.readByte(), dataInputStream));
                }
            }
            return b12;
        }
    }

    /* loaded from: classes3.dex */
    private final class f implements Loader.d {

        /* renamed from: a, reason: collision with root package name */
        private final DataInputStream f26553a;

        /* renamed from: b, reason: collision with root package name */
        private final e f26554b = new e();

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f26555c;

        public f(InputStream inputStream) {
            this.f26553a = new DataInputStream(inputStream);
        }

        private void a() {
            int readUnsignedByte = this.f26553a.readUnsignedByte();
            int readUnsignedShort = this.f26553a.readUnsignedShort();
            byte[] bArr = new byte[readUnsignedShort];
            this.f26553a.readFully(bArr, 0, readUnsignedShort);
            b bVar = (b) u.this.f26545c.get(Integer.valueOf(readUnsignedByte));
            if (bVar == null || u.this.f26548f) {
                return;
            }
            bVar.f(bArr);
        }

        private void b(byte b11) {
            if (u.this.f26548f) {
                return;
            }
            u.this.f26543a.c(this.f26554b.c(b11, this.f26553a));
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void cancelLoad() {
            this.f26555c = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void load() {
            while (!this.f26555c) {
                byte readByte = this.f26553a.readByte();
                if (readByte == 36) {
                    a();
                } else {
                    b(readByte);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class g implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        private final OutputStream f26557a;

        /* renamed from: b, reason: collision with root package name */
        private final HandlerThread f26558b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f26559c;

        public g(OutputStream outputStream) {
            this.f26557a = outputStream;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:RtspMessageChannel:Sender");
            this.f26558b = handlerThread;
            handlerThread.start();
            this.f26559c = new Handler(handlerThread.getLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(byte[] bArr, List list) {
            try {
                this.f26557a.write(bArr);
            } catch (Exception e11) {
                if (u.this.f26548f) {
                    return;
                }
                u.this.f26543a.b(list, e11);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Handler handler = this.f26559c;
            final HandlerThread handlerThread = this.f26558b;
            Objects.requireNonNull(handlerThread);
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.x
                @Override // java.lang.Runnable
                public final void run() {
                    handlerThread.quit();
                }
            });
            try {
                this.f26558b.join();
            } catch (InterruptedException unused) {
                this.f26558b.interrupt();
            }
        }

        public void h(final List list) {
            final byte[] a11 = y.a(list);
            this.f26559c.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.w
                @Override // java.lang.Runnable
                public final void run() {
                    u.g.this.d(a11, list);
                }
            });
        }
    }

    public u(d dVar) {
        this.f26543a = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f26548f) {
            return;
        }
        try {
            g gVar = this.f26546d;
            if (gVar != null) {
                gVar.close();
            }
            this.f26544b.k();
            Socket socket = this.f26547e;
            if (socket != null) {
                socket.close();
            }
            this.f26548f = true;
        } catch (Throwable th2) {
            this.f26548f = true;
            throw th2;
        }
    }

    public void i(Socket socket) {
        this.f26547e = socket;
        this.f26546d = new g(socket.getOutputStream());
        this.f26544b.m(new f(socket.getInputStream()), new c(), 0);
    }

    public void k(int i11, b bVar) {
        this.f26545c.put(Integer.valueOf(i11), bVar);
    }

    public void l(List list) {
        com.google.android.exoplayer2.util.a.i(this.f26546d);
        this.f26546d.h(list);
    }
}
