package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.c1;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.w0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.util.Locale;

/* loaded from: classes5.dex */
public class MBAlertDialog extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Button f40089a;

    /* renamed from: b, reason: collision with root package name */
    private Button f40090b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f40091c;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.widget.dialog.b f40092d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f40093e;

    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.widget.dialog.b f40094a;

        a(com.mbridge.msdk.widget.dialog.b bVar) {
            this.f40094a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.mbridge.msdk.widget.dialog.b bVar = this.f40094a;
            if (bVar != null) {
                bVar.b();
            }
            MBAlertDialog.this.cancel();
            MBAlertDialog.this.clear();
        }
    }

    /* loaded from: classes5.dex */
    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.widget.dialog.b f40096a;

        b(com.mbridge.msdk.widget.dialog.b bVar) {
            this.f40096a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.mbridge.msdk.widget.dialog.b bVar = this.f40096a;
            if (bVar != null) {
                bVar.a();
            }
            MBAlertDialog.this.cancel();
            MBAlertDialog.this.clear();
        }
    }

    public MBAlertDialog(Context context, com.mbridge.msdk.widget.dialog.b bVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(g0.a(context, "mbridge_cm_alertview", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        this.f40092d = bVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.f40093e = (TextView) inflate.findViewById(g0.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e11) {
                o0.a("MBAlertDialog", e11.getMessage());
            }
            try {
                this.f40091c = (TextView) inflate.findViewById(g0.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.f40090b = (Button) inflate.findViewById(g0.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f40089a = (Button) inflate.findViewById(g0.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
            } catch (Exception e12) {
                o0.a("MBAlertDialog", e12.getMessage());
            }
        }
        Button button = this.f40089a;
        if (button != null) {
            button.setOnClickListener(new a(bVar));
        }
        Button button2 = this.f40090b;
        if (button2 != null) {
            button2.setOnClickListener(new b(bVar));
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void a() {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            setTitle("Confirm to close? ");
            setContent("You will not be rewarded after closing the window");
            setConfirmText("Close it");
            setCancelText("Continue");
            return;
        }
        setTitle("确认关闭？");
        setContent("关闭后您将不会获得任何奖励噢~ ");
        setConfirmText("确认关闭");
        setCancelText("继续试玩");
    }

    private void a(int i11) {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            setTitle(i11 == com.mbridge.msdk.foundation.same.a.H ? "Confirm" : "Tips");
            setContent(i11 == com.mbridge.msdk.foundation.same.a.H ? "If you choose to continue, you will receive a reward after the end. Confirm closed?" : "If you choose to continue, you will receive a reward after the end. Whether to continue?");
            setConfirmText(i11 == com.mbridge.msdk.foundation.same.a.H ? "Close" : "Cancel");
            setCancelText("Continue");
            return;
        }
        setTitle(i11 == com.mbridge.msdk.foundation.same.a.H ? "确认关闭？" : "提示");
        setContent(i11 == com.mbridge.msdk.foundation.same.a.H ? "如果你选择继续，结束后将会获得奖励。确认关闭吗？" : "如果你选择继续，结束后将会获得奖励。是否继续？");
        setConfirmText(i11 == com.mbridge.msdk.foundation.same.a.H ? "确认关闭" : "取消");
        setCancelText("继续");
    }

    private void a(String str, String str2, String str3, String str4) {
        setTitle(str);
        setContent(str2);
        setConfirmText(str3);
        setCancelText(str4);
    }

    private void b() {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            setTitle("Confirm to close? ");
            setContent("You will not be rewarded after closing the window");
            setConfirmText("Close it");
            setCancelText("Continue");
            return;
        }
        setTitle("确认关闭？");
        setContent("关闭后您将不会获得任何奖励噢~ ");
        setConfirmText("确认关闭");
        setCancelText("继续观看");
    }

    public void clear() {
        if (this.f40092d != null) {
            this.f40092d = null;
        }
    }

    public com.mbridge.msdk.widget.dialog.b getListener() {
        return this.f40092d;
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

    public void makeDownloadAlert(String str) {
        com.mbridge.msdk.widget.dialog.a.a(this, str);
    }

    public void makeIVAlertView(int i11, String str) {
        try {
            String obj = w0.a(getContext(), "MBridge_ConfirmTitle" + str, "").toString();
            String obj2 = w0.a(getContext(), "MBridge_ConfirmContent" + str, "").toString();
            String obj3 = w0.a(getContext(), "MBridge_CancelText" + str, "").toString();
            String obj4 = w0.a(getContext(), "MBridge_ConfirmText" + str, "").toString();
            if (TextUtils.isEmpty(obj) && TextUtils.isEmpty(obj2) && TextUtils.isEmpty(obj3) && TextUtils.isEmpty(obj4)) {
                a(i11);
            } else {
                a(obj, obj2, obj3, obj4);
            }
        } catch (Exception e11) {
            o0.a("MBAlertDialog", e11.getMessage());
        }
    }

    public void makeInsAlert(String str) {
        com.mbridge.msdk.widget.dialog.a.b(this, str);
    }

    public void makePlayableAlertView() {
        g d11 = h.b().d(c.m().b());
        if (d11 != null) {
            a(d11.s(), d11.q(), d11.r(), d11.o());
        } else {
            a();
        }
    }

    public void makeRVAlertView(String str) {
        try {
            String obj = w0.a(getContext(), "MBridge_ConfirmTitle" + str, "").toString();
            String obj2 = w0.a(getContext(), "MBridge_ConfirmContent" + str, "").toString();
            String obj3 = w0.a(getContext(), "MBridge_CancelText" + str, "").toString();
            String obj4 = w0.a(getContext(), "MBridge_ConfirmText" + str, "").toString();
            g d11 = h.b().d(c.m().b());
            if (TextUtils.isEmpty(obj) && TextUtils.isEmpty(obj2) && TextUtils.isEmpty(obj3) && TextUtils.isEmpty(obj4)) {
                if (d11 != null) {
                    a(d11.s(), d11.q(), d11.r(), d11.p());
                    return;
                } else {
                    b();
                    return;
                }
            }
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(obj)) {
                if (d11 != null) {
                    obj = d11.s();
                } else if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    setTitle("Confirm to close? ");
                } else {
                    setTitle("确认关闭？");
                }
            }
            if (TextUtils.isEmpty(obj2)) {
                if (d11 != null) {
                    obj2 = d11.q();
                } else if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    setContent("You will not be rewarded after closing the window");
                } else {
                    setContent("关闭后您将不会获得任何奖励噢~ ");
                }
            }
            if (TextUtils.isEmpty(obj4)) {
                if (d11 != null) {
                    obj4 = d11.r();
                } else if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    setConfirmText("Close it");
                } else {
                    setConfirmText("确认关闭");
                }
            }
            if (TextUtils.isEmpty(obj3)) {
                if (d11 != null) {
                    obj3 = d11.p();
                } else if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    setCancelText("Continue");
                } else {
                    setCancelText("继续观看");
                }
            }
            a(obj, obj2, obj4, obj3);
        } catch (Exception e11) {
            o0.a("MBAlertDialog", e11.getMessage());
        }
    }

    public void onlyShow() {
        super.show();
    }

    public void setCancelText(String str) {
        Button button = this.f40089a;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
        Button button = this.f40090b;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setContent(String str) {
        TextView textView = this.f40091c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f40093e;
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
