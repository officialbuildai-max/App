package com.mbridge.msdk.foundation.same.net;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes5.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static volatile AtomicInteger f35486b = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f35487a;

    /* loaded from: classes5.dex */
    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("SocketThreadPool");
            return newThread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f35489a;

        b(c cVar) {
            this.f35489a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f35489a.a();
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private ByteBuffer f35491a;

        /* renamed from: b, reason: collision with root package name */
        private String f35492b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f35493c;

        /* renamed from: d, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.net.b f35494d;

        /* renamed from: e, reason: collision with root package name */
        private OutputStream f35495e;

        /* renamed from: f, reason: collision with root package name */
        private int f35496f;

        /* renamed from: g, reason: collision with root package name */
        private Socket f35497g;

        /* renamed from: h, reason: collision with root package name */
        private String f35498h;

        c(String str, int i11, String str2, boolean z10, com.mbridge.msdk.foundation.same.net.b bVar) {
            this.f35492b = str;
            this.f35496f = i11;
            this.f35498h = str2;
            this.f35493c = z10;
            this.f35494d = bVar;
        }

        private void a(String str) {
            if (this.f35494d != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "Unknown exception";
                }
                this.f35494d.onError(new com.mbridge.msdk.foundation.same.net.exception.a(13, new com.mbridge.msdk.foundation.same.net.toolbox.a(TTAdConstant.DEEPLINK_FALLBACK_CODE, str.getBytes(), null)));
            }
        }

        /* JADX WARN: Finally extract failed */
        /* JADX WARN: Removed duplicated region for block: B:107:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:109:0x00c2 A[Catch: all -> 0x0036, TryCatch #2 {all -> 0x0036, blocks: (B:3:0x0005, B:5:0x0025, B:9:0x003a, B:11:0x0088, B:12:0x009a, B:14:0x00b0, B:15:0x00eb, B:20:0x013b, B:23:0x0175, B:26:0x0183, B:41:0x01a3, B:53:0x01cb, B:66:0x01ec, B:68:0x01f0, B:79:0x01fd, B:87:0x027d, B:103:0x0267, B:106:0x027a, B:109:0x00c2, B:111:0x00c6, B:112:0x00d5, B:113:0x00cf, B:114:0x008e, B:117:0x0097, B:82:0x021c, B:83:0x022b, B:85:0x0231, B:86:0x0238, B:100:0x0225), top: B:2:0x0005, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:114:0x008e A[Catch: all -> 0x0036, TryCatch #2 {all -> 0x0036, blocks: (B:3:0x0005, B:5:0x0025, B:9:0x003a, B:11:0x0088, B:12:0x009a, B:14:0x00b0, B:15:0x00eb, B:20:0x013b, B:23:0x0175, B:26:0x0183, B:41:0x01a3, B:53:0x01cb, B:66:0x01ec, B:68:0x01f0, B:79:0x01fd, B:87:0x027d, B:103:0x0267, B:106:0x027a, B:109:0x00c2, B:111:0x00c6, B:112:0x00d5, B:113:0x00cf, B:114:0x008e, B:117:0x0097, B:82:0x021c, B:83:0x022b, B:85:0x0231, B:86:0x0238, B:100:0x0225), top: B:2:0x0005, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0088 A[Catch: all -> 0x0036, TryCatch #2 {all -> 0x0036, blocks: (B:3:0x0005, B:5:0x0025, B:9:0x003a, B:11:0x0088, B:12:0x009a, B:14:0x00b0, B:15:0x00eb, B:20:0x013b, B:23:0x0175, B:26:0x0183, B:41:0x01a3, B:53:0x01cb, B:66:0x01ec, B:68:0x01f0, B:79:0x01fd, B:87:0x027d, B:103:0x0267, B:106:0x027a, B:109:0x00c2, B:111:0x00c6, B:112:0x00d5, B:113:0x00cf, B:114:0x008e, B:117:0x0097, B:82:0x021c, B:83:0x022b, B:85:0x0231, B:86:0x0238, B:100:0x0225), top: B:2:0x0005, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x00b0 A[Catch: all -> 0x0036, TryCatch #2 {all -> 0x0036, blocks: (B:3:0x0005, B:5:0x0025, B:9:0x003a, B:11:0x0088, B:12:0x009a, B:14:0x00b0, B:15:0x00eb, B:20:0x013b, B:23:0x0175, B:26:0x0183, B:41:0x01a3, B:53:0x01cb, B:66:0x01ec, B:68:0x01f0, B:79:0x01fd, B:87:0x027d, B:103:0x0267, B:106:0x027a, B:109:0x00c2, B:111:0x00c6, B:112:0x00d5, B:113:0x00cf, B:114:0x008e, B:117:0x0097, B:82:0x021c, B:83:0x022b, B:85:0x0231, B:86:0x0238, B:100:0x0225), top: B:2:0x0005, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0138  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0187  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x019f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 740
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.f.c.a():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private static f f35500a = new f(null);
    }

    private f() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(), new ThreadPoolExecutor.DiscardPolicy());
        this.f35487a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    /* synthetic */ f(a aVar) {
        this();
    }

    public static f b() {
        return d.f35500a;
    }

    public String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr2, 0, 1024);
            if (read <= 0) {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public void a(String str, int i11, String str2, boolean z10, com.mbridge.msdk.foundation.same.net.b bVar) {
        this.f35487a.execute(new b(new c(str, i11, str2, z10, bVar)));
    }

    public byte[] a(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
