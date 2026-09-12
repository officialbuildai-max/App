package hy;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f64965a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final Set f64966b = new LinkedHashSet();

    private a() {
    }

    public final void a() {
        com.transsion.wrapperad.install.b bVar = com.transsion.wrapperad.install.b.f58298a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        bVar.b(a11);
    }
}
