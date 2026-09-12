package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class n extends r {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;

    @Nullable
    private m mHorizontalHelper;

    @Nullable
    private m mVerticalHelper;

    /* loaded from: classes2.dex */
    class a extends h {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.h, androidx.recyclerview.widget.RecyclerView.x
        protected void o(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
            n nVar = n.this;
            int[] calculateDistanceToFinalSnap = nVar.calculateDistanceToFinalSnap(nVar.mRecyclerView.getLayoutManager(), view);
            int i11 = calculateDistanceToFinalSnap[0];
            int i12 = calculateDistanceToFinalSnap[1];
            int w11 = w(Math.max(Math.abs(i11), Math.abs(i12)));
            if (w11 > 0) {
                aVar.d(i11, i12, w11, this.f14470j);
            }
        }

        @Override // androidx.recyclerview.widget.h
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.h
        public int x(int i11) {
            return Math.min(100, super.x(i11));
        }
    }

    private int d(View view, m mVar) {
        return (mVar.g(view) + (mVar.e(view) / 2)) - (mVar.m() + (mVar.n() / 2));
    }

    private View e(RecyclerView.m mVar, m mVar2) {
        int childCount = mVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int m11 = mVar2.m() + (mVar2.n() / 2);
        int i11 = Integer.MAX_VALUE;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = mVar.getChildAt(i12);
            int abs = Math.abs((mVar2.g(childAt) + (mVar2.e(childAt) / 2)) - m11);
            if (abs < i11) {
                view = childAt;
                i11 = abs;
            }
        }
        return view;
    }

    private m f(RecyclerView.m mVar) {
        m mVar2 = this.mHorizontalHelper;
        if (mVar2 == null || mVar2.f14486a != mVar) {
            this.mHorizontalHelper = m.a(mVar);
        }
        return this.mHorizontalHelper;
    }

    private m g(RecyclerView.m mVar) {
        if (mVar.canScrollVertically()) {
            return h(mVar);
        }
        if (mVar.canScrollHorizontally()) {
            return f(mVar);
        }
        return null;
    }

    private m h(RecyclerView.m mVar) {
        m mVar2 = this.mVerticalHelper;
        if (mVar2 == null || mVar2.f14486a != mVar) {
            this.mVerticalHelper = m.c(mVar);
        }
        return this.mVerticalHelper;
    }

    private boolean i(RecyclerView.m mVar, int i11, int i12) {
        return mVar.canScrollHorizontally() ? i11 > 0 : i12 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean j(RecyclerView.m mVar) {
        PointF computeScrollVectorForPosition;
        int itemCount = mVar.getItemCount();
        if (!(mVar instanceof RecyclerView.x.b) || (computeScrollVectorForPosition = ((RecyclerView.x.b) mVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.r
    @Nullable
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.m mVar, @NonNull View view) {
        int[] iArr = new int[2];
        if (mVar.canScrollHorizontally()) {
            iArr[0] = d(view, f(mVar));
        } else {
            iArr[0] = 0;
        }
        if (mVar.canScrollVertically()) {
            iArr[1] = d(view, h(mVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.r
    @Nullable
    protected RecyclerView.x createScroller(@NonNull RecyclerView.m mVar) {
        if (mVar instanceof RecyclerView.x.b) {
            return new a(this.mRecyclerView.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.r
    public View findSnapView(RecyclerView.m mVar) {
        if (mVar.canScrollVertically()) {
            return e(mVar, h(mVar));
        }
        if (mVar.canScrollHorizontally()) {
            return e(mVar, f(mVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.r
    @SuppressLint({"UnknownNullness"})
    public int findTargetSnapPosition(RecyclerView.m mVar, int i11, int i12) {
        m g11;
        int itemCount = mVar.getItemCount();
        if (itemCount == 0 || (g11 = g(mVar)) == null) {
            return -1;
        }
        int childCount = mVar.getChildCount();
        View view = null;
        int i13 = Integer.MAX_VALUE;
        int i14 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = mVar.getChildAt(i15);
            if (childAt != null) {
                int d11 = d(childAt, g11);
                if (d11 <= 0 && d11 > i14) {
                    view2 = childAt;
                    i14 = d11;
                }
                if (d11 >= 0 && d11 < i13) {
                    view = childAt;
                    i13 = d11;
                }
            }
        }
        boolean i16 = i(mVar, i11, i12);
        if (i16 && view != null) {
            return mVar.getPosition(view);
        }
        if (!i16 && view2 != null) {
            return mVar.getPosition(view2);
        }
        if (i16) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = mVar.getPosition(view) + (j(mVar) == i16 ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }
}
