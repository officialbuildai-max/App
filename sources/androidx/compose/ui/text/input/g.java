package androidx.compose.ui.text.input;

import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorBoundsInfo;
import androidx.compose.ui.graphics.u4;
import kotlin.jvm.JvmStatic;

/* loaded from: classes.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f6305a = new g();

    private g() {
    }

    @JvmStatic
    public static final CursorAnchorInfo.Builder a(CursorAnchorInfo.Builder builder, y.i iVar) {
        EditorBoundsInfo.Builder editorBounds;
        EditorBoundsInfo.Builder handwritingBounds;
        EditorBoundsInfo build;
        CursorAnchorInfo.Builder editorBoundsInfo;
        editorBounds = b.a().setEditorBounds(u4.c(iVar));
        handwritingBounds = editorBounds.setHandwritingBounds(u4.c(iVar));
        build = handwritingBounds.build();
        editorBoundsInfo = builder.setEditorBoundsInfo(build);
        return editorBoundsInfo;
    }
}
