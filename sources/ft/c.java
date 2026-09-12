package ft;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f62584a;

    /* renamed from: b, reason: collision with root package name */
    private String f62585b;

    /* renamed from: c, reason: collision with root package name */
    private Function0 f62586c;

    /* renamed from: d, reason: collision with root package name */
    private int f62587d;

    /* renamed from: e, reason: collision with root package name */
    private int f62588e;

    /* renamed from: f, reason: collision with root package name */
    private Function0 f62589f;

    public c(TextView textView) {
        Intrinsics.h(textView, "textView");
        this.f62584a = textView;
        this.f62585b = "http://schemas.android.com/apk/res/android";
    }

    public final void a(Context context, AttributeSet attributeSet, int i11) {
        Intrinsics.h(context, "context");
        if (attributeSet != null) {
            String attributeValue = attributeSet.getAttributeValue(this.f62585b, MimeTypes.BASE_TYPE_TEXT);
            if (attributeValue != null && attributeValue.length() >= 2) {
                String substring = attributeValue.substring(1, attributeValue.length());
                Intrinsics.g(substring, "substring(...)");
                this.f62587d = b.a(substring);
            }
            String attributeValue2 = attributeSet.getAttributeValue(this.f62585b, "hint");
            if (attributeValue2 == null || attributeValue2.length() < 2) {
                return;
            }
            String substring2 = attributeValue2.substring(1, attributeValue2.length());
            Intrinsics.g(substring2, "substring(...)");
            this.f62588e = b.a(substring2);
        }
    }

    public void b(int i11) {
        this.f62588e = i11;
        if (i11 != 0) {
            this.f62584a.setHint(i11);
        }
    }

    public void c(CharSequence charSequence) {
        this.f62588e = 0;
        this.f62584a.setHint(charSequence);
    }

    @Override // ft.a
    public void changeLocal() {
        try {
            int i11 = this.f62587d;
            if (i11 != 0) {
                this.f62584a.setText(i11);
            }
            int i12 = this.f62588e;
            if (i12 != 0) {
                this.f62584a.setHint(i12);
            }
            Function0 function0 = this.f62589f;
            if (function0 != null) {
                this.f62584a.setText(function0 != null ? (CharSequence) function0.invoke() : null);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        Function0 function02 = this.f62586c;
        if (function02 != null) {
            function02.invoke();
        }
    }

    public void d(Function0 listener) {
        Intrinsics.h(listener, "listener");
        this.f62586c = listener;
    }

    public void e(Function0 function0) {
        this.f62589f = function0;
        this.f62587d = 0;
        this.f62584a.setText(function0 != null ? (CharSequence) function0.invoke() : null);
    }

    public void f(int i11) {
        this.f62587d = i11;
        if (i11 != 0) {
            this.f62584a.setText(i11);
        }
    }

    public void g(CharSequence charSequence) {
        this.f62589f = null;
        this.f62587d = 0;
        this.f62584a.setText(charSequence);
    }
}
