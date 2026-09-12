package yv;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import bw.g;
import bw.h;
import bw.i;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.GslbSdk;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class b implements GslbSdk.GslbInitListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f79181a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f79182b;

    public b(c cVar, Context context) {
        this.f79181a = cVar;
        this.f79182b = context;
    }

    @Override // com.transsion.gslb.GslbSdk.GslbInitListener
    public final void onInitFail(String str) {
        String msg = "GSLB init fail: " + str;
        Intrinsics.h("UpgradeSdkManager", "tag");
        Intrinsics.h(msg, "msg");
        long currentTimeMillis = System.currentTimeMillis();
        if (!g.f17021a && currentTimeMillis - g.f17022b >= 5000) {
            g.f17022b = currentTimeMillis;
            if (Log.isLoggable("upgradeSdkLog", 3)) {
                g.f17021a = true;
            }
        }
        boolean z10 = f.f79190o.a().f79195d;
    }

    @Override // com.transsion.gslb.GslbSdk.GslbInitListener
    public final void onInitSuccess(Map map) {
        g.a("GSLB init success: " + map);
        String country = GslbSdk.getCountry();
        if (TextUtils.isEmpty(country)) {
            return;
        }
        this.f79181a.f79186b = country;
        h hVar = i.f17023b;
        i a11 = hVar.a(this.f79182b);
        Intrinsics.e(country);
        a11.b("KV_UPGRADE_GSLB_COUNTRY", country);
        Application application = null;
        if (StringsKt.H(country, "IN", true)) {
            c cVar = this.f79181a;
            if (!TextUtils.equals(cVar.f79186b, cVar.f79187c)) {
                g.a("GSLB init current: " + country + " request: " + this.f79181a.f79187c);
                Application application2 = xv.a.f78570a;
                if (application2 != null) {
                    application = application2;
                } else {
                    Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
                }
                hVar.a(application).b("KV_UPGRADE_LOCAL_CDN_DATA", "");
                return;
            }
        }
        if (StringsKt.H(country, "RU", true)) {
            c cVar2 = this.f79181a;
            if (TextUtils.equals(cVar2.f79186b, cVar2.f79187c)) {
                return;
            }
            g.a("GSLB init current: " + country + " request: " + this.f79181a.f79187c);
            Application application3 = xv.a.f78570a;
            if (application3 != null) {
                application = application3;
            } else {
                Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
            }
            hVar.a(application).b("KV_UPGRADE_LOCAL_CDN_DATA", "");
        }
    }
}
