package com.google.android.libraries.places.widget.internal.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.internal.zzkd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o1.b;

/* loaded from: classes4.dex */
public final class zzo extends DefaultItemAnimator {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList();
    private final int zzd;

    public zzo(Resources resources) {
        this.zzd = resources.getDimensionPixelSize(R.dimen.places_autocomplete_vertical_dropdown);
    }

    private final void zzd(RecyclerView.b0 b0Var) {
        List list = this.zzc;
        View view = b0Var.itemView;
        list.add(b0Var);
        long moveDuration = getMoveDuration() + (b0Var.getLayoutPosition() * 67);
        view.setTranslationY(-this.zzd);
        view.setAlpha(0.0f);
        ViewPropertyAnimator animate = view.animate();
        animate.cancel();
        animate.translationY(0.0f).alpha(1.0f).setDuration(133L).setInterpolator(new b()).setStartDelay(moveDuration);
        animate.setListener(new zzn(this, view, b0Var, animate)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzf(View view) {
        view.setAlpha(1.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.q
    public final boolean animateAdd(RecyclerView.b0 b0Var) {
        try {
            endAnimation(b0Var);
            b0Var.itemView.setAlpha(0.0f);
            if (((zzt) b0Var).zzb()) {
                this.zza.add(b0Var);
                return true;
            }
            this.zzb.add(b0Var);
            return true;
        } catch (Error e11) {
            e = e11;
            zzkd.zzb(e);
            throw e;
        } catch (RuntimeException e12) {
            e = e12;
            zzkd.zzb(e);
            throw e;
        }
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.j
    public final void endAnimation(RecyclerView.b0 b0Var) {
        try {
            super.endAnimation(b0Var);
            if (this.zza.remove(b0Var)) {
                zzf(b0Var.itemView);
                dispatchAddFinished(b0Var);
            }
            zze();
        } catch (Error e11) {
            e = e11;
            zzkd.zzb(e);
            throw e;
        } catch (RuntimeException e12) {
            e = e12;
            zzkd.zzb(e);
            throw e;
        }
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.j
    public final void endAnimations() {
        try {
            int size = this.zza.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                RecyclerView.b0 b0Var = (RecyclerView.b0) this.zza.get(size);
                zzf(b0Var.itemView);
                dispatchAddFinished(b0Var);
                this.zza.remove(size);
            }
            List list = this.zzc;
            int size2 = list.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    super.endAnimations();
                    return;
                }
                ((RecyclerView.b0) list.get(size2)).itemView.animate().cancel();
            }
        } catch (Error e11) {
            e = e11;
            zzkd.zzb(e);
            throw e;
        } catch (RuntimeException e12) {
            e = e12;
            zzkd.zzb(e);
            throw e;
        }
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.j
    public final boolean isRunning() {
        try {
            if (!super.isRunning() && this.zzb.isEmpty() && this.zza.isEmpty()) {
                return !this.zzc.isEmpty();
            }
            return true;
        } catch (Error | RuntimeException e11) {
            zzkd.zzb(e11);
            throw e11;
        }
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.j
    public final void runPendingAnimations() {
        try {
            Iterator it = this.zzb.iterator();
            while (it.hasNext()) {
                super.animateAdd((RecyclerView.b0) it.next());
            }
            this.zzb.clear();
            super.runPendingAnimations();
            if (this.zza.isEmpty()) {
                return;
            }
            ArrayList<RecyclerView.b0> arrayList = new ArrayList(this.zza);
            this.zza.clear();
            for (RecyclerView.b0 b0Var : arrayList) {
                View view = b0Var.itemView;
                this.zzc.add(b0Var);
                long moveDuration = getMoveDuration() + (b0Var.getLayoutPosition() * 67);
                view.setTranslationY(-this.zzd);
                view.setAlpha(0.0f);
                ViewPropertyAnimator animate = view.animate();
                animate.cancel();
                animate.translationY(0.0f).alpha(1.0f).setDuration(133L).setInterpolator(new b()).setStartDelay(moveDuration);
                animate.setListener(new zzn(this, view, b0Var, animate)).start();
            }
        } catch (Error e11) {
            e = e11;
            zzkd.zzb(e);
            throw e;
        } catch (RuntimeException e12) {
            e = e12;
            zzkd.zzb(e);
            throw e;
        }
    }
}
