package com.transsion.mbwidget.guide;

import android.app.Dialog;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.view.v;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.report.l;
import com.transsion.baseui.dialog.BaseDialogFragment;
import com.transsion.baseui.widget.text.GradientTextView;
import com.transsion.mbwidget.HotSubjectWidgetProvider;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.t1;
import lg.a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/transsion/mbwidget/guide/AddWidgetDialog;", "Lcom/transsion/baseui/dialog/BaseDialogFragment;", "Ltm/b;", "<init>", "()V", "", "p0", "n0", "o0", "initView", "onDestroyView", "Landroid/view/Window;", "window", "d0", "(Landroid/view/Window;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "c0", "Lkotlinx/coroutines/t1;", "e", "Lkotlinx/coroutines/t1;", "addWidgetJob", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "getOnDismissListener", "()Lkotlin/jvm/functions/Function0;", "t0", "(Lkotlin/jvm/functions/Function0;)V", "onDismissListener", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class AddWidgetDialog extends BaseDialogFragment<tm.b> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private t1 addWidgetJob;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function0 onDismissListener;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* renamed from: com.transsion.mbwidget.guide.AddWidgetDialog$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, tm.b> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, tm.b.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/transsion/mbwidget/databinding/DialogWidgetAddBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((LayoutInflater) obj, (ViewGroup) obj2, ((Boolean) obj3).booleanValue());
        }

        public final tm.b invoke(LayoutInflater p02, ViewGroup viewGroup, boolean z10) {
            Intrinsics.h(p02, "p0");
            return tm.b.c(p02, viewGroup, z10);
        }
    }

    public AddWidgetDialog() {
        super(AnonymousClass1.INSTANCE);
    }

    private final void n0() {
        Object m1185constructorimpl;
        boolean isRequestPinAppWidgetSupported;
        try {
            Result.Companion companion = Result.INSTANCE;
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(Utils.a());
            ComponentName componentName = new ComponentName(Utils.a(), (Class<?>) HotSubjectWidgetProvider.class);
            isRequestPinAppWidgetSupported = appWidgetManager.isRequestPinAppWidgetSupported();
            if (isRequestPinAppWidgetSupported) {
                appWidgetManager.requestPinAppWidget(componentName, null, PendingIntent.getBroadcast(Utils.a(), 0, new Intent(Utils.a(), (Class<?>) WidgetCallbackReceiver.class), 201326592));
                a j11 = com.transsion.mbwidget.d.f46293a.j();
                if (j11 != null) {
                    j11.a();
                }
                o0();
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.f(lg.a.f68962a, "DeskWidget_", "add-error:" + m1188exceptionOrNullimpl.getMessage(), false, 4, null);
        }
    }

    private final void o0() {
        t1 d11;
        if (com.transsion.mbwidget.d.f46293a.n()) {
            d11 = k.d(v.a(this), null, null, new AddWidgetDialog$checkMiUI$1(this, null), 3, null);
            this.addWidgetJob = d11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0() {
        requireContext().startActivity(new Intent(requireContext(), (Class<?>) WidgetGuideActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(AddWidgetDialog addWidgetDialog, View it) {
        Intrinsics.h(it, "it");
        addWidgetDialog.dismiss();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(AddWidgetDialog addWidgetDialog, View it) {
        Intrinsics.h(it, "it");
        addWidgetDialog.p0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(AddWidgetDialog addWidgetDialog, View it) {
        Intrinsics.h(it, "it");
        com.transsion.mbwidget.utils.a.f46337a.b();
        if (Build.VERSION.SDK_INT >= 26) {
            addWidgetDialog.n0();
        } else {
            addWidgetDialog.p0();
        }
        return Unit.f67184a;
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void c0() {
        if (l.f43413a.q()) {
            a0();
            return;
        }
        com.transsion.mbwidget.d dVar = com.transsion.mbwidget.d.f46293a;
        dVar.k().putLong("desk_widget_guide_show_time", System.currentTimeMillis());
        dVar.k().putLong("desk_widget_guide_show_first", 1L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void d0(Window window) {
        Intrinsics.h(window, "window");
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = -2;
        attributes.width = -1;
        window.setGravity(80);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(Z());
        }
        window.setAttributes(attributes);
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void initView() {
        ImageView closeIV = ((tm.b) getMViewBinding()).f76409c;
        Intrinsics.g(closeIV, "closeIV");
        jg.c.c(closeIV, 0L, new Function1() { // from class: com.transsion.mbwidget.guide.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q02;
                q02 = AddWidgetDialog.q0(AddWidgetDialog.this, (View) obj);
                return q02;
            }
        }, 1, null);
        GradientTextView tipsTv = ((tm.b) getMViewBinding()).f76410d;
        Intrinsics.g(tipsTv, "tipsTv");
        jg.c.c(tipsTv, 0L, new Function1() { // from class: com.transsion.mbwidget.guide.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r02;
                r02 = AddWidgetDialog.r0(AddWidgetDialog.this, (View) obj);
                return r02;
            }
        }, 1, null);
        TextView addTv = ((tm.b) getMViewBinding()).f76408b;
        Intrinsics.g(addTv, "addTv");
        jg.c.c(addTv, 0L, new Function1() { // from class: com.transsion.mbwidget.guide.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s02;
                s02 = AddWidgetDialog.s0(AddWidgetDialog.this, (View) obj);
                return s02;
            }
        }, 1, null);
        k.d(v.a(this), null, null, new AddWidgetDialog$initView$4(this, null), 3, null);
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.transsion.mbwidget.utils.a.f46337a.a();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        a j11 = com.transsion.mbwidget.d.f46293a.j();
        if (j11 != null) {
            j11.onDismiss();
        }
        Function0 function0 = this.onDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
        this.onDismissListener = null;
    }

    public final void t0(Function0 function0) {
        this.onDismissListener = function0;
    }
}
