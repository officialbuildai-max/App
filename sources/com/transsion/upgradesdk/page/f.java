package com.transsion.upgradesdk.page;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import bw.l;
import bw.n;
import com.tencent.mmkv.MMKV;
import com.transsion.upgradesdk.R$layout;
import com.transsion.upgradesdk.bean.UpgradeData;
import com.transsion.upgradesdk.manager.UpgradeDialogCallback;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/upgradesdk/page/f;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "upgradesdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class f extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    public TextView f56732a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f56733b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f56734c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f56735d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f56736e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f56737f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f56738g;

    /* renamed from: h, reason: collision with root package name */
    public UpgradeData f56739h;

    /* renamed from: i, reason: collision with root package name */
    public int f56740i = 1;

    /* renamed from: j, reason: collision with root package name */
    public final Lazy f56741j = LazyKt.b(new a(this));

    /* renamed from: k, reason: collision with root package name */
    public final Lazy f56742k = LazyKt.b(new b(this));

    /* renamed from: l, reason: collision with root package name */
    public final Lazy f56743l = LazyKt.b(new e(this));

    /* renamed from: m, reason: collision with root package name */
    public final Lazy f56744m = LazyKt.b(new c(this));

    public static void X() {
        new Handler().postDelayed(new Runnable() { // from class: aw.d
            @Override // java.lang.Runnable
            public final void run() {
                com.transsion.upgradesdk.page.f.c0();
            }
        }, 300L);
    }

    public static final void a0(f this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        UpgradeData upgradeData = this$0.f56739h;
        if (upgradeData == null) {
            Intrinsics.z("upgradeData");
            upgradeData = null;
        }
        if (!upgradeData.isForceUpdate()) {
            l.e(this$0.f56740i, ((Boolean) this$0.f56743l.getValue()).booleanValue(), "later", com.transsion.upgradesdk.bean.c.f56712c);
            UpgradeDialogCallback upgradeDialogCallback = yv.f.f79190o.a().f79198g;
            if (upgradeDialogCallback != null) {
                upgradeDialogCallback.onDialogClick(3);
            }
            this$0.dismiss();
            return;
        }
        l.e(this$0.f56740i, ((Boolean) this$0.f56743l.getValue()).booleanValue(), "exitapp", com.transsion.upgradesdk.bean.c.f56712c);
        UpgradeDialogCallback upgradeDialogCallback2 = yv.f.f79190o.a().f79198g;
        if (upgradeDialogCallback2 != null) {
            upgradeDialogCallback2.onDialogClick(2);
        }
        this$0.dismiss();
        X();
    }

    public static final boolean b0(f this$0, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        Intrinsics.h(this$0, "this$0");
        if (i11 != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        UpgradeData upgradeData = this$0.f56739h;
        if (upgradeData == null) {
            Intrinsics.z("upgradeData");
            upgradeData = null;
        }
        if (upgradeData.isForceUpdate()) {
            l.e(this$0.f56740i, ((Boolean) this$0.f56743l.getValue()).booleanValue(), "back_exit", com.transsion.upgradesdk.bean.c.f56712c);
            UpgradeDialogCallback upgradeDialogCallback = yv.f.f79190o.a().f79198g;
            if (upgradeDialogCallback != null) {
                upgradeDialogCallback.onDialogClick(5);
            }
            X();
            return false;
        }
        l.e(this$0.f56740i, ((Boolean) this$0.f56743l.getValue()).booleanValue(), "back", com.transsion.upgradesdk.bean.c.f56712c);
        UpgradeDialogCallback upgradeDialogCallback2 = yv.f.f79190o.a().f79198g;
        if (upgradeDialogCallback2 == null) {
            return false;
        }
        upgradeDialogCallback2.onDialogClick(4);
        return false;
    }

    public static final void c0() {
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public static final void d0(f this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        l.e(this$0.f56740i, ((Boolean) this$0.f56743l.getValue()).booleanValue(), "update", com.transsion.upgradesdk.bean.c.f56712c);
        UpgradeDialogCallback upgradeDialogCallback = yv.f.f79190o.a().f79198g;
        if (upgradeDialogCallback != null) {
            upgradeDialogCallback.onDialogClick(1);
        }
        UpgradeData upgradeData = this$0.f56739h;
        UpgradeData upgradeData2 = null;
        if (upgradeData == null) {
            Intrinsics.z("upgradeData");
            upgradeData = null;
        }
        String pkg = upgradeData.getPkg();
        UpgradeData upgradeData3 = this$0.f56739h;
        if (upgradeData3 == null) {
            Intrinsics.z("upgradeData");
            upgradeData3 = null;
        }
        int directDwl = upgradeData3.getDirectDwl();
        UpgradeData upgradeData4 = this$0.f56739h;
        if (upgradeData4 == null) {
            Intrinsics.z("upgradeData");
        } else {
            upgradeData2 = upgradeData4;
        }
        n.c(pkg, directDwl, upgradeData2.getHoverBtn(), new d(this$0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x018e, code lost:
    
        r11 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y(android.view.View r11) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.upgradesdk.page.f.Y(android.view.View):void");
    }

    public final void Z(FragmentManager manager) {
        Intrinsics.h(manager, "manager");
        if (manager.L0() || manager.T0()) {
            return;
        }
        Fragment k02 = manager.k0("UpgradeBottomDialog");
        if ((k02 == null || !k02.isAdded()) && !isAdded()) {
            show(manager, "UpgradeBottomDialog");
        }
    }

    public final void e0() {
        TextView textView = this.f56737f;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: aw.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.transsion.upgradesdk.page.f.a0(com.transsion.upgradesdk.page.f.this, view);
                }
            });
        }
        TextView textView2 = this.f56738g;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: aw.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.transsion.upgradesdk.page.f.d0(com.transsion.upgradesdk.page.f.this, view);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.h(inflater, "inflater");
        View inflate = inflater.inflate(((Number) this.f56744m.getValue()).intValue() == 1 ? R$layout.upgradesdk_layout_dialog_os16 : R$layout.upgradesdk_layout_dialog_os15, viewGroup, false);
        try {
            UpgradeData upgradeData = yv.f.f79190o.a().f79193b;
            Intrinsics.e(upgradeData);
            this.f56739h = upgradeData;
            if (upgradeData == null) {
                Intrinsics.z("upgradeData");
                upgradeData = null;
            }
            this.f56740i = upgradeData.isForceUpdate() ? 2 : 1;
            Intrinsics.e(inflate);
            Y(inflate);
        } catch (Exception unused) {
            dismiss();
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        yv.f a11 = yv.f.f79190o.a();
        Intrinsics.h(this, "dialog");
        if (a11.f79200i == this) {
            a11.f79200i = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        UpgradeDialogCallback upgradeDialogCallback = yv.f.f79190o.a().f79198g;
        if (upgradeDialogCallback != null) {
            upgradeDialogCallback.onDialogDismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
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
        if (context2 == null || ((Boolean) this.f56743l.getValue()).booleanValue()) {
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

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: aw.a
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                    return com.transsion.upgradesdk.page.f.b0(com.transsion.upgradesdk.page.f.this, dialogInterface, i11, keyEvent);
                }
            });
        }
        Integer num = (Integer) this.f56741j.getValue();
        if (num != null) {
            int intValue = num.intValue();
            TextView textView = this.f56737f;
            if (textView != null) {
                textView.setTextColor(intValue);
            }
        }
        Integer num2 = (Integer) this.f56742k.getValue();
        if (num2 != null) {
            int intValue2 = num2.intValue();
            TextView textView2 = this.f56738g;
            if (textView2 != null) {
                textView2.setTextColor(intValue2);
            }
        }
        l.d(this.f56740i, ((Boolean) this.f56743l.getValue()).booleanValue(), com.transsion.upgradesdk.bean.c.f56712c);
        UpgradeDialogCallback upgradeDialogCallback = yv.f.f79190o.a().f79198g;
        if (upgradeDialogCallback != null) {
            upgradeDialogCallback.onDialogShow();
        }
    }
}
