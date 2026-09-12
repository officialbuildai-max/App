package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private final long f5149a;

    /* renamed from: b, reason: collision with root package name */
    private final List f5150b;

    /* renamed from: c, reason: collision with root package name */
    private final MotionEvent f5151c;

    public y(long j11, List list, MotionEvent motionEvent) {
        this.f5149a = j11;
        this.f5150b = list;
        this.f5151c = motionEvent;
    }

    public final MotionEvent a() {
        return this.f5151c;
    }

    public final List b() {
        return this.f5150b;
    }
}
