package androidx.media3.exoplayer.drm;

import android.net.Uri;
import androidx.media3.common.t;
import androidx.media3.datasource.a;
import androidx.media3.datasource.c;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import com.google.common.collect.r4;
import com.google.common.primitives.Ints;
import java.util.Map;

/* loaded from: classes2.dex */
public final class j implements w {

    /* renamed from: a, reason: collision with root package name */
    private final Object f11661a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private t.f f11662b;

    /* renamed from: c, reason: collision with root package name */
    private t f11663c;

    /* renamed from: d, reason: collision with root package name */
    private a.InterfaceC0099a f11664d;

    /* renamed from: e, reason: collision with root package name */
    private String f11665e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.media3.exoplayer.upstream.m f11666f;

    private t b(t.f fVar) {
        a.InterfaceC0099a interfaceC0099a = this.f11664d;
        if (interfaceC0099a == null) {
            interfaceC0099a = new c.b().d(this.f11665e);
        }
        Uri uri = fVar.f10344c;
        l0 l0Var = new l0(uri == null ? null : uri.toString(), fVar.f10349h, interfaceC0099a);
        r4 it = fVar.f10346e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            l0Var.c((String) entry.getKey(), (String) entry.getValue());
        }
        DefaultDrmSessionManager.b e11 = new DefaultDrmSessionManager.b().f(fVar.f10342a, k0.f11667d).c(fVar.f10347f).d(fVar.f10348g).e(Ints.o(fVar.f10351j));
        androidx.media3.exoplayer.upstream.m mVar = this.f11666f;
        if (mVar != null) {
            e11.b(mVar);
        }
        DefaultDrmSessionManager a11 = e11.a(l0Var);
        a11.E(0, fVar.c());
        return a11;
    }

    @Override // androidx.media3.exoplayer.drm.w
    public t a(androidx.media3.common.t tVar) {
        t tVar2;
        androidx.media3.common.util.a.e(tVar.f10293b);
        t.f fVar = tVar.f10293b.f10387c;
        if (fVar == null) {
            return t.f11694a;
        }
        synchronized (this.f11661a) {
            try {
                if (!fVar.equals(this.f11662b)) {
                    this.f11662b = fVar;
                    this.f11663c = b(fVar);
                }
                tVar2 = (t) androidx.media3.common.util.a.e(this.f11663c);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return tVar2;
    }
}
