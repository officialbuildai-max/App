package androidx.media3.exoplayer.hls;

import androidx.media3.datasource.a;

/* loaded from: classes2.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name */
    private final a.InterfaceC0099a f11782a;

    public c(a.InterfaceC0099a interfaceC0099a) {
        this.f11782a = interfaceC0099a;
    }

    @Override // androidx.media3.exoplayer.hls.f
    public androidx.media3.datasource.a a(int i11) {
        return this.f11782a.createDataSource();
    }
}
