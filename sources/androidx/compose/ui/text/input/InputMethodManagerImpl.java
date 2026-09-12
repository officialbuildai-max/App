package androidx.compose.ui.text.input;

import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class InputMethodManagerImpl implements r {

    /* renamed from: a, reason: collision with root package name */
    private final View f6273a;

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f6274b = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<InputMethodManager>() { // from class: androidx.compose.ui.text.input.InputMethodManagerImpl$imm$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final InputMethodManager invoke() {
            View view;
            view = InputMethodManagerImpl.this.f6273a;
            Object systemService = view.getContext().getSystemService("input_method");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            return (InputMethodManager) systemService;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final SoftwareKeyboardControllerCompat f6275c;

    public InputMethodManagerImpl(View view) {
        this.f6273a = view;
        this.f6275c = new SoftwareKeyboardControllerCompat(view);
    }

    private final InputMethodManager c() {
        return (InputMethodManager) this.f6274b.getValue();
    }

    @Override // androidx.compose.ui.text.input.r
    public void a(CursorAnchorInfo cursorAnchorInfo) {
        c().updateCursorAnchorInfo(this.f6273a, cursorAnchorInfo);
    }

    @Override // androidx.compose.ui.text.input.r
    public boolean isActive() {
        return c().isActive(this.f6273a);
    }
}
