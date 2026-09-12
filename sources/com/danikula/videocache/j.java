package com.danikula.videocache;

import java.io.OutputStream;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f24105a = Executors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    private final String f24106b;

    /* renamed from: c, reason: collision with root package name */
    private final int f24107c;

    /* loaded from: classes3.dex */
    private class a implements Callable {
        private a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(j.this.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, int i11) {
        this.f24106b = (String) l.c(str);
        this.f24107c = i11;
    }

    private List b() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e11) {
            throw new IllegalStateException(e11);
        }
    }

    private String c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.f24106b, Integer.valueOf(this.f24107c), "ping");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        h hVar = new h(c());
        try {
            try {
                byte[] bytes = "ping ok".getBytes();
                hVar.d(0L);
                byte[] bArr = new byte[bytes.length];
                hVar.f(bArr);
                boolean equals = Arrays.equals(bytes, bArr);
                q.c("Ping response: `" + new String(bArr) + "`, pinged? " + equals);
                return equals;
            } catch (ProxyCacheException unused) {
                q.b("Error reading ping response");
                hVar.a();
                return false;
            }
        } finally {
            hVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(String str) {
        return "ping".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(int i11, int i12) {
        l.a(i11 >= 1);
        l.a(i12 > 0);
        int i13 = 0;
        while (i13 < i11) {
            try {
            } catch (InterruptedException | ExecutionException unused) {
                q.b("Error pinging server due to unexpected error");
            } catch (TimeoutException unused2) {
                q.f("Error pinging server (attempt: " + i13 + ", timeout: " + i12 + "). ");
            }
            if (((Boolean) this.f24105a.submit(new a()).get(i12, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i13++;
            i12 *= 2;
        }
        q.b(String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i13), Integer.valueOf(i12 / 2), b()));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }
}
