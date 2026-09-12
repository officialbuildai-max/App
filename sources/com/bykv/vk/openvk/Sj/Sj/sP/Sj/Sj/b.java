package com.bykv.vk.openvk.Sj.Sj.sP.Sj.Sj;

import android.content.Context;
import com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC;
import com.bytedance.sdk.component.sP.Sj.Fmk;
import com.bytedance.sdk.component.sP.Sj.Ym;
import com.bytedance.sdk.component.sP.Sj.sP;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class b implements com.bykv.vk.openvk.Sj.Sj.sP.Sj.Sj.a {

    /* renamed from: c, reason: collision with root package name */
    private File f20270c;

    /* renamed from: d, reason: collision with root package name */
    private File f20271d;

    /* renamed from: e, reason: collision with root package name */
    private long f20272e;

    /* renamed from: i, reason: collision with root package name */
    private RandomAccessFile f20276i;

    /* renamed from: j, reason: collision with root package name */
    private final TKC f20277j;

    /* renamed from: a, reason: collision with root package name */
    private volatile long f20268a = -2147483648L;

    /* renamed from: b, reason: collision with root package name */
    private final Object f20269b = new Object();

    /* renamed from: f, reason: collision with root package name */
    private volatile long f20273f = -1;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f20274g = false;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f20275h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements com.bytedance.sdk.component.sP.Sj.TKC {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00c0 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0079 A[SYNTHETIC] */
        @Override // com.bytedance.sdk.component.sP.Sj.TKC
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void Sj(com.bytedance.sdk.component.sP.Sj.sP r17, com.bytedance.sdk.component.sP.Sj.Zq r18) {
            /*
                Method dump skipped, instructions count: 455
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.Sj.Sj.sP.Sj.Sj.b.a.Sj(com.bytedance.sdk.component.sP.Sj.sP, com.bytedance.sdk.component.sP.Sj.Zq):void");
        }

        @Override // com.bytedance.sdk.component.sP.Sj.TKC
        public void Sj(sP sPVar, IOException iOException) {
            b.this.f20275h = false;
            b.this.f20268a = -1L;
        }
    }

    public b(Context context, TKC tkc) {
        this.f20272e = 0L;
        this.f20276i = null;
        this.f20277j = tkc;
        try {
            this.f20270c = c6.b.d(tkc.sP(), tkc.sef());
            this.f20271d = c6.b.c(tkc.sP(), tkc.sef());
            if (d()) {
                this.f20276i = new RandomAccessFile(this.f20271d, CampaignEx.JSON_KEY_AD_R);
            } else {
                this.f20276i = new RandomAccessFile(this.f20270c, "rw");
            }
            if (d()) {
                return;
            }
            this.f20272e = this.f20270c.length();
            i();
        } catch (Throwable unused) {
            tkc.Fmk();
        }
    }

    private boolean d() {
        return this.f20271d.exists();
    }

    private long e() {
        return d() ? this.f20271d.length() : this.f20270c.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        synchronized (this.f20269b) {
            if (d()) {
                this.f20277j.Fmk();
                this.f20277j.sef();
                return;
            }
            try {
            } finally {
            }
            if (!this.f20270c.renameTo(this.f20271d)) {
                throw new IOException("Error renaming file " + this.f20270c + " to " + this.f20271d + " for completion!");
            }
            RandomAccessFile randomAccessFile = this.f20276i;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.f20276i = new RandomAccessFile(this.f20271d, "rw");
            this.f20277j.sef();
            this.f20277j.Fmk();
        }
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.Sj.Sj.a
    public long TKC() {
        if (!d()) {
            synchronized (this.f20269b) {
                int i11 = 0;
                do {
                    try {
                        if (this.f20268a == -2147483648L) {
                            i11 += 15;
                            try {
                                this.f20269b.wait(5L);
                            } catch (InterruptedException unused) {
                                throw new IOException("total length InterruptException");
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                } while (i11 <= 20000);
                return -1L;
            }
        }
        this.f20268a = this.f20271d.length();
        return this.f20268a;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.Sj.Sj.a
    public int a(long j11, byte[] bArr, int i11, int i12) {
        try {
            if (j11 == this.f20268a) {
                return -1;
            }
            int i13 = 0;
            int i14 = 0;
            while (!this.f20274g) {
                synchronized (this.f20269b) {
                    try {
                        if (j11 < e()) {
                            this.f20276i.seek(j11);
                            i14 = this.f20276i.read(bArr, i11, i12);
                        } else {
                            i13 += 33;
                            this.f20269b.wait(33L);
                        }
                    } finally {
                    }
                }
                if (i14 > 0) {
                    return i14;
                }
                if (i13 >= 20000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th2) {
            if (th2 instanceof IOException) {
                throw th2;
            }
            throw new IOException();
        }
    }

    public void i() {
        Ym.Sj sP = t5.b.a() != null ? t5.b.a().sP() : new Ym.Sj("v_cache");
        long uvD = this.f20277j.uvD();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        sP.Sj(uvD, timeUnit).sP(this.f20277j.dNu(), timeUnit).TKC(this.f20277j.TzV(), timeUnit);
        Ym Sj = sP.Sj();
        this.f20277j.sef();
        Sj.Sj(new Fmk.Sj().Sj("RANGE", "bytes=" + this.f20272e + "-").sP(this.f20277j.Fmk()).Sj().Sj("videoLoadWhenPlaying").Sj(9).sP()).Sj(new a());
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.Sj.Sj.a
    public void sP() {
        try {
            if (!this.f20274g) {
                this.f20276i.close();
            }
            File file = this.f20270c;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.f20271d;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
        this.f20274g = true;
    }
}
