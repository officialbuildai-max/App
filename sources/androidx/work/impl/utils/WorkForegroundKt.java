package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.model.j0;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m1;

/* loaded from: classes2.dex */
public abstract class WorkForegroundKt {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16021a;

    static {
        String i11 = androidx.work.t.i("WorkForegroundRunnable");
        Intrinsics.g(i11, "tagWithPrefix(...)");
        f16021a = i11;
    }

    public static final Object b(Context context, j0 j0Var, androidx.work.s sVar, androidx.work.j jVar, j4.c cVar, Continuation continuation) {
        if (!j0Var.f15862q || Build.VERSION.SDK_INT >= 31) {
            return Unit.f67184a;
        }
        Executor a11 = cVar.a();
        Intrinsics.g(a11, "getMainThreadExecutor(...)");
        Object g11 = kotlinx.coroutines.i.g(m1.b(a11), new WorkForegroundKt$workForeground$2(sVar, j0Var, jVar, context, null), continuation);
        return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
    }
}
