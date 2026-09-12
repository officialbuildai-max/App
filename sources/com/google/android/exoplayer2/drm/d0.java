package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.p0;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class d0 implements com.google.android.exoplayer2.decoder.b {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f25029d;

    /* renamed from: a, reason: collision with root package name */
    public final UUID f25030a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f25031b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f25032c;

    static {
        boolean z10;
        if ("Amazon".equals(p0.f27682c)) {
            String str = p0.f27683d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z10 = true;
                f25029d = z10;
            }
        }
        z10 = false;
        f25029d = z10;
    }

    public d0(UUID uuid, byte[] bArr, boolean z10) {
        this.f25030a = uuid;
        this.f25031b = bArr;
        this.f25032c = z10;
    }
}
