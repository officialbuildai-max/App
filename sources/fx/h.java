package fx;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import ck.j;
import com.blankj.utilcode.util.i;
import com.transsion.version.update.NoticeConfig;
import com.transsion.version.update.R$string;
import com.transsion.version.update.R$style;
import com.transsion.version.update.RemoteVersionInfo;
import com.transsion.version.update.UpdateManager;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes7.dex */
public final class h extends j {

    /* renamed from: g, reason: collision with root package name */
    public static final a f63165g = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final ex.b f63166b;

    /* renamed from: c, reason: collision with root package name */
    private Function1 f63167c;

    /* renamed from: d, reason: collision with root package name */
    private String f63168d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f63169e;

    /* renamed from: f, reason: collision with root package name */
    private RemoteVersionInfo f63170f;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a(Context context, RemoteVersionInfo remoteVersionInfo, boolean z10, Function1 callback) {
            Intrinsics.h(context, "context");
            Intrinsics.h(remoteVersionInfo, "remoteVersionInfo");
            Intrinsics.h(callback, "callback");
            h hVar = new h(context);
            hVar.o(remoteVersionInfo, z10);
            hVar.n(callback);
            return hVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context, R$style.BottomDialogTheme);
        Intrinsics.h(context, "context");
        ex.b c11 = ex.b.c(LayoutInflater.from(context), null, false);
        Intrinsics.g(c11, "inflate(...)");
        this.f63166b = c11;
        this.f63168d = "";
        setContentView(c11.getRoot());
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes = attributes == null ? new WindowManager.LayoutParams() : attributes;
            attributes.width = gk.a.f63748a.a(context);
            attributes.height = -2;
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: fx.d
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                h.l(h.this, dialogInterface);
            }
        });
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(h hVar, DialogInterface dialogInterface) {
        hVar.e();
    }

    private final void m(RemoteVersionInfo remoteVersionInfo) {
        String str;
        NoticeConfig noticeConfig;
        NoticeConfig noticeConfig2;
        NoticeConfig noticeConfig3;
        boolean z10 = remoteVersionInfo != null && remoteVersionInfo.getForceUpdate();
        String str2 = null;
        String updateTitle = (remoteVersionInfo == null || (noticeConfig3 = remoteVersionInfo.getNoticeConfig()) == null) ? null : noticeConfig3.getUpdateTitle();
        if (remoteVersionInfo != null && (noticeConfig2 = remoteVersionInfo.getNoticeConfig()) != null) {
            str2 = noticeConfig2.getUpdateDesc();
        }
        i.f(remoteVersionInfo != null ? remoteVersionInfo.getInstallPkgSize() : 0L, 1048576);
        if (remoteVersionInfo == null || (noticeConfig = remoteVersionInfo.getNoticeConfig()) == null || (str = noticeConfig.getUpdateVersionName()) == null) {
            str = "";
        }
        this.f63168d = str;
        try {
            Drawable applicationIcon = getContext().getPackageManager().getApplicationIcon(getContext().getPackageName());
            Intrinsics.g(applicationIcon, "getApplicationIcon(...)");
            this.f63166b.f62171d.setImageDrawable(applicationIcon);
        } catch (Exception unused) {
            this.f63166b.f62171d.setVisibility(8);
        }
        this.f63166b.f62178k.setText(getContext().getString(R$string.version, this.f63168d));
        if (updateTitle != null && updateTitle.length() != 0) {
            this.f63166b.f62177j.setText(updateTitle);
        }
        if (str2 != null && str2.length() != 0) {
            this.f63166b.f62174g.setText(str2);
        }
        setCancelable(!z10);
        setCanceledOnTouchOutside(true ^ z10);
        this.f63166b.f62169b.setVisibility(z10 ? 8 : 0);
    }

    private final void p() {
        this.f63166b.f62169b.setOnClickListener(new View.OnClickListener() { // from class: fx.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.q(h.this, view);
            }
        });
        this.f63166b.f62170c.setOnClickListener(new View.OnClickListener() { // from class: fx.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.r(h.this, view);
            }
        });
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: fx.g
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                h.s(h.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(h hVar, View view) {
        hVar.dismiss();
        Function1 function1 = hVar.f63167c;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(h hVar, View view) {
        RemoteVersionInfo remoteVersionInfo = hVar.f63170f;
        if (remoteVersionInfo == null || !remoteVersionInfo.getForceUpdate()) {
            hVar.dismiss();
        }
        Function1 function1 = hVar.f63167c;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(h hVar, DialogInterface dialogInterface) {
        a.C0856a.f(lg.a.f68962a, "update", "onShow Listener  " + hVar, false, 4, null);
        if (hVar.f63169e) {
            return;
        }
        UpdateManager.f57641f.a().h(hVar.f63168d);
    }

    @Override // ck.j
    public boolean b() {
        if (this.f63169e) {
            return true;
        }
        a.C0856a.g(lg.a.f68962a, "被弹窗拦截策略拦截 " + this, false, 2, null);
        return false;
    }

    @Override // ck.j
    public void f() {
        super.f();
        a.C0856a.f(lg.a.f68962a, "update", "onShow " + this, false, 4, null);
    }

    public final void n(Function1 callback) {
        Intrinsics.h(callback, "callback");
        this.f63167c = callback;
    }

    public final void o(RemoteVersionInfo remoteVersionInfo, boolean z10) {
        this.f63170f = remoteVersionInfo;
        m(remoteVersionInfo);
        this.f63169e = z10;
    }
}
