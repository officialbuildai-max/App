package androidx.compose.ui;

import androidx.compose.ui.f;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes.dex */
public abstract class ComposedModifierKt {
    public static final f b(f fVar, Function1 function1, Function3 function3) {
        return fVar.e(new d(function1, function3));
    }

    public static /* synthetic */ f c(f fVar, Function1 function1, Function3 function3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = InspectableValueKt.a();
        }
        return b(fVar, function1, function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f d(final androidx.compose.runtime.i iVar, f fVar) {
        if (fVar.c(new Function1<f.b, Boolean>() { // from class: androidx.compose.ui.ComposedModifierKt$materializeImpl$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(f.b bVar) {
                return Boolean.valueOf(!(bVar instanceof d));
            }
        })) {
            return fVar;
        }
        iVar.x(1219399079);
        f fVar2 = (f) fVar.b(f.f4253a, new Function2<f, f.b, f>() { // from class: androidx.compose.ui.ComposedModifierKt$materializeImpl$result$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final f invoke(f fVar3, f.b bVar) {
                f d11;
                boolean z10 = bVar instanceof d;
                f fVar4 = bVar;
                if (z10) {
                    Function3 a11 = ((d) bVar).a();
                    Intrinsics.f(a11, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function3<androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
                    d11 = ComposedModifierKt.d(androidx.compose.runtime.i.this, (f) ((Function3) TypeIntrinsics.e(a11, 3)).invoke(f.f4253a, androidx.compose.runtime.i.this, 0));
                    fVar4 = d11;
                }
                return fVar3.e(fVar4);
            }
        });
        iVar.N();
        return fVar2;
    }

    public static final f e(androidx.compose.runtime.i iVar, f fVar) {
        iVar.P(439770924);
        f d11 = d(iVar, fVar);
        iVar.K();
        return d11;
    }
}
