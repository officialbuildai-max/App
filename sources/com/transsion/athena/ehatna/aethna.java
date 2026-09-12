package com.transsion.athena.ehatna;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.athena.data.Track;
import com.transsion.ga.AthenaAnalytics;
import k4.a;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class aethna {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile aethna f42761a;

    /* renamed from: b, reason: collision with root package name */
    private athena f42762b;

    /* renamed from: c, reason: collision with root package name */
    private String f42763c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f42764d;

    /* renamed from: e, reason: collision with root package name */
    private long f42765e = -1;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f42766f;

    private aethna() {
    }

    public static aethna b() {
        if (f42761a == null) {
            synchronized (aethna.class) {
                try {
                    if (f42761a == null) {
                        f42761a = new aethna();
                    }
                } finally {
                }
            }
        }
        return f42761a;
    }

    public long a(long j11, long j12) {
        if (!this.f42764d) {
            return j11;
        }
        athena athenaVar = this.f42762b;
        return (athenaVar.f42767a + j12) - athenaVar.f42768b;
    }

    public String a() {
        return this.f42763c;
    }

    public void a(Track track) {
        if (!this.f42764d) {
            if (TextUtils.isEmpty(this.f42763c)) {
                return;
            }
            track.setBootId(this.f42763c);
        } else {
            long trackErTs = this.f42762b.f42767a + (track.getTrackErTs() - this.f42762b.f42768b);
            if (trackErTs < 1633017600000L) {
                trackErTs = track.getTrackTs();
            }
            track.setTrackTs(trackErTs);
        }
    }

    public void a(boolean z10) {
        this.f42766f = z10;
        if (z10) {
            this.f42765e = SystemClock.elapsedRealtime();
        }
    }

    public boolean a(long j11) {
        this.f42766f = false;
        this.f42765e = -1L;
        if (j11 > 1633017600000L) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f42762b = new athena(j11, SystemClock.elapsedRealtime(), this.f42763c);
            if (Math.abs(currentTimeMillis - j11) > 600000) {
                this.f42764d = true;
            }
            try {
                if (!TextUtils.isEmpty(this.f42763c)) {
                    a a11 = a.a(AthenaAnalytics.J());
                    athena athenaVar = this.f42762b;
                    athenaVar.getClass();
                    a11.g("base_time", new JSONObject().put("serverTime", athenaVar.f42767a).put("elapsedRealtime", athenaVar.f42768b).put("bootId", athenaVar.f42769c).toString());
                }
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            }
        } else {
            this.f42762b = new athena(System.currentTimeMillis(), SystemClock.elapsedRealtime(), this.f42763c);
            this.f42764d = false;
        }
        return this.f42764d;
    }

    public long c() {
        athena athenaVar = this.f42762b;
        if (athenaVar != null) {
            return athenaVar.f42767a - athenaVar.f42768b;
        }
        return 0L;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|2|3|(1:5)|7|(5:8|9|10|11|12)|(5:14|15|16|17|(1:31)(2:21|(2:23|(2:25|26)(1:28))(2:29|30)))|36|37|38|17|(2:19|31)(1:32)|(2:(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0063, code lost:
    
        if (r2 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            r8 = this;
            java.lang.String r0 = "base_time"
            android.content.Context r1 = com.transsion.ga.AthenaAnalytics.J()     // Catch: java.lang.Exception -> L30
            k4.a r1 = k4.a.a(r1)     // Catch: java.lang.Exception -> L30
            java.lang.String r1 = r1.i(r0)     // Catch: java.lang.Exception -> L30
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L30
            r2.<init>()     // Catch: java.lang.Exception -> L30
            java.lang.String r3 = "baseTimeJs = "
            r2.append(r3)     // Catch: java.lang.Exception -> L30
            r2.append(r1)     // Catch: java.lang.Exception -> L30
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L30
            com.transsion.athena.taaneh.aethna.a(r2)     // Catch: java.lang.Exception -> L30
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L30
            if (r2 != 0) goto L38
            com.transsion.athena.ehatna.athena r2 = new com.transsion.athena.ehatna.athena     // Catch: java.lang.Exception -> L30
            r2.<init>(r1)     // Catch: java.lang.Exception -> L30
            r8.f42762b = r2     // Catch: java.lang.Exception -> L30
            goto L38
        L30:
            r1 = move-exception
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)
            com.transsion.athena.taaneh.aethna.b(r1)
        L38:
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L62
            java.lang.String r3 = "/proc/sys/kernel/random/boot_id"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L62
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L63
            int r4 = r2.read(r3)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L63
            if (r4 <= 0) goto L65
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L63
            r6 = 0
            r5.<init>(r3, r6, r4)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L63
            java.lang.String r3 = r5.trim()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L63
            r2.close()     // Catch: java.io.IOException -> L69
            goto L69
        L58:
            r0 = move-exception
            r1 = r2
            goto L5c
        L5b:
            r0 = move-exception
        L5c:
            if (r1 == 0) goto L61
            r1.close()     // Catch: java.io.IOException -> L61
        L61:
            throw r0
        L62:
            r2 = r1
        L63:
            if (r2 == 0) goto L68
        L65:
            r2.close()     // Catch: java.io.IOException -> L68
        L68:
            r3 = r1
        L69:
            r8.f42763c = r3
            com.transsion.athena.ehatna.athena r2 = r8.f42762b
            if (r2 == 0) goto Lb2
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto Lb2
            java.lang.String r2 = r8.f42763c
            com.transsion.athena.ehatna.athena r3 = r8.f42762b
            java.lang.String r3 = r3.f42769c
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto La3
            long r0 = java.lang.System.currentTimeMillis()
            com.transsion.athena.ehatna.athena r2 = r8.f42762b
            long r2 = r2.f42767a
            long r4 = android.os.SystemClock.elapsedRealtime()
            com.transsion.athena.ehatna.athena r6 = r8.f42762b
            long r6 = r6.f42768b
            long r4 = r4 - r6
            long r2 = r2 + r4
            long r2 = r2 - r0
            long r0 = java.lang.Math.abs(r2)
            r2 = 600000(0x927c0, double:2.964394E-318)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto Lb2
            r0 = 1
            r8.f42764d = r0
            goto Lb2
        La3:
            r8.f42762b = r1
            android.content.Context r1 = com.transsion.ga.AthenaAnalytics.J()
            k4.a r1 = k4.a.a(r1)
            java.lang.String r2 = ""
            r1.g(r0, r2)
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.ehatna.aethna.d():void");
    }

    public boolean e() {
        return this.f42766f;
    }

    public boolean f() {
        if (this.f42765e > 0 && SystemClock.elapsedRealtime() - this.f42765e > 60000) {
            return false;
        }
        athena athenaVar = this.f42762b;
        return athenaVar == null || !TextUtils.equals(athenaVar.f42769c, this.f42763c);
    }
}
