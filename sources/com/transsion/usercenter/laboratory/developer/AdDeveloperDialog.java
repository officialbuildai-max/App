package com.transsion.usercenter.laboratory.developer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.blankj.utilcode.util.ToastUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import com.transsion.usercenter.laboratory.developer.AdDeveloperDialog;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import fw.q;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import qw.c;
import ti.m;
import ti.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/transsion/usercenter/laboratory/developer/AdDeveloperDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lkotlin/Function0;", "callback", "r0", "(Lkotlin/jvm/functions/Function0;)Lcom/transsion/usercenter/laboratory/developer/AdDeveloperDialog;", "c", "Lkotlin/jvm/functions/Function0;", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class AdDeveloperDialog extends BaseDialog {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function0 callback;

    /* loaded from: classes6.dex */
    public static final class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f56947a;

        public a(q qVar) {
            this.f56947a = qVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Editable text = this.f56947a.f62977d.getText();
            if (text == null || text.length() == 0) {
                this.f56947a.f62978e.setErrorEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public AdDeveloperDialog() {
        super(R$layout.ad_dialog_developer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(AdDeveloperDialog adDeveloperDialog, View view) {
        adDeveloperDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(q qVar, AdDeveloperDialog adDeveloperDialog, View view) {
        String lowerCase = qVar.f62977d.getText().toString().toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        m mVar = m.f76386a;
        c cVar = c.f74005a;
        if (!mVar.d(lowerCase, cVar.a())) {
            ToastUtils.s("密码错误，请重新输入！", new Object[0]);
            qVar.f62977d.setText("");
            return;
        }
        Function0 function0 = adDeveloperDialog.callback;
        if (function0 != null) {
            function0.invoke();
        }
        cVar.c(p.f76389a.c());
        adDeveloperDialog.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        setStyle(0, R$style.BaseDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final q a11 = q.a(view);
        Intrinsics.g(a11, "bind(...)");
        a11.f62975b.setOnClickListener(new View.OnClickListener() { // from class: qw.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdDeveloperDialog.p0(AdDeveloperDialog.this, view2);
            }
        });
        a11.f62976c.setOnClickListener(new View.OnClickListener() { // from class: qw.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdDeveloperDialog.q0(q.this, this, view2);
            }
        });
        a11.f62978e.setBoxBackgroundColor(0);
        EditText etPwd = a11.f62977d;
        Intrinsics.g(etPwd, "etPwd");
        etPwd.addTextChangedListener(new a(a11));
    }

    public final AdDeveloperDialog r0(Function0 callback) {
        Intrinsics.h(callback, "callback");
        this.callback = callback;
        return this;
    }
}
