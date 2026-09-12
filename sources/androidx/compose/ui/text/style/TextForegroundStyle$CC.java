package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.y4;
import androidx.compose.ui.text.style.l;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.compose.ui.text.style.TextForegroundStyle$-CC, reason: invalid class name */
/* loaded from: classes.dex */
public abstract /* synthetic */ class TextForegroundStyle$CC {
    public static l a(final l lVar, l lVar2) {
        float c11;
        boolean z10 = lVar2 instanceof b;
        if (!z10 || !(lVar instanceof b)) {
            return (!z10 || (lVar instanceof b)) ? (z10 || !(lVar instanceof b)) ? lVar2.b(new Function0<l>() { // from class: androidx.compose.ui.text.style.TextForegroundStyle$merge$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final l invoke() {
                    return l.this;
                }
            }) : lVar : lVar2;
        }
        y4 e11 = ((b) lVar2).e();
        c11 = k.c(lVar2.getAlpha(), new Function0<Float>() { // from class: androidx.compose.ui.text.style.TextForegroundStyle$merge$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(l.this.getAlpha());
            }
        });
        return new b(e11, c11);
    }

    public static l b(l lVar, Function0 function0) {
        return !Intrinsics.c(lVar, l.b.f6499b) ? lVar : (l) function0.invoke();
    }
}
