package com.mbridge.msdk.foundation.feedback.bean;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.setting.b;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.FeedbackRadioGroup;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes5.dex */
public class a {
    private static int A = -1;
    private static String B;

    /* renamed from: b, reason: collision with root package name */
    private String f35349b;

    /* renamed from: c, reason: collision with root package name */
    private CampaignEx f35350c;

    /* renamed from: e, reason: collision with root package name */
    private FeedBackButton f35352e;

    /* renamed from: f, reason: collision with root package name */
    private String f35353f;

    /* renamed from: i, reason: collision with root package name */
    private String f35356i;

    /* renamed from: j, reason: collision with root package name */
    private MBFeedBackDialog f35357j;

    /* renamed from: k, reason: collision with root package name */
    private Dialog f35358k;

    /* renamed from: l, reason: collision with root package name */
    private JSONArray f35359l;

    /* renamed from: q, reason: collision with root package name */
    private int f35364q;

    /* renamed from: r, reason: collision with root package name */
    private List<g> f35365r;

    /* renamed from: u, reason: collision with root package name */
    private int f35368u;

    /* renamed from: a, reason: collision with root package name */
    private float f35348a = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private String f35351d = "";

    /* renamed from: g, reason: collision with root package name */
    private float f35354g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    private int f35355h = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f35360m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f35361n = -1;

    /* renamed from: o, reason: collision with root package name */
    private int f35362o = -1;

    /* renamed from: p, reason: collision with root package name */
    private int f35363p = -1;

