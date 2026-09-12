package com.cloud.h5update;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.h5update.impl.UpdateChecker;
import com.cloud.h5update.impl.UpdateParser;
import com.cloud.h5update.utils.l;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t6.c;
import t6.d;

/* loaded from: classes3.dex */
public final class b implements c {

    /* renamed from: g, reason: collision with root package name */
    public static final C0300b f21334g = new C0300b(null);

    /* renamed from: h, reason: collision with root package name */
    private static UpdateEntity f21335h;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference f21336a;

    /* renamed from: b, reason: collision with root package name */
    private String f21337b;

    /* renamed from: c, reason: collision with root package name */
    private Map f21338c;

    /* renamed from: d, reason: collision with root package name */
    private Map f21339d;

    /* renamed from: e, reason: collision with root package name */
    private t6.a f21340e;

    /* renamed from: f, reason: collision with root package name */
    private d f21341f;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Context f21342a;

        /* renamed from: b, reason: collision with root package name */
        private String f21343b;

        /* renamed from: c, reason: collision with root package name */
        private Map f21344c;

        /* renamed from: d, reason: collision with root package name */
        private Map f21345d;

        /* renamed from: e, reason: collision with root package name */
        private d f21346e;

        /* renamed from: f, reason: collision with root package name */
        private t6.a f21347f;

        public a(Context context) {
            Intrinsics.h(context, "context");
            this.f21342a = context;
            this.f21346e = new UpdateParser();
            this.f21347f = new UpdateChecker();
        }

        private final b a() {
            l.f21391a.q(this.f21342a, "[UpdateManager.Builder] : context == null");
            b bVar = new b(null);
            bVar.f21336a = new WeakReference(this.f21342a);
            bVar.f21337b = this.f21343b;
            bVar.f21338c = this.f21344c;
            bVar.f21339d = this.f21345d;
            bVar.f21340e = this.f21347f;
            bVar.f21341f = this.f21346e;
            return bVar;
        }

        public final void b() {
            String str = this.f21343b;
            if (str == null || StringsKt.q0(str)) {
                com.cloud.h5update.a aVar = com.cloud.h5update.a.f21332a;
                this.f21343b = aVar.a() == 3 ? "https://api-test.byte-app.com/common/app-management/consumer-not-login/preloadconfig/query/getResourceByCDN" : aVar.a() == 2 ? "https://app-manage-api-static-pre.shalltry.com/common/app-management/consumer-not-login/preloadconfig/query/getResourceByCDN" : "https://app-manage-api-static.shalltry.com/common/app-management/consumer-not-login/preloadconfig/query/getResourceByCDN";
            }
            a().k();
        }

        public final a c(t6.a updateChecker) {
            Intrinsics.h(updateChecker, "updateChecker");
            this.f21347f = updateChecker;
            return this;
        }
    }

    /* renamed from: com.cloud.h5update.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0300b {
        private C0300b() {
        }

        public /* synthetic */ C0300b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UpdateEntity a() {
            return b.f21335h;
        }
    }

    private b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void j() {
        t6.a aVar;
        if (l.f21391a.b()) {
            i();
            return;
        }
        String str = this.f21337b;
        if (str == null || (aVar = this.f21340e) == null) {
            return;
        }
        aVar.noNetWork(str, this);
    }

    @Override // t6.c
    public UpdateEntity a(String json) {
        Intrinsics.h(json, "json");
        d dVar = this.f21341f;
        if (dVar == null) {
            return null;
        }
        Intrinsics.e(dVar);
        f21335h = dVar.a(json);
        TH5Update.a aVar = TH5Update.f21320c;
        if (aVar.j() != null) {
            t6.b j11 = aVar.j();
            Intrinsics.e(j11);
            if (!j11.onGetEntity(f21335h)) {
                return null;
            }
        }
        return f21335h;
    }

    public void i() {
        if (TextUtils.isEmpty(this.f21337b)) {
            throw new NullPointerException("[UpdateManager] : mUpdateUrl 不能为空");
        }
        t6.a aVar = this.f21340e;
        if (aVar == null) {
            return;
        }
        Intrinsics.e(aVar);
        String str = this.f21337b;
        Intrinsics.e(str);
        aVar.checkVersion(str, this.f21338c, this.f21339d, this);
    }

    public void k() {
        j();
    }
}
