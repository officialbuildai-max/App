package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final Object f5829a;

    /* renamed from: b, reason: collision with root package name */
    private final View f5830b;

    /* loaded from: classes.dex */
    private static class a {
        static Bundle a(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        static AutofillId a(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j11) {
            return contentCaptureSession.newAutofillId(autofillId, j11);
        }

        static ViewStructure b(ContentCaptureSession contentCaptureSession, View view) {
            return contentCaptureSession.newViewStructure(view);
        }

        static ViewStructure c(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j11) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, j11);
        }

        static void d(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        public static void e(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }

        static void f(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
        }
    }

    /* loaded from: classes.dex */
    private static class c {
        static void a(ContentCaptureSession contentCaptureSession, List<ViewStructure> list) {
            contentCaptureSession.notifyViewsAppeared(list);
        }
    }

    private d(ContentCaptureSession contentCaptureSession, View view) {
        this.f5829a = contentCaptureSession;
        this.f5830b = view;
    }

    public static d f(ContentCaptureSession contentCaptureSession, View view) {
        return new d(contentCaptureSession, view);
    }

    public AutofillId a(long j11) {
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        ContentCaptureSession a11 = androidx.compose.ui.platform.coreshims.c.a(this.f5829a);
        androidx.compose.ui.platform.coreshims.b a12 = e.a(this.f5830b);
        Objects.requireNonNull(a12);
        return b.a(a11, a12.a(), j11);
    }

    public f b(AutofillId autofillId, long j11) {
        if (Build.VERSION.SDK_INT >= 29) {
            return f.i(b.c(androidx.compose.ui.platform.coreshims.c.a(this.f5829a), autofillId, j11));
        }
        return null;
    }

    public void c(AutofillId autofillId, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.e(androidx.compose.ui.platform.coreshims.c.a(this.f5829a), autofillId, charSequence);
        }
    }

    public void d(List list) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            c.a(androidx.compose.ui.platform.coreshims.c.a(this.f5829a), list);
            return;
        }
        if (i11 >= 29) {
            ViewStructure b11 = b.b(androidx.compose.ui.platform.coreshims.c.a(this.f5829a), this.f5830b);
            a.a(b11).putBoolean("TREAT_AS_VIEW_TREE_APPEARING", true);
            b.d(androidx.compose.ui.platform.coreshims.c.a(this.f5829a), b11);
            for (int i12 = 0; i12 < list.size(); i12++) {
                b.d(androidx.compose.ui.platform.coreshims.c.a(this.f5829a), (ViewStructure) list.get(i12));
            }
            ViewStructure b12 = b.b(androidx.compose.ui.platform.coreshims.c.a(this.f5829a), this.f5830b);
            a.a(b12).putBoolean("TREAT_AS_VIEW_TREE_APPEARED", true);
            b.d(androidx.compose.ui.platform.coreshims.c.a(this.f5829a), b12);
        }
    }

    public void e(long[] jArr) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            ContentCaptureSession a11 = androidx.compose.ui.platform.coreshims.c.a(this.f5829a);
            androidx.compose.ui.platform.coreshims.b a12 = e.a(this.f5830b);
            Objects.requireNonNull(a12);
            b.f(a11, a12.a(), jArr);
            return;
        }
        if (i11 >= 29) {
            ViewStructure b11 = b.b(androidx.compose.ui.platform.coreshims.c.a(this.f5829a), this.f5830b);
            a.a(b11).putBoolean("TREAT_AS_VIEW_TREE_APPEARING", true);
            b.d(androidx.compose.ui.platform.coreshims.c.a(this.f5829a), b11);
            ContentCaptureSession a13 = androidx.compose.ui.platform.coreshims.c.a(this.f5829a);
            androidx.compose.ui.platform.coreshims.b a14 = e.a(this.f5830b);
            Objects.requireNonNull(a14);
            b.f(a13, a14.a(), jArr);
            ViewStructure b12 = b.b(androidx.compose.ui.platform.coreshims.c.a(this.f5829a), this.f5830b);
            a.a(b12).putBoolean("TREAT_AS_VIEW_TREE_APPEARED", true);
            b.d(androidx.compose.ui.platform.coreshims.c.a(this.f5829a), b12);
        }
    }
}
