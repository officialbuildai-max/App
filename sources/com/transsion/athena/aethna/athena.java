package com.transsion.athena.aethna;

import android.os.Handler;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.athena.config.data.model.anateh;
import com.transsion.athena.config.data.model.anehat;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.config.data.model.enatha;
import java.security.SecureRandom;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class athena {

    /* renamed from: a, reason: collision with root package name */
    private static volatile athena f42606a;

    /* renamed from: b, reason: collision with root package name */
    public static SecureRandom f42607b = new SecureRandom();

    /* renamed from: c, reason: collision with root package name */
    private final com.transsion.athena.aethna.anehat.athena f42608c = com.transsion.athena.aethna.anehat.athena.a(com.transsion.athena.aethna.anehat.aethna.athena.b());

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f42609d;

    private athena() {
    }

    private boolean a(float f11) {
        if (f11 == 1.0f) {
            return true;
        }
        int i11 = (int) (10000.0f * f11);
        int abs = Math.abs(f42607b.nextInt()) % 10000;
        boolean z10 = abs < i11;
        com.transsion.athena.taaneh.aethna.a("checkSamplingRate false, samplingRate : %f, samplingRateInTenThousand : %d, randomHash : %d", Float.valueOf(f11), Integer.valueOf(i11), Integer.valueOf(abs));
        return z10;
    }

    public static athena c() {
        if (f42606a == null) {
            synchronized (athena.class) {
                try {
                    if (f42606a == null) {
                        f42606a = new athena();
                    }
                } finally {
                }
            }
        }
        return f42606a;
    }

    public int a(int i11, String str, float f11) {
        if (!this.f42609d) {
            com.transsion.athena.taaneh.aethna.a("isTidEnable init not completed");
            return 101;
        }
        if (!ehanat.r()) {
            com.transsion.athena.taaneh.aethna.a("isTidEnable sdk disable");
            return 100;
        }
        enatha b11 = this.f42608c.b().b();
        com.transsion.athena.config.data.model.athena a11 = this.f42608c.b().a(i11);
        if (anehat.a(b11.b()) || a11 == null || a11.l()) {
            if (!ehanat.p() || "location#page_view#athena_anr_full#athena_crash_full".contains(str)) {
                return 102;
            }
            return a(f11) ? 0 : 105;
        }
        TidConfigBean b12 = a11.b(str);
        if (b12 != null) {
            if (!b12.inSamplingRange()) {
                com.transsion.athena.taaneh.aethna.a("isTidEnable device is not in sampling range");
                return 105;
            }
            if (b12.isEnable()) {
                return 0;
            }
            com.transsion.athena.taaneh.aethna.a("isTidEnable tid config is closed");
            return 104;
        }
        try {
            if (!com.transsion.athena.taaneh.anehat.b()) {
                return 103;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SafeStringUtils.SP_APPID, i11);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
            com.transsion.athena.taaneh.aethna.b("invalid or not registered:%s", jSONObject.toString());
            return 103;
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b("checkTidEnable exception:%s", e11.getMessage());
            return 103;
        }
    }

    public int a(long j11, float f11) {
        if (!this.f42609d) {
            com.transsion.athena.taaneh.aethna.a("isTidEnable init not completed");
            return 101;
        }
        if (!ehanat.r()) {
            com.transsion.athena.taaneh.aethna.a("isTidEnable sdk disable");
            return 100;
        }
        enatha b11 = this.f42608c.b().b();
        anateh b12 = this.f42608c.b();
        b12.getClass();
        com.transsion.athena.config.data.model.athena a11 = b12.a(com.transsion.athena.taaneh.anehat.a(j11));
        if (anehat.a(b11.b()) || a11 == null || a11.l()) {
            if (ehanat.p()) {
                return a(f11) ? 0 : 105;
            }
            return 102;
        }
        TidConfigBean a12 = a11.a(j11);
        if (a12 == null) {
            com.transsion.athena.taaneh.aethna.a("isTidEnable tid config is null");
            return 103;
        }
        if (a12.inSamplingRange()) {
            if (a12.isEnable()) {
                return 0;
            }
            com.transsion.athena.taaneh.aethna.a("isTidEnable tid config is closed");
            return 104;
        }
        com.transsion.athena.taaneh.aethna.a("isTidEnable tid " + a12.getTid() + " is not in sampling range");
        return 105;
    }

    public TidConfigBean a(int i11, String str) {
        com.transsion.athena.config.data.model.athena a11 = this.f42608c.b().a(i11);
        if (a11 != null) {
            return a11.b(str);
        }
        return null;
    }

    public com.transsion.athena.config.data.model.aethna a(long j11) {
        return this.f42608c.a(j11);
    }

    public List<com.transsion.athena.config.data.model.athena> a() {
        return this.f42608c.a();
    }

    public void a(int i11) {
        this.f42608c.a(i11);
    }

    public void a(Handler handler, aethna aethnaVar) {
        this.f42608c.a(handler, aethnaVar);
    }

    public void a(com.transsion.athena.config.data.model.athena athenaVar, String str) {
        this.f42608c.a(athenaVar, str);
    }

    public void a(String str) {
        this.f42608c.a(str);
    }

    public void a(List<com.transsion.athena.config.data.model.athena> list) {
        this.f42608c.a(list);
    }

    public int b() {
        return this.f42608c.b().b().a();
    }

    public TidConfigBean b(long j11) {
        anateh b11 = this.f42608c.b();
        b11.getClass();
        com.transsion.athena.config.data.model.athena a11 = b11.a(com.transsion.athena.taaneh.anehat.a(j11));
        if (a11 == null) {
            return null;
        }
        for (TidConfigBean tidConfigBean : a11.j()) {
            if (tidConfigBean.getTid() == j11) {
                return tidConfigBean;
            }
        }
        return null;
    }

    public com.transsion.athena.config.data.model.athena b(int i11) {
        return this.f42608c.b().a(i11);
    }

    public List<TidConfigBean> c(int i11) {
        return this.f42608c.b(i11);
    }

    public List<byte[]> d() {
        return this.f42608c.b().b().b();
    }

    public int e() {
        return this.f42608c.b().b().e();
    }

    public String f() {
        return this.f42608c.b().b().g();
    }

    public int g() {
        return this.f42608c.b().b().h();
    }

    public void h() {
        this.f42608c.d();
        this.f42609d = true;
    }

    public Pair<Integer, byte[]> i() {
        return this.f42608c.e();
    }

    public void j() {
        this.f42608c.f();
    }

    public void k() {
        this.f42608c.g();
    }

    public void l() {
        this.f42608c.h();
    }
}
