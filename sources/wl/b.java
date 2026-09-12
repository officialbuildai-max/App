package wl;

import am.f;
import com.cloud.tmc.miniutils.constant.TimeConstants;
import com.transsion.http.impl.r;
import xl.h;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private zl.a f77823a = new zl.a();

    /* renamed from: b, reason: collision with root package name */
    private h f77824b;

    /* renamed from: c, reason: collision with root package name */
    private final am.e f77825c;

    public b(am.c cVar) {
        this.f77825c = cVar.c();
    }

    public void a(r rVar) {
        this.f77823a.a(this, rVar);
    }

    public h b() {
        if (this.f77825c.e() != null) {
            this.f77824b = new xl.c(this.f77825c.e()).a(a.f77822b <= 0 ? 104857600L : r1 * 1048576, a.f77821a <= 0 ? 864000000L : r3 * TimeConstants.HOUR);
        }
        return this.f77824b;
    }

    public am.e c() {
        return this.f77825c;
    }

    public f d() {
        return new f(this.f77825c);
    }
}
