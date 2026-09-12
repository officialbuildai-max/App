package bi;

import java.lang.reflect.Field;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f16625a = new m();

    private m() {
    }

    public final Object a(Object instance, String fieldName) {
        Object m1185constructorimpl;
        Intrinsics.h(instance, "instance");
        Intrinsics.h(fieldName, "fieldName");
        try {
            Result.Companion companion = Result.INSTANCE;
            Field declaredField = instance.getClass().getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            m1185constructorimpl = Result.m1185constructorimpl(declaredField.get(instance));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            return null;
        }
        return m1185constructorimpl;
    }
}
