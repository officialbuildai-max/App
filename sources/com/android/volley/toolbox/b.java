package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Request;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class b implements com.android.volley.f {

    /* renamed from: a, reason: collision with root package name */
    protected final f f19365a;

    /* renamed from: b, reason: collision with root package name */
    private final a f19366b;

    /* renamed from: c, reason: collision with root package name */
    protected final ByteArrayPool f19367c;

    public b(a aVar) {
        this(aVar, new ByteArrayPool(4096));
    }

    public b(a aVar, ByteArrayPool byteArrayPool) {
        this.f19366b = aVar;
        this.f19365a = aVar;
        this.f19367c = byteArrayPool;
    }

    @Override // com.android.volley.f
    public com.android.volley.g a(Request request) {
        IOException iOException;
        e eVar;
        byte[] bArr;
        e a11;
        int d11;
        List c11;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                a11 = this.f19366b.a(request, d.c(request.getCacheEntry()));
                try {
                    d11 = a11.d();
                    c11 = a11.c();
                    break;
                } catch (IOException e11) {
                    bArr = null;
                    eVar = a11;
                    iOException = e11;
                }
            } catch (IOException e12) {
                iOException = e12;
                eVar = null;
                bArr = null;
            }
            l.a(request, l.e(request, iOException, elapsedRealtime, eVar, bArr));
        }
        if (d11 == 304) {
            return l.b(request, SystemClock.elapsedRealtime() - elapsedRealtime, c11);
        }
        InputStream a12 = a11.a();
        byte[] c12 = a12 != null ? l.c(a12, a11.b(), this.f19367c) : new byte[0];
        l.d(SystemClock.elapsedRealtime() - elapsedRealtime, request, c12, d11);
        if (d11 < 200 || d11 > 299) {
            throw new IOException();
        }
        return new com.android.volley.g(d11, c12, false, SystemClock.elapsedRealtime() - elapsedRealtime, c11);
    }
}
