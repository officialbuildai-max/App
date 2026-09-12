package z6;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.G;
import com.cloud.hisavana.sdk.api.listener.AdCallback;
import com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.e4;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected G f79402a;

    /* renamed from: b, reason: collision with root package name */
    protected String f79403b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f79404c;

    /* renamed from: d, reason: collision with root package name */
    protected int f79405d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f79406e;

    /* renamed from: f, reason: collision with root package name */
    protected com.cloud.hisavana.sdk.api.listener.d f79407f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f79408g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f79409h;

    /* renamed from: i, reason: collision with root package name */
    protected b7.a f79410i;

    /* renamed from: j, reason: collision with root package name */
    protected b7.b f79411j;

    /* renamed from: k, reason: collision with root package name */
    private long f79412k = 0;

    /* renamed from: l, reason: collision with root package name */
    protected androidx.collection.b f79413l = new androidx.collection.b();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: z6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1004a extends AdCallback {

        /* renamed from: a, reason: collision with root package name */
        protected final a f79414a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1004a(a aVar) {
            this.f79414a = aVar;
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public com.cloud.hisavana.sdk.api.listener.d d() {
            a aVar = this.f79414a;
            if (aVar != null) {
                return aVar.f79407f;
            }
            return null;
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public String e() {
            a aVar = this.f79414a;
            return aVar != null ? SSPTrackingHelper.f22035a.o(aVar.f79402a) : "";
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public String g() {
            a aVar = this.f79414a;
            return aVar != null ? SSPTrackingHelper.f22035a.q(aVar.f79402a) : "";
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public void q(G g11, Bundle bundle) {
            a aVar = this.f79414a;
            if (aVar != null) {
                aVar.f79402a = g11;
            }
            super.q(g11, bundle);
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public void r(G g11, List list, Bundle bundle) {
            a aVar = this.f79414a;
            if (aVar != null) {
                aVar.f79402a = g11;
            }
            super.r(g11, list, bundle);
        }
    }

    public a(String str) {
        this.f79403b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TaErrorCode taErrorCode, Bundle bundle) {
        try {
            SSPTrackingHelper sSPTrackingHelper = SSPTrackingHelper.f22035a;
            sSPTrackingHelper.N(Integer.valueOf(taErrorCode.getErrorCode()), sSPTrackingHelper.q(this.f79402a), this.f79403b, sSPTrackingHelper.m(this.f79402a), bundle);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        if (TextUtils.isEmpty(a7.c.f440b)) {
            e4.b().e("ssp", "AppId is empty, please check your config.");
            com.cloud.hisavana.sdk.api.listener.d dVar = this.f79407f;
            if (dVar != null) {
                dVar.onError(TaErrorCode.ERROR_INVALID_APP_ID);
            }
            return false;
        }
        if (!com.cloud.sdk.commonutil.util.e.h()) {
            e4.b().e("ssp", "You should init first");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long n11 = SSPTrackingHelper.f22035a.n();
        if (currentTimeMillis - this.f79412k > n11) {
            this.f79412k = currentTimeMillis;
            return true;
        }
        e4.b().d("ssp", "Ad request rate limit exceeded，current interval is" + n11);
        return false;
    }

    public void c() {
        this.f79407f = null;
        try {
            G g11 = this.f79402a;
            if (g11 != null) {
                this.f79413l.remove(g11);
                if (e4.c()) {
                    e4.b().i("ssp", "NonViewApi mLoadedAd destroy");
                }
                this.f79402a.m();
            }
            if (this.f79413l.isEmpty()) {
                return;
            }
            for (int i11 = 0; i11 < this.f79413l.size(); i11++) {
                G g12 = (G) this.f79413l.o(i11);
                if (g12 != null) {
                    e4.b().d("ssp", "baseAd destroy " + g12);
                    g12.m();
                }
            }
            this.f79413l.clear();
        } catch (Throwable unused) {
        }
    }

    public int d() {
        G g11 = this.f79402a;
        if (g11 == null) {
            return 1115;
        }
        return g11.r();
    }

    public int e() {
        G g11 = this.f79402a;
        if (g11 != null) {
            return g11.q();
        }
        return 1;
    }

    public double f() {
        G g11 = this.f79402a;
        if (g11 != null) {
            return g11.t();
        }
        return 0.0d;
    }

    public int g() {
        G g11 = this.f79402a;
        if (g11 != null) {
            return g11.u();
        }
        return 0;
    }

    public b7.a h() {
        return this.f79410i;
    }

    public boolean i() {
        G g11 = this.f79402a;
        return g11 != null && g11.A();
    }

    public boolean j() {
        return this.f79402a != null;
    }

    public boolean k() {
        G g11 = this.f79402a;
        if (g11 != null) {
            return g11.B();
        }
        return false;
    }

    public void l(String str, String str2, Map map) {
        this.f79411j = new b7.b(str, str2, map);
    }

    public void m(boolean z10) {
        this.f79408g = z10;
    }

    public void n(boolean z10) {
        this.f79404c = z10;
    }

    public void o(int i11) {
        this.f79405d = i11;
    }

    public void p(com.cloud.hisavana.sdk.api.listener.d dVar) {
        this.f79407f = dVar;
    }

    public void q(String str) {
        this.f79403b = str;
    }

    public void r(b7.a aVar) {
        this.f79410i = aVar;
    }
}
