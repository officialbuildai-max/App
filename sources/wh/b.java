package wh;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class b implements vh.c {

    /* renamed from: a, reason: collision with root package name */
    private final vh.c f77803a;

    /* renamed from: b, reason: collision with root package name */
    private final int f77804b;

    /* renamed from: c, reason: collision with root package name */
    private final int f77805c;

    /* renamed from: d, reason: collision with root package name */
    private final int f77806d;

    /* renamed from: e, reason: collision with root package name */
    private final float f77807e;

    /* renamed from: f, reason: collision with root package name */
    private final float f77808f;

    public b(vh.c mStyle, int i11, int i12, int i13, float f11, float f12) {
        Intrinsics.h(mStyle, "mStyle");
        this.f77803a = mStyle;
        this.f77804b = i11;
        this.f77805c = i12;
        this.f77806d = i13;
        this.f77807e = f11;
        this.f77808f = f12;
    }

    @Override // vh.c
    public View createView(Context context) {
        View createView = this.f77803a.createView(context);
        Intrinsics.e(createView);
        return createView;
    }

    @Override // vh.c
    public int getGravity() {
        return this.f77804b;
    }

    @Override // vh.c
    public float getHorizontalMargin() {
        return this.f77807e;
    }

    @Override // vh.c
    public float getVerticalMargin() {
        return this.f77808f;
    }

    @Override // vh.c
    public int getXOffset() {
        return this.f77805c;
    }

    @Override // vh.c
    public int getYOffset() {
        return this.f77806d;
    }
}
