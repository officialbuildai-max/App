package com.transsion.usercenter.profile.viewmodel;

import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import com.therouter.TheRouter;
import com.transsnet.loginapi.ILoginApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class UserProfileVideoViewModel extends t0 {

    /* renamed from: o, reason: collision with root package name */
    public static final a f57418o = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f57419a;

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f57420b;

    /* renamed from: c, reason: collision with root package name */
    private String f57421c;

    /* renamed from: d, reason: collision with root package name */
    private String f57422d;

    /* renamed from: e, reason: collision with root package name */
    private int f57423e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f57424f;

    /* renamed from: g, reason: collision with root package name */
    private final List f57425g;

    /* renamed from: h, reason: collision with root package name */
    private final b0 f57426h;

    /* renamed from: i, reason: collision with root package name */
    private final LiveData f57427i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f57428j;

    /* renamed from: k, reason: collision with root package name */
    private final b0 f57429k;

    /* renamed from: l, reason: collision with root package name */
    private final LiveData f57430l;

    /* renamed from: m, reason: collision with root package name */
    private final b0 f57431m;

    /* renamed from: n, reason: collision with root package name */
    private final LiveData f57432n;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UserProfileVideoViewModel() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f57419a = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: com.transsion.usercenter.profile.viewmodel.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tw.c n11;
                n11 = UserProfileVideoViewModel.n();
                return n11;
            }
        });
        this.f57420b = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: com.transsion.usercenter.profile.viewmodel.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi v11;
                v11 = UserProfileVideoViewModel.v();
                return v11;
            }
        });
        this.f57422d = "";
        this.f57423e = 12;
        this.f57424f = true;
        this.f57425g = new ArrayList();
        b0 b0Var = new b0(Boolean.FALSE);
        this.f57426h = b0Var;
        this.f57427i = b0Var;
        b0 b0Var2 = new b0();
        this.f57429k = b0Var2;
        this.f57430l = b0Var2;
        b0 b0Var3 = new b0(null);
        this.f57431m = b0Var3;
        this.f57432n = b0Var3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tw.c n() {
        return (tw.c) zg.c.f79537e.a().h(tw.c.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final tw.c o() {
        return (tw.c) this.f57419a.getValue();
    }

    private final ILoginApi r() {
        return (ILoginApi) this.f57420b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi v() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void x(boolean r16) {
        /*
            r15 = this;
            r7 = r15
            r2 = r16
            r0 = 1
            if (r2 == 0) goto Le
            androidx.lifecycle.b0 r1 = r7.f57426h
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r1.q(r3)
            goto L10
        Le:
            r7.f57428j = r0
        L10:
            java.lang.String r1 = r7.f57421c
            r3 = 0
            if (r1 != 0) goto L2b
            com.transsnet.loginapi.ILoginApi r1 = r15.r()
            if (r1 == 0) goto L2d
            com.transsnet.loginapi.bean.UserInfo r1 = r1.i()
            if (r1 == 0) goto L2d
            java.lang.String r1 = r1.getUserId()
            if (r1 == 0) goto L2d
            java.lang.String r1 = r1.toString()
        L2b:
            r5 = r1
            goto L2e
        L2d:
            r5 = r3
        L2e:
            if (r2 == 0) goto L34
            java.lang.String r1 = ""
        L32:
            r4 = r1
            goto L37
        L34:
            java.lang.String r1 = r7.f57422d
            goto L32
        L37:
            com.transsnet.loginapi.ILoginApi r1 = r15.r()
            if (r1 == 0) goto L4d
            com.transsnet.loginapi.bean.UserInfo r1 = r1.i()
            if (r1 == 0) goto L4d
            java.lang.String r1 = r1.getUserId()
            if (r1 == 0) goto L4d
            java.lang.String r3 = r1.toString()
        L4d:
            java.lang.String r1 = r7.f57421c
            r6 = 0
            if (r1 == 0) goto L63
            boolean r1 = kotlin.text.StringsKt.q0(r1)
            if (r1 == 0) goto L59
            goto L63
        L59:
            java.lang.String r1 = r7.f57421c
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r3)
            if (r1 == 0) goto L63
            r8 = r0
            goto L64
        L63:
            r8 = r6
        L64:
            lg.a$a r0 = lg.a.f68962a
            java.lang.String r1 = r7.f57421c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "requestPage isRefresh="
            r9.append(r10)
            r9.append(r2)
            java.lang.String r10 = ", isSelf="
            r9.append(r10)
            r9.append(r8)
            java.lang.String r10 = ", target="
            r9.append(r10)
            r9.append(r1)
            java.lang.String r1 = ", current="
            r9.append(r1)
            r9.append(r3)
            java.lang.String r1 = r9.toString()
            java.lang.String r3 = "UserProfileVideoVM"
            r0.c(r3, r1, r6)
            kotlinx.coroutines.n0 r9 = androidx.view.u0.a(r15)
            com.transsion.usercenter.profile.viewmodel.UserProfileVideoViewModel$requestPage$1 r12 = new com.transsion.usercenter.profile.viewmodel.UserProfileVideoViewModel$requestPage$1
            r6 = 0
            r0 = r12
            r1 = r15
            r2 = r16
            r3 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r13 = 3
            r14 = 0
            r10 = 0
            r11 = 0
            kotlinx.coroutines.i.d(r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.profile.viewmodel.UserProfileVideoViewModel.x(boolean):void");
    }

    public final LiveData p() {
        return this.f57432n;
    }

    public final LiveData q() {
        return this.f57430l;
    }

    public final LiveData s() {
        return this.f57427i;
    }

    public final void t(String str) {
        this.f57421c = str;
    }

    public final void u() {
        if (!this.f57424f || Intrinsics.c(this.f57426h.f(), Boolean.TRUE) || this.f57428j) {
            return;
        }
        lg.a.f68962a.c("UserProfileVideoVM", "loadMore start nextPage=" + this.f57422d, false);
        x(false);
    }

    public final void w() {
        if (Intrinsics.c(this.f57426h.f(), Boolean.TRUE) || this.f57428j) {
            return;
        }
        lg.a.f68962a.c("UserProfileVideoVM", "refresh start userId=" + this.f57421c, false);
        this.f57422d = "";
        this.f57424f = true;
        this.f57425g.clear();
        x(true);
    }
}
