package com.transsion.usercenter.profile;

import android.app.Application;
import androidx.view.LiveData;
import androidx.view.u0;
import com.therouter.TheRouter;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.usercenter.profile.b;
import com.transsion.usercenter.profile.bean.ProfileEntranceInfo;
import com.transsion.usercenter.profile.bean.ProfileInfo;
import com.transsnet.loginapi.ILoginApi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class ProfileViewModel extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f57218b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f57219c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.view.b0 f57220d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.view.b0 f57221e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.view.b0 f57222f;

    /* renamed from: g, reason: collision with root package name */
    private io.reactivex.rxjava3.disposables.c f57223g;

    /* loaded from: classes6.dex */
    public static final class a extends sg.a {
        a() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fetchEntrance: error:");
            sb2.append(str2);
            ProfileViewModel.this.l().q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(ProfileEntranceInfo profileEntranceInfo) {
            super.c(profileEntranceInfo);
            ProfileViewModel.this.l().q(profileEntranceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f57225a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProfileViewModel f57226b;

        b(String str, ProfileViewModel profileViewModel) {
            this.f57225a = str;
            this.f57226b = profileViewModel;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        
            if (kotlin.jvm.internal.Intrinsics.c(r0, (r2 == null || (r2 = r2.i()) == null) ? null : r2.getUserId()) != false) goto L15;
         */
        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final io.reactivex.rxjava3.core.m apply(java.lang.Throwable r4) {
            /*
                r3 = this;
                java.lang.String r0 = "it"
                kotlin.jvm.internal.Intrinsics.h(r4, r0)
                java.lang.String r0 = r3.f57225a
                r1 = 0
                if (r0 == 0) goto L2d
                int r0 = r0.length()
                if (r0 != 0) goto L11
                goto L2d
            L11:
                java.lang.String r0 = r3.f57225a
                com.transsion.usercenter.profile.ProfileViewModel r2 = r3.f57226b
                com.transsnet.loginapi.ILoginApi r2 = com.transsion.usercenter.profile.ProfileViewModel.f(r2)
                if (r2 == 0) goto L26
                com.transsnet.loginapi.bean.UserInfo r2 = r2.i()
                if (r2 == 0) goto L26
                java.lang.String r2 = r2.getUserId()
                goto L27
            L26:
                r2 = r1
            L27:
                boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r2)
                if (r0 == 0) goto L60
            L2d:
                com.transsion.usercenter.profile.e0 r0 = com.transsion.usercenter.profile.e0.f57253a
                com.tencent.mmkv.MMKV r0 = r0.b()
                java.lang.String r2 = "PROFILE_JSON"
                java.lang.String r0 = r0.getString(r2, r1)
                if (r0 == 0) goto L60
                int r1 = r0.length()
                if (r1 != 0) goto L42
                goto L60
            L42:
                java.lang.Class<com.transsion.usercenter.profile.bean.ProfileInfo> r1 = com.transsion.usercenter.profile.bean.ProfileInfo.class
                java.lang.Object r0 = com.blankj.utilcode.util.o.d(r0, r1)     // Catch: java.lang.Exception -> L5c
                com.transsion.usercenter.profile.bean.ProfileInfo r0 = (com.transsion.usercenter.profile.bean.ProfileInfo) r0     // Catch: java.lang.Exception -> L5c
                com.tn.lib.net.bean.BaseDto r1 = new com.tn.lib.net.bean.BaseDto     // Catch: java.lang.Exception -> L5c
                r1.<init>()     // Catch: java.lang.Exception -> L5c
                java.lang.String r2 = "0"
                r1.setCode(r2)     // Catch: java.lang.Exception -> L5c
                r1.setData(r0)     // Catch: java.lang.Exception -> L5c
                io.reactivex.rxjava3.core.j r4 = io.reactivex.rxjava3.core.j.t(r1)     // Catch: java.lang.Exception -> L5c
                return r4
            L5c:
                r0 = move-exception
                r0.printStackTrace()
            L60:
                io.reactivex.rxjava3.core.j r4 = io.reactivex.rxjava3.core.j.l(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.profile.ProfileViewModel.b.apply(java.lang.Throwable):io.reactivex.rxjava3.core.m");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c implements lz.f {

        /* renamed from: a, reason: collision with root package name */
        public static final c f57227a = new c();

        c() {
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto it) {
            Intrinsics.h(it, "it");
            ProfileInfo profileInfo = (ProfileInfo) it.getData();
            if (profileInfo != null) {
                e0.f57253a.b().putString("PROFILE_JSON", com.blankj.utilcode.util.o.j(profileInfo));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends sg.a {
        d() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            ProfileViewModel.this.f57220d.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(ProfileInfo profileInfo) {
            super.c(profileInfo);
            ProfileViewModel.this.f57220d.q(profileInfo);
        }

        @Override // sg.a, io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c d11) {
            Intrinsics.h(d11, "d");
            super.onSubscribe(d11);
            ProfileViewModel.this.f57223g = d11;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f57218b = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.m0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi q11;
                q11 = ProfileViewModel.q();
                return q11;
            }
        });
        this.f57219c = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.n0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b r11;
                r11 = ProfileViewModel.r();
                return r11;
            }
        });
        this.f57220d = new androidx.view.b0();
        this.f57221e = new androidx.view.b0();
        this.f57222f = new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILoginApi n() {
        return (ILoginApi) this.f57218b.getValue();
    }

    private final com.transsion.usercenter.profile.b o() {
        return (com.transsion.usercenter.profile.b) this.f57219c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi q() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.usercenter.profile.b r() {
        return (com.transsion.usercenter.profile.b) zg.c.f79537e.a().h(com.transsion.usercenter.profile.b.class);
    }

    public final void i() {
        b.a.g(o(), null, 1, null).v(qz.a.c()).f(sg.d.f75472a.c()).subscribe(new a());
    }

    public final void j() {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ProfileViewModel$fetchLatestDownloadList$1(this, null), 3, null);
    }

    public final void k(String str) {
        io.reactivex.rxjava3.disposables.c cVar;
        io.reactivex.rxjava3.disposables.c cVar2 = this.f57223g;
        if (cVar2 != null && !cVar2.isDisposed() && (cVar = this.f57223g) != null) {
            cVar.dispose();
        }
        b.a.h(o(), str == null ? "" : str, null, 2, null).v(qz.a.c()).x(new b(str, this)).h(c.f57227a).f(sg.d.f75472a.c()).subscribe(new d());
    }

    public final androidx.view.b0 l() {
        return this.f57222f;
    }

    public final LiveData m() {
        return this.f57221e;
    }

    public final LiveData p() {
        return this.f57220d;
    }
}
