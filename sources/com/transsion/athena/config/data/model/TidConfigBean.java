package com.transsion.athena.config.data.model;

import android.util.Log;
import androidx.annotation.Nullable;
import com.transsion.ga.AthenaAnalytics;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class TidConfigBean {
    public static final int REASON_ATHENA_DISABLE = 100;
    public static final int REASON_CONFIG_NOT_READY = 102;
    public static final int REASON_DB_EXCEPTION = 106;
    public static final int REASON_INITIALIZING = 101;
    public static final int REASON_NONE = 0;
    public static final int REASON_SAMPLING_RATE = 105;
    public static final int REASON_TID_DISABLE = 104;
    public static final int REASON_TID_NOT_EXIST = 103;

    /* renamed from: a, reason: collision with root package name */
    private long f42620a;

    /* renamed from: b, reason: collision with root package name */
    private String f42621b;

    /* renamed from: c, reason: collision with root package name */
    private aatnhe f42622c;

    /* renamed from: d, reason: collision with root package name */
    private long f42623d;

    public TidConfigBean() {
        this.f42622c = new aatnhe();
    }

    public TidConfigBean(long j11, String str, aatnhe aatnheVar) {
        new aatnhe();
        this.f42620a = j11;
        this.f42621b = str;
        this.f42622c = aatnheVar;
    }

    @Nullable
    public static TidConfigBean fromJSON(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            TidConfigBean tidConfigBean = new TidConfigBean();
            tidConfigBean.setTid(jSONObject.getLong("tid"));
            tidConfigBean.setTidConfig(aatnhe.a(jSONObject.getJSONObject("tidConfig")));
            return tidConfigBean;
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }

    public boolean allowTrack(long j11) {
        return this.f42622c.b() == 0 || j11 >= this.f42623d + this.f42622c.b();
    }

    public boolean allowUpload(long j11) {
        long j12 = this.f42622c.j();
        long i11 = this.f42622c.i();
        if (j12 == -1 || i11 == -1) {
            return false;
        }
        boolean z10 = Math.abs(j11 - j12) >= i11;
        boolean z11 = this.f42622c.f() > 0 && this.f42622c.f() <= this.f42622c.a();
        int g11 = this.f42622c.g();
        if (g11 == 0 || (g11 == 1 && com.transsion.athena.taaneh.aatnhe.d(AthenaAnalytics.J()))) {
            return z10 || z11;
        }
        return false;
    }

    public String getEvent() {
        return this.f42621b;
    }

    public long getTid() {
        return this.f42620a;
    }

    public aatnhe getTidConfig() {
        return this.f42622c;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean inSamplingRange() {
        /*
            r10 = this;
            com.transsion.athena.config.data.model.aatnhe r0 = r10.f42622c
            int r0 = r0.d()
            com.transsion.athena.config.data.model.aatnhe r1 = r10.f42622c
            int r1 = r1.c()
            com.transsion.athena.config.data.model.aatnhe r2 = r10.f42622c
            int r2 = r2.e()
            com.transsion.athena.config.data.model.aatnhe r3 = r10.f42622c
            int r3 = r3.m()
            com.transsion.athena.config.data.model.aatnhe r4 = r10.f42622c
            int r4 = r4.l()
            r5 = 1
            r6 = 100
            if (r3 != r6) goto L2c
            if (r0 != 0) goto L2c
            if (r1 != r6) goto L2c
            if (r2 != r5) goto L2c
            if (r4 != r5) goto L2c
            return r5
        L2c:
            java.lang.String r7 = com.transsion.athena.taaneh.anehat.a()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L3b
            java.lang.String r7 = com.transsion.athena.taaneh.anehat.a()
            goto L43
        L3b:
            android.content.Context r7 = com.transsion.ga.AthenaAnalytics.J()
            java.lang.String r7 = com.transsion.athena.taaneh.athena.b(r7)
        L43:
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            r9 = 0
            if (r8 != 0) goto L5b
            int r2 = r2 * r6
            int r7 = r7.hashCode()
            int r7 = java.lang.Math.abs(r7)
            int r7 = r7 % r2
            if (r7 < r0) goto L59
            if (r7 > r1) goto L59
            goto L5b
        L59:
            r2 = r9
            goto L5c
        L5b:
            r2 = r5
        L5c:
            java.security.SecureRandom r7 = com.transsion.athena.aethna.athena.f42607b
            int r7 = r7.nextInt()
            int r7 = java.lang.Math.abs(r7)
            int r4 = r4 * r6
            int r7 = r7 % r4
            if (r7 >= r3) goto L6c
            r3 = r5
            goto L6d
        L6c:
            r3 = r9
        L6d:
            boolean r4 = com.transsion.athena.taaneh.anehat.b()
            if (r4 == 0) goto L9f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "gaidHashHit: "
            r4.append(r6)
            r4.append(r2)
            java.lang.String r6 = " eventHashHit: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r6 = " gmin = "
            r4.append(r6)
            r4.append(r0)
            java.lang.String r0 = " gmax = "
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            com.transsion.athena.taaneh.aethna.c(r0)
        L9f:
            if (r2 == 0) goto La4
            if (r3 == 0) goto La4
            goto La5
        La4:
            r5 = r9
        La5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.config.data.model.TidConfigBean.inSamplingRange():boolean");
    }

    public boolean isCacheEnable() {
        return this.f42622c.h() == 0;
    }

    public boolean isEnable() {
        aatnhe aatnheVar = this.f42622c;
        return aatnheVar != null && aatnheVar.i() >= 0;
    }

    public void setEvent(String str) {
        this.f42621b = str;
    }

    public void setLastTTime(long j11) {
        this.f42623d = j11;
    }

    public void setTid(long j11) {
        this.f42620a = j11;
    }

    public void setTidConfig(aatnhe aatnheVar) {
        this.f42622c = aatnheVar;
    }

    public JSONObject toJSON() {
        try {
            return new JSONObject().put("tid", getTid()).put("tidConfig", this.f42622c.n());
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }
}
