package androidx.compose.ui.platform;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import androidx.compose.ui.text.AnnotatedString;

/* loaded from: classes.dex */
public final class j implements q0 {

    /* renamed from: a, reason: collision with root package name */
    private final ClipboardManager f5899a;

    public j(ClipboardManager clipboardManager) {
        this.f5899a = clipboardManager;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public j(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "clipboard"
            java.lang.Object r2 = r2.getSystemService(r0)
            java.lang.String r0 = "null cannot be cast to non-null type android.content.ClipboardManager"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            android.content.ClipboardManager r2 = (android.content.ClipboardManager) r2
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.j.<init>(android.content.Context):void");
    }

    @Override // androidx.compose.ui.platform.q0
    public AnnotatedString a() {
        ClipData primaryClip = this.f5899a.getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            return null;
        }
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        return k.a(itemAt != null ? itemAt.getText() : null);
    }

    @Override // androidx.compose.ui.platform.q0
    public boolean b() {
        ClipDescription primaryClipDescription = this.f5899a.getPrimaryClipDescription();
        if (primaryClipDescription != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    @Override // androidx.compose.ui.platform.q0
    public void c(AnnotatedString annotatedString) {
        this.f5899a.setPrimaryClip(ClipData.newPlainText("plain text", k.b(annotatedString)));
    }
}
