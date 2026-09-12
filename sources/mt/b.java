package mt;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b implements lt.c {

    /* renamed from: a, reason: collision with root package name */
    private final lt.c f70110a;

    /* renamed from: b, reason: collision with root package name */
    private final int f70111b;

    /* renamed from: c, reason: collision with root package name */
    private final int f70112c;

    /* renamed from: d, reason: collision with root package name */
    private final int f70113d;

    /* renamed from: e, reason: collision with root package name */
    private final float f70114e;

    /* renamed from: f, reason: collision with root package name */
    private final float f70115f;

    public b(lt.c mStyle, int i11, int i12, int i13, float f11, float f12) {
        Intrinsics.h(mStyle, "mStyle");
        this.f70110a = mStyle;
        this.f70111b = i11;
        this.f70112c = i12;
        this.f70113d = i13;
        this.f70114e = f11;
        this.f70115f = f12;
    }

    @Override // lt.c
    public View createView(Context context) {
        View createView = this.f70110a.createView(context);
        Intrinsics.e(createView);
        return createView;
    }

    @Override // lt.c
    public int getGravity() {
        return this.f70111b;
    }

    @Override // lt.c
    public float getHorizontalMargin() {
        return this.f70114e;
    }

    @Override // lt.c
    public float getVerticalMargin() {
        return this.f70115f;
    }

    @Override // lt.c
    public int getXOffset() {
        return this.f70112c;
    }

    @Override // lt.c
    public int getYOffset() {
        return this.f70113d;
    }
}
