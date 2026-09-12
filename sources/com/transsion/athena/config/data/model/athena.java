package com.transsion.athena.config.data.model;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class athena {

    /* renamed from: a, reason: collision with root package name */
    private int f42643a;

    /* renamed from: d, reason: collision with root package name */
    private long f42646d;

    /* renamed from: e, reason: collision with root package name */
    private int f42647e;

    /* renamed from: g, reason: collision with root package name */
    private String f42649g;

    /* renamed from: h, reason: collision with root package name */
    private String f42650h;

    /* renamed from: i, reason: collision with root package name */
    private int f42651i;

    /* renamed from: j, reason: collision with root package name */
    private int f42652j;

    /* renamed from: k, reason: collision with root package name */
    private String f42653k;

    /* renamed from: b, reason: collision with root package name */
    private long f42644b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f42645c = 0;

    /* renamed from: f, reason: collision with root package name */
    private final List<TidConfigBean> f42648f = new CopyOnWriteArrayList();

    @Nullable
    public static athena a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            athena athenaVar = new athena();
            athenaVar.f42644b = jSONObject.getLong("npt");
            athenaVar.f42645c = jSONObject.getInt("rt");
            athenaVar.f42646d = jSONObject.getLong("ver");
            athenaVar.f42647e = jSONObject.optInt("dim");
            athenaVar.f42650h = jSONObject.optString("url");
            athenaVar.f42653k = jSONObject.optString("url_config");
            athenaVar.f42649g = jSONObject.optString("opcode");
            athenaVar.f42651i = jSONObject.optInt("interval");
            athenaVar.f42652j = jSONObject.optInt(OfflineConstantsKt.OFFLINE);
            return athenaVar;
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }

    public TidConfigBean a(long j11) {
        for (TidConfigBean tidConfigBean : this.f42648f) {
            if (tidConfigBean.getTid() == j11) {
                return tidConfigBean;
            }
        }
        return null;
    }

    public void a(int i11) {
        this.f42643a = i11;
    }

    public void a(TidConfigBean tidConfigBean) {
        this.f42648f.add(tidConfigBean);
    }

    public boolean a() {
        return this.f42652j == 2;
    }

    public boolean a(long j11, int i11) {
        if (this.f42644b == -1 || j11 == -1) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j12 = currentTimeMillis - this.f42644b;
        if (Math.abs(j12) >= j11) {
            b(currentTimeMillis);
            return true;
        }
        if (j12 >= 0) {
            return this.f42645c < i11;
        }
        long j13 = this.f42644b;
        Calendar calendar = Calendar.getInstance();
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.add(5, 1);
        return j13 >= timeInMillis && j13 < calendar.getTimeInMillis();
    }

    public int b() {
        return this.f42643a;
    }

    public TidConfigBean b(String str) {
        for (TidConfigBean tidConfigBean : this.f42648f) {
            if (TextUtils.equals(tidConfigBean.getEvent(), str)) {
                return tidConfigBean;
            }
        }
        return null;
    }

    public void b(int i11) {
        this.f42647e = i11;
    }

    public void b(long j11) {
        this.f42644b = j11;
        this.f42645c = 0;
    }

    public String c() {
        String str = this.f42653k;
        return str == null ? "" : str;
    }

    public void c(int i11) {
        this.f42651i = i11;
    }

    public void c(long j11) {
        this.f42646d = j11;
    }

    public void c(String str) {
        this.f42653k = str;
    }

    public int d() {
        return this.f42647e;
    }

    public void d(int i11) {
        this.f42652j = i11;
    }

    public void d(String str) {
        this.f42649g = str;
    }

    public int e() {
        return this.f42651i;
    }

    public void e(int i11) {
        this.f42645c = i11;
    }

    public void e(String str) {
        this.f42650h = str;
    }

    public String f() {
        return this.f42649g;
    }

    public int g() {
        return this.f42645c;
    }

    public String h() {
        return this.f42650h;
    }

    public long i() {
        if (anehat.a(this.f42648f)) {
            return 0L;
        }
        return this.f42648f.get(0).getTidConfig().k();
    }

    public List<TidConfigBean> j() {
        return this.f42648f;
    }

    public long k() {
        return this.f42646d;
    }

    public boolean l() {
        return anehat.a(this.f42648f);
    }

    public String m() {
        try {
            return new JSONObject().put("npt", this.f42644b).put("rt", this.f42645c).put("ver", this.f42646d).put("dim", this.f42647e).put("url", this.f42650h).put("url_config", this.f42653k).put("interval", this.f42651i).put(OfflineConstantsKt.OFFLINE, this.f42652j).put("opcode", this.f42649g).toString();
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }
}
