package com.cloud.tmc.miniapp.widget.pulldownrefresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.MiniRefreshState;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes3.dex */
public class OooO00o extends ViewGroup implements com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO, NestedScrollingParent {
    public static com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO00o o00000O;
    public static com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0O0 o00000OO;
    public static com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0OO o00000Oo;
    public static ViewGroup.MarginLayoutParams o00000o0 = new ViewGroup.MarginLayoutParams(-1, -1);
    public float OooO;
    public int OooO00o;
    public int OooO0O0;
    public int OooO0OO;
    public int OooO0Oo;
    public int OooO0o;
    public int OooO0o0;
    public int OooO0oO;
    public float OooO0oo;
    public float OooOO0;
    public float OooOO0O;
    public float OooOO0o;
    public float OooOOO;
    public float OooOOO0;
    public char OooOOOO;
    public boolean OooOOOo;
    public boolean OooOOo;
    public boolean OooOOo0;
    public int OooOOoo;
    public int OooOo;
    public int OooOo0;
    public int OooOo00;
    public int OooOo0O;
    public int OooOo0o;
    public Scroller OooOoO;
    public int OooOoO0;
    public VelocityTracker OooOoOO;
    public int[] OooOoo;
    public Interpolator OooOoo0;
    public boolean OooOooO;
    public boolean OooOooo;
    public boolean Oooo;
    public boolean Oooo0;
    public boolean Oooo000;
    public boolean Oooo00O;
    public boolean Oooo00o;
    public boolean Oooo0O0;
    public boolean Oooo0OO;
    public boolean Oooo0o;
    public boolean Oooo0o0;
    public boolean Oooo0oO;
    public boolean Oooo0oo;
    public boolean OoooO;
    public boolean OoooO0;
    public boolean OoooO00;
    public boolean OoooO0O;
    public boolean OoooOO0;
    public boolean OoooOOO;
    public boolean OoooOOo;
    public boolean OoooOo0;
    public boolean OoooOoO;
    public com.cloud.tmc.miniapp.widget.pulldownrefresh.listener.OooO0OO OoooOoo;
    public com.cloud.tmc.miniapp.widget.pulldownrefresh.listener.OooO0O0 Ooooo00;
    public int Ooooo0o;
    public boolean OooooO0;
    public int[] OooooOO;
    public NestedScrollingChildHelper OooooOo;
    public int Oooooo;
    public NestedScrollingParentHelper Oooooo0;
    public com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO00o OoooooO;
    public int Ooooooo;
    public Runnable o00000;
    public boolean o000000;
    public boolean o000000O;
    public MotionEvent o000000o;
    public ValueAnimator o00000O0;
    public boolean o000OOo;
    public boolean o000oOoO;
    public int o00O0O;
    public float o00Oo0;
    public float o00Ooo;
    public float o00o0O;
    public com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0o o00oO0O;
    public com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O o00oO0o;
    public float o00ooo;
    public int o0O0O00;
    public long o0OO00O;
    public MiniRefreshState o0OOO0o;
    public MiniRefreshState o0Oo0oo;
    public com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO00o o0OoOo0;
    public Paint o0ooOO0;
    public Handler o0ooOOo;
    public com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO0 o0ooOoO;
    public com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oo000o;
    public int oo0o0Oo;
    public int ooOO;

    /* loaded from: classes3.dex */
    public class OooO implements ValueAnimator.AnimatorUpdateListener {
        public OooO() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            OooO00o oooO00o = OooO00o.this;
            if (oooO00o.o00000O0 != null) {
                ((OooOo) oooO00o.o0ooOoO).OooO00o(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }
    }

    /* renamed from: com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o$OooO00o, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0353OooO00o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[MiniRefreshState.values().length];
            OooO00o = iArr;
            try {
                iArr[MiniRefreshState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                OooO00o[MiniRefreshState.PULL_DOWN_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                OooO00o[MiniRefreshState.PULL_UP_TO_LOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                OooO00o[MiniRefreshState.PULL_DOWN_CANCELED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                OooO00o[MiniRefreshState.PULL_UP_CANCELED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                OooO00o[MiniRefreshState.RELEASE_TO_REFRESH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                OooO00o[MiniRefreshState.RELEASE_TO_LOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                OooO00o[MiniRefreshState.RELEASE_TO_TWO_LEVEL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                OooO00o[MiniRefreshState.REFRESH_RELEASED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                OooO00o[MiniRefreshState.LOAD_RELEASED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                OooO00o[MiniRefreshState.REFRESHING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                OooO00o[MiniRefreshState.LOADING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class OooO0O0 extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean OooO00o;

        public OooO0O0(boolean z10) {
            this.OooO00o = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                OooO00o.this.setStateDirectLoading(this.OooO00o);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class OooO0OO extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean OooO00o;

        public OooO0OO(boolean z10) {
            this.OooO00o = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                OooO00o.this.o0OO00O = System.currentTimeMillis();
                OooO00o.this.OooO00o(MiniRefreshState.REFRESHING);
                OooO00o oooO00o = OooO00o.this;
                com.cloud.tmc.miniapp.widget.pulldownrefresh.listener.OooO0OO oooO0OO = oooO00o.OoooOoo;
                if (oooO0OO == null) {
                    oooO00o.OooO00o(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, true, Boolean.FALSE);
                } else if (this.OooO00o) {
                    oooO0OO.OooO00o(oooO00o);
                }
                OooO00o oooO00o2 = OooO00o.this;
                com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O = oooO00o2.oo000o;
                if (oooOO0O != null) {
                    int i11 = oooO00o2.Oooooo;
                    oooOO0O.OooO0O0(oooO00o2, i11, (int) (oooO00o2.o00Oo0 * i11));
                }
                OooO00o.this.getClass();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class OooO0o extends AnimatorListenerAdapter {
        public OooO0o() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MiniRefreshState miniRefreshState;
            MiniRefreshState miniRefreshState2;
            if (animator == null || animator.getDuration() != 0) {
                OooO00o oooO00o = OooO00o.this;
                oooO00o.o00000O0 = null;
                if (oooO00o.OooO0O0 == 0 && (miniRefreshState = oooO00o.o0OOO0o) != (miniRefreshState2 = MiniRefreshState.NONE) && !miniRefreshState.isOpening && !miniRefreshState.isDragging) {
                    oooO00o.OooO00o(miniRefreshState2);
                    return;
                }
                MiniRefreshState miniRefreshState3 = oooO00o.o0OOO0o;
                if (miniRefreshState3 != oooO00o.o0Oo0oo) {
                    oooO00o.setViceState(miniRefreshState3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class OooOO0 implements Runnable {
        public OooOO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OooO00o oooO00o = OooO00o.this;
            com.cloud.tmc.miniapp.widget.pulldownrefresh.listener.OooO0O0 oooO0O0 = oooO00o.Ooooo00;
            if (oooO0O0 != null) {
                oooO0O0.OooO00o(oooO00o);
            } else {
                oooO00o.OooO00o(2000, true, false);
            }
            OooO00o.this.getClass();
        }
    }

    /* loaded from: classes3.dex */
    public class OooOO0O implements Runnable {
        public int OooO00o = 0;
        public final /* synthetic */ int OooO0O0;
        public final /* synthetic */ Boolean OooO0OO;
        public final /* synthetic */ boolean OooO0Oo;

