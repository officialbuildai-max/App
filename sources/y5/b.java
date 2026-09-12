package y5;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;
import w5.c;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f79027a;

    /* renamed from: b, reason: collision with root package name */
    private int f79028b;

    /* renamed from: c, reason: collision with root package name */
    private long f79029c;

    /* renamed from: d, reason: collision with root package name */
    private double f79030d;

    /* renamed from: e, reason: collision with root package name */
    private String f79031e;

    /* renamed from: f, reason: collision with root package name */
    private String f79032f;

    /* renamed from: g, reason: collision with root package name */
    private String f79033g;

    /* renamed from: h, reason: collision with root package name */
    private String f79034h;

    /* renamed from: i, reason: collision with root package name */
    private String f79035i;

    /* renamed from: j, reason: collision with root package name */
    private String f79036j;

    /* renamed from: k, reason: collision with root package name */
    private double f79037k;

    /* renamed from: l, reason: collision with root package name */
    private int f79038l;

    /* renamed from: m, reason: collision with root package name */
    private int f79039m;

    /* renamed from: n, reason: collision with root package name */
    private float f79040n = -1.0f;

    /* renamed from: o, reason: collision with root package name */
    private int f79041o = 0;

    /* renamed from: p, reason: collision with root package name */
    private int f79042p = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f79043q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f79044r = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f79045s = 307200;

    /* renamed from: t, reason: collision with root package name */
    private int f79046t = 1;

    public int A() {
        return this.f79044r;
    }

    public boolean B() {
        return this.f79043q == 0;
    }

    public int C() {
        return this.f79027a;
    }

    public void D(int i11) {
        this.f79027a = i11;
    }

    public void E(String str) {
        this.f79032f = str;
    }

    public int F() {
        return this.f79042p;
    }

    public String G() {
        if (TextUtils.isEmpty(this.f79036j)) {
            this.f79036j = c.a(this.f79033g);
        }
        return this.f79036j;
    }

    public String H() {
        return this.f79031e;
    }

    public void I(int i11) {
        this.f79042p = i11;
    }

    public int J() {
        return this.f79043q;
    }

    public double K() {
        return this.f79030d;
    }

    public void L(int i11) {
        this.f79043q = i11;
    }

    public void M(String str) {
        this.f79036j = str;
    }

    public int N() {
        return this.f79046t;
    }

    public float a() {
        return this.f79040n;
    }

    public void b(int i11) {
        this.f79041o = i11;
    }

    public int c() {
        return this.f79039m;
    }

    public void d(int i11) {
        this.f79039m = i11;
    }

    public void e(String str) {
        this.f79034h = str;
    }

    public String f() {
        return this.f79035i;
    }

    public long g() {
        return this.f79029c;
    }

    public void h(int i11) {
        this.f79045s = i11;
    }

    public void i(String str) {
        this.f79035i = str;
    }

    public double j() {
        return this.f79037k;
    }

    public void k(int i11) {
        this.f79044r = i11;
    }

    public int l() {
        return this.f79041o;
    }

    public int m() {
        return this.f79038l;
    }

    public void n(double d11) {
        this.f79030d = d11;
    }

    public void o(int i11) {
        this.f79038l = i11;
    }

    public void p(long j11) {
        this.f79029c = j11;
    }

    public void q(String str) {
        this.f79031e = str;
    }

    public String r() {
        return this.f79032f;
    }

    public void s(int i11) {
        this.f79046t = Math.min(4, Math.max(1, i11));
    }

    public int t() {
        return this.f79028b;
    }

    public void u(int i11) {
        this.f79028b = i11;
    }

    public void v(String str) {
        this.f79033g = str;
    }

    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", C());
            jSONObject.put("cover_url", r());
            jSONObject.put("cover_width", t());
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, z());
            jSONObject.put("file_hash", G());
            jSONObject.put("resolution", H());
            jSONObject.put("size", g());
            jSONObject.put("video_duration", K());
            jSONObject.put(CampaignEx.JSON_KEY_VIDEO_URL, x());
            jSONObject.put("playable_download_url", f());
            jSONObject.put("if_playable_loading_show", l());
            jSONObject.put("remove_loading_page_type", F());
            jSONObject.put("fallback_endcard_judge", m());
            jSONObject.put("video_preload_size", y());
            jSONObject.put("reward_video_cached_type", J());
            jSONObject.put("execute_cached_type", A());
            jSONObject.put("endcard_render", c());
            jSONObject.put("replay_time", N());
            jSONObject.put("play_speed_ratio", a());
            if (j() > 0.0d) {
                jSONObject.put("start", j());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String x() {
        return this.f79033g;
    }

    public int y() {
        if (this.f79045s < 0) {
            this.f79045s = 307200;
        }
        long j11 = this.f79045s;
        long j12 = this.f79029c;
        if (j11 > j12) {
            this.f79045s = (int) j12;
        }
        return this.f79045s;
    }

    public String z() {
        return this.f79034h;
    }
}
