package ak;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.core.utils.ToastUtil;
import com.transsion.web.api.WebPageIdentity;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;
import org.mvel2.ast.ASTNode;

/* loaded from: classes5.dex */
public abstract class k {
    public static final Navigator b(Navigator navigator, Bundle bundle) {
        Intrinsics.h(navigator, "<this>");
        if (bundle == null) {
            return navigator;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                navigator.K(str, (String) obj);
            } else if (obj instanceof Integer) {
                navigator.F(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                navigator.G(str, ((Number) obj).longValue());
            } else if (obj instanceof Float) {
                navigator.E(str, ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                navigator.D(str, ((Number) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                navigator.z(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Character) {
                navigator.C(str, ((Character) obj).charValue());
            } else if (obj instanceof Bundle) {
                navigator.A(str, (Bundle) obj);
            } else if (obj instanceof Parcelable) {
                navigator.I(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                navigator.J(str, (Serializable) obj);
            } else if (obj != null) {
                navigator.K(str, obj.toString());
            }
        }
        return navigator;
    }

    private static final void c(Uri uri, Function2 function2) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Intrinsics.g(queryParameterNames, "getQueryParameterNames(...)");
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : queryParameterNames) {
            if (!Intrinsics.c((String) obj, NativeComponentConstants.KEY_COMPONENT_TYPE)) {
                arrayList.add(obj);
            }
        }
        for (String str : arrayList) {
            String queryParameter = uri.getQueryParameter(str);
            if (queryParameter != null) {
                Intrinsics.e(str);
                function2.invoke(str, queryParameter);
            }
        }
    }

    public static final String d(long j11) {
        if (1 <= j11 && j11 < 1000) {
            return String.valueOf(j11);
        }
        if (1000 <= j11 && j11 < 1000000) {
            return (j11 / 1000) + CampaignEx.JSON_KEY_AD_K;
        }
        if (j11 < 1000000) {
            return "0";
        }
        return (j11 / 1000000) + "m";
    }

    public static final int e(List list, Object obj) {
        Intrinsics.h(list, "<this>");
        Iterator it = list.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            int i12 = i11 + 1;
            if (it.next() == obj) {
                return i11;
            }
            i11 = i12;
        }
        return -1;
    }

    public static final boolean f(Uri uri) {
        Intrinsics.h(uri, "<this>");
        return Intrinsics.c(uri.getScheme(), "https") || Intrinsics.c(uri.getScheme(), "http");
    }

    public static final void g(String str, String extraParam) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(extraParam, "extraParam");
        Uri parse = Uri.parse(str + extraParam);
        Intrinsics.e(parse);
        if (f(parse)) {
            p(TheRouter.c(WebPageIdentity.WEB_VIEW).K("url", str));
            return;
        }
        try {
            String queryParameter = parse.getQueryParameter(TmcConstants.EXTRA_BACK_TO_MINIAPP_DEEPLINK);
            if (queryParameter != null && queryParameter.length() != 0) {
                lg.a.f68962a.c("deeplink", "openDeeplink--Deeplink is mini app, " + queryParameter, true);
                uj.a aVar = uj.a.f76883a;
                Application a11 = Utils.a();
                Intrinsics.g(a11, "getApp(...)");
                aVar.b(a11, queryParameter);
                return;
            }
        } catch (Throwable th2) {
            a.C0856a.l(lg.a.f68962a, "Deeplink", "openMiniApp:" + th2, false, 4, null);
            th2.printStackTrace();
        }
        try {
            Uri g11 = com.transsion.baselib.helper.b.f43318a.g(parse);
            if (g11 != null) {
                o(g11);
            }
        } catch (Throwable th3) {
            a.C0856a.l(lg.a.f68962a, "Deeplink", "openDeeplink:" + th3, false, 4, null);
            th3.printStackTrace();
        }
    }

    public static /* synthetic */ void h(String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = "";
        }
        g(str, str2);
    }

    public static final void i(String str) {
        Intrinsics.h(str, "<this>");
        j(str, com.transsion.baselib.report.l.f43413a.o());
    }

