package androidx.compose.ui.text.input;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
public final class z implements InputConnection {

    /* renamed from: a, reason: collision with root package name */
    private final q f6357a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f6358b;

    /* renamed from: c, reason: collision with root package name */
    private int f6359c;

    /* renamed from: d, reason: collision with root package name */
    private TextFieldValue f6360d;

    /* renamed from: e, reason: collision with root package name */
    private int f6361e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6362f;

    /* renamed from: g, reason: collision with root package name */
    private final List f6363g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private boolean f6364h = true;

    public z(TextFieldValue textFieldValue, q qVar, boolean z10) {
        this.f6357a = qVar;
        this.f6358b = z10;
        this.f6360d = textFieldValue;
    }

    private final void a(m mVar) {
        b();
        try {
            this.f6363g.add(mVar);
        } finally {
            c();
        }
    }

    private final boolean b() {
        this.f6359c++;
        return true;
    }

    private final boolean c() {
        int i11 = this.f6359c - 1;
        this.f6359c = i11;
        if (i11 == 0 && !this.f6363g.isEmpty()) {
            this.f6357a.e(CollectionsKt.U0(this.f6363g));
            this.f6363g.clear();
        }
        return this.f6359c > 0;
    }

    private final void d(int i11) {
        sendKeyEvent(new KeyEvent(0, i11));
        sendKeyEvent(new KeyEvent(1, i11));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        boolean z10 = this.f6364h;
        return z10 ? b() : z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i11) {
        boolean z10 = this.f6364h;
        if (z10) {
            return false;
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.f6363g.clear();
        this.f6359c = 0;
        this.f6364h = false;
        this.f6357a.b(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo completionInfo) {
        boolean z10 = this.f6364h;
        if (z10) {
            return false;
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i11, Bundle bundle) {
        boolean z10 = this.f6364h;
        if (z10) {
            return false;
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean z10 = this.f6364h;
        return z10 ? this.f6358b : z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i11) {
        boolean z10 = this.f6364h;
        if (z10) {
            a(new a(String.valueOf(charSequence), i11));
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i11, int i12) {
        boolean z10 = this.f6364h;
        if (!z10) {
            return z10;
        }
        a(new k(i11, i12));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i11, int i12) {
        boolean z10 = this.f6364h;
        if (!z10) {
            return z10;
        }
        a(new l(i11, i12));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return c();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        boolean z10 = this.f6364h;
        if (!z10) {
            return z10;
        }
        a(new n());
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i11) {
        return TextUtils.getCapsMode(this.f6360d.f(), androidx.compose.ui.text.b0.j(this.f6360d.e()), i11);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i11) {
        boolean z10 = (i11 & 1) != 0;
        this.f6362f = z10;
        if (z10) {
            this.f6361e = extractedTextRequest != null ? extractedTextRequest.token : 0;
        }
        return s.a(this.f6360d);
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i11) {
        if (androidx.compose.ui.text.b0.f(this.f6360d.e())) {
            return null;
        }
        return d0.a(this.f6360d).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i11, int i12) {
        return d0.b(this.f6360d, i11).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i11, int i12) {
        return d0.c(this.f6360d, i11).toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i11) {
        boolean z10 = this.f6364h;
        if (z10) {
            z10 = false;
            switch (i11) {
                case R.id.selectAll:
                    a(new c0(0, this.f6360d.f().length()));
                    break;
                case R.id.cut:
                    d(277);
                    break;
                case R.id.copy:
                    d(278);
                    break;
                case R.id.paste:
                    d(279);
                    break;
            }
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i11) {
        int a11;
        boolean z10 = this.f6364h;
        if (!z10) {
            return z10;
        }
        if (i11 != 0) {
            switch (i11) {
                case 2:
                    a11 = o.f6315b.c();
                    break;
                case 3:
                    a11 = o.f6315b.g();
                    break;
                case 4:
                    a11 = o.f6315b.h();
                    break;
                case 5:
                    a11 = o.f6315b.d();
                    break;
                case 6:
                    a11 = o.f6315b.b();
                    break;
                case 7:
                    a11 = o.f6315b.f();
                    break;
                default:
                    Log.w("RecordingIC", "IME sends unsupported Editor Action: " + i11);
                    a11 = o.f6315b.a();
                    break;
            }
        } else {
            a11 = o.f6315b.a();
        }
        this.f6357a.d(a11);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        boolean z10 = this.f6364h;
        if (z10) {
            return true;
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean z10) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14 = this.f6364h;
        if (!z14) {
            return z14;
        }
        boolean z15 = false;
        boolean z16 = (i11 & 1) != 0;
        boolean z17 = (i11 & 2) != 0;
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 33) {
            boolean z18 = (i11 & 16) != 0;
            boolean z19 = (i11 & 8) != 0;
            boolean z20 = (i11 & 4) != 0;
            if (i12 >= 34 && (i11 & 32) != 0) {
                z15 = true;
            }
            if (z18 || z19 || z20 || z15) {
                z11 = z15;
                z10 = z20;
                z13 = z19;
                z12 = z18;
            } else if (i12 >= 34) {
                z12 = true;
                z13 = true;
                z10 = true;
                z11 = true;
            } else {
                z11 = z15;
                z12 = true;
                z13 = true;
                z10 = true;
            }
        } else {
            z10 = false;
            z11 = false;
            z12 = true;
            z13 = true;
        }
        this.f6357a.c(z16, z17, z12, z13, z10, z11);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        boolean z10 = this.f6364h;
        if (!z10) {
            return z10;
        }
        this.f6357a.a(keyEvent);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i11, int i12) {
        boolean z10 = this.f6364h;
        if (z10) {
            a(new a0(i11, i12));
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i11) {
        boolean z10 = this.f6364h;
        if (z10) {
            a(new b0(String.valueOf(charSequence), i11));
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i11, int i12) {
        boolean z10 = this.f6364h;
        if (!z10) {
            return z10;
        }
        a(new c0(i11, i12));
        return true;
    }
}
