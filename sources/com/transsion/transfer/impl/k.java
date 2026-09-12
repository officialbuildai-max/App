package com.transsion.transfer.impl;

import android.app.Application;
import android.os.Build;
import androidx.view.LiveData;
import iv.h;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class k extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final androidx.view.b0 f55879b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.view.b0 f55880c;

    /* renamed from: d, reason: collision with root package name */
    private final jv.b f55881d;

    /* renamed from: e, reason: collision with root package name */
    private final jv.b f55882e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.view.b0 f55883f;

    /* renamed from: g, reason: collision with root package name */
    private g f55884g;

    /* renamed from: h, reason: collision with root package name */
    private final g f55885h;

    /* renamed from: i, reason: collision with root package name */
    private final Function4 f55886i;

    /* renamed from: j, reason: collision with root package name */
    private final c f55887j;

    /* loaded from: classes6.dex */
    public static final class a implements Function4 {
        a() {
        }

        public void a(String clientIp, String transferId, boolean z10, String str) {
            Intrinsics.h(clientIp, "clientIp");
            Intrinsics.h(transferId, "transferId");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("invoke: clientIp:");
            sb2.append(clientIp);
            sb2.append(", transferId:");
            sb2.append(transferId);
            sb2.append(", isConnect:");
            sb2.append(z10);
            k.this.f55879b.n(new Pair(clientIp, Boolean.valueOf(z10)));
            if (z10) {
                return;
            }
            kv.b.f68518a.s(str, k.this.t());
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            a((String) obj, (String) obj2, ((Boolean) obj3).booleanValue(), (String) obj4);
            return Unit.f67184a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements g {
        b() {
        }

        @Override // com.transsion.transfer.impl.g
        public void a(String clientIp, String clientDeviceName) {
            Intrinsics.h(clientIp, "clientIp");
            Intrinsics.h(clientDeviceName, "clientDeviceName");
            k.this.f55880c.n(clientDeviceName);
            g gVar = k.this.f55884g;
            if (gVar != null) {
                gVar.a(clientIp, clientDeviceName);
            }
        }

        @Override // com.transsion.transfer.impl.g
        public String b() {
            return k.this.q();
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements i {
        c() {
        }

        @Override // com.transsion.transfer.impl.i
        public void K(String clientIp, String remoteFilePath, TaskState state, long j11, long j12) {
            Intrinsics.h(clientIp, "clientIp");
            Intrinsics.h(remoteFilePath, "remoteFilePath");
            Intrinsics.h(state, "state");
            k.this.f55881d.n(new Triple(clientIp, remoteFilePath, new Triple(state, Long.valueOf(j11), Long.valueOf(j12))));
        }

        @Override // com.transsion.transfer.impl.i
        public void d(String clientIp) {
            Intrinsics.h(clientIp, "clientIp");
            k.this.f55883f.n(clientIp);
        }

        @Override // com.transsion.transfer.impl.i
        public void h(String clientIp, String remoteFilePath, long j11, long j12) {
            Intrinsics.h(clientIp, "clientIp");
            Intrinsics.h(remoteFilePath, "remoteFilePath");
            k.this.f55881d.n(new Triple(clientIp, remoteFilePath, new Triple(TaskState.TRANSFERRING, Long.valueOf(j11), Long.valueOf(j12))));
        }

        @Override // com.transsion.transfer.impl.i
        public void m(String clientIp) {
            Intrinsics.h(clientIp, "clientIp");
        }

        @Override // com.transsion.transfer.impl.i
        public void n(String clientIp, List files) {
            Intrinsics.h(clientIp, "clientIp");
            Intrinsics.h(files, "files");
            k.this.f55882e.n(new Pair(clientIp, files));
        }

        @Override // com.transsion.transfer.impl.i
        public void p(String clientIp) {
            Intrinsics.h(clientIp, "clientIp");
            k.this.f55879b.n(new Pair(clientIp, Boolean.FALSE));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f55879b = new androidx.view.b0();
        this.f55880c = new androidx.view.b0();
        this.f55881d = new jv.b();
        this.f55882e = new jv.b();
        this.f55883f = new androidx.view.b0();
        this.f55885h = new b();
        this.f55886i = new a();
        this.f55887j = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String q() {
        String MODEL = Build.MODEL;
        Intrinsics.g(MODEL, "MODEL");
        return MODEL;
    }

    public final void A() {
        h b11 = iv.h.f65759s.b(b());
        b11.e(this.f55885h);
        b11.a(this.f55887j);
        b11.b(this.f55886i);
        b11.open();
        kv.b.f68518a.r();
    }

    public final void B(g gVar) {
        this.f55884g = gVar;
    }

    public final void C() {
        h b11 = iv.h.f65759s.b(b());
        b11.e(this.f55885h);
        b11.a(this.f55887j);
        b11.b(this.f55886i);
        b11.d();
    }

    public final boolean j() {
        h b11 = iv.h.f65759s.b(b());
        b11.e(this.f55885h);
        b11.a(this.f55887j);
        b11.b(this.f55886i);
        return !b11.c().isEmpty();
    }

    public final LiveData k() {
        return this.f55880c;
    }

    public final List l() {
        h b11 = iv.h.f65759s.b(b());
        b11.e(this.f55885h);
        b11.a(this.f55887j);
        b11.b(this.f55886i);
        return b11.c();
    }

    public final List m() {
        h b11 = iv.h.f65759s.b(b());
        b11.e(this.f55885h);
        b11.a(this.f55887j);
        b11.b(this.f55886i);
        return b11.i();
    }

    public final LiveData n() {
        return this.f55883f;
    }

    public final LiveData o() {
        return this.f55879b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.t0
    public void onCleared() {
        super.onCleared();
        h.a aVar = iv.h.f65759s;
        aVar.b(b()).g(this.f55887j);
        aVar.b(b()).h(this.f55886i);
        aVar.b(b()).e(null);
    }

    public final String p() {
        h b11 = iv.h.f65759s.b(b());
        b11.e(this.f55885h);
        b11.a(this.f55887j);
        b11.b(this.f55886i);
        List i11 = b11.i();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getCurClientName: getCurClientName:");
        sb2.append(i11);
        if (i11.isEmpty()) {
            return null;
        }
        return (String) i11.get(0);
    }

    public final Function4 r() {
        return this.f55886i;
    }

    public final int s() {
        return mv.b.f70138a.f().size();
    }

    public final String t() {
        h b11 = iv.h.f65759s.b(b());
        b11.e(this.f55885h);
        b11.b(this.f55886i);
        return b11.j();
    }

    public final LiveData u() {
        return this.f55882e;
    }

    public final LiveData v() {
        return this.f55881d;
    }

    public final int w() {
        mv.b bVar = mv.b.f70138a;
        return bVar.g().size() + bVar.h().size();
    }

    public final void x() {
        h b11 = iv.h.f65759s.b(b());
        b11.e(this.f55885h);
        b11.a(this.f55887j);
        b11.b(this.f55886i);
    }

    public final boolean y() {
        h b11 = iv.h.f65759s.b(b());
        b11.e(this.f55885h);
        b11.b(this.f55886i);
        return b11.isRunning();
    }

    public final void z(int i11) {
        h.a aVar = iv.h.f65759s;
        List c11 = aVar.b(b()).c();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("notifyClientCMD: clientIps:");
        sb2.append(c11);
        if (c11.isEmpty()) {
            return;
        }
        h b11 = aVar.b(b());
        b11.e(this.f55885h);
        b11.a(this.f55887j);
        b11.b(this.f55886i);
        b11.f((String) c11.get(0), i11);
    }
}
