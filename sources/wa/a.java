package wa;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.R$attr;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final TimeInterpolator f77730a;

    /* renamed from: b, reason: collision with root package name */
    protected final View f77731b;

    /* renamed from: c, reason: collision with root package name */
    protected final int f77732c;

    /* renamed from: d, reason: collision with root package name */
    protected final int f77733d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f77734e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.activity.b f77735f;

    public a(View view) {
        this.f77731b = view;
        Context context = view.getContext();
        this.f77730a = j.g(context, R$attr.motionEasingStandardDecelerateInterpolator, PathInterpolatorCompat.create(0.0f, 0.0f, 0.0f, 1.0f));
        this.f77732c = j.f(context, R$attr.motionDurationMedium2, 300);
        this.f77733d = j.f(context, R$attr.motionDurationShort3, 150);
        this.f77734e = j.f(context, R$attr.motionDurationShort2, 100);
    }

    public float a(float f11) {
        return this.f77730a.getInterpolation(f11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public androidx.activity.b b() {
        if (this.f77735f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        androidx.activity.b bVar = this.f77735f;
        this.f77735f = null;
        return bVar;
    }

    public androidx.activity.b c() {
        androidx.activity.b bVar = this.f77735f;
        this.f77735f = null;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(androidx.activity.b bVar) {
        this.f77735f = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public androidx.activity.b e(androidx.activity.b bVar) {
        if (this.f77735f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        androidx.activity.b bVar2 = this.f77735f;
        this.f77735f = bVar;
        return bVar2;
    }
}
