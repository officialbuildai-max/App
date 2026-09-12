package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DefaultItemAnimator extends q {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    private ArrayList<RecyclerView.b0> mPendingRemovals = new ArrayList<>();
    private ArrayList<RecyclerView.b0> mPendingAdditions = new ArrayList<>();
    private ArrayList<g> mPendingMoves = new ArrayList<>();
    private ArrayList<f> mPendingChanges = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.b0>> mAdditionsList = new ArrayList<>();
    ArrayList<ArrayList<g>> mMovesList = new ArrayList<>();
    ArrayList<ArrayList<f>> mChangesList = new ArrayList<>();
    ArrayList<RecyclerView.b0> mAddAnimations = new ArrayList<>();
    ArrayList<RecyclerView.b0> mMoveAnimations = new ArrayList<>();
    ArrayList<RecyclerView.b0> mRemoveAnimations = new ArrayList<>();
    ArrayList<RecyclerView.b0> mChangeAnimations = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.b0 f14175a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f14176b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f14177c;

        a(RecyclerView.b0 b0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f14175a = b0Var;
            this.f14176b = viewPropertyAnimator;
            this.f14177c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f14176b.setListener(null);
            this.f14177c.setAlpha(1.0f);
            DefaultItemAnimator.this.dispatchRemoveFinished(this.f14175a);
            DefaultItemAnimator.this.mRemoveAnimations.remove(this.f14175a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchRemoveStarting(this.f14175a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.b0 f14179a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f14180b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f14181c;

        b(RecyclerView.b0 b0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f14179a = b0Var;
            this.f14180b = view;
            this.f14181c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f14180b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f14181c.setListener(null);
            DefaultItemAnimator.this.dispatchAddFinished(this.f14179a);
            DefaultItemAnimator.this.mAddAnimations.remove(this.f14179a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchAddStarting(this.f14179a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.b0 f14183a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f14184b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f14185c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f14186d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f14187e;

        c(RecyclerView.b0 b0Var, int i11, View view, int i12, ViewPropertyAnimator viewPropertyAnimator) {
            this.f14183a = b0Var;
            this.f14184b = i11;
            this.f14185c = view;
            this.f14186d = i12;
            this.f14187e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f14184b != 0) {
                this.f14185c.setTranslationX(0.0f);
            }
            if (this.f14186d != 0) {
                this.f14185c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f14187e.setListener(null);
            DefaultItemAnimator.this.dispatchMoveFinished(this.f14183a);
            DefaultItemAnimator.this.mMoveAnimations.remove(this.f14183a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchMoveStarting(this.f14183a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f14189a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f14190b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f14191c;

        d(f fVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f14189a = fVar;
            this.f14190b = viewPropertyAnimator;
            this.f14191c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f14190b.setListener(null);
            this.f14191c.setAlpha(1.0f);
            this.f14191c.setTranslationX(0.0f);
            this.f14191c.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.f14189a.f14197a, true);
            DefaultItemAnimator.this.mChangeAnimations.remove(this.f14189a.f14197a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.f14189a.f14197a, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f14193a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f14194b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f14195c;

        e(f fVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f14193a = fVar;
            this.f14194b = viewPropertyAnimator;
            this.f14195c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f14194b.setListener(null);
            this.f14195c.setAlpha(1.0f);
            this.f14195c.setTranslationX(0.0f);
            this.f14195c.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.f14193a.f14198b, false);
            DefaultItemAnimator.this.mChangeAnimations.remove(this.f14193a.f14198b);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.f14193a.f14198b, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.b0 f14197a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.b0 f14198b;

        /* renamed from: c, reason: collision with root package name */
        public int f14199c;

        /* renamed from: d, reason: collision with root package name */
        public int f14200d;

        /* renamed from: e, reason: collision with root package name */
        public int f14201e;

        /* renamed from: f, reason: collision with root package name */
        public int f14202f;

        private f(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2) {
            this.f14197a = b0Var;
            this.f14198b = b0Var2;
        }

        f(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2, int i11, int i12, int i13, int i14) {
            this(b0Var, b0Var2);
            this.f14199c = i11;
            this.f14200d = i12;
            this.f14201e = i13;
            this.f14202f = i14;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f14197a + ", newHolder=" + this.f14198b + ", fromX=" + this.f14199c + ", fromY=" + this.f14200d + ", toX=" + this.f14201e + ", toY=" + this.f14202f + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.b0 f14203a;

        /* renamed from: b, reason: collision with root package name */
        public int f14204b;

        /* renamed from: c, reason: collision with root package name */
        public int f14205c;

        /* renamed from: d, reason: collision with root package name */
        public int f14206d;

        /* renamed from: e, reason: collision with root package name */
        public int f14207e;

        g(RecyclerView.b0 b0Var, int i11, int i12, int i13, int i14) {
            this.f14203a = b0Var;
            this.f14204b = i11;
            this.f14205c = i12;
            this.f14206d = i13;
            this.f14207e = i14;
        }
    }

    private void a(RecyclerView.b0 b0Var) {
        View view = b0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.mRemoveAnimations.add(b0Var);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new a(b0Var, animate, view)).start();
    }

    private void b(List list, RecyclerView.b0 b0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            f fVar = (f) list.get(size);
            if (d(fVar, b0Var) && fVar.f14197a == null && fVar.f14198b == null) {
                list.remove(fVar);
            }
        }
    }

    private void c(f fVar) {
        RecyclerView.b0 b0Var = fVar.f14197a;
        if (b0Var != null) {
            d(fVar, b0Var);
        }
        RecyclerView.b0 b0Var2 = fVar.f14198b;
        if (b0Var2 != null) {
            d(fVar, b0Var2);
        }
    }

    private boolean d(f fVar, RecyclerView.b0 b0Var) {
        boolean z10 = false;
        if (fVar.f14198b == b0Var) {
            fVar.f14198b = null;
        } else {
            if (fVar.f14197a != b0Var) {
                return false;
            }
            fVar.f14197a = null;
            z10 = true;
        }
        b0Var.itemView.setAlpha(1.0f);
        b0Var.itemView.setTranslationX(0.0f);
        b0Var.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(b0Var, z10);
        return true;
    }

    private void e(RecyclerView.b0 b0Var) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        b0Var.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(b0Var);
    }

    @Override // androidx.recyclerview.widget.q
    public boolean animateAdd(RecyclerView.b0 b0Var) {
        e(b0Var);
        b0Var.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(b0Var);
        return true;
    }

    void animateAddImpl(RecyclerView.b0 b0Var) {
        View view = b0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.mAddAnimations.add(b0Var);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new b(b0Var, view, animate)).start();
    }

    @Override // androidx.recyclerview.widget.q
    @SuppressLint({"UnknownNullness"})
    public boolean animateChange(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2, int i11, int i12, int i13, int i14) {
        if (b0Var == b0Var2) {
            return animateMove(b0Var, i11, i12, i13, i14);
        }
        float translationX = b0Var.itemView.getTranslationX();
        float translationY = b0Var.itemView.getTranslationY();
        float alpha = b0Var.itemView.getAlpha();
        e(b0Var);
        int i15 = (int) ((i13 - i11) - translationX);
        int i16 = (int) ((i14 - i12) - translationY);
        b0Var.itemView.setTranslationX(translationX);
        b0Var.itemView.setTranslationY(translationY);
        b0Var.itemView.setAlpha(alpha);
        if (b0Var2 != null) {
            e(b0Var2);
            b0Var2.itemView.setTranslationX(-i15);
            b0Var2.itemView.setTranslationY(-i16);
            b0Var2.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new f(b0Var, b0Var2, i11, i12, i13, i14));
        return true;
    }

    void animateChangeImpl(f fVar) {
        RecyclerView.b0 b0Var = fVar.f14197a;
        View view = b0Var == null ? null : b0Var.itemView;
        RecyclerView.b0 b0Var2 = fVar.f14198b;
        View view2 = b0Var2 != null ? b0Var2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(fVar.f14197a);
            duration.translationX(fVar.f14201e - fVar.f14199c);
            duration.translationY(fVar.f14202f - fVar.f14200d);
            duration.alpha(0.0f).setListener(new d(fVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.mChangeAnimations.add(fVar.f14198b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new e(fVar, animate, view2)).start();
        }
    }

    @Override // androidx.recyclerview.widget.q
    @SuppressLint({"UnknownNullness"})
    public boolean animateMove(RecyclerView.b0 b0Var, int i11, int i12, int i13, int i14) {
        View view = b0Var.itemView;
        int translationX = i11 + ((int) view.getTranslationX());
        int translationY = i12 + ((int) b0Var.itemView.getTranslationY());
        e(b0Var);
        int i15 = i13 - translationX;
        int i16 = i14 - translationY;
        if (i15 == 0 && i16 == 0) {
            dispatchMoveFinished(b0Var);
            return false;
        }
        if (i15 != 0) {
            view.setTranslationX(-i15);
        }
        if (i16 != 0) {
            view.setTranslationY(-i16);
        }
        this.mPendingMoves.add(new g(b0Var, translationX, translationY, i13, i14));
        return true;
    }

    void animateMoveImpl(RecyclerView.b0 b0Var, int i11, int i12, int i13, int i14) {
        View view = b0Var.itemView;
        int i15 = i13 - i11;
        int i16 = i14 - i12;
        if (i15 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i16 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.mMoveAnimations.add(b0Var);
        animate.setDuration(getMoveDuration()).setListener(new c(b0Var, i15, view, i16, animate)).start();
    }

    @Override // androidx.recyclerview.widget.q
    @SuppressLint({"UnknownNullness"})
    public boolean animateRemove(RecyclerView.b0 b0Var) {
        e(b0Var);
        this.mPendingRemovals.add(b0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.b0 b0Var, @NonNull List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(b0Var, list);
    }

    void cancelAll(List<RecyclerView.b0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    void dispatchFinishedWhenDone() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void endAnimation(RecyclerView.b0 b0Var) {
        View view = b0Var.itemView;
        view.animate().cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.mPendingMoves.get(size).f14203a == b0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(b0Var);
                this.mPendingMoves.remove(size);
            }
        }
        b(this.mPendingChanges, b0Var);
        if (this.mPendingRemovals.remove(b0Var)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(b0Var);
        }
        if (this.mPendingAdditions.remove(b0Var)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(b0Var);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList<f> arrayList = this.mChangesList.get(size2);
            b(arrayList, b0Var);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList<g> arrayList2 = this.mMovesList.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f14203a == b0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(b0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.mMovesList.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.b0> arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(b0Var)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(b0Var);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(b0Var);
        this.mAddAnimations.remove(b0Var);
        this.mChangeAnimations.remove(b0Var);
        this.mMoveAnimations.remove(b0Var);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            g gVar = this.mPendingMoves.get(size);
            View view = gVar.f14203a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(gVar.f14203a);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2));
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.b0 b0Var = this.mPendingAdditions.get(size3);
            b0Var.itemView.setAlpha(1.0f);
            dispatchAddFinished(b0Var);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            c(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList<g> arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    g gVar2 = arrayList.get(size6);
                    View view2 = gVar2.f14203a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(gVar2.f14203a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.b0> arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.b0 b0Var2 = arrayList2.get(size8);
                    b0Var2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(b0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList<f> arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    c(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean isRunning() {
        return (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void runPendingAnimations() {
        boolean isEmpty = this.mPendingRemovals.isEmpty();
        boolean isEmpty2 = this.mPendingMoves.isEmpty();
        boolean isEmpty3 = this.mPendingChanges.isEmpty();
        boolean isEmpty4 = this.mPendingAdditions.isEmpty();
        if (isEmpty && isEmpty2 && isEmpty4 && isEmpty3) {
            return;
        }
        Iterator<RecyclerView.b0> it = this.mPendingRemovals.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.mPendingRemovals.clear();
        if (!isEmpty2) {
            final ArrayList<g> arrayList = new ArrayList<>();
            arrayList.addAll(this.mPendingMoves);
            this.mMovesList.add(arrayList);
            this.mPendingMoves.clear();
            Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        g gVar = (g) it2.next();
                        DefaultItemAnimator.this.animateMoveImpl(gVar.f14203a, gVar.f14204b, gVar.f14205c, gVar.f14206d, gVar.f14207e);
                    }
                    arrayList.clear();
                    DefaultItemAnimator.this.mMovesList.remove(arrayList);
                }
            };
            if (isEmpty) {
                runnable.run();
            } else {
                ViewCompat.postOnAnimationDelayed(arrayList.get(0).f14203a.itemView, runnable, getRemoveDuration());
            }
        }
        if (!isEmpty3) {
            final ArrayList<f> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.mPendingChanges);
            this.mChangesList.add(arrayList2);
            this.mPendingChanges.clear();
            Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        DefaultItemAnimator.this.animateChangeImpl((f) it2.next());
                    }
                    arrayList2.clear();
                    DefaultItemAnimator.this.mChangesList.remove(arrayList2);
                }
            };
            if (isEmpty) {
                runnable2.run();
            } else {
                ViewCompat.postOnAnimationDelayed(arrayList2.get(0).f14197a.itemView, runnable2, getRemoveDuration());
            }
        }
        if (isEmpty4) {
            return;
        }
        final ArrayList<RecyclerView.b0> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.mPendingAdditions);
        this.mAdditionsList.add(arrayList3);
        this.mPendingAdditions.clear();
        Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    DefaultItemAnimator.this.animateAddImpl((RecyclerView.b0) it2.next());
                }
                arrayList3.clear();
                DefaultItemAnimator.this.mAdditionsList.remove(arrayList3);
            }
        };
        if (isEmpty && isEmpty2 && isEmpty3) {
            runnable3.run();
        } else {
            ViewCompat.postOnAnimationDelayed(arrayList3.get(0).itemView, runnable3, (!isEmpty ? getRemoveDuration() : 0L) + Math.max(!isEmpty2 ? getMoveDuration() : 0L, isEmpty3 ? 0L : getChangeDuration()));
        }
    }
}
