package androidx.recyclerview.widget;

import android.animation.Animator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public abstract class ItemTouchHelper extends RecyclerView.l implements RecyclerView.o {

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ItemTouchHelper this$0;

        AnonymousClass1(ItemTouchHelper itemTouchHelper) {
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ ItemTouchHelper this$0;
        final /* synthetic */ a val$anim;
        final /* synthetic */ int val$swipeDir;

        AnonymousClass4(ItemTouchHelper itemTouchHelper, a aVar, int i11) {
            this.val$swipeDir = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    /* loaded from: classes2.dex */
    static class a implements Animator.AnimatorListener {
    }
}
