package n00;

import com.transsion.gslb.GslbSdk;

/* loaded from: classes7.dex */
public class l {

    /* renamed from: c, reason: collision with root package name */
    private static final l f70206c = new l();

    /* renamed from: a, reason: collision with root package name */
    private String f70207a = "https://ire-oneid.shalltry.com";

    /* renamed from: b, reason: collision with root package name */
    private String f70208b = "76iRl07s0xSN9jqmEWAt79EBJZulIQIsV64FZr2O";

    public static l d() {
        return f70206c;
    }

    public String a() {
        return GslbSdk.getDomain(this.f70207a, true) + "/one/v1/change";
    }

    public String b() {
        return this.f70208b;
    }

    public String c() {
        return this.f70207a;
    }

    public String e() {
        return GslbSdk.getDomain(this.f70207a, true) + "/one/v1/log";
    }

    public String f() {
        return GslbSdk.getDomain(this.f70207a, true) + "/one/v1/odid";
    }
}
