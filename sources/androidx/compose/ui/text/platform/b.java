package androidx.compose.ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.k1;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.y4;
import androidx.compose.ui.graphics.z4;
import androidx.compose.ui.text.MultiParagraph;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b {
    public static final void a(MultiParagraph multiParagraph, m1 m1Var, j1 j1Var, float f11, z4 z4Var, androidx.compose.ui.text.style.i iVar, z.h hVar, int i11) {
        m1Var.n();
        if (multiParagraph.u().size() <= 1) {
            b(multiParagraph, m1Var, j1Var, f11, z4Var, iVar, hVar, i11);
        } else if (j1Var instanceof b5) {
            b(multiParagraph, m1Var, j1Var, f11, z4Var, iVar, hVar, i11);
        } else if (j1Var instanceof y4) {
            List u11 = multiParagraph.u();
            int size = u11.size();
            float f12 = 0.0f;
            float f13 = 0.0f;
            for (int i12 = 0; i12 < size; i12++) {
                androidx.compose.ui.text.m mVar = (androidx.compose.ui.text.m) u11.get(i12);
                f13 += mVar.e().getHeight();
                f12 = Math.max(f12, mVar.e().getWidth());
            }
            Shader b11 = ((y4) j1Var).b(y.n.a(f12, f13));
            Matrix matrix = new Matrix();
            b11.getLocalMatrix(matrix);
            List u12 = multiParagraph.u();
            int size2 = u12.size();
            for (int i13 = 0; i13 < size2; i13++) {
                androidx.compose.ui.text.m mVar2 = (androidx.compose.ui.text.m) u12.get(i13);
                mVar2.e().j(m1Var, k1.a(b11), f11, z4Var, iVar, hVar, i11);
                m1Var.c(0.0f, mVar2.e().getHeight());
                matrix.setTranslate(0.0f, -mVar2.e().getHeight());
                b11.setLocalMatrix(matrix);
            }
        }
        m1Var.j();
    }

    private static final void b(MultiParagraph multiParagraph, m1 m1Var, j1 j1Var, float f11, z4 z4Var, androidx.compose.ui.text.style.i iVar, z.h hVar, int i11) {
        List u11 = multiParagraph.u();
        int size = u11.size();
        for (int i12 = 0; i12 < size; i12++) {
            androidx.compose.ui.text.m mVar = (androidx.compose.ui.text.m) u11.get(i12);
            mVar.e().j(m1Var, j1Var, f11, z4Var, iVar, hVar, i11);
            m1Var.c(0.0f, mVar.e().getHeight());
        }
    }
}
