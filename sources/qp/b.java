package qp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.therouter.TheRouter;
import com.transsion.mpush.api.IPushRouteHandler;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.push.api.IPushProvider;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class b implements IPushRouteHandler {

    /* renamed from: c, reason: collision with root package name */
    public static final a f73792c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f73793a;

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f73794b = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: qp.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Set h11;
            h11 = b.h(b.this);
            return h11;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(String str) {
        this.f73793a = str;
    }

    private final Intent b(Context context, Map map) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.addFlags(335544320);
        f(launchIntentForPackage, map);
        return launchIntentForPackage;
    }

    private final Intent c(String str, Map map) {
        if (str == null || StringsKt.q0(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (!k(parse)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(335544320);
        f(intent, map);
        return intent;
    }

    private final Intent d(Context context, String str, Map map) {
        if (str != null && !StringsKt.q0(str)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(335544320);
            f(intent, map);
            return intent;
        }
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.addFlags(335544320);
        f(launchIntentForPackage, map);
        return launchIntentForPackage;
    }

    private final Intent e(Context context, String str, Map map) {
        IPushProvider iPushProvider = (IPushProvider) TheRouter.d(IPushProvider.class, new Object[0]);
        if (iPushProvider == null) {
            return null;
        }
        Intent a11 = iPushProvider.a(context);
        a11.setAction("android.intent.action.VIEW");
        a11.addFlags(872415232);
        if (str != null && !StringsKt.q0(str)) {
            a11.setData(Uri.parse(str));
        }
        f(a11, map);
        return a11;
    }

    private final void f(Intent intent, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            intent.putExtra((String) entry.getKey(), (String) entry.getValue());
        }
    }

    private final Set g() {
        return (Set) this.f73794b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set h(b bVar) {
        return bVar.i();
    }

    private final Set i() {
        Uri parse;
        String scheme;
        String str = this.f73793a;
        String str2 = null;
        if (str != null && (parse = Uri.parse(str)) != null && (scheme = parse.getScheme()) != null && !StringsKt.q0(scheme)) {
            str2 = scheme;
        }
        Set b11 = SetsKt.b();
        if (str2 != null) {
            b11.add(str2);
        }
        return SetsKt.a(b11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
    
        if (r3 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String j(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L10
            boolean r1 = kotlin.text.StringsKt.q0(r3)
            if (r1 != 0) goto La
            goto Lb
        La:
            r3 = r0
        Lb:
            if (r3 != 0) goto Le
            goto L10
        Le:
            r0 = r3
            goto L1b
        L10:
            java.lang.String r3 = r2.f73793a
            if (r3 == 0) goto L1b
            boolean r1 = kotlin.text.StringsKt.q0(r3)
            if (r1 != 0) goto L1b
            goto Le
        L1b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: qp.b.j(java.lang.String):java.lang.String");
    }

    private final boolean k(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null) {
            return false;
        }
        Locale ROOT = Locale.ROOT;
        Intrinsics.g(ROOT, "ROOT");
        String lowerCase = scheme.toLowerCase(ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        if (lowerCase == null) {
            return false;
        }
        return !g().contains(lowerCase);
    }

    private final boolean l(Context context, Intent intent, String str) {
        Object m1185constructorimpl;
        if (intent == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            context.startActivity(intent);
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.TRUE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.l(lg.a.f68962a, "AppPushRouteHandler", str + ": " + m1188exceptionOrNullimpl.getMessage(), false, 4, null);
            m1185constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) m1185constructorimpl).booleanValue();
    }

    private final void m(Context context, String str, String str2, Map map) {
        String jSONObject;
        a.C0856a.f(lg.a.f68962a, "AppPushRouteHandler", "【激活广告推送】路由结果：" + str + " → " + str2, false, 4, null);
        try {
            String str3 = (String) map.get("msg_extra_map");
            if (str3 == null) {
                str3 = "{}";
            }
            JSONObject jSONObject2 = new JSONObject(str3);
            jSONObject2.put("clickResult", str2);
            jSONObject = jSONObject2.toString();
        } catch (Exception unused) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("clickResult", str2);
            String str4 = (String) map.get("clickArea");
            if (str4 != null) {
                jSONObject3.put("clickArea", str4);
            }
            jSONObject = jSONObject3.toString();
        }
        Intrinsics.e(jSONObject);
        LocalPushMessage localPushMessage = new LocalPushMessage(0, null, null, null, null, null, null, null, null, null, 0L, 0, 0L, false, false, null, false, 0, 262143, null);
        String str5 = (String) map.get("msg_id");
        if (str5 == null) {
            str5 = "";
        }
        localPushMessage.setMessageId(str5);
        String str6 = (String) map.get("msg_source");
        if (str6 == null) {
            str6 = "";
        }
        localPushMessage.setSource(str6);
        String str7 = (String) map.get("msg_type");
        if (str7 == null) {
            str7 = "";
        }
        localPushMessage.setType(str7);
        String str8 = (String) map.get("msg_style");
        if (str8 == null) {
            str8 = "";
        }
        localPushMessage.setStyle(str8);
        String str9 = (String) map.get("deeplink");
        localPushMessage.setDeeplink(str9 != null ? str9 : "");
        localPushMessage.setExtraMap(jSONObject);
        ln.b.f69110a.g(context, localPushMessage, (String) map.get("channel_id"), (String) map.get("msg_source"));
    }

    @Override // com.transsion.mpush.api.IPushRouteHandler
    public void onHandleRoute(Context context, String str, Map extras) {
        Intent intent;
        Intrinsics.h(context, "context");
        Intrinsics.h(extras, "extras");
        String str2 = (String) extras.get("target_package_name");
        if (str2 != null && !StringsKt.q0(str2)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str2);
            } catch (Exception unused) {
                intent = null;
            }
            if (intent != null && l(context, intent, "target package error")) {
                m(context, str2, NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, extras);
                return;
            }
            m(context, str2, "launch_failed", extras);
        }
        String j11 = j(str);
        if (l(context, c(j11, extras), "start external intent error") || l(context, e(context, j11, extras), "start provider intent error") || l(context, d(context, j11, extras), "start fallback intent error") || l(context, b(context, extras), "start app launch intent error")) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "AppPushRouteHandler", "app launch intent is null", false, 4, null);
    }
}
