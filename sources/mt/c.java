package mt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c implements lt.c {

    /* renamed from: a, reason: collision with root package name */
    private final int f70116a;

    /* renamed from: b, reason: collision with root package name */
    private final lt.c f70117b;

    public c(int i11, lt.c cVar) {
        this.f70116a = i11;
        this.f70117b = cVar;
    }

    @Override // lt.c
    public View createView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(this.f70116a, (ViewGroup) null);
        Intrinsics.g(inflate, "inflate(...)");
        return inflate;
    }

    @Override // lt.c
    public int getGravity() {
        lt.c cVar = this.f70117b;
        if (cVar != null) {
            return cVar.getGravity();
        }
        return 17;
    }

    @Override // lt.c
    public float getHorizontalMargin() {
        lt.c cVar = this.f70117b;
        if (cVar != null) {
            return cVar.getHorizontalMargin();
        }
        return 0.0f;
    }

    @Override // lt.c
    public float getVerticalMargin() {
        lt.c cVar = this.f70117b;
        if (cVar != null) {
            return cVar.getVerticalMargin();
        }
        return 0.0f;
    }

    @Override // lt.c
    public int getXOffset() {
        lt.c cVar = this.f70117b;
        if (cVar != null) {
            return cVar.getXOffset();
        }
        return 0;
    }

    @Override // lt.c
    public int getYOffset() {
        lt.c cVar = this.f70117b;
        if (cVar != null) {
            return cVar.getYOffset();
        }
        return 0;
    }
}
