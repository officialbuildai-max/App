package aw;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import bw.l;
import bw.n;
import com.tencent.mmkv.MMKV;
import com.transsion.upgradesdk.R$id;
import com.transsion.upgradesdk.R$layout;
import com.transsion.upgradesdk.R$string;
import com.transsion.upgradesdk.bean.UpgradeData;
import com.transsion.upgradesdk.manager.UpgradeDialogCallback;
import com.transsion.upgradesdk.page.j;
import com.transsion.upgradesdk.page.k;
import java.math.BigDecimal;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class i extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    public TextView f16240a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f16241b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f16242c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f16243d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f16244e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f16245f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f16246g;

    /* renamed from: h, reason: collision with root package name */
    public UpgradeData f16247h;

    /* renamed from: i, reason: collision with root package name */
    public int f16248i = 1;

    /* renamed from: j, reason: collision with root package name */
    public final Lazy f16249j = LazyKt.b(new com.transsion.upgradesdk.page.g(this));

    /* renamed from: k, reason: collision with root package name */
    public final Lazy f16250k = LazyKt.b(new com.transsion.upgradesdk.page.h(this));

    /* renamed from: l, reason: collision with root package name */
    public final Lazy f16251l = LazyKt.b(new k(this));

    /* renamed from: m, reason: collision with root package name */
    public final Lazy f16252m = LazyKt.b(new com.transsion.upgradesdk.page.i(this));

    public static void a() {
        new Handler().postDelayed(new Runnable() { // from class: aw.h
            @Override // java.lang.Runnable
            public final void run() {
                i.e();
            }
        }, 300L);
    }

    public static final void c(i this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        UpgradeData upgradeData = this$0.f16247h;
        if (upgradeData == null) {
            Intrinsics.z("upgradeData");
            upgradeData = null;
        }
        if (!upgradeData.isForceUpdate()) {
            l.e(this$0.f16248i, ((Boolean) this$0.f16251l.getValue()).booleanValue(), "later", com.transsion.upgradesdk.bean.c.f56712c);
            UpgradeDialogCallback upgradeDialogCallback = yv.f.f79190o.a().f79198g;
            if (upgradeDialogCallback != null) {
                upgradeDialogCallback.onDialogClick(3);
            }
            this$0.dismiss();
            return;
        }
        l.e(this$0.f16248i, ((Boolean) this$0.f16251l.getValue()).booleanValue(), "exitapp", com.transsion.upgradesdk.bean.c.f56712c);
        UpgradeDialogCallback upgradeDialogCallback2 = yv.f.f79190o.a().f79198g;
        if (upgradeDialogCallback2 != null) {
            upgradeDialogCallback2.onDialogClick(2);
        }
        this$0.dismiss();
        a();
    }

    public static final boolean d(i this$0, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        Intrinsics.h(this$0, "this$0");
        if (i11 != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        UpgradeData upgradeData = this$0.f16247h;
        if (upgradeData == null) {
            Intrinsics.z("upgradeData");
            upgradeData = null;
        }
        if (upgradeData.isForceUpdate()) {
            l.e(this$0.f16248i, ((Boolean) this$0.f16251l.getValue()).booleanValue(), "back_exit", com.transsion.upgradesdk.bean.c.f56712c);
            UpgradeDialogCallback upgradeDialogCallback = yv.f.f79190o.a().f79198g;
            if (upgradeDialogCallback != null) {
                upgradeDialogCallback.onDialogClick(5);
            }
            a();
            return false;
        }
        l.e(this$0.f16248i, ((Boolean) this$0.f16251l.getValue()).booleanValue(), "back", com.transsion.upgradesdk.bean.c.f56712c);
        UpgradeDialogCallback upgradeDialogCallback2 = yv.f.f79190o.a().f79198g;
        if (upgradeDialogCallback2 == null) {
            return false;
        }
        upgradeDialogCallback2.onDialogClick(4);
        return false;
    }

    public static final void e() {
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public static final void f(i this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        l.e(this$0.f16248i, ((Boolean) this$0.f16251l.getValue()).booleanValue(), "update", com.transsion.upgradesdk.bean.c.f56712c);
        UpgradeDialogCallback upgradeDialogCallback = yv.f.f79190o.a().f79198g;
        if (upgradeDialogCallback != null) {
            upgradeDialogCallback.onDialogClick(1);
        }
        UpgradeData upgradeData = this$0.f16247h;
        UpgradeData upgradeData2 = null;
        if (upgradeData == null) {
            Intrinsics.z("upgradeData");
            upgradeData = null;
        }
        String pkg = upgradeData.getPkg();
        UpgradeData upgradeData3 = this$0.f16247h;
        if (upgradeData3 == null) {
            Intrinsics.z("upgradeData");
            upgradeData3 = null;
        }
        int directDwl = upgradeData3.getDirectDwl();
        UpgradeData upgradeData4 = this$0.f16247h;
        if (upgradeData4 == null) {
            Intrinsics.z("upgradeData");
        } else {
            upgradeData2 = upgradeData4;
        }
        n.c(pkg, directDwl, upgradeData2.getHoverBtn(), new j(this$0));
    }

    public final void b(View view) {
        double d11;
        String str;
        ImageView imageView;
        ViewStub viewStub = (ViewStub) view.findViewById(R$id.icon_stub);
        UpgradeData upgradeData = this.f16247h;
        UpgradeData upgradeData2 = null;
        if (upgradeData == null) {
            Intrinsics.z("upgradeData");
            upgradeData = null;
        }
        viewStub.setLayoutResource(Intrinsics.c(upgradeData.getPkg(), "com.transsion.phonemaster") ? R$layout.layout_icon_pm_style : R$layout.layout_icon_sdk_default);
        this.f16242c = (ImageView) viewStub.inflate().findViewById(R$id.iv_icon);
        this.f16240a = (TextView) view.findViewById(R$id.tv_name);
        this.f16241b = (TextView) view.findViewById(R$id.tv_version);
        this.f16243d = (TextView) view.findViewById(R$id.tv_size);
        this.f16244e = (TextView) view.findViewById(R$id.tv_message);
        this.f16245f = (TextView) view.findViewById(R$id.tv_cancel);
        this.f16246g = (TextView) view.findViewById(R$id.tv_ok);
        try {
            TextView textView = this.f16240a;
            if (textView != null) {
                textView.setText(StringsKt.n1(yv.f.f79190o.a().e().f77573c).toString());
            }
            Drawable drawable = yv.f.f79190o.a().e().f77572b;
            if (drawable != null && (imageView = this.f16242c) != null) {
                imageView.setImageDrawable(drawable);
            }
            TextView textView2 = this.f16241b;
            if (textView2 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getString(R$string.upgrade_sdk_text_version));
                sb2.append(":  ");
                UpgradeData upgradeData3 = this.f16247h;
                if (upgradeData3 == null) {
                    Intrinsics.z("upgradeData");
                    upgradeData3 = null;
                }
                sb2.append(upgradeData3.getPkgVersionName());
                textView2.setText(sb2.toString());
            }
            TextView textView3 = this.f16243d;
            if (textView3 != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(getString(R$string.upgrade_sdk_text_size));
                sb3.append(":  ");
                UpgradeData upgradeData4 = this.f16247h;
                if (upgradeData4 == null) {
                    Intrinsics.z("upgradeData");
                    upgradeData4 = null;
                }
                long pkgSize = upgradeData4.getPkgSize();
                if (pkgSize < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                    d11 = pkgSize / 1024;
                    str = "K";
                } else if (pkgSize < 1073741824) {
                    d11 = pkgSize / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    str = "M";
                } else {
                    d11 = pkgSize / 1073741824;
                    str = "G";
                }
                sb3.append(new BigDecimal(d11).setScale(1, 4).doubleValue() + str);
                textView3.setText(sb3.toString());
            }
            TextView textView4 = this.f16244e;
            if (textView4 != null) {
                UpgradeData upgradeData5 = this.f16247h;
                if (upgradeData5 == null) {
                    Intrinsics.z("upgradeData");
                    upgradeData5 = null;
                }
                textView4.setText(upgradeData5.getUpgradeMessage());
            }
            TextView textView5 = this.f16245f;
            if (textView5 != null) {
                UpgradeData upgradeData6 = this.f16247h;
                if (upgradeData6 == null) {
                    Intrinsics.z("upgradeData");
                } else {
                    upgradeData2 = upgradeData6;
                }
                Context context = textView5.getContext();
                Intrinsics.g(context, "getContext(...)");
                textView5.setText(upgradeData2.getCancelButtonText(context));
            }
            TextView textView6 = this.f16244e;
            if (textView6 != null) {
                textView6.setMovementMethod(new ScrollingMovementMethod());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            dismiss();
        }
        g();
    }

    public final void g() {
        TextView textView = this.f16245f;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: aw.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.c(i.this, view);
                }
            });
        }
        TextView textView2 = this.f16246g;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: aw.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.f(i.this, view);
                }
            });
        }
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.h(inflater, "inflater");
        View inflate = inflater.inflate(((Number) this.f16252m.getValue()).intValue() == 1 ? R$layout.upgradesdk_layout_dialog_os16 : R$layout.upgradesdk_layout_dialog_os15, viewGroup, false);
        try {
            UpgradeData upgradeData = yv.f.f79190o.a().f79193b;
            Intrinsics.e(upgradeData);
            this.f16247h = upgradeData;
            if (upgradeData == null) {
                Intrinsics.z("upgradeData");
                upgradeData = null;
            }
            this.f16248i = upgradeData.isForceUpdate() ? 2 : 1;
            Intrinsics.e(inflate);
            b(inflate);
        } catch (Exception unused) {
            dismiss();
        }
        return inflate;
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        yv.f a11 = yv.f.f79190o.a();
        Intrinsics.h(this, "dialog");
        if (a11.f79201j == this) {
            a11.f79201j = null;
        }
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        UpgradeDialogCallback upgradeDialogCallback = yv.f.f79190o.a().f79198g;
        if (upgradeDialogCallback != null) {
            upgradeDialogCallback.onDialogDismiss();
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onStart() {
        Window window;
        Context context;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (context = getContext()) != null) {
            Intrinsics.e(context);
            bw.d.a(window, context);
        }
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        Context context2 = getContext();
        if (context2 == null || ((Boolean) this.f16251l.getValue()).booleanValue()) {
            return;
        }
        bw.h hVar = bw.i.f17023b;
        bw.i a11 = hVar.a(context2);
        long currentTimeMillis = System.currentTimeMillis();
        Intrinsics.h("KV_UPGRADE_POPUP_LAST_TIME", "key");
        MMKV mmkv = a11.f17025a;
        if (mmkv != null) {
            mmkv.t("KV_UPGRADE_POPUP_LAST_TIME", currentTimeMillis);
        }
        bw.i a12 = hVar.a(context2);
        Intrinsics.h("KV_UPGRADE_POPUP_TIMES", "key");
        MMKV mmkv2 = a12.f17025a;
        int g11 = (mmkv2 != null ? mmkv2.g("KV_UPGRADE_POPUP_TIMES", 0) : 0) + 1;
        bw.i a13 = hVar.a(context2);
        Intrinsics.h("KV_UPGRADE_POPUP_TIMES", "key");
        MMKV mmkv3 = a13.f17025a;
        if (mmkv3 != null) {
            mmkv3.s("KV_UPGRADE_POPUP_TIMES", g11);
        }
    }

    @Override // android.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: aw.g
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                    return i.d(i.this, dialogInterface, i11, keyEvent);
                }
            });
        }
        Integer num = (Integer) this.f16249j.getValue();
        if (num != null) {
            int intValue = num.intValue();
            TextView textView = this.f16245f;
            if (textView != null) {
                textView.setTextColor(intValue);
            }
        }
        Integer num2 = (Integer) this.f16250k.getValue();
        if (num2 != null) {
            int intValue2 = num2.intValue();
            TextView textView2 = this.f16246g;
            if (textView2 != null) {
                textView2.setTextColor(intValue2);
            }
        }
        l.d(this.f16248i, ((Boolean) this.f16251l.getValue()).booleanValue(), com.transsion.upgradesdk.bean.c.f56712c);
        UpgradeDialogCallback upgradeDialogCallback = yv.f.f79190o.a().f79198g;
        if (upgradeDialogCallback != null) {
            upgradeDialogCallback.onDialogShow();
        }
    }
}
