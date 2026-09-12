package com.android.volley;

import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* loaded from: classes2.dex */
public class d implements k {

    /* renamed from: a, reason: collision with root package name */
    private int f19310a;

    /* renamed from: b, reason: collision with root package name */
    private int f19311b;

    /* renamed from: c, reason: collision with root package name */
    private final int f19312c;

    /* renamed from: d, reason: collision with root package name */
    private final float f19313d;

    public d() {
        this(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 1, 1.0f);
    }

    public d(int i11, int i12, float f11) {
        this.f19310a = i11;
        this.f19312c = i12;
        this.f19313d = f11;
    }

    @Override // com.android.volley.k
    public int a() {
        return this.f19311b;
    }

    @Override // com.android.volley.k
    public void b(VolleyError volleyError) {
        this.f19311b++;
        int i11 = this.f19310a;
        this.f19310a = i11 + ((int) (i11 * this.f19313d));
        if (!d()) {
            throw volleyError;
        }
    }

    @Override // com.android.volley.k
    public int c() {
        return this.f19310a;
    }

    protected boolean d() {
        return this.f19311b <= this.f19312c;
    }
}
