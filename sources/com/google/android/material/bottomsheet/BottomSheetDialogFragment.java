package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes4.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {

    /* renamed from: a, reason: collision with root package name */
    private boolean f28493a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends BottomSheetBehavior.f {
        private b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onSlide(View view, float f11) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onStateChanged(View view, int i11) {
            if (i11 == 5) {
                BottomSheetDialogFragment.this.Y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        if (this.f28493a) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void Z(BottomSheetBehavior bottomSheetBehavior, boolean z10) {
        this.f28493a = z10;
        if (bottomSheetBehavior.q0() == 5) {
            Y();
            return;
        }
        if (getDialog() instanceof c) {
            ((c) getDialog()).m();
        }
        bottomSheetBehavior.Y(new b());
        bottomSheetBehavior.U0(5);
    }

    private boolean a0(boolean z10) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof c)) {
            return false;
        }
        c cVar = (c) dialog;
        BottomSheetBehavior k11 = cVar.k();
        if (!k11.x0() || !cVar.l()) {
            return false;
        }
        Z(k11, z10);
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (a0(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (a0(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new c(getContext(), getTheme());
    }
}
