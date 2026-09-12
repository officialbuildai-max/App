package androidx.window.core;

import androidx.window.core.SpecificationComputer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
final class f extends SpecificationComputer {

    /* renamed from: b, reason: collision with root package name */
    private final Object f15384b;

    /* renamed from: c, reason: collision with root package name */
    private final String f15385c;

    /* renamed from: d, reason: collision with root package name */
    private final SpecificationComputer.VerificationMode f15386d;

    /* renamed from: e, reason: collision with root package name */
    private final e f15387e;

    public f(Object value, String tag, SpecificationComputer.VerificationMode verificationMode, e logger) {
        Intrinsics.h(value, "value");
        Intrinsics.h(tag, "tag");
        Intrinsics.h(verificationMode, "verificationMode");
        Intrinsics.h(logger, "logger");
        this.f15384b = value;
        this.f15385c = tag;
        this.f15386d = verificationMode;
        this.f15387e = logger;
    }

    @Override // androidx.window.core.SpecificationComputer
    public Object a() {
        return this.f15384b;
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer c(String message, Function1 condition) {
        Intrinsics.h(message, "message");
        Intrinsics.h(condition, "condition");
        return ((Boolean) condition.invoke(this.f15384b)).booleanValue() ? this : new d(this.f15384b, this.f15385c, message, this.f15387e, this.f15386d);
    }
}
