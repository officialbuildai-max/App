package androidx.compose.ui.input.pointer;

import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private long f5067a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseLongArray f5068b = new SparseLongArray();

    /* renamed from: c, reason: collision with root package name */
    private final SparseBooleanArray f5069c = new SparseBooleanArray();

    /* renamed from: d, reason: collision with root package name */
    private final List f5070d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private int f5071e = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f5072f = -1;

    private final void a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (this.f5068b.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.f5068b;
                long j11 = this.f5067a;
                this.f5067a = 1 + j11;
                sparseLongArray.put(pointerId, j11);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (this.f5068b.indexOfKey(pointerId2) < 0) {
            SparseLongArray sparseLongArray2 = this.f5068b;
            long j12 = this.f5067a;
            this.f5067a = 1 + j12;
            sparseLongArray2.put(pointerId2, j12);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.f5069c.put(pointerId2, true);
            }
        }
    }

    private final void b(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.f5071e && source == this.f5072f) {
            return;
        }
        this.f5071e = toolType;
        this.f5072f = source;
        this.f5069c.clear();
        this.f5068b.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.ui.input.pointer.z d(androidx.compose.ui.input.pointer.i0 r32, android.view.MotionEvent r33, int r34, boolean r35) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.h.d(androidx.compose.ui.input.pointer.i0, android.view.MotionEvent, int, boolean):androidx.compose.ui.input.pointer.z");
    }

    private final long f(int i11) {
        long j11;
        int indexOfKey = this.f5068b.indexOfKey(i11);
        if (indexOfKey >= 0) {
            j11 = this.f5068b.valueAt(indexOfKey);
        } else {
            j11 = this.f5067a;
            this.f5067a = 1 + j11;
            this.f5068b.put(i11, j11);
        }
        return v.b(j11);
    }

    private final boolean g(MotionEvent motionEvent, int i11) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i12 = 0; i12 < pointerCount; i12++) {
            if (motionEvent.getPointerId(i12) == i11) {
                return true;
            }
        }
        return false;
    }

    private final void h(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.f5069c.get(pointerId, false)) {
                this.f5068b.delete(pointerId);
                this.f5069c.delete(pointerId);
            }
        }
        if (this.f5068b.size() > motionEvent.getPointerCount()) {
            for (int size = this.f5068b.size() - 1; -1 < size; size--) {
                int keyAt = this.f5068b.keyAt(size);
                if (!g(motionEvent, keyAt)) {
                    this.f5068b.removeAt(size);
                    this.f5069c.delete(keyAt);
                }
            }
        }
    }

    public final y c(MotionEvent motionEvent, i0 i0Var) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 4) {
            this.f5068b.clear();
            this.f5069c.clear();
            return null;
        }
        b(motionEvent);
        a(motionEvent);
        boolean z10 = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z11 = actionMasked == 8;
        if (z10) {
            this.f5069c.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        int actionIndex = actionMasked != 1 ? actionMasked != 6 ? -1 : motionEvent.getActionIndex() : 0;
        this.f5070d.clear();
        int pointerCount = motionEvent.getPointerCount();
        int i11 = 0;
        while (i11 < pointerCount) {
            this.f5070d.add(d(i0Var, motionEvent, i11, (z10 || i11 == actionIndex || (z11 && motionEvent.getButtonState() == 0)) ? false : true));
            i11++;
        }
        h(motionEvent);
        return new y(motionEvent.getEventTime(), this.f5070d, motionEvent);
    }

    public final void e(int i11) {
        this.f5069c.delete(i11);
        this.f5068b.delete(i11);
    }
}
