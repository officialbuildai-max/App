package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;

/* loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        public static AutofillId a(View view) {
            return view.getAutofillId();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        static ContentCaptureSession a(View view) {
            return view.getContentCaptureSession();
        }
    }

    /* loaded from: classes.dex */
    private static class c {
        static void a(View view, int i11) {
            view.setImportantForContentCapture(i11);
        }
    }

    public static androidx.compose.ui.platform.coreshims.b a(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return androidx.compose.ui.platform.coreshims.b.b(a.a(view));
        }
        return null;
    }

    public static d b(View view) {
        ContentCaptureSession a11;
        if (Build.VERSION.SDK_INT < 29 || (a11 = b.a(view)) == null) {
            return null;
        }
        return d.f(a11, view);
    }

    public static void c(View view, int i11) {
        if (Build.VERSION.SDK_INT >= 30) {
            c.a(view, i11);
        }
    }
}
