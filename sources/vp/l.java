package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.task.ad.StageTaskProgressLayout;

/* loaded from: classes6.dex */
public final class l implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f77555a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f77556b;

    /* renamed from: c, reason: collision with root package name */
    public final View f77557c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f77558d;

    /* renamed from: e, reason: collision with root package name */
    public final StageTaskProgressLayout f77559e;

    private l(ConstraintLayout constraintLayout, FrameLayout frameLayout, View view, AppCompatTextView appCompatTextView, StageTaskProgressLayout stageTaskProgressLayout) {
        this.f77555a = constraintLayout;
        this.f77556b = frameLayout;
        this.f77557c = view;
        this.f77558d = appCompatTextView;
        this.f77559e = stageTaskProgressLayout;
    }

    public static l a(View view) {
        View a11;
        int i11 = R$id.ad_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null && (a11 = g4.b.a(view, (i11 = R$id.ad_mask))) != null) {
            i11 = R$id.btn_action;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.double_progress;
                StageTaskProgressLayout stageTaskProgressLayout = (StageTaskProgressLayout) g4.b.a(view, i11);
                if (stageTaskProgressLayout != null) {
                    return new l((ConstraintLayout) view, frameLayout, a11, appCompatTextView, stageTaskProgressLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static l c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.stage_task_view_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77555a;
    }
}
