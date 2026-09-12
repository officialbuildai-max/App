package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: classes3.dex */
class e extends m {

    /* renamed from: i, reason: collision with root package name */
    private b f24087i;

    /* renamed from: j, reason: collision with root package name */
    private final a f24088j;

    public e(a aVar) {
        super(aVar);
        this.f24088j = aVar;
    }

    private String i(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private String j(d dVar) {
        int i11;
        String str;
        String z10 = this.f24088j.z();
        boolean isEmpty = TextUtils.isEmpty(z10);
        long A = this.f24088j.A();
        long G = this.f24088j.G();
        long j11 = dVar.f24085b;
        boolean z11 = A >= 0;
        boolean z12 = dVar.f24086c;
        long j12 = z12 ? A - j11 : A;
        boolean z13 = z11 && z12;
        q.e("header， offset = " + j11 + ", rangeEnd = " + G + ", totalSize = " + A + ", contentLength = " + j12 + " , contentType = " + z10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(dVar.f24086c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb2.append("Accept-Ranges: bytes\n");
        String str2 = "";
        sb2.append(z11 ? i("Content-Length: %d\n", Long.valueOf(j12)) : "");
        if (z13) {
            i11 = 1;
            str = i("Content-Range: bytes %d-%d/%d\n", Long.valueOf(j11), Long.valueOf(G), Long.valueOf(A));
        } else {
            i11 = 1;
            str = "";
        }
        sb2.append(str);
        if (!isEmpty) {
            Object[] objArr = new Object[i11];
            objArr[0] = z10;
            str2 = i("Content-Type: %s\n", objArr);
        }
        sb2.append(str2);
        sb2.append("\n");
        return sb2.toString();
    }

    private void m(OutputStream outputStream, long j11, String str) {
        q.a("responseWithCache， offset = " + j11);
        byte[] bArr = new byte[8192];
        while (true) {
            int d11 = d(bArr, j11, 8192, str);
            if (d11 == -1 || this.f24113e) {
                break;
            }
            outputStream.write(bArr, 0, d11);
            j11 += d11;
        }
        outputStream.flush();
        q.e("responseWithCache， --------------------end,offset = " + j11 + "， threadName = " + Thread.currentThread().getName());
    }

    public void k(d dVar, Socket socket) {
        long j11 = dVar.f24085b;
        q.f("processRequest， offset = " + j11 + "， threadName = " + Thread.currentThread().getName());
        a(j11);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(j(dVar).getBytes("UTF-8"));
        m(bufferedOutputStream, j11, n.b(dVar.f24084a));
    }

    public void l(b bVar) {
        this.f24087i = bVar;
    }
}
