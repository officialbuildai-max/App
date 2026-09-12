package androidx.media3.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: g, reason: collision with root package name */
    public static final b f13713g = new b(-1, ViewCompat.MEASURED_STATE_MASK, 0, 0, -1, null);

    /* renamed from: a, reason: collision with root package name */
    public final int f13714a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13715b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13716c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13717d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13718e;

    /* renamed from: f, reason: collision with root package name */
    public final Typeface f13719f;

    public b(int i11, int i12, int i13, int i14, int i15, Typeface typeface) {
        this.f13714a = i11;
        this.f13715b = i12;
        this.f13716c = i13;
        this.f13717d = i14;
        this.f13718e = i15;
        this.f13719f = typeface;
    }

    public static b a(CaptioningManager.CaptionStyle captionStyle) {
        return new b(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f13713g.f13714a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f13713g.f13715b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f13713g.f13716c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f13713g.f13717d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f13713g.f13718e, captionStyle.getTypeface());
    }
}
