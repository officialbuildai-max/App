package com.transsion.usercenter.profile.viewmodel;

import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.therouter.TheRouter;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;

/* loaded from: classes6.dex */
public final class UserProfileViewModel extends t0 {

    /* renamed from: l, reason: collision with root package name */
    public static final a f57433l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f57434a = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.viewmodel.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi r11;
            r11 = UserProfileViewModel.r();
            return r11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f57435b = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.viewmodel.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsion.usercenter.profile.c t11;
            t11 = UserProfileViewModel.t();
            return t11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f57436c = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.viewmodel.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsion.usercenter.profile.b s11;
            s11 = UserProfileViewModel.s();
            return s11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final b0 f57437d;

    /* renamed from: e, reason: collision with root package name */
    private final LiveData f57438e;

    /* renamed from: f, reason: collision with root package name */
    private final b0 f57439f;

    /* renamed from: g, reason: collision with root package name */
    private final LiveData f57440g;

    /* renamed from: h, reason: collision with root package name */
    private final b0 f57441h;

    /* renamed from: i, reason: collision with root package name */
    private final LiveData f57442i;

    /* renamed from: j, reason: collision with root package name */
    private final b0 f57443j;

    /* renamed from: k, reason: collision with root package name */
    private final LiveData f57444k;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UserProfileViewModel() {
        b0 b0Var = new b0();
        this.f57437d = b0Var;
        this.f57438e = b0Var;
        b0 b0Var2 = new b0(Boolean.FALSE);
        this.f57439f = b0Var2;
        this.f57440g = b0Var2;
        b0 b0Var3 = new b0();
        this.f57441h = b0Var3;
        this.f57442i = b0Var3;
        b0 b0Var4 = new b0();
        this.f57443j = b0Var4;
        this.f57444k = b0Var4;
    }

    private final ILoginApi k() {
        return (ILoginApi) this.f57434a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.usercenter.profile.b l() {
        return (com.transsion.usercenter.profile.b) this.f57436c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.usercenter.profile.c m() {
        return (com.transsion.usercenter.profile.c) this.f57435b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi r() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.usercenter.profile.b s() {
        return (com.transsion.usercenter.profile.b) zg.c.f79537e.a().h(com.transsion.usercenter.profile.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.usercenter.profile.c t() {
        return (com.transsion.usercenter.profile.c) zg.c.f79537e.a().h(com.transsion.usercenter.profile.c.class);
    }

    public final void i(String targetUID) {
        Intrinsics.h(targetUID, "targetUID");
        k.d(u0.a(this), null, null, new UserProfileViewModel$fetchSubscriptionStatus$1(this, targetUID, null), 3, null);
    }

    public final void j(String str) {
        k.d(u0.a(this), null, null, new UserProfileViewModel$fetchUserProfileV3$1(this, str, null), 3, null);
    }

    public final LiveData n() {
        return this.f57442i;
    }

    public final LiveData o() {
        return this.f57444k;
    }

    public final void p(String str) {
        UserInfo i11;
        String userId;
        this.f57437d.q(str);
        ILoginApi k11 = k();
        String str2 = (k11 == null || (i11 = k11.i()) == null || (userId = i11.getUserId()) == null) ? null : userId.toString();
        boolean z10 = str == null || StringsKt.q0(str) || Intrinsics.c(str, str2);
        lg.a.f68962a.c("UserProfileVM", "initProfile target=" + str + ", current=" + str2 + ", isSelf=" + z10, false);
        this.f57439f.q(Boolean.valueOf(z10));
        j(str);
        if (z10 || str == null || StringsKt.q0(str)) {
            this.f57441h.q(null);
        } else {
            i(str);
        }
    }

    public final LiveData q() {
        return this.f57440g;
    }

    public final void u(String targetUID, boolean z10) {
        Intrinsics.h(targetUID, "targetUID");
        k.d(u0.a(this), null, null, new UserProfileViewModel$toggleSubscription$1(targetUID, z10, this, null), 3, null);
    }
}
