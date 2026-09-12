package nv;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.view.e;
import androidx.view.f;
import androidx.view.u;
import com.cloud.tmc.integration.utils.share.config.ShareConstant;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.tn.lib.widget.toast.core.h;
import com.transsion.transfer.wifi.qrcode.QrCodeUtil;
import com.transsion.transfer.wifi.util.g;
import com.transsion.web.R$string;
import com.transsion.web.share.WebShareDialog;
import f.j;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private long f70699a;

    /* renamed from: e, reason: collision with root package name */
    private androidx.activity.result.b f70703e;

    /* renamed from: b, reason: collision with root package name */
    private final String f70700b = "fail";

    /* renamed from: c, reason: collision with root package name */
    private final String f70701c = "cancel";

    /* renamed from: d, reason: collision with root package name */
    private final String f70702d = NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.activity.result.a f70704f = new androidx.activity.result.a() { // from class: nv.a
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            c.h(c.this, (ActivityResult) obj);
        }
    };

    /* loaded from: classes7.dex */
    public static final class a implements f {
        a() {
        }

        @Override // androidx.view.f
        public /* synthetic */ void onCreate(u uVar) {
            e.a(this, uVar);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onDestroy(u uVar) {
            e.b(this, uVar);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onPause(u uVar) {
            e.c(this, uVar);
        }

        @Override // androidx.view.f
        public void onResume(u owner) {
            Intrinsics.h(owner, "owner");
            e.d(this, owner);
            c.this.f70699a = 0L;
        }

        @Override // androidx.view.f
        public /* synthetic */ void onStart(u uVar) {
            e.e(this, uVar);
        }

        @Override // androidx.view.f
        public void onStop(u owner) {
            Intrinsics.h(owner, "owner");
            e.f(this, owner);
            if (com.blankj.utilcode.util.c.l()) {
                return;
            }
            c.this.f70699a = SystemClock.elapsedRealtime();
        }
    }

    private final Intent d(Context context, String str, String str2, String str3) {
        String e11 = e(context, str2, str3);
        if (e11 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(ShareConstant.SHARE_TYPE_TEXT);
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setPackage(e11);
        return intent;
    }

    private final String e(Context context, String str, String str2) {
        if (str != null && com.transsion.baseui.util.a.f43556a.c(context, str)) {
            return str;
        }
        if (str2 == null || !com.transsion.baseui.util.a.f43556a.c(context, str2)) {
            return null;
        }
        return str2;
    }

    private final String f() {
        return "Enjoy Free Dramas & HD Movies on MovieBox—now with file transfer support! " + QrCodeUtil.f56030a.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(c cVar, ActivityResult activityResult) {
        String str;
        Intrinsics.h(activityResult, "activityResult");
        try {
            if (cVar.f70699a != 0 && SystemClock.elapsedRealtime() - cVar.f70699a >= 1500) {
                str = cVar.f70702d;
                g.d(g.f56093a, "ShareManager --> shareResultActivityResultCallback --> result = " + str, false, 2, null);
                h.f41533a.l(str);
            }
            str = cVar.f70700b;
            g.d(g.f56093a, "ShareManager --> shareResultActivityResultCallback --> result = " + str, false, 2, null);
            h.f41533a.l(str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(AppCompatActivity appCompatActivity, c cVar, String packageName, String str, String txt) {
        Object m1185constructorimpl;
        Unit unit;
        Intrinsics.h(packageName, "packageName");
        Intrinsics.h(txt, "txt");
        g.h(g.f56093a, "ShareManager --> showShareDialog() --> packageName = " + packageName + " --> backUpPackageName = " + str + " --> txt = " + txt, false, 2, null);
        if (packageName.length() == 0) {
            ClipData newPlainText = ClipData.newPlainText("MovieBox", txt);
            ClipboardManager clipboardManager = (ClipboardManager) appCompatActivity.getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
            }
            h.f41533a.k(R$string.web_copied);
        } else {
            Intent d11 = cVar.d(appCompatActivity, txt, packageName, str);
            if (d11 == null) {
                h.f41533a.k(R$string.web_app_not_exist);
            } else {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    androidx.activity.result.b bVar = cVar.f70703e;
                    if (bVar != null) {
                        bVar.a(d11);
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    m1185constructorimpl = Result.m1185constructorimpl(unit);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
                }
                Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
                if (m1188exceptionOrNullimpl != null) {
                    g.d(g.f56093a, "ShareManager --> showShareDialog() --> it = " + m1188exceptionOrNullimpl, false, 2, null);
                    m1185constructorimpl = Unit.f67184a;
                }
            }
        }
        return Unit.f67184a;
    }

    public final void g(AppCompatActivity activity) {
        Intrinsics.h(activity, "activity");
        this.f70703e = activity.registerForActivityResult(new j(), this.f70704f);
        activity.getLifecycle().a(new a());
    }

    public final void i(final AppCompatActivity activity) {
        Intrinsics.h(activity, "activity");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("WhatsApp", f());
        jSONObject.put("Telegram", f());
        jSONObject.put("CopyLink", f());
        WebShareDialog.Companion companion = WebShareDialog.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.g(jSONObject2, "toString(...)");
        WebShareDialog a11 = companion.a(jSONObject2);
        a11.s0("wifi_share_panel");
        a11.t0(false);
        a11.r0(new Function3() { // from class: nv.b
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit j11;
                j11 = c.j(AppCompatActivity.this, this, (String) obj, (String) obj2, (String) obj3);
                return j11;
            }
        });
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        a11.show(supportFragmentManager, "WebShareDialog");
    }
}
