package androidx.media3.exoplayer.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.a;
import androidx.media3.exoplayer.drm.b0;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import w1.h;

/* loaded from: classes2.dex */
public final class l0 implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private final a.InterfaceC0099a f11674a;

    /* renamed from: b, reason: collision with root package name */
    private final String f11675b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f11676c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f11677d;

    public l0(String str, boolean z10, a.InterfaceC0099a interfaceC0099a) {
        androidx.media3.common.util.a.a((z10 && TextUtils.isEmpty(str)) ? false : true);
        this.f11674a = interfaceC0099a;
        this.f11675b = str;
        this.f11676c = z10;
        this.f11677d = new HashMap();
    }

    @Override // androidx.media3.exoplayer.drm.m0
    public byte[] a(UUID uuid, b0.a aVar) {
        String b11 = aVar.b();
        if (this.f11676c || TextUtils.isEmpty(b11)) {
            b11 = this.f11675b;
        }
        if (TextUtils.isEmpty(b11)) {
            h.b bVar = new h.b();
            Uri uri = Uri.EMPTY;
            throw new MediaDrmCallbackException(bVar.i(uri).a(), uri, ImmutableMap.of(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap hashMap = new HashMap();
        UUID uuid2 = androidx.media3.common.h.f10067e;
        hashMap.put(HttpHeaders.CONTENT_TYPE, uuid2.equals(uuid) ? "text/xml" : androidx.media3.common.h.f10065c.equals(uuid) ? "application/json" : OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        if (uuid2.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f11677d) {
            hashMap.putAll(this.f11677d);
        }
        return x.a(this.f11674a.createDataSource(), b11, aVar.a(), hashMap);
    }

    @Override // androidx.media3.exoplayer.drm.m0
    public byte[] b(UUID uuid, b0.d dVar) {
        return x.a(this.f11674a.createDataSource(), dVar.b() + "&signedRequest=" + a1.H(dVar.a()), null, Collections.emptyMap());
    }

    public void c(String str, String str2) {
        androidx.media3.common.util.a.e(str);
        androidx.media3.common.util.a.e(str2);
        synchronized (this.f11677d) {
            this.f11677d.put(str, str2);
        }
    }
}
