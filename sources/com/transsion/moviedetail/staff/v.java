package com.transsion.moviedetail.staff;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Pair;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import lg.a;

/* loaded from: classes6.dex */
public final class v extends RecyclerView.r {

    /* renamed from: a, reason: collision with root package name */
    private final s f47391a;

    /* renamed from: b, reason: collision with root package name */
    private final Function2 f47392b;

    /* renamed from: c, reason: collision with root package name */
    private RecyclerView f47393c;

    /* renamed from: d, reason: collision with root package name */
    private final String f47394d;

    /* renamed from: e, reason: collision with root package name */
    private int f47395e;

    /* renamed from: f, reason: collision with root package name */
    private int f47396f;

    /* renamed from: g, reason: collision with root package name */
    private int f47397g;

    /* renamed from: h, reason: collision with root package name */
    private int f47398h;

    /* renamed from: i, reason: collision with root package name */
    private int f47399i;

    /* renamed from: j, reason: collision with root package name */
    private SparseArray f47400j;

    public v(s adapter, Function2 callback) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(callback, "callback");
        this.f47391a = adapter;
        this.f47392b = callback;
        this.f47394d = "MovieStaffScroll";
        this.f47397g = -1;
        this.f47398h = -1;
        this.f47399i = -1;
        this.f47400j = new SparseArray();
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0114, code lost:
    
        r0 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0115, code lost:
    
        r8.f47400j.put(r0, new kotlin.Pair(r8.f47391a.getItem(r0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime())));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x012d, code lost:
    
