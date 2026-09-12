package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.s;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class r implements k {

    /* renamed from: a, reason: collision with root package name */
    private final Context f27547a;

    /* renamed from: b, reason: collision with root package name */
    private final List f27548b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final k f27549c;

    /* renamed from: d, reason: collision with root package name */
    private k f27550d;

    /* renamed from: e, reason: collision with root package name */
    private k f27551e;

    /* renamed from: f, reason: collision with root package name */
    private k f27552f;

    /* renamed from: g, reason: collision with root package name */
    private k f27553g;

    /* renamed from: h, reason: collision with root package name */
    private k f27554h;

    /* renamed from: i, reason: collision with root package name */
    private k f27555i;

    /* renamed from: j, reason: collision with root package name */
    private k f27556j;

    /* renamed from: k, reason: collision with root package name */
    private k f27557k;

    /* loaded from: classes3.dex */
    public static final class a implements k.a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f27558a;

        /* renamed from: b, reason: collision with root package name */
        private final k.a f27559b;

        /* renamed from: c, reason: collision with root package name */
        private k0 f27560c;

        public a(Context context) {
            this(context, new s.b());
        }

        public a(Context context, k.a aVar) {
            this.f27558a = context.getApplicationContext();
            this.f27559b = aVar;
        }

        @Override // com.google.android.exoplayer2.upstream.k.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r createDataSource() {
            r rVar = new r(this.f27558a, this.f27559b.createDataSource());
            k0 k0Var = this.f27560c;
            if (k0Var != null) {
                rVar.e(k0Var);
            }
            return rVar;
        }
    }

    public r(Context context, k kVar) {
        this.f27547a = context.getApplicationContext();
        this.f27549c = (k) com.google.android.exoplayer2.util.a.e(kVar);
    }

    private void f(k kVar) {
        for (int i11 = 0; i11 < this.f27548b.size(); i11++) {
            kVar.e((k0) this.f27548b.get(i11));
        }
    }

    private k h() {
        if (this.f27551e == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f27547a);
            this.f27551e = assetDataSource;
            f(assetDataSource);
        }
        return this.f27551e;
    }

    private k i() {
        if (this.f27552f == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f27547a);
            this.f27552f = contentDataSource;
            f(contentDataSource);
        }
        return this.f27552f;
    }

    private k j() {
        if (this.f27555i == null) {
            h hVar = new h();
            this.f27555i = hVar;
            f(hVar);
        }
        return this.f27555i;
    }

    private k k() {
        if (this.f27550d == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f27550d = fileDataSource;
            f(fileDataSource);
        }
        return this.f27550d;
    }

    private k l() {
        if (this.f27556j == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f27547a);
            this.f27556j = rawResourceDataSource;
            f(rawResourceDataSource);
        }
        return this.f27556j;
    }

    private k m() {
        if (this.f27553g == null) {
            try {
                k kVar = (k) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                this.f27553g = kVar;
                f(kVar);
            } catch (ClassNotFoundException unused) {
                com.google.android.exoplayer2.util.s.i("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e11) {
                throw new RuntimeException("Error instantiating RTMP extension", e11);
            }
            if (this.f27553g == null) {
                this.f27553g = this.f27549c;
            }
        }
        return this.f27553g;
    }

    private k n() {
        if (this.f27554h == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.f27554h = udpDataSource;
            f(udpDataSource);
        }
        return this.f27554h;
    }

    private void o(k kVar, k0 k0Var) {
        if (kVar != null) {
            kVar.e(k0Var);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) {
        com.google.android.exoplayer2.util.a.g(this.f27557k == null);
        String scheme = nVar.f27491a.getScheme();
        if (p0.w0(nVar.f27491a)) {
            String path = nVar.f27491a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.f27557k = k();
            } else {
                this.f27557k = h();
            }
        } else if ("asset".equals(scheme)) {
            this.f27557k = h();
        } else if ("content".equals(scheme)) {
            this.f27557k = i();
        } else if ("rtmp".equals(scheme)) {
            this.f27557k = m();
        } else if ("udp".equals(scheme)) {
            this.f27557k = n();
        } else if ("data".equals(scheme)) {
            this.f27557k = j();
        } else if (com.mbridge.msdk.playercommon.exoplayer2.upstream.RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) || "android.resource".equals(scheme)) {
            this.f27557k = l();
        } else {
            this.f27557k = this.f27549c;
        }
        return this.f27557k.a(nVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        k kVar = this.f27557k;
        if (kVar != null) {
            try {
                kVar.close();
            } finally {
                this.f27557k = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f27549c.e(k0Var);
        this.f27548b.add(k0Var);
        o(this.f27550d, k0Var);
        o(this.f27551e, k0Var);
        o(this.f27552f, k0Var);
        o(this.f27553g, k0Var);
        o(this.f27554h, k0Var);
        o(this.f27555i, k0Var);
        o(this.f27556j, k0Var);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Map getResponseHeaders() {
        k kVar = this.f27557k;
        return kVar == null ? Collections.emptyMap() : kVar.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        k kVar = this.f27557k;
        if (kVar == null) {
            return null;
        }
        return kVar.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        return ((k) com.google.android.exoplayer2.util.a.e(this.f27557k)).read(bArr, i11, i12);
    }
}
