package androidx.core.view.insets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.R$id;
import androidx.core.view.insets.Protection;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ProtectionLayout extends FrameLayout {
    private static final Object PROTECTION_VIEW = new Object();
    private c mGroup;
    private final List<Protection> mProtections;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Protection.a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout.LayoutParams f8483a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f8484b;

        a(FrameLayout.LayoutParams layoutParams, View view) {
            this.f8483a = layoutParams;
            this.f8484b = view;
        }

        @Override // androidx.core.view.insets.Protection.a.InterfaceC0076a
        public void a(int i11) {
            FrameLayout.LayoutParams layoutParams = this.f8483a;
            layoutParams.height = i11;
            this.f8484b.setLayoutParams(layoutParams);
        }

        @Override // androidx.core.view.insets.Protection.a.InterfaceC0076a
        public void b(z0.c cVar) {
            FrameLayout.LayoutParams layoutParams = this.f8483a;
            layoutParams.leftMargin = cVar.f79248a;
            layoutParams.topMargin = cVar.f79249b;
            layoutParams.rightMargin = cVar.f79250c;
            layoutParams.bottomMargin = cVar.f79251d;
            this.f8484b.setLayoutParams(layoutParams);
        }

        @Override // androidx.core.view.insets.Protection.a.InterfaceC0076a
        public void c(float f11) {
            this.f8484b.setAlpha(f11);
        }

        @Override // androidx.core.view.insets.Protection.a.InterfaceC0076a
        public void d(int i11) {
            FrameLayout.LayoutParams layoutParams = this.f8483a;
            layoutParams.width = i11;
            this.f8484b.setLayoutParams(layoutParams);
        }

        @Override // androidx.core.view.insets.Protection.a.InterfaceC0076a
        public void e(float f11) {
            this.f8484b.setTranslationX(f11);
        }

        @Override // androidx.core.view.insets.Protection.a.InterfaceC0076a
        public void f(float f11) {
            this.f8484b.setTranslationY(f11);
        }

        @Override // androidx.core.view.insets.Protection.a.InterfaceC0076a
        public void g(Drawable drawable) {
            this.f8484b.setBackground(drawable);
        }

        @Override // androidx.core.view.insets.Protection.a.InterfaceC0076a
        public void onVisibilityChanged(boolean z10) {
            this.f8484b.setVisibility(z10 ? 0 : 4);
        }
    }

    public ProtectionLayout(Context context) {
        super(context);
        this.mProtections = new ArrayList();
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.mProtections = new ArrayList();
    }

    public ProtectionLayout(Context context, List<Protection> list) {
        super(context);
        this.mProtections = new ArrayList();
        setProtections(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void addProtectionView(android.content.Context r7, int r8, androidx.core.view.insets.Protection r9) {
        /*
            r6 = this;
            androidx.core.view.insets.Protection$a r0 = r9.getAttributes()
            int r1 = r9.getSide()
            r2 = 1
            r3 = 4
            r4 = -1
            if (r1 == r2) goto L48
            r2 = 2
            if (r1 == r2) goto L41
            if (r1 == r3) goto L38
            r2 = 8
            if (r1 != r2) goto L1d
            int r9 = r0.m()
            r1 = 80
            goto L4e
        L1d:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unexpected side: "
            r8.append(r0)
            int r9 = r9.getSide()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L38:
            int r9 = r0.q()
            r1 = 5
        L3d:
            r5 = r4
            r4 = r9
            r9 = r5
            goto L4e
        L41:
            int r9 = r0.m()
            r1 = 48
            goto L4e
        L48:
            int r9 = r0.q()
            r1 = 3
            goto L3d
        L4e:
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r4, r9, r1)
            z0.c r9 = r0.n()
            int r1 = r9.f79248a
            r2.leftMargin = r1
            int r1 = r9.f79249b
            r2.topMargin = r1
            int r1 = r9.f79250c
            r2.rightMargin = r1
            int r9 = r9.f79251d
            r2.bottomMargin = r9
            android.view.View r9 = new android.view.View
            r9.<init>(r7)
            java.lang.Object r7 = androidx.core.view.insets.ProtectionLayout.PROTECTION_VIEW
            r9.setTag(r7)
            float r7 = r0.o()
            r9.setTranslationX(r7)
            float r7 = r0.p()
            r9.setTranslationY(r7)
            float r7 = r0.k()
            r9.setAlpha(r7)
            boolean r7 = r0.r()
            if (r7 == 0) goto L8d
            r3 = 0
        L8d:
            r9.setVisibility(r3)
            android.graphics.drawable.Drawable r7 = r0.l()
            r9.setBackground(r7)
            androidx.core.view.insets.ProtectionLayout$a r7 = new androidx.core.view.insets.ProtectionLayout$a
            r7.<init>(r2, r9)
            r0.t(r7)
            r6.addView(r9, r8, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.insets.ProtectionLayout.addProtectionView(android.content.Context, int, androidx.core.view.insets.Protection):void");
    }

    private void addProtectionViews() {
        if (this.mProtections.isEmpty()) {
            return;
        }
        this.mGroup = new c(getOrInstallSystemBarStateMonitor(), this.mProtections);
        int childCount = getChildCount();
        int i11 = this.mGroup.i();
        for (int i12 = 0; i12 < i11; i12++) {
            addProtectionView(getContext(), i12 + childCount, this.mGroup.h(i12));
        }
    }

    private f getOrInstallSystemBarStateMonitor() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R$id.tag_system_bar_state_monitor);
        if (tag instanceof f) {
            return (f) tag;
        }
        f fVar = new f(viewGroup);
        viewGroup.setTag(R$id.tag_system_bar_state_monitor, fVar);
        return fVar;
    }

    private void maybeUninstallSystemBarStateMonitor() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R$id.tag_system_bar_state_monitor);
        if (tag instanceof f) {
            f fVar = (f) tag;
            if (fVar.k()) {
                return;
            }
            fVar.h();
            viewGroup.setTag(R$id.tag_system_bar_state_monitor, null);
        }
    }

    private void removeProtectionViews() {
        if (this.mGroup != null) {
            removeViews(getChildCount() - this.mGroup.i(), this.mGroup.i());
            int i11 = this.mGroup.i();
            for (int i12 = 0; i12 < i11; i12++) {
                this.mGroup.h(i12).getAttributes().t(null);
            }
            this.mGroup.g();
            this.mGroup = null;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (view != null && view.getTag() != PROTECTION_VIEW) {
            c cVar = this.mGroup;
            int childCount = getChildCount() - (cVar != null ? cVar.i() : 0);
            if (i11 > childCount || i11 < 0) {
                i11 = childCount;
            }
        }
        super.addView(view, i11, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mGroup != null) {
            removeProtectionViews();
        }
        addProtectionViews();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeProtectionViews();
        maybeUninstallSystemBarStateMonitor();
    }

    public void setProtections(List<Protection> list) {
        this.mProtections.clear();
        this.mProtections.addAll(list);
        if (isAttachedToWindow()) {
            removeProtectionViews();
            addProtectionViews();
            requestApplyInsets();
        }
    }
}
