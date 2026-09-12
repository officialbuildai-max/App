package androidx.compose.material;

import androidx.compose.ui.input.pointer.h0;
import androidx.compose.ui.input.pointer.v;
import androidx.compose.ui.input.pointer.w;
import androidx.compose.ui.platform.o2;
import java.util.List;

/* loaded from: classes.dex */
public abstract class DragGestureDetectorCopyKt {

    /* renamed from: a, reason: collision with root package name */
    private static final float f3431a;

    /* renamed from: b, reason: collision with root package name */
    private static final float f3432b;

    /* renamed from: c, reason: collision with root package name */
    private static final float f3433c;

    static {
        float g11 = o0.i.g((float) 0.125d);
        f3431a = g11;
        float g12 = o0.i.g(18);
        f3432b = g12;
        f3433c = g11 / g12;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x011b -> B:14:0x0126). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x015c -> B:11:0x015e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x017e -> B:14:0x0126). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(androidx.compose.ui.input.pointer.c r20, long r21, int r23, kotlin.jvm.functions.Function2 r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DragGestureDetectorCopyKt.a(androidx.compose.ui.input.pointer.c, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final boolean b(androidx.compose.ui.input.pointer.o oVar, long j11) {
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

    public static final float c(o2 o2Var, int i11) {
        return h0.g(i11, h0.f5073a.b()) ? o2Var.f() * f3433c : o2Var.f();
    }
}
