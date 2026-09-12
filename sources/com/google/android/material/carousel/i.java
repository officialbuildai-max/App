package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public final class i extends d {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f28697d = {1};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f28698e = {1, 0};

    /* renamed from: c, reason: collision with root package name */
    private int f28699c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.carousel.d
    public f g(b bVar, View view) {
        float b11 = bVar.b();
        if (bVar.d()) {
            b11 = bVar.a();
        }
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        float f11 = ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (bVar.d()) {
            f11 = ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f12 = f11;
        float d11 = d() + f12;
        float max = Math.max(c() + f12, d11);
        float min = Math.min(measuredHeight + f12, b11);
        float a11 = d1.a.a((measuredHeight / 3.0f) + f12, d11 + f12, max + f12);
        float f13 = (min + a11) / 2.0f;
        int[] iArr = f28697d;
        if (b11 < 2.0f * d11) {
            iArr = new int[]{0};
        }
        int[] iArr2 = f28698e;
        if (bVar.c() == 1) {
            iArr = d.a(iArr);
            iArr2 = d.a(iArr2);
        }
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int max2 = (int) Math.max(1.0d, Math.floor(((b11 - (e.i(iArr4) * f13)) - (e.i(iArr3) * max)) / min));
        int ceil = (int) Math.ceil(b11 / min);
        int i11 = (ceil - max2) + 1;
        int[] iArr5 = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr5[i12] = ceil - i12;
        }
        a c11 = a.c(b11, a11, d11, max, iArr3, f13, iArr4, min, iArr5);
        this.f28699c = c11.e();
        if (i(c11, bVar.getItemCount())) {
            c11 = a.c(b11, a11, d11, max, new int[]{c11.f28658c}, f13, new int[]{c11.f28659d}, min, new int[]{c11.f28662g});
        }
        return e.d(view.getContext(), f12, b11, c11, bVar.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.carousel.d
    public boolean h(b bVar, int i11) {
        return (i11 < this.f28699c && bVar.getItemCount() >= this.f28699c) || (i11 >= this.f28699c && bVar.getItemCount() < this.f28699c);
    }

    boolean i(a aVar, int i11) {
        int e11 = aVar.e() - i11;
        boolean z10 = e11 > 0 && (aVar.f28658c > 0 || aVar.f28659d > 1);
        while (e11 > 0) {
            int i12 = aVar.f28658c;
            if (i12 > 0) {
                aVar.f28658c = i12 - 1;
            } else {
                int i13 = aVar.f28659d;
                if (i13 > 1) {
                    aVar.f28659d = i13 - 1;
                }
            }
            e11--;
        }
        return z10;
    }
}
