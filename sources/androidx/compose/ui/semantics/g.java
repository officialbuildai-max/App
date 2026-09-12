package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final Function0 f6048a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f6049b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f6050c;

    public g(Function0 function0, Function0 function02, boolean z10) {
        this.f6048a = function0;
        this.f6049b = function02;
        this.f6050c = z10;
    }

    public final Function0 a() {
        return this.f6049b;
    }

    public final boolean b() {
        return this.f6050c;
    }

    public final Function0 c() {
        return this.f6048a;
    }

    public String toString() {
        return "ScrollAxisRange(value=" + ((Number) this.f6048a.invoke()).floatValue() + ", maxValue=" + ((Number) this.f6049b.invoke()).floatValue() + ", reverseScrolling=" + this.f6050c + ')';
    }
}
