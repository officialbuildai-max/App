package androidx.compose.ui.platform;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.SessionMutex;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes.dex */
public final class i0 implements kotlinx.coroutines.n0 {

    /* renamed from: a, reason: collision with root package name */
    private final View f5879a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.compose.ui.text.input.e0 f5880b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlinx.coroutines.n0 f5881c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicReference f5882d = SessionMutex.a();

    public i0(View view, androidx.compose.ui.text.input.e0 e0Var, kotlinx.coroutines.n0 n0Var) {
        this.f5879a = view;
        this.f5880b = e0Var;
        this.f5881c = n0Var;
    }

    public final InputConnection a(EditorInfo editorInfo) {
        android.support.v4.media.session.c.a(SessionMutex.c(this.f5882d));
        return null;
    }

    public final boolean b() {
        android.support.v4.media.session.c.a(SessionMutex.c(this.f5882d));
        return false;
    }

    @Override // kotlinx.coroutines.n0
    public CoroutineContext getCoroutineContext() {
        return this.f5881c.getCoroutineContext();
    }
}
