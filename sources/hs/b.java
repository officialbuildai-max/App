package hs;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b implements gs.c {

    /* renamed from: a, reason: collision with root package name */
    private final gs.c f64953a;

    /* renamed from: b, reason: collision with root package name */
    private final int f64954b;

    /* renamed from: c, reason: collision with root package name */
    private final int f64955c;

    /* renamed from: d, reason: collision with root package name */
    private final int f64956d;

    /* renamed from: e, reason: collision with root package name */
    private final float f64957e;

    /* renamed from: f, reason: collision with root package name */
    private final float f64958f;

    public b(gs.c mStyle, int i11, int i12, int i13, float f11, float f12) {
        Intrinsics.h(mStyle, "mStyle");
        this.f64953a = mStyle;
        this.f64954b = i11;
        this.f64955c = i12;
        this.f64956d = i13;
        this.f64957e = f11;
        this.f64958f = f12;
    }

    @Override // gs.c
    public View createView(Context context) {
        View createView = this.f64953a.createView(context);
        Intrinsics.e(createView);
        return createView;
    }

    @Override // gs.c
    public int getGravity() {
        return this.f64954b;
    }

    @Override // gs.c
    public float getHorizontalMargin() {
        return this.f64957e;
    }

    @Override // gs.c
    public float getVerticalMargin() {
        return this.f64958f;
    }

    @Override // gs.c
    public int getXOffset() {
        return this.f64955c;
    }

    @Override // gs.c
    public int getYOffset() {
        return this.f64956d;
    }
}
