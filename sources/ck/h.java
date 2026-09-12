package ck;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.w;
import com.blankj.utilcode.util.y;
import com.transsion.baseui.R$color;
import com.transsion.baseui.R$id;
import com.transsion.baseui.R$layout;
import com.transsion.baseui.R$style;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class h extends w {

    /* renamed from: a, reason: collision with root package name */
    private ProgressBar f17324a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context, R$style.BaseTranslucentDialogStyle);
        Intrinsics.h(context, "context");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        ProgressBar progressBar = this.f17324a;
        if (progressBar != null) {
            jg.c.g(progressBar);
        }
    }

    @Override // androidx.appcompat.app.w, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        ProgressBar progressBar = this.f17324a;
        if (progressBar != null) {
            jg.c.g(progressBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.w, androidx.activity.q, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.base_dialog_loading);
        this.f17324a = (ProgressBar) findViewById(R$id.load_view);
        com.transsion.baseui.util.a aVar = com.transsion.baseui.util.a.f43556a;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        int a11 = (int) aVar.a(context, 28.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a11, a11);
        layoutParams.gravity = 49;
        int a12 = (y.a() / 2) - com.blankj.utilcode.util.d.c();
        Context context2 = getContext();
        Intrinsics.g(context2, "getContext(...)");
        layoutParams.topMargin = a12 - ((int) aVar.a(context2, 54.0f));
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(17);
            window.setWindowAnimations(0);
            window.setBackgroundDrawableResource(R$color.base_transparent);
            window.setDimAmount(0.0f);
            window.clearFlags(2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = y.e();
            attributes.height = y.a();
            window.setAttributes(attributes);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        ProgressBar progressBar = this.f17324a;
        if (progressBar != null) {
            jg.c.k(progressBar);
        }
    }
}
