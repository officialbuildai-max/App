package tj;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f76391a;

    /* renamed from: b, reason: collision with root package name */
    private String f76392b;

    /* renamed from: c, reason: collision with root package name */
    private Function0 f76393c;

    /* renamed from: d, reason: collision with root package name */
    private int f76394d;

    /* renamed from: e, reason: collision with root package name */
    private int f76395e;

    /* renamed from: f, reason: collision with root package name */
    private Function0 f76396f;

    public c(TextView textView) {
        Intrinsics.h(textView, "textView");
        this.f76391a = textView;
        this.f76392b = "http://schemas.android.com/apk/res/android";
    }

    public final void a(Context context, AttributeSet attributeSet, int i11) {
        Intrinsics.h(context, "context");
        if (attributeSet != null) {
            String attributeValue = attributeSet.getAttributeValue(this.f76392b, MimeTypes.BASE_TYPE_TEXT);
            if (attributeValue != null && attributeValue.length() >= 2) {
                String substring = attributeValue.substring(1, attributeValue.length());
                Intrinsics.g(substring, "substring(...)");
                this.f76394d = b.a(substring);
            }
            String attributeValue2 = attributeSet.getAttributeValue(this.f76392b, "hint");
            if (attributeValue2 == null || attributeValue2.length() < 2) {
                return;
            }
            String substring2 = attributeValue2.substring(1, attributeValue2.length());
            Intrinsics.g(substring2, "substring(...)");
            this.f76395e = b.a(substring2);
        }
    }

    public void b(int i11) {
        this.f76395e = i11;
        if (i11 != 0) {
            this.f76391a.setHint(i11);
        }
    }

    public void c(CharSequence charSequence) {
        this.f76395e = 0;
        this.f76391a.setHint(charSequence);
    }

    @Override // tj.a
    public void changeLocal() {
        try {
            if (this.f76394d != 0) {
                String string = this.f76391a.getContext().getString(this.f76394d);
                Intrinsics.g(string, "getString(...)");
                if (!Intrinsics.c(this.f76391a.getText().toString(), string)) {
                    this.f76391a.setText(this.f76394d);
                }
            }
            if (this.f76395e != 0) {
                String string2 = this.f76391a.getContext().getString(this.f76395e);
                Intrinsics.g(string2, "getString(...)");
                CharSequence hint = this.f76391a.getHint();
                if (!Intrinsics.c(hint != null ? hint.toString() : null, string2)) {
                    this.f76391a.setHint(this.f76395e);
                }
            }
            Function0 function0 = this.f76396f;
            if (function0 != null) {
                CharSequence charSequence = function0 != null ? (CharSequence) function0.invoke() : null;
                if (!Intrinsics.c(this.f76391a.getText().toString(), charSequence != null ? charSequence.toString() : null)) {
                    this.f76391a.setText(charSequence);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        Function0 function02 = this.f76393c;
        if (function02 != null) {
            function02.invoke();
        }
    }

    public void d(Function0 listener) {
        Intrinsics.h(listener, "listener");
        this.f76393c = listener;
    }

    public void e(Function0 function0) {
        this.f76396f = function0;
        this.f76394d = 0;
        this.f76391a.setText(function0 != null ? (CharSequence) function0.invoke() : null);
    }

    public void f(int i11) {
        this.f76394d = i11;
        if (i11 != 0) {
            this.f76391a.setText(i11);
        }
    }

    public void g(CharSequence charSequence) {
        this.f76396f = null;
        this.f76394d = 0;
        this.f76391a.setText(charSequence);
    }
}
