package e7;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$string;
import com.cloud.hisavana.sdk.R$style;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.util.r;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.NativeBean;
import com.cloud.hisavana.sdk.e4;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class d extends Dialog {

    /* renamed from: l, reason: collision with root package name */
    public static final a f61687l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private Function0 f61688a;

    /* renamed from: b, reason: collision with root package name */
    private final TextView f61689b;

    /* renamed from: c, reason: collision with root package name */
    private final TextView f61690c;

    /* renamed from: d, reason: collision with root package name */
    private final TextView f61691d;

    /* renamed from: e, reason: collision with root package name */
    private final TextView f61692e;

    /* renamed from: f, reason: collision with root package name */
    private final ImageView f61693f;

    /* renamed from: g, reason: collision with root package name */
    private final ImageView f61694g;

    /* renamed from: h, reason: collision with root package name */
    private String f61695h;

    /* renamed from: i, reason: collision with root package name */
    private e f61696i;

    /* renamed from: j, reason: collision with root package name */
    private int f61697j;

    /* renamed from: k, reason: collision with root package name */
    private AdsDTO f61698k;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends e {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f61699f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j11, d dVar) {
            super(j11, 1000L);
            this.f61699f = dVar;
        }

        @Override // e7.e
        public void e() {
            this.f61699f.k(true);
        }

        @Override // e7.e
        public void f(long j11) {
            d dVar = this.f61699f;
            try {
                Result.Companion companion = Result.INSTANCE;
                int i11 = (int) ((j11 + DescriptorProtos$Edition.EDITION_PROTO3_VALUE) / 1000);
                if (dVar.f61691d != null) {
                    dVar.f61691d.setText(dVar.f61695h + " (" + i11 + "s)");
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, Function0 function0) {
        super(context, R$style.HSDialogTheme);
        Intrinsics.h(context, "context");
        this.f61688a = function0;
        this.f61695h = "";
        setCancelable(false);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: e7.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                boolean d11;
                d11 = d.d(d.this, dialogInterface, i11, keyEvent);
                return d11;
            }
        });
        View inflate = LayoutInflater.from(context).inflate(R$layout.hs_ad_bubble_popup_layout, (ViewGroup) null);
        setContentView(inflate);
        View findViewById = inflate.findViewById(R$id.tv_app_name);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.f61689b = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R$id.tv_app_size);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.f61690c = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R$id.tv_cta);
        Intrinsics.g(findViewById3, "findViewById(...)");
        TextView textView = (TextView) findViewById3;
        this.f61691d = textView;
        View findViewById4 = inflate.findViewById(R$id.tv_auto_start);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.f61692e = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R$id.iv_close);
        Intrinsics.g(findViewById5, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById5;
        this.f61693f = imageView;
        View findViewById6 = inflate.findViewById(R$id.iv_icon);
        Intrinsics.g(findViewById6, "findViewById(...)");
        this.f61694g = (ImageView) findViewById6;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: e7.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.e(d.this, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: e7.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.f(d.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(d this$0, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        Intrinsics.h(this$0, "this$0");
        if (i11 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        this$0.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(d this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(d this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        this$0.k(false);
    }

    private final void j() {
        try {
            Result.Companion companion = Result.INSTANCE;
            e eVar = this.f61696i;
            if (eVar != null) {
                eVar.d();
            }
            this.f61696i = null;
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(boolean z10) {
        try {
            Result.Companion companion = Result.INSTANCE;
            j();
            Function0 function0 = this.f61688a;
            if (function0 != null) {
                function0.invoke();
            }
            AthenaTracker.Z(this.f61698k, z10);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    private final void r() {
        j();
        this.f61696i = new b(this.f61697j * 1000, this).g();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            j();
            super.dismiss();
        } catch (Throwable th2) {
            e4.b().w("AdBubblePopupDialog", "hide failed: " + th2.getMessage());
        }
    }

    public final boolean l() {
        return isShowing();
    }

    public final void m(AdsDTO adsDTO) {
        Object m1185constructorimpl;
        PslinkInfo pslinkInfo;
        NativeBean nativeObject;
        this.f61698k = adsDTO;
        String str = null;
        String titleTxt = (adsDTO == null || (nativeObject = adsDTO.getNativeObject()) == null) ? null : nativeObject.getTitleTxt();
        if (titleTxt != null && titleTxt.length() != 0) {
            this.f61689b.setText(titleTxt);
        }
        n(adsDTO);
        r rVar = r.f22275a;
        AdsDTO adsDTO2 = this.f61698k;
        if (adsDTO2 != null && (pslinkInfo = adsDTO2.getPslinkInfo()) != null) {
            str = pslinkInfo.getSourceSize();
        }
        o(rVar.i(str));
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(getContext().getString(R$string.hs_bubble_install_btn));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = "Install it";
        }
        Intrinsics.g(m1185constructorimpl, "getOrDefault(...)");
        q((String) m1185constructorimpl);
        int autoRetentionTime = adsDTO != null ? adsDTO.getAutoRetentionTime() : 0;
        p(autoRetentionTime);
        if (autoRetentionTime > 0) {
            this.f61692e.setVisibility(0);
            this.f61692e.setText(getContext().getString(R$string.ad_bubble_auto_start, Integer.valueOf(autoRetentionTime)));
            return;
        }
        try {
            String string = getContext().getString(R$string.install);
            Intrinsics.g(string, "getString(...)");
            q(string);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th3) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th3));
        }
        this.f61692e.setVisibility(8);
    }

    public final void n(AdsDTO adsDTO) {
        NativeBean nativeObject;
        if (adsDTO != null && adsDTO.getSource() == 4) {
            DownLoadRequest.n(adsDTO.getLogoUrl(), adsDTO, null, this.f61694g);
            return;
        }
        String logoUrl = (adsDTO == null || (nativeObject = adsDTO.getNativeObject()) == null) ? null : nativeObject.getLogoUrl();
        if (logoUrl == null) {
            logoUrl = "";
        }
        DownLoadRequest.o(logoUrl, adsDTO, 1, null, this.f61694g);
    }

    public final void o(String size) {
        Intrinsics.h(size, "size");
        if (size.length() <= 0) {
            this.f61690c.setVisibility(8);
        } else {
            this.f61690c.setText(size);
            this.f61690c.setVisibility(0);
        }
    }

    public final void p(int i11) {
        this.f61697j = i11;
    }

    public final void q(String text) {
        Intrinsics.h(text, "text");
        this.f61695h = text;
        this.f61691d.setText(text);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            AthenaTracker.a0(this.f61698k);
            if (this.f61697j > 0) {
                r();
            }
        } catch (Throwable th2) {
            e4.b().w("AdBubblePopupDialog", "show failed: " + th2.getMessage());
        }
    }
}
