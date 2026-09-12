package v0;

import android.view.View;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public float f77101a;

    /* renamed from: b, reason: collision with root package name */
    public int f77102b;

    /* renamed from: c, reason: collision with root package name */
    public int f77103c;

    /* renamed from: d, reason: collision with root package name */
    public int f77104d;

    /* renamed from: e, reason: collision with root package name */
    public int f77105e;

    public void a(View view) {
        this.f77102b = view.getLeft();
        this.f77103c = view.getTop();
        this.f77104d = view.getRight();
        this.f77105e = view.getBottom();
        this.f77101a = view.getRotation();
    }

    public int b() {
        return this.f77105e - this.f77103c;
    }

    public int c() {
        return this.f77104d - this.f77102b;
    }
}
