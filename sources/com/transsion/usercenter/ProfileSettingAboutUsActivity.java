package com.transsion.usercenter;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.Utils;
import com.transsion.baseui.activity.BaseActivity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/transsion/usercenter/ProfileSettingAboutUsActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lfw/j;", "<init>", "()V", "", "f0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "e0", "()Lfw/j;", "", "isTranslucent", "()Z", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class ProfileSettingAboutUsActivity extends BaseActivity<fw.j> {

    /* loaded from: classes6.dex */
    public static final class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.h(widget, "widget");
            com.tn.lib.widget.toast.core.h.f41533a.a("H5 Privacy Policy");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.h(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(androidx.core.content.b.getColor(Utils.a(), com.transsion.baseui.R$color.base_color_395CFF));
            ds2.setUnderlineText(false);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.h(widget, "widget");
            com.tn.lib.widget.toast.core.h.f41533a.a(" H5 User Agreement");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.h(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(androidx.core.content.b.getColor(Utils.a(), com.transsion.baseui.R$color.base_color_395CFF));
            ds2.setUnderlineText(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f0() {
        String obj = ((fw.j) getMViewBinding()).f62831d.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) obj);
        int o02 = StringsKt.o0(obj, "Privacy Policy", 0, false, 6, null);
        spannableStringBuilder.setSpan(new a(), o02, o02 + 14, 0);
        int v02 = StringsKt.v0(obj, "User Agreement", 0, false, 6, null);
        spannableStringBuilder.setSpan(new b(), v02, v02 + 14, 0);
        ((fw.j) getMViewBinding()).f62831d.setMovementMethod(LinkMovementMethod.getInstance());
        ((fw.j) getMViewBinding()).f62831d.setHighlightColor(0);
        ((fw.j) getMViewBinding()).f62831d.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public fw.j getViewBinding() {
        fw.j c11 = fw.j.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout root = ((fw.j) getMViewBinding()).getRoot();
        Intrinsics.g(root, "getRoot(...)");
        jg.c.e(root);
        ((fw.j) getMViewBinding()).f62830c.goneRightViewLayout();
        f0();
        ((fw.j) getMViewBinding()).f62833f.setText("V 1.0  todo 这里通过工具类获取");
        ((fw.j) getMViewBinding()).f62832e.setText("Oneroom   todo 这里通过工具类获取");
    }
}
