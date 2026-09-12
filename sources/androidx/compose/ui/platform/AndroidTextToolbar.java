package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class AndroidTextToolbar implements h2 {

    /* renamed from: a, reason: collision with root package name */
    private final View f5658a;

    /* renamed from: b, reason: collision with root package name */
    private ActionMode f5659b;

    /* renamed from: c, reason: collision with root package name */
    private final h0.b f5660c = new h0.b(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidTextToolbar$textActionModeCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m159invoke();
            return Unit.f67184a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m159invoke() {
            AndroidTextToolbar.this.f5659b = null;
        }
    }, null, null, null, null, null, 62, null);

    /* renamed from: d, reason: collision with root package name */
    private TextToolbarStatus f5661d = TextToolbarStatus.Hidden;

    public AndroidTextToolbar(View view) {
        this.f5658a = view;
    }

    @Override // androidx.compose.ui.platform.h2
    public void a(y.i iVar, Function0 function0, Function0 function02, Function0 function03, Function0 function04) {
        this.f5660c.l(iVar);
        this.f5660c.h(function0);
        this.f5660c.i(function03);
        this.f5660c.j(function02);
        this.f5660c.k(function04);
        ActionMode actionMode = this.f5659b;
        if (actionMode == null) {
            this.f5661d = TextToolbarStatus.Shown;
            this.f5659b = i2.f5898a.b(this.f5658a, new h0.a(this.f5660c), 1);
        } else if (actionMode != null) {
            actionMode.invalidate();
        }
    }

    @Override // androidx.compose.ui.platform.h2
    public TextToolbarStatus getStatus() {
        return this.f5661d;
    }

    @Override // androidx.compose.ui.platform.h2
    public void hide() {
        this.f5661d = TextToolbarStatus.Hidden;
        ActionMode actionMode = this.f5659b;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.f5659b = null;
    }
}