        public OooOO0O(int i11, Boolean bool, boolean z10) {
            this.OooO0O0 = i11;
            this.OooO0OO = bool;
            this.OooO0Oo = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i11 = this.OooO00o;
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
            if (i11 == 0) {
                OooO00o oooO00o = OooO00o.this;
                MiniRefreshState miniRefreshState = oooO00o.o0OOO0o;
                MiniRefreshState miniRefreshState2 = MiniRefreshState.NONE;
                if (miniRefreshState == miniRefreshState2 && oooO00o.o0Oo0oo == MiniRefreshState.REFRESHING) {
                    oooO00o.o0Oo0oo = miniRefreshState2;
                } else {
                    ValueAnimator valueAnimator = oooO00o.o00000O0;
                    if (valueAnimator != null && miniRefreshState.isHeader && (miniRefreshState.isDragging || miniRefreshState == MiniRefreshState.REFRESH_RELEASED)) {
                        valueAnimator.setDuration(0L);
                        OooO00o.this.o00000O0.cancel();
                        OooO00o oooO00o2 = OooO00o.this;
                        oooO00o2.o00000O0 = null;
                        if (((OooOo) oooO00o2.o0ooOoO).OooO00o(0) == null) {
                            OooO00o.this.OooO00o(miniRefreshState2);
                        } else {
                            OooO00o.this.OooO00o(MiniRefreshState.PULL_DOWN_CANCELED);
                        }
                    } else if (miniRefreshState == MiniRefreshState.REFRESHING && oooO00o.oo000o != null && oooO00o.o00oO0O != null) {
                        this.OooO00o = i11 + 1;
                        oooO00o.o0ooOOo.postDelayed(this, this.OooO0O0);
                        OooO00o.this.OooO00o(MiniRefreshState.REFRESH_FINISH);
                        if (this.OooO0OO == Boolean.FALSE) {
                            OooO00o.this.OooO0O0(false);
                        }
                    }
                }
                if (this.OooO0OO == Boolean.TRUE) {
                    OooO00o.this.OooO0O0(true);
                    return;
                }
                return;
            }
            OooO00o oooO00o3 = OooO00o.this;
            int OooO00o = oooO00o3.oo000o.OooO00o(oooO00o3, this.OooO0Oo);
            OooO00o.this.getClass();
            if (OooO00o < Integer.MAX_VALUE) {
                OooO00o oooO00o4 = OooO00o.this;
                if (oooO00o4.OooOOOo || oooO00o4.OooooO0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    OooO00o oooO00o5 = OooO00o.this;
                    if (oooO00o5.OooOOOo) {
                        float f11 = oooO00o5.OooOO0O;
                        oooO00o5.OooO = f11;
                        oooO00o5.OooO0Oo = 0;
                        oooO00o5.OooOOOo = false;
                        OooO00o.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, oooO00o5.OooOO0, (f11 + oooO00o5.OooO0O0) - (oooO00o5.OooO00o * 2), 0));
                        OooO00o oooO00o6 = OooO00o.this;
                        OooO00o.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, oooO00o6.OooOO0, oooO00o6.OooOO0O + oooO00o6.OooO0O0, 0));
                    }
                    OooO00o oooO00o7 = OooO00o.this;
                    if (oooO00o7.OooooO0) {
                        oooO00o7.Ooooo0o = 0;
                        OooO00o.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, oooO00o7.OooOO0, oooO00o7.OooOO0O, 0));
                        OooO00o oooO00o8 = OooO00o.this;
                        oooO00o8.OooooO0 = false;
                        oooO00o8.OooO0Oo = 0;
                    }
                }
                OooO00o oooO00o9 = OooO00o.this;
                int i12 = oooO00o9.OooO0O0;
                if (i12 <= 0) {
                    if (i12 < 0) {
                        oooO00o9.OooO00o(0, OooO00o, oooO00o9.OooOoo0, oooO00o9.OooO0o);
                        return;
                    }
                    ((OooOo) oooO00o9.o0ooOoO).OooO00o(0, false);
                    ((OooOo) OooO00o.this.o0ooOoO).OooO00o(MiniRefreshState.NONE);
                    return;
                }
                ValueAnimator OooO00o2 = oooO00o9.OooO00o(0, OooO00o, oooO00o9.OooOoo0, oooO00o9.OooO0o);
                OooO00o oooO00o10 = OooO00o.this;
                if (oooO00o10.OoooO00) {
                    animatorUpdateListener = ((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) oooO00o10.o00oO0O).OooO00o(oooO00o10.OooO0O0);
                }
                if (OooO00o2 == null || animatorUpdateListener == null) {
                    return;
                }
                OooO00o2.addUpdateListener(animatorUpdateListener);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class OooOOO implements Runnable {
        public int OooO0O0;
        public float OooO0o0;
        public int OooO00o = 0;
        public float OooO0Oo = 0.0f;
        public long OooO0OO = AnimationUtils.currentAnimationTimeMillis();

        public OooOOO(float f11, int i11) {
            this.OooO0o0 = f11;
            this.OooO0O0 = i11;
            OooO00o.this.o0ooOOo.postDelayed(this, 10);
            if (f11 > 0.0f) {
                ((OooOo) OooO00o.this.o0ooOoO).OooO00o(MiniRefreshState.PULL_DOWN_TO_REFRESH);
            } else {
                ((OooOo) OooO00o.this.o0ooOoO).OooO00o(MiniRefreshState.PULL_UP_TO_LOAD);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            OooO00o oooO00o = OooO00o.this;
            if (oooO00o.o00000 != this || oooO00o.o0OOO0o.isFinishing) {
                return;
            }
            if (Math.abs(oooO00o.OooO0O0) < Math.abs(this.OooO0O0)) {
                double d11 = this.OooO0o0;
                int i11 = this.OooO00o + 1;
                this.OooO00o = i11;
                this.OooO0o0 = (float) (Math.pow(0.949999988079071d, i11 * 2.0d) * d11);
            } else if (this.OooO0O0 != 0) {
                double d12 = this.OooO0o0;
                int i12 = this.OooO00o + 1;
                this.OooO00o = i12;
                this.OooO0o0 = (float) (Math.pow(0.44999998807907104d, i12 * 2.0d) * d12);
            } else {
                double d13 = this.OooO0o0;
                int i13 = this.OooO00o + 1;
                this.OooO00o = i13;
                this.OooO0o0 = (float) (Math.pow(0.8500000238418579d, i13 * 2.0d) * d13);
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f11 = this.OooO0o0 * ((((float) (currentAnimationTimeMillis - this.OooO0OO)) * 1.0f) / 1000.0f);
            if (Math.abs(f11) >= 1.0f) {
                this.OooO0OO = currentAnimationTimeMillis;
                float f12 = this.OooO0Oo + f11;
                this.OooO0Oo = f12;
                OooO00o.this.OooO00o(f12);
                OooO00o.this.o0ooOOo.postDelayed(this, 10);
                return;
            }
            OooO00o oooO00o2 = OooO00o.this;
            MiniRefreshState miniRefreshState = oooO00o2.o0Oo0oo;
            boolean z10 = miniRefreshState.isDragging;
            if (z10 && miniRefreshState.isHeader) {
                ((OooOo) oooO00o2.o0ooOoO).OooO00o(MiniRefreshState.PULL_DOWN_CANCELED);
            } else if (z10 && miniRefreshState.isFooter) {
                ((OooOo) oooO00o2.o0ooOoO).OooO00o(MiniRefreshState.PULL_UP_CANCELED);
            }
            OooO00o oooO00o3 = OooO00o.this;
            oooO00o3.o00000 = null;
            if (Math.abs(oooO00o3.OooO0O0) >= Math.abs(this.OooO0O0)) {
                int min = Math.min(Math.max((int) (Math.abs(OooO00o.this.OooO0O0 - this.OooO0O0) / com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO0O0), 30), 100) * 10;
                OooO00o oooO00o4 = OooO00o.this;
                oooO00o4.OooO00o(this.OooO0O0, 0, oooO00o4.OooOoo0, min);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class OooOOO0 implements Runnable {
        public int OooO00o = 0;
        public final /* synthetic */ int OooO0O0;
        public final /* synthetic */ boolean OooO0OO;
        public final /* synthetic */ boolean OooO0Oo;

        /* renamed from: com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o$OooOOO0$OooO00o, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0354OooO00o implements Runnable {
            public final /* synthetic */ int OooO00o;

            /* renamed from: com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o$OooOOO0$OooO00o$OooO00o, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0355OooO00o extends AnimatorListenerAdapter {
                public C0355OooO00o() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator == null || animator.getDuration() != 0) {
                        OooOOO0 oooOOO0 = OooOOO0.this;
                        OooO00o oooO00o = OooO00o.this;
                        oooO00o.o000000 = false;
                        if (oooOOO0.OooO0OO) {
                            oooO00o.OooO0O0(true);
                        }
                        OooO00o oooO00o2 = OooO00o.this;
                        if (oooO00o2.o0OOO0o == MiniRefreshState.LOAD_FINISH) {
                            oooO00o2.OooO00o(MiniRefreshState.NONE);
                        }
                    }
                }
            }

            public RunnableC0354OooO00o(int i11) {
                this.OooO00o = i11;
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
                ValueAnimator valueAnimator;
                OooO00o oooO00o = OooO00o.this;
                if (!oooO00o.Oooo || this.OooO00o >= 0) {
                    animatorUpdateListener = null;
                } else {
                    animatorUpdateListener = ((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) oooO00o.o00oO0O).OooO00o(oooO00o.OooO0O0);
                    if (animatorUpdateListener != null) {
                        ((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) animatorUpdateListener).onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                    }
                }
                C0355OooO00o c0355OooO00o = new C0355OooO00o();
                OooOOO0 oooOOO0 = OooOOO0.this;
                OooO00o oooO00o2 = OooO00o.this;
                int i11 = oooO00o2.OooO0O0;
                if (i11 > 0) {
                    valueAnimator = ((OooOo) oooO00o2.o0ooOoO).OooO00o(0);
                } else {
                    if (animatorUpdateListener != null || i11 == 0) {
                        ValueAnimator valueAnimator2 = oooO00o2.o00000O0;
                        if (valueAnimator2 != null) {
                            valueAnimator2.setDuration(0L);
                            OooO00o.this.o00000O0.cancel();
                            OooO00o.this.o00000O0 = null;
                        }
                        ((OooOo) OooO00o.this.o0ooOoO).OooO00o(0, false);
                        ((OooOo) OooO00o.this.o0ooOoO).OooO00o(MiniRefreshState.NONE);
                    } else if (oooOOO0.OooO0OO && oooO00o2.Oooo0O0) {
                        int i12 = -oooO00o2.Ooooooo;
                        if (i11 >= i12) {
                            oooO00o2.OooO00o(MiniRefreshState.NONE);
                        } else {
                            valueAnimator = ((OooOo) oooO00o2.o0ooOoO).OooO00o(i12);
                        }
                    } else {
                        valueAnimator = ((OooOo) oooO00o2.o0ooOoO).OooO00o(0);
                    }
                    valueAnimator = null;
                }
                if (valueAnimator != null) {
                    valueAnimator.addListener(c0355OooO00o);
                } else {
                    c0355OooO00o.onAnimationEnd(null);
                }
            }
        }

        public OooOOO0(int i11, boolean z10, boolean z11) {
            this.OooO0O0 = i11;
            this.OooO0OO = z10;
            this.OooO0Oo = z11;
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a6, code lost:
        
            if (((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) r6.o00oO0O).OooO00o() != false) goto L44;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 317
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.OooOOO0.run():void");
        }
    }

    /* loaded from: classes3.dex */
    public class OooOOOO implements Runnable {
        public int OooO00o;
        public float OooO0O0;
        public long OooO0OO = 0;
        public long OooO0Oo = AnimationUtils.currentAnimationTimeMillis();

        public OooOOOO(float f11) {
            this.OooO0O0 = f11;
            this.OooO00o = OooO00o.this.OooO0O0;
        }

        @Override // java.lang.Runnable
        public void run() {
            OooO00o oooO00o = OooO00o.this;
            if (oooO00o.o00000 != this || oooO00o.o0OOO0o.isFinishing) {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j11 = currentAnimationTimeMillis - this.OooO0Oo;
            float pow = (float) (Math.pow(0.98f, ((float) (currentAnimationTimeMillis - this.OooO0OO)) / (1000.0f / 10)) * this.OooO0O0);
            this.OooO0O0 = pow;
            float f11 = ((((float) j11) * 1.0f) / 1000.0f) * pow;
            if (Math.abs(f11) <= 1.0f) {
                OooO00o.this.o00000 = null;
                return;
            }
            this.OooO0Oo = currentAnimationTimeMillis;
            int i11 = (int) (this.OooO00o + f11);
            this.OooO00o = i11;
            OooO00o oooO00o2 = OooO00o.this;
            if (oooO00o2.OooO0O0 * i11 > 0) {
                ((OooOo) oooO00o2.o0ooOoO).OooO00o(i11, true);
                OooO00o.this.o0ooOOo.postDelayed(this, 10);
                return;
            }
            oooO00o2.o00000 = null;
            ((OooOo) oooO00o2.o0ooOoO).OooO00o(0, true);
            View view = ((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) OooO00o.this.o00oO0O).OooO0OO;
            int i12 = (int) (-this.OooO0O0);
            float f12 = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO0O0;
            if (view instanceof ScrollView) {
                ((ScrollView) view).fling(i12);
            } else if (view instanceof AbsListView) {
                ((AbsListView) view).fling(i12);
            } else if (view instanceof WebView) {
                ((WebView) view).flingScroll(0, i12);
            } else if (view instanceof NestedScrollView) {
                ((NestedScrollView) view).fling(i12);
            } else if (view instanceof RecyclerView) {
                ((RecyclerView) view).fling(0, i12);
            }
            OooO00o oooO00o3 = OooO00o.this;
            if (!oooO00o3.o000000 || f11 <= 0.0f) {
                return;
            }
            oooO00o3.o000000 = false;
        }
    }

    /* loaded from: classes3.dex */
    public class OooOo implements com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO0 {
        public OooOo() {
        }

        public ValueAnimator OooO00o(int i11) {
            OooO00o oooO00o = OooO00o.this;
            return oooO00o.OooO00o(i11, 0, oooO00o.OooOoo0, oooO00o.OooO0o);
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00ba  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO0 OooO00o(int r17, boolean r18) {
            /*
                Method dump skipped, instructions count: 819
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.OooOo.OooO00o(int, boolean):com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO0");
        }

        public com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO0 OooO00o(@NonNull com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O) {
            if (oooOO0O.equals(OooO00o.this.oo000o)) {
                OooO00o oooO00o = OooO00o.this;
                com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO00o oooO00o2 = oooO00o.OoooooO;
                if (oooO00o2.OooO0O0) {
                    oooO00o.OoooooO = oooO00o2.OooO00o();
                }
            } else if (oooOO0O.equals(OooO00o.this.o00oO0o)) {
                OooO00o oooO00o3 = OooO00o.this;
                com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO00o oooO00o4 = oooO00o3.o0OoOo0;
                if (oooO00o4.OooO0O0) {
                    oooO00o3.o0OoOo0 = oooO00o4.OooO00o();
                }
            }
            return this;
        }

        public com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO0 OooO00o(@NonNull com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O, int i11) {
            OooO00o oooO00o = OooO00o.this;
            if (oooO00o.o0ooOO0 == null && i11 != 0) {
                oooO00o.o0ooOO0 = new Paint();
            }
            if (oooOO0O.equals(OooO00o.this.oo000o)) {
                OooO00o.this.oo0o0Oo = i11;
            } else if (oooOO0O.equals(OooO00o.this.o00oO0o)) {
                OooO00o.this.o0O0O00 = i11;
            }
            return this;
        }

        public com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO0 OooO00o(@NonNull MiniRefreshState miniRefreshState) {
            switch (C0353OooO00o.OooO00o[miniRefreshState.ordinal()]) {
                case 1:
                    OooO00o oooO00o = OooO00o.this;
                    MiniRefreshState miniRefreshState2 = oooO00o.o0OOO0o;
                    MiniRefreshState miniRefreshState3 = MiniRefreshState.NONE;
                    if (miniRefreshState2 != miniRefreshState3 && oooO00o.OooO0O0 == 0) {
                        oooO00o.OooO00o(miniRefreshState3);
                        return null;
                    }
                    if (oooO00o.OooO0O0 == 0) {
                        return null;
                    }
                    OooO00o(0);
                    return null;
                case 2:
                    OooO00o oooO00o2 = OooO00o.this;
                    if (oooO00o2.o0OOO0o.isOpening || !oooO00o2.OooO00o(oooO00o2.OooOooO)) {
                        OooO00o.this.setViceState(MiniRefreshState.PULL_DOWN_TO_REFRESH);
                        return null;
                    }
                    OooO00o.this.OooO00o(MiniRefreshState.PULL_DOWN_TO_REFRESH);
                    return null;
                case 3:
                    OooO00o oooO00o3 = OooO00o.this;
                    if (oooO00o3.OooO00o(oooO00o3.OooOooo)) {
                        OooO00o oooO00o4 = OooO00o.this;
                        MiniRefreshState miniRefreshState4 = oooO00o4.o0OOO0o;
                        if (!miniRefreshState4.isOpening && !miniRefreshState4.isFinishing && (!oooO00o4.o000oOoO || !oooO00o4.Oooo0O0 || !oooO00o4.OoooOOO)) {
                            oooO00o4.OooO00o(MiniRefreshState.PULL_UP_TO_LOAD);
                            return null;
                        }
                    }
                    OooO00o.this.setViceState(MiniRefreshState.PULL_UP_TO_LOAD);
                    return null;
                case 4:
                    OooO00o oooO00o5 = OooO00o.this;
                    if (oooO00o5.o0OOO0o.isOpening || !oooO00o5.OooO00o(oooO00o5.OooOooO)) {
                        OooO00o.this.setViceState(MiniRefreshState.PULL_DOWN_CANCELED);
                        return null;
                    }
                    OooO00o.this.OooO00o(MiniRefreshState.PULL_DOWN_CANCELED);
                    OooO00o(MiniRefreshState.NONE);
                    return null;
                case 5:
                    OooO00o oooO00o6 = OooO00o.this;
                    if (oooO00o6.OooO00o(oooO00o6.OooOooo)) {
                        OooO00o oooO00o7 = OooO00o.this;
                        if (!oooO00o7.o0OOO0o.isOpening && (!oooO00o7.o000oOoO || !oooO00o7.Oooo0O0 || !oooO00o7.OoooOOO)) {
                            oooO00o7.OooO00o(MiniRefreshState.PULL_UP_CANCELED);
                            OooO00o(MiniRefreshState.NONE);
                            return null;
                        }
                    }
                    OooO00o.this.setViceState(MiniRefreshState.PULL_UP_CANCELED);
                    return null;
                case 6:
                    OooO00o oooO00o8 = OooO00o.this;
                    if (oooO00o8.o0OOO0o.isOpening || !oooO00o8.OooO00o(oooO00o8.OooOooO)) {
                        OooO00o.this.setViceState(MiniRefreshState.RELEASE_TO_REFRESH);
                        return null;
                    }
                    OooO00o.this.OooO00o(MiniRefreshState.RELEASE_TO_REFRESH);
                    return null;
                case 7:
                    OooO00o oooO00o9 = OooO00o.this;
                    if (oooO00o9.OooO00o(oooO00o9.OooOooo)) {
                        OooO00o oooO00o10 = OooO00o.this;
                        MiniRefreshState miniRefreshState5 = oooO00o10.o0OOO0o;
                        if (!miniRefreshState5.isOpening && !miniRefreshState5.isFinishing && (!oooO00o10.o000oOoO || !oooO00o10.Oooo0O0 || !oooO00o10.OoooOOO)) {
                            oooO00o10.OooO00o(MiniRefreshState.RELEASE_TO_LOAD);
                            return null;
                        }
                    }
                    OooO00o.this.setViceState(MiniRefreshState.RELEASE_TO_LOAD);
                    return null;
                case 8:
                    OooO00o oooO00o11 = OooO00o.this;
                    if (oooO00o11.o0OOO0o.isOpening || !oooO00o11.OooO00o(oooO00o11.OooOooO)) {
                        OooO00o.this.setViceState(MiniRefreshState.RELEASE_TO_TWO_LEVEL);
                        return null;
                    }
                    OooO00o.this.OooO00o(MiniRefreshState.RELEASE_TO_TWO_LEVEL);
                    return null;
                case 9:
                    OooO00o oooO00o12 = OooO00o.this;
                    if (oooO00o12.o0OOO0o.isOpening || !oooO00o12.OooO00o(oooO00o12.OooOooO)) {
                        OooO00o.this.setViceState(MiniRefreshState.REFRESH_RELEASED);
                        return null;
                    }
                    OooO00o.this.OooO00o(MiniRefreshState.REFRESH_RELEASED);
                    return null;
                case 10:
                    OooO00o oooO00o13 = OooO00o.this;
                    if (oooO00o13.o0OOO0o.isOpening || !oooO00o13.OooO00o(oooO00o13.OooOooo)) {
                        OooO00o.this.setViceState(MiniRefreshState.LOAD_RELEASED);
                        return null;
                    }
                    OooO00o.this.OooO00o(MiniRefreshState.LOAD_RELEASED);
                    return null;
                case 11:
                    OooO00o.this.setStateRefreshing(true);
                    return null;
                case 12:
                    OooO00o.this.setStateLoading(true);
                    return null;
                default:
                    OooO00o.this.OooO00o(miniRefreshState);
                    return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class OooOo00 extends ViewGroup.MarginLayoutParams {
        public int OooO00o;
        public com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0 OooO0O0;

        public OooOo00(int i11, int i12) {
            super(i11, i12);
            this.OooO00o = 0;
            this.OooO0O0 = null;
        }

        public OooOo00(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.OooO00o = 0;
            this.OooO0O0 = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MiniRefreshLayout_Layout);
            this.OooO00o = obtainStyledAttributes.getColor(R.styleable.MiniRefreshLayout_Layout_layout_srlBackgroundColor, this.OooO00o);
            if (obtainStyledAttributes.hasValue(R.styleable.MiniRefreshLayout_Layout_layout_srlSpinnerStyle)) {
                this.OooO0O0 = com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0oo[obtainStyledAttributes.getInt(R.styleable.MiniRefreshLayout_Layout_layout_srlSpinnerStyle, 0)];
            }
            obtainStyledAttributes.recycle();
        }
    }

    public OooO00o(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.OooO0o0 = 300;
        this.OooO0o = 300;
        this.OooOO0o = 1.0f;
        this.OooOOO0 = 0.16666667f;
        this.OooOOO = 0.5f;
        this.OooOOOO = 'n';
        this.OooOOoo = -1;
        this.OooOo00 = -1;
        this.OooOo0 = -1;
        this.OooOo0O = -1;
        this.OooOooO = true;
        this.OooOooo = false;
        this.Oooo000 = true;
        this.Oooo00O = true;
        this.Oooo00o = true;
        this.Oooo0 = true;
        this.Oooo0O0 = false;
        this.Oooo0OO = true;
        this.Oooo0o0 = true;
        this.Oooo0o = false;
        this.Oooo0oO = true;
        this.Oooo0oo = false;
        this.Oooo = true;
        this.OoooO00 = true;
        this.OoooO0 = true;
        this.OoooO0O = true;
        this.OoooO = false;
        this.OoooOO0 = false;
        this.o000oOoO = false;
        this.OoooOOO = false;
        this.OoooOOo = false;
        this.OoooOo0 = false;
        this.OoooOoO = false;
        this.OooooOO = new int[2];
        this.OooooOo = new NestedScrollingChildHelper(this);
        this.Oooooo0 = new NestedScrollingParentHelper(this);
        com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO00o oooO00o = com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO00o.OooO0OO;
        this.OoooooO = oooO00o;
        this.o0OoOo0 = oooO00o;
        this.o00Oo0 = 2.5f;
        this.o00Ooo = 2.5f;
        this.o00o0O = 1.0f;
        this.o00ooo = 1.0f;
        this.o0ooOoO = new OooOo();
        MiniRefreshState miniRefreshState = MiniRefreshState.NONE;
        this.o0OOO0o = miniRefreshState;
        this.o0Oo0oo = miniRefreshState;
        this.o0OO00O = 0L;
        this.oo0o0Oo = 0;
        this.o0O0O00 = 0;
        this.o000000 = false;
        this.o000000O = false;
        this.o000000o = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o0ooOOo = new Handler();
        this.OooOoO = new Scroller(context);
        this.OooOoOO = VelocityTracker.obtain();
        this.OooO0oO = context.getResources().getDisplayMetrics().heightPixels;
        this.OooOoo0 = new com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0(0);
        this.OooO00o = viewConfiguration.getScaledTouchSlop();
        this.OooOo0o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.OooOo = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Ooooooo = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(60.0f);
        this.Oooooo = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.MiniRefreshLayout);
        if (!obtainStyledAttributes.hasValue(R.styleable.MiniRefreshLayout_android_clipToPadding)) {
            setClipToPadding(false);
        }
        if (!obtainStyledAttributes.hasValue(R.styleable.MiniRefreshLayout_android_clipChildren)) {
            setClipChildren(false);
        }
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0OO oooO0OO = o00000Oo;
        if (oooO0OO != null) {
            oooO0OO.OooO00o(context, this);
        }
        this.OooOOO = obtainStyledAttributes.getFloat(R.styleable.MiniRefreshLayout_srlDragRate, this.OooOOO);
        this.o00Oo0 = obtainStyledAttributes.getFloat(R.styleable.MiniRefreshLayout_srlHeaderMaxDragRate, this.o00Oo0);
        this.o00Ooo = obtainStyledAttributes.getFloat(R.styleable.MiniRefreshLayout_srlFooterMaxDragRate, this.o00Ooo);
        this.o00o0O = obtainStyledAttributes.getFloat(R.styleable.MiniRefreshLayout_srlHeaderTriggerRate, this.o00o0O);
        this.o00ooo = obtainStyledAttributes.getFloat(R.styleable.MiniRefreshLayout_srlFooterTriggerRate, this.o00ooo);
        this.OooOooO = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableRefresh, this.OooOooO);
        this.OooO0o = obtainStyledAttributes.getInt(R.styleable.MiniRefreshLayout_srlReboundDuration, this.OooO0o);
        this.OooOooo = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableLoadMore, this.OooOooo);
        this.Oooooo = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MiniRefreshLayout_srlHeaderHeight, this.Oooooo);
        this.Ooooooo = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MiniRefreshLayout_srlFooterHeight, this.Ooooooo);
        this.ooOO = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MiniRefreshLayout_srlHeaderInsetStart, this.ooOO);
        this.o00O0O = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MiniRefreshLayout_srlFooterInsetStart, this.o00O0O);
        this.OoooO = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlDisableContentWhenRefresh, this.OoooO);
        this.OoooOO0 = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlDisableContentWhenLoading, this.OoooOO0);
        this.Oooo00o = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableHeaderTranslationContent, this.Oooo00o);
        this.Oooo0 = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableFooterTranslationContent, this.Oooo0);
        this.Oooo0OO = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnablePreviewInEditMode, this.Oooo0OO);
        this.Oooo0oO = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableAutoLoadMore, this.Oooo0oO);
        this.Oooo0o0 = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableOverScrollBounce, this.Oooo0o0);
        this.Oooo0oo = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnablePureScrollMode, this.Oooo0oo);
        this.Oooo = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableScrollContentWhenLoaded, this.Oooo);
        this.OoooO00 = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableScrollContentWhenRefreshed, this.OoooO00);
        this.OoooO0 = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.OoooO0);
        boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.Oooo0O0);
        this.Oooo0O0 = z10;
        this.Oooo0O0 = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z10);
        this.Oooo000 = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.Oooo000);
        this.Oooo00O = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.Oooo00O);
        this.Oooo0o = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableOverScrollDrag, this.Oooo0o);
        this.OooOOoo = obtainStyledAttributes.getResourceId(R.styleable.MiniRefreshLayout_srlFixedHeaderViewId, this.OooOOoo);
        this.OooOo00 = obtainStyledAttributes.getResourceId(R.styleable.MiniRefreshLayout_srlFixedFooterViewId, this.OooOo00);
        this.OooOo0 = obtainStyledAttributes.getResourceId(R.styleable.MiniRefreshLayout_srlHeaderTranslationViewId, this.OooOo0);
        this.OooOo0O = obtainStyledAttributes.getResourceId(R.styleable.MiniRefreshLayout_srlFooterTranslationViewId, this.OooOo0O);
        boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.MiniRefreshLayout_srlEnableNestedScrolling, this.OoooO0O);
        this.OoooO0O = z11;
        this.OooooOo.setNestedScrollingEnabled(z11);
        this.OoooOOo = this.OoooOOo || obtainStyledAttributes.hasValue(R.styleable.MiniRefreshLayout_srlEnableLoadMore);
        this.OoooOo0 = this.OoooOo0 || obtainStyledAttributes.hasValue(R.styleable.MiniRefreshLayout_srlEnableHeaderTranslationContent);
        this.OoooOoO = this.OoooOoO || obtainStyledAttributes.hasValue(R.styleable.MiniRefreshLayout_srlEnableFooterTranslationContent);
        this.OoooooO = obtainStyledAttributes.hasValue(R.styleable.MiniRefreshLayout_srlHeaderHeight) ? com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO00o.OooO0o : this.OoooooO;
        this.o0OoOo0 = obtainStyledAttributes.hasValue(R.styleable.MiniRefreshLayout_srlFooterHeight) ? com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO00o.OooO0o : this.o0OoOo0;
        int color = obtainStyledAttributes.getColor(R.styleable.MiniRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.MiniRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.OooOoo = new int[]{color2, color};
            } else {
                this.OooOoo = new int[]{color2};
            }
        } else if (color != 0) {
            this.OooOoo = new int[]{0, color};
        }
        if (this.Oooo0oo && !this.OoooOOo && !this.OooOooo) {
            this.OooOooo = true;
        }
        obtainStyledAttributes.recycle();
    }

    public static void setDefaultRefreshFooterCreator(@NonNull com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO00o oooO00o) {
        o00000O = oooO00o;
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0O0 oooO0O0) {
        o00000OO = oooO0O0;
    }

    public static void setDefaultRefreshInitializer(@NonNull com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0OO oooO0OO) {
        o00000Oo = oooO0OO;
    }

    public ValueAnimator OooO00o(int i11, int i12, Interpolator interpolator, int i13) {
        if (this.OooO0O0 == i11) {
            return null;
        }
        ValueAnimator valueAnimator = this.o00000O0;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.o00000O0.cancel();
            this.o00000O0 = null;
        }
        this.o00000 = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.OooO0O0, i11);
        this.o00000O0 = ofInt;
        ofInt.setDuration(i13);
        this.o00000O0.setInterpolator(interpolator);
        this.o00000O0.addListener(new OooO0o());
        this.o00000O0.addUpdateListener(new OooO());
        this.o00000O0.setStartDelay(i12);
        this.o00000O0.start();
        return this.o00000O0;
    }

    public OooO00o OooO00o(int i11, boolean z10, Boolean bool) {
        int i12 = i11 >> 16;
        int i13 = (i11 << 16) >> 16;
        OooOO0O oooOO0O = new OooOO0O(i12, bool, z10);
        if (i13 > 0) {
            this.o0ooOOo.postDelayed(oooOO0O, i13);
        } else {
            oooOO0O.run();
        }
        return this;
    }

    public OooO00o OooO00o(int i11, boolean z10, boolean z11) {
        int i12 = i11 >> 16;
        int i13 = (i11 << 16) >> 16;
        OooOOO0 oooOOO0 = new OooOOO0(i12, z11, z10);
        if (i13 > 0) {
            this.o0ooOOo.postDelayed(oooOOO0, i13);
        } else {
            oooOOO0.run();
        }
        return this;
    }

    public OooO00o OooO00o(@NonNull com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO oooO) {
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O;
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O2 = this.o00oO0o;
        if (oooOO0O2 != null) {
            removeView(oooOO0O2.getView());
        }
        this.o00oO0o = oooO;
        this.o000000 = false;
        this.o0O0O00 = 0;
        this.OoooOOO = false;
        this.o0OoOo0 = com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO00o.OooO0OO;
        this.OooOooo = !this.OoooOOo || this.OooOooo;
        OooOo00 oooOo00 = new OooOo00(-1, -2);
        ViewGroup.LayoutParams layoutParams = this.o00oO0o.getView().getLayoutParams();
        if (layoutParams instanceof OooOo00) {
            oooOo00 = (OooOo00) layoutParams;
        }
        ViewExtKt.removeSelf(this.o00oO0o.getView());
        if (this.o00oO0o.getSpinnerStyle().OooO0O0) {
            addView(this.o00oO0o.getView(), getChildCount(), oooOo00);
        } else {
            addView(this.o00oO0o.getView(), 0, oooOo00);
        }
        int[] iArr = this.OooOoo;
        if (iArr != null && (oooOO0O = this.o00oO0o) != null) {
            oooOO0O.setPrimaryColors(iArr);
        }
        return this;
    }

    public com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO OooO00o(@NonNull com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0 oooOO0) {
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O;
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O2 = this.oo000o;
        if (oooOO0O2 != null) {
            removeView(oooOO0O2.getView());
        }
        this.oo000o = oooOO0;
        this.oo0o0Oo = 0;
        this.OoooooO = com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO00o.OooO0OO;
        OooOo00 oooOo00 = new OooOo00(-1, -2);
        ViewGroup.LayoutParams layoutParams = this.oo000o.getView().getLayoutParams();
        if (layoutParams instanceof OooOo00) {
            oooOo00 = (OooOo00) layoutParams;
        }
        ViewExtKt.removeSelf(this.oo000o.getView());
        if (this.oo000o.getSpinnerStyle().OooO0O0) {
            addView(this.oo000o.getView(), getChildCount(), oooOo00);
        } else {
            addView(this.oo000o.getView(), 0, oooOo00);
        }
        int[] iArr = this.OooOoo;
        if (iArr != null && (oooOO0O = this.oo000o) != null) {
            oooOO0O.setPrimaryColors(iArr);
        }
        return this;
    }

    public void OooO00o(float f11) {
        MiniRefreshState miniRefreshState;
        if (this.OooooO0 && !this.OoooO0 && f11 < 0.0f && !((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) this.o00oO0O).OooO00o()) {
            f11 = 0.0f;
        }
        if (f11 > this.OooO0oO * 5 && getTag() == null) {
            float f12 = this.OooOO0O;
            float f13 = this.OooO0oO;
            if (f12 < f13 / 6.0f && this.OooOO0 < f13 / 16.0f) {
                setTag("");
            }
        }
        MiniRefreshState miniRefreshState2 = this.o0OOO0o;
        if (miniRefreshState2 == MiniRefreshState.TwoLevel && f11 > 0.0f && this.o00oO0O != null) {
            int measuredHeight = getMeasuredHeight();
            float f14 = this.OooOO0o;
            ((OooOo) this.o0ooOoO).OooO00o(Math.min((int) f11, f14 > 1.0f ? (int) f14 : (int) (measuredHeight * f14)), true);
        } else if (miniRefreshState2 == MiniRefreshState.REFRESHING && f11 >= 0.0f) {
            float f15 = this.Oooooo;
            if (f11 < f15) {
                ((OooOo) this.o0ooOoO).OooO00o((int) f11, true);
            } else {
                float f16 = (this.o00Oo0 - 1.0f) * f15;
                int max = Math.max((this.OooO0oO * 4) / 3, getHeight());
                int i11 = this.Oooooo;
                float f17 = max - i11;
                float max2 = Math.max(0.0f, (f11 - i11) * this.OooOOO);
                float f18 = -max2;
                if (f17 == 0.0f) {
                    f17 = 1.0f;
                }
                ((OooOo) this.o0ooOoO).OooO00o(((int) Math.min((1.0f - ((float) Math.pow(100.0d, f18 / f17))) * f16, max2)) + this.Oooooo, true);
            }
        } else if (f11 < 0.0f && (miniRefreshState2 == MiniRefreshState.LOADING || ((this.Oooo0O0 && this.o000oOoO && this.OoooOOO && OooO00o(this.OooOooo)) || (this.Oooo0oO && !this.o000oOoO && OooO00o(this.OooOooo))))) {
            int i12 = this.Ooooooo;
            if (f11 > (-i12)) {
                ((OooOo) this.o0ooOoO).OooO00o((int) f11, true);
            } else {
                float f19 = (this.o00Ooo - 1.0f) * i12;
                int max3 = Math.max((this.OooO0oO * 4) / 3, getHeight());
                int i13 = this.Ooooooo;
                float f20 = max3 - i13;
                float f21 = -Math.min(0.0f, (i13 + f11) * this.OooOOO);
                float f22 = -f21;
                if (f20 == 0.0f) {
                    f20 = 1.0f;
                }
                ((OooOo) this.o0ooOoO).OooO00o(((int) (-Math.min((1.0f - ((float) Math.pow(100.0d, f22 / f20))) * f19, f21))) - this.Ooooooo, true);
            }
        } else if (f11 >= 0.0f) {
            float f23 = this.o00Oo0 * this.Oooooo;
            float max4 = Math.max(this.OooO0oO / 2, getHeight());
            float max5 = Math.max(0.0f, this.OooOOO * f11);
            float f24 = -max5;
            if (max4 == 0.0f) {
                max4 = 1.0f;
            }
            ((OooOo) this.o0ooOoO).OooO00o((int) Math.min((1.0f - ((float) Math.pow(100.0d, f24 / max4))) * f23, max5), true);
        } else {
            float f25 = this.o00Ooo * this.Ooooooo;
            float max6 = Math.max(this.OooO0oO / 2, getHeight());
            float f26 = -Math.min(0.0f, this.OooOOO * f11);
            float f27 = -f26;
            if (max6 == 0.0f) {
                max6 = 1.0f;
            }
            ((OooOo) this.o0ooOoO).OooO00o((int) (-Math.min((1.0f - ((float) Math.pow(100.0d, f27 / max6))) * f25, f26)), true);
        }
        if (!this.Oooo0oO || this.o000oOoO || !OooO00o(this.OooOooo) || f11 >= 0.0f || (miniRefreshState = this.o0OOO0o) == MiniRefreshState.REFRESHING || miniRefreshState == MiniRefreshState.LOADING || miniRefreshState == MiniRefreshState.LOAD_FINISH) {
            return;
        }
        if (this.OoooOO0) {
            this.o00000 = null;
            ((OooOo) this.o0ooOoO).OooO00o(-this.Ooooooo);
        }
        setStateDirectLoading(false);
        this.o0ooOOo.postDelayed(new OooOO0(), this.OooO0o);
    }

    public void OooO00o(MiniRefreshState miniRefreshState) {
        MiniRefreshState miniRefreshState2 = this.o0OOO0o;
        if (miniRefreshState2 == miniRefreshState) {
            if (this.o0Oo0oo != miniRefreshState2) {
                this.o0Oo0oo = miniRefreshState2;
                return;
            }
            return;
        }
        this.o0OOO0o = miniRefreshState;
        this.o0Oo0oo = miniRefreshState;
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O = this.oo000o;
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O2 = this.o00oO0o;
        if (oooOO0O != null) {
            oooOO0O.OooO00o(this, miniRefreshState2, miniRefreshState);
        }
        if (oooOO0O2 != null) {
            oooOO0O2.OooO00o(this, miniRefreshState2, miniRefreshState);
        }
        if (miniRefreshState == MiniRefreshState.LOAD_FINISH) {
            this.o000000 = false;
        }
    }

    public boolean OooO00o() {
        int i11 = this.o000OOo ? 0 : 400;
        int i12 = this.OooO0o;
        float f11 = (this.o00Oo0 / 2.0f) + 0.5f;
        int i13 = this.Oooooo;
        float f12 = f11 * i13 * 1.0f;
        if (i13 == 0) {
            i13 = 1;
        }
        float f13 = f12 / i13;
        if (this.o0OOO0o != MiniRefreshState.NONE || !OooO00o(this.OooOooO)) {
            return false;
        }
        com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO0O0 oooO0O0 = new com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO0O0(this, f13, i12, false);
        setViceState(MiniRefreshState.REFRESHING);
        if (i11 > 0) {
            this.o0ooOOo.postDelayed(oooO0O0, i11);
        } else {
            oooO0O0.run();
        }
        return true;
    }

    public boolean OooO00o(int i11) {
        if (i11 == 0) {
            if (this.o00000O0 != null) {
                MiniRefreshState miniRefreshState = this.o0OOO0o;
                if (miniRefreshState.isFinishing || miniRefreshState == MiniRefreshState.TWO_LEVEL_RELEASED || miniRefreshState == MiniRefreshState.REFRESH_RELEASED || miniRefreshState == MiniRefreshState.LOAD_RELEASED) {
                    return true;
                }
                if (miniRefreshState == MiniRefreshState.PULL_DOWN_CANCELED) {
                    ((OooOo) this.o0ooOoO).OooO00o(MiniRefreshState.PULL_DOWN_TO_REFRESH);
                } else if (miniRefreshState == MiniRefreshState.PULL_UP_CANCELED) {
                    ((OooOo) this.o0ooOoO).OooO00o(MiniRefreshState.PULL_UP_TO_LOAD);
                }
                this.o00000O0.setDuration(0L);
                this.o00000O0.cancel();
                this.o00000O0 = null;
            }
            this.o00000 = null;
        }
        return this.o00000O0 != null;
    }

    public boolean OooO00o(boolean z10) {
        return z10 && !this.Oooo0oo;
    }

    public boolean OooO00o(boolean z10, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O) {
        return z10 || this.Oooo0oo || oooOO0O == null || oooOO0O.getSpinnerStyle() == com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0o0;
    }

    public OooO00o OooO0O0(boolean z10) {
        MiniRefreshState miniRefreshState = this.o0OOO0o;
        if (miniRefreshState == MiniRefreshState.REFRESHING && z10) {
            OooO00o(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.o0OO00O))), 300) << 16, true, Boolean.TRUE);
        } else if (miniRefreshState == MiniRefreshState.LOADING && z10) {
            OooO00o(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.o0OO00O))), 300) << 16, true, true);
        } else if (this.o000oOoO != z10) {
            this.o000oOoO = z10;
            com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O = this.o00oO0o;
            if (oooOO0O instanceof com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO) {
                if (((com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO) oooOO0O).OooO00o(z10)) {
                    this.OoooOOO = true;
                    if (this.o000oOoO && this.Oooo0O0 && this.OooO0O0 > 0 && this.o00oO0o.getSpinnerStyle() == com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0Oo && OooO00o(this.OooOooo) && OooO00o(this.OooOooO, this.oo000o)) {
                        this.o00oO0o.getView().setTranslationY(this.OooO0O0);
                    }
                } else {
                    this.OoooOOO = false;
                    StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("Footer:");
                    OooO00o.append(this.o00oO0o);
                    OooO00o.append(" NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])");
                    new RuntimeException(OooO00o.toString()).printStackTrace();
                }
            }
        }
        return this;
    }

    public void OooO0O0() {
        MiniRefreshState miniRefreshState = this.o0OOO0o;
        MiniRefreshState miniRefreshState2 = MiniRefreshState.TwoLevel;
        if (miniRefreshState == miniRefreshState2) {
            int measuredHeight = getMeasuredHeight();
            float f11 = this.OooOO0o;
            int i11 = f11 > 1.0f ? (int) f11 : (int) (measuredHeight * f11);
            if (this.OooOoO0 > -1000 && this.OooO0O0 > i11 / 2) {
                ValueAnimator OooO00o = ((OooOo) this.o0ooOoO).OooO00o(i11);
                if (OooO00o != null) {
                    OooO00o.setDuration(this.OooO0o0);
                    return;
                }
                return;
            }
            if (this.OooOOOo) {
                OooOo oooOo = (OooOo) this.o0ooOoO;
                OooO00o oooO00o = OooO00o.this;
                if (oooO00o.o0OOO0o == miniRefreshState2) {
                    ((OooOo) oooO00o.o0ooOoO).OooO00o(MiniRefreshState.TwoLevelFinish);
                    if (OooO00o.this.OooO0O0 != 0) {
                        oooOo.OooO00o(0).setDuration(OooO00o.this.OooO0o0);
                        return;
                    } else {
                        oooOo.OooO00o(0, false);
                        OooO00o.this.OooO00o(MiniRefreshState.NONE);
                        return;
                    }
                }
                return;
            }
            return;
        }
        MiniRefreshState miniRefreshState3 = MiniRefreshState.LOADING;
        if (miniRefreshState == miniRefreshState3 || (this.Oooo0O0 && this.o000oOoO && this.OoooOOO && this.OooO0O0 < 0 && OooO00o(this.OooOooo))) {
            int i12 = this.OooO0O0;
            int i13 = -this.Ooooooo;
            if (i12 < i13) {
                ((OooOo) this.o0ooOoO).OooO00o(i13);
                return;
            } else {
                if (i12 > 0) {
                    ((OooOo) this.o0ooOoO).OooO00o(0);
                    return;
                }
                return;
            }
        }
        MiniRefreshState miniRefreshState4 = this.o0OOO0o;
        MiniRefreshState miniRefreshState5 = MiniRefreshState.REFRESHING;
        if (miniRefreshState4 == miniRefreshState5) {
            int i14 = this.OooO0O0;
            int i15 = this.Oooooo;
            if (i14 > i15) {
                ((OooOo) this.o0ooOoO).OooO00o(i15);
                return;
            } else {
                if (i14 < 0) {
                    ((OooOo) this.o0ooOoO).OooO00o(0);
                    return;
                }
                return;
            }
        }
        if (miniRefreshState4 == MiniRefreshState.PULL_DOWN_TO_REFRESH) {
            ((OooOo) this.o0ooOoO).OooO00o(MiniRefreshState.PULL_DOWN_CANCELED);
            return;
        }
        if (miniRefreshState4 == MiniRefreshState.PULL_UP_TO_LOAD) {
            ((OooOo) this.o0ooOoO).OooO00o(MiniRefreshState.PULL_UP_CANCELED);
            return;
        }
        if (miniRefreshState4 == MiniRefreshState.RELEASE_TO_REFRESH) {
            ((OooOo) this.o0ooOoO).OooO00o(miniRefreshState5);
            return;
        }
        if (miniRefreshState4 == MiniRefreshState.RELEASE_TO_LOAD) {
            ((OooOo) this.o0ooOoO).OooO00o(miniRefreshState3);
            return;
        }
        if (miniRefreshState4 == MiniRefreshState.RELEASE_TO_TWO_LEVEL) {
            ((OooOo) this.o0ooOoO).OooO00o(MiniRefreshState.TWO_LEVEL_RELEASED);
            return;
        }
        if (miniRefreshState4 == MiniRefreshState.REFRESH_RELEASED) {
            if (this.o00000O0 == null) {
                ((OooOo) this.o0ooOoO).OooO00o(this.Oooooo);
            }
        } else if (miniRefreshState4 == MiniRefreshState.LOAD_RELEASED) {
            if (this.o00000O0 == null) {
                ((OooOo) this.o0ooOoO).OooO00o(-this.Ooooooo);
            }
        } else {
            if (miniRefreshState4 == MiniRefreshState.LOAD_FINISH || this.OooO0O0 == 0) {
                return;
            }
            ((OooOo) this.o0ooOoO).OooO00o(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e9, code lost:
    
        if (r4 <= r13.Oooooo) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f0, code lost:
    
        if (r4 >= (-r13.Ooooooo)) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean OooO0O0(float r13) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.OooO0O0(float):boolean");
    }

    @Override // android.view.View
    public void computeScroll() {
        MiniRefreshState miniRefreshState;
        this.OooOoO.getCurrY();
        if (this.OooOoO.computeScrollOffset()) {
            int finalY = this.OooOoO.getFinalY();
            if ((finalY >= 0 || !((this.OooOooO || this.Oooo0o) && ((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) this.o00oO0O).OooO0O0())) && (finalY <= 0 || !((this.OooOooo || this.Oooo0o) && ((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) this.o00oO0O).OooO00o()))) {
                this.o000000O = true;
                invalidate();
                return;
            }
            if (this.o000000O) {
                float currVelocity = finalY > 0 ? -this.OooOoO.getCurrVelocity() : this.OooOoO.getCurrVelocity();
                if (this.o00000O0 == null) {
                    if (currVelocity > 0.0f && ((miniRefreshState = this.o0OOO0o) == MiniRefreshState.REFRESHING || miniRefreshState == MiniRefreshState.TwoLevel)) {
                        this.o00000 = new OooOOO(currVelocity, this.Oooooo);
                    } else if (currVelocity < 0.0f && (this.o0OOO0o == MiniRefreshState.LOADING || ((this.Oooo0O0 && this.o000oOoO && this.OoooOOO && OooO00o(this.OooOooo)) || (this.Oooo0oO && !this.o000oOoO && OooO00o(this.OooOooo) && this.o0OOO0o != MiniRefreshState.REFRESHING)))) {
                        this.o00000 = new OooOOO(currVelocity, -this.Ooooooo);
                    } else if (this.OooO0O0 == 0 && this.Oooo0o0) {
                        this.o00000 = new OooOOO(currVelocity, 0);
                    }
                }
            }
            this.OooOoO.forceFinished(true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e2, code lost:
    
        if (r6 != 3) goto L215;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r22) {
        /*
            Method dump skipped, instructions count: 919
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j11) {
        Paint paint;
        Paint paint2;
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0o oooO0o = this.o00oO0O;
        View view2 = oooO0o != null ? ((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) oooO0o).OooO00o : null;
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O = this.oo000o;
        if (oooOO0O != null && oooOO0O.getView() == view) {
            if (!OooO00o(this.OooOooO) || (!this.Oooo0OO && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getPaddingTop() + view2.getTop() + this.OooO0O0, view.getTop());
                int i11 = this.oo0o0Oo;
                if (i11 != 0 && (paint2 = this.o0ooOO0) != null) {
                    paint2.setColor(i11);
                    if (this.oo000o.getSpinnerStyle().OooO0OO) {
                        max = view.getBottom();
                    } else if (this.oo000o.getSpinnerStyle() == com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0Oo) {
                        max = view.getBottom() + this.OooO0O0;
                    }
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), max, this.o0ooOO0);
                }
                if ((this.Oooo000 && this.oo000o.getSpinnerStyle() == com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0o0) || this.oo000o.getSpinnerStyle().OooO0OO) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j11);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O2 = this.o00oO0o;
        if (oooOO0O2 != null && oooOO0O2.getView() == view) {
            if (!OooO00o(this.OooOooo) || (!this.Oooo0OO && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.OooO0O0, view.getBottom());
                int i12 = this.o0O0O00;
                if (i12 != 0 && (paint = this.o0ooOO0) != null) {
                    paint.setColor(i12);
                    if (this.o00oO0o.getSpinnerStyle().OooO0OO) {
                        min = view.getTop();
                    } else if (this.o00oO0o.getSpinnerStyle() == com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0Oo) {
                        min = view.getTop() + this.OooO0O0;
                    }
                    canvas.drawRect(0.0f, min, getWidth(), view.getBottom(), this.o0ooOO0);
                }
                if ((this.Oooo00O && this.o00oO0o.getSpinnerStyle() == com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0o0) || this.o00oO0o.getSpinnerStyle().OooO0OO) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j11);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j11);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new OooOo00(getContext(), attributeSet);
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO
    @NonNull
    public ViewGroup getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.Oooooo0.getNestedScrollAxes();
    }

    @Nullable
    public com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO getRefreshFooter() {
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O = this.o00oO0o;
        if (oooOO0O instanceof com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO) {
            return (com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO) oooOO0O;
        }
        return null;
    }

    @Nullable
    public com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0 getRefreshHeader() {
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O = this.oo000o;
        if (oooOO0O instanceof com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0) {
            return (com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0) oooOO0O;
        }
        return null;
    }

    @NonNull
    public MiniRefreshState getState() {
        return this.o0OOO0o;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.OoooO0O && (this.Oooo0o || this.OooOooO || this.OooOooo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O;
        super.onAttachedToWindow();
        boolean z10 = true;
        this.o000OOo = true;
        if (!isInEditMode()) {
            if (this.oo000o == null) {
                com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0O0 oooO0O0 = o00000OO;
                if (oooO0O0 != null) {
                    com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0 OooO00o = oooO0O0.OooO00o(getContext(), this);
                    if (OooO00o == null) {
                        throw new RuntimeException("DefaultRefreshHeaderCreator can not return null");
                    }
                    OooO00o(OooO00o);
                } else {
                    OooO00o(new com.cloud.tmc.miniapp.widget.pulldownrefresh.header.OooO00o(getContext(), null));
                }
            }
            if (this.o00oO0o == null) {
                com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO00o oooO00o = o00000O;
                if (oooO00o != null) {
                    com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO OooO00o2 = oooO00o.OooO00o(getContext(), this);
                    if (OooO00o2 == null) {
                        throw new RuntimeException("DefaultRefreshFooterCreator can not return null");
                    }
                    OooO00o(OooO00o2);
                } else {
                    boolean z11 = this.OooOooo;
                    OooO00o(new com.cloud.tmc.miniapp.widget.pulldownrefresh.footer.OooO00o(getContext(), null));
                    this.OooOooo = z11;
                }
            } else {
                if (!this.OooOooo && this.OoooOOo) {
                    z10 = false;
                }
                this.OooOooo = z10;
            }
            if (this.o00oO0O == null) {
                int childCount = getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = getChildAt(i11);
                    com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O2 = this.oo000o;
                    if ((oooOO0O2 == null || childAt != oooOO0O2.getView()) && ((oooOO0O = this.o00oO0o) == null || childAt != oooOO0O.getView())) {
                        this.o00oO0O = new com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o(childAt);
                    }
                }
            }
            if (this.o00oO0O == null) {
                int OooO00o3 = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                ViewExtKt.removeSelf(textView);
                addView(textView, 0, new OooOo00(-1, -1));
                com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o oooO00o2 = new com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o(textView);
                this.o00oO0O = oooO00o2;
                oooO00o2.OooO00o.setPadding(OooO00o3, OooO00o3, OooO00o3, OooO00o3);
            }
            View findViewById = findViewById(this.OooOOoo);
            View findViewById2 = findViewById(this.OooOo00);
            com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o oooO00o3 = (com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) this.o00oO0O;
            oooO00o3.getClass();
            oooO00o3.OooO.OooO0O0 = null;
            com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o oooO00o4 = (com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) this.o00oO0O;
            oooO00o4.OooO.OooO0OO = this.OoooO0;
            oooO00o4.OooO00o(this.o0ooOoO, findViewById, findViewById2);
            if (this.OooO0O0 != 0) {
                OooO00o(MiniRefreshState.NONE);
                com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0o oooO0o = this.o00oO0O;
                this.OooO0O0 = 0;
                ((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) oooO0o).OooO00o(0, this.OooOo0, this.OooOo0O);
            }
        }
        int[] iArr = this.OooOoo;
        if (iArr != null) {
            com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O3 = this.oo000o;
            if (oooOO0O3 != null) {
                oooOO0O3.setPrimaryColors(iArr);
            }
            com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O4 = this.o00oO0o;
            if (oooOO0O4 != null) {
                oooOO0O4.setPrimaryColors(this.OooOoo);
            }
        }
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0o oooO0o2 = this.o00oO0O;
        if (oooO0o2 != null) {
            bringChildToFront(((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) oooO0o2).OooO00o);
        }
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O5 = this.oo000o;
        if (oooOO0O5 != null && oooOO0O5.getSpinnerStyle().OooO0O0) {
            bringChildToFront(this.oo000o.getView());
        }
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O6 = this.o00oO0o;
        if (oooOO0O6 == null || !oooOO0O6.getSpinnerStyle().OooO0O0) {
            return;
        }
        bringChildToFront(this.o00oO0o.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.o000OOo = false;
        this.OoooOOo = true;
        this.o00000 = null;
        ValueAnimator valueAnimator = this.o00000O0;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.o00000O0.removeAllUpdateListeners();
            this.o00000O0.setDuration(0L);
            this.o00000O0.cancel();
            this.o00000O0 = null;
        }
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O = this.oo000o;
        if (oooOO0O != null && this.o0OOO0o == MiniRefreshState.REFRESHING) {
            oooOO0O.OooO00o(this, false);
        }
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O2 = this.o00oO0o;
        if (oooOO0O2 != null && this.o0OOO0o == MiniRefreshState.LOADING) {
            oooOO0O2.OooO00o(this, false);
        }
        if (this.OooO0O0 != 0) {
            ((OooOo) this.o0ooOoO).OooO00o(0, true);
        }
        MiniRefreshState miniRefreshState = this.o0OOO0o;
        MiniRefreshState miniRefreshState2 = MiniRefreshState.NONE;
        if (miniRefreshState != miniRefreshState2) {
            OooO00o(miniRefreshState2);
        }
        Handler handler = this.o0ooOOo;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.o000000 = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onFinishInflate() {
        /*
            r11 = this;
            super.onFinishInflate()
            int r0 = r11.getChildCount()
            r1 = 3
            if (r0 > r1) goto L9e
            r2 = -1
            r3 = 0
            r5 = r2
            r4 = r3
            r6 = r4
        Lf:
            r7 = 2
            r8 = 1
            if (r4 >= r0) goto L33
            android.view.View r9 = r11.getChildAt(r4)
            boolean r10 = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(r9)
            if (r10 == 0) goto L24
            if (r6 < r7) goto L21
            if (r4 != r8) goto L24
        L21:
            r5 = r4
            r6 = r7
            goto L30
        L24:
            boolean r7 = r9 instanceof com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
            if (r7 != 0) goto L30
            if (r6 >= r8) goto L30
            if (r4 <= 0) goto L2e
            r6 = r8
            goto L2f
        L2e:
            r6 = r3
        L2f:
            r5 = r4
        L30:
            int r4 = r4 + 1
            goto Lf
        L33:
            if (r5 < 0) goto L4d
            com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o r4 = new com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o
            android.view.View r6 = r11.getChildAt(r5)
            r4.<init>(r6)
            r11.o00oO0O = r4
            if (r5 != r8) goto L48
            if (r0 != r1) goto L46
        L44:
            r1 = r3
            goto L4f
        L46:
            r7 = r2
            goto L44
        L48:
            if (r0 != r7) goto L4d
            r1 = r2
            r7 = r8
            goto L4f
        L4d:
            r1 = r2
            r7 = r1
        L4f:
            r4 = r3
        L50:
            if (r4 >= r0) goto L9d
            android.view.View r5 = r11.getChildAt(r4)
            if (r4 == r1) goto L8b
            if (r4 == r7) goto L65
            if (r1 != r2) goto L65
            com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O r6 = r11.oo000o
            if (r6 != 0) goto L65
            boolean r6 = r5 instanceof com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0
            if (r6 == 0) goto L65
            goto L8b
        L65:
            if (r4 == r7) goto L6d
            if (r7 != r2) goto L9a
            boolean r6 = r5 instanceof com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO
            if (r6 == 0) goto L9a
        L6d:
            boolean r6 = r11.OooOooo
            if (r6 != 0) goto L78
            boolean r6 = r11.OoooOOo
            if (r6 != 0) goto L76
            goto L78
        L76:
            r6 = r3
            goto L79
        L78:
            r6 = r8
        L79:
            r11.OooOooo = r6
            boolean r6 = r5 instanceof com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO
            if (r6 == 0) goto L82
            com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO r5 = (com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO) r5
            goto L88
        L82:
            com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO0O0 r6 = new com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO0O0
            r6.<init>(r5)
            r5 = r6
        L88:
            r11.o00oO0o = r5
            goto L9a
        L8b:
            boolean r6 = r5 instanceof com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0
            if (r6 == 0) goto L92
            com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0 r5 = (com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0) r5
            goto L98
        L92:
            com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO0OO r6 = new com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO0OO
            r6.<init>(r5)
            r5 = r6
        L98:
            r11.oo000o = r5
        L9a:
            int r4 = r4 + 1
            goto L50
        L9d:
            return
        L9e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "最多只支持3个子View，Most only support three sub view"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.onFinishInflate():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        int i15;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8 && childAt.getTag(R.string.srl_component_falsify) != childAt) {
                com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0o oooO0o = this.o00oO0O;
                if (oooO0o != null && ((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) oooO0o).OooO00o == childAt) {
                    boolean z11 = isInEditMode() && this.Oooo0OO && OooO00o(this.OooOooO) && this.oo000o != null;
                    View view = ((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) this.o00oO0O).OooO00o;
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : o00000o0;
                    int i17 = marginLayoutParams.leftMargin + paddingLeft;
                    int i18 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i17;
                    int measuredHeight = view.getMeasuredHeight() + i18;
                    if (z11 && OooO00o(this.Oooo00o, this.oo000o)) {
                        int i19 = this.Oooooo;
                        i18 += i19;
                        measuredHeight += i19;
                    }
                    view.layout(i17, i18, measuredWidth, measuredHeight);
                }
                com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O = this.oo000o;
                if (oooOO0O != null && oooOO0O.getView() == childAt) {
                    boolean z12 = isInEditMode() && this.Oooo0OO && OooO00o(this.OooOooO);
                    View view2 = this.oo000o.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : o00000o0;
                    int i20 = marginLayoutParams2.leftMargin;
                    int i21 = marginLayoutParams2.topMargin + this.ooOO;
                    int measuredWidth2 = view2.getMeasuredWidth() + i20;
                    int measuredHeight2 = view2.getMeasuredHeight() + i21;
                    if (!z12 && this.oo000o.getSpinnerStyle() == com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0Oo) {
                        int i22 = this.Oooooo;
                        i21 -= i22;
                        measuredHeight2 -= i22;
                    }
                    view2.layout(i20, i21, measuredWidth2, measuredHeight2);
                }
                com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O2 = this.o00oO0o;
                if (oooOO0O2 != null && oooOO0O2.getView() == childAt) {
                    boolean z13 = isInEditMode() && this.Oooo0OO && OooO00o(this.OooOooo);
                    View view3 = this.o00oO0o.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : o00000o0;
                    com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0 spinnerStyle = this.o00oO0o.getSpinnerStyle();
                    int i23 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (getMeasuredHeight() + marginLayoutParams3.topMargin) - this.o00O0O;
                    if (this.o000oOoO && this.OoooOOO && this.Oooo0O0 && this.o00oO0O != null && this.o00oO0o.getSpinnerStyle() == com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0Oo && OooO00o(this.OooOooo)) {
                        View view4 = ((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) this.o00oO0O).OooO00o;
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0oO) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.o00O0O;
                    } else {
                        if (z13 || spinnerStyle == com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0o || spinnerStyle == com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0o0) {
                            i15 = this.Ooooooo;
                        } else if (spinnerStyle.OooO0OO && this.OooO0O0 < 0) {
                            i15 = Math.max(OooO00o(this.OooOooo) ? -this.OooO0O0 : 0, 0);
                        }
                        measuredHeight3 -= i15;
                    }
                    view3.layout(i23, measuredHeight3, view3.getMeasuredWidth() + i23, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0211  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f11, float f12, boolean z10) {
        return this.OooooOo.dispatchNestedFling(f11, f12, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f11, float f12) {
        return (this.o000000 && f12 > 0.0f) || OooO0O0(-f12) || this.OooooOo.dispatchNestedPreFling(f11, f12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i11, int i12, @NonNull int[] iArr) {
        int i13 = this.Ooooo0o;
        int i14 = 0;
        if (i12 * i13 > 0) {
            if (Math.abs(i12) > Math.abs(this.Ooooo0o)) {
                int i15 = this.Ooooo0o;
                this.Ooooo0o = 0;
                i14 = i15;
            } else {
                this.Ooooo0o -= i12;
                i14 = i12;
            }
            OooO00o(this.Ooooo0o);
        } else if (i12 > 0 && this.o000000) {
            int i16 = i13 - i12;
            this.Ooooo0o = i16;
            OooO00o(i16);
            i14 = i12;
        }
        this.OooooOo.dispatchNestedPreScroll(i11, i12 - i14, iArr, null);
        iArr[1] = iArr[1] + i14;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14) {
        boolean dispatchNestedScroll = this.OooooOo.dispatchNestedScroll(i11, i12, i13, i14, this.OooooOO);
        int i15 = i14 + this.OooooOO[1];
        if ((i15 < 0 && (this.OooOooO || this.Oooo0o)) || (i15 > 0 && (this.OooOooo || this.Oooo0o))) {
            MiniRefreshState miniRefreshState = this.o0Oo0oo;
            if (miniRefreshState == MiniRefreshState.NONE || miniRefreshState.isOpening) {
                ((OooOo) this.o0ooOoO).OooO00o(i15 > 0 ? MiniRefreshState.PULL_UP_TO_LOAD : MiniRefreshState.PULL_DOWN_TO_REFRESH);
                if (!dispatchNestedScroll) {
                    ViewParent parent = getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            int i16 = this.Ooooo0o - i15;
            this.Ooooo0o = i16;
            OooO00o(i16);
        }
        if (!this.o000000 || i12 >= 0) {
            return;
        }
        this.o000000 = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i11) {
        this.Oooooo0.onNestedScrollAccepted(view, view2, i11);
        this.OooooOo.startNestedScroll(i11 & 2);
        this.Ooooo0o = this.OooO0O0;
        this.OooooO0 = true;
        OooO00o(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i11) {
        return isEnabled() && isNestedScrollingEnabled() && (i11 & 2) != 0 && (this.Oooo0o || this.OooOooO || this.OooOooo);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.Oooooo0.onStopNestedScroll(view);
        this.OooooO0 = false;
        this.Ooooo0o = 0;
        OooO0O0();
        this.OooooOo.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (ViewCompat.isNestedScrollingEnabled(((com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) this.o00oO0O).OooO0OO)) {
            this.OooOOo = z10;
            super.requestDisallowInterceptTouchEvent(z10);
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.OoooO0O = z10;
        this.OooooOo.setNestedScrollingEnabled(z10);
    }

    public void setStateDirectLoading(boolean z10) {
        MiniRefreshState miniRefreshState = this.o0OOO0o;
        MiniRefreshState miniRefreshState2 = MiniRefreshState.LOADING;
        if (miniRefreshState != miniRefreshState2) {
            this.o0OO00O = System.currentTimeMillis();
            this.o000000 = true;
            OooO00o(miniRefreshState2);
            com.cloud.tmc.miniapp.widget.pulldownrefresh.listener.OooO0O0 oooO0O0 = this.Ooooo00;
            if (oooO0O0 == null) {
                OooO00o(2000, true, false);
            } else if (z10) {
                oooO0O0.OooO00o(this);
            }
            com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O = this.o00oO0o;
            if (oooOO0O != null) {
                int i11 = this.Ooooooo;
                oooOO0O.OooO0O0(this, i11, (int) (this.o00Ooo * i11));
            }
        }
    }

    public void setStateLoading(boolean z10) {
        OooO0O0 oooO0O0 = new OooO0O0(z10);
        OooO00o(MiniRefreshState.LOAD_RELEASED);
        ValueAnimator OooO00o = ((OooOo) this.o0ooOoO).OooO00o(-this.Ooooooo);
        if (OooO00o != null) {
            OooO00o.addListener(oooO0O0);
        }
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O = this.o00oO0o;
        if (oooOO0O != null) {
            int i11 = this.Ooooooo;
            oooOO0O.OooO00o(this, i11, (int) (this.o00Ooo * i11));
        }
        if (OooO00o == null) {
            oooO0O0.onAnimationEnd(null);
        }
    }

    public void setStateRefreshing(boolean z10) {
        OooO0OO oooO0OO = new OooO0OO(z10);
        OooO00o(MiniRefreshState.REFRESH_RELEASED);
        ValueAnimator OooO00o = ((OooOo) this.o0ooOoO).OooO00o(this.Oooooo);
        if (OooO00o != null) {
            OooO00o.addListener(oooO0OO);
        }
        com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O oooOO0O = this.oo000o;
        if (oooOO0O != null) {
            int i11 = this.Oooooo;
            oooOO0O.OooO00o(this, i11, (int) (this.o00Oo0 * i11));
        }
        if (OooO00o == null) {
            oooO0OO.onAnimationEnd(null);
        }
    }

    public void setViceState(MiniRefreshState miniRefreshState) {
        MiniRefreshState miniRefreshState2 = this.o0OOO0o;
        if (miniRefreshState2.isDragging && miniRefreshState2.isHeader != miniRefreshState.isHeader) {
            OooO00o(MiniRefreshState.NONE);
        }
        if (this.o0Oo0oo != miniRefreshState) {
            this.o0Oo0oo = miniRefreshState;
        }
    }
}
