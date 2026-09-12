package hr;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f64948a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static String f64949b = "";

    /* renamed from: c, reason: collision with root package name */
    private static Function0 f64950c;

    /* renamed from: d, reason: collision with root package name */
    private static Function4 f64951d;

    /* renamed from: e, reason: collision with root package name */
    private static Function1 f64952e;

    private a() {
    }

    public final void a() {
        f64949b = "";
        f64950c = null;
        f64951d = null;
        f64952e = null;
    }

    public final String b() {
        return f64949b;
    }

    public final String c() {
        String str;
        Function0 function0 = f64950c;
        return (function0 == null || (str = (String) function0.invoke()) == null) ? "" : str;
    }

    public void d(String appName, Function0 userId, Function4 reportShow, Function1 toastShow) {
        Intrinsics.h(appName, "appName");
        Intrinsics.h(userId, "userId");
        Intrinsics.h(reportShow, "reportShow");
        Intrinsics.h(toastShow, "toastShow");
        f64949b = appName;
        f64950c = userId;
        f64951d = reportShow;
        f64952e = toastShow;
    }

    public final void e(Context context, String str, String id2, com.transsion.share.share.a aVar) {
        Intrinsics.h(context, "context");
        Intrinsics.h(id2, "id");
        Function4 function4 = f64951d;
        if (function4 != null) {
            function4.invoke(context, str, id2, aVar);
        }
    }

    public final void f(String content) {
        Intrinsics.h(content, "content");
        Function1 function1 = f64952e;
        if (function1 != null) {
            function1.invoke(content);
        }
    }
}
