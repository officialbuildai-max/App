package androidx.compose.animation.core;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final i f2496a;

    /* renamed from: b, reason: collision with root package name */
    private final AnimationEndReason f2497b;

    public e(i iVar, AnimationEndReason animationEndReason) {
        this.f2496a = iVar;
        this.f2497b = animationEndReason;
    }

    public String toString() {
        return "AnimationResult(endReason=" + this.f2497b + ", endState=" + this.f2496a + ')';
    }
}