        if (r0 == r10) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012f, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void h(int r9, int r10) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.moviedetail.staff.v.h(int, int):void");
    }

    public final void d(AppBarLayout appBarLayout, int i11) {
        Intrinsics.h(appBarLayout, "appBarLayout");
        a.C0856a.f(lg.a.f68962a, this.f47394d, "appbarScroll  moveY:" + i11, false, 4, null);
        try {
            this.f47396f = i11;
            int c11 = com.blankj.utilcode.util.y.c();
            int a11 = com.blankj.utilcode.util.d.a();
            RecyclerView recyclerView = this.f47393c;
            int i12 = 0;
            int top = (c11 - a11) - (recyclerView != null ? recyclerView.getTop() : 0);
            RecyclerView recyclerView2 = this.f47393c;
            GridLayoutManager gridLayoutManager = (GridLayoutManager) (recyclerView2 != null ? recyclerView2.getLayoutManager() : null);
            if (gridLayoutManager == null) {
                return;
            }
            int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
            int i13 = -1;
            if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                int i14 = 0;
                int i15 = -1;
                while (true) {
                    View findViewByPosition = gridLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                    if (findViewByPosition != null) {
                        a.C0856a c0856a = lg.a.f68962a;
                        a.C0856a.f(c0856a, this.f47394d, "appbarScroll  *****  index:" + findFirstVisibleItemPosition + "  totalY:" + this.f47395e + "    top:" + findViewByPosition.getTop(), false, 4, null);
                        if (findViewByPosition.getTop() < 0) {
                            return;
                        }
                        if (findViewByPosition.getBottom() < findViewByPosition.getHeight() * 0.7f) {
                            a.C0856a.f(c0856a, this.f47394d, "index:" + findFirstVisibleItemPosition + "  标题栏档住了，不计入", false, 4, null);
                        } else if (gridLayoutManager.Y().e(findFirstVisibleItemPosition, gridLayoutManager.U()) == 0) {
                            if (i15 == -1) {
                                i15 = findFirstVisibleItemPosition;
                            }
                            int height = findViewByPosition.getHeight();
                            int i16 = i14 + height;
                            if (i16 < top) {
                                i14 = i16;
                            } else if (((top - i14) * 100) / height >= 70) {
                                int i17 = findFirstVisibleItemPosition + 1;
                                if (i17 <= findLastVisibleItemPosition) {
                                    while (true) {
                                        int i18 = findFirstVisibleItemPosition;
                                        findFirstVisibleItemPosition = i17;
                                        if (gridLayoutManager.Y().e(findFirstVisibleItemPosition, gridLayoutManager.U()) != 0) {
                                            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                                                break;
                                            } else {
                                                i17 = findFirstVisibleItemPosition + 1;
                                            }
                                        } else {
                                            findFirstVisibleItemPosition = i18;
                                            break;
                                        }
                                    }
                                }
                                i12 = findFirstVisibleItemPosition;
                            } else {
                                i12 = RangesKt.f(findFirstVisibleItemPosition - 1, 0);
                            }
                        }
                    }
                    if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                        break;
                    } else {
                        findFirstVisibleItemPosition++;
                    }
                }
                i13 = i15;
            }
            a.C0856a.f(lg.a.f68962a, this.f47394d, "firstVisiblePosition:" + i13 + "   realLastVisiblePosition:" + i12, false, 4, null);
            h(i13, i12);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void e(int i11, int i12) {
        while (i11 < i12) {
            try {
                Pair pair = (Pair) this.f47400j.get(i11);
                if (pair != null) {
                    this.f47392b.invoke(Integer.valueOf(i11), pair);
                    this.f47400j.remove(i11);
                }
                i11++;
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
    }

    public final void f() {
        try {
            IntIterator a11 = androidx.core.util.k.a(this.f47400j);
            while (a11.hasNext()) {
                int intValue = a11.next().intValue();
                Function2 function2 = this.f47392b;
                Integer valueOf = Integer.valueOf(intValue);
                Object obj = this.f47400j.get(intValue);
                Intrinsics.g(obj, "get(...)");
                function2.invoke(valueOf, obj);
            }
            this.f47400j.clear();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void g() {
        try {
            int i11 = this.f47397g;
            if (i11 >= 0) {
                int i12 = this.f47398h;
                this.f47397g = -1;
                this.f47398h = -1;
                h(i11, i12);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        this.f47395e += i12;
        this.f47393c = recyclerView;
        if (this.f47396f >= 0) {
            return;
        }
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        int i13 = findFirstVisibleItemPosition;
        while (true) {
            if (i13 >= findLastVisibleItemPosition) {
                break;
            }
            View findViewByPosition = gridLayoutManager.findViewByPosition(i13);
            if (findViewByPosition != null) {
                Rect rect = new Rect();
                findViewByPosition.getLocalVisibleRect(rect);
                a.C0856a c0856a = lg.a.f68962a;
                a.C0856a.f(c0856a, this.f47394d, "index:" + i13 + "  totalY:" + this.f47395e + "    dy:" + i12 + " top:" + recyclerView.getTop(), false, 4, null);
                a.C0856a.f(c0856a, this.f47394d, "index:" + i13 + "  firstView top:" + findViewByPosition.getTop() + "    bottom:" + findViewByPosition.getBottom(), false, 4, null);
                if (findViewByPosition.getBottom() < findViewByPosition.getHeight() * 0.7f) {
                    a.C0856a.f(c0856a, this.f47394d, "index:" + i13 + "  标题栏档住了，不计入", false, 4, null);
                } else if ((rect.height() * 100) / findViewByPosition.getHeight() >= 70) {
                    findFirstVisibleItemPosition = i13;
                    break;
                }
            }
            i13++;
        }
        if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            int i14 = findLastVisibleItemPosition;
            while (true) {
                View findViewByPosition2 = gridLayoutManager.findViewByPosition(i14);
                if (findViewByPosition2 != null) {
                    Rect rect2 = new Rect();
                    findViewByPosition2.getLocalVisibleRect(rect2);
                    if ((rect2.height() * 100) / findViewByPosition2.getHeight() >= 70) {
                        findLastVisibleItemPosition = i14;
                        break;
                    }
                }
                if (i14 == findFirstVisibleItemPosition) {
                    break;
                } else {
                    i14--;
                }
            }
        }
        a.C0856a.f(lg.a.f68962a, this.f47394d, "firstVisiblePosition:" + findFirstVisibleItemPosition + "   lastVisiblePosition:" + findLastVisibleItemPosition, false, 4, null);
        h(findFirstVisibleItemPosition, findLastVisibleItemPosition);
    }
}
