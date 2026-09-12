package com.bytedance.sdk.openadsdk.component.reward.Sj;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import com.bytedance.sdk.component.utils.LqL;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.openadsdk.utils.FPG;

/* loaded from: classes3.dex */
public class aa {
    private Sj EjP;
    protected int Sj;
    private boolean TKC = true;
    private final com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sP;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class Sj implements View.OnLayoutChangeListener {
        private int Sj;
        private int sP;

        private Sj() {
        }

        abstract void Sj(int i11, int i12);

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            int i19 = i13 - i11;
            int i20 = i14 - i12;
            if (i19 == this.Sj && i20 == this.sP) {
                return;
            }
            this.Sj = i19;
            this.sP = i20;
            Sj(i19, i20);
        }
    }

    public aa(com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2) {
        this.Sj = 0;
        this.sP = sj2;
        TKC();
        if (sj2.Sj == 2) {
            return;
        }
        try {
            this.Sj = FPG.TKC(sj2.Fm, FPG.Sj());
            if (!sj2.Fm.getWindow().hasFeature(1)) {
                sj2.Fm.requestWindowFeature(1);
            }
            sj2.Fm.getWindow().addFlags(16777344);
            if (sj2.sdp == 2 || !FPG.TKC(sj2.Fm)) {
                sj2.Fm.getWindow().addFlags(1024);
            }
        } catch (Throwable th2) {
            Log.e("TTAD.RFSM", "init: ", th2);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private void EjP() {
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.sP;
        if (sj2.sdp != 2) {
            Sj(sj2.Fm, 1);
        } else if (sj2.EZ) {
            Sj(sj2.Fm, 8);
        } else {
            Sj(sj2.Fm, 0);
        }
    }

    private float HiB() {
        return FPG.TKC(this.sP.Fm, FPG.aa(this.sP.Fm));
    }

    private static void Sj(Activity activity, int i11) {
        if (activity.getRequestedOrientation() == i11) {
            return;
        }
        activity.setRequestedOrientation(i11);
    }

    private void TKC() {
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.sP;
        sj2.MuB = sj2.sP.tY();
        if (26 != Build.VERSION.SDK_INT) {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.sP;
            sj3.sdp = sj3.sP.liH();
        } else if (this.sP.Fm.getResources().getConfiguration().orientation == 1) {
            this.sP.sdp = 1;
        } else {
            this.sP.sdp = 2;
        }
    }

    private float[] sP(int i11) {
        float vS = vS();
        float HiB = HiB();
        int i12 = this.sP.sdp;
        if ((i12 == 1) != (vS > HiB)) {
            float f11 = vS + HiB;
            HiB = f11 - HiB;
            vS = f11 - HiB;
        }
        if (i12 == 1) {
            vS -= i11;
        } else {
            HiB -= i11;
        }
        return new float[]{HiB, vS};
    }

    private float vS() {
        return FPG.TKC(this.sP.Fm, FPG.Ym(this.sP.Fm));
    }

    public void Sj() {
        FPG.Sj(this.sP.Fm);
        this.sP.Fm.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.aa.3
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i11) {
                if (i11 == 0) {
                    try {
                        if (aa.this.sP.Fm.isFinishing()) {
                            return;
                        }
                        aa.this.sP.Fm.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.aa.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FPG.Sj(aa.this.sP.Fm);
                            }
                        }, 2500L);
                    } catch (Exception e11) {
                        sU.sP("TTAD.RFSM", e11.getMessage());
                    }
                }
            }
        });
    }

    public void Sj(LqL lqL) {
        if (lqL == null) {
            return;
        }
        lqL.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.aa.1
            @Override // java.lang.Runnable
            public void run() {
                View findViewById;
                try {
                    View decorView = aa.this.sP.Fm.getWindow().getDecorView();
                    if (decorView == null || (findViewById = decorView.findViewById(R.id.statusBarBackground)) == null) {
                        return;
                    }
                    findViewById.setVisibility(8);
                } catch (Exception unused) {
                }
            }
        }, 300L);
    }

    public void Sj(boolean z10) {
        float min;
        float max;
        int max2;
        int i11;
        int i12;
        int i13 = Build.VERSION.SDK_INT;
        if (i13 != 26) {
            if (i13 == 27) {
                try {
                    EjP();
                } catch (Throwable unused) {
                }
            } else {
                EjP();
            }
        }
        float HiB = HiB();
        float vS = vS();
        if (this.sP.sdp == 2) {
            min = Math.max(HiB, vS);
            max = Math.min(HiB, vS);
        } else {
            min = Math.min(HiB, vS);
            max = Math.max(HiB, vS);
        }
        Activity activity = this.sP.Fm;
        int TKC = FPG.TKC(activity, FPG.Sj());
        if (this.sP.sdp != 2) {
            if (FPG.TKC(activity)) {
                max -= TKC;
            }
        } else if (FPG.TKC(activity)) {
            min -= TKC;
        }
        if (z10) {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.sP;
            sj2.IOh = (int) min;
            sj2.pfr = (int) max;
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.sP;
        int i14 = 20;
        if (sj3.sdp != 2) {
            float f11 = sj3.MuB;
            if (f11 != 0.0f && f11 != 100.0f) {
                i11 = (int) Math.max((max - (((min - 20.0f) - 20.0f) / f11)) / 2.0f, 0.0f);
                i12 = i11;
                max2 = 20;
            }
            i14 = 0;
            max2 = 0;
            i11 = 0;
            i12 = 0;
        } else {
            float f12 = sj3.MuB;
            if (f12 != 0.0f && f12 != 100.0f) {
                max2 = (int) Math.max((min - (((max - 20.0f) - 20.0f) * f12)) / 2.0f, 0.0f);
                i11 = 20;
                i12 = 20;
                i14 = max2;
            }
            i14 = 0;
            max2 = 0;
            i11 = 0;
            i12 = 0;
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = this.sP;
        float f13 = i14;
        float f14 = max2;
        sj4.IOh = (int) ((min - f13) - f14);
        float f15 = i11;
        float f16 = i12;
        sj4.pfr = (int) ((max - f15) - f16);
        com.bytedance.sdk.openadsdk.activity.vS vSVar = sj4.HS;
        if (vSVar == null || vSVar.uA <= 0) {
            activity.getWindow().getDecorView().setPadding(FPG.sP(activity, f13), FPG.sP(activity, f15), FPG.sP(activity, f14), FPG.sP(activity, f16));
        }
    }

    public float[] Sj(int i11) {
        float[] fArr = new float[2];
        Activity activity = this.sP.Fm;
        View decorView = activity.getWindow().getDecorView();
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 35 || this.sP.sP.tY() != 100.0f) {
            fArr[0] = decorView.getWidth() - (decorView.getPaddingLeft() * 2);
            fArr[1] = decorView.getHeight() - (decorView.getPaddingTop() * 2);
        } else {
            fArr[0] = decorView.getWidth() - decorView.getPaddingLeft();
            fArr[1] = decorView.getHeight() - decorView.getPaddingTop();
        }
        fArr[0] = FPG.TKC(activity, fArr[0]);
        float TKC = FPG.TKC(activity, fArr[1]);
        fArr[1] = TKC;
        if (fArr[0] < 10.0f || TKC < 10.0f) {
            fArr = sP(this.Sj);
        }
        if (i12 != 26 && i12 != 27 && activity.getResources() != null && activity.getResources().getConfiguration() != null) {
            if ((activity.getResources().getConfiguration().orientation == 2 ? 2 : 1) != i11) {
                if (i11 == 2) {
                    float f11 = fArr[0];
                    float f12 = fArr[1];
                    if (f11 < f12) {
                        fArr[1] = f11;
                        fArr[0] = f12;
                    }
                } else {
                    float f13 = fArr[0];
                    float f14 = fArr[1];
                    if (f13 > f14) {
                        fArr[1] = f13;
                        fArr[0] = f14;
                    }
                }
            }
        }
        return fArr;
    }

    public void sP() {
        if (this.EjP != null) {
            this.sP.Fm.getWindow().getDecorView().removeOnLayoutChangeListener(this.EjP);
            this.EjP = null;
        }
    }

    public void sP(LqL lqL) {
        try {
            com.bytedance.sdk.openadsdk.activity.vS vSVar = this.sP.HS;
            if (vSVar == null || vSVar.uA <= 0) {
                final boolean z10 = true;
                final boolean z11 = this.TKC && com.bytedance.sdk.openadsdk.core.dNu.EjP().WMZ() == 1;
                if (!this.TKC || !FPG.TKC(this.sP.Fm)) {
                    z10 = false;
                }
                if (z10 || z11) {
                    if (this.EjP == null) {
                        this.EjP = new Sj() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.aa.2
                            boolean Sj;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super();
                            }

                            /* JADX WARN: Removed duplicated region for block: B:17:0x00e9 A[Catch: all -> 0x010c, TryCatch #0 {all -> 0x010c, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x001f, B:7:0x006a, B:9:0x0088, B:11:0x0097, B:13:0x00ab, B:14:0x00af, B:15:0x00e3, B:17:0x00e9, B:18:0x00ee, B:20:0x00fc, B:24:0x00b2, B:26:0x00bc, B:28:0x00d0, B:30:0x00d4, B:31:0x00da, B:33:0x00de, B:34:0x0102, B:36:0x0106, B:39:0x0045), top: B:1:0x0000 }] */
                            /* JADX WARN: Removed duplicated region for block: B:20:0x00fc A[Catch: all -> 0x010c, TryCatch #0 {all -> 0x010c, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x001f, B:7:0x006a, B:9:0x0088, B:11:0x0097, B:13:0x00ab, B:14:0x00af, B:15:0x00e3, B:17:0x00e9, B:18:0x00ee, B:20:0x00fc, B:24:0x00b2, B:26:0x00bc, B:28:0x00d0, B:30:0x00d4, B:31:0x00da, B:33:0x00de, B:34:0x0102, B:36:0x0106, B:39:0x0045), top: B:1:0x0000 }] */
                            /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
                            @Override // com.bytedance.sdk.openadsdk.component.reward.Sj.aa.Sj
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            void Sj(int r7, int r8) {
                                /*
                                    Method dump skipped, instructions count: 269
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.Sj.aa.AnonymousClass2.Sj(int, int):void");
                            }
                        };
                    }
                    this.sP.Fm.getWindow().getDecorView().addOnLayoutChangeListener(this.EjP);
                }
                this.TKC = false;
            }
        } catch (Exception unused) {
        }
    }
}
