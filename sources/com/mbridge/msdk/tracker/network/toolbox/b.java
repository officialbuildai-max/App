package com.mbridge.msdk.tracker.network.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import com.mbridge.msdk.tracker.network.b0;
import com.mbridge.msdk.tracker.network.p;
import com.mbridge.msdk.tracker.network.q;
import com.mbridge.msdk.tracker.network.t;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class b implements com.mbridge.msdk.tracker.network.m {

    /* renamed from: a, reason: collision with root package name */
    private final a f38702a;

    /* renamed from: b, reason: collision with root package name */
    protected final c f38703b;

    public b(a aVar) {
        this(aVar, new c(4096));
    }

    public b(a aVar, c cVar) {
        this.f38702a = aVar;
        this.f38703b = cVar;
    }

    private static void a(p pVar, int i11) {
        if (pVar != null) {
            try {
                pVar.b(i11);
            } catch (Exception unused) {
            }
        }
    }

    private static void a(p pVar, int i11, Exception exc) {
        if (pVar != null) {
            try {
                pVar.a(exc);
                pVar.a(i11);
            } catch (Exception unused) {
            }
        }
    }

    private static p b(t<?> tVar) {
        if (tVar == null) {
            return null;
        }
        try {
            if (!tVar.a() || TextUtils.isEmpty(tVar.t())) {
                return null;
            }
            p pVar = new p(tVar.p(), tVar.g() == 0 ? "GET" : "POST");
            pVar.d("queue");
            pVar.e(tVar.d("local_id"));
            pVar.a(tVar.d("ad_type"));
            pVar.i(tVar.r());
            tVar.a(pVar);
            return pVar;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.mbridge.msdk.tracker.network.m
    public q a(t<?> tVar) throws b0 {
        IOException iOException;
        g gVar;
        byte[] bArr;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        p b11 = b(tVar);
        while (true) {
            Collections.emptyList();
            try {
                g a11 = this.f38702a.a(tVar, f.a(tVar.d()));
                try {
                    int d11 = a11.d();
                    a(b11, d11);
                    List<com.mbridge.msdk.tracker.network.g> c11 = a11.c();
                    if (d11 == 304) {
                        return k.a(tVar, SystemClock.elapsedRealtime() - elapsedRealtime, c11);
                    }
                    InputStream a12 = a11.a();
                    byte[] a13 = a12 != null ? k.a(a12, a11.b(), this.f38703b, b11) : new byte[0];
                    try {
                        k.a(SystemClock.elapsedRealtime() - elapsedRealtime, tVar, a13, d11);
                        if (d11 < 200 || d11 > 299) {
                            throw new IOException();
                        }
                        a(b11, 1, null);
                        return new q(d11, a13, false, SystemClock.elapsedRealtime() - elapsedRealtime, c11);
                    } catch (IOException e11) {
                        e = e11;
                        gVar = a11;
                        bArr = a13;
                        iOException = e;
                        a(b11, TextUtils.equals(iOException.getMessage(), "timeout") ? 3 : 2, iOException);
                        k.a(tVar, k.a(tVar, iOException, elapsedRealtime, gVar, bArr));
                    }
                } catch (IOException e12) {
                    e = e12;
                    bArr = null;
                    gVar = a11;
                }
            } catch (IOException e13) {
                iOException = e13;
                gVar = null;
                bArr = null;
            }
            a(b11, TextUtils.equals(iOException.getMessage(), "timeout") ? 3 : 2, iOException);
            k.a(tVar, k.a(tVar, iOException, elapsedRealtime, gVar, bArr));
        }
    }
}
