package e6;

import android.content.Context;
import com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC;
import com.bytedance.sdk.component.sP.Sj.Fmk;
import com.bytedance.sdk.component.sP.Sj.Ym;
import com.bytedance.sdk.component.sP.Sj.sP;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import v5.a;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Context f61675a;

    /* renamed from: b, reason: collision with root package name */
    private TKC f61676b;

    /* renamed from: d, reason: collision with root package name */
    private File f61678d;

    /* renamed from: e, reason: collision with root package name */
    private File f61679e;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f61677c = false;

    /* renamed from: f, reason: collision with root package name */
    private final List f61680f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f61681g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements com.bytedance.sdk.component.sP.Sj.TKC {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f61682a;

        a(long j11) {
            this.f61682a = j11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0159 A[Catch: all -> 0x015e, TryCatch #6 {all -> 0x015e, blocks: (B:59:0x014c, B:61:0x0159, B:62:0x0160), top: B:58:0x014c }] */
        /* JADX WARN: Type inference failed for: r13v5 */
        @Override // com.bytedance.sdk.component.sP.Sj.TKC
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void Sj(com.bytedance.sdk.component.sP.Sj.sP r18, com.bytedance.sdk.component.sP.Sj.Zq r19) {
            /*
                Method dump skipped, instructions count: 419
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: e6.c.a.Sj(com.bytedance.sdk.component.sP.Sj.sP, com.bytedance.sdk.component.sP.Sj.Zq):void");
        }

        @Override // com.bytedance.sdk.component.sP.Sj.TKC
        public void Sj(sP sPVar, IOException iOException) {
            c cVar = c.this;
            cVar.h(cVar.f61676b, PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY, iOException.getMessage());
            b.b(c.this.f61676b);
        }
    }

    public c(Context context, TKC tkc) {
        this.f61678d = null;
        this.f61679e = null;
        this.f61675a = context;
        this.f61676b = tkc;
        this.f61678d = c6.b.d(tkc.sP(), tkc.sef());
        this.f61679e = c6.b.c(tkc.sP(), tkc.sef());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            this.f61679e.delete();
            this.f61678d.delete();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            if (this.f61678d.renameTo(this.f61679e)) {
                return;
            }
            throw new IOException("Error renaming file " + this.f61678d + " to " + this.f61679e + " for completion!");
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(TKC tkc, int i11) {
        synchronized (a.InterfaceC0973a.class) {
            try {
                for (a.InterfaceC0973a interfaceC0973a : this.f61680f) {
                    if (interfaceC0973a != null) {
                        interfaceC0973a.Sj(tkc, i11);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(TKC tkc, int i11, String str) {
        synchronized (a.InterfaceC0973a.class) {
            try {
                for (a.InterfaceC0973a interfaceC0973a : this.f61680f) {
                    if (interfaceC0973a != null) {
                        interfaceC0973a.Sj(tkc, i11, str);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    private void o() {
        Ym.Sj sP = t5.b.a() != null ? t5.b.a().sP() : new Ym.Sj("v_preload");
        long uvD = this.f61676b.uvD();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        sP.Sj(uvD, timeUnit).sP(this.f61676b.dNu(), timeUnit).TKC(this.f61676b.TzV(), timeUnit);
        Ym Sj = sP.Sj();
        Fmk.Sj sj2 = new Fmk.Sj();
        long length = this.f61678d.length();
        int TKC = this.f61676b.TKC();
        boolean TEQ = this.f61676b.TEQ();
        int Sj2 = this.f61676b.Sj();
        if (Sj2 > 0) {
            if (Sj2 >= this.f61676b.uA()) {
                TEQ = true;
            } else {
                TKC = Sj2;
            }
        }
        sj2.Sj("videoPreload").Sj(6);
        if (TEQ) {
            sj2.Sj("RANGE", "bytes=" + length + "-").sP(this.f61676b.Fmk()).Sj().sP();
        } else {
            sj2.Sj("RANGE", "bytes=" + length + "-" + TKC).sP(this.f61676b.Fmk()).Sj().sP();
        }
        Sj.Sj(sj2.sP()).Sj(new a(length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(TKC tkc, int i11) {
        synchronized (a.InterfaceC0973a.class) {
            try {
                for (a.InterfaceC0973a interfaceC0973a : this.f61680f) {
                    if (interfaceC0973a != null) {
                        interfaceC0973a.sP(tkc, i11);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private boolean t() {
        if (this.f61679e.exists()) {
            return true;
        }
        if (!this.f61676b.TEQ()) {
            if (this.f61678d.length() >= this.f61676b.TKC()) {
                return true;
            }
            if (this.f61676b.Sj() > 0 && this.f61678d.length() >= this.f61676b.Sj()) {
                return true;
            }
        }
        return false;
    }

    public TKC e() {
        return this.f61676b;
    }

    public void m(a.InterfaceC0973a interfaceC0973a) {
        if (this.f61681g) {
            synchronized (a.InterfaceC0973a.class) {
                this.f61680f.add(interfaceC0973a);
            }
            return;
        }
        this.f61680f.add(interfaceC0973a);
        if (t()) {
            this.f61676b.Jcg(1);
            g(this.f61676b, 200);
            b.b(this.f61676b);
        } else {
            this.f61681g = true;
            this.f61676b.Jcg(0);
            o();
        }
    }

    public void n(boolean z10) {
        this.f61677c = z10;
    }
}