    public static final void j(String str, Context context) {
        String str2;
        Intrinsics.h(str, "<this>");
        if (context == null) {
            return;
        }
        if (!StringsKt.W(str, "http://", false, 2, null) && !StringsKt.W(str, "https://", false, 2, null)) {
            str = "http://" + str;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addCategory("android.intent.category.BROWSABLE");
        if (!(context instanceof Activity)) {
            intent.addFlags(ASTNode.DEOP);
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            try {
                Intent intent2 = new Intent(intent);
                intent2.setPackage("com.android.chrome");
                context.startActivity(intent2);
                a.C0856a.l(lg.a.f68962a, "ExternalBrowser", "openExternalBrowser with chrome", false, 4, null);
                com.transsion.baselib.helper.a.f43316a.c("ExtUtils", "dialog_browser_chrome");
            } catch (Exception unused) {
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                Intrinsics.g(queryIntentActivities, "queryIntentActivities(...)");
                ArrayList<ResolveInfo> arrayList = new ArrayList();
                for (Object obj : queryIntentActivities) {
                    if (!Intrinsics.c(((ResolveInfo) obj).activityInfo.packageName, context.getPackageName())) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.v(arrayList, 10));
                for (ResolveInfo resolveInfo : arrayList) {
                    Intent intent3 = new Intent(intent);
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    intent3.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                    arrayList2.add(intent3);
                }
                if (arrayList2.isEmpty()) {
                    ToastUtil.f("Please install a browser to continue");
                    str2 = "dialog_no_browser";
                } else {
                    Intent createChooser = Intent.createChooser((Intent) CollectionsKt.i0(arrayList2), "Open in browser");
                    createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) CollectionsKt.d0(arrayList2, 1).toArray(new Intent[0]));
                    context.startActivity(createChooser);
                    a.C0856a.l(lg.a.f68962a, "ExternalBrowser", "openExternalBrowser with --filter intent", false, 4, null);
                    str2 = "dialog_browser_normal";
                }
                com.transsion.baselib.helper.a.f43316a.c("ExtUtils", str2);
            }
        } catch (ActivityNotFoundException e11) {
            e11.printStackTrace();
            ToastUtil.f("Unable to open through this browser, please try another one");
            str2 = "dialog_browser_err";
            com.transsion.baselib.helper.a.f43316a.c("ExtUtils", str2);
        } catch (Exception e12) {
            e12.printStackTrace();
            ToastUtil.f("Unable to open through this browser, please try another one");
            str2 = "dialog_browser_unknown_err";
            com.transsion.baselib.helper.a.f43316a.c("ExtUtils", str2);
        }
    }

    public static final String k(String str) {
        Intrinsics.h(str, "<this>");
        try {
            URI uri = new URI(str);
            return uri.getScheme() + "://" + uri.getHost() + uri.getPath();
        } catch (Throwable unused) {
            return str;
        }
    }

    private static final String l(Uri uri) {
        String queryParameter = uri.getQueryParameter(NativeComponentConstants.KEY_COMPONENT_TYPE);
        if (queryParameter != null) {
            return queryParameter;
        }
        String path = uri.getPath();
        return path == null ? "" : path;
    }

    public static final Navigator m(Uri uri) {
        Intrinsics.h(uri, "<this>");
        final Navigator c11 = TheRouter.c(l(uri));
        c(uri, new Function2() { // from class: ak.j
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit n11;
                n11 = k.n(Navigator.this, (String) obj, (String) obj2);
                return n11;
            }
        });
        return c11;
    }

    public static final Unit n(Navigator navigator, String key, String value) {
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        navigator.K(key, value);
        return Unit.f67184a;
    }

    public static final void o(Uri uri) {
        Intrinsics.h(uri, "<this>");
        p(m(uri));
    }

    public static final void p(Navigator navigator) {
        Object obj;
        Intrinsics.h(navigator, "<this>");
        try {
            Iterator it = com.transsion.baselib.report.l.f43413a.m().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String localClassName = ((Activity) obj).getLocalClassName();
                Intrinsics.g(localClassName, "getLocalClassName(...)");
                if (StringsKt.c0(localClassName, "MainActivity", false, 2, null)) {
                    break;
                }
            }
            Activity activity = (Activity) obj;
            if (activity == null) {
                activity = com.transsion.baselib.report.l.f43413a.o();
            }
            Navigator.x(navigator, activity, null, 2, null);
        } catch (Throwable unused) {
            Navigator.x(navigator, null, null, 3, null);
        }
    }
}
