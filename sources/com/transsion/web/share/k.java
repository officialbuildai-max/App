package com.transsion.web.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.view.u;
import com.cloud.tmc.integration.utils.share.config.ShareConstant;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.web.R$string;
import com.transsion.web.fragment.WebFragmentV2;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kr.p;
import lg.a;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f58250a;

    /* renamed from: b, reason: collision with root package name */
    private final Function2 f58251b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.activity.result.b f58252c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f58253d;

    /* renamed from: e, reason: collision with root package name */
    private long f58254e;

    /* renamed from: f, reason: collision with root package name */
    private final String f58255f;

    /* renamed from: g, reason: collision with root package name */
    private final String f58256g;

    /* renamed from: h, reason: collision with root package name */
    private final String f58257h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.activity.result.a f58258i;

    /* renamed from: j, reason: collision with root package name */
    private String f58259j;

    /* loaded from: classes7.dex */
    public static final class a implements androidx.view.f {
        a() {
        }

        @Override // androidx.view.f
        public /* synthetic */ void onCreate(u uVar) {
            androidx.view.e.a(this, uVar);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onDestroy(u uVar) {
            androidx.view.e.b(this, uVar);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onPause(u uVar) {
            androidx.view.e.c(this, uVar);
        }

        @Override // androidx.view.f
        public void onResume(u owner) {
            Intrinsics.h(owner, "owner");
            androidx.view.e.d(this, owner);
            k.this.f58254e = 0L;
        }

        @Override // androidx.view.f
        public /* synthetic */ void onStart(u uVar) {
            androidx.view.e.e(this, uVar);
        }

        @Override // androidx.view.f
        public void onStop(u owner) {
            Intrinsics.h(owner, "owner");
            androidx.view.e.f(this, owner);
            if (com.blankj.utilcode.util.c.l()) {
                return;
            }
            k.this.f58254e = SystemClock.elapsedRealtime();
        }
    }

    public k(Fragment fragment, Function2 shareCallback) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(shareCallback, "shareCallback");
        this.f58250a = fragment;
        this.f58251b = shareCallback;
        this.f58255f = "fail";
        this.f58256g = "cancel";
        this.f58257h = NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS;
        androidx.activity.result.a aVar = new androidx.activity.result.a() { // from class: com.transsion.web.share.j
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                k.n(k.this, (ActivityResult) obj);
            }
        };
        this.f58258i = aVar;
        this.f58252c = fragment.registerForActivityResult(new f.j(), aVar);
        fragment.getLifecycle().a(new a());
        this.f58259j = "";
    }

    private final Intent f(Context context, String str, String str2, String str3) {
        String g11 = g(context, str2, str3);
        if (g11 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(ShareConstant.SHARE_TYPE_TEXT);
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setPackage(g11);
        return intent;
    }

    private final String g(Context context, String str, String str2) {
        if (str != null && com.transsion.baseui.util.a.f43556a.c(context, str)) {
            return str;
        }
        if (str2 == null || !com.transsion.baseui.util.a.f43556a.c(context, str2)) {
            return null;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(k kVar, boolean z10) {
        if (z10) {
            kVar.m(kVar.f58257h);
        } else {
            kVar.m(kVar.f58255f);
            com.tn.lib.widget.toast.core.h.f41533a.k(R$string.web_app_not_exist);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(k kVar, boolean z10) {
        if (z10) {
            kVar.m(kVar.f58257h);
        } else {
            kVar.m(kVar.f58255f);
            com.tn.lib.widget.toast.core.h.f41533a.k(R$string.web_app_not_exist);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Context context, k kVar, String packageName, String str, String txt) {
        Object m1185constructorimpl;
        Unit unit;
        Intrinsics.h(packageName, "packageName");
        Intrinsics.h(txt, "txt");
        if (packageName.length() == 0) {
            ClipData newPlainText = ClipData.newPlainText("MovieBox", txt);
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
            }
            com.tn.lib.widget.toast.core.h.f41533a.k(R$string.web_copied);
            kVar.m(kVar.f58257h);
        } else {
            Intent f11 = kVar.f(context, txt, packageName, str);
            if (f11 == null) {
                com.tn.lib.widget.toast.core.h.f41533a.k(R$string.web_app_not_exist);
                kVar.m(kVar.f58255f);
            } else {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    androidx.activity.result.b bVar = kVar.f58252c;
                    if (bVar != null) {
                        bVar.a(f11);
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    m1185constructorimpl = Result.m1185constructorimpl(unit);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
                }
                if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
                    kVar.m(kVar.f58255f);
                    m1185constructorimpl = Unit.f67184a;
                }
            }
        }
        return Unit.f67184a;
    }

    private final void m(String str) {
        this.f58251b.invoke(this.f58259j, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(k kVar, ActivityResult activityResult) {
        String str;
        Intrinsics.h(activityResult, "activityResult");
        try {
            if (kVar.f58253d) {
                int resultCode = activityResult.getResultCode();
                if (resultCode == -1) {
                    str = kVar.f58257h;
                } else if (resultCode != 0) {
                    str = kVar.f58255f;
                } else {
                    com.tn.lib.widget.toast.core.h.f41533a.k(com.transsion.share.R$string.cancel);
                    str = kVar.f58256g;
                }
            } else {
                if (kVar.f58254e != 0 && SystemClock.elapsedRealtime() - kVar.f58254e >= 1500) {
                    str = kVar.f58257h;
                }
                a.C0856a c0856a = lg.a.f68962a;
                String a11 = WebFragmentV2.INSTANCE.a();
                Intrinsics.g(a11, "<get-TAG>(...)");
                a.C0856a.f(c0856a, a11, "操作太快了 leaveVskitTime:" + kVar.f58254e, false, 4, null);
                str = kVar.f58255f;
            }
            a.C0856a c0856a2 = lg.a.f68962a;
            String a12 = WebFragmentV2.INSTANCE.a();
            Intrinsics.g(a12, "<get-TAG>(...)");
            a.C0856a.f(c0856a2, a12, "shareResultActivityResultCallback:" + str + "  ----  " + activityResult.getResultCode(), false, 4, null);
            kVar.m(str);
        } catch (Exception unused) {
        }
    }

    public final void h(Activity activity, String data, String callbackId) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        JSONObject jSONObject = new JSONObject(data);
        String optString = jSONObject.optString("packageName");
        String optString2 = jSONObject.optString("txt");
        this.f58259j = callbackId;
        Context context = this.f58250a.getContext();
        if (context == null) {
            return;
        }
        if (Intrinsics.c(optString, "copyLink")) {
            ClipData newPlainText = ClipData.newPlainText("MovieBox", optString2);
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
            }
            com.tn.lib.widget.toast.core.h.f41533a.k(R$string.web_copied);
            m(this.f58257h);
            return;
        }
        if (optString == null || optString.length() == 0) {
            m("0");
            return;
        }
        if (TextUtils.equals(optString, "com.whatsapp")) {
            p pVar = p.f68511a;
            Intrinsics.e(optString2);
            pVar.d(activity, optString2, new Function1() { // from class: com.transsion.web.share.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit i11;
                    i11 = k.i(k.this, ((Boolean) obj).booleanValue());
                    return i11;
                }
            });
        } else if (TextUtils.equals(optString, "org.telegram.messenger")) {
            p pVar2 = p.f68511a;
            Intrinsics.e(optString2);
            pVar2.c(activity, optString2, new Function1() { // from class: com.transsion.web.share.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit j11;
                    j11 = k.j(k.this, ((Boolean) obj).booleanValue());
                    return j11;
                }
            });
        }
    }

    public final void k(String data, String callbackId, FragmentManager fragmentManager) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        Intrinsics.h(fragmentManager, "fragmentManager");
        this.f58259j = callbackId;
        final Context context = this.f58250a.getContext();
        if (context == null) {
            return;
        }
        try {
            if (fragmentManager.k0("WebShareDialog") != null) {
                return;
            }
            WebShareDialog a11 = WebShareDialog.INSTANCE.a(data);
            a11.r0(new Function3() { // from class: com.transsion.web.share.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit l11;
                    l11 = k.l(context, this, (String) obj, (String) obj2, (String) obj3);
                    return l11;
                }
            });
            a11.show(fragmentManager, "WebShareDialog");
        } catch (Exception unused) {
            m(this.f58255f);
        }
    }
}
