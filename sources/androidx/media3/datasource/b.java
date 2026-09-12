package androidx.media3.datasource;

import android.content.Context;
import android.net.Uri;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.u;
import androidx.media3.datasource.a;
import androidx.media3.datasource.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import w1.h;
import w1.n;

/* loaded from: classes2.dex */
public final class b implements androidx.media3.datasource.a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f10800a;

    /* renamed from: b, reason: collision with root package name */
    private final List f10801b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.datasource.a f10802c;

    /* renamed from: d, reason: collision with root package name */
    private androidx.media3.datasource.a f10803d;

    /* renamed from: e, reason: collision with root package name */
    private androidx.media3.datasource.a f10804e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.media3.datasource.a f10805f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.media3.datasource.a f10806g;

    /* renamed from: h, reason: collision with root package name */
    private androidx.media3.datasource.a f10807h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.media3.datasource.a f10808i;

    /* renamed from: j, reason: collision with root package name */
    private androidx.media3.datasource.a f10809j;

    /* renamed from: k, reason: collision with root package name */
    private androidx.media3.datasource.a f10810k;

    /* loaded from: classes2.dex */
    public static final class a implements a.InterfaceC0099a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f10811a;

        /* renamed from: b, reason: collision with root package name */
        private final a.InterfaceC0099a f10812b;

        /* renamed from: c, reason: collision with root package name */
        private n f10813c;

        public a(Context context) {
            this(context, new c.b());
        }

        public a(Context context, a.InterfaceC0099a interfaceC0099a) {
            this.f10811a = context.getApplicationContext();
            this.f10812b = (a.InterfaceC0099a) androidx.media3.common.util.a.e(interfaceC0099a);
        }

        @Override // androidx.media3.datasource.a.InterfaceC0099a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b createDataSource() {
            b bVar = new b(this.f10811a, this.f10812b.createDataSource());
            n nVar = this.f10813c;
            if (nVar != null) {
                bVar.c(nVar);
            }
            return bVar;
        }
    }

    public b(Context context, androidx.media3.datasource.a aVar) {
        this.f10800a = context.getApplicationContext();
        this.f10802c = (androidx.media3.datasource.a) androidx.media3.common.util.a.e(aVar);
    }

    private void d(androidx.media3.datasource.a aVar) {
        for (int i11 = 0; i11 < this.f10801b.size(); i11++) {
            aVar.c((n) this.f10801b.get(i11));
        }
    }

    private androidx.media3.datasource.a e() {
        if (this.f10804e == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f10800a);
            this.f10804e = assetDataSource;
            d(assetDataSource);
        }
        return this.f10804e;
    }

    private androidx.media3.datasource.a f() {
        if (this.f10805f == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f10800a);
            this.f10805f = contentDataSource;
            d(contentDataSource);
        }
        return this.f10805f;
    }

    private androidx.media3.datasource.a g() {
        if (this.f10808i == null) {
            w1.c cVar = new w1.c();
            this.f10808i = cVar;
            d(cVar);
        }
        return this.f10808i;
    }

    private androidx.media3.datasource.a h() {
        if (this.f10803d == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f10803d = fileDataSource;
            d(fileDataSource);
        }
        return this.f10803d;
    }

    private androidx.media3.datasource.a i() {
        if (this.f10809j == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f10800a);
            this.f10809j = rawResourceDataSource;
            d(rawResourceDataSource);
        }
        return this.f10809j;
    }

    private androidx.media3.datasource.a j() {
        if (this.f10806g == null) {
            try {
                androidx.media3.datasource.a aVar = (androidx.media3.datasource.a) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                this.f10806g = aVar;
                d(aVar);
            } catch (ClassNotFoundException unused) {
                u.h("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e11) {
                throw new RuntimeException("Error instantiating RTMP extension", e11);
            }
            if (this.f10806g == null) {
                this.f10806g = this.f10802c;
            }
        }
        return this.f10806g;
    }

    private androidx.media3.datasource.a k() {
        if (this.f10807h == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.f10807h = udpDataSource;
            d(udpDataSource);
        }
        return this.f10807h;
    }

    private void l(androidx.media3.datasource.a aVar, n nVar) {
        if (aVar != null) {
            aVar.c(nVar);
        }
    }

    @Override // androidx.media3.datasource.a
    public long a(h hVar) {
        androidx.media3.common.util.a.g(this.f10810k == null);
        String scheme = hVar.f77634a.getScheme();
        if (a1.J0(hVar.f77634a)) {
            String path = hVar.f77634a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.f10810k = h();
            } else {
                this.f10810k = e();
            }
        } else if ("asset".equals(scheme)) {
            this.f10810k = e();
        } else if ("content".equals(scheme)) {
            this.f10810k = f();
        } else if ("rtmp".equals(scheme)) {
            this.f10810k = j();
        } else if ("udp".equals(scheme)) {
            this.f10810k = k();
        } else if ("data".equals(scheme)) {
            this.f10810k = g();
        } else if (com.mbridge.msdk.playercommon.exoplayer2.upstream.RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) || "android.resource".equals(scheme)) {
            this.f10810k = i();
        } else {
            this.f10810k = this.f10802c;
        }
        return this.f10810k.a(hVar);
    }

    @Override // androidx.media3.datasource.a
    public void c(n nVar) {
        androidx.media3.common.util.a.e(nVar);
        this.f10802c.c(nVar);
        this.f10801b.add(nVar);
        l(this.f10803d, nVar);
        l(this.f10804e, nVar);
        l(this.f10805f, nVar);
        l(this.f10806g, nVar);
        l(this.f10807h, nVar);
        l(this.f10808i, nVar);
        l(this.f10809j, nVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        androidx.media3.datasource.a aVar = this.f10810k;
        if (aVar != null) {
            try {
                aVar.close();
            } finally {
                this.f10810k = null;
            }
        }
    }

    @Override // androidx.media3.datasource.a
    public Map getResponseHeaders() {
        androidx.media3.datasource.a aVar = this.f10810k;
        return aVar == null ? Collections.emptyMap() : aVar.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        androidx.media3.datasource.a aVar = this.f10810k;
        if (aVar == null) {
            return null;
        }
        return aVar.getUri();
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        return ((androidx.media3.datasource.a) androidx.media3.common.util.a.e(this.f10810k)).read(bArr, i11, i12);
    }
}
