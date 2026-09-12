package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m6.d;

/* loaded from: classes.dex */
public abstract class BaseQuickAdapter extends RecyclerView.Adapter {
    public static final a A = new a(null);
    public static final int B = 268435729;
    public static final int C = 268436002;
    public static final int D = 268436275;
    public static final int E = 268436821;

    /* renamed from: a, reason: collision with root package name */
    private final int f21224a;

    /* renamed from: b, reason: collision with root package name */
    private List<Object> f21225b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f21226c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f21227d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f21228e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f21229f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f21230g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f21231h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f21232i;

    /* renamed from: j, reason: collision with root package name */
    private k6.b f21233j;

    /* renamed from: k, reason: collision with root package name */
    private m6.c f21234k;

    /* renamed from: l, reason: collision with root package name */
    private LinearLayout f21235l;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f21236m;

    /* renamed from: n, reason: collision with root package name */
    private FrameLayout f21237n;

    /* renamed from: o, reason: collision with root package name */
    private int f21238o;

    /* renamed from: p, reason: collision with root package name */
    private p6.a f21239p;

    /* renamed from: q, reason: collision with root package name */
    private p6.d f21240q;

    /* renamed from: r, reason: collision with root package name */
    private p6.e f21241r;

    /* renamed from: s, reason: collision with root package name */
    private p6.b f21242s;

    /* renamed from: t, reason: collision with root package name */
    private p6.c f21243t;

    /* renamed from: u, reason: collision with root package name */
    private r6.g f21244u;

    /* renamed from: v, reason: collision with root package name */
    private r6.a f21245v;

    /* renamed from: w, reason: collision with root package name */
    private r6.f f21246w;

    /* renamed from: x, reason: collision with root package name */
    private RecyclerView f21247x;

    /* renamed from: y, reason: collision with root package name */
    private final LinkedHashSet<Integer> f21248y;

