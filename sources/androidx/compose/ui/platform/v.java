package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewStructure;

/* loaded from: classes.dex */
final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f5942a = new v();

    private v() {
    }

    public final void a(ViewStructure viewStructure, View view) {
        viewStructure.setClassName(view.getAccessibilityClassName().toString());
    }
}
