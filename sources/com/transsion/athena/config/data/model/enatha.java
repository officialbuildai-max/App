package com.transsion.athena.config.data.model;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class enatha {

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f42684e;

    /* renamed from: j, reason: collision with root package name */
    private String f42689j;

    /* renamed from: n, reason: collision with root package name */
    private String f42693n;

    /* renamed from: a, reason: collision with root package name */
    private long f42680a = 86400000;

    /* renamed from: b, reason: collision with root package name */
    private long f42681b = 150000;

    /* renamed from: c, reason: collision with root package name */
    private boolean f42682c = true;

    /* renamed from: d, reason: collision with root package name */
    private String f42683d = "";

    /* renamed from: f, reason: collision with root package name */
    private long f42685f = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f42686g = -1;

    /* renamed from: h, reason: collision with root package name */
    private int f42687h = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f42688i = false;

    /* renamed from: k, reason: collision with root package name */
    private List<String> f42690k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    private List<byte[]> f42691l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private Pair<Integer, Integer> f42692m = new Pair<>(3, 6);

    /* renamed from: o, reason: collision with root package name */
    private int f42694o = 6;

    /* renamed from: p, reason: collision with root package name */
    private int f42695p = 10;

    @Nullable
    public static enatha a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                enatha enathaVar = new enatha();
                enathaVar.f42680a = jSONObject.getLong("pd");
                enathaVar.f42681b = jSONObject.getLong("th");
                enathaVar.f42682c = jSONObject.getBoolean("once");
                if (jSONObject.has("url")) {
                    enathaVar.f42683d = jSONObject.getString("url");
                }
                if (jSONObject.has("tidUrls")) {
                    enathaVar.f42684e = jSONObject.getJSONObject("tidUrls");
                }
                enathaVar.f42685f = jSONObject.getLong("version");
                enathaVar.f42686g = jSONObject.getLong("npt");
                enathaVar.f42687h = jSONObject.getInt("rt");
                enathaVar.f42688i = jSONObject.getBoolean("dd");
                enathaVar.f42689j = jSONObject.optString("ddv", null);
                if (jSONObject.has(TtmlNode.TAG_P)) {
                    enathaVar.a(jSONObject.getJSONArray(TtmlNode.TAG_P));
                }
                if (jSONObject.has("delays")) {
                    String[] split = jSONObject.getString("delays").split(",");
                    enathaVar.f42692m = new Pair<>(Integer.valueOf(Integer.parseInt(split[0])), Integer.valueOf(Integer.parseInt(split[1])));
                }
                if (jSONObject.has("tz")) {
                    enathaVar.f42693n = jSONObject.getString("tz");
                }
                int i11 = 6;
                int optInt = jSONObject.optInt("geo", 6);
                if (optInt > 0 && optInt < 12) {
                    i11 = optInt;
                }
                enathaVar.f42694o = i11;
                if (jSONObject.has("dlt")) {
                    enathaVar.f42695p = jSONObject.getInt("dlt");
                }
                return enathaVar;
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            }
        }
        return null;
    }

    public int a() {
        return this.f42694o;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(long r1) {
        /*
            r0 = this;
            java.lang.String r1 = java.lang.String.valueOf(r1)
            org.json.JSONObject r2 = r0.f42684e
            if (r2 == 0) goto L1d
            boolean r2 = r2.has(r1)
            if (r2 == 0) goto L1d
            org.json.JSONObject r2 = r0.f42684e     // Catch: java.lang.Exception -> L15
            java.lang.String r1 = r2.getString(r1)     // Catch: java.lang.Exception -> L15
            goto L1e
        L15:
            r1 = move-exception
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)
            com.transsion.athena.taaneh.aethna.b(r1)
        L1d:
            r1 = 0
        L1e:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L26
            java.lang.String r1 = r0.f42683d
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.config.data.model.enatha.a(long):java.lang.String");
    }

    public void a(int i11, int i12) {
        this.f42692m = new Pair<>(Integer.valueOf(i11), Integer.valueOf(i12));
    }

    public void a(String str) {
        this.f42689j = str;
    }

    public void a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        this.f42690k.clear();
        this.f42691l.clear();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            this.f42690k.add(jSONArray.getString(i11));
            this.f42691l.add(jSONArray.getString(i11).getBytes());
        }
    }

    public void a(boolean z10) {
        this.f42688i = z10;
    }

    public boolean a(int i11) {
        if (this.f42686g == -1 || this.f42680a == -1) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = currentTimeMillis - this.f42686g;
        if (Math.abs(j11) < this.f42680a) {
            return j11 >= 0 && this.f42687h < i11;
        }
        b(currentTimeMillis);
        return true;
    }

    public List<byte[]> b() {
        return this.f42691l;
    }

    public void b(int i11) {
        if (i11 <= 0 || i11 >= 12) {
            i11 = 6;
        }
        this.f42694o = i11;
    }

    public void b(long j11) {
        this.f42686g = j11;
        this.f42687h = 0;
    }

    public void b(String str) {
        this.f42693n = str;
    }

    public void b(JSONObject jSONObject) {
        this.f42684e = jSONObject;
    }

    public void b(boolean z10) {
        this.f42682c = z10;
    }

    public long c() {
        return this.f42680a;
    }

    public void c(int i11) {
        this.f42687h = i11;
    }

    public void c(long j11) {
        this.f42686g = j11;
    }

    public void c(String str) {
        this.f42683d = str;
    }

    public int d() {
        return this.f42687h;
    }

    public void d(int i11) {
        this.f42695p = i11;
    }

    public void d(long j11) {
        this.f42680a = j11;
    }

    public int e() {
        try {
            int intValue = ((Integer) this.f42692m.first).intValue();
            int intValue2 = ((Integer) this.f42692m.second).intValue();
            int i11 = com.transsion.athena.taaneh.anehat.f42857e;
            return new Random().nextInt((intValue2 - intValue) + 1) + intValue;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 6;
        }
    }

    public void e(long j11) {
        if (j11 <= 0) {
            return;
        }
        this.f42681b = j11;
    }

    public long f() {
        return this.f42681b;
    }

    public void f(long j11) {
        this.f42685f = j11;
    }

    public String g() {
        return TextUtils.isEmpty(this.f42693n) ? "Asia/Shanghai" : this.f42693n;
    }

    public int h() {
        return this.f42695p;
    }

    public long i() {
        return this.f42685f;
    }

    public JSONObject j() {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.f42690k.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            return new JSONObject().put("pd", this.f42680a).put("dlt", this.f42695p).put("th", this.f42681b).put("once", this.f42682c).put("url", this.f42683d).put("tidUrls", this.f42684e).put("version", this.f42685f).put("npt", this.f42686g).put("rt", this.f42687h).put("dd", this.f42688i).put("ddv", this.f42689j).put(TtmlNode.TAG_P, jSONArray).put("tz", this.f42693n).put("geo", this.f42694o).put("delays", this.f42692m.first + "," + this.f42692m.second);
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }
}
