package com.transsion.ad.bidding.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.Utils;
import com.hisavana.mediation.ad.ViewBinder;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    private final Context f41943a;

    public r(Context context) {
        Intrinsics.h(context, "context");
        this.f41943a = context;
    }

    private final void C(ViewBinder viewBinder) {
        ti.b bVar = ti.b.f76376a;
        View layout = viewBinder.layout;
        Intrinsics.g(layout, "layout");
        bVar.e(layout, viewBinder.callToActionId);
    }

    private final View f(Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View inflate = LayoutInflater.from(context).inflate(t(), (ViewGroup) null);
        Intrinsics.g(inflate, "inflate(...)");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(AppCompatTextView appCompatTextView) {
        try {
            Result.Companion companion = Result.INSTANCE;
            String lowerCase = appCompatTextView.getText().toString().toLowerCase(Locale.ROOT);
            Intrinsics.g(lowerCase, "toLowerCase(...)");
            if (ti.b.f76376a.b(lowerCase)) {
                appCompatTextView.setText(StringsKt.z(lowerCase));
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public Integer A() {
        return null;
    }

    public boolean B() {
        return true;
    }

    public Integer b() {
        return null;
    }

    public abstract Integer c();

    public Integer d() {
        return null;
    }

    public Integer e() {
        return null;
    }

    public final w g() {
        int t11 = t();
        View f11 = f(this.f41943a);
        Integer v11 = v();
        Integer z10 = z();
        Integer s11 = s();
        Integer l11 = l();
        Integer m11 = m();
        Integer c11 = c();
        Integer h11 = h();
        Integer d11 = d();
        return new w(Integer.valueOf(t11), f11, z10, s11, l11, v11, m11, x(), w(), y(), u(), o(), e(), b(), c11, d11, h11, n(), p(), j(), k(), i(), A());
    }

    public abstract Integer h();

    public abstract Integer i();

    public Integer j() {
        return null;
    }

    public Integer k() {
        return null;
    }

    public abstract Integer l();

    public abstract Integer m();

    public Integer n() {
        return null;
    }

    public Integer o() {
        return null;
    }

    public Integer p() {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f2, code lost:
    
        if (r5 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0101, code lost:
    
        if (r4 == null) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.hisavana.mediation.ad.ViewBinder q(com.transsion.ad.bidding.base.w r9, com.hisavana.common.bean.TAdNativeInfo r10) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.base.r.q(com.transsion.ad.bidding.base.w, com.hisavana.common.bean.TAdNativeInfo):com.hisavana.mediation.ad.ViewBinder");
    }

    public abstract Integer s();

    public abstract int t();

    public Integer u() {
        return null;
    }

    public abstract Integer v();

    public Integer w() {
        return null;
    }

    public Integer x() {
        return null;
    }

    public Integer y() {
        return null;
    }

    public abstract Integer z();
}
