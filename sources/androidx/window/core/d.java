package androidx.window.core;

import androidx.window.core.SpecificationComputer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
final class d extends SpecificationComputer {

    /* renamed from: b, reason: collision with root package name */
    private final Object f15377b;

    /* renamed from: c, reason: collision with root package name */
    private final String f15378c;

    /* renamed from: d, reason: collision with root package name */
    private final String f15379d;

    /* renamed from: e, reason: collision with root package name */
    private final e f15380e;

    /* renamed from: f, reason: collision with root package name */
    private final SpecificationComputer.VerificationMode f15381f;

    /* renamed from: g, reason: collision with root package name */
    private final WindowStrictModeException f15382g;

    /* loaded from: classes2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15383a;

        static {
            int[] iArr = new int[SpecificationComputer.VerificationMode.values().length];
            iArr[SpecificationComputer.VerificationMode.STRICT.ordinal()] = 1;
            iArr[SpecificationComputer.VerificationMode.LOG.ordinal()] = 2;
            iArr[SpecificationComputer.VerificationMode.QUIET.ordinal()] = 3;
            f15383a = iArr;
        }
    }

    public d(Object value, String tag, String message, e logger, SpecificationComputer.VerificationMode verificationMode) {
        Intrinsics.h(value, "value");
        Intrinsics.h(tag, "tag");
        Intrinsics.h(message, "message");
        Intrinsics.h(logger, "logger");
        Intrinsics.h(verificationMode, "verificationMode");
        this.f15377b = value;
        this.f15378c = tag;
        this.f15379d = message;
        this.f15380e = logger;
        this.f15381f = verificationMode;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(b(value, message));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        Intrinsics.g(stackTrace, "stackTrace");
        Object[] array = ArraysKt.R(stackTrace, 2).toArray(new StackTraceElement[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        windowStrictModeException.setStackTrace((StackTraceElement[]) array);
        this.f15382g = windowStrictModeException;
    }

    @Override // androidx.window.core.SpecificationComputer
    public Object a() {
        int i11 = a.f15383a[this.f15381f.ordinal()];
        if (i11 == 1) {
            throw this.f15382g;
        }
        if (i11 == 2) {
            this.f15380e.debug(this.f15378c, b(this.f15377b, this.f15379d));
            return null;
        }
        if (i11 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer c(String message, Function1 condition) {
        Intrinsics.h(message, "message");
        Intrinsics.h(condition, "condition");
        return this;
    }
}
