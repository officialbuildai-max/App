package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

/* loaded from: classes4.dex */
final class o extends p {

    /* renamed from: b, reason: collision with root package name */
    private final int f32990b;

    /* renamed from: c, reason: collision with root package name */
    private final int f32991c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i11, int i12, int i13) {
        super(i11);
        if (i12 < 0 || i12 > 10 || i13 < 0 || i13 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.f32990b = i12;
        this.f32991c = i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f32990b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f32991c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f32990b == 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f32991c == 10;
    }
}
