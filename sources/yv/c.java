package yv;

import android.content.Context;
import bw.i;
import com.transsion.gslb.GslbSdk;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f79183d = new a();

    /* renamed from: e, reason: collision with root package name */
    public static volatile c f79184e;

    /* renamed from: a, reason: collision with root package name */
    public final String[] f79185a = new String[3];

    /* renamed from: b, reason: collision with root package name */
    public String f79186b;

    /* renamed from: c, reason: collision with root package name */
    public String f79187c;

    public c() {
        a();
    }

    public final void a() {
        if (f.f79190o.a().f79195d) {
            this.f79185a[0] = "https://test-upgrade-api.palmplaystore.com/";
        } else {
            this.f79185a[0] = "https://app-manage-api.shalltry.com/";
        }
    }

    public final void b(Context context) {
        Intrinsics.h(context, "context");
        this.f79186b = i.f17023b.a(context).a("KV_UPGRADE_GSLB_COUNTRY", "");
        GslbSdk.init(context, this.f79185a, new b(this, context));
    }
}
