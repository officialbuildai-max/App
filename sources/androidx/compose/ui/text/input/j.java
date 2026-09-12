package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public abstract class j {
    /* JADX WARN: Code restructure failed: missing block: B:6:0x005d, code lost:
    
        if (c(r22, r8.g(), r8.c()) == false) goto L10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final android.view.inputmethod.CursorAnchorInfo.Builder a(android.view.inputmethod.CursorAnchorInfo.Builder r17, int r18, int r19, androidx.compose.ui.text.input.v r20, androidx.compose.ui.text.z r21, y.i r22) {
        /*
            r0 = r19
            r1 = r20
            r2 = r18
            r3 = r22
            int r4 = r1.a(r2)
            int r5 = r1.a(r0)
            int r6 = r5 - r4
            int r6 = r6 * 4
            float[] r6 = new float[r6]
            androidx.compose.ui.text.MultiParagraph r7 = r21.v()
            long r8 = androidx.compose.ui.text.c0.b(r4, r5)
            r5 = 0
            r7.a(r8, r6, r5)
        L22:
            if (r2 >= r0) goto L8e
            int r5 = r1.a(r2)
            int r7 = r5 - r4
            int r7 = r7 * 4
            y.i r8 = new y.i
            r9 = r6[r7]
            int r10 = r7 + 1
            r10 = r6[r10]
            int r11 = r7 + 2
            r11 = r6[r11]
            int r7 = r7 + 3
            r7 = r6[r7]
            r8.<init>(r9, r10, r11, r7)
            boolean r7 = r3.o(r8)
            float r9 = r8.f()
            float r10 = r8.i()
            boolean r9 = c(r3, r9, r10)
            if (r9 == 0) goto L63
            float r9 = r8.g()
            float r10 = r8.c()
            boolean r9 = c(r3, r9, r10)
            if (r9 != 0) goto L60
            goto L63
        L60:
            r9 = r21
            goto L66
        L63:
            r7 = r7 | 2
            goto L60
        L66:
            androidx.compose.ui.text.style.ResolvedTextDirection r5 = r9.c(r5)
            androidx.compose.ui.text.style.ResolvedTextDirection r10 = androidx.compose.ui.text.style.ResolvedTextDirection.Rtl
            if (r5 != r10) goto L73
            r5 = r7 | 4
            r16 = r5
            goto L75
        L73:
            r16 = r7
        L75:
            float r12 = r8.f()
            float r13 = r8.i()
            float r14 = r8.g()
            float r15 = r8.c()
            r10 = r17
            r11 = r2
            r10.addCharacterBounds(r11, r12, r13, r14, r15, r16)
            int r2 = r2 + 1
            goto L22
        L8e:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.j.a(android.view.inputmethod.CursorAnchorInfo$Builder, int, int, androidx.compose.ui.text.input.v, androidx.compose.ui.text.z, y.i):android.view.inputmethod.CursorAnchorInfo$Builder");
    }

    public static final CursorAnchorInfo b(CursorAnchorInfo.Builder builder, TextFieldValue textFieldValue, v vVar, androidx.compose.ui.text.z zVar, Matrix matrix, y.i iVar, y.i iVar2, boolean z10, boolean z11, boolean z12, boolean z13) {
        builder.reset();
        builder.setMatrix(matrix);
        int j11 = androidx.compose.ui.text.b0.j(textFieldValue.e());
        builder.setSelectionRange(j11, androidx.compose.ui.text.b0.i(textFieldValue.e()));
        if (z10) {
            d(builder, j11, vVar, zVar, iVar);
        }
        if (z11) {
            androidx.compose.ui.text.b0 d11 = textFieldValue.d();
            int j12 = d11 != null ? androidx.compose.ui.text.b0.j(d11.n()) : -1;
            androidx.compose.ui.text.b0 d12 = textFieldValue.d();
            int i11 = d12 != null ? androidx.compose.ui.text.b0.i(d12.n()) : -1;
            if (j12 >= 0 && j12 < i11) {
                builder.setComposingText(j12, textFieldValue.f().subSequence(j12, i11));
                a(builder, j12, i11, vVar, zVar, iVar);
            }
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 33 && z12) {
            g.a(builder, iVar2);
        }
        if (i12 >= 34 && z13) {
            i.a(builder, zVar, iVar);
        }
        return builder.build();
    }

    private static final boolean c(y.i iVar, float f11, float f12) {
        float f13 = iVar.f();
        if (f11 <= iVar.g() && f13 <= f11) {
            float i11 = iVar.i();
            if (f12 <= iVar.c() && i11 <= f12) {
                return true;
            }
        }
        return false;
    }

    private static final CursorAnchorInfo.Builder d(CursorAnchorInfo.Builder builder, int i11, v vVar, androidx.compose.ui.text.z zVar, y.i iVar) {
        if (i11 < 0) {
            return builder;
        }
        int a11 = vVar.a(i11);
        y.i e11 = zVar.e(a11);
        float l11 = RangesKt.l(e11.f(), 0.0f, o0.t.g(zVar.y()));
        boolean c11 = c(iVar, l11, e11.i());
        boolean c12 = c(iVar, l11, e11.c());
        boolean z10 = zVar.c(a11) == ResolvedTextDirection.Rtl;
        int i12 = (c11 || c12) ? 1 : 0;
        if (!c11 || !c12) {
            i12 |= 2;
        }
        builder.setInsertionMarkerLocation(l11, e11.i(), e11.c(), e11.c(), z10 ? i12 | 4 : i12);
        return builder;
    }
}
