package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    protected final RecyclerView.m f14486a;

    /* renamed from: b, reason: collision with root package name */
    private int f14487b;

    /* renamed from: c, reason: collision with root package name */
    final Rect f14488c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends m {
        a(RecyclerView.m mVar) {
            super(mVar, null);
        }

        @Override // androidx.recyclerview.widget.m
        public int d(View view) {
            return this.f14486a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int e(View view) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return this.f14486a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int f(View view) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return this.f14486a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int g(View view) {
            return this.f14486a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int h() {
            return this.f14486a.getWidth();
        }

        @Override // androidx.recyclerview.widget.m
        public int i() {
            return this.f14486a.getWidth() - this.f14486a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.m
        public int j() {
            return this.f14486a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.m
        public int k() {
            return this.f14486a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.m
        public int l() {
            return this.f14486a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.m
        public int m() {
            return this.f14486a.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.m
        public int n() {
            return (this.f14486a.getWidth() - this.f14486a.getPaddingLeft()) - this.f14486a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.m
        public int p(View view) {
            this.f14486a.getTransformedBoundingBox(view, true, this.f14488c);
            return this.f14488c.right;
        }

        @Override // androidx.recyclerview.widget.m
        public int q(View view) {
            this.f14486a.getTransformedBoundingBox(view, true, this.f14488c);
            return this.f14488c.left;
        }

        @Override // androidx.recyclerview.widget.m
        public void r(int i11) {
            this.f14486a.offsetChildrenHorizontal(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends m {
        b(RecyclerView.m mVar) {
            super(mVar, null);
        }

        @Override // androidx.recyclerview.widget.m
        public int d(View view) {
            return this.f14486a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int e(View view) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return this.f14486a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int f(View view) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return this.f14486a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int g(View view) {
            return this.f14486a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int h() {
            return this.f14486a.getHeight();
        }

        @Override // androidx.recyclerview.widget.m
        public int i() {
            return this.f14486a.getHeight() - this.f14486a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.m
        public int j() {
            return this.f14486a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.m
        public int k() {
            return this.f14486a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.m
        public int l() {
            return this.f14486a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.m
        public int m() {
            return this.f14486a.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.m
        public int n() {
            return (this.f14486a.getHeight() - this.f14486a.getPaddingTop()) - this.f14486a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.m
        public int p(View view) {
            this.f14486a.getTransformedBoundingBox(view, true, this.f14488c);
            return this.f14488c.bottom;
        }

        @Override // androidx.recyclerview.widget.m
        public int q(View view) {
            this.f14486a.getTransformedBoundingBox(view, true, this.f14488c);
            return this.f14488c.top;
        }

        @Override // androidx.recyclerview.widget.m
        public void r(int i11) {
            this.f14486a.offsetChildrenVertical(i11);
        }
    }

    private m(RecyclerView.m mVar) {
        this.f14487b = Integer.MIN_VALUE;
        this.f14488c = new Rect();
        this.f14486a = mVar;
    }

    /* synthetic */ m(RecyclerView.m mVar, a aVar) {
        this(mVar);
    }

    public static m a(RecyclerView.m mVar) {
        return new a(mVar);
    }

    public static m b(RecyclerView.m mVar, int i11) {
        if (i11 == 0) {
            return a(mVar);
        }
        if (i11 == 1) {
            return c(mVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static m c(RecyclerView.m mVar) {
        return new b(mVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f14487b) {
            return 0;
        }
        return n() - this.f14487b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i11);

    public void s() {
        this.f14487b = n();
    }
}
