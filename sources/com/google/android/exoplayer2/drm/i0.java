package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.exoplayer2.drm.c0;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class i0 implements j0 {

    /* renamed from: a, reason: collision with root package name */
    private final k.a f25043a;

    /* renamed from: b, reason: collision with root package name */
    private final String f25044b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f25045c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f25046d;

    public i0(String str, boolean z10, k.a aVar) {
        com.google.android.exoplayer2.util.a.a((z10 && TextUtils.isEmpty(str)) ? false : true);
        this.f25043a = aVar;
        this.f25044b = str;
        this.f25045c = z10;
        this.f25046d = new HashMap();
    }

    private static byte[] c(k.a aVar, String str, byte[] bArr, Map map) {
        com.google.android.exoplayer2.upstream.i0 i0Var = new com.google.android.exoplayer2.upstream.i0(aVar.createDataSource());
        com.google.android.exoplayer2.upstream.n a11 = new n.b().j(str).e(map).d(2).c(bArr).b(1).a();
        int i11 = 0;
        com.google.android.exoplayer2.upstream.n nVar = a11;
        while (true) {
            try {
                com.google.android.exoplayer2.upstream.l lVar = new com.google.android.exoplayer2.upstream.l(i0Var, nVar);
                try {
                    try {
                        return p0.Y0(lVar);
                    } catch (HttpDataSource$InvalidResponseCodeException e11) {
                        String d11 = d(e11, i11);
                        if (d11 == null) {
                            throw e11;
                        }
                        i11++;
                        nVar = nVar.a().j(d11).a();
                    }
                } finally {
                    p0.n(lVar);
                }
            } catch (Exception e12) {
                throw new MediaDrmCallbackException(a11, (Uri) com.google.android.exoplayer2.util.a.e(i0Var.h()), i0Var.getResponseHeaders(), i0Var.f(), e12);
            }
        }
    }

    private static String d(HttpDataSource$InvalidResponseCodeException httpDataSource$InvalidResponseCodeException, int i11) {
        Map<String, List<String>> map;
        List<String> list;
        int i12 = httpDataSource$InvalidResponseCodeException.responseCode;
        if ((i12 != 307 && i12 != 308) || i11 >= 5 || (map = httpDataSource$InvalidResponseCodeException.headerFields) == null || (list = map.get(HttpHeaders.LOCATION)) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // com.google.android.exoplayer2.drm.j0
    public byte[] a(UUID uuid, c0.d dVar) {
        return c(this.f25043a, dVar.b() + "&signedRequest=" + p0.D(dVar.a()), null, Collections.emptyMap());
    }

    @Override // com.google.android.exoplayer2.drm.j0
    public byte[] b(UUID uuid, c0.a aVar) {
        String b11 = aVar.b();
        if (this.f25045c || TextUtils.isEmpty(b11)) {
            b11 = this.f25044b;
        }
        if (TextUtils.isEmpty(b11)) {
            n.b bVar = new n.b();
            Uri uri = Uri.EMPTY;
            throw new MediaDrmCallbackException(bVar.i(uri).a(), uri, ImmutableMap.of(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap hashMap = new HashMap();
        UUID uuid2 = com.google.android.exoplayer2.l.f25244e;
        hashMap.put(HttpHeaders.CONTENT_TYPE, uuid2.equals(uuid) ? "text/xml" : com.google.android.exoplayer2.l.f25242c.equals(uuid) ? "application/json" : OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        if (uuid2.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f25046d) {
            hashMap.putAll(this.f25046d);
        }
        return c(this.f25043a, b11, aVar.a(), hashMap);
    }

    public void e(String str, String str2) {
        com.google.android.exoplayer2.util.a.e(str);
        com.google.android.exoplayer2.util.a.e(str2);
        synchronized (this.f25046d) {
            this.f25046d.put(str, str2);
        }
    }
}
