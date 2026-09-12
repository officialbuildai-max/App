package com.transsion.version.update;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.event.EventConstants;
import com.tencent.mmkv.MMKV;
import com.transsion.upgradesdk.manager.UpgradeSdkManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes7.dex */
public final class UpdateManager {

    /* renamed from: f, reason: collision with root package name */
    public static final a f57641f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static volatile UpdateManager f57642g;

    /* renamed from: a, reason: collision with root package name */
    private UpdateVersionRequest f57643a = new UpdateVersionRequest();

    /* renamed from: b, reason: collision with root package name */
    private final String f57644b = "TECNO";

    /* renamed from: c, reason: collision with root package name */
    private final String f57645c = "INFINIX";

    /* renamed from: d, reason: collision with root package name */
    private final String f57646d = "ITEL";

    /* renamed from: e, reason: collision with root package name */
    private final HashSet f57647e = SetsKt.g("TECNO", "INFINIX", "ITEL");

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UpdateManager a() {
            UpdateManager updateManager = UpdateManager.f57642g;
            if (updateManager == null) {
                synchronized (this) {
                    updateManager = new UpdateManager();
                    UpdateManager.f57642g = updateManager;
                }
            }
            return updateManager;
        }
    }

    private final boolean f() {
        d dVar = d.f57653a;
        boolean z10 = false;
        int i11 = dVar.b().getInt("key_last_installed_version_v2", 0);
        int f11 = com.blankj.utilcode.util.c.f();
        if (i11 != 0 && i11 < f11) {
            z10 = true;
        }
        if (z10) {
            dVar.b().putInt("key_last_installed_version_v2", f11);
        }
        return z10;
    }

    public static /* synthetic */ Object j(UpdateManager updateManager, Activity activity, String str, String str2, String str3, boolean z10, Continuation continuation, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            z10 = false;
        }
        return updateManager.i(activity, str, str2, str3, z10, continuation);
    }

    public final void c() {
        d dVar = d.f57653a;
        int i11 = dVar.b().getInt("key_last_installed_version_v2", 0);
        String string = dVar.b().getString("key_user_clicked_dialog_type", "");
        if (!f() || string == null || string.length() <= 0) {
            return;
        }
        dVar.b().remove("key_user_clicked_dialog_type");
        e.f57661a.b(MapsKt.l(TuplesKt.a(EventConstants.KEY_ACTION, "update_success"), TuplesKt.a("last_version", String.valueOf(i11)), TuplesKt.a("dialog_type", string)));
    }

    public final boolean d() {
        String str;
        Object obj;
        MMKV c11 = bh.a.f16551a.c();
        if (c11 == null || (str = c11.getString("phone_brand", Build.BRAND)) == null) {
            str = Build.BRAND;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        a.C0856a.f(lg.a.f68962a, "update", "brand " + str, false, 4, null);
        Intrinsics.e(str);
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.g(upperCase, "toUpperCase(...)");
        Iterator it = this.f57647e.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (StringsKt.W(upperCase, (String) next, false, 2, null)) {
                obj = next;
                break;
            }
        }
        return ((String) obj) != null;
    }

    public final void e(String appKey) {
        Intrinsics.h(appKey, "appKey");
        if (d()) {
            UpgradeSdkManager.getInstance().init(Utils.a(), appKey, false);
        }
    }

    public final boolean g() {
        return d.f57653a.b().getInt("target_version_code", 0) > com.blankj.utilcode.util.c.f();
    }

    public final void h(String str) {
        d dVar = d.f57653a;
        dVar.b().putString("showed_target_version_name", str);
        dVar.b().putInt("update_dialog_showed_times", dVar.b().getInt("update_dialog_showed_times", 0) + 1);
        dVar.b().putLong("update_dialog_show_timestamp", System.currentTimeMillis());
        a.C0856a.f(lg.a.f68962a, "update", "记录展示版本为 " + str + "已展示次数为 " + dVar.b().getInt("update_dialog_showed_times", 0), false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(android.app.Activity r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, boolean r14, kotlin.coroutines.Continuation r15) {
        /*
            r9 = this;
            boolean r0 = r15 instanceof com.transsion.version.update.UpdateManager$startCheckUpdate$1
            if (r0 == 0) goto L14
            r0 = r15
            com.transsion.version.update.UpdateManager$startCheckUpdate$1 r0 = (com.transsion.version.update.UpdateManager$startCheckUpdate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            com.transsion.version.update.UpdateManager$startCheckUpdate$1 r0 = new com.transsion.version.update.UpdateManager$startCheckUpdate$1
            r0.<init>(r9, r15)
            goto L12
        L1a:
            java.lang.Object r15 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.label
            r8 = 1
            if (r1 == 0) goto L33
            if (r1 != r8) goto L2b
            kotlin.ResultKt.b(r15)
            goto L48
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            kotlin.ResultKt.b(r15)
            com.transsion.version.update.UpdateVersionRequest r1 = r9.f57643a
            if (r1 == 0) goto L4b
            r7.label = r8
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            java.lang.Object r15 = r1.q(r2, r3, r4, r5, r6, r7)
            if (r15 != r0) goto L48
            return r0
        L48:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            goto L4c
        L4b:
            r15 = 0
        L4c:
            r9.c()
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.a(r8)
            boolean r10 = kotlin.jvm.internal.Intrinsics.c(r15, r10)
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.a(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.version.update.UpdateManager.i(android.app.Activity, java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
