package bs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f17000a;

    /* renamed from: b, reason: collision with root package name */
    private String f17001b;

    /* renamed from: c, reason: collision with root package name */
    private Function0 f17002c;

    /* renamed from: d, reason: collision with root package name */
    private int f17003d;

    /* renamed from: e, reason: collision with root package name */
    private int f17004e;

    /* renamed from: f, reason: collision with root package name */
    private Function0 f17005f;

    public c(TextView textView) {
        Intrinsics.h(textView, "textView");
        this.f17000a = textView;
        this.f17001b = "http://schemas.android.com/apk/res/android";
    }

    public final void a(Context context, AttributeSet attributeSet, int i11) {
        Intrinsics.h(context, "context");
        if (attributeSet != null) {
            String attributeValue = attributeSet.getAttributeValue(this.f17001b, MimeTypes.BASE_TYPE_TEXT);
            if (attributeValue != null && attributeValue.length() >= 2) {
                String substring = attributeValue.substring(1, attributeValue.length());
                Intrinsics.g(substring, "substring(...)");
                this.f17003d = b.a(substring);
            }
            String attributeValue2 = attributeSet.getAttributeValue(this.f17001b, "hint");
            if (attributeValue2 == null || attributeValue2.length() < 2) {
                return;
            }
            String substring2 = attributeValue2.substring(1, attributeValue2.length());
            Intrinsics.g(substring2, "substring(...)");
            this.f17004e = b.a(substring2);
        }
    }

    public void b(int i11) {
        this.f17004e = i11;
        if (i11 != 0) {
            this.f17000a.setHint(i11);
        }
    }

    public void c(CharSequence charSequence) {
        this.f17004e = 0;
        this.f17000a.setHint(charSequence);
    }

    @Override // bs.a
    public void changeLocal() {
        try {
            int i11 = this.f17003d;
            if (i11 != 0) {
                this.f17000a.setText(i11);
            }
            int i12 = this.f17004e;
            if (i12 != 0) {
                this.f17000a.setHint(i12);
            }
            Function0 function0 = this.f17005f;
            if (function0 != null) {
                this.f17000a.setText(function0 != null ? (CharSequence) function0.invoke() : null);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        Function0 function02 = this.f17002c;
        if (function02 != null) {
            function02.invoke();
        }
    }

    public void d(Function0 listener) {
        Intrinsics.h(listener, "listener");
        this.f17002c = listener;
    }

    public void e(Function0 function0) {
        this.f17005f = function0;
        this.f17003d = 0;
        this.f17000a.setText(function0 != null ? (CharSequence) function0.invoke() : null);
    }

    public void f(int i11) {
        this.f17003d = i11;
        if (i11 != 0) {
            this.f17000a.setText(i11);
        }
    }

    public void g(CharSequence charSequence) {
        this.f17005f = null;
        this.f17003d = 0;
        this.f17000a.setText(charSequence);
    }
}
