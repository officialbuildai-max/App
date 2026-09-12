package com.transsion.baselib.kids;

import ak.o;
import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.therouter.TheRouter;
import com.transsion.baselib.report.launch.b;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;
import sm.f;

/* loaded from: classes5.dex */
public final class KidsAccountManager {

    /* renamed from: a, reason: collision with root package name */
    public static final KidsAccountManager f43340a = new KidsAccountManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Gson f43341b = new Gson();

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0609a f43342b = new C0609a(null);

        /* renamed from: a, reason: collision with root package name */
        private final int f43343a;

        /* renamed from: com.transsion.baselib.kids.KidsAccountManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0609a {
            private C0609a() {
            }

            public /* synthetic */ C0609a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(int i11) {
            this.f43343a = i11;
        }
    }

    private KidsAccountManager() {
    }

    private final String a() {
        UserInfo i11;
        ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
        String userId = (iLoginApi == null || (i11 = iLoginApi.i()) == null) ? null : i11.getUserId();
        return (userId == null || userId.length() == 0) ? "visitor" : userId;
    }

    private final boolean h(String str) {
        String value;
        Long x10;
        long h11 = b.f43424a.b().h(str, 0L);
        if (h11 == 0) {
            return false;
        }
        ConfigBean c11 = f.f75530c.a().c("pk_kids_dialog_suppress_duration", false);
        return System.currentTimeMillis() - h11 < ((c11 == null || (value = c11.getValue()) == null || (x10 = StringsKt.x(value)) == null) ? 604800000L : x10.longValue());
    }

    public static /* synthetic */ void n(KidsAccountManager kidsAccountManager, KidsProfile kidsProfile, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        kidsAccountManager.m(kidsProfile, z10);
    }

    public final void b() {
        b.f43424a.b().M("kids_profile");
        MMKV I = MMKV.I("kv_search_list");
        Intrinsics.g(I, "mmkvWithID(...)");
        I.M("kv_kids_search_work");
        I.M("kv_kids_search_group");
        a.C0856a.f(lg.a.f68962a, "KidsAccountManager", "deleteKidsProfile: profile and search history cleared", false, 4, null);
        a aVar = new a(2);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = a.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, aVar, 0L);
    }

    public final void c(KidsProfile profile) {
        Intrinsics.h(profile, "profile");
        a.C0856a.f(lg.a.f68962a, "KidsAccountManager", "enter kids mode.", false, 4, null);
        o.f721a.a(profile.getKidsId());
    }

    public final void d() {
        a.C0856a.f(lg.a.f68962a, "KidsAccountManager", "exit kids mode.", false, 4, null);
        o.f721a.b();
    }

    public final String e() {
        String d11 = o.f721a.d();
        if (d11 != null) {
            return d11;
        }
        KidsProfile f11 = f();
        if (f11 != null) {
            return f11.getKidsId();
        }
        return null;
    }

    public final KidsProfile f() {
        String k11 = b.f43424a.b().k("kids_profile");
        if (k11 == null) {
            return null;
        }
        return (KidsProfile) f43341b.fromJson(k11, KidsProfile.class);
    }

    public final boolean g() {
        return h("kids_create_dialog_dismiss_" + a());
    }

    public final boolean i() {
        KidsProfile f11 = f();
        if (f11 == null) {
            return false;
        }
        String pinHash = f11.getPinHash();
        return !(pinHash == null || pinHash.length() == 0);
    }

    public final boolean j() {
        return h("kids_switch_dialog_dismiss_" + a());
    }

    public final void k() {
        b.f43424a.b().t("kids_create_dialog_dismiss_" + a(), System.currentTimeMillis());
    }

    public final void l() {
        b.f43424a.b().t("kids_switch_dialog_dismiss_" + a(), System.currentTimeMillis());
    }

    public final void m(KidsProfile profile, boolean z10) {
        Intrinsics.h(profile, "profile");
        b.f43424a.b().v("kids_profile", f43341b.toJson(profile));
        if (z10) {
            a aVar = new a(1);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = a.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, aVar, 0L);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(12:5|6|7|8|(1:(1:11)(2:35|36))(3:37|38|(2:40|41)(2:42|(1:44)))|12|(4:14|(2:15|(2:17|(2:19|20)(1:31))(2:32|33))|21|(5:25|26|27|28|29))|34|26|27|28|29))|47|6|7|8|(0)(0)|12|(0)|34|26|27|28|29) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x002e, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cf, code lost:
    
        lg.a.f68962a.i("KidsAccountManager", "shouldShowAutoPopup error: " + r11.getMessage(), true);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0083 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:11:0x002a, B:12:0x007b, B:14:0x0083, B:15:0x0089, B:17:0x008f, B:21:0x00a2, B:23:0x00a6, B:25:0x00ac, B:26:0x00b2, B:38:0x003c, B:40:0x005b, B:42:0x0060), top: B:8:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.kids.KidsAccountManager.o(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void p(String pinHash) {
        KidsProfile copy;
        Intrinsics.h(pinHash, "pinHash");
        KidsProfile f11 = f();
        if (f11 == null) {
            return;
        }
        MMKV b11 = b.f43424a.b();
        Gson gson = f43341b;
        copy = f11.copy((r20 & 1) != 0 ? f11.kidsId : null, (r20 & 2) != 0 ? f11.name : null, (r20 & 4) != 0 ? f11.avatarResId : 0, (r20 & 8) != 0 ? f11.gender : null, (r20 & 16) != 0 ? f11.birthday : null, (r20 & 32) != 0 ? f11.pinHash : pinHash, (r20 & 64) != 0 ? f11.avatarLocalPath : null, (r20 & 128) != 0 ? f11.favorites : null, (r20 & 256) != 0 ? f11.age : null);
        b11.v("kids_profile", gson.toJson(copy));
    }

    public final boolean q(String inputPin) {
        Intrinsics.h(inputPin, "inputPin");
        KidsProfile f11 = f();
        if (f11 == null) {
            return false;
        }
        return Intrinsics.c(f11.getPinHash(), inputPin);
    }
}