    /* renamed from: z, reason: collision with root package name */
    private final LinkedHashSet<Integer> f21249z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/chad/library/adapter/base/BaseQuickAdapter$AnimationType;", "", "(Ljava/lang/String;I)V", "AlphaIn", "ScaleIn", "SlideInBottom", "SlideInLeft", "SlideInRight", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public enum AnimationType {
        AlphaIn,
        ScaleIn,
        SlideInBottom,
        SlideInLeft,
        SlideInRight
    }

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21250a;

        static {
            int[] iArr = new int[AnimationType.values().length];
            try {
                iArr[AnimationType.AlphaIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnimationType.ScaleIn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnimationType.SlideInBottom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnimationType.SlideInLeft.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnimationType.SlideInRight.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f21250a = iArr;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends GridLayoutManager.c {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecyclerView.m f21252f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager.c f21253g;

        c(RecyclerView.m mVar, GridLayoutManager.c cVar) {
            this.f21252f = mVar;
            this.f21253g = cVar;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            int itemViewType = BaseQuickAdapter.this.getItemViewType(i11);
            if (itemViewType == 268435729 && BaseQuickAdapter.this.b0()) {
                return 1;
            }
            if (itemViewType == 268436275 && BaseQuickAdapter.this.W()) {
                return 1;
            }
            BaseQuickAdapter.j(BaseQuickAdapter.this);
            return BaseQuickAdapter.this.u0(itemViewType) ? ((GridLayoutManager) this.f21252f).U() : this.f21253g.f(i11);
        }
    }

    public BaseQuickAdapter(int i11, List list) {
        this.f21224a = i11;
        this.f21225b = list == null ? new ArrayList() : list;
        this.f21228e = true;
        this.f21232i = true;
        this.f21238o = -1;
        D();
        this.f21248y = new LinkedHashSet<>();
        this.f21249z = new LinkedHashSet<>();
    }

    public /* synthetic */ BaseQuickAdapter(int i11, List list, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? null : list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(BaseViewHolder viewHolder, BaseQuickAdapter this$0, View v11) {
        Intrinsics.h(viewHolder, "$viewHolder");
        Intrinsics.h(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int a02 = bindingAdapterPosition - this$0.a0();
        Intrinsics.g(v11, "v");
        this$0.r1(v11, a02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(BaseViewHolder viewHolder, BaseQuickAdapter this$0, View v11) {
        Intrinsics.h(viewHolder, "$viewHolder");
        Intrinsics.h(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int a02 = bindingAdapterPosition - this$0.a0();
        Intrinsics.g(v11, "v");
        this$0.v1(v11, a02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(BaseViewHolder viewHolder, BaseQuickAdapter this$0, View v11) {
        Intrinsics.h(viewHolder, "$viewHolder");
        Intrinsics.h(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int a02 = bindingAdapterPosition - this$0.a0();
        Intrinsics.g(v11, "v");
        return this$0.x1(v11, a02);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D() {
        if (this instanceof r6.i) {
            this.f21246w = ((r6.i) this).b(this);
        }
        if (this instanceof r6.l) {
            this.f21244u = ((r6.l) this).f(this);
        }
    }

    private final BaseViewHolder H(Class cls, View view) {
        try {
            if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
                Constructor declaredConstructor = cls.getDeclaredConstructor(View.class);
                Intrinsics.g(declaredConstructor, "z.getDeclaredConstructor(View::class.java)");
                declaredConstructor.setAccessible(true);
                Object newInstance = declaredConstructor.newInstance(view);
                Intrinsics.f(newInstance, "null cannot be cast to non-null type VH of com.chad.library.adapter.base.BaseQuickAdapter");
                return (BaseViewHolder) newInstance;
            }
            Constructor declaredConstructor2 = cls.getDeclaredConstructor(getClass(), View.class);
            Intrinsics.g(declaredConstructor2, "z.getDeclaredConstructor…aClass, View::class.java)");
            declaredConstructor2.setAccessible(true);
            Object newInstance2 = declaredConstructor2.newInstance(this, view);
            Intrinsics.f(newInstance2, "null cannot be cast to non-null type VH of com.chad.library.adapter.base.BaseQuickAdapter");
            return (BaseViewHolder) newInstance2;
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            return null;
        } catch (InstantiationException e12) {
            e12.printStackTrace();
            return null;
        } catch (NoSuchMethodException e13) {
            e13.printStackTrace();
            return null;
        } catch (InvocationTargetException e14) {
            e14.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ void W0(BaseQuickAdapter baseQuickAdapter, List list, Runnable runnable, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDiffNewData");
        }
        if ((i11 & 2) != 0) {
            runnable = null;
        }
        baseQuickAdapter.V0(list, runnable);
    }

    public static /* synthetic */ int c1(BaseQuickAdapter baseQuickAdapter, View view, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFooterView");
        }
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = 1;
        }
        return baseQuickAdapter.b1(view, i11, i12);
    }

    private final Class e0(Class cls) {
        try {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                return null;
            }
            Type[] types = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            Intrinsics.g(types, "types");
            for (Type type : types) {
                if (type instanceof Class) {
                    if (BaseViewHolder.class.isAssignableFrom((Class) type)) {
                        return (Class) type;
                    }
                } else if (type instanceof ParameterizedType) {
                    Type rawType = ((ParameterizedType) type).getRawType();
                    if ((rawType instanceof Class) && BaseViewHolder.class.isAssignableFrom((Class) rawType)) {
                        return (Class) rawType;
                    }
                } else {
                    continue;
                }
            }
            return null;
        } catch (TypeNotPresentException e11) {
            e11.printStackTrace();
            return null;
        } catch (GenericSignatureFormatError e12) {
            e12.printStackTrace();
            return null;
        } catch (MalformedParameterizedTypeException e13) {
            e13.printStackTrace();
            return null;
        }
    }

    public static final /* synthetic */ p6.a j(BaseQuickAdapter baseQuickAdapter) {
        baseQuickAdapter.getClass();
        return null;
    }

    private final void k(RecyclerView.b0 b0Var) {
        if (this.f21231h) {
            if (!this.f21232i || b0Var.getLayoutPosition() > this.f21238o) {
                k6.b bVar = this.f21233j;
                if (bVar == null) {
                    bVar = new k6.a(0.0f, 1, null);
                }
                View view = b0Var.itemView;
                Intrinsics.g(view, "holder.itemView");
                for (Animator animator : bVar.a(view)) {
                    A1(animator, b0Var.getLayoutPosition());
                }
                this.f21238o = b0Var.getLayoutPosition();
            }
        }
    }

    public static /* synthetic */ int k1(BaseQuickAdapter baseQuickAdapter, View view, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderView");
        }
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = 1;
        }
        return baseQuickAdapter.j1(view, i11, i12);
    }

    public static /* synthetic */ int u(BaseQuickAdapter baseQuickAdapter, View view, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFooterView");
        }
        if ((i13 & 2) != 0) {
            i11 = -1;
        }
        if ((i13 & 4) != 0) {
            i12 = 1;
        }
        return baseQuickAdapter.t(view, i11, i12);
    }

    public static /* synthetic */ int y(BaseQuickAdapter baseQuickAdapter, View view, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addHeaderView");
        }
        if ((i13 & 2) != 0) {
            i11 = -1;
        }
        if ((i13 & 4) != 0) {
            i12 = 1;
        }
        return baseQuickAdapter.x(view, i11, i12);
    }

    protected void A0(BaseViewHolder viewHolder, int i11) {
        Intrinsics.h(viewHolder, "viewHolder");
    }

    protected void A1(Animator anim, int i11) {
        Intrinsics.h(anim, "anim");
        anim.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: B0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (u0(holder.getItemViewType())) {
            f1(holder);
        } else {
            k(holder);
        }
    }

    @Deprecated
    public void C0(int i11) {
        G0(i11);
    }

    public void D0(Object obj) {
        int indexOf = this.f21225b.indexOf(obj);
        if (indexOf == -1) {
            return;
        }
        G0(indexOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E(int i11) {
        if (this.f21225b.size() == i11) {
            notifyDataSetChanged();
        }
    }

    public final void E0() {
        if (r0()) {
            LinearLayout linearLayout = this.f21236m;
            if (linearLayout == null) {
                Intrinsics.z("mFooterLayout");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            int X = X();
            if (X != -1) {
                notifyItemRemoved(X);
            }
        }
    }

    protected abstract void F(BaseViewHolder baseViewHolder, Object obj);

    public final void F0() {
        if (s0()) {
            LinearLayout linearLayout = this.f21235l;
            if (linearLayout == null) {
                Intrinsics.z("mHeaderLayout");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            int c02 = c0();
            if (c02 != -1) {
                notifyItemRemoved(c02);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(BaseViewHolder holder, Object obj, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(payloads, "payloads");
    }

    public void G0(int i11) {
        if (i11 >= this.f21225b.size()) {
            return;
        }
        this.f21225b.remove(i11);
        int a02 = i11 + a0();
        notifyItemRemoved(a02);
        E(0);
        notifyItemRangeChanged(a02, this.f21225b.size() - a02);
    }

    public final void H0() {
        FrameLayout frameLayout = this.f21237n;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.z("mEmptyLayout");
                frameLayout = null;
            }
            frameLayout.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseViewHolder I(View view) {
        Intrinsics.h(view, "view");
        Class cls = null;
        for (Class<?> cls2 = getClass(); cls == null && cls2 != null; cls2 = cls2.getSuperclass()) {
            cls = e0(cls2);
        }
        BaseViewHolder baseViewHolder = cls == null ? new BaseViewHolder(view) : H(cls, view);
        return baseViewHolder == null ? new BaseViewHolder(view) : baseViewHolder;
    }

    public final void I0(View footer) {
        int X;
        Intrinsics.h(footer, "footer");
        if (r0()) {
            LinearLayout linearLayout = this.f21236m;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.z("mFooterLayout");
                linearLayout = null;
            }
            linearLayout.removeView(footer);
            LinearLayout linearLayout3 = this.f21236m;
            if (linearLayout3 == null) {
                Intrinsics.z("mFooterLayout");
            } else {
                linearLayout2 = linearLayout3;
            }
            if (linearLayout2.getChildCount() != 0 || (X = X()) == -1) {
                return;
            }
            notifyItemRemoved(X);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseViewHolder J(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        return I(s6.a.a(parent, i11));
    }

    public final void J0(View header) {
        int c02;
        Intrinsics.h(header, "header");
        if (s0()) {
            LinearLayout linearLayout = this.f21235l;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.z("mHeaderLayout");
                linearLayout = null;
            }
            linearLayout.removeView(header);
            LinearLayout linearLayout3 = this.f21235l;
            if (linearLayout3 == null) {
                Intrinsics.z("mHeaderLayout");
            } else {
                linearLayout2 = linearLayout3;
            }
            if (linearLayout2.getChildCount() != 0 || (c02 = c0()) == -1) {
                return;
            }
            notifyItemRemoved(c02);
        }
    }

    public final k6.b K() {
        return this.f21233j;
    }

    @Deprecated
    public void K0(Collection<Object> newData) {
        Intrinsics.h(newData, "newData");
        n1(newData);
    }

    public final boolean L() {
        return this.f21231h;
    }

    public final void L0(k6.b bVar) {
        this.f21231h = true;
        this.f21233j = bVar;
    }

    public final LinkedHashSet<Integer> M() {
        return this.f21248y;
    }

    public final void M0(boolean z10) {
        this.f21231h = z10;
    }

    public final LinkedHashSet<Integer> N() {
        return this.f21249z;
    }

    public final void N0(boolean z10) {
        this.f21232i = z10;
    }

    protected int O() {
        return this.f21225b.size();
    }

    public final void O0(AnimationType animationType) {
        k6.b aVar;
        Intrinsics.h(animationType, "animationType");
        int i11 = b.f21250a[animationType.ordinal()];
        if (i11 == 1) {
            aVar = new k6.a(0.0f, 1, null);
        } else if (i11 == 2) {
            aVar = new k6.c(0.0f, 1, null);
        } else if (i11 == 3) {
            aVar = new k6.d();
        } else if (i11 == 4) {
            aVar = new k6.e();
        } else {
            if (i11 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            aVar = new k6.f();
        }
        L0(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int P(int i11) {
        return super.getItemViewType(i11);
    }

    public void P0(int i11, Object obj) {
        if (i11 >= this.f21225b.size()) {
            return;
        }
        this.f21225b.set(i11, obj);
        notifyItemChanged(i11 + a0());
    }

    @Deprecated
    public final m6.c Q() {
        return R();
    }

    public final void Q0(List<Object> list) {
        Intrinsics.h(list, "<set-?>");
        this.f21225b = list;
    }

    public final m6.c R() {
        m6.c cVar = this.f21234k;
        if (cVar == null) {
            throw new IllegalStateException("Please use setDiffCallback() or setDiffConfig() first!");
        }
        Intrinsics.e(cVar);
        return cVar;
    }

    public final void R0(DiffUtil.e diffCallback) {
        Intrinsics.h(diffCallback, "diffCallback");
        S0(new d.a(diffCallback).a());
    }

    public final r6.a S() {
        throw new IllegalStateException("Please first implements DraggableModule");
    }

    public final void S0(m6.d config) {
        Intrinsics.h(config, "config");
        this.f21234k = new m6.c(this, config);
    }

    public final FrameLayout T() {
        FrameLayout frameLayout = this.f21237n;
        if (frameLayout != null) {
            if (frameLayout != null) {
                return frameLayout;
            }
            Intrinsics.z("mEmptyLayout");
        }
        return null;
    }

    public void T0(@NonNull DiffUtil.d diffResult, List<Object> list) {
        Intrinsics.h(diffResult, "diffResult");
        Intrinsics.h(list, "list");
        if (q0()) {
            q1(list);
        } else {
            diffResult.b(new m6.e(this));
            this.f21225b = list;
        }
    }

    public final LinearLayout U() {
        LinearLayout linearLayout = this.f21236m;
        if (linearLayout != null) {
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.z("mFooterLayout");
        }
        return null;
    }

    @JvmOverloads
    public final void U0(List<Object> list) {
        W0(this, list, null, 2, null);
    }

    public final int V() {
        return r0() ? 1 : 0;
    }

    @JvmOverloads
    public void V0(List<Object> list, Runnable runnable) {
        if (q0()) {
            q1(list);
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        m6.c cVar = this.f21234k;
        if (cVar != null) {
            cVar.f(list, runnable);
        }
    }

    public final boolean W() {
        return this.f21230g;
    }

    public final int X() {
        if (!q0()) {
            return a0() + this.f21225b.size();
        }
        int i11 = (this.f21226c && s0()) ? 2 : 1;
        if (this.f21227d) {
            return i11;
        }
        return -1;
    }

    public final void X0(int i11) {
        RecyclerView recyclerView = this.f21247x;
        if (recyclerView != null) {
            View view = LayoutInflater.from(recyclerView.getContext()).inflate(i11, (ViewGroup) recyclerView, false);
            Intrinsics.g(view, "view");
            Y0(view);
        }
    }

    public final boolean Y() {
        return this.f21227d;
    }

    public final void Y0(View emptyView) {
        boolean z10;
        Intrinsics.h(emptyView, "emptyView");
        int itemCount = getItemCount();
        FrameLayout frameLayout = null;
        if (this.f21237n == null) {
            FrameLayout frameLayout2 = new FrameLayout(emptyView.getContext());
            this.f21237n = frameLayout2;
            ViewGroup.LayoutParams layoutParams = emptyView.getLayoutParams();
            frameLayout2.setLayoutParams(layoutParams != null ? new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height) : new ViewGroup.LayoutParams(-1, -1));
            z10 = true;
        } else {
            ViewGroup.LayoutParams layoutParams2 = emptyView.getLayoutParams();
            if (layoutParams2 != null) {
                FrameLayout frameLayout3 = this.f21237n;
                if (frameLayout3 == null) {
                    Intrinsics.z("mEmptyLayout");
                    frameLayout3 = null;
                }
                ViewGroup.LayoutParams layoutParams3 = frameLayout3.getLayoutParams();
                layoutParams3.width = layoutParams2.width;
                layoutParams3.height = layoutParams2.height;
                FrameLayout frameLayout4 = this.f21237n;
                if (frameLayout4 == null) {
                    Intrinsics.z("mEmptyLayout");
                    frameLayout4 = null;
                }
                frameLayout4.setLayoutParams(layoutParams3);
            }
            z10 = false;
        }
        FrameLayout frameLayout5 = this.f21237n;
        if (frameLayout5 == null) {
            Intrinsics.z("mEmptyLayout");
            frameLayout5 = null;
        }
        frameLayout5.removeAllViews();
        FrameLayout frameLayout6 = this.f21237n;
        if (frameLayout6 == null) {
            Intrinsics.z("mEmptyLayout");
        } else {
            frameLayout = frameLayout6;
        }
        frameLayout.addView(emptyView);
        this.f21228e = true;
        if (z10 && q0()) {
            int i11 = (this.f21226c && s0()) ? 1 : 0;
            if (getItemCount() > itemCount) {
                notifyItemInserted(i11);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public final LinearLayout Z() {
        LinearLayout linearLayout = this.f21235l;
        if (linearLayout != null) {
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.z("mHeaderLayout");
        }
        return null;
    }

    @JvmOverloads
    public final int Z0(View view) {
        Intrinsics.h(view, "view");
        return c1(this, view, 0, 0, 6, null);
    }

    public final int a0() {
        return s0() ? 1 : 0;
    }

    @JvmOverloads
    public final int a1(View view, int i11) {
        Intrinsics.h(view, "view");
        return c1(this, view, i11, 0, 4, null);
    }

    public final boolean b0() {
        return this.f21229f;
    }

    @JvmOverloads
    public final int b1(View view, int i11, int i12) {
        Intrinsics.h(view, "view");
        LinearLayout linearLayout = this.f21236m;
        if (linearLayout != null) {
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.z("mFooterLayout");
                linearLayout = null;
            }
            if (linearLayout.getChildCount() > i11) {
                LinearLayout linearLayout3 = this.f21236m;
                if (linearLayout3 == null) {
                    Intrinsics.z("mFooterLayout");
                    linearLayout3 = null;
                }
                linearLayout3.removeViewAt(i11);
                LinearLayout linearLayout4 = this.f21236m;
                if (linearLayout4 == null) {
                    Intrinsics.z("mFooterLayout");
                } else {
                    linearLayout2 = linearLayout4;
                }
                linearLayout2.addView(view, i11);
                return i11;
            }
        }
        return t(view, i11, i12);
    }

    public final int c0() {
        return (!q0() || this.f21226c) ? 0 : -1;
    }

    public final boolean d0() {
        return this.f21226c;
    }

    public final void d1(boolean z10) {
        this.f21230g = z10;
    }

    public final void e1(boolean z10) {
        this.f21227d = z10;
    }

    public Object f0(int i11) {
        return CollectionsKt.l0(this.f21225b, i11);
    }

    protected void f1(RecyclerView.b0 holder) {
        Intrinsics.h(holder, "holder");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.b) {
            ((StaggeredGridLayoutManager.b) layoutParams).c(true);
        }
    }

    public int g0(Object obj) {
        if (obj == null || this.f21225b.isEmpty()) {
            return -1;
        }
        return this.f21225b.indexOf(obj);
    }

    public final void g1(p6.a aVar) {
    }

    public final Context getContext() {
        Context context = getRecyclerView().getContext();
        Intrinsics.g(context, "recyclerView.context");
        return context;
    }

    public final List<Object> getData() {
        return this.f21225b;
    }

    public Object getItem(int i11) {
        return this.f21225b.get(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!q0()) {
            r6.f fVar = this.f21246w;
            return a0() + O() + V() + ((fVar == null || !fVar.m()) ? 0 : 1);
        }
        if (this.f21226c && s0()) {
            r1 = 2;
        }
        return (this.f21227d && r0()) ? r1 + 1 : r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i11) {
        return i11;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        if (q0()) {
            boolean z10 = this.f21226c && s0();
            if (i11 != 0) {
                return i11 != 1 ? D : D;
            }
            if (z10) {
                return B;
            }
            return E;
        }
        boolean s02 = s0();
        if (s02 && i11 == 0) {
            return B;
        }
        if (s02) {
            i11--;
        }
        int size = this.f21225b.size();
        return i11 < size ? P(i11) : i11 - size < r0() ? D : C;
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.f21247x;
        if (recyclerView == null) {
            throw new IllegalStateException("Please get it after onAttachedToRecyclerView()");
        }
        Intrinsics.e(recyclerView);
        return recyclerView;
    }

    public final r6.f h0() {
        r6.f fVar = this.f21246w;
        if (fVar == null) {
            throw new IllegalStateException("Please first implements LoadMoreModule");
        }
        Intrinsics.e(fVar);
        return fVar;
    }

    @JvmOverloads
    public final int h1(View view) {
        Intrinsics.h(view, "view");
        return k1(this, view, 0, 0, 6, null);
    }

    public final r6.f i0() {
        return this.f21246w;
    }

    @JvmOverloads
    public final int i1(View view, int i11) {
        Intrinsics.h(view, "view");
        return k1(this, view, i11, 0, 4, null);
    }

    public final p6.b j0() {
        return this.f21242s;
    }

    @JvmOverloads
    public final int j1(View view, int i11, int i12) {
        Intrinsics.h(view, "view");
        LinearLayout linearLayout = this.f21235l;
        if (linearLayout != null) {
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.z("mHeaderLayout");
                linearLayout = null;
            }
            if (linearLayout.getChildCount() > i11) {
                LinearLayout linearLayout3 = this.f21235l;
                if (linearLayout3 == null) {
                    Intrinsics.z("mHeaderLayout");
                    linearLayout3 = null;
                }
                linearLayout3.removeViewAt(i11);
                LinearLayout linearLayout4 = this.f21235l;
                if (linearLayout4 == null) {
                    Intrinsics.z("mHeaderLayout");
                } else {
                    linearLayout2 = linearLayout4;
                }
                linearLayout2.addView(view, i11);
                return i11;
            }
        }
        return x(view, i11, i12);
    }

    public final p6.c k0() {
        return null;
    }

    public final void l(int... viewIds) {
        Intrinsics.h(viewIds, "viewIds");
        for (int i11 : viewIds) {
            this.f21248y.add(Integer.valueOf(i11));
        }
    }

    public final p6.d l0() {
        return this.f21240q;
    }

    public final void l1(boolean z10) {
        this.f21229f = z10;
    }

    public final void m(int... viewIds) {
        Intrinsics.h(viewIds, "viewIds");
        for (int i11 : viewIds) {
            this.f21249z.add(Integer.valueOf(i11));
        }
    }

    public final p6.e m0() {
        return this.f21241r;
    }

    public final void m1(boolean z10) {
        this.f21226c = z10;
    }

    public void n(int i11, Object obj) {
        this.f21225b.add(i11, obj);
        notifyItemInserted(i11 + a0());
        E(1);
    }

    public final RecyclerView n0() {
        return this.f21247x;
    }

    public void n1(Collection<Object> collection) {
        List<Object> list = this.f21225b;
        if (collection != list) {
            list.clear();
            if (collection != null && !collection.isEmpty()) {
                this.f21225b.addAll(collection);
            }
        } else if (collection == null || collection.isEmpty()) {
            this.f21225b.clear();
        } else {
            ArrayList arrayList = new ArrayList(collection);
            this.f21225b.clear();
            this.f21225b.addAll(arrayList);
        }
        r6.f fVar = this.f21246w;
        if (fVar != null) {
            fVar.x();
        }
        this.f21238o = -1;
        notifyDataSetChanged();
        r6.f fVar2 = this.f21246w;
        if (fVar2 != null) {
            fVar2.f();
        }
    }

    public void o(int i11, Collection<Object> newData) {
        Intrinsics.h(newData, "newData");
        this.f21225b.addAll(i11, newData);
        notifyItemRangeInserted(i11 + a0(), newData.size());
        E(newData.size());
    }

    public final r6.g o0() {
        r6.g gVar = this.f21244u;
        if (gVar == null) {
            throw new IllegalStateException("Please first implements UpFetchModule");
        }
        Intrinsics.e(gVar);
        return gVar;
    }

    public final void o1(r6.f fVar) {
        this.f21246w = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.f21247x = recyclerView;
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.d0(new c(layoutManager, gridLayoutManager.Y()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.f21247x = null;
    }

    public void p(@NonNull Object obj) {
        this.f21225b.add(obj);
        notifyItemInserted(this.f21225b.size() + a0());
        E(1);
    }

    public final View p0(int i11, int i12) {
        BaseViewHolder baseViewHolder;
        RecyclerView recyclerView = this.f21247x;
        if (recyclerView == null || (baseViewHolder = (BaseViewHolder) recyclerView.findViewHolderForLayoutPosition(i11)) == null) {
            return null;
        }
        return baseViewHolder.getViewOrNull(i12);
    }

    @Deprecated
    public void p1(List<Object> list) {
        q1(list);
    }

    public void q(@NonNull Collection<Object> newData) {
        Intrinsics.h(newData, "newData");
        this.f21225b.addAll(newData);
        notifyItemRangeInserted((this.f21225b.size() - newData.size()) + a0(), newData.size());
        E(newData.size());
    }

    public final boolean q0() {
        FrameLayout frameLayout = this.f21237n;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.z("mEmptyLayout");
                frameLayout = null;
            }
            if (frameLayout.getChildCount() != 0 && this.f21228e) {
                return this.f21225b.isEmpty();
            }
            return false;
        }
        return false;
    }

    public void q1(List<Object> list) {
        if (list == this.f21225b) {
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f21225b = list;
        r6.f fVar = this.f21246w;
        if (fVar != null) {
            fVar.x();
        }
        this.f21238o = -1;
        notifyDataSetChanged();
        r6.f fVar2 = this.f21246w;
        if (fVar2 != null) {
            fVar2.f();
        }
    }

    @JvmOverloads
    public final int r(View view) {
        Intrinsics.h(view, "view");
        return u(this, view, 0, 0, 6, null);
    }

    public final boolean r0() {
        LinearLayout linearLayout = this.f21236m;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.z("mFooterLayout");
            linearLayout = null;
        }
        return linearLayout.getChildCount() > 0;
    }

    protected void r1(View v11, int i11) {
        Intrinsics.h(v11, "v");
        p6.b bVar = this.f21242s;
        if (bVar != null) {
            bVar.a(this, v11, i11);
        }
    }

    @JvmOverloads
    public final int s(View view, int i11) {
        Intrinsics.h(view, "view");
        return u(this, view, i11, 0, 4, null);
    }

    public final boolean s0() {
        LinearLayout linearLayout = this.f21235l;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.z("mHeaderLayout");
            linearLayout = null;
        }
        return linearLayout.getChildCount() > 0;
    }

    public final void s1(p6.b bVar) {
        this.f21242s = bVar;
    }

    @JvmOverloads
    public final int t(View view, int i11, int i12) {
        int X;
        Intrinsics.h(view, "view");
        LinearLayout linearLayout = null;
        if (this.f21236m == null) {
            LinearLayout linearLayout2 = new LinearLayout(view.getContext());
            this.f21236m = linearLayout2;
            linearLayout2.setOrientation(i12);
            LinearLayout linearLayout3 = this.f21236m;
            if (linearLayout3 == null) {
                Intrinsics.z("mFooterLayout");
                linearLayout3 = null;
            }
            linearLayout3.setLayoutParams(i12 == 1 ? new RecyclerView.n(-1, -2) : new RecyclerView.n(-2, -1));
        }
        LinearLayout linearLayout4 = this.f21236m;
        if (linearLayout4 == null) {
            Intrinsics.z("mFooterLayout");
            linearLayout4 = null;
        }
        int childCount = linearLayout4.getChildCount();
        if (i11 < 0 || i11 > childCount) {
            i11 = childCount;
        }
        LinearLayout linearLayout5 = this.f21236m;
        if (linearLayout5 == null) {
            Intrinsics.z("mFooterLayout");
            linearLayout5 = null;
        }
        linearLayout5.addView(view, i11);
        LinearLayout linearLayout6 = this.f21236m;
        if (linearLayout6 == null) {
            Intrinsics.z("mFooterLayout");
        } else {
            linearLayout = linearLayout6;
        }
        if (linearLayout.getChildCount() == 1 && (X = X()) != -1) {
            notifyItemInserted(X);
        }
        return i11;
    }

    public final boolean t0() {
        return this.f21232i;
    }

    protected boolean t1(View v11, int i11) {
        Intrinsics.h(v11, "v");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u0(int i11) {
        return i11 == 268436821 || i11 == 268435729 || i11 == 268436275 || i11 == 268436002;
    }

    public final void u1(p6.c cVar) {
    }

    @JvmOverloads
    public final int v(View view) {
        Intrinsics.h(view, "view");
        return y(this, view, 0, 0, 6, null);
    }

    public final boolean v0() {
        return this.f21228e;
    }

    protected void v1(View v11, int i11) {
        Intrinsics.h(v11, "v");
        p6.d dVar = this.f21240q;
        if (dVar != null) {
            dVar.a(this, v11, i11);
        }
    }

    @JvmOverloads
    public final int w(View view, int i11) {
        Intrinsics.h(view, "view");
        return y(this, view, i11, 0, 4, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder holder, int i11) {
        Intrinsics.h(holder, "holder");
        r6.g gVar = this.f21244u;
        if (gVar != null) {
            gVar.a(i11);
        }
        r6.f fVar = this.f21246w;
        if (fVar != null) {
            fVar.e(i11);
        }
        switch (holder.getItemViewType()) {
            case B /* 268435729 */:
            case D /* 268436275 */:
            case E /* 268436821 */:
                return;
            case C /* 268436002 */:
                r6.f fVar2 = this.f21246w;
                if (fVar2 != null) {
                    fVar2.j().convert(holder, i11, fVar2.i());
                    return;
                }
                return;
            default:
                F(holder, getItem(i11 - a0()));
                return;
        }
    }

    public final void w1(p6.d dVar) {
        this.f21240q = dVar;
    }

    @JvmOverloads
    public final int x(View view, int i11, int i12) {
        int c02;
        Intrinsics.h(view, "view");
        LinearLayout linearLayout = null;
        if (this.f21235l == null) {
            LinearLayout linearLayout2 = new LinearLayout(view.getContext());
            this.f21235l = linearLayout2;
            linearLayout2.setOrientation(i12);
            LinearLayout linearLayout3 = this.f21235l;
            if (linearLayout3 == null) {
                Intrinsics.z("mHeaderLayout");
                linearLayout3 = null;
            }
            linearLayout3.setLayoutParams(i12 == 1 ? new RecyclerView.n(-1, -2) : new RecyclerView.n(-2, -1));
        }
        LinearLayout linearLayout4 = this.f21235l;
        if (linearLayout4 == null) {
            Intrinsics.z("mHeaderLayout");
            linearLayout4 = null;
        }
        int childCount = linearLayout4.getChildCount();
        if (i11 < 0 || i11 > childCount) {
            i11 = childCount;
        }
        LinearLayout linearLayout5 = this.f21235l;
        if (linearLayout5 == null) {
            Intrinsics.z("mHeaderLayout");
            linearLayout5 = null;
        }
        linearLayout5.addView(view, i11);
        LinearLayout linearLayout6 = this.f21235l;
        if (linearLayout6 == null) {
            Intrinsics.z("mHeaderLayout");
        } else {
            linearLayout = linearLayout6;
        }
        if (linearLayout.getChildCount() == 1 && (c02 = c0()) != -1) {
            notifyItemInserted(c02);
        }
        return i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder holder, int i11, List<Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, i11);
            return;
        }
        r6.g gVar = this.f21244u;
        if (gVar != null) {
            gVar.a(i11);
        }
        r6.f fVar = this.f21246w;
        if (fVar != null) {
            fVar.e(i11);
        }
        switch (holder.getItemViewType()) {
            case B /* 268435729 */:
            case D /* 268436275 */:
            case E /* 268436821 */:
                return;
            case C /* 268436002 */:
                r6.f fVar2 = this.f21246w;
                if (fVar2 != null) {
                    fVar2.j().convert(holder, i11, fVar2.i());
                    return;
                }
                return;
            default:
                G(holder, getItem(i11 - a0()), payloads);
                return;
        }
    }

    protected boolean x1(View v11, int i11) {
        Intrinsics.h(v11, "v");
        p6.e eVar = this.f21241r;
        if (eVar != null) {
            return eVar.a(this, v11, i11);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseViewHolder y0(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        return J(parent, this.f21224a);
    }

    public final void y1(p6.e eVar) {
        this.f21241r = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(final BaseViewHolder viewHolder, int i11) {
        Intrinsics.h(viewHolder, "viewHolder");
        if (this.f21240q != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseQuickAdapter.B(BaseViewHolder.this, this, view);
                }
            });
        }
        if (this.f21241r != null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.m
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean C2;
                    C2 = BaseQuickAdapter.C(BaseViewHolder.this, this, view);
                    return C2;
                }
            });
        }
        if (this.f21242s != null) {
            Iterator<Integer> it = M().iterator();
            while (it.hasNext()) {
                Integer id2 = it.next();
                View view = viewHolder.itemView;
                Intrinsics.g(id2, "id");
                View findViewById = view.findViewById(id2.intValue());
                if (findViewById != null) {
                    Intrinsics.g(findViewById, "findViewById<View>(id)");
                    if (!findViewById.isClickable()) {
                        findViewById.setClickable(true);
                    }
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            BaseQuickAdapter.A(BaseViewHolder.this, this, view2);
                        }
                    });
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View view = null;
        switch (i11) {
            case B /* 268435729 */:
                LinearLayout linearLayout = this.f21235l;
                if (linearLayout == null) {
                    Intrinsics.z("mHeaderLayout");
                    linearLayout = null;
                }
                ViewParent parent2 = linearLayout.getParent();
                if (parent2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent2;
                    LinearLayout linearLayout2 = this.f21235l;
                    if (linearLayout2 == null) {
                        Intrinsics.z("mHeaderLayout");
                        linearLayout2 = null;
                    }
                    viewGroup.removeView(linearLayout2);
                }
                LinearLayout linearLayout3 = this.f21235l;
                if (linearLayout3 == null) {
                    Intrinsics.z("mHeaderLayout");
                } else {
                    view = linearLayout3;
                }
                return I(view);
            case C /* 268436002 */:
                r6.f fVar = this.f21246w;
                Intrinsics.e(fVar);
                BaseViewHolder I = I(fVar.j().getRootView(parent));
                r6.f fVar2 = this.f21246w;
                Intrinsics.e(fVar2);
                fVar2.F(I);
                return I;
            case D /* 268436275 */:
                LinearLayout linearLayout4 = this.f21236m;
                if (linearLayout4 == null) {
                    Intrinsics.z("mFooterLayout");
                    linearLayout4 = null;
                }
                ViewParent parent3 = linearLayout4.getParent();
                if (parent3 instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) parent3;
                    LinearLayout linearLayout5 = this.f21236m;
                    if (linearLayout5 == null) {
                        Intrinsics.z("mFooterLayout");
                        linearLayout5 = null;
                    }
                    viewGroup2.removeView(linearLayout5);
                }
                LinearLayout linearLayout6 = this.f21236m;
                if (linearLayout6 == null) {
                    Intrinsics.z("mFooterLayout");
                } else {
                    view = linearLayout6;
                }
                return I(view);
            case E /* 268436821 */:
                FrameLayout frameLayout = this.f21237n;
                if (frameLayout == null) {
                    Intrinsics.z("mEmptyLayout");
                    frameLayout = null;
                }
                ViewParent parent4 = frameLayout.getParent();
                if (parent4 instanceof ViewGroup) {
                    ViewGroup viewGroup3 = (ViewGroup) parent4;
                    FrameLayout frameLayout2 = this.f21237n;
                    if (frameLayout2 == null) {
                        Intrinsics.z("mEmptyLayout");
                        frameLayout2 = null;
                    }
                    viewGroup3.removeView(frameLayout2);
                }
                FrameLayout frameLayout3 = this.f21237n;
                if (frameLayout3 == null) {
                    Intrinsics.z("mEmptyLayout");
                } else {
                    view = frameLayout3;
                }
                return I(view);
            default:
                BaseViewHolder y02 = y0(parent, i11);
                z(y02, i11);
                A0(y02, i11);
                return y02;
        }
    }

    public final void z1(boolean z10) {
        this.f21228e = z10;
    }
}
