package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* loaded from: classes2.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: q, reason: collision with root package name */
    private static final String f17724q = "LottieAnimationView";

    /* renamed from: r, reason: collision with root package name */
    private static final m0 f17725r = new m0() { // from class: com.airbnb.lottie.f
        @Override // com.airbnb.lottie.m0
        public final void onResult(Object obj) {
            LottieAnimationView.n((Throwable) obj);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private final m0 f17726d;

    /* renamed from: e, reason: collision with root package name */
    private final m0 f17727e;

    /* renamed from: f, reason: collision with root package name */
    private m0 f17728f;

    /* renamed from: g, reason: collision with root package name */
    private int f17729g;

    /* renamed from: h, reason: collision with root package name */
    private final LottieDrawable f17730h;

    /* renamed from: i, reason: collision with root package name */
    private String f17731i;

    /* renamed from: j, reason: collision with root package name */
    private int f17732j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f17733k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f17734l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f17735m;

    /* renamed from: n, reason: collision with root package name */
    private final Set f17736n;

    /* renamed from: o, reason: collision with root package name */
    private final Set f17737o;

    /* renamed from: p, reason: collision with root package name */
    private LottieTask f17738p;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f17739a;

        /* renamed from: b, reason: collision with root package name */
        int f17740b;

        /* renamed from: c, reason: collision with root package name */
        float f17741c;

        /* renamed from: d, reason: collision with root package name */
        boolean f17742d;

        /* renamed from: e, reason: collision with root package name */
        String f17743e;

        /* renamed from: f, reason: collision with root package name */
        int f17744f;

        /* renamed from: g, reason: collision with root package name */
        int f17745g;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f17739a = parcel.readString();
            this.f17741c = parcel.readFloat();
            this.f17742d = parcel.readInt() == 1;
            this.f17743e = parcel.readString();
            this.f17744f = parcel.readInt();
            this.f17745g = parcel.readInt();
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.f17739a);
            parcel.writeFloat(this.f17741c);
            parcel.writeInt(this.f17742d ? 1 : 0);
            parcel.writeString(this.f17743e);
            parcel.writeInt(this.f17744f);
            parcel.writeInt(this.f17745g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum UserActionTaken {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends w4.c {
        a(w4.e eVar) {
        }

        @Override // w4.c
        public Object a(w4.b bVar) {
            throw null;
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements m0 {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f17747a;

        public b(LottieAnimationView lottieAnimationView) {
            this.f17747a = new WeakReference(lottieAnimationView);
        }

        @Override // com.airbnb.lottie.m0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f17747a.get();
            if (lottieAnimationView == null) {
                return;
            }
            if (lottieAnimationView.f17729g != 0) {
                lottieAnimationView.setImageResource(lottieAnimationView.f17729g);
            }
            (lottieAnimationView.f17728f == null ? LottieAnimationView.f17725r : lottieAnimationView.f17728f).onResult(th2);
        }
    }

    /* loaded from: classes2.dex */
    private static class c implements m0 {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f17748a;

        public c(LottieAnimationView lottieAnimationView) {
            this.f17748a = new WeakReference(lottieAnimationView);
        }

        @Override // com.airbnb.lottie.m0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(h hVar) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f17748a.get();
            if (lottieAnimationView == null) {
                return;
            }
            lottieAnimationView.setComposition(hVar);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f17726d = new c(this);
        this.f17727e = new b(this);
        this.f17729g = 0;
        this.f17730h = new LottieDrawable();
        this.f17733k = false;
        this.f17734l = false;
        this.f17735m = true;
        this.f17736n = new HashSet();
        this.f17737o = new HashSet();
        k(null, R$attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17726d = new c(this);
        this.f17727e = new b(this);
        this.f17729g = 0;
        this.f17730h = new LottieDrawable();
        this.f17733k = false;
        this.f17734l = false;
        this.f17735m = true;
        this.f17736n = new HashSet();
        this.f17737o = new HashSet();
        k(attributeSet, R$attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f17726d = new c(this);
        this.f17727e = new b(this);
        this.f17729g = 0;
        this.f17730h = new LottieDrawable();
        this.f17733k = false;
        this.f17734l = false;
        this.f17735m = true;
        this.f17736n = new HashSet();
        this.f17737o = new HashSet();
        k(attributeSet, i11);
    }

    private void g() {
        LottieTask lottieTask = this.f17738p;
        if (lottieTask != null) {
            lottieTask.k(this.f17726d);
            this.f17738p.j(this.f17727e);
        }
    }

    private void h() {
        this.f17730h.z();
    }

    private LottieTask i(final String str) {
        return isInEditMode() ? new LottieTask(new Callable() { // from class: com.airbnb.lottie.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                q0 l11;
                l11 = LottieAnimationView.this.l(str);
                return l11;
            }
        }, true) : this.f17735m ? r.l(getContext(), str) : r.m(getContext(), str, null);
    }

    private LottieTask j(final int i11) {
        return isInEditMode() ? new LottieTask(new Callable() { // from class: com.airbnb.lottie.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                q0 m11;
                m11 = LottieAnimationView.this.m(i11);
                return m11;
            }
        }, true) : this.f17735m ? r.u(getContext(), i11) : r.v(getContext(), i11, null);
    }

    private void k(AttributeSet attributeSet, int i11) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.LottieAnimationView, i11, 0);
        this.f17735m = obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_rawRes);
        boolean hasValue2 = obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_fileName);
        boolean hasValue3 = obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_url);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f17734l = true;
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_loop, false)) {
            this.f17730h.t1(-1);
        }
        if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(R$styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(R$styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(obtainStyledAttributes.getFloat(R$styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_clipToCompositionBounds)) {
            setClipToCompositionBounds(obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_clipToCompositionBounds, true));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_clipTextToBoundingBox)) {
            setClipTextToBoundingBox(obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_clipTextToBoundingBox, false));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_defaultFontFileExtension)) {
            setDefaultFontFileExtension(obtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_defaultFontFileExtension));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_imageAssetsFolder));
        p(obtainStyledAttributes.getFloat(R$styleable.LottieAnimationView_lottie_progress, 0.0f), obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_progress));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_colorFilter)) {
            addValueCallback(new p4.d("**"), (p4.d) p0.K, new w4.c(new s0(g.a.a(getContext(), obtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor())));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_renderMode)) {
            int i12 = R$styleable.LottieAnimationView_lottie_renderMode;
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int i13 = obtainStyledAttributes.getInt(i12, renderMode.ordinal());
            if (i13 >= RenderMode.values().length) {
                i13 = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[i13]);
        }
        if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_asyncUpdates)) {
            int i14 = R$styleable.LottieAnimationView_lottie_asyncUpdates;
            AsyncUpdates asyncUpdates = AsyncUpdates.AUTOMATIC;
            int i15 = obtainStyledAttributes.getInt(i14, asyncUpdates.ordinal());
            if (i15 >= RenderMode.values().length) {
                i15 = asyncUpdates.ordinal();
            }
            setAsyncUpdates(AsyncUpdates.values()[i15]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_useCompositionFrameRate)) {
            setUseCompositionFrameRate(obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_useCompositionFrameRate, false));
        }
        obtainStyledAttributes.recycle();
        this.f17730h.x1(Boolean.valueOf(v4.l.f(getContext()) != 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ q0 l(String str) {
        return this.f17735m ? r.n(getContext(), str) : r.o(getContext(), str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ q0 m(int i11) {
        return this.f17735m ? r.w(getContext(), i11) : r.x(getContext(), i11, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(Throwable th2) {
        if (!v4.l.k(th2)) {
            throw new IllegalStateException("Unable to parse composition", th2);
        }
        v4.f.d("Unable to load composition.", th2);
    }

    private void o() {
        boolean isAnimating = isAnimating();
        setImageDrawable(null);
        setImageDrawable(this.f17730h);
        if (isAnimating) {
            this.f17730h.P0();
        }
    }

    private void p(float f11, boolean z10) {
        if (z10) {
            this.f17736n.add(UserActionTaken.SET_PROGRESS);
        }
        this.f17730h.r1(f11);
    }

    private void setCompositionTask(LottieTask lottieTask) {
        q0 e11 = lottieTask.e();
        LottieDrawable lottieDrawable = this.f17730h;
        if (e11 != null && lottieDrawable == getDrawable() && lottieDrawable.O() == e11.b()) {
            return;
        }
        this.f17736n.add(UserActionTaken.SET_ANIMATION);
        h();
        g();
        this.f17738p = lottieTask.d(this.f17726d).c(this.f17727e);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f17730h.s(animatorListener);
    }

    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f17730h.t(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f17730h.u(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull o0 o0Var) {
        h composition = getComposition();
        if (composition != null) {
            o0Var.a(composition);
        }
        return this.f17737o.add(o0Var);
    }

    public <T> void addValueCallback(p4.d dVar, T t11, w4.c cVar) {
        this.f17730h.v(dVar, t11, cVar);
    }

    public <T> void addValueCallback(p4.d dVar, T t11, w4.e eVar) {
        this.f17730h.v(dVar, t11, new a(eVar));
    }

    public void cancelAnimation() {
        this.f17734l = false;
        this.f17736n.add(UserActionTaken.PLAY_OPTION);
        this.f17730h.y();
    }

    public <T> void clearValueCallback(p4.d dVar, T t11) {
        this.f17730h.v(dVar, t11, null);
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
        this.f17730h.D();
    }

    public void enableFeatureFlag(LottieFeatureFlag lottieFeatureFlag, boolean z10) {
        this.f17730h.F(lottieFeatureFlag, z10);
    }

    public void enableMergePathsForKitKatAndAbove(boolean z10) {
        this.f17730h.F(LottieFeatureFlag.MergePathsApi19, z10);
    }

    public AsyncUpdates getAsyncUpdates() {
        return this.f17730h.J();
    }

    public boolean getAsyncUpdatesEnabled() {
        return this.f17730h.K();
    }

    public boolean getClipTextToBoundingBox() {
        return this.f17730h.M();
    }

    public boolean getClipToCompositionBounds() {
        return this.f17730h.N();
    }

    @Nullable
    public h getComposition() {
        Drawable drawable = getDrawable();
        LottieDrawable lottieDrawable = this.f17730h;
        if (drawable == lottieDrawable) {
            return lottieDrawable.O();
        }
        return null;
    }

    public long getDuration() {
        if (getComposition() != null) {
            return r0.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f17730h.R();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f17730h.T();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f17730h.V();
    }

    public float getMaxFrame() {
        return this.f17730h.X();
    }

    public float getMinFrame() {
        return this.f17730h.Y();
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        return this.f17730h.Z();
    }

    public float getProgress() {
        return this.f17730h.a0();
    }

    public RenderMode getRenderMode() {
        return this.f17730h.b0();
    }

    public int getRepeatCount() {
        return this.f17730h.c0();
    }

    public int getRepeatMode() {
        return this.f17730h.d0();
    }

    public float getSpeed() {
        return this.f17730h.e0();
    }

    public boolean hasMasks() {
        return this.f17730h.h0();
    }

    public boolean hasMatte() {
        return this.f17730h.i0();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof LottieDrawable) && ((LottieDrawable) drawable).b0() == RenderMode.SOFTWARE) {
            this.f17730h.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.f17730h;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.f17730h.k0();
    }

    public boolean isFeatureFlagEnabled(LottieFeatureFlag lottieFeatureFlag) {
        return this.f17730h.n0(lottieFeatureFlag);
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.f17730h.n0(LottieFeatureFlag.MergePathsApi19);
    }

    @Deprecated
    public void loop(boolean z10) {
        this.f17730h.t1(z10 ? -1 : 0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.f17734l) {
            return;
        }
        this.f17730h.H0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i11;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f17731i = savedState.f17739a;
        Set set = this.f17736n;
        UserActionTaken userActionTaken = UserActionTaken.SET_ANIMATION;
        if (!set.contains(userActionTaken) && !TextUtils.isEmpty(this.f17731i)) {
            setAnimation(this.f17731i);
        }
        this.f17732j = savedState.f17740b;
        if (!this.f17736n.contains(userActionTaken) && (i11 = this.f17732j) != 0) {
            setAnimation(i11);
        }
        if (!this.f17736n.contains(UserActionTaken.SET_PROGRESS)) {
            p(savedState.f17741c, false);
        }
        if (!this.f17736n.contains(UserActionTaken.PLAY_OPTION) && savedState.f17742d) {
            playAnimation();
        }
        if (!this.f17736n.contains(UserActionTaken.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.f17743e);
        }
        if (!this.f17736n.contains(UserActionTaken.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f17744f);
        }
        if (this.f17736n.contains(UserActionTaken.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(savedState.f17745g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f17739a = this.f17731i;
        savedState.f17740b = this.f17732j;
        savedState.f17741c = this.f17730h.a0();
        savedState.f17742d = this.f17730h.l0();
        savedState.f17743e = this.f17730h.T();
        savedState.f17744f = this.f17730h.d0();
        savedState.f17745g = this.f17730h.c0();
        return savedState;
    }

    public void pauseAnimation() {
        this.f17734l = false;
        this.f17730h.G0();
    }

    public void playAnimation() {
        this.f17736n.add(UserActionTaken.PLAY_OPTION);
        this.f17730h.H0();
    }

    public void removeAllAnimatorListeners() {
        this.f17730h.I0();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.f17737o.clear();
    }

    public void removeAllUpdateListeners() {
        this.f17730h.J0();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f17730h.K0(animatorListener);
    }

    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f17730h.L0(animatorPauseListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull o0 o0Var) {
        return this.f17737o.remove(o0Var);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f17730h.M0(animatorUpdateListener);
    }

    public List<p4.d> resolveKeyPath(p4.d dVar) {
        return this.f17730h.O0(dVar);
    }

    public void resumeAnimation() {
        this.f17736n.add(UserActionTaken.PLAY_OPTION);
        this.f17730h.P0();
    }

    public void reverseAnimationSpeed() {
        this.f17730h.Q0();
    }

    public void setAnimation(int i11) {
        this.f17732j = i11;
        this.f17731i = null;
        setCompositionTask(j(i11));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        setCompositionTask(r.p(inputStream, str));
    }

    public void setAnimation(String str) {
        this.f17731i = str;
        this.f17732j = 0;
        setCompositionTask(i(str));
    }

    public void setAnimation(ZipInputStream zipInputStream, @Nullable String str) {
        setCompositionTask(r.B(zipInputStream, str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f17735m ? r.y(getContext(), str) : r.z(getContext(), str, null));
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        setCompositionTask(r.z(getContext(), str, str2));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z10) {
        this.f17730h.S0(z10);
    }

    public void setAsyncUpdates(AsyncUpdates asyncUpdates) {
        this.f17730h.T0(asyncUpdates);
    }

    public void setCacheComposition(boolean z10) {
        this.f17735m = z10;
    }

    public void setClipTextToBoundingBox(boolean z10) {
        this.f17730h.U0(z10);
    }

    public void setClipToCompositionBounds(boolean z10) {
        this.f17730h.V0(z10);
    }

    public void setComposition(@NonNull h hVar) {
        if (d.f17792a) {
            Log.v(f17724q, "Set Composition \n" + hVar);
        }
        this.f17730h.setCallback(this);
        this.f17733k = true;
        boolean W0 = this.f17730h.W0(hVar);
        if (this.f17734l) {
            this.f17730h.H0();
        }
        this.f17733k = false;
        if (getDrawable() != this.f17730h || W0) {
            if (!W0) {
                o();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator it = this.f17737o.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                throw null;
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.f17730h.X0(str);
    }

    public void setFailureListener(@Nullable m0 m0Var) {
        this.f17728f = m0Var;
    }

    public void setFallbackResource(int i11) {
        this.f17729g = i11;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.a aVar) {
        this.f17730h.Y0(aVar);
    }

    public void setFontMap(@Nullable Map<String, Typeface> map) {
        this.f17730h.Z0(map);
    }

    public void setFrame(int i11) {
        this.f17730h.a1(i11);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z10) {
        this.f17730h.b1(z10);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.b bVar) {
        this.f17730h.c1(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f17730h.d1(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f17732j = 0;
        this.f17731i = null;
        g();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f17732j = 0;
        this.f17731i = null;
        g();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i11) {
        this.f17732j = 0;
        this.f17731i = null;
        g();
        super.setImageResource(i11);
    }

    public void setMaintainOriginalImageBounds(boolean z10) {
        this.f17730h.e1(z10);
    }

    public void setMaxFrame(int i11) {
        this.f17730h.f1(i11);
    }

    public void setMaxFrame(String str) {
        this.f17730h.g1(str);
    }

    public void setMaxProgress(float f11) {
        this.f17730h.h1(f11);
    }

    public void setMinAndMaxFrame(int i11, int i12) {
        this.f17730h.i1(i11, i12);
    }

    public void setMinAndMaxFrame(String str) {
        this.f17730h.j1(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z10) {
        this.f17730h.k1(str, str2, z10);
    }

    public void setMinAndMaxProgress(float f11, float f12) {
        this.f17730h.l1(f11, f12);
    }

    public void setMinFrame(int i11) {
        this.f17730h.m1(i11);
    }

    public void setMinFrame(String str) {
        this.f17730h.n1(str);
    }

    public void setMinProgress(float f11) {
        this.f17730h.o1(f11);
    }

    public void setOutlineMasksAndMattes(boolean z10) {
        this.f17730h.p1(z10);
    }

    public void setPerformanceTrackingEnabled(boolean z10) {
        this.f17730h.q1(z10);
    }

    public void setProgress(float f11) {
        p(f11, true);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f17730h.s1(renderMode);
    }

    public void setRepeatCount(int i11) {
        this.f17736n.add(UserActionTaken.SET_REPEAT_COUNT);
        this.f17730h.t1(i11);
    }

    public void setRepeatMode(int i11) {
        this.f17736n.add(UserActionTaken.SET_REPEAT_MODE);
        this.f17730h.u1(i11);
    }

    public void setSafeMode(boolean z10) {
        this.f17730h.v1(z10);
    }

    public void setSpeed(float f11) {
        this.f17730h.w1(f11);
    }

    public void setTextDelegate(t0 t0Var) {
        this.f17730h.y1(t0Var);
    }

    public void setUseCompositionFrameRate(boolean z10) {
        this.f17730h.z1(z10);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable;
        if (!this.f17733k && drawable == (lottieDrawable = this.f17730h) && lottieDrawable.k0()) {
            pauseAnimation();
        } else if (!this.f17733k && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable2 = (LottieDrawable) drawable;
            if (lottieDrawable2.k0()) {
                lottieDrawable2.G0();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        return this.f17730h.B1(str, bitmap);
    }
}
