package net.lucode.hackware.magicindicator.buildins.commonnavigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import g00.b;
import j00.c;
import j00.d;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.R$layout;

/* loaded from: classes.dex */
public class CommonNavigator extends FrameLayout implements h00.a, b.a {

    /* renamed from: a, reason: collision with root package name */
    private HorizontalScrollView f70465a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f70466b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f70467c;

    /* renamed from: d, reason: collision with root package name */
    private c f70468d;

    /* renamed from: e, reason: collision with root package name */
    private j00.a f70469e;

    /* renamed from: f, reason: collision with root package name */
    private b f70470f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f70471g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f70472h;

    /* renamed from: i, reason: collision with root package name */
    private float f70473i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f70474j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f70475k;

    /* renamed from: l, reason: collision with root package name */
    private int f70476l;

    /* renamed from: m, reason: collision with root package name */
    private int f70477m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f70478n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f70479o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f70480p;

    /* renamed from: q, reason: collision with root package name */
    private List f70481q;

    /* renamed from: r, reason: collision with root package name */
    private DataSetObserver f70482r;

    /* loaded from: classes7.dex */
    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CommonNavigator.this.f70470f.m(CommonNavigator.this.f70469e.a());
            CommonNavigator.this.d();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }
    }

    public CommonNavigator(Context context) {
        super(context);
        this.f70473i = 0.5f;
        this.f70474j = true;
        this.f70475k = true;
        this.f70480p = true;
        this.f70481q = new ArrayList();
        this.f70482r = new a();
        b bVar = new b();
        this.f70470f = bVar;
        bVar.k(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        removeAllViews();
        View inflate = this.f70471g ? LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout_no_scroll, this) : LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout, this);
        this.f70465a = (HorizontalScrollView) inflate.findViewById(R$id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.title_container);
        this.f70466b = linearLayout;
        linearLayout.setPadding(this.f70477m, 0, this.f70476l, 0);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R$id.indicator_container);
        this.f70467c = linearLayout2;
        if (this.f70478n) {
            linearLayout2.getParent().bringChildToFront(this.f70467c);
        }
        e();
    }

    private void e() {
        LinearLayout.LayoutParams layoutParams;
        int g11 = this.f70470f.g();
        for (int i11 = 0; i11 < g11; i11++) {
            Object c11 = this.f70469e.c(getContext(), i11);
            if (c11 instanceof View) {
                View view = (View) c11;
                if (this.f70471g) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.f70469e.d(getContext(), i11);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.f70466b.addView(view, layoutParams);
            }
        }
        j00.a aVar = this.f70469e;
        if (aVar != null) {
            c b11 = aVar.b(getContext());
            this.f70468d = b11;
            if (b11 instanceof View) {
                this.f70467c.addView((View) this.f70468d, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        this.f70481q.clear();
        int g11 = this.f70470f.g();
        for (int i11 = 0; i11 < g11; i11++) {
            k00.a aVar = new k00.a();
            View childAt = this.f70466b.getChildAt(i11);
            if (childAt != 0) {
                aVar.f66678a = childAt.getLeft();
                aVar.f66679b = childAt.getTop();
                aVar.f66680c = childAt.getRight();
                int bottom = childAt.getBottom();
                aVar.f66681d = bottom;
                if (childAt instanceof j00.b) {
                    j00.b bVar = (j00.b) childAt;
                    aVar.f66682e = bVar.getContentLeft();
                    aVar.f66683f = bVar.getContentTop();
                    aVar.f66684g = bVar.getContentRight();
                    aVar.f66685h = bVar.getContentBottom();
                } else {
                    aVar.f66682e = aVar.f66678a;
                    aVar.f66683f = aVar.f66679b;
                    aVar.f66684g = aVar.f66680c;
                    aVar.f66685h = bottom;
                }
            }
            this.f70481q.add(aVar);
        }
    }

    public j00.a getAdapter() {
        return this.f70469e;
    }

    public int getLeftPadding() {
        return this.f70477m;
    }

    public c getPagerIndicator() {
        return this.f70468d;
    }

    public d getPagerTitleView(int i11) {
        LinearLayout linearLayout = this.f70466b;
        if (linearLayout == null) {
            return null;
        }
        return (d) linearLayout.getChildAt(i11);
    }

    public int getRightPadding() {
        return this.f70476l;
    }

    public float getScrollPivotX() {
        return this.f70473i;
    }

    public LinearLayout getTitleContainer() {
        return this.f70466b;
    }

    public boolean isAdjustMode() {
        return this.f70471g;
    }

    public boolean isEnablePivotScroll() {
        return this.f70472h;
    }

    public boolean isFollowTouch() {
        return this.f70475k;
    }

    public boolean isIndicatorOnTop() {
        return this.f70478n;
    }

    public boolean isReselectWhenLayout() {
        return this.f70480p;
    }

    public boolean isSkimOver() {
        return this.f70479o;
    }

    public boolean isSmoothScroll() {
        return this.f70474j;
    }

    @Override // h00.a
    public void notifyDataSetChanged() {
        j00.a aVar = this.f70469e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // h00.a
    public void onAttachToMagicIndicator() {
        d();
    }

    @Override // g00.b.a
    public void onDeselected(int i11, int i12) {
        LinearLayout linearLayout = this.f70466b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i11);
        if (childAt instanceof d) {
            ((d) childAt).onDeselected(i11, i12);
        }
    }

    @Override // h00.a
    public void onDetachFromMagicIndicator() {
    }

    @Override // g00.b.a
    public void onEnter(int i11, int i12, float f11, boolean z10) {
        LinearLayout linearLayout = this.f70466b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i11);
        if (childAt instanceof d) {
            ((d) childAt).onEnter(i11, i12, f11, z10);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        if (this.f70469e != null) {
            f();
            c cVar = this.f70468d;
            if (cVar != null) {
                cVar.onPositionDataProvide(this.f70481q);
            }
            if (this.f70480p && this.f70470f.f() == 0) {
                onPageSelected(this.f70470f.e());
                onPageScrolled(this.f70470f.e(), 0.0f, 0);
            }
        }
    }

    @Override // g00.b.a
    public void onLeave(int i11, int i12, float f11, boolean z10) {
        LinearLayout linearLayout = this.f70466b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i11);
        if (childAt instanceof d) {
            ((d) childAt).onLeave(i11, i12, f11, z10);
        }
    }

    @Override // h00.a
    public void onPageScrollStateChanged(int i11) {
        if (this.f70469e != null) {
            this.f70470f.h(i11);
            c cVar = this.f70468d;
            if (cVar != null) {
                cVar.onPageScrollStateChanged(i11);
            }
        }
    }

    @Override // h00.a
    public void onPageScrolled(int i11, float f11, int i12) {
        if (this.f70469e != null) {
            this.f70470f.i(i11, f11, i12);
            c cVar = this.f70468d;
            if (cVar != null) {
                cVar.onPageScrolled(i11, f11, i12);
            }
            if (this.f70465a == null || this.f70481q.size() <= 0 || i11 < 0 || i11 >= this.f70481q.size() || !this.f70475k) {
                return;
            }
            int min = Math.min(this.f70481q.size() - 1, i11);
            int min2 = Math.min(this.f70481q.size() - 1, i11 + 1);
            k00.a aVar = (k00.a) this.f70481q.get(min);
            k00.a aVar2 = (k00.a) this.f70481q.get(min2);
            float a11 = aVar.a() - (this.f70465a.getWidth() * this.f70473i);
            this.f70465a.scrollTo((int) (a11 + (((aVar2.a() - (this.f70465a.getWidth() * this.f70473i)) - a11) * f11)), 0);
        }
    }

    @Override // h00.a
    public void onPageSelected(int i11) {
        if (this.f70469e != null) {
            this.f70470f.j(i11);
            c cVar = this.f70468d;
            if (cVar != null) {
                cVar.onPageSelected(i11);
            }
        }
    }

    @Override // g00.b.a
    public void onSelected(int i11, int i12) {
        LinearLayout linearLayout = this.f70466b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i11);
        if (childAt instanceof d) {
            ((d) childAt).onSelected(i11, i12);
        }
        if (this.f70471g || this.f70475k || this.f70465a == null || this.f70481q.size() <= 0) {
            return;
        }
        k00.a aVar = (k00.a) this.f70481q.get(Math.min(this.f70481q.size() - 1, i11));
        if (this.f70472h) {
            float a11 = aVar.a() - (this.f70465a.getWidth() * this.f70473i);
            if (this.f70474j) {
                this.f70465a.smoothScrollTo((int) a11, 0);
                return;
            } else {
                this.f70465a.scrollTo((int) a11, 0);
                return;
            }
        }
        int scrollX = this.f70465a.getScrollX();
        int i13 = aVar.f66678a;
        if (scrollX > i13) {
            if (this.f70474j) {
                this.f70465a.smoothScrollTo(i13, 0);
                return;
            } else {
                this.f70465a.scrollTo(i13, 0);
                return;
            }
        }
        int scrollX2 = this.f70465a.getScrollX() + getWidth();
        int i14 = aVar.f66680c;
        if (scrollX2 < i14) {
            if (this.f70474j) {
                this.f70465a.smoothScrollTo(i14 - getWidth(), 0);
            } else {
                this.f70465a.scrollTo(i14 - getWidth(), 0);
            }
        }
    }

    public void setAdapter(j00.a aVar) {
        j00.a aVar2 = this.f70469e;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.g(this.f70482r);
        }
        this.f70469e = aVar;
        if (aVar == null) {
            this.f70470f.m(0);
            d();
            return;
        }
        aVar.f(this.f70482r);
        this.f70470f.m(this.f70469e.a());
        if (this.f70466b != null) {
            this.f70469e.e();
        }
    }

    public void setAdjustMode(boolean z10) {
        this.f70471g = z10;
    }

    public void setEnablePivotScroll(boolean z10) {
        this.f70472h = z10;
    }

    public void setFollowTouch(boolean z10) {
        this.f70475k = z10;
    }

    public void setIndicatorOnTop(boolean z10) {
        this.f70478n = z10;
    }

    public void setLeftPadding(int i11) {
        this.f70477m = i11;
    }

    public void setReselectWhenLayout(boolean z10) {
        this.f70480p = z10;
    }

    public void setRightPadding(int i11) {
        this.f70476l = i11;
    }

    public void setScrollPivotX(float f11) {
        this.f70473i = f11;
    }

    public void setSkimOver(boolean z10) {
        this.f70479o = z10;
        this.f70470f.l(z10);
    }

    public void setSmoothScroll(boolean z10) {
        this.f70474j = z10;
    }
}
