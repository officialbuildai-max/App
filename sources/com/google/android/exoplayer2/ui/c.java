package com.google.android.exoplayer2.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.core.view.ViewCompat;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: g, reason: collision with root package name */
    public static final c f27164g = new c(-1, ViewCompat.MEASURED_STATE_MASK, 0, 0, -1, null);

    /* renamed from: a, reason: collision with root package name */
    public final int f27165a;

    /* renamed from: b, reason: collision with root package name */
    public final int f27166b;

    /* renamed from: c, reason: collision with root package name */
    public final int f27167c;

    /* renamed from: d, reason: collision with root package name */
    public final int f27168d;

    /* renamed from: e, reason: collision with root package name */
    public final int f27169e;

    /* renamed from: f, reason: collision with root package name */
    public final Typeface f27170f;

    public c(int i11, int i12, int i13, int i14, int i15, Typeface typeface) {
        this.f27165a = i11;
        this.f27166b = i12;
        this.f27167c = i13;
        this.f27168d = i14;
        this.f27169e = i15;
        this.f27170f = typeface;
    }

    public static c a(CaptioningManager.CaptionStyle captionStyle) {
        return com.google.android.exoplayer2.util.p0.f27680a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    private static c b(CaptioningManager.CaptionStyle captionStyle) {
        return new c(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static c c(CaptioningManager.CaptionStyle captionStyle) {
        return new c(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f27164g.f27165a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f27164g.f27166b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f27164g.f27167c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f27164g.f27168d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f27164g.f27169e, captionStyle.getTypeface());
    }
}
