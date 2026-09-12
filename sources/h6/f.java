package h6;

import com.bykv.vk.openvk.Sj.Sj.sP.sP.uA;
import com.bytedance.sdk.component.sP.Sj.Zq;
import com.bytedance.sdk.component.sP.Sj.vS;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class f extends c {

    /* renamed from: c, reason: collision with root package name */
    private Zq f64503c;

    public f(Zq zq2, b bVar) {
        vS Jcg;
        this.f64503c = zq2;
        this.f64500a = new ArrayList();
        if (zq2 != null && (Jcg = zq2.Jcg()) != null) {
            for (int i11 = 0; i11 < Jcg.Sj(); i11++) {
                this.f64500a.add(new uA.c(Jcg.Sj(i11), Jcg.sP(i11)));
            }
        }
        this.f64501b = bVar;
    }

    @Override // h6.c
    public InputStream a() {
        return this.f64503c.vS().TKC();
    }

    @Override // h6.c
    public String b() {
        Zq zq2 = this.f64503c;
        return (zq2 == null || zq2.Dq() == null) ? "http/1.1" : this.f64503c.Dq().toString();
    }

    @Override // h6.c
    public int d() {
        return this.f64503c.TKC();
    }

    @Override // h6.c
    public String g(String str, String str2) {
        return e(str) != null ? e(str).f20370b : str2;
    }

    @Override // h6.c
    public List h() {
        return this.f64500a;
    }

    @Override // h6.c
    public boolean i() {
        return this.f64503c.TKC() >= 200 && this.f64503c.TKC() < 300;
    }

    @Override // h6.c
    public String j() {
        return f(this.f64503c.TKC());
    }
}
