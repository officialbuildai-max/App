package com.transsion.postdetail.ui.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.appcompat.app.w;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.a0;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$style;
import com.transsion.postdetail.bean.NegativeFeedbackAction;
import ej.f;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* loaded from: classes6.dex */
public final class h extends w {

    /* renamed from: d, reason: collision with root package name */
    public static final a f49502d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final List f49503e = CollectionsKt.o("dislike_post", "dislike_category", "dislike_user", "report");

    /* renamed from: a, reason: collision with root package name */
    private final List f49504a;

    /* renamed from: b, reason: collision with root package name */
    private final String f49505b;

    /* renamed from: c, reason: collision with root package name */
    private Function1 f49506c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, List actions, String pageName) {
        super(context, R$style.NegativeFeedbackDialogTheme);
        Intrinsics.h(context, "context");
        Intrinsics.h(actions, "actions");
        Intrinsics.h(pageName, "pageName");
        this.f49504a = actions;
        this.f49505b = pageName;
    }

    private final void i(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", "post_feedback");
        hashMap.put("module_name", str2);
        hj.i.f64628a.F(str, "feature_click", hashMap);
    }

    private final void k() {
        final View findViewById;
        final View findViewById2 = findViewById(R$id.dragHandle);
        if (findViewById2 == null || (findViewById = findViewById(R$id.llDialogRoot)) == null) {
            return;
        }
        final float a11 = a0.a(40.0f);
        findViewById.post(new Runnable() { // from class: com.transsion.postdetail.ui.dialog.f
            @Override // java.lang.Runnable
            public final void run() {
                h.l(findViewById2, findViewById);
            }
        });
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        findViewById2.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.postdetail.ui.dialog.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean m11;
                m11 = h.m(Ref.FloatRef.this, findViewById, a11, this, view, motionEvent);
                return m11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(View view, View view2) {
        int a11 = a0.a(20.0f);
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= a11;
        rect.bottom += a11;
        rect.left = 0;
        rect.right = view2.getWidth();
        view2.setTouchDelegate(new TouchDelegate(rect, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(Ref.FloatRef floatRef, View view, float f11, h hVar, View view2, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            floatRef.element = motionEvent.getRawY();
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                view.setTranslationY(RangesKt.e(motionEvent.getRawY() - floatRef.element, 0.0f));
                return true;
            }
            if (action != 3) {
                return false;
            }
        }
        if (motionEvent.getRawY() - floatRef.element > f11) {
            hVar.dismiss();
            return true;
        }
        view.animate().translationY(0.0f).setDuration(200L).start();
        return true;
    }

    private final void n() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.llOptions);
        if (linearLayout == null) {
            return;
        }
        final int i11 = 0;
        for (Object obj : this.f49504a) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            final NegativeFeedbackAction negativeFeedbackAction = (NegativeFeedbackAction) obj;
            View inflate = LayoutInflater.from(getContext()).inflate(R$layout.item_negative_feedback_option, (ViewGroup) linearLayout, false);
            AppCompatImageView appCompatImageView = (AppCompatImageView) inflate.findViewById(R$id.ivOptionIcon);
            String iconUrl = negativeFeedbackAction.getIconUrl();
            if (iconUrl == null || iconUrl.length() == 0) {
                appCompatImageView.setImageResource(R$drawable.ic_post_negative_feedback);
            } else {
                f.a aVar = ej.f.f62005a;
                Context context = getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b g11 = aVar.m(context).g(iconUrl);
                Intrinsics.e(appCompatImageView);
                g11.d(appCompatImageView);
            }
            ((AppCompatTextView) inflate.findViewById(R$id.tvOptionTitle)).setText(negativeFeedbackAction.getTitle());
            if (i11 > 0) {
                ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
                Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = a0.a(16.0f);
                inflate.setLayoutParams(layoutParams2);
            }
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.o(h.this, i11, negativeFeedbackAction, view);
                }
            });
            linearLayout.addView(inflate);
            i11 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(h hVar, int i11, NegativeFeedbackAction negativeFeedbackAction, View view) {
        String str = hVar.f49505b;
        List list = f49503e;
        hVar.i(str, (String) ((i11 < 0 || i11 >= list.size()) ? "" : list.get(i11)));
        Function1 function1 = hVar.f49506c;
        if (function1 != null) {
            function1.invoke(negativeFeedbackAction);
        }
        hVar.dismiss();
    }

    public final void j(Function1 function1) {
        this.f49506c = function1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.w, androidx.activity.q, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.dialog_negative_feedback);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setWindowAnimations(R$style.NegativeFeedbackDialogAnimation);
            window.setDimAmount(0.42f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        n();
        k();
    }
}
