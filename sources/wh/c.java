package wh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class c implements vh.c {

    /* renamed from: a, reason: collision with root package name */
    private final int f77809a;

    /* renamed from: b, reason: collision with root package name */
    private final vh.c f77810b;

    public c(int i11, vh.c cVar) {
        this.f77809a = i11;
        this.f77810b = cVar;
    }

    @Override // vh.c
    public View createView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(this.f77809a, (ViewGroup) null);
        Intrinsics.g(inflate, "inflate(...)");
        return inflate;
    }

    @Override // vh.c
    public int getGravity() {
        vh.c cVar = this.f77810b;
        if (cVar != null) {
            return cVar.getGravity();
        }
        return 17;
    }

    @Override // vh.c
    public float getHorizontalMargin() {
        vh.c cVar = this.f77810b;
        if (cVar != null) {
            return cVar.getHorizontalMargin();
        }
        return 0.0f;
    }

    @Override // vh.c
    public float getVerticalMargin() {
        vh.c cVar = this.f77810b;
        if (cVar != null) {
            return cVar.getVerticalMargin();
        }
        return 0.0f;
    }

    @Override // vh.c
    public int getXOffset() {
        vh.c cVar = this.f77810b;
        if (cVar != null) {
            return cVar.getXOffset();
        }
        return 0;
    }

    @Override // vh.c
    public int getYOffset() {
        vh.c cVar = this.f77810b;
        if (cVar != null) {
            return cVar.getYOffset();
        }
        return 0;
    }
}
