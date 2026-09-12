package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.search.SearchBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i {

    /* renamed from: d, reason: collision with root package name */
    private Animator f29653d;

    /* renamed from: e, reason: collision with root package name */
    private Animator f29654e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f29655f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f29656g;

    /* renamed from: a, reason: collision with root package name */
    private final Set f29650a = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name */
    private final Set f29651b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    private final Set f29652c = new LinkedHashSet();

    /* renamed from: h, reason: collision with root package name */
    private boolean f29657h = true;

    /* renamed from: i, reason: collision with root package name */
    private Animator f29658i = null;

    /* loaded from: classes4.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.k(new g() { // from class: com.google.android.material.search.h
                @Override // com.google.android.material.search.i.g
                public final void a(SearchBar.b bVar) {
                    bVar.a();
                }
            });
        }
    }

    /* loaded from: classes4.dex */
    class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f29660a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Animator f29661b;

        b(View view, Animator animator) {
            this.f29660a = view;
            this.f29661b = animator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f29660a.setVisibility(8);
            this.f29661b.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.f29658i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SearchBar f29664a;

        d(SearchBar searchBar) {
            this.f29664a = searchBar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.f29655f = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f29664a.setVisibility(4);
        }
    }

    /* loaded from: classes4.dex */
    class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.f29658i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SearchBar f29667a;

        f(SearchBar searchBar) {
            this.f29667a = searchBar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f29667a.setVisibility(0);
            i.this.f29656g = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f29667a.stopOnLoadAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface g {
        void a(SearchBar.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(ab.i iVar, View view, ValueAnimator valueAnimator) {
        iVar.e0(1.0f - valueAnimator.getAnimatedFraction());
        ViewCompat.setBackground(view, iVar);
        view.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(t(searchBar, view), o(searchBar, view, appBarLayout));
        animatorSet.addListener(new c());
        Iterator it = this.f29651b.iterator();
        while (it.hasNext()) {
            animatorSet.addListener((AnimatorListenerAdapter) it.next());
        }
        if (z10) {
            animatorSet.setDuration(0L);
        }
        animatorSet.start();
        this.f29658i = animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(g gVar) {
        Iterator it = this.f29650a.iterator();
        while (it.hasNext()) {
            gVar.a((SearchBar.b) it.next());
        }
    }

    private Animator l(SearchBar searchBar, View view, AppBarLayout appBarLayout) {
        return p(searchBar, view, appBarLayout).o(250L).d(new f(searchBar)).g();
    }

    private Animator m(View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(com.google.android.material.internal.q.f(view));
        TimeInterpolator timeInterpolator = oa.a.f71041a;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration(this.f29657h ? 250L : 0L);
        ofFloat.setStartDelay(this.f29657h ? 500L : 0L);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.addUpdateListener(com.google.android.material.internal.q.f(view));
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(250L);
        ofFloat2.setStartDelay(750L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    private List n(View view) {
        boolean p11 = com.google.android.material.internal.f0.p(view);
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if ((!p11 && (childAt instanceof ActionMenuView)) || (p11 && !(childAt instanceof ActionMenuView))) {
                    arrayList.add(childAt);
                }
            }
        }
        return arrayList;
    }

    private Animator o(SearchBar searchBar, View view, AppBarLayout appBarLayout) {
        return p(searchBar, view, appBarLayout).o(300L).d(new d(searchBar)).i();
    }

    private com.google.android.material.internal.g p(SearchBar searchBar, View view, AppBarLayout appBarLayout) {
        return new com.google.android.material.internal.g(searchBar, view).m(q(searchBar, view)).n(appBarLayout != null ? appBarLayout.getTop() : 0).c(n(view));
    }

    private ValueAnimator.AnimatorUpdateListener q(SearchBar searchBar, final View view) {
        final ab.i m11 = ab.i.m(view.getContext());
        m11.a0(searchBar.getCornerSize());
        m11.c0(ViewCompat.getElevation(searchBar));
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i.A(ab.i.this, view, valueAnimator);
            }
        };
    }

    private List r(SearchBar searchBar) {
        List i11 = com.google.android.material.internal.f0.i(searchBar);
        if (searchBar.getCenterView() != null) {
            i11.remove(searchBar.getCenterView());
        }
        return i11;
    }

    private Animator s(SearchBar searchBar) {
        List r11 = r(searchBar);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(com.google.android.material.internal.q.e(r11));
        ofFloat.setDuration(100L);
        ofFloat.setInterpolator(oa.a.f71041a);
        return ofFloat;
    }

    private Animator t(SearchBar searchBar, final View view) {
        List r11 = r(searchBar);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(com.google.android.material.internal.q.e(r11));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(0.0f);
            }
        });
        ofFloat.setDuration(75L);
        ofFloat.setInterpolator(oa.a.f71041a);
        return ofFloat;
    }

    private Animator u(View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(com.google.android.material.internal.q.f(view));
        ofFloat.setInterpolator(oa.a.f71041a);
        ofFloat.setDuration(250L);
        return ofFloat;
    }

    private Animator v(TextView textView, View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(250L);
        animatorSet.play(w(textView));
        if (view != null) {
            animatorSet.play(u(view));
        }
        return animatorSet;
    }

    private Animator w(TextView textView) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(com.google.android.material.internal.q.f(textView));
        ofFloat.setInterpolator(oa.a.f71041a);
        ofFloat.setDuration(250L);
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D(AnimatorListenerAdapter animatorListenerAdapter) {
        return this.f29652c.remove(animatorListenerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E(AnimatorListenerAdapter animatorListenerAdapter) {
        return this.f29651b.remove(animatorListenerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F(SearchBar.b bVar) {
        return this.f29650a.remove(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(boolean z10) {
        this.f29657h = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z10) {
        Animator animator;
        if (y() && (animator = this.f29658i) != null) {
            animator.cancel();
        }
        this.f29656g = true;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(l(searchBar, view, appBarLayout), s(searchBar));
        animatorSet.addListener(new e());
        Iterator it = this.f29652c.iterator();
        while (it.hasNext()) {
            animatorSet.addListener((AnimatorListenerAdapter) it.next());
        }
        if (z10) {
            animatorSet.setDuration(0L);
        }
        animatorSet.start();
        this.f29658i = animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(final SearchBar searchBar, final View view, final AppBarLayout appBarLayout, final boolean z10) {
        Animator animator;
        if (x() && (animator = this.f29658i) != null) {
            animator.cancel();
        }
        this.f29655f = true;
        view.setVisibility(4);
        view.post(new Runnable() { // from class: com.google.android.material.search.e
            @Override // java.lang.Runnable
            public final void run() {
                i.this.C(searchBar, view, appBarLayout, z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(SearchBar searchBar) {
        k(new g() { // from class: com.google.android.material.search.d
            @Override // com.google.android.material.search.i.g
            public final void a(SearchBar.b bVar) {
                bVar.b();
            }
        });
        TextView textView = searchBar.getTextView();
        View centerView = searchBar.getCenterView();
        View f11 = ToolbarUtils.f(searchBar);
        Animator v11 = v(textView, f11);
        v11.addListener(new a());
        this.f29653d = v11;
        textView.setAlpha(0.0f);
        if (f11 != null) {
            f11.setAlpha(0.0f);
        }
        if (centerView == null) {
            v11.start();
            return;
        }
        centerView.setAlpha(0.0f);
        centerView.setVisibility(0);
        Animator m11 = m(centerView);
        this.f29654e = m11;
        m11.addListener(new b(centerView, v11));
        m11.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(SearchBar searchBar) {
        Animator animator = this.f29653d;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.f29654e;
        if (animator2 != null) {
            animator2.end();
        }
        View centerView = searchBar.getCenterView();
        if (centerView != null) {
            centerView.setAlpha(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(AnimatorListenerAdapter animatorListenerAdapter) {
        this.f29652c.add(animatorListenerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(AnimatorListenerAdapter animatorListenerAdapter) {
        this.f29651b.add(animatorListenerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(SearchBar.b bVar) {
        this.f29650a.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        return this.f29656g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        return this.f29655f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z() {
        return this.f29657h;
    }
}
