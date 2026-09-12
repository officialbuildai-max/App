package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal<>();
    static Comparator<b> sTaskComparator = new Comparator<b>() { // from class: androidx.recyclerview.widget.GapWorker.1
        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            RecyclerView recyclerView = bVar.f14270d;
            if ((recyclerView == null) != (bVar2.f14270d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z10 = bVar.f14267a;
            if (z10 != bVar2.f14267a) {
                return z10 ? -1 : 1;
            }
            int i11 = bVar2.f14268b - bVar.f14268b;
            if (i11 != 0) {
                return i11;
            }
            int i12 = bVar.f14269c - bVar2.f14269c;
            if (i12 != 0) {
                return i12;
            }
            return 0;
        }
    };
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews = new ArrayList<>();
    private ArrayList<b> mTasks = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements RecyclerView.m.c {

        /* renamed from: a, reason: collision with root package name */
        int f14263a;

        /* renamed from: b, reason: collision with root package name */
        int f14264b;

        /* renamed from: c, reason: collision with root package name */
        int[] f14265c;

        /* renamed from: d, reason: collision with root package name */
        int f14266d;

        @Override // androidx.recyclerview.widget.RecyclerView.m.c
        public void a(int i11, int i12) {
            if (i11 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i12 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i13 = this.f14266d;
            int i14 = i13 * 2;
            int[] iArr = this.f14265c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f14265c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i14 >= iArr.length) {
                int[] iArr3 = new int[i13 * 4];
                this.f14265c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f14265c;
            iArr4[i14] = i11;
            iArr4[i14 + 1] = i12;
            this.f14266d++;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f14265c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f14266d = 0;
        }

        void c(RecyclerView recyclerView, boolean z10) {
            this.f14266d = 0;
            int[] iArr = this.f14265c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.m mVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || mVar == null || !mVar.isItemPrefetchEnabled()) {
                return;
            }
            if (z10) {
                if (!recyclerView.mAdapterHelper.p()) {
                    mVar.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                mVar.collectAdjacentPrefetchPositions(this.f14263a, this.f14264b, recyclerView.mState, this);
            }
            int i11 = this.f14266d;
            if (i11 > mVar.mPrefetchMaxCountObserved) {
                mVar.mPrefetchMaxCountObserved = i11;
                mVar.mPrefetchMaxObservedInInitialPrefetch = z10;
                recyclerView.mRecycler.P();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d(int i11) {
            if (this.f14265c != null) {
                int i12 = this.f14266d * 2;
                for (int i13 = 0; i13 < i12; i13 += 2) {
                    if (this.f14265c[i13] == i11) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i11, int i12) {
            this.f14263a = i11;
            this.f14264b = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f14267a;

        /* renamed from: b, reason: collision with root package name */
        public int f14268b;

        /* renamed from: c, reason: collision with root package name */
        public int f14269c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f14270d;

        /* renamed from: e, reason: collision with root package name */
        public int f14271e;

        b() {
        }

        public void a() {
            this.f14267a = false;
            this.f14268b = 0;
            this.f14269c = 0;
            this.f14270d = null;
            this.f14271e = 0;
        }
    }

    private void buildTaskList() {
        b bVar;
        int size = this.mRecyclerViews.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView recyclerView = this.mRecyclerViews.get(i12);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i11 += recyclerView.mPrefetchRegistry.f14266d;
            }
        }
        this.mTasks.ensureCapacity(i11);
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            RecyclerView recyclerView2 = this.mRecyclerViews.get(i14);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(aVar.f14263a) + Math.abs(aVar.f14264b);
                for (int i15 = 0; i15 < aVar.f14266d * 2; i15 += 2) {
                    if (i13 >= this.mTasks.size()) {
                        bVar = new b();
                        this.mTasks.add(bVar);
                    } else {
                        bVar = this.mTasks.get(i13);
                    }
                    int[] iArr = aVar.f14265c;
                    int i16 = iArr[i15 + 1];
                    bVar.f14267a = i16 <= abs;
                    bVar.f14268b = abs;
                    bVar.f14269c = i16;
                    bVar.f14270d = recyclerView2;
                    bVar.f14271e = iArr[i15];
                    i13++;
                }
            }
        }
        Collections.sort(this.mTasks, sTaskComparator);
    }

    private void flushTaskWithDeadline(b bVar, long j11) {
        RecyclerView.b0 prefetchPositionWithDeadline = prefetchPositionWithDeadline(bVar.f14270d, bVar.f14271e, bVar.f14267a ? Long.MAX_VALUE : j11);
        if (prefetchPositionWithDeadline == null || prefetchPositionWithDeadline.mNestedRecyclerView == null || !prefetchPositionWithDeadline.isBound() || prefetchPositionWithDeadline.isInvalid()) {
            return;
        }
        prefetchInnerRecyclerViewWithDeadline(prefetchPositionWithDeadline.mNestedRecyclerView.get(), j11);
    }

    private void flushTasksWithDeadline(long j11) {
        for (int i11 = 0; i11 < this.mTasks.size(); i11++) {
            b bVar = this.mTasks.get(i11);
            if (bVar.f14270d == null) {
                return;
            }
            flushTaskWithDeadline(bVar, j11);
            bVar.a();
        }
    }

    static boolean isPrefetchPositionAttached(RecyclerView recyclerView, int i11) {
        int j11 = recyclerView.mChildHelper.j();
        for (int i12 = 0; i12 < j11; i12++) {
            RecyclerView.b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i12));
            if (childViewHolderInt.mPosition == i11 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView recyclerView, long j11) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        a aVar = recyclerView.mPrefetchRegistry;
        aVar.c(recyclerView, true);
        if (aVar.f14266d != 0) {
            try {
                androidx.core.os.s.a("RV Nested Prefetch");
                recyclerView.mState.f(recyclerView.mAdapter);
                for (int i11 = 0; i11 < aVar.f14266d * 2; i11 += 2) {
                    prefetchPositionWithDeadline(recyclerView, aVar.f14265c[i11], j11);
                }
            } finally {
                androidx.core.os.s.b();
            }
        }
    }

    private RecyclerView.b0 prefetchPositionWithDeadline(RecyclerView recyclerView, int i11, long j11) {
        if (isPrefetchPositionAttached(recyclerView, i11)) {
            return null;
        }
        RecyclerView.t tVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.b0 N = tVar.N(i11, false, j11);
            if (N != null) {
                if (!N.isBound() || N.isInvalid()) {
                    tVar.a(N, false);
                } else {
                    tVar.G(N.itemView);
                }
            }
            recyclerView.onExitLayoutOrScroll(false);
            return N;
        } catch (Throwable th2) {
            recyclerView.onExitLayoutOrScroll(false);
            throw th2;
        }
    }

    public void add(RecyclerView recyclerView) {
        if (RecyclerView.sDebugAssertionsEnabled && this.mRecyclerViews.contains(recyclerView)) {
            throw new IllegalStateException("RecyclerView already present in worker list!");
        }
        this.mRecyclerViews.add(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void postFromTraversal(RecyclerView recyclerView, int i11, int i12) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.sDebugAssertionsEnabled && !this.mRecyclerViews.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.mPostTimeNs == 0) {
                this.mPostTimeNs = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        recyclerView.mPrefetchRegistry.e(i11, i12);
    }

    void prefetch(long j11) {
        buildTaskList();
        flushTasksWithDeadline(j11);
    }

    public void remove(RecyclerView recyclerView) {
        boolean remove = this.mRecyclerViews.remove(recyclerView);
        if (RecyclerView.sDebugAssertionsEnabled && !remove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.os.s.a("RV Prefetch");
            if (!this.mRecyclerViews.isEmpty()) {
                int size = this.mRecyclerViews.size();
                long j11 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    RecyclerView recyclerView = this.mRecyclerViews.get(i11);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j11 = Math.max(recyclerView.getDrawingTime(), j11);
                    }
                }
                if (j11 != 0) {
                    prefetch(TimeUnit.MILLISECONDS.toNanos(j11) + this.mFrameIntervalNs);
                    this.mPostTimeNs = 0L;
                    androidx.core.os.s.b();
                }
            }
        } finally {
            this.mPostTimeNs = 0L;
            androidx.core.os.s.b();
        }
    }
}
