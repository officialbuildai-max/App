package androidx.media3.exoplayer.drm;

import android.os.Build;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class c0 implements androidx.media3.decoder.b {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f11650d;

    /* renamed from: a, reason: collision with root package name */
    public final UUID f11651a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f11652b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11653c;

    static {
        boolean z10;
        if ("Amazon".equals(Build.MANUFACTURER)) {
            String str = Build.MODEL;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z10 = true;
                f11650d = z10;
            }
        }
        z10 = false;
        f11650d = z10;
    }

    public c0(UUID uuid, byte[] bArr) {
        this(uuid, bArr, false);
    }

    public c0(UUID uuid, byte[] bArr, boolean z10) {
        this.f11651a = uuid;
        this.f11652b = bArr;
        this.f11653c = z10;
    }
}