    /* renamed from: s, reason: collision with root package name */
    private int f35366s = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 20.0f);

    /* renamed from: t, reason: collision with root package name */
    private String f35367t = "";

    /* renamed from: v, reason: collision with root package name */
    private com.mbridge.msdk.widget.dialog.b f35369v = new C0487a();

    /* renamed from: w, reason: collision with root package name */
    private int f35370w = A;

    /* renamed from: x, reason: collision with root package name */
    private int f35371x = -1;

    /* renamed from: y, reason: collision with root package name */
    private int f35372y = -1;

    /* renamed from: z, reason: collision with root package name */
    private int f35373z = -1;

    /* renamed from: com.mbridge.msdk.foundation.feedback.bean.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0487a implements com.mbridge.msdk.widget.dialog.b {
        C0487a() {
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void a() {
            a.this.m();
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void b() {
            a.this.l();
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void c() {
            a.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements com.mbridge.msdk.widget.dialog.b {
        c() {
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void a() {
            a.this.m();
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void b() {
            a.this.l();
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void c() {
            a.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (z10) {
                String unused = a.B = (String) compoundButton.getText();
            }
            if (a.this.f35357j != null) {
                a.this.f35357j.setCancelButtonClickable(!TextUtils.isEmpty(a.B));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.f35358k == null || !a.this.f35358k.isShowing()) {
                    return;
                }
                a.this.f35358k.dismiss();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* loaded from: classes5.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.p();
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements com.mbridge.msdk.widget.dialog.b {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.foundation.feedback.a f35380a;

        /* renamed from: b, reason: collision with root package name */
        private String f35381b;

        public g(String str, com.mbridge.msdk.foundation.feedback.a aVar) {
            this.f35380a = aVar;
            this.f35381b = str;
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void a() {
            com.mbridge.msdk.foundation.feedback.b.f35343f = false;
            com.mbridge.msdk.foundation.feedback.a aVar = this.f35380a;
            if (aVar != null) {
                aVar.close();
            }
        }

        public void a(int i11) {
            com.mbridge.msdk.foundation.feedback.b.f35343f = true;
            com.mbridge.msdk.foundation.feedback.a aVar = this.f35380a;
            if (aVar == null || i11 != 2) {
                return;
            }
            aVar.a();
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void b() {
            com.mbridge.msdk.foundation.feedback.b.f35343f = false;
            com.mbridge.msdk.foundation.feedback.a aVar = this.f35380a;
            if (aVar != null) {
                aVar.a(a.B);
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void c() {
            com.mbridge.msdk.foundation.feedback.a aVar = this.f35380a;
            if (aVar != null) {
                aVar.close();
            }
        }
    }

    public a(String str) {
        this.f35365r = new ArrayList();
        this.f35356i = str;
        if (this.f35365r == null) {
            this.f35365r = new ArrayList();
        }
        d();
        e();
        c();
    }

    private FeedbackRadioGroup a(b.C0537b c0537b) {
        JSONArray b11 = c0537b.b();
        Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (b11 == null || b11.length() <= 0 || d11 == null) {
            return null;
        }
        FeedbackRadioGroup feedbackRadioGroup = new FeedbackRadioGroup(d11);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    private void a(int i11) {
        if (i11 == 2) {
            com.mbridge.msdk.foundation.feedback.b.b().a(this.f35356i, 0, 2, B, this.f35351d);
        } else {
            com.mbridge.msdk.foundation.feedback.b.b().a(this.f35356i, 0, 3, B, this.f35351d);
        }
        List<g> list = this.f35365r;
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null) {
                    gVar.a(i11);
                }
            }
        }
    }

    private void a(Context context) {
        if (context != null) {
            try {
                com.mbridge.msdk.click.c.e(context, t0.a(this.f35350c));
            } catch (Exception unused) {
                com.mbridge.msdk.click.c.c(context, t0.a(this.f35350c));
            }
        }
    }

    private void a(RadioButton radioButton) {
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(new d());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.mbridge.msdk.widget.FeedbackRadioGroup r11, com.mbridge.msdk.setting.b.C0537b r12) {
        /*
            r10 = this;
            org.json.JSONArray r12 = r12.b()
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r0 = r0.d()
            if (r12 == 0) goto L7e
            int r1 = r12.length()
            if (r1 <= 0) goto L7e
            if (r0 == 0) goto L7e
            java.lang.String r1 = "mbridge_cm_feedback_choice_btn_bg"
            java.lang.String r2 = "drawable"
            com.mbridge.msdk.foundation.tools.g0.a(r0, r1, r2)
            android.content.res.Resources r1 = com.mbridge.msdk.foundation.tools.g0.a(r0)
            java.lang.String r2 = "mbridge_cm_feedback_rb_text_color_color_list"
            java.lang.String r3 = "color"
            int r2 = com.mbridge.msdk.foundation.tools.g0.a(r0, r2, r3)
            if (r1 == 0) goto L34
            android.content.res.ColorStateList r1 = r1.getColorStateList(r2)     // Catch: java.lang.Exception -> L30
            goto L35
        L30:
            r1 = move-exception
            r1.printStackTrace()
        L34:
            r1 = 0
        L35:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = com.mbridge.msdk.foundation.tools.t0.a(r0, r2)
            int r4 = com.mbridge.msdk.foundation.tools.t0.a(r0, r2)
            int r2 = com.mbridge.msdk.foundation.tools.t0.a(r0, r2)
            r5 = 0
        L44:
            int r6 = r12.length()
            if (r5 >= r6) goto L7e
            java.lang.String r6 = r12.optString(r5)
            android.widget.RadioButton r7 = new android.widget.RadioButton
            r7.<init>(r0)
            r7.setButtonTintList(r1)
            r7.setText(r6)
            if (r1 == 0) goto L5e
            r7.setTextColor(r1)
        L5e:
            r7.setCompoundDrawablePadding(r3)
            r7.setPadding(r3, r4, r3, r4)
            android.text.TextUtils$TruncateAt r6 = android.text.TextUtils.TruncateAt.END
            r7.setEllipsize(r6)
            android.widget.RadioGroup$LayoutParams r6 = new android.widget.RadioGroup$LayoutParams
            r8 = -1
            r9 = -2
            r6.<init>(r8, r9)
            int r8 = r2 / 4
            r6.setMargins(r2, r8, r2, r8)
            r10.a(r7)
            r11.addView(r7, r6)
            int r5 = r5 + 1
            goto L44
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.feedback.bean.a.a(com.mbridge.msdk.widget.FeedbackRadioGroup, com.mbridge.msdk.setting.b$b):void");
    }

    private void b() {
        FeedBackButton feedBackButton = this.f35352e;
        if (feedBackButton != null) {
            int i11 = this.f35372y;
            if (i11 > -1) {
                feedBackButton.setX(i11);
            }
            int i12 = this.f35373z;
            if (i12 > -1) {
                this.f35352e.setY(i12);
            }
            float f11 = this.f35348a;
            if (f11 >= 0.0f) {
                this.f35352e.setAlpha(f11);
                this.f35352e.setEnabled(this.f35348a != 0.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.f35352e.getLayoutParams();
            int i13 = this.f35371x;
            if (i13 > 0) {
                this.f35352e.setWidth(i13);
                if (layoutParams != null) {
                    layoutParams.width = this.f35371x;
                }
            }
            int i14 = this.f35355h;
            if (i14 > 0) {
                this.f35352e.setHeight(i14);
                if (layoutParams != null) {
                    layoutParams.height = this.f35355h;
                }
            }
            if (layoutParams != null) {
                this.f35352e.setLayoutParams(layoutParams);
            }
            try {
                if (!TextUtils.isEmpty(this.f35353f)) {
                    this.f35352e.setTextColor(Color.parseColor(this.f35353f));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            float f12 = this.f35354g;
            if (f12 > 0.0f) {
                this.f35352e.setTextSize(f12);
            }
            JSONArray jSONArray = this.f35359l;
            if (jSONArray != null && jSONArray.length() == 4) {
                Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                this.f35352e.setPadding(t0.a(d11, (float) this.f35359l.optDouble(0)), t0.a(d11, (float) this.f35359l.optDouble(1)), t0.a(d11, (float) this.f35359l.optDouble(2)), t0.a(d11, (float) this.f35359l.optDouble(3)));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i15 = this.f35366s;
            if (i15 > 0) {
                gradientDrawable.setCornerRadius(i15);
            }
            if (TextUtils.isEmpty(this.f35349b)) {
                gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            } else {
                gradientDrawable.setColor(Color.parseColor(this.f35349b));
            }
            this.f35352e.setBackground(gradientDrawable);
        }
    }

    private void c() {
        try {
            if (com.mbridge.msdk.foundation.feedback.b.b().a(com.mbridge.msdk.foundation.controller.c.m().d()) != null) {
                com.mbridge.msdk.setting.g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d11 == null) {
                    d11 = h.b().a();
                }
                b.C0537b z10 = d11.z();
                if (z10 == null) {
                    o0.c("", "feedback fbk is null");
                    return;
                }
                d();
                this.f35357j = new MBFeedBackDialog(com.mbridge.msdk.foundation.feedback.b.b().a(com.mbridge.msdk.foundation.controller.c.m().d()), this.f35369v);
                FeedbackRadioGroup a11 = a(z10);
                this.f35357j.setCancelText(z10.d());
                this.f35357j.setConfirmText(z10.a());
                this.f35357j.setPrivacyText(z10.c());
                this.f35367t = z10.e();
                this.f35357j.setTitle(z10.f());
                this.f35357j.setContent(a11);
                this.f35357j.setCancelButtonClickable(!TextUtils.isEmpty(B));
                a(a11, z10);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void d() {
        if (this.f35369v == null) {
            this.f35369v = new c();
        }
    }

    private void e() {
        Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (d11 != null) {
            try {
                FeedBackButton feedBackButton = new FeedBackButton(d11);
                this.f35352e = feedBackButton;
                int i11 = 8;
                if (this.f35370w != 8) {
                    i11 = 0;
                }
                feedBackButton.setVisibility(i11);
                this.f35352e.setOnClickListener(new b());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.mbridge.msdk.foundation.feedback.b.b().a(this.f35356i, 1, 4, B, this.f35351d);
        List<g> list = this.f35365r;
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null) {
                    gVar.b();
                }
            }
        }
        o();
        B = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.mbridge.msdk.foundation.feedback.b.b().a(this.f35356i, 0, 4, B, this.f35351d);
        List<g> list = this.f35365r;
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null) {
                    gVar.a();
                }
            }
        }
        B = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.mbridge.msdk.foundation.feedback.b.b().a(this.f35356i, 0, 4, B, this.f35351d);
        Context f11 = com.mbridge.msdk.foundation.controller.c.m().f();
        if (f11 == null) {
            f11 = com.mbridge.msdk.foundation.controller.c.m().d();
        }
        List<g> list = this.f35365r;
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null) {
                    gVar.a();
                }
            }
        }
        a(f11);
        B = "";
    }

    private void o() {
        if (TextUtils.isEmpty(this.f35367t)) {
            return;
        }
        try {
            Activity a11 = com.mbridge.msdk.foundation.feedback.b.b().a(com.mbridge.msdk.foundation.controller.c.m().d());
            if (a11 != null) {
                View inflate = LayoutInflater.from(a11).inflate(g0.a(a11, "mbridge_cm_feedback_notice_layout", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                Dialog dialog = new Dialog(a11, 3);
                this.f35358k = dialog;
                dialog.requestWindowFeature(1);
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = this.f35358k.getWindow();
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -2;
                layoutParams.height = -2;
                this.f35358k.setContentView(inflate);
                this.f35358k.show();
                window.setAttributes(layoutParams);
                inflate.postDelayed(new e(), 2000L);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(int i11, int i12, int i13, int i14, int i15, float f11, String str, String str2, float f12, JSONArray jSONArray) {
        if (i11 > -1) {
            this.f35372y = i11;
        }
        if (i12 > -1) {
            this.f35373z = i12;
        }
        if (i13 > -1) {
            this.f35371x = i13;
        }
        if (i14 > -1) {
            this.f35355h = i14;
        }
        if (f12 > -1.0f) {
            this.f35354g = f12;
        }
        if (jSONArray != null) {
            this.f35359l = jSONArray;
        }
        this.f35353f = str;
        this.f35349b = str2;
        this.f35348a = f11;
        this.f35366s = i15;
        b();
    }

    public void a(CampaignEx campaignEx) {
        this.f35350c = campaignEx;
    }

    public void a(g gVar) {
        if (this.f35365r == null) {
            this.f35365r = new ArrayList();
        }
        this.f35365r.add(gVar);
    }

    public void a(FeedBackButton feedBackButton) {
        FeedBackButton feedBackButton2 = this.f35352e;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.f35348a);
            feedBackButton.setEnabled(this.f35348a != 0.0f);
            feedBackButton.setVisibility(this.f35370w != 8 ? 0 : 8);
            this.f35352e = feedBackButton;
            CampaignEx campaignEx = this.f35350c;
            if (campaignEx != null && !campaignEx.isDynamicView()) {
                b();
            }
            feedBackButton.setOnClickListener(new f());
        }
    }

    public void b(int i11) {
        this.f35364q = i11;
    }

    public void b(String str) {
        this.f35351d = str;
    }

    public void c(int i11) {
        this.f35368u = i11;
    }

    public void d(int i11) {
        this.f35370w = i11;
        FeedBackButton feedBackButton = this.f35352e;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i11);
        }
    }

    public void f() {
        FeedBackButton feedBackButton = this.f35352e;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener(null);
            this.f35352e.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.f35352e.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f35352e);
            }
        }
        MBFeedBackDialog mBFeedBackDialog = this.f35357j;
        if (mBFeedBackDialog != null) {
            mBFeedBackDialog.cancel();
            this.f35357j.setListener(null);
        }
        this.f35357j = null;
        this.f35365r = null;
        this.f35352e = null;
        this.f35369v = null;
    }

    public void g() {
        MBFeedBackDialog mBFeedBackDialog = this.f35357j;
        if (mBFeedBackDialog == null || !mBFeedBackDialog.isShowing()) {
            return;
        }
        this.f35357j.cancel();
    }

    public CampaignEx h() {
        return this.f35350c;
    }

    public FeedBackButton i() {
        if (this.f35352e == null) {
            e();
        }
        return this.f35352e;
    }

    public int j() {
        return this.f35364q;
    }

    public int k() {
        return this.f35368u;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055 A[Catch: Exception -> 0x002a, TRY_LEAVE, TryCatch #0 {Exception -> 0x002a, blocks: (B:2:0x0000, B:4:0x0023, B:7:0x002f, B:9:0x003b, B:10:0x003f, B:13:0x0050, B:15:0x0055, B:21:0x002c), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003b A[Catch: Exception -> 0x002a, TryCatch #0 {Exception -> 0x002a, blocks: (B:2:0x0000, B:4:0x0023, B:7:0x002f, B:9:0x003b, B:10:0x003f, B:13:0x0050, B:15:0x0055, B:21:0x002c), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p() {
        /*
            r6 = this;
            com.mbridge.msdk.foundation.feedback.b r0 = com.mbridge.msdk.foundation.feedback.b.b()     // Catch: java.lang.Exception -> L2a
            java.lang.String r1 = r6.f35356i     // Catch: java.lang.Exception -> L2a
            java.lang.String r4 = com.mbridge.msdk.foundation.feedback.bean.a.B     // Catch: java.lang.Exception -> L2a
            java.lang.String r5 = r6.f35351d     // Catch: java.lang.Exception -> L2a
            r2 = 0
            r3 = 1
            r0.a(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2a
            com.mbridge.msdk.foundation.feedback.b r0 = com.mbridge.msdk.foundation.feedback.b.b()     // Catch: java.lang.Exception -> L2a
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L2a
            android.content.Context r1 = r1.d()     // Catch: java.lang.Exception -> L2a
            android.app.Activity r0 = r0.a(r1)     // Catch: java.lang.Exception -> L2a
            com.mbridge.msdk.widget.dialog.MBFeedBackDialog r1 = r6.f35357j     // Catch: java.lang.Exception -> L2a
            if (r1 == 0) goto L2c
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Exception -> L2a
            if (r1 == r0) goto L2f
            goto L2c
        L2a:
            r0 = move-exception
            goto L59
        L2c:
            r6.c()     // Catch: java.lang.Exception -> L2a
        L2f:
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L2a
            android.content.Context r0 = r0.d()     // Catch: java.lang.Exception -> L2a
            com.mbridge.msdk.widget.FeedBackButton r1 = r6.f35352e     // Catch: java.lang.Exception -> L2a
            if (r1 == 0) goto L3f
            android.content.Context r0 = r1.getContext()     // Catch: java.lang.Exception -> L2a
        L3f:
            com.mbridge.msdk.foundation.feedback.b r1 = com.mbridge.msdk.foundation.feedback.b.b()     // Catch: java.lang.Exception -> L2a
            java.lang.String r2 = r6.f35356i     // Catch: java.lang.Exception -> L2a
            com.mbridge.msdk.widget.dialog.MBFeedBackDialog r3 = r6.f35357j     // Catch: java.lang.Exception -> L2a
            boolean r1 = r1.a(r2, r0, r3)     // Catch: java.lang.Exception -> L2a
            if (r1 == 0) goto L4f
            r2 = 2
            goto L50
        L4f:
            r2 = 3
        L50:
            r6.a(r2)     // Catch: java.lang.Exception -> L2a
            if (r1 != 0) goto L5c
            r6.a(r0)     // Catch: java.lang.Exception -> L2a
            goto L5c
        L59:
            r0.printStackTrace()
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.feedback.bean.a.p():void");
    }
}
