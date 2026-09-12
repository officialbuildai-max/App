package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.tools.c1;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes5.dex */
public class MBFeedBackDialog extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Button f40098a;

    /* renamed from: b, reason: collision with root package name */
    private Button f40099b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f40100c;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.widget.dialog.b f40101d;

    /* renamed from: e, reason: collision with root package name */
    private Button f40102e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f40103f;

    /* renamed from: g, reason: collision with root package name */
    private int f40104g;

    /* renamed from: h, reason: collision with root package name */
    private int f40105h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MBFeedBackDialog.this.f40101d != null) {
                MBFeedBackDialog.this.f40101d.b();
            }
            MBFeedBackDialog.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MBFeedBackDialog.this.f40101d != null) {
                MBFeedBackDialog.this.f40101d.a();
            }
            MBFeedBackDialog.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBFeedBackDialog.this.dismiss();
            if (MBFeedBackDialog.this.f40101d != null) {
                MBFeedBackDialog.this.f40101d.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnCancelListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (MBFeedBackDialog.this.f40101d != null) {
                MBFeedBackDialog.this.f40101d.a();
            }
        }
    }

    public MBFeedBackDialog(Context context, com.mbridge.msdk.widget.dialog.b bVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(g0.a(context, "mbridge_cm_feedbackview", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        setDialogWidthAndHeight(0.5f, 0.8f);
        this.f40101d = bVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.f40103f = (TextView) inflate.findViewById(g0.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e11) {
                o0.a("MBAlertDialog", e11.getMessage());
            }
            try {
                this.f40100c = (LinearLayout) inflate.findViewById(g0.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.f40099b = (Button) inflate.findViewById(g0.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f40098a = (Button) inflate.findViewById(g0.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
                this.f40102e = (Button) inflate.findViewById(g0.a(context, "mbridge_video_common_alertview_private_action_button", "id"));
            } catch (Exception e12) {
                o0.a("MBAlertDialog", e12.getMessage());
            }
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        a();
    }

    private void a() {
        Button button = this.f40098a;
        if (button != null) {
            button.setOnClickListener(new a());
        }
        Button button2 = this.f40099b;
        if (button2 != null) {
            button2.setOnClickListener(new b());
        }
        Button button3 = this.f40102e;
        if (button3 != null) {
            button3.setOnClickListener(new c());
        }
        setOnCancelListener(new d());
    }

    public static boolean isScreenOrientationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public void clear() {
        if (this.f40101d != null) {
            this.f40101d = null;
        }
    }

    public com.mbridge.msdk.widget.dialog.b getListener() {
        return this.f40101d;
    }

    public void hideNavigationBar(Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            window.addFlags(67108864);
            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            c1.a(window);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.setGravity(17);
        }
    }

    public void setCancelButtonClickable(boolean z10) {
        Button button = this.f40098a;
        if (button != null) {
            button.setClickable(z10);
            if (z10) {
                this.f40098a.setBackgroundResource(getContext().getResources().getIdentifier("mbridge_cm_feedback_choice_btn_bg_pressed", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
                this.f40098a.setAlpha(1.0f);
            } else {
                this.f40098a.setBackgroundResource(getContext().getResources().getIdentifier("mbridge_cm_feedback_choice_btn_bg_pressed", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
                this.f40098a.setAlpha(0.4f);
            }
        }
    }

    public void setCancelText(String str) {
        Button button = this.f40098a;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
    }

    public void setContent(ViewGroup viewGroup) {
        LinearLayout linearLayout = this.f40100c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 16.0f);
            layoutParams.rightMargin = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 16.0f);
            layoutParams.topMargin = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 3.0f);
            layoutParams.bottomMargin = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 3.0f);
            this.f40100c.addView(viewGroup, layoutParams);
        }
    }

    public void setDialogWidthAndHeight(float f11, float f12) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (!isScreenOrientationPortrait(getContext())) {
            this.f40105h = displayMetrics.heightPixels;
            this.f40104g = displayMetrics.widthPixels;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = (int) (this.f40104g * f11);
            attributes.height = -1;
            attributes.gravity = 17;
            getWindow().setAttributes(attributes);
            return;
        }
        this.f40105h = displayMetrics.widthPixels;
        this.f40104g = displayMetrics.heightPixels;
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.width = -1;
        attributes2.height = (int) (this.f40104g * f12);
        attributes2.gravity = 80;
        getWindow().setAttributes(attributes2);
    }

    public void setListener(com.mbridge.msdk.widget.dialog.b bVar) {
        this.f40101d = bVar;
    }

    public void setPrivacyText(String str) {
        Button button = this.f40102e;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f40103f;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        try {
            getWindow().setFlags(8, 8);
            super.show();
            hideNavigationBar(getWindow());
            getWindow().clearFlags(8);
        } catch (Exception e11) {
            o0.b("MBAlertDialog", e11.getMessage());
            super.show();
        }
    }
}
