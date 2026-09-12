package kotlinx.serialization.json.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f68429a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final ArrayDeque f68430b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    private static int f68431c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f68432d;

    static {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.g(property, "getProperty(\"kotlinx.ser…lization.json.pool.size\")");
            m1185constructorimpl = Result.m1185constructorimpl(StringsKt.v(property));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        Integer num = (Integer) m1185constructorimpl;
        f68432d = num != null ? num.intValue() : 1048576;
    }

    private h() {
    }

    public final void a(char[] array) {
        Intrinsics.h(array, "array");
        synchronized (this) {
            try {
                int i11 = f68431c;
                if (array.length + i11 < f68432d) {
                    f68431c = i11 + array.length;
                    f68430b.addLast(array);
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final char[] b() {
        char[] cArr;
        synchronized (this) {
            cArr = (char[]) f68430b.q();
            if (cArr != null) {
                f68431c -= cArr.length;
            } else {
                cArr = null;
            }
        }
        return cArr == null ? new char[128] : cArr;
    }
}
