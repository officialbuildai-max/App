package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.e0;
import androidx.compose.ui.input.pointer.h0;
import androidx.compose.ui.input.pointer.v;
import androidx.compose.ui.input.pointer.w;
import androidx.compose.ui.platform.o2;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public abstract class DragGestureDetectorKt {

    /* renamed from: a, reason: collision with root package name */
    private static final float f2734a;

    /* renamed from: b, reason: collision with root package name */
    private static final float f2735b;

    /* renamed from: c, reason: collision with root package name */
    private static final float f2736c;

    static {
        float g11 = o0.i.g((float) 0.125d);
        f2734a = g11;
        float g12 = o0.i.g(18);
        f2735b = g12;
        f2736c = g11 / g12;
    }

    public static final Object b(e0 e0Var, Function3 function3, Function1 function1, Function0 function0, Function0 function02, Orientation orientation, Function2 function2, Continuation continuation) {
        Object c11 = ForEachGestureKt.c(e0Var, new DragGestureDetectorKt$detectDragGestures$9(function02, new Ref.LongRef(), orientation, function3, function2, function0, function1, null), continuation);
        return c11 == IntrinsicsKt.f() ? c11 : Unit.f67184a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x010b, code lost:
    
        if (((r8 != null ? r8 == androidx.compose.foundation.gestures.Orientation.Vertical ? y.g.n(r4) : y.g.m(r4) : y.g.k(r4)) == 0.0f) == false) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0083 -> B:10:0x0089). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(androidx.compose.ui.input.pointer.c r18, long r19, kotlin.jvm.functions.Function1 r21, kotlin.coroutines.Continuation r22) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.c(androidx.compose.ui.input.pointer.c, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(androidx.compose.ui.input.pointer.o oVar, long j11) {
        Object obj;
        List b11 = oVar.b();
        int size = b11.size();
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                obj = null;
                break;
            }
            obj = b11.get(i11);
            if (v.d(((w) obj).f(), j11)) {
                break;
            }
            i11++;
        }
        w wVar = (w) obj;
        if (wVar != null && wVar.i()) {
            z10 = true;
        }
        return true ^ z10;
    }

    public static final float e(o2 o2Var, int i11) {
        return h0.g(i11, h0.f5073a.b()) ? o2Var.f() * f2736c : o2Var.f();
    }
}
