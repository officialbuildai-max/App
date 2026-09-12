package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBGradientAndShadowTextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: classes5.dex */
public class MBAcquireRewardPopView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private final String f34736a;

    /* renamed from: b, reason: collision with root package name */
    private AcquireRewardPopViewParameters f34737b;

    /* renamed from: c, reason: collision with root package name */
    private AnimationSet f34738c;

    /* renamed from: d, reason: collision with root package name */
    private float f34739d;

    /* renamed from: e, reason: collision with root package name */
    private float f34740e;

    /* renamed from: f, reason: collision with root package name */
    private float f34741f;

    /* renamed from: g, reason: collision with root package name */
    private float f34742g;

    /* renamed from: h, reason: collision with root package name */
    private int f34743h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f34744i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f34745j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f34746k;

    /* renamed from: l, reason: collision with root package name */
    private final View.OnClickListener f34747l;

    /* renamed from: m, reason: collision with root package name */
    private Runnable f34748m;

    /* renamed from: n, reason: collision with root package name */
    private Runnable f34749n;

    /* renamed from: o, reason: collision with root package name */
    private View.OnTouchListener f34750o;

    /* renamed from: p, reason: collision with root package name */
    private final View.OnClickListener f34751p;

    /* renamed from: q, reason: collision with root package name */
    private final View.OnClickListener f34752q;

    public MBAcquireRewardPopView(Context context) {
        super(context);
        this.f34736a = "MBAcquireRewardPopView";
        this.f34739d = 0.0f;
        this.f34740e = 0.0f;
        this.f34741f = 0.0f;
        this.f34742g = 0.0f;
        this.f34747l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f34748m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean contains = MBAcquireRewardPopView.this.f34737b.rightAnswerList.contains(str);
                View rightAnswerView = contains ? MBAcquireRewardPopView.this.getRightAnswerView() : MBAcquireRewardPopView.this.getWrongAnswerView();
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                }
                if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                    if (contains) {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f34737b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f34749n, 2000L);
            }
        };
        this.f34748m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MBAcquireRewardPopView.this.f34743h > 0) {
                    MBAcquireRewardPopView.n(MBAcquireRewardPopView.this);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.f34748m, 1000L);
                } else {
                    if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.f34744i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.f34749n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.f34744i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.f34750o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.f34739d = motionEvent.getX();
                    MBAcquireRewardPopView.this.f34740e = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        MBAcquireRewardPopView.this.f34741f = motionEvent.getX();
                        MBAcquireRewardPopView.this.f34742g = motionEvent.getY();
                    }
                } else if (MBAcquireRewardPopView.this.f34741f <= MBAcquireRewardPopView.this.f34739d) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f34739d, MBAcquireRewardPopView.this.f34740e);
                } else if (Math.abs(MBAcquireRewardPopView.this.f34741f - MBAcquireRewardPopView.this.f34739d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.f34742g - MBAcquireRewardPopView.this.f34740e) >= 100.0f) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f34739d, MBAcquireRewardPopView.this.f34740e);
                } else {
                    if (MBAcquireRewardPopView.this.f34745j) {
                        return false;
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f34748m);
                    MBAcquireRewardPopView.this.f34745j = true;
                    View rightAnswerView = MBAcquireRewardPopView.this.getRightAnswerView();
                    View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                    if (childAt != null) {
                        MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                    }
                    if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f34737b.reduceTime);
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f34749n, 2000L);
                }
                return false;
            }
        };
        this.f34751p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f34739d, MBAcquireRewardPopView.this.f34740e);
                }
            }
        };
        this.f34752q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.f34744i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34736a = "MBAcquireRewardPopView";
        this.f34739d = 0.0f;
        this.f34740e = 0.0f;
        this.f34741f = 0.0f;
        this.f34742g = 0.0f;
        this.f34747l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f34748m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean contains = MBAcquireRewardPopView.this.f34737b.rightAnswerList.contains(str);
                View rightAnswerView = contains ? MBAcquireRewardPopView.this.getRightAnswerView() : MBAcquireRewardPopView.this.getWrongAnswerView();
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                }
                if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                    if (contains) {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f34737b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f34749n, 2000L);
            }
        };
        this.f34748m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MBAcquireRewardPopView.this.f34743h > 0) {
                    MBAcquireRewardPopView.n(MBAcquireRewardPopView.this);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.f34748m, 1000L);
                } else {
                    if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.f34744i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.f34749n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.f34744i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.f34750o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.f34739d = motionEvent.getX();
                    MBAcquireRewardPopView.this.f34740e = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        MBAcquireRewardPopView.this.f34741f = motionEvent.getX();
                        MBAcquireRewardPopView.this.f34742g = motionEvent.getY();
                    }
                } else if (MBAcquireRewardPopView.this.f34741f <= MBAcquireRewardPopView.this.f34739d) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f34739d, MBAcquireRewardPopView.this.f34740e);
                } else if (Math.abs(MBAcquireRewardPopView.this.f34741f - MBAcquireRewardPopView.this.f34739d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.f34742g - MBAcquireRewardPopView.this.f34740e) >= 100.0f) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f34739d, MBAcquireRewardPopView.this.f34740e);
                } else {
                    if (MBAcquireRewardPopView.this.f34745j) {
                        return false;
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f34748m);
                    MBAcquireRewardPopView.this.f34745j = true;
                    View rightAnswerView = MBAcquireRewardPopView.this.getRightAnswerView();
                    View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                    if (childAt != null) {
                        MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                    }
                    if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f34737b.reduceTime);
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f34749n, 2000L);
                }
                return false;
            }
        };
        this.f34751p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f34739d, MBAcquireRewardPopView.this.f34740e);
                }
            }
        };
        this.f34752q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.f34744i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f34736a = "MBAcquireRewardPopView";
        this.f34739d = 0.0f;
        this.f34740e = 0.0f;
        this.f34741f = 0.0f;
        this.f34742g = 0.0f;
        this.f34747l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f34748m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean contains = MBAcquireRewardPopView.this.f34737b.rightAnswerList.contains(str);
                View rightAnswerView = contains ? MBAcquireRewardPopView.this.getRightAnswerView() : MBAcquireRewardPopView.this.getWrongAnswerView();
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                }
                if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                    if (contains) {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f34737b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f34749n, 2000L);
            }
        };
        this.f34748m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MBAcquireRewardPopView.this.f34743h > 0) {
                    MBAcquireRewardPopView.n(MBAcquireRewardPopView.this);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.f34748m, 1000L);
                } else {
                    if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.f34744i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.f34749n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.f34744i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.f34750o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.f34739d = motionEvent.getX();
                    MBAcquireRewardPopView.this.f34740e = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        MBAcquireRewardPopView.this.f34741f = motionEvent.getX();
                        MBAcquireRewardPopView.this.f34742g = motionEvent.getY();
                    }
                } else if (MBAcquireRewardPopView.this.f34741f <= MBAcquireRewardPopView.this.f34739d) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f34739d, MBAcquireRewardPopView.this.f34740e);
                } else if (Math.abs(MBAcquireRewardPopView.this.f34741f - MBAcquireRewardPopView.this.f34739d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.f34742g - MBAcquireRewardPopView.this.f34740e) >= 100.0f) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f34739d, MBAcquireRewardPopView.this.f34740e);
                } else {
                    if (MBAcquireRewardPopView.this.f34745j) {
                        return false;
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f34748m);
                    MBAcquireRewardPopView.this.f34745j = true;
                    View rightAnswerView = MBAcquireRewardPopView.this.getRightAnswerView();
                    View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                    if (childAt != null) {
                        MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                    }
                    if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f34737b.reduceTime);
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f34749n, 2000L);
                }
                return false;
            }
        };
        this.f34751p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f34739d, MBAcquireRewardPopView.this.f34740e);
                }
            }
        };
        this.f34752q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.f34744i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    public MBAcquireRewardPopView(Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f34736a = "MBAcquireRewardPopView";
        this.f34739d = 0.0f;
        this.f34740e = 0.0f;
        this.f34741f = 0.0f;
        this.f34742g = 0.0f;
        this.f34747l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f34748m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean contains = MBAcquireRewardPopView.this.f34737b.rightAnswerList.contains(str);
                View rightAnswerView = contains ? MBAcquireRewardPopView.this.getRightAnswerView() : MBAcquireRewardPopView.this.getWrongAnswerView();
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                }
                if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                    if (contains) {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f34737b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f34749n, 2000L);
            }
        };
        this.f34748m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MBAcquireRewardPopView.this.f34743h > 0) {
                    MBAcquireRewardPopView.n(MBAcquireRewardPopView.this);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.f34748m, 1000L);
                } else {
                    if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.f34744i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.f34749n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.f34744i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.f34750o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.f34739d = motionEvent.getX();
                    MBAcquireRewardPopView.this.f34740e = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        MBAcquireRewardPopView.this.f34741f = motionEvent.getX();
                        MBAcquireRewardPopView.this.f34742g = motionEvent.getY();
                    }
                } else if (MBAcquireRewardPopView.this.f34741f <= MBAcquireRewardPopView.this.f34739d) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f34739d, MBAcquireRewardPopView.this.f34740e);
                } else if (Math.abs(MBAcquireRewardPopView.this.f34741f - MBAcquireRewardPopView.this.f34739d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.f34742g - MBAcquireRewardPopView.this.f34740e) >= 100.0f) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f34739d, MBAcquireRewardPopView.this.f34740e);
                } else {
                    if (MBAcquireRewardPopView.this.f34745j) {
                        return false;
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f34748m);
                    MBAcquireRewardPopView.this.f34745j = true;
                    View rightAnswerView = MBAcquireRewardPopView.this.getRightAnswerView();
                    View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                    if (childAt != null) {
                        MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                    }
                    if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f34737b.reduceTime);
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f34749n, 2000L);
                }
                return false;
            }
        };
        this.f34751p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f34739d, MBAcquireRewardPopView.this.f34740e);
                }
            }
        };
        this.f34752q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f34737b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f34737b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.f34744i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    private GradientDrawable a(int i11, int i12) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i11);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(i12);
        return gradientDrawable;
    }

    private GradientDrawable a(int[] iArr, GradientDrawable.Orientation orientation) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(iArr);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(orientation);
        gradientDrawable.setShape(0);
        return gradientDrawable;
    }

    private LayerDrawable a(int i11, int i12, int i13, int i14) {
        int[] iArr = {i11, i12};
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        GradientDrawable a11 = a(iArr, orientation);
        a11.setCornerRadius(t0.a(getContext(), 12.0f));
        GradientDrawable a12 = a(new int[]{i13, i14}, orientation);
        a12.setCornerRadius(t0.a(getContext(), 12.0f));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{a11, a12});
        layerDrawable.setLayerInset(1, 5, 5, 5, 5);
        return layerDrawable;
    }

    private View a(ArrayList<String> arrayList) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 290.0f), -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f34737b;
        linearLayout.setBackground(a(acquireRewardPopViewParameters.viewBackLayerTopColor, acquireRewardPopViewParameters.viewBackLayerBottomColor, acquireRewardPopViewParameters.viewForegroundTopColor, acquireRewardPopViewParameters.viewForegroundBottomColor));
        ImageView imageView = new ImageView(getContext());
        int a11 = t0.a(getContext(), 20.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a11, a11);
        layoutParams2.gravity = GravityCompat.END;
        layoutParams2.setMargins(0, 13, 13, 0);
        imageView.setLayoutParams(layoutParams2);
        imageView.setImageResource(getResources().getIdentifier("mbridge_reward_popview_close", "drawable", c.m().h()));
        imageView.setOnClickListener(this.f34752q);
        linearLayout.addView(imageView);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        int a12 = t0.a(getContext(), 18.0f);
        layoutParams3.setMargins(a12, 5, a12, t0.a(getContext(), 12.0f));
        textView.setLayoutParams(layoutParams3);
        textView.setText(this.f34737b.title);
        textView.setTextColor(this.f34737b.titleTextColor);
        textView.setTextSize(18.0f);
        textView.setGravity(17);
        linearLayout.addView(textView);
        if (arrayList != null && arrayList.size() > 1) {
            int a13 = t0.a(getContext(), 8.0f);
            int a14 = t0.a(getContext(), 24.0f);
            int a15 = t0.a(getContext(), 30.0f);
            int a16 = t0.a(getContext(), 12.0f);
            int a17 = t0.a(getContext(), 40.0f);
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                boolean contains = this.f34737b.rightAnswerList.contains(arrayList.get(i11));
                TextView textView2 = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.gravity = 1;
                layoutParams4.setMargins(a15, a16, a15, 0);
                textView2.setPadding(a14, a13, a14, a13);
                textView2.setLayoutParams(layoutParams4);
                textView2.setText(arrayList.get(i11));
                textView2.setSingleLine(true);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setTag(arrayList.get(i11));
                textView2.setTextSize(17.0f);
                textView2.setGravity(17);
                textView2.setTextColor(contains ? this.f34737b.buttonTextLightColor : this.f34737b.buttonTextDarkColor);
                textView2.setBackground(a(contains ? this.f34737b.buttonBackgroundLightColor : this.f34737b.buttonBackgroundDarkColor, a17));
                textView2.setOnClickListener(this.f34747l);
                linearLayout.addView(textView2);
            }
        }
        this.f34746k = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        int a18 = t0.a(getContext(), 16.0f);
        int a19 = t0.a(getContext(), 18.0f);
        layoutParams5.setMargins(a19, a18, a19, a18);
        layoutParams5.gravity = 1;
        this.f34746k.setLayoutParams(layoutParams5);
        TextView textView3 = this.f34746k;
        AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f34737b;
        textView3.setText(String.format(acquireRewardPopViewParameters2.tips, Integer.valueOf(acquireRewardPopViewParameters2.reduceTime)));
        this.f34746k.setTextColor(this.f34737b.tipTextColor);
        this.f34746k.setGravity(17);
        this.f34746k.setTextSize(12.0f);
        linearLayout.addView(this.f34746k);
        return linearLayout;
    }

    private ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f34737b;
        if (acquireRewardPopViewParameters != null) {
            List<String> list = acquireRewardPopViewParameters.rightAnswerList;
            if (list != null) {
                arrayList.addAll(list);
            }
            if (this.f34737b.wrongAnswerList != null) {
                int nextInt = new Random().nextInt(this.f34737b.wrongAnswerList.size());
                if (nextInt > this.f34737b.wrongAnswerList.size() - 1) {
                    nextInt = 0;
                }
                arrayList.add(this.f34737b.wrongAnswerList.get(nextInt));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.8f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(1000L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        AnimationSet animationSet = new AnimationSet(true);
        this.f34738c = animationSet;
        animationSet.addAnimation(translateAnimation);
        this.f34738c.addAnimation(alphaAnimation);
        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(1000L);
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(MBAcquireRewardPopView.this.f34738c);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f34738c.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(alphaAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(this.f34738c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, View view2) {
        removeView(view);
        addView(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getRightAnswerView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f34737b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.successTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.successTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.successTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, t0.a(getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f34737b;
        int i11 = acquireRewardPopViewParameters2.viewType;
        String str = i11 == 1 ? acquireRewardPopViewParameters2.successTitle : i11 == 2 ? acquireRewardPopViewParameters2.slideSuccessTitle : "";
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setText(String.format(" %s ", str));
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable a11 = a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(this.f34737b.successTipTextColor);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = this.f34737b;
        textView.setText(String.format(acquireRewardPopViewParameters3.successTip, Integer.valueOf(acquireRewardPopViewParameters3.reduceTime)));
        int a12 = t0.a(getContext(), 6.0f);
        int a13 = t0.a(getContext(), 32.0f);
        textView.setPadding(a13, a12, a13, a12);
        textView.setBackground(a11);
        linearLayout.addView(textView);
        return linearLayout;
    }

    private View getSlidePopView() {
        int a11 = t0.a(getContext(), 290.0f);
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a11, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f34737b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.successTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.successTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.successTitleShadowColor;
        gradientAndShadowParameters.textSize = 30;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, t0.a(getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        mBGradientAndShadowTextView.setText(String.format(" %s ", this.f34737b.slideTitle));
        mBGradientAndShadowTextView.setGravity(17);
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable a12 = a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
        this.f34746k = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        layoutParams3.setMargins(0, 0, 0, t0.a(getContext(), 25.0f));
        this.f34746k.setLayoutParams(layoutParams3);
        this.f34746k.setTextSize(12.0f);
        this.f34746k.setGravity(17);
        this.f34746k.setTextColor(this.f34737b.successTipTextColor);
        TextView textView = this.f34746k;
        AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f34737b;
        textView.setText(String.format(acquireRewardPopViewParameters2.slideTip, Integer.valueOf(acquireRewardPopViewParameters2.reduceTime)));
        int a13 = t0.a(getContext(), 6.0f);
        int a14 = t0.a(getContext(), 32.0f);
        this.f34746k.setPadding(a14, a13, a14, a13);
        this.f34746k.setBackground(a12);
        linearLayout.addView(this.f34746k);
        View imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 1;
        imageView.setLayoutParams(layoutParams4);
        imageView.setBackgroundResource(getResources().getIdentifier("mbridge_slide_rightarrow", "drawable", c.m().h()));
        linearLayout.addView(imageView);
        View imageView2 = new ImageView(getContext());
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView2.setBackgroundResource(getResources().getIdentifier("mbridge_slide_hand", "drawable", c.m().h()));
        linearLayout.addView(imageView2);
        imageView2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                MBAcquireRewardPopView.this.a(view);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (MBAcquireRewardPopView.this.f34738c != null) {
                    MBAcquireRewardPopView.this.f34738c.cancel();
                }
            }
        });
        linearLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                MBAcquireRewardPopView.this.setLongClickable(true);
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.setOnTouchListener(mBAcquireRewardPopView.f34750o);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getWrongAnswerView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f34737b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.failTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.failTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.failTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, t0.a(getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        mBGradientAndShadowTextView.setText(String.format(" %s ", this.f34737b.failTitle));
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable a11 = a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(this.f34737b.failTipTextColor);
        textView.setText(String.format(this.f34737b.failTip, ""));
        int a12 = t0.a(getContext(), 6.0f);
        int a13 = t0.a(getContext(), 32.0f);
        textView.setPadding(a13, a12, a13, a12);
        textView.setBackground(a11);
        linearLayout.addView(textView);
        return linearLayout;
    }

    static /* synthetic */ int n(MBAcquireRewardPopView mBAcquireRewardPopView) {
        int i11 = mBAcquireRewardPopView.f34743h;
        mBAcquireRewardPopView.f34743h = i11 - 1;
        return i11;
    }

    public void init(AcquireRewardPopViewParameters acquireRewardPopViewParameters) {
        View view;
        if (acquireRewardPopViewParameters == null) {
            o0.b("MBAcquireRewardPopView", "Must generate parameters.");
            return;
        }
        this.f34737b = acquireRewardPopViewParameters;
        if (acquireRewardPopViewParameters.viewType == 1) {
            view = a(a());
            if (this.f34737b.canClickMaskArea) {
                setOnClickListener(this.f34751p);
            }
        } else {
            view = null;
        }
        if (this.f34737b.viewType == 2) {
            view = getSlidePopView();
        }
        if (view != null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            setBackgroundColor(this.f34737b.containerBackgroundColor);
            addView(view);
            int i11 = this.f34737b.autoDismissTime;
            if (i11 > 0) {
                this.f34743h = i11;
                post(this.f34748m);
                this.f34744i = true;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f34748m);
    }

    public void onPause() {
        if (!this.f34744i || this.f34743h <= 0) {
            return;
        }
        removeCallbacks(this.f34748m);
    }

    public void onResume() {
        if (!this.f34744i || this.f34743h <= 0) {
            return;
        }
        post(this.f34748m);
    }

    public void onStop() {
        if (!this.f34744i || this.f34743h <= 0) {
            return;
        }
        removeCallbacks(this.f34748m);
    }

    public void onTimeLessThanReduce(int i11) {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f34737b;
        acquireRewardPopViewParameters.reduceTime = i11;
        TextView textView = this.f34746k;
        if (textView != null) {
            textView.setText(String.format(acquireRewardPopViewParameters.tips, Integer.valueOf(i11)));
        }
    }
}
