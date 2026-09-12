package com.mbridge.msdk.dycreator.binding;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.dycreator.baseview.MBApkInfoView;
import com.mbridge.msdk.dycreator.baseview.MBFeedBack;
import com.mbridge.msdk.dycreator.baseview.MBLogoTextView;
import com.mbridge.msdk.dycreator.baseview.MBSplashClickView;
import com.mbridge.msdk.dycreator.baseview.MBSplashImageBgView;
import com.mbridge.msdk.dycreator.baseview.MBSplashPortView;
import com.mbridge.msdk.dycreator.baseview.MBSplashShakeView;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.subjectfactory.a;
import com.mbridge.msdk.dycreator.viewmodel.BaseViewModel;
import com.mbridge.msdk.dycreator.viewobserver.h;
import com.mbridge.msdk.dycreator.viewobserver.i;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.n0;
import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: g, reason: collision with root package name */
    private static volatile b f34786g;

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.dycreator.viewobserver.d f34787a = (com.mbridge.msdk.dycreator.viewobserver.d) com.mbridge.msdk.dycreator.subjectfactory.a.a().a(a.b.VIEW_OBSERVER);

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.dycreator.viewobserver.c f34788b = (com.mbridge.msdk.dycreator.viewobserver.c) com.mbridge.msdk.dycreator.subjectfactory.a.a().a(a.b.CLICK_OBSERVER);

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.dycreator.viewobserver.f f34789c = (com.mbridge.msdk.dycreator.viewobserver.f) com.mbridge.msdk.dycreator.subjectfactory.a.a().a(a.b.EFFECT_OBSERVER);

    /* renamed from: d, reason: collision with root package name */
    private h f34790d = (h) com.mbridge.msdk.dycreator.subjectfactory.a.a().a(a.b.REPORT_OBSERVER);

    /* renamed from: e, reason: collision with root package name */
    private BaseViewModel f34791e;

    /* renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.shake.b f34792f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements com.mbridge.msdk.dycreator.viewobserver.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34793a;

        a(View view) {
            this.f34793a = view;
        }

        @Override // com.mbridge.msdk.dycreator.viewobserver.g
        public void a(Object obj) {
            try {
                KeyEvent.Callback callback = this.f34793a;
                if (callback instanceof InterBase) {
                    b.this.b((InterBase) callback, obj);
                }
            } catch (Exception e11) {
                o0.b("MBDataBinding", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.dycreator.binding.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0477b implements com.mbridge.msdk.dycreator.viewobserver.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34795a;

        C0477b(View view) {
            this.f34795a = view;
        }

        @Override // com.mbridge.msdk.dycreator.viewobserver.e
        public void a(Object obj) {
            try {
                KeyEvent.Callback callback = this.f34795a;
                if (callback instanceof InterBase) {
                    b.this.a((InterBase) callback, obj);
                }
            } catch (Exception e11) {
                o0.b("MBDataBinding", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34797a;

        c(View view) {
            this.f34797a = view;
        }

        @Override // com.mbridge.msdk.dycreator.viewobserver.i
        public void a(Object obj) {
            try {
                KeyEvent.Callback callback = this.f34797a;
                if (callback instanceof InterBase) {
                    b.this.c((InterBase) callback, obj);
                }
            } catch (Exception e11) {
                o0.b("MBDataBinding", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements com.mbridge.msdk.dycreator.viewobserver.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34799a;

        d(View view) {
            this.f34799a = view;
        }

        @Override // com.mbridge.msdk.dycreator.viewobserver.b
        public void a(Object obj) {
            if (obj == null) {
                return;
            }
            try {
                if (com.mbridge.msdk.dycreator.utils.d.a(this.f34799a, (com.mbridge.msdk.dycreator.viewdata.base.a) obj)) {
                    b.this.a(this.f34799a, obj);
                }
            } catch (Exception e11) {
                o0.b("MBDataBinding", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements DyCountDownListenerWrapper {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f34801a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f34802b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f34803c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f34804d;

        e(boolean z10, String str, String str2, View view) {
            this.f34801a = z10;
            this.f34802b = str;
            this.f34803c = str2;
            this.f34804d = view;
        }

        @Override // com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper
        public void getCountDownValue(int i11) {
            if (i11 != 0) {
                ((TextView) this.f34804d).setText(com.mbridge.msdk.dycreator.utils.d.a(this.f34801a, i11, this.f34802b, this.f34803c));
            } else {
                SplashResData splashResData = new SplashResData();
                splashResData.seteAction(EAction.CLOSE);
                EventBus.getDefault().post(splashResData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.dycreator.viewdata.base.a f34806a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f34807b;

        f(com.mbridge.msdk.dycreator.viewdata.base.a aVar, View view) {
            this.f34806a = aVar;
            this.f34807b = view;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            View view = this.f34807b;
            if (view != null) {
                ((ImageView) view).setBackgroundColor(-7829368);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (bitmap != null) {
                try {
                    if (!bitmap.isRecycled()) {
                        boolean z10 = bitmap.getWidth() > bitmap.getHeight();
                        if ((this.f34806a.getEffectData().getOrientation() == 1 ? this.f34807b.getResources().getConfiguration().orientation : this.f34806a.getEffectData().getOrientation()) == 1) {
                            if (z10) {
                                View view = this.f34807b;
                                if (view instanceof MBSplashPortView) {
                                    if (view.getParent() != null) {
                                        ((ViewGroup) this.f34807b.getParent()).setVisibility(8);
                                        return;
                                    }
                                    return;
                                } else if (view instanceof MBSplashImageBgView) {
                                    view.setVisibility(0);
                                    Bitmap a11 = n0.a(bitmap);
                                    ((MBSplashImageBgView) this.f34807b).setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    ((MBSplashImageBgView) this.f34807b).setImageBitmap(a11);
                                    return;
                                }
                            } else {
                                View view2 = this.f34807b;
                                if (view2 instanceof MBSplashPortView) {
                                    view2.setVisibility(0);
                                    ((MBSplashPortView) this.f34807b).setScaleType(ImageView.ScaleType.FIT_CENTER);
                                    ((MBSplashPortView) this.f34807b).setImageBitmap(bitmap);
                                    return;
                                } else if (view2 instanceof MBSplashImageBgView) {
                                    view2.setVisibility(8);
                                    return;
                                } else if (view2 instanceof InterBase) {
                                    String effectDes = ((InterBase) view2).getEffectDes();
                                    ViewGroup viewGroup = (ViewGroup) this.f34807b.getParent();
                                    if (viewGroup != null) {
                                        com.mbridge.msdk.dycreator.utils.d.a(effectDes, viewGroup, true);
                                    }
                                }
                            }
                        } else if (z10) {
                            View view3 = this.f34807b;
                            if (view3 instanceof MBSplashPortView) {
                                view3.setVisibility(0);
                                ((MBSplashPortView) this.f34807b).setScaleType(ImageView.ScaleType.FIT_XY);
                                ((ImageView) this.f34807b).setImageBitmap(bitmap);
                                return;
                            } else if (view3 instanceof MBSplashImageBgView) {
                                view3.setVisibility(8);
                                ((MBSplashImageBgView) this.f34807b).setImageBitmap(n0.a(bitmap));
                                return;
                            } else if (view3 instanceof InterBase) {
                                String effectDes2 = ((InterBase) view3).getEffectDes();
                                ViewGroup viewGroup2 = (ViewGroup) this.f34807b.getParent();
                                if (viewGroup2 != null) {
                                    com.mbridge.msdk.dycreator.utils.d.a(effectDes2, viewGroup2, true);
                                }
                            }
                        } else {
                            View view4 = this.f34807b;
                            if (view4 instanceof MBSplashPortView) {
                                view4.setVisibility(0);
                                ((MBSplashPortView) this.f34807b).setImageBitmap(bitmap);
                                return;
                            } else {
                                if (view4 instanceof MBSplashImageBgView) {
                                    view4.setVisibility(0);
                                    Bitmap a12 = n0.a(bitmap);
                                    ((MBSplashImageBgView) this.f34807b).setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    ((MBSplashImageBgView) this.f34807b).setImageBitmap(a12);
                                    return;
                                }
                                if (view4 instanceof InterBase) {
                                    String effectDes3 = ((InterBase) view4).getEffectDes();
                                    ViewGroup viewGroup3 = (ViewGroup) this.f34807b.getParent();
                                    if (viewGroup3 != null) {
                                        com.mbridge.msdk.dycreator.utils.d.a(effectDes3, viewGroup3, true);
                                    }
                                }
                            }
                        }
                        ((ImageView) this.f34807b).setImageBitmap(bitmap);
                        return;
                    }
                } catch (Exception e11) {
                    o0.b("MBDataBinding", e11.getMessage());
                    return;
                }
            }
            ((ImageView) this.f34807b).setBackgroundColor(-7829368);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g extends com.mbridge.msdk.shake.b {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f34809g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ MBSplashData f34810h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i11, int i12, View view, MBSplashData mBSplashData) {
            super(i11, i12);
            this.f34809g = view;
            this.f34810h = mBSplashData;
        }

        @Override // com.mbridge.msdk.shake.b
        public void a() {
            View view = this.f34809g;
            if (view != null) {
                try {
                    if (view.getGlobalVisibleRect(new Rect())) {
                        SplashResData splashResData = new SplashResData();
                        this.f34810h.setClickType(4);
                        splashResData.setBaseViewData(this.f34810h);
                        splashResData.seteAction(EAction.DOWNLOAD);
                        EventBus.getDefault().post(splashResData);
                        com.mbridge.msdk.shake.a.a().b(b.this.f34792f);
                    }
                } catch (Exception e11) {
                    o0.b("MBDataBinding", e11.getMessage());
                }
            }
        }
    }

    private b() {
    }

    public static b a() {
        if (f34786g == null) {
            synchronized (b.class) {
                try {
                    if (f34786g == null) {
                        f34786g = new b();
                    }
                } finally {
                }
            }
        }
        return f34786g;
    }

    private com.mbridge.msdk.shake.b a(View view, MBSplashData mBSplashData) {
        if (mBSplashData != null) {
            try {
                DyOption dyOption = mBSplashData.getDyOption();
                if (dyOption != null && dyOption.isShakeVisible() && this.f34792f == null) {
                    this.f34792f = new g(dyOption.getShakeStrenght(), dyOption.getShakeTime() * 1000, view, mBSplashData);
                }
            } catch (Exception e11) {
                o0.b("MBDataBinding", e11.getMessage());
            }
        }
        return this.f34792f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, Object obj) {
        if (view == null || obj == null || !(obj instanceof com.mbridge.msdk.dycreator.viewdata.base.a)) {
            return;
        }
        view.setOnClickListener(new com.mbridge.msdk.dycreator.binding.a((com.mbridge.msdk.dycreator.viewdata.base.a) obj));
    }

    private void a(View view, Object obj, com.mbridge.msdk.dycreator.viewdata.base.a aVar) {
        if (view == null || obj == null) {
            return;
        }
        try {
            if (view instanceof TextView) {
                try {
                    ((TextView) view).setText(String.valueOf(obj).replace("\\n", "\n"));
                    return;
                } catch (Exception e11) {
                    e11.printStackTrace();
                    return;
                }
            }
            if (view instanceof ImageView) {
                if (obj instanceof Integer) {
                    ((ImageView) view).setImageResource(((Integer) obj).intValue());
                }
                if (obj instanceof String) {
                    com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(obj.toString(), new f(aVar, view));
                }
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    private void a(View view, Object obj, Object obj2) {
        int i11;
        boolean z10;
        if (obj == null || !(obj instanceof String)) {
            return;
        }
        com.mbridge.msdk.dycreator.viewdata.base.a aVar = (com.mbridge.msdk.dycreator.viewdata.base.a) obj2;
        if (obj.equals("countdown") && view != null && (view instanceof TextView) && aVar != null) {
            TextView textView = (TextView) view;
            String str = (String) textView.getText();
            String p11 = k0.p(view.getContext());
            DyOption effectData = aVar.getEffectData();
            if (effectData != null) {
                boolean isCanSkip = effectData.isCanSkip();
                i11 = effectData.getCountDownTime();
                z10 = isCanSkip;
            } else {
                i11 = 5;
                z10 = false;
            }
            textView.setText(com.mbridge.msdk.dycreator.utils.d.a(z10, i11, str, p11));
            aVar.getEffectData().setDyCountDownListenerWrapper(new e(z10, str, p11, view));
        }
        obj.equals("anim");
        if (obj.equals("visible")) {
            if (view instanceof MBFeedBack) {
                if (com.mbridge.msdk.foundation.feedback.b.b().a()) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(8);
                }
            }
            if (!(view instanceof MBLogoTextView) || aVar == null || aVar.getEffectData() == null || aVar.getEffectData().isLogoVisible()) {
                return;
            }
            ((MBLogoTextView) view).setCompoundDrawables(null, null, null, null);
        }
    }

    private void a(ViewGroup viewGroup, Object obj, com.mbridge.msdk.dycreator.viewdata.base.a aVar) {
        if (obj == null || !(obj instanceof String)) {
            return;
        }
        if (obj.equals("wobble") && (viewGroup instanceof MBSplashShakeView)) {
            if (aVar.getEffectData().isShakeVisible()) {
                if (this.f34792f != null) {
                    com.mbridge.msdk.shake.a.a().b(this.f34792f);
                }
                com.mbridge.msdk.shake.a.a().a(a((View) viewGroup, (MBSplashData) aVar));
            } else if (this.f34792f != null) {
                com.mbridge.msdk.shake.a.a().b(this.f34792f);
            }
        }
        if (obj.equals("visible") && (viewGroup instanceof MBApkInfoView)) {
            if (!aVar.getEffectData().isApkInfoVisible()) {
                viewGroup.setVisibility(8);
            } else if (!(aVar instanceof MBSplashData) || TextUtils.isEmpty(((MBSplashData) aVar).getAppInfo())) {
                viewGroup.setVisibility(4);
            } else {
                viewGroup.setVisibility(0);
            }
        }
        obj.equals("anim");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(InterBase interBase, Object obj) {
        if (interBase == 0 || obj == null) {
            return;
        }
        String effectDes = interBase.getEffectDes();
        if (TextUtils.isEmpty(effectDes)) {
            return;
        }
        try {
            if (interBase instanceof ViewGroup) {
                a((ViewGroup) interBase, (Object) effectDes, (com.mbridge.msdk.dycreator.viewdata.base.a) obj);
            } else if (interBase instanceof View) {
                a((View) interBase, effectDes, obj);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void a(com.mbridge.msdk.dycreator.viewobserver.b bVar, int i11) {
        com.mbridge.msdk.dycreator.viewobserver.c cVar = this.f34788b;
        if (cVar != null) {
            cVar.a(bVar, i11);
        }
    }

    private void a(com.mbridge.msdk.dycreator.viewobserver.e eVar, int i11) {
        com.mbridge.msdk.dycreator.viewobserver.f fVar = this.f34789c;
        if (fVar != null) {
            fVar.a(eVar, i11);
        }
    }

    private void a(com.mbridge.msdk.dycreator.viewobserver.g gVar, int i11) {
        h hVar = this.f34790d;
        if (hVar != null) {
            hVar.a(gVar, i11);
        }
    }

    private void a(i iVar, int i11) {
        com.mbridge.msdk.dycreator.viewobserver.d dVar = this.f34787a;
        if (dVar != null) {
            dVar.a(iVar, i11);
        }
    }

    private void b(ViewGroup viewGroup, Object obj, com.mbridge.msdk.dycreator.viewdata.base.a aVar) {
        if (viewGroup != null) {
            if (viewGroup instanceof MBSplashClickView) {
                if (aVar == null || aVar.getEffectData() == null || !aVar.getEffectData().isClickButtonVisible()) {
                    viewGroup.setVisibility(8);
                } else if (aVar.getEffectData().isShakeVisible()) {
                    viewGroup.setVisibility(8);
                } else if (obj != null && !TextUtils.isEmpty(obj.toString())) {
                    viewGroup.setVisibility(0);
                    ((MBSplashClickView) viewGroup).initView(obj.toString());
                }
            }
            if (viewGroup instanceof MBSplashShakeView) {
                if (aVar == null || aVar.getEffectData() == null || !aVar.getEffectData().isShakeVisible()) {
                    viewGroup.setVisibility(8);
                } else {
                    if (obj == null || TextUtils.isEmpty(obj.toString())) {
                        return;
                    }
                    viewGroup.setVisibility(0);
                    ((MBSplashShakeView) viewGroup).initView(obj.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(InterBase interBase, Object obj) {
        if (interBase == null || obj == null) {
            return;
        }
        String reportDes = interBase.getReportDes();
        if (TextUtils.isEmpty(reportDes)) {
            return;
        }
        try {
            if (!(obj instanceof com.mbridge.msdk.dycreator.viewdata.base.a) || ((com.mbridge.msdk.dycreator.viewdata.base.a) obj).getBindData() == null) {
                return;
            }
            interBase.setDynamicReport(reportDes, ((com.mbridge.msdk.dycreator.viewdata.base.a) obj).getBindData());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void c(InterBase interBase, Object obj) {
        if (interBase == 0 || obj == null) {
            return;
        }
        String bindDataDes = interBase.getBindDataDes();
        if (TextUtils.isEmpty(bindDataDes)) {
            return;
        }
        try {
            Object a11 = com.mbridge.msdk.dycreator.utils.d.a(obj, bindDataDes);
            if (a11 == null) {
                return;
            }
            if (interBase instanceof ViewGroup) {
                b((ViewGroup) interBase, a11, (com.mbridge.msdk.dycreator.viewdata.base.a) obj);
            } else if (interBase instanceof View) {
                a((View) interBase, a11, (com.mbridge.msdk.dycreator.viewdata.base.a) obj);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view) {
        if (view != 0) {
            try {
                if (view instanceof InterBase) {
                    String actionDes = ((InterBase) view).getActionDes();
                    if (!TextUtils.isEmpty(actionDes)) {
                        if (actionDes.startsWith("click")) {
                            a(new d(view), view.getId());
                        } else if (!actionDes.equals("move") && !actionDes.equals("long_click")) {
                            actionDes.equals("wobble");
                        }
                    }
                }
            } catch (Exception e11) {
                o0.b("MBDataBinding", e11.getMessage());
            }
        }
    }

    public void a(BaseViewModel baseViewModel) {
        this.f34791e = baseViewModel;
        if (baseViewModel != null) {
            baseViewModel.setClickSubject(this.f34788b);
            this.f34791e.setConcreteSubject(this.f34787a);
            this.f34791e.setEffectSubject(this.f34789c);
            this.f34791e.setReportSubject(this.f34790d);
        }
    }

    public synchronized void b() {
        try {
            com.mbridge.msdk.dycreator.viewobserver.c cVar = this.f34788b;
            if (cVar != null) {
                cVar.a();
            }
            com.mbridge.msdk.dycreator.viewobserver.d dVar = this.f34787a;
            if (dVar != null) {
                dVar.a();
            }
            com.mbridge.msdk.dycreator.viewobserver.f fVar = this.f34789c;
            if (fVar != null) {
                fVar.a();
            }
            if (this.f34791e != null) {
                this.f34791e = null;
            }
            if (this.f34792f != null) {
                this.f34792f = null;
            }
            if (f34786g != null) {
                f34786g = null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void b(View view) {
        a(new c(view), view.getId());
    }

    public void c(View view) {
        a(new C0477b(view), view.getId());
    }

    public void d(View view) {
        a(new a(view), view.getId());
    }
}
