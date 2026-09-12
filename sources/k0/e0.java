package k0;

import android.text.Layout;

/* loaded from: classes2.dex */
public abstract class e0 {
    public static final int a(Layout layout, int i11, boolean z10) {
        if (i11 <= 0) {
            return 0;
        }
        if (i11 >= layout.getText().length()) {
            return layout.getLineCount() - 1;
        }
        int lineForOffset = layout.getLineForOffset(i11);
        int lineStart = layout.getLineStart(lineForOffset);
        return (lineStart == i11 || layout.getLineEnd(lineForOffset) == i11) ? lineStart == i11 ? z10 ? lineForOffset - 1 : lineForOffset : z10 ? lineForOffset : lineForOffset + 1 : lineForOffset;
    }
}
